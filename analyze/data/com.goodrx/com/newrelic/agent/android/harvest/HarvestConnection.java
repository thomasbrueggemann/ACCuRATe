package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.HarvestResponse;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HarvestConnection implements HarvestErrorCodes {
   private static final String APPLICATION_TOKEN_HEADER = "X-App-License-Key";
   private static final String COLLECTOR_CONNECT_URI = "/mobile/v3/connect";
   private static final String COLLECTOR_DATA_URI = "/mobile/v3/data";
   private static final String CONNECT_TIME_HEADER = "X-NewRelic-Connect-Time";
   private static final Boolean DISABLE_COMPRESSION_FOR_DEBUGGING = Boolean.valueOf(false);
   private String applicationToken;
   private final HttpClient collectorClient;
   private String collectorHost;
   private ConnectInformation connectInformation;
   private final AgentLog log = AgentLogManager.getAgentLog();
   private long serverTimestamp;
   private boolean useSsl;

   public HarvestConnection() {
      int var1 = (int)TimeUnit.MILLISECONDS.convert(20L, TimeUnit.SECONDS);
      BasicHttpParams var2 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var2, var1);
      HttpConnectionParams.setSoTimeout(var2, var1);
      HttpConnectionParams.setTcpNoDelay(var2, true);
      HttpConnectionParams.setSocketBufferSize(var2, 8192);
      this.collectorClient = new DefaultHttpClient(var2);
   }

   private byte[] deflate(String var1) {
      Deflater var2 = new Deflater();
      var2.setInput(var1.getBytes());
      var2.finish();
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();

      int var5;
      for(byte[] var4 = new byte[8192]; !var2.finished(); var3.write(var4, 0, var5)) {
         var5 = var2.deflate(var4);
         if(var5 <= 0) {
            this.log.error("HTTP request contains an incomplete payload");
         }
      }

      var2.end();
      return var3.toByteArray();
   }

   private String getCollectorConnectUri() {
      return this.getCollectorUri("/mobile/v3/connect");
   }

   private String getCollectorDataUri() {
      return this.getCollectorUri("/mobile/v3/data");
   }

   private String getCollectorUri(String var1) {
      String var2;
      if(this.useSsl) {
         var2 = "https://";
      } else {
         var2 = "http://";
      }

      return var2 + this.collectorHost + var1;
   }

   public static String readResponse(HttpResponse param0) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void recordCollectorError(Exception var1) {
      this.log.error("HarvestConnection: Attempting to convert network exception " + var1.getClass().getName() + " to error code.");
      StatsEngine.get().inc("Supportability/AgentHealth/Collector/ResponseErrorCodes/" + ExceptionHelper.exceptionToErrorCode(var1));
   }

   public HttpPost createConnectPost(String var1) {
      return this.createPost(this.getCollectorConnectUri(), var1);
   }

   public HttpPost createDataPost(String var1) {
      return this.createPost(this.getCollectorDataUri(), var1);
   }

   public HttpPost createPost(String var1, String var2) {
      String var3;
      if(var2.length() > 512 && !DISABLE_COMPRESSION_FOR_DEBUGGING.booleanValue()) {
         var3 = "deflate";
      } else {
         var3 = "identity";
      }

      HttpPost var4 = new HttpPost(var1);
      var4.addHeader("Content-Type", "application/json");
      var4.addHeader("Content-Encoding", var3);
      var4.addHeader("User-Agent", System.getProperty("http.agent"));
      if(this.applicationToken == null) {
         this.log.error("Cannot create POST without an Application Token.");
         return null;
      } else {
         var4.addHeader("X-App-License-Key", this.applicationToken);
         if(this.serverTimestamp != 0L) {
            var4.addHeader("X-NewRelic-Connect-Time", Long.valueOf(this.serverTimestamp).toString());
         }

         if("deflate".equals(var3)) {
            var4.setEntity(new ByteArrayEntity(this.deflate(var2)));
            return var4;
         } else {
            try {
               var4.setEntity(new StringEntity(var2, "utf-8"));
               return var4;
            } catch (UnsupportedEncodingException var6) {
               this.log.error("UTF-8 is unsupported");
               throw new IllegalArgumentException(var6);
            }
         }
      }
   }

   public ConnectInformation getConnectInformation() {
      return this.connectInformation;
   }

   public HarvestResponse send(HttpPost var1) {
      HarvestResponse var2 = new HarvestResponse();

      HttpResponse var5;
      try {
         TicToc var3 = new TicToc();
         var3.tic();
         var5 = this.collectorClient.execute(var1);
         var2.setResponseTime(var3.toc());
      } catch (Exception var8) {
         this.log.error("Failed to send POST to collector: " + var8.getMessage());
         this.recordCollectorError(var8);
         return null;
      }

      var2.setStatusCode(var5.getStatusLine().getStatusCode());

      try {
         var2.setResponseBody(readResponse(var5));
         return var2;
      } catch (IOException var7) {
         var7.printStackTrace();
         this.log.error("Failed to retrieve collector response: " + var7.getMessage());
         return var2;
      }
   }

   public HarvestResponse sendConnect() {
      if(this.connectInformation == null) {
         throw new IllegalArgumentException();
      } else {
         HttpPost var1 = this.createConnectPost(this.connectInformation.toJsonString());
         if(var1 == null) {
            this.log.error("Failed to create connect POST");
            return null;
         } else {
            TicToc var2 = new TicToc();
            var2.tic();
            HarvestResponse var3 = this.send(var1);
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Connect", var2.toc());
            return var3;
         }
      }
   }

   public HarvestResponse sendData(Harvestable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException();
      } else {
         HttpPost var2 = this.createDataPost(var1.toJsonString());
         if(var2 == null) {
            this.log.error("Failed to create data POST");
            return null;
         } else {
            return this.send(var2);
         }
      }
   }

   public void setApplicationToken(String var1) {
      this.applicationToken = var1;
   }

   public void setCollectorHost(String var1) {
      this.collectorHost = var1;
   }

   public void setConnectInformation(ConnectInformation var1) {
      this.connectInformation = var1;
   }

   public void setServerTimestamp(long var1) {
      this.log.debug("Setting server timestamp: " + var1);
      this.serverTimestamp = var1;
   }

   public void useSsl(boolean var1) {
      this.useSsl = var1;
   }
}

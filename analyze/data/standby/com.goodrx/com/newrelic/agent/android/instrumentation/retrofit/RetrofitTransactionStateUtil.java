package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

public class RetrofitTransactionStateUtil extends TransactionStateUtil {
   private static final String CONTENT_TYPE_HEADER = "Content-Type";
   private static final String NO_BODY_TEXT = "Response BODY not found.";
   private static final AgentLog log = AgentLogManager.getAgentLog();

   private static void addTransactionAndErrorData(TransactionState var0, Response var1) {
      TransactionData var2 = var0.end();
      if(var2 != null) {
         TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         if((long)var0.getStatusCode() >= 400L) {
            String var3 = getAppDataHeader(var1.getHeaders(), "Content-Type");
            TreeMap var4 = new TreeMap();
            if(var3 != null && var3.length() > 0 && !"".equals(var3)) {
               var4.put("content_type", (Object)null);
            }

            var4.put("content_length", var0.getBytesReceived() + "");
            Measurements.addHttpError(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var1.getReason(), var4);
            return;
         }
      }

   }

   private static String getAppDataHeader(List<Header> var0, String var1) {
      if(var0 != null) {
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Header var3 = (Header)var2.next();
            if(var3.getName() != null && var3.getName().equalsIgnoreCase(var1)) {
               return var3.getValue();
            }
         }
      }

      return null;
   }

   public static void inspectAndInstrument(TransactionState var0, Request var1) {
      var0.setUrl(var1.getUrl());
      var0.setHttpMethod(var1.getMethod());
      var0.setCarrier(Agent.getActiveNetworkCarrier());
      var0.setWanType(Agent.getActiveNetworkWanType());
   }

   public static void inspectAndInstrumentResponse(TransactionState var0, Response var1) {
      String var2 = getAppDataHeader(var1.getHeaders(), "X-NewRelic-App-Data");
      if(var2 != null && !"".equals(var2)) {
         var0.setAppData(var2);
      }

      var0.setStatusCode(var1.getStatus());
      long var3 = var1.getBody().length();
      if(var3 >= 0L) {
         var0.setBytesReceived(var3);
      }

      addTransactionAndErrorData(var0, var1);
   }
}

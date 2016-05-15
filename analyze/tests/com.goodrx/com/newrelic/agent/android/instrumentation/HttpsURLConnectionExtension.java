package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class HttpsURLConnectionExtension extends HttpsURLConnection {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private HttpsURLConnection impl;
   private TransactionState transactionState;

   public HttpsURLConnectionExtension(HttpsURLConnection var1) {
      super(var1.getURL());
      this.impl = var1;
      TransactionStateUtil.setCrossProcessHeader(var1);
   }

   private void addTransactionAndErrorData(TransactionState var1) {
      TransactionData var2 = var1.end();
      if(var2 != null) {
         TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         if((long)var1.getStatusCode() >= 400L) {
            StringBuilder var3 = new StringBuilder();

            try {
               InputStream var9 = this.getErrorStream();
               if(var9 instanceof CountingInputStream) {
                  var3.append(((CountingInputStream)var9).getBufferAsString());
               }
            } catch (Exception var10) {
               log.error(var10.toString());
            }

            TreeMap var5 = new TreeMap();
            String var6 = this.impl.getContentType();
            if(var6 != null && !"".equals(var6)) {
               var5.put("content_type", var6);
            }

            var5.put("content_length", var1.getBytesReceived() + "");
            Measurements.addHttpError(var2, var3.toString(), var5);
            return;
         }
      }

   }

   private void checkResponse() {
      if(!this.getTransactionState().isComplete()) {
         TransactionStateUtil.inspectAndInstrumentResponse(this.getTransactionState(), this.impl);
      }

   }

   private void error(Exception var1) {
      TransactionState var2 = this.getTransactionState();
      TransactionStateUtil.setErrorCodeFromException(var2, var1);
      if(!var2.isComplete()) {
         TransactionStateUtil.inspectAndInstrumentResponse(var2, this.impl);
         TransactionData var3 = var2.end();
         if(var3 != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(var3.getUrl(), var3.getHttpMethod(), var3.getStatusCode(), var3.getErrorCode(), var3.getTimestamp(), (double)var3.getTime(), var3.getBytesSent(), var3.getBytesReceived(), var3.getAppData()));
         }
      }

   }

   private TransactionState getTransactionState() {
      if(this.transactionState == null) {
         this.transactionState = new TransactionState();
         TransactionStateUtil.inspectAndInstrument(this.transactionState, (HttpURLConnection)this.impl);
      }

      return this.transactionState;
   }

   public void addRequestProperty(String var1, String var2) {
      this.impl.addRequestProperty(var1, var2);
   }

   public void connect() throws IOException {
      this.getTransactionState();

      try {
         this.impl.connect();
      } catch (IOException var3) {
         this.error(var3);
         throw var3;
      }
   }

   public void disconnect() {
      if(this.transactionState != null && !this.transactionState.isComplete()) {
         this.addTransactionAndErrorData(this.transactionState);
      }

      this.impl.disconnect();
   }

   public boolean getAllowUserInteraction() {
      return this.impl.getAllowUserInteraction();
   }

   public String getCipherSuite() {
      return this.impl.getCipherSuite();
   }

   public int getConnectTimeout() {
      return this.impl.getConnectTimeout();
   }

   public Object getContent() throws IOException {
      this.getTransactionState();

      Object var3;
      try {
         var3 = this.impl.getContent();
      } catch (IOException var6) {
         this.error(var6);
         throw var6;
      }

      int var4 = this.impl.getContentLength();
      if(var4 >= 0) {
         TransactionState var5 = this.getTransactionState();
         if(!var5.isComplete()) {
            var5.setBytesReceived((long)var4);
            this.addTransactionAndErrorData(var5);
         }
      }

      return var3;
   }

   public Object getContent(Class[] var1) throws IOException {
      this.getTransactionState();

      Object var4;
      try {
         var4 = this.impl.getContent(var1);
      } catch (IOException var5) {
         this.error(var5);
         throw var5;
      }

      this.checkResponse();
      return var4;
   }

   public String getContentEncoding() {
      this.getTransactionState();
      String var2 = this.impl.getContentEncoding();
      this.checkResponse();
      return var2;
   }

   public int getContentLength() {
      this.getTransactionState();
      int var2 = this.impl.getContentLength();
      this.checkResponse();
      return var2;
   }

   public String getContentType() {
      this.getTransactionState();
      String var2 = this.impl.getContentType();
      this.checkResponse();
      return var2;
   }

   public long getDate() {
      this.getTransactionState();
      long var2 = this.impl.getDate();
      this.checkResponse();
      return var2;
   }

   public boolean getDefaultUseCaches() {
      return this.impl.getDefaultUseCaches();
   }

   public boolean getDoInput() {
      return this.impl.getDoInput();
   }

   public boolean getDoOutput() {
      return this.impl.getDoOutput();
   }

   public InputStream getErrorStream() {
      this.getTransactionState();

      try {
         CountingInputStream var2 = new CountingInputStream(this.impl.getErrorStream(), true);
         return var2;
      } catch (Exception var4) {
         log.error(var4.toString());
         return this.impl.getErrorStream();
      }
   }

   public long getExpiration() {
      this.getTransactionState();
      long var2 = this.impl.getExpiration();
      this.checkResponse();
      return var2;
   }

   public String getHeaderField(int var1) {
      this.getTransactionState();
      String var3 = this.impl.getHeaderField(var1);
      this.checkResponse();
      return var3;
   }

   public String getHeaderField(String var1) {
      this.getTransactionState();
      String var3 = this.impl.getHeaderField(var1);
      this.checkResponse();
      return var3;
   }

   public long getHeaderFieldDate(String var1, long var2) {
      this.getTransactionState();
      long var5 = this.impl.getHeaderFieldDate(var1, var2);
      this.checkResponse();
      return var5;
   }

   public int getHeaderFieldInt(String var1, int var2) {
      this.getTransactionState();
      int var4 = this.impl.getHeaderFieldInt(var1, var2);
      this.checkResponse();
      return var4;
   }

   public String getHeaderFieldKey(int var1) {
      this.getTransactionState();
      String var3 = this.impl.getHeaderFieldKey(var1);
      this.checkResponse();
      return var3;
   }

   public Map<String, List<String>> getHeaderFields() {
      this.getTransactionState();
      Map var2 = this.impl.getHeaderFields();
      this.checkResponse();
      return var2;
   }

   public HostnameVerifier getHostnameVerifier() {
      return this.impl.getHostnameVerifier();
   }

   public long getIfModifiedSince() {
      this.getTransactionState();
      long var2 = this.impl.getIfModifiedSince();
      this.checkResponse();
      return var2;
   }

   public InputStream getInputStream() throws IOException {
      final TransactionState var1 = this.getTransactionState();

      CountingInputStream var2;
      try {
         var2 = new CountingInputStream(this.impl.getInputStream());
         TransactionStateUtil.inspectAndInstrumentResponse(var1, this.impl);
      } catch (IOException var4) {
         this.error(var4);
         throw var4;
      }

      var2.addStreamCompleteListener(new StreamCompleteListener() {
         public void streamComplete(StreamCompleteEvent var1x) {
            if(!var1.isComplete()) {
               long var2 = (long)HttpsURLConnectionExtension.this.impl.getContentLength();
               long var4 = var1x.getBytes();
               if(var2 >= 0L) {
                  var4 = var2;
               }

               var1.setBytesReceived(var4);
               HttpsURLConnectionExtension.this.addTransactionAndErrorData(var1);
            }

         }

         public void streamError(StreamCompleteEvent var1x) {
            if(!var1.isComplete()) {
               var1.setBytesReceived(var1x.getBytes());
            }

            HttpsURLConnectionExtension.this.error(var1x.getException());
         }
      });
      return var2;
   }

   public boolean getInstanceFollowRedirects() {
      return this.impl.getInstanceFollowRedirects();
   }

   public long getLastModified() {
      this.getTransactionState();
      long var2 = this.impl.getLastModified();
      this.checkResponse();
      return var2;
   }

   public Certificate[] getLocalCertificates() {
      return this.impl.getLocalCertificates();
   }

   public Principal getLocalPrincipal() {
      return this.impl.getLocalPrincipal();
   }

   public OutputStream getOutputStream() throws IOException {
      final TransactionState var1 = this.getTransactionState();

      CountingOutputStream var2;
      try {
         var2 = new CountingOutputStream(this.impl.getOutputStream());
      } catch (IOException var4) {
         this.error(var4);
         throw var4;
      }

      var2.addStreamCompleteListener(new StreamCompleteListener() {
         public void streamComplete(StreamCompleteEvent var1x) {
            if(!var1.isComplete()) {
               String var2 = HttpsURLConnectionExtension.this.impl.getRequestProperty("content-length");
               long var3 = var1x.getBytes();
               if(var2 != null) {
                  label22: {
                     long var6;
                     try {
                        var6 = Long.parseLong(var2);
                     } catch (NumberFormatException var8) {
                        break label22;
                     }

                     var3 = var6;
                  }
               }

               var1.setBytesSent(var3);
               HttpsURLConnectionExtension.this.addTransactionAndErrorData(var1);
            }

         }

         public void streamError(StreamCompleteEvent var1x) {
            if(!var1.isComplete()) {
               var1.setBytesSent(var1x.getBytes());
            }

            HttpsURLConnectionExtension.this.error(var1x.getException());
         }
      });
      return var2;
   }

   public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
      return this.impl.getPeerPrincipal();
   }

   public Permission getPermission() throws IOException {
      return this.impl.getPermission();
   }

   public int getReadTimeout() {
      return this.impl.getReadTimeout();
   }

   public String getRequestMethod() {
      return this.impl.getRequestMethod();
   }

   public Map<String, List<String>> getRequestProperties() {
      return this.impl.getRequestProperties();
   }

   public String getRequestProperty(String var1) {
      return this.impl.getRequestProperty(var1);
   }

   public int getResponseCode() throws IOException {
      this.getTransactionState();

      int var3;
      try {
         var3 = this.impl.getResponseCode();
      } catch (IOException var4) {
         this.error(var4);
         throw var4;
      }

      this.checkResponse();
      return var3;
   }

   public String getResponseMessage() throws IOException {
      this.getTransactionState();

      String var3;
      try {
         var3 = this.impl.getResponseMessage();
      } catch (IOException var4) {
         this.error(var4);
         throw var4;
      }

      this.checkResponse();
      return var3;
   }

   public SSLSocketFactory getSSLSocketFactory() {
      return this.impl.getSSLSocketFactory();
   }

   public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
      try {
         Certificate[] var2 = this.impl.getServerCertificates();
         return var2;
      } catch (SSLPeerUnverifiedException var3) {
         this.error(var3);
         throw var3;
      }
   }

   public URL getURL() {
      return this.impl.getURL();
   }

   public boolean getUseCaches() {
      return this.impl.getUseCaches();
   }

   public void setAllowUserInteraction(boolean var1) {
      this.impl.setAllowUserInteraction(var1);
   }

   public void setChunkedStreamingMode(int var1) {
      this.impl.setChunkedStreamingMode(var1);
   }

   public void setConnectTimeout(int var1) {
      this.impl.setConnectTimeout(var1);
   }

   public void setDefaultUseCaches(boolean var1) {
      this.impl.setDefaultUseCaches(var1);
   }

   public void setDoInput(boolean var1) {
      this.impl.setDoInput(var1);
   }

   public void setDoOutput(boolean var1) {
      this.impl.setDoOutput(var1);
   }

   public void setFixedLengthStreamingMode(int var1) {
      this.impl.setFixedLengthStreamingMode(var1);
   }

   public void setHostnameVerifier(HostnameVerifier var1) {
      this.impl.setHostnameVerifier(var1);
   }

   public void setIfModifiedSince(long var1) {
      this.impl.setIfModifiedSince(var1);
   }

   public void setInstanceFollowRedirects(boolean var1) {
      this.impl.setInstanceFollowRedirects(var1);
   }

   public void setReadTimeout(int var1) {
      this.impl.setReadTimeout(var1);
   }

   public void setRequestMethod(String var1) throws ProtocolException {
      try {
         this.impl.setRequestMethod(var1);
      } catch (ProtocolException var3) {
         this.error(var3);
         throw var3;
      }
   }

   public void setRequestProperty(String var1, String var2) {
      this.impl.setRequestProperty(var1, var2);
   }

   public void setSSLSocketFactory(SSLSocketFactory var1) {
      this.impl.setSSLSocketFactory(var1);
   }

   public void setUseCaches(boolean var1) {
      this.impl.setUseCaches(var1);
   }

   public String toString() {
      return this.impl.toString();
   }

   public boolean usingProxy() {
      return this.impl.usingProxy();
   }
}

package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.parse.ParseHttpClient;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

class ParseURLConnectionHttpClient extends ParseHttpClient<HttpURLConnection, HttpURLConnection> {
   private static final String ACCEPT_ENCODING_HEADER = "Accept-encoding";
   private static final String CONTENT_LENGTH_HEADER = "Content-Length";
   private static final String CONTENT_TYPE_HEADER = "Content-Type";
   private static final String GZIP_ENCODING = "gzip";
   private int socketOperationTimeout;

   public ParseURLConnectionHttpClient(int var1, SSLSessionCache var2) {
      this.socketOperationTimeout = var1;
      HttpsURLConnection.setDefaultSSLSocketFactory(SSLCertificateSocketFactory.getDefault(var1, var2));
   }

   ParseHttpResponse executeInternal(ParseHttpRequest var1) throws IOException {
      HttpURLConnection var2 = this.getRequest(var1);
      ParseHttpBody var3 = var1.getBody();
      if(var3 != null) {
         OutputStream var4 = var2.getOutputStream();
         var3.writeTo(var4);
         var4.flush();
         var4.close();
      }

      return this.getResponse(var2);
   }

   HttpURLConnection getRequest(ParseHttpRequest var1) throws IOException {
      HttpURLConnection var2 = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(var1.getUrl())).openConnection());
      var2.setRequestMethod(var1.getMethod().toString());
      var2.setConnectTimeout(this.socketOperationTimeout);
      var2.setReadTimeout(this.socketOperationTimeout);
      var2.setDoInput(true);
      var2.setInstanceFollowRedirects(false);
      Iterator var3 = var1.getAllHeaders().entrySet().iterator();

      while(var3.hasNext()) {
         Entry var5 = (Entry)var3.next();
         var2.setRequestProperty((String)var5.getKey(), (String)var5.getValue());
      }

      if(this.disableHttpLibraryAutoDecompress()) {
         var2.setRequestProperty("Accept-encoding", "gzip");
      }

      ParseHttpBody var4 = var1.getBody();
      if(var4 != null) {
         var2.setRequestProperty("Content-Length", String.valueOf(var4.getContentLength()));
         var2.setRequestProperty("Content-Type", var4.getContentType());
         var2.setFixedLengthStreamingMode(var4.getContentLength());
         var2.setDoOutput(true);
      }

      return var2;
   }

   ParseHttpResponse getResponse(HttpURLConnection var1) throws IOException {
      int var2 = var1.getResponseCode();
      InputStream var3;
      if(var2 < 400) {
         var3 = var1.getInputStream();
      } else {
         var3 = var1.getErrorStream();
      }

      int var4 = var1.getContentLength();
      String var5 = var1.getResponseMessage();
      HashMap var6 = new HashMap();
      Iterator var7 = var1.getHeaderFields().entrySet().iterator();

      while(var7.hasNext()) {
         Entry var9 = (Entry)var7.next();
         if(var9.getKey() != null && ((List)var9.getValue()).size() > 0) {
            Object var10 = var9.getKey();
            String var11;
            if(var9.getValue() == null) {
               var11 = "";
            } else {
               var11 = (String)((List)var9.getValue()).get(0);
            }

            var6.put(var10, var11);
         }
      }

      String var8 = var1.getContentType();
      return (new ParseHttpResponse.Builder()).setStatusCode(var2).setContent(var3).setTotalSize((long)var4).setReasonPhrase(var5).setHeaders(var6).setContentType(var8).build();
   }
}

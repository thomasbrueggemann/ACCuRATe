package com.parse;

import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import com.parse.PLog;
import com.parse.ParseApacheHttpClient;
import com.parse.ParseOkHttpClient;
import com.parse.ParseURLConnectionHttpClient;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class ParseHttpClient<LibraryRequest, LibraryResponse> {
   private static final String APACHE_HTTPCLIENT_NAME = "org.apache.http";
   private static final String KEEP_ALIVE_PROPERTY_NAME = "http.keepAlive";
   private static final String MAX_CONNECTIONS_PROPERTY_NAME = "http.maxConnections";
   private static final String OKHTTPCLIENT_PATH = "com.squareup.okhttp.OkHttpClient";
   private static final String OKHTTP_NAME = "com.squareup.okhttp";
   private static final String TAG = "com.parse.ParseHttpClient";
   private static final String URLCONNECTION_NAME = "net.java.URLConnection";
   private List<ParseNetworkInterceptor> externalInterceptors;
   private boolean hasExecuted;
   private List<ParseNetworkInterceptor> internalInterceptors;

   public static ParseHttpClient createClient(int var0, SSLSessionCache var1) {
      String var2;
      Object var3;
      if(hasOkHttpOnClasspath()) {
         var2 = "com.squareup.okhttp";
         var3 = new ParseOkHttpClient(var0, var1);
      } else if(VERSION.SDK_INT >= 19) {
         var2 = "net.java.URLConnection";
         var3 = new ParseURLConnectionHttpClient(var0, var1);
      } else {
         var2 = "org.apache.http";
         var3 = new ParseApacheHttpClient(var0, var1);
      }

      PLog.method_363("com.parse.ParseHttpClient", "Using " + var2 + " library for networking communication.");
      return (ParseHttpClient)var3;
   }

   private static boolean hasOkHttpOnClasspath() {
      try {
         Class.forName("com.squareup.okhttp.OkHttpClient");
         return true;
      } catch (ClassNotFoundException var1) {
         return false;
      }
   }

   public static void setKeepAlive(boolean var0) {
      System.setProperty("http.keepAlive", String.valueOf(var0));
   }

   public static void setMaxConnections(int var0) {
      if(var0 <= 0) {
         throw new IllegalArgumentException("Max connections should be large than 0");
      } else {
         System.setProperty("http.maxConnections", String.valueOf(var0));
      }
   }

   void addExternalInterceptor(ParseNetworkInterceptor var1) {
      if(this.externalInterceptors == null) {
         this.externalInterceptors = new ArrayList();
      }

      this.externalInterceptors.add(var1);
   }

   void addInternalInterceptor(ParseNetworkInterceptor var1) {
      if(this.hasExecuted) {
         throw new IllegalStateException("`ParseHttpClient#addInternalInterceptor(ParseNetworkInterceptor)` can only be invoked before `ParseHttpClient` execute any request");
      } else {
         if(this.internalInterceptors == null) {
            this.internalInterceptors = new ArrayList();
         }

         this.internalInterceptors.add(var1);
      }
   }

   boolean disableHttpLibraryAutoDecompress() {
      return this.externalInterceptors != null && this.externalInterceptors.size() > 0;
   }

   public final ParseHttpResponse execute(ParseHttpRequest var1) throws IOException {
      if(!this.hasExecuted) {
         this.hasExecuted = true;
      }

      return (new ParseHttpClient.ParseNetworkInterceptorChain(0, 0, var1)).proceed(var1);
   }

   abstract ParseHttpResponse executeInternal(ParseHttpRequest var1) throws IOException;

   abstract LibraryRequest getRequest(ParseHttpRequest var1) throws IOException;

   abstract ParseHttpResponse getResponse(LibraryResponse var1) throws IOException;

   private class ParseNetworkInterceptorChain implements ParseNetworkInterceptor.Chain {
      private final int externalIndex;
      private final int internalIndex;
      private final ParseHttpRequest request;

      ParseNetworkInterceptorChain(int var2, int var3, ParseHttpRequest var4) {
         this.internalIndex = var2;
         this.externalIndex = var3;
         this.request = var4;
      }

      public ParseHttpRequest getRequest() {
         return this.request;
      }

      public ParseHttpResponse proceed(ParseHttpRequest var1) throws IOException {
         if(ParseHttpClient.this.internalInterceptors != null && this.internalIndex < ParseHttpClient.this.internalInterceptors.size()) {
            ParseHttpClient.ParseNetworkInterceptorChain var3 = ParseHttpClient.this.new ParseNetworkInterceptorChain(1 + this.internalIndex, this.externalIndex, var1);
            return ((ParseNetworkInterceptor)ParseHttpClient.this.internalInterceptors.get(this.internalIndex)).intercept(var3);
         } else if(ParseHttpClient.this.externalInterceptors != null && this.externalIndex < ParseHttpClient.this.externalInterceptors.size()) {
            ParseHttpClient.ParseNetworkInterceptorChain var2 = ParseHttpClient.this.new ParseNetworkInterceptorChain(this.internalIndex, 1 + this.externalIndex, var1);
            return ((ParseNetworkInterceptor)ParseHttpClient.this.externalInterceptors.get(this.externalIndex)).intercept(var2);
         } else {
            return ParseHttpClient.this.executeInternal(var1);
         }
      }
   }
}

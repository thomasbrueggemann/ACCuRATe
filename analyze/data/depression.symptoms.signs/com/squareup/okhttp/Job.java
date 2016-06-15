package com.squareup.okhttp;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.Failure;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.Policy;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;

final class Job implements Runnable, Policy {
   private final OkHttpClient client;
   private final Dispatcher dispatcher;
   private Request request;
   private final Response.Receiver responseReceiver;

   public Job(Dispatcher var1, OkHttpClient var2, Request var3, Response.Receiver var4) {
      this.dispatcher = var1;
      this.client = var2;
      this.request = var3;
      this.responseReceiver = var4;
   }

   private Response execute() throws IOException {
      Connection var1 = null;
      Response var2 = null;

      while(true) {
         HttpEngine var3 = this.newEngine(var1);
         Request.Body var4 = this.request.body();
         if(var4 != null) {
            MediaType var9 = var4.contentType();
            if(var9 == null) {
               throw new IllegalStateException("contentType == null");
            }

            if(var3.getRequestHeaders().getContentType() == null) {
               var3.getRequestHeaders().setContentType(var9.toString());
            }
         }

         var3.sendRequest();
         if(var4 != null) {
            var4.writeTo(var3.getRequestBody());
         }

         var3.readResponse();
         int var5 = var3.getResponseCode();
         Dispatcher.RealResponseBody var6 = new Dispatcher.RealResponseBody(var3.getResponseHeaders(), var3.getResponseBody());
         Response var7 = (new Response.Builder(this.request, var5)).rawHeaders(var3.getResponseHeaders().getHeaders()).body(var6).redirectedBy(var2).build();
         Request var8 = this.processResponse(var3, var7);
         if(var8 == null) {
            var3.automaticallyReleaseConnectionToPool();
            return var7;
         }

         if(this.sameConnection(this.request, var8)) {
            var1 = var3.getConnection();
         } else {
            var1 = null;
         }

         var2 = var7;
         this.request = var8;
      }
   }

   private Request processResponse(HttpEngine var1, Response var2) throws IOException {
      Request var3 = var2.request();
      Proxy var4;
      if(var1.getConnection() != null) {
         var4 = var1.getConnection().getRoute().getProxy();
      } else {
         var4 = this.client.getProxy();
      }

      int var5 = var2.code();
      switch(var5) {
      case 300:
      case 301:
      case 302:
      case 303:
      case 307:
         String var6 = var3.method();
         if(var5 == 307 && !var6.equals("GET") && !var6.equals("HEAD")) {
            break;
         }

         String var7 = var2.header("Location");
         if(var7 != null) {
            URL var8 = new URL(var3.url(), var7);
            if(var8.getProtocol().equals("https") || var8.getProtocol().equals("http")) {
               return this.request.newBuilder().url(var8).build();
            }
         }
         break;
      case 407:
         if(var4.type() != Type.HTTP) {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
         }
      case 401:
         RawHeaders var9 = var3.rawHeaders();
         Request var10;
         if(HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), var2.code(), var2.rawHeaders(), var9, var4, this.request.url())) {
            var10 = var3.newBuilder().rawHeaders(var9).build();
         } else {
            var10 = null;
         }

         return var10;
      }

      return null;
   }

   private boolean sameConnection(Request var1, Request var2) {
      return var1.url().getHost().equals(var2.url().getHost()) && Util.getEffectivePort(var1.url()) == Util.getEffectivePort(var2.url()) && var1.url().getProtocol().equals(var2.url().getProtocol());
   }

   public int getChunkLength() {
      return this.request.body().contentLength() == -1L?1024:-1;
   }

   public long getFixedContentLength() {
      return this.request.body().contentLength();
   }

   public HttpURLConnection getHttpConnectionToCache() {
      return null;
   }

   public long getIfModifiedSince() {
      return 0L;
   }

   public URL getURL() {
      return this.request.url();
   }

   public boolean getUseCaches() {
      return false;
   }

   HttpEngine newEngine(Connection var1) throws IOException {
      String var2 = this.request.url().getProtocol();
      RawHeaders var3 = this.request.rawHeaders();
      if(var2.equals("http")) {
         return new HttpEngine(this.client, this, this.request.method(), var3, var1, (RetryableOutputStream)null);
      } else if(var2.equals("https")) {
         return new HttpsEngine(this.client, this, this.request.method(), var3, var1, (RetryableOutputStream)null);
      } else {
         throw new AssertionError();
      }
   }

   public void run() {
      try {
         Response var3 = this.execute();
         this.responseReceiver.onResponse(var3);
         return;
      } catch (IOException var6) {
         this.responseReceiver.onFailure((new Failure.Builder()).request(this.request).exception(var6).build());
      } finally {
         this.dispatcher.finished(this);
      }

   }

   public void setSelectedProxy(Proxy var1) {
   }

   Object tag() {
      return this.request.tag();
   }

   public boolean usingProxy() {
      return false;
   }
}

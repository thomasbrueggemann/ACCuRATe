package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import bolts.Capture;
import com.newrelic.agent.android.instrumentation.okhttp2.OkHttp2Instrumentation;
import com.parse.ParseByteArrayHttpBody;
import com.parse.ParseHttpClient;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Response.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

class ParseOkHttpClient extends ParseHttpClient<Request, Response> {
   private static final String OKHTTP_DELETE = "DELETE";
   private static final String OKHTTP_GET = "GET";
   private static final String OKHTTP_POST = "POST";
   private static final String OKHTTP_PUT = "PUT";
   private OkHttpClient okHttpClient = new OkHttpClient();

   public ParseOkHttpClient(int var1, SSLSessionCache var2) {
      this.okHttpClient.setConnectTimeout((long)var1, TimeUnit.MILLISECONDS);
      this.okHttpClient.setReadTimeout((long)var1, TimeUnit.MILLISECONDS);
      this.okHttpClient.setFollowRedirects(false);
      this.okHttpClient.setSslSocketFactory(SSLCertificateSocketFactory.getDefault(var1, var2));
   }

   private ParseHttpRequest getParseHttpRequest(Request var1) {
      ParseHttpRequest.Builder var2 = new ParseHttpRequest.Builder();
      String var3 = var1.method();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case 70454:
         if(var3.equals("GET")) {
            var4 = 0;
         }
         break;
      case 79599:
         if(var3.equals("PUT")) {
            var4 = 3;
         }
         break;
      case 2461856:
         if(var3.equals("POST")) {
            var4 = 2;
         }
         break;
      case 2012838315:
         if(var3.equals("DELETE")) {
            var4 = 1;
         }
      }

      switch(var4) {
      case 0:
         var2.setMethod(ParseHttpRequest.Method.GET);
         break;
      case 1:
         var2.setMethod(ParseHttpRequest.Method.DELETE);
         break;
      case 2:
         var2.setMethod(ParseHttpRequest.Method.POST);
         break;
      case 3:
         var2.setMethod(ParseHttpRequest.Method.PUT);
         break;
      default:
         throw new IllegalArgumentException("Invalid http method " + var1.method());
      }

      var2.setUrl(var1.urlString());
      Iterator var7 = var1.headers().toMultimap().entrySet().iterator();

      while(var7.hasNext()) {
         Entry var10 = (Entry)var7.next();
         var2.addHeader((String)var10.getKey(), (String)((List)var10.getValue()).get(0));
      }

      ParseOkHttpClient.ParseOkHttpRequestBody var8 = (ParseOkHttpClient.ParseOkHttpRequestBody)var1.body();
      if(var8 != null) {
         var2.setBody(var8.getParseHttpBody());
      }

      return var2.build();
   }

   void addExternalInterceptor(final ParseNetworkInterceptor var1) {
      this.okHttpClient.networkInterceptors().add(new Interceptor() {
         public Response intercept(final Chain var1x) throws IOException {
            Request var2 = var1x.request();
            final ParseHttpRequest var3 = ParseOkHttpClient.this.getParseHttpRequest(var2);
            final Capture var4 = new Capture();
            final ParseHttpResponse var5 = var1.intercept(new ParseNetworkInterceptor.Chain() {
               public ParseHttpRequest getRequest() {
                  return var3;
               }

               public ParseHttpResponse proceed(ParseHttpRequest var1xx) throws IOException {
                  Request var2 = ParseOkHttpClient.this.getRequest(var1xx);
                  Response var3x = var1x.proceed(var2);
                  var4.set(var3x);
                  return ParseOkHttpClient.this.getResponse(var3x);
               }
            });
            Response var6 = (Response)var4.get();
            Builder var7;
            if(!(var6 instanceof Builder)) {
               var7 = var6.newBuilder();
            } else {
               var7 = OkHttp2Instrumentation.newBuilder((Builder)var6);
            }

            var7.code(var5.getStatusCode()).message(var5.getReasonPhrase());
            if(var5.getAllHeaders() != null) {
               Iterator var12 = var5.getAllHeaders().entrySet().iterator();

               while(var12.hasNext()) {
                  Entry var13 = (Entry)var12.next();
                  var7.header((String)var13.getKey(), (String)var13.getValue());
               }
            }

            ResponseBody var9 = new ResponseBody() {
               public long contentLength() throws IOException {
                  return var5.getTotalSize();
               }

               public MediaType contentType() {
                  return var5.getContentType() == null?null:MediaType.parse(var5.getContentType());
               }

               public BufferedSource source() throws IOException {
                  return var5.getContent() == null?null:Okio.buffer(Okio.source(var5.getContent()));
               }
            };
            if(!(var7 instanceof Builder)) {
               var7.body(var9);
            } else {
               OkHttp2Instrumentation.body((Builder)var7, var9);
            }

            return var7.build();
         }
      });
   }

   ParseHttpResponse executeInternal(ParseHttpRequest var1) throws IOException {
      Request var2 = this.getRequest(var1);
      OkHttpClient var3 = this.okHttpClient;
      Call var4;
      if(!(var3 instanceof OkHttpClient)) {
         var4 = var3.newCall(var2);
      } else {
         var4 = OkHttp2Instrumentation.newCall((OkHttpClient)var3, var2);
      }

      return this.getResponse(var4.execute());
   }

   Request getRequest(ParseHttpRequest var1) throws IOException {
      com.squareup.okhttp.Request.Builder var2 = new com.squareup.okhttp.Request.Builder();
      ParseHttpRequest.Method var3 = var1.getMethod();
      switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[var3.ordinal()]) {
      case 1:
         var2.get();
         break;
      case 2:
         var2.delete();
      case 3:
      case 4:
         break;
      default:
         throw new IllegalStateException("Unsupported http method " + var3.toString());
      }

      var2.url(var1.getUrl());
      com.squareup.okhttp.Headers.Builder var6 = new com.squareup.okhttp.Headers.Builder();
      Iterator var7 = var1.getAllHeaders().entrySet().iterator();

      while(var7.hasNext()) {
         Entry var14 = (Entry)var7.next();
         var6.add((String)var14.getKey(), (String)var14.getValue());
      }

      var2.headers(var6.build());
      ParseHttpBody var9 = var1.getBody();
      boolean var10 = var9 instanceof ParseByteArrayHttpBody;
      ParseOkHttpClient.ParseOkHttpRequestBody var11 = null;
      if(var10) {
         var11 = new ParseOkHttpClient.ParseOkHttpRequestBody(var9);
      }

      switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[var3.ordinal()]) {
      case 3:
         var2.post(var11);
         break;
      case 4:
         var2.put(var11);
      }

      return !(var2 instanceof com.squareup.okhttp.Request.Builder)?var2.build():OkHttp2Instrumentation.build((com.squareup.okhttp.Request.Builder)var2);
   }

   ParseHttpResponse getResponse(Response var1) throws IOException {
      int var2 = var1.code();
      InputStream var3 = var1.body().byteStream();
      int var4 = (int)var1.body().contentLength();
      String var5 = var1.message();
      HashMap var6 = new HashMap();
      Iterator var7 = var1.headers().names().iterator();

      while(var7.hasNext()) {
         String var11 = (String)var7.next();
         var6.put(var11, var1.header(var11));
      }

      ResponseBody var8 = var1.body();
      String var9 = null;
      if(var8 != null) {
         MediaType var10 = var8.contentType();
         var9 = null;
         if(var10 != null) {
            var9 = var8.contentType().toString();
         }
      }

      return (new ParseHttpResponse.Builder()).setStatusCode(var2).setContent(var3).setTotalSize((long)var4).setReasonPhrase(var5).setHeaders(var6).setContentType(var9).build();
   }

   private static class ParseOkHttpRequestBody extends RequestBody {
      private ParseHttpBody parseBody;

      public ParseOkHttpRequestBody(ParseHttpBody var1) {
         this.parseBody = var1;
      }

      public long contentLength() throws IOException {
         return this.parseBody.getContentLength();
      }

      public MediaType contentType() {
         return this.parseBody.getContentType() == null?null:MediaType.parse(this.parseBody.getContentType());
      }

      public ParseHttpBody getParseHttpBody() {
         return this.parseBody;
      }

      public void writeTo(BufferedSink var1) throws IOException {
         this.parseBody.writeTo(var1.outputStream());
      }
   }
}

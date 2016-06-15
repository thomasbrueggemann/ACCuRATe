package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.Policy;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import com.squareup.okhttp.internal.http.RouteSelector;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.Proxy.Type;
import java.security.Permission;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;

public class HttpURLConnectionImpl extends HttpURLConnection implements Policy {
   public static final int HTTP_TEMP_REDIRECT = 307;
   private static final int MAX_REDIRECTS = 20;
   final OkHttpClient client;
   private long fixedContentLength = -1L;
   protected HttpEngine httpEngine;
   protected IOException httpEngineFailure;
   private final RawHeaders rawRequestHeaders = new RawHeaders();
   private int redirectionCount;
   private Proxy selectedProxy;

   public HttpURLConnectionImpl(URL var1, OkHttpClient var2) {
      super(var1);
      this.client = var2;
   }

   private boolean execute(boolean param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private HttpEngine getResponse() throws IOException {
      this.initHttpEngine();
      if(this.httpEngine.hasResponse()) {
         return this.httpEngine;
      } else {
         while(true) {
            while(!this.execute(true)) {
               ;
            }

            HttpURLConnectionImpl.Retry var1 = this.processResponseHeaders();
            if(var1 == HttpURLConnectionImpl.Retry.NONE) {
               this.httpEngine.automaticallyReleaseConnectionToPool();
               return this.httpEngine;
            }

            String var2 = this.method;
            OutputStream var3 = this.httpEngine.getRequestBody();
            int var4 = this.httpEngine.getResponseCode();
            if(var4 == 300 || var4 == 301 || var4 == 302 || var4 == 303) {
               var2 = "GET";
               var3 = null;
            }

            if(var3 != null && !(var3 instanceof RetryableOutputStream)) {
               throw new HttpRetryException("Cannot retry streamed HTTP body", var4);
            }

            if(var1 == HttpURLConnectionImpl.Retry.DIFFERENT_CONNECTION) {
               this.httpEngine.automaticallyReleaseConnectionToPool();
            }

            this.httpEngine.release(false);
            this.httpEngine = this.newHttpEngine(var2, this.rawRequestHeaders, this.httpEngine.getConnection(), (RetryableOutputStream)var3);
            if(var3 == null) {
               this.httpEngine.getRequestHeaders().removeContentLength();
            }
         }
      }
   }

   private boolean handleFailure(IOException var1) throws IOException {
      RouteSelector var2 = this.httpEngine.routeSelector;
      if(var2 != null && this.httpEngine.connection != null) {
         var2.connectFailed(this.httpEngine.connection, var1);
      }

      OutputStream var3 = this.httpEngine.getRequestBody();
      boolean var4;
      if(var3 != null && !(var3 instanceof RetryableOutputStream)) {
         var4 = false;
      } else {
         var4 = true;
      }

      if((var2 != null || this.httpEngine.connection != null) && (var2 == null || var2.hasNext()) && this.isRecoverable(var1) && var4) {
         this.httpEngine.release(true);
         RetryableOutputStream var5 = (RetryableOutputStream)var3;
         this.httpEngine = this.newHttpEngine(this.method, this.rawRequestHeaders, (Connection)null, var5);
         this.httpEngine.routeSelector = var2;
         return true;
      } else {
         this.httpEngineFailure = var1;
         return false;
      }
   }

   private void initHttpEngine() throws IOException {
      // $FF: Couldn't be decompiled
   }

   private boolean isRecoverable(IOException var1) {
      boolean var2;
      if(var1 instanceof SSLHandshakeException && var1.getCause() instanceof CertificateException) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3 = var1 instanceof ProtocolException;
      return !var2 && !var3;
   }

   private static boolean isValidNonDirectProxy(Proxy var0) {
      return var0 != null && var0.type() != Type.DIRECT;
   }

   private HttpEngine newHttpEngine(String var1, RawHeaders var2, Connection var3, RetryableOutputStream var4) throws IOException {
      if(this.url.getProtocol().equals("http")) {
         return new HttpEngine(this.client, this, var1, var2, var3, var4);
      } else if(this.url.getProtocol().equals("https")) {
         return new HttpsEngine(this.client, this, var1, var2, var3, var4);
      } else {
         throw new AssertionError();
      }
   }

   private HttpURLConnectionImpl.Retry processResponseHeaders() throws IOException {
      Proxy var1;
      if(this.httpEngine.connection != null) {
         var1 = this.httpEngine.connection.getRoute().getProxy();
      } else {
         var1 = this.client.getProxy();
      }

      int var2 = this.getResponseCode();
      switch(var2) {
      case 300:
      case 301:
      case 302:
      case 303:
      case 307:
         if(!this.getInstanceFollowRedirects()) {
            return HttpURLConnectionImpl.Retry.NONE;
         } else {
            int var3 = 1 + this.redirectionCount;
            this.redirectionCount = var3;
            if(var3 > 20) {
               throw new ProtocolException("Too many redirects: " + this.redirectionCount);
            } else if(var2 == 307 && !this.method.equals("GET") && !this.method.equals("HEAD")) {
               return HttpURLConnectionImpl.Retry.NONE;
            } else {
               String var4 = this.getHeaderField("Location");
               if(var4 == null) {
                  return HttpURLConnectionImpl.Retry.NONE;
               } else {
                  URL var5 = this.url;
                  this.url = new URL(var5, var4);
                  if(!this.url.getProtocol().equals("https") && !this.url.getProtocol().equals("http")) {
                     return HttpURLConnectionImpl.Retry.NONE;
                  } else {
                     boolean var6 = var5.getProtocol().equals(this.url.getProtocol());
                     if(!var6 && !this.client.getFollowProtocolRedirects()) {
                        return HttpURLConnectionImpl.Retry.NONE;
                     } else {
                        boolean var7 = var5.getHost().equals(this.url.getHost());
                        boolean var8;
                        if(Util.getEffectivePort(var5) == Util.getEffectivePort(this.url)) {
                           var8 = true;
                        } else {
                           var8 = false;
                        }

                        if(var7 && var8 && var6) {
                           return HttpURLConnectionImpl.Retry.SAME_CONNECTION;
                        }

                        return HttpURLConnectionImpl.Retry.DIFFERENT_CONNECTION;
                     }
                  }
               }
            }
         }
      case 407:
         if(var1.type() != Type.HTTP) {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
         }
      case 401:
         if(HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), this.getResponseCode(), this.httpEngine.getResponseHeaders().getHeaders(), this.rawRequestHeaders, var1, this.url)) {
            return HttpURLConnectionImpl.Retry.SAME_CONNECTION;
         }

         return HttpURLConnectionImpl.Retry.NONE;
      default:
         return HttpURLConnectionImpl.Retry.NONE;
      }
   }

   private void setTransports(String var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      if(var2) {
         var3.addAll(this.client.getTransports());
      }

      String[] var4 = var1.split(",", -1);
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         var3.add(var4[var6]);
      }

      this.client.setTransports(var3);
   }

   public final void addRequestProperty(String var1, String var2) {
      if(this.connected) {
         throw new IllegalStateException("Cannot add request property after connection is made");
      } else if(var1 == null) {
         throw new NullPointerException("field == null");
      } else if(var2 == null) {
         Platform.get().logW("Ignoring header " + var1 + " because its value was null.");
      } else if("X-Android-Transports".equals(var1)) {
         this.setTransports(var2, true);
      } else {
         this.rawRequestHeaders.add(var1, var2);
      }
   }

   public final void connect() throws IOException {
      this.initHttpEngine();

      while(!this.execute(false)) {
         ;
      }

   }

   public final void disconnect() {
      if(this.httpEngine != null) {
         if(this.httpEngine.hasResponse()) {
            Util.closeQuietly((Closeable)this.httpEngine.getResponseBody());
         }

         this.httpEngine.release(true);
      }

   }

   public final int getChunkLength() {
      return this.chunkLength;
   }

   public int getConnectTimeout() {
      return this.client.getConnectTimeout();
   }

   public final InputStream getErrorStream() {
      // $FF: Couldn't be decompiled
   }

   public final long getFixedContentLength() {
      return this.fixedContentLength;
   }

   public final String getHeaderField(int var1) {
      try {
         String var3 = this.getResponse().getResponseHeaders().getHeaders().getValue(var1);
         return var3;
      } catch (IOException var4) {
         return null;
      }
   }

   public final String getHeaderField(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final String getHeaderFieldKey(int var1) {
      try {
         String var3 = this.getResponse().getResponseHeaders().getHeaders().getFieldName(var1);
         return var3;
      } catch (IOException var4) {
         return null;
      }
   }

   public final Map<String, List<String>> getHeaderFields() {
      try {
         Map var2 = this.getResponse().getResponseHeaders().getHeaders().toMultimap(true);
         return var2;
      } catch (IOException var3) {
         return Collections.emptyMap();
      }
   }

   public HttpURLConnection getHttpConnectionToCache() {
      return this;
   }

   public HttpEngine getHttpEngine() {
      return this.httpEngine;
   }

   public final InputStream getInputStream() throws IOException {
      if(!this.doInput) {
         throw new ProtocolException("This protocol does not support input");
      } else {
         HttpEngine var1 = this.getResponse();
         if(this.getResponseCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
         } else {
            InputStream var2 = var1.getResponseBody();
            if(var2 == null) {
               throw new ProtocolException("No response body exists; responseCode=" + this.getResponseCode());
            } else {
               return var2;
            }
         }
      }
   }

   public final OutputStream getOutputStream() throws IOException {
      this.connect();
      OutputStream var1 = this.httpEngine.getRequestBody();
      if(var1 == null) {
         throw new ProtocolException("method does not support a request body: " + this.method);
      } else if(this.httpEngine.hasResponse()) {
         throw new ProtocolException("cannot write request body after response has been read");
      } else {
         return var1;
      }
   }

   public final Permission getPermission() throws IOException {
      String var1 = this.getURL().getHost();
      int var2 = Util.getEffectivePort(this.getURL());
      if(this.usingProxy()) {
         InetSocketAddress var3 = (InetSocketAddress)this.client.getProxy().address();
         var1 = var3.getHostName();
         var2 = var3.getPort();
      }

      return new SocketPermission(var1 + ":" + var2, "connect, resolve");
   }

   public int getReadTimeout() {
      return this.client.getReadTimeout();
   }

   public final Map<String, List<String>> getRequestProperties() {
      if(this.connected) {
         throw new IllegalStateException("Cannot access request header fields after connection is set");
      } else {
         return this.rawRequestHeaders.toMultimap(false);
      }
   }

   public final String getRequestProperty(String var1) {
      return var1 == null?null:this.rawRequestHeaders.get(var1);
   }

   public final int getResponseCode() throws IOException {
      return this.getResponse().getResponseCode();
   }

   public String getResponseMessage() throws IOException {
      return this.getResponse().getResponseHeaders().getHeaders().getResponseMessage();
   }

   public void setConnectTimeout(int var1) {
      this.client.setConnectTimeout((long)var1, TimeUnit.MILLISECONDS);
   }

   public void setFixedLengthStreamingMode(int var1) {
      this.setFixedLengthStreamingMode((long)var1);
   }

   public void setFixedLengthStreamingMode(long var1) {
      if(super.connected) {
         throw new IllegalStateException("Already connected");
      } else if(this.chunkLength > 0) {
         throw new IllegalStateException("Already in chunked mode");
      } else if(var1 < 0L) {
         throw new IllegalArgumentException("contentLength < 0");
      } else {
         this.fixedContentLength = var1;
         super.fixedContentLength = (int)Math.min(var1, 2147483647L);
      }
   }

   public void setReadTimeout(int var1) {
      this.client.setReadTimeout((long)var1, TimeUnit.MILLISECONDS);
   }

   public final void setRequestProperty(String var1, String var2) {
      if(this.connected) {
         throw new IllegalStateException("Cannot set request property after connection is made");
      } else if(var1 == null) {
         throw new NullPointerException("field == null");
      } else if(var2 == null) {
         Platform.get().logW("Ignoring header " + var1 + " because its value was null.");
      } else if("X-Android-Transports".equals(var1)) {
         this.setTransports(var2, false);
      } else {
         this.rawRequestHeaders.set(var1, var2);
      }
   }

   public final void setSelectedProxy(Proxy var1) {
      this.selectedProxy = var1;
   }

   public final boolean usingProxy() {
      return this.selectedProxy != null?isValidNonDirectProxy(this.selectedProxy):isValidNonDirectProxy(this.client.getProxy());
   }

   static enum Retry {
      DIFFERENT_CONNECTION,
      NONE,
      SAME_CONNECTION;

      static {
         HttpURLConnectionImpl.Retry[] var0 = new HttpURLConnectionImpl.Retry[]{NONE, SAME_CONNECTION, DIFFERENT_CONNECTION};
      }
   }
}

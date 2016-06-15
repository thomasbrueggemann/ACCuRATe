package com.squareup.okhttp;

import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.HttpResponseCache;
import com.squareup.okhttp.OkAuthenticator;
import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.OkResponseCacheAdapter;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class OkHttpClient implements URLStreamHandlerFactory {
   private static final List<String> DEFAULT_TRANSPORTS = Util.immutableList(Arrays.asList(new String[]{"spdy/3", "http/1.1"}));
   private OkAuthenticator authenticator;
   private int connectTimeout;
   private ConnectionPool connectionPool;
   private CookieHandler cookieHandler;
   private final Dispatcher dispatcher;
   private boolean followProtocolRedirects = true;
   private HostnameVerifier hostnameVerifier;
   private Proxy proxy;
   private ProxySelector proxySelector;
   private int readTimeout;
   private ResponseCache responseCache;
   private final RouteDatabase routeDatabase;
   private SSLSocketFactory sslSocketFactory;
   private List<String> transports;

   public OkHttpClient() {
      this.routeDatabase = new RouteDatabase();
      this.dispatcher = new Dispatcher();
   }

   private OkHttpClient(OkHttpClient var1) {
      this.routeDatabase = var1.routeDatabase;
      this.dispatcher = var1.dispatcher;
   }

   private OkHttpClient copyWithDefaults() {
      OkHttpClient var1 = new OkHttpClient(this);
      var1.proxy = this.proxy;
      ProxySelector var2;
      if(this.proxySelector != null) {
         var2 = this.proxySelector;
      } else {
         var2 = ProxySelector.getDefault();
      }

      var1.proxySelector = var2;
      CookieHandler var3;
      if(this.cookieHandler != null) {
         var3 = this.cookieHandler;
      } else {
         var3 = CookieHandler.getDefault();
      }

      var1.cookieHandler = var3;
      ResponseCache var4;
      if(this.responseCache != null) {
         var4 = this.responseCache;
      } else {
         var4 = ResponseCache.getDefault();
      }

      var1.responseCache = var4;
      SSLSocketFactory var5;
      if(this.sslSocketFactory != null) {
         var5 = this.sslSocketFactory;
      } else {
         var5 = HttpsURLConnection.getDefaultSSLSocketFactory();
      }

      var1.sslSocketFactory = var5;
      Object var6;
      if(this.hostnameVerifier != null) {
         var6 = this.hostnameVerifier;
      } else {
         var6 = OkHostnameVerifier.INSTANCE;
      }

      var1.hostnameVerifier = (HostnameVerifier)var6;
      OkAuthenticator var7;
      if(this.authenticator != null) {
         var7 = this.authenticator;
      } else {
         var7 = HttpAuthenticator.SYSTEM_DEFAULT;
      }

      var1.authenticator = var7;
      ConnectionPool var8;
      if(this.connectionPool != null) {
         var8 = this.connectionPool;
      } else {
         var8 = ConnectionPool.getDefault();
      }

      var1.connectionPool = var8;
      var1.followProtocolRedirects = this.followProtocolRedirects;
      List var9;
      if(this.transports != null) {
         var9 = this.transports;
      } else {
         var9 = DEFAULT_TRANSPORTS;
      }

      var1.transports = var9;
      var1.connectTimeout = this.connectTimeout;
      var1.readTimeout = this.readTimeout;
      return var1;
   }

   void cancel(Object var1) {
      this.dispatcher.cancel(var1);
   }

   public URLStreamHandler createURLStreamHandler(final String var1) {
      return !var1.equals("http") && !var1.equals("https")?null:new URLStreamHandler() {
         protected int getDefaultPort() {
            if(var1.equals("http")) {
               return 80;
            } else if(var1.equals("https")) {
               return 443;
            } else {
               throw new AssertionError();
            }
         }

         protected URLConnection openConnection(URL var1x) {
            return OkHttpClient.this.open(var1x);
         }

         protected URLConnection openConnection(URL var1x, Proxy var2) {
            return OkHttpClient.this.open(var1x, var2);
         }
      };
   }

   void enqueue(Request var1, Response.Receiver var2) {
      this.dispatcher.enqueue(this.copyWithDefaults(), var1, var2);
   }

   public OkAuthenticator getAuthenticator() {
      return this.authenticator;
   }

   public int getConnectTimeout() {
      return this.connectTimeout;
   }

   public ConnectionPool getConnectionPool() {
      return this.connectionPool;
   }

   public CookieHandler getCookieHandler() {
      return this.cookieHandler;
   }

   public boolean getFollowProtocolRedirects() {
      return this.followProtocolRedirects;
   }

   public HostnameVerifier getHostnameVerifier() {
      return this.hostnameVerifier;
   }

   public OkResponseCache getOkResponseCache() {
      return (OkResponseCache)(this.responseCache instanceof HttpResponseCache?((HttpResponseCache)this.responseCache).okResponseCache:(this.responseCache != null?new OkResponseCacheAdapter(this.responseCache):null));
   }

   public Proxy getProxy() {
      return this.proxy;
   }

   public ProxySelector getProxySelector() {
      return this.proxySelector;
   }

   public int getReadTimeout() {
      return this.readTimeout;
   }

   public ResponseCache getResponseCache() {
      return this.responseCache;
   }

   public RouteDatabase getRoutesDatabase() {
      return this.routeDatabase;
   }

   public SSLSocketFactory getSslSocketFactory() {
      return this.sslSocketFactory;
   }

   public List<String> getTransports() {
      return this.transports;
   }

   public HttpURLConnection open(URL var1) {
      return this.open(var1, this.proxy);
   }

   HttpURLConnection open(URL var1, Proxy var2) {
      String var3 = var1.getProtocol();
      OkHttpClient var4 = this.copyWithDefaults();
      var4.proxy = var2;
      if(var3.equals("http")) {
         return new HttpURLConnectionImpl(var1, var4);
      } else if(var3.equals("https")) {
         return new HttpsURLConnectionImpl(var1, var4);
      } else {
         throw new IllegalArgumentException("Unexpected protocol: " + var3);
      }
   }

   public OkHttpClient setAuthenticator(OkAuthenticator var1) {
      this.authenticator = var1;
      return this;
   }

   public void setConnectTimeout(long var1, TimeUnit var3) {
      if(var1 < 0L) {
         throw new IllegalArgumentException("timeout < 0");
      } else if(var3 == null) {
         throw new IllegalArgumentException("unit == null");
      } else {
         long var4 = var3.toMillis(var1);
         if(var4 > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
         } else {
            this.connectTimeout = (int)var4;
         }
      }
   }

   public OkHttpClient setConnectionPool(ConnectionPool var1) {
      this.connectionPool = var1;
      return this;
   }

   public OkHttpClient setCookieHandler(CookieHandler var1) {
      this.cookieHandler = var1;
      return this;
   }

   public OkHttpClient setFollowProtocolRedirects(boolean var1) {
      this.followProtocolRedirects = var1;
      return this;
   }

   public OkHttpClient setHostnameVerifier(HostnameVerifier var1) {
      this.hostnameVerifier = var1;
      return this;
   }

   public OkHttpClient setProxy(Proxy var1) {
      this.proxy = var1;
      return this;
   }

   public OkHttpClient setProxySelector(ProxySelector var1) {
      this.proxySelector = var1;
      return this;
   }

   public void setReadTimeout(long var1, TimeUnit var3) {
      if(var1 < 0L) {
         throw new IllegalArgumentException("timeout < 0");
      } else if(var3 == null) {
         throw new IllegalArgumentException("unit == null");
      } else {
         long var4 = var3.toMillis(var1);
         if(var4 > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
         } else {
            this.readTimeout = (int)var4;
         }
      }
   }

   public OkHttpClient setResponseCache(ResponseCache var1) {
      this.responseCache = var1;
      return this;
   }

   public OkHttpClient setSslSocketFactory(SSLSocketFactory var1) {
      this.sslSocketFactory = var1;
      return this;
   }

   public OkHttpClient setTransports(List<String> var1) {
      List var2 = Util.immutableList(var1);
      if(!var2.contains("http/1.1")) {
         throw new IllegalArgumentException("transports doesn\'t contain http/1.1: " + var2);
      } else if(var2.contains((Object)null)) {
         throw new IllegalArgumentException("transports must not contain null");
      } else if(var2.contains("")) {
         throw new IllegalArgumentException("transports contains an empty string");
      } else {
         this.transports = var2;
         return this;
      }
   }
}

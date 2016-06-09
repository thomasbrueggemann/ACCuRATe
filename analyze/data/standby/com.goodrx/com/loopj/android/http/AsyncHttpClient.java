package com.loopj.android.http;

import android.content.Context;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.HttpGet;
import com.loopj.android.http.LogHandler;
import com.loopj.android.http.LogInterface;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.RetryHandler;
import com.loopj.android.http.Utils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.SyncBasicHttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

public class AsyncHttpClient {
   public static LogInterface log = new LogHandler();
   private final Map<String, String> clientHeaderMap;
   private int connectTimeout;
   private final DefaultHttpClient httpClient;
   private final HttpContext httpContext;
   private boolean isUrlEncodingEnabled;
   private int maxConnections;
   private final Map<Context, List<RequestHandle>> requestMap;
   private int responseTimeout;
   private ExecutorService threadPool;

   public AsyncHttpClient() {
      this(false, 80, 443);
   }

   public AsyncHttpClient(SchemeRegistry var1) {
      boolean var2 = true;
      super();
      this.maxConnections = 10;
      this.connectTimeout = 10000;
      this.responseTimeout = 10000;
      this.isUrlEncodingEnabled = var2;
      BasicHttpParams var3 = new BasicHttpParams();
      ConnManagerParams.setTimeout(var3, (long)this.connectTimeout);
      ConnManagerParams.setMaxConnectionsPerRoute(var3, new ConnPerRouteBean(this.maxConnections));
      ConnManagerParams.setMaxTotalConnections(var3, 10);
      HttpConnectionParams.setSoTimeout(var3, this.responseTimeout);
      HttpConnectionParams.setConnectionTimeout(var3, this.connectTimeout);
      HttpConnectionParams.setTcpNoDelay(var3, var2);
      HttpConnectionParams.setSocketBufferSize(var3, 8192);
      HttpProtocolParams.setVersion(var3, HttpVersion.HTTP_1_1);
      ClientConnectionManager var4 = this.createConnectionManager(var1, var3);
      if(var4 == null) {
         var2 = false;
      }

      Utils.asserts(var2, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
      this.threadPool = this.getDefaultThreadPool();
      this.requestMap = Collections.synchronizedMap(new WeakHashMap());
      this.clientHeaderMap = new HashMap();
      this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
      this.httpClient = new DefaultHttpClient(var4, var3);
      this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
         public void process(HttpRequest var1, HttpContext var2) {
            if(!var1.containsHeader("Accept-Encoding")) {
               var1.addHeader("Accept-Encoding", "gzip");
            }

            String var4;
            for(Iterator var3 = AsyncHttpClient.this.clientHeaderMap.keySet().iterator(); var3.hasNext(); var1.addHeader(var4, (String)AsyncHttpClient.this.clientHeaderMap.get(var4))) {
               var4 = (String)var3.next();
               if(var1.containsHeader(var4)) {
                  Header var5 = var1.getFirstHeader(var4);
                  LogInterface var6 = AsyncHttpClient.log;
                  Object[] var7 = new Object[]{var4, AsyncHttpClient.this.clientHeaderMap.get(var4), var5.getName(), var5.getValue()};
                  var6.method_1("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", var7));
                  var1.removeHeader(var5);
               }
            }

         }
      });
      this.httpClient.addResponseInterceptor(new HttpResponseInterceptor() {
         public void process(HttpResponse var1, HttpContext var2) {
            HttpEntity var3 = var1.getEntity();
            if(var3 != null) {
               Header var4 = var3.getContentEncoding();
               if(var4 != null) {
                  HeaderElement[] var5 = var4.getElements();
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     if(var5[var7].getName().equalsIgnoreCase("gzip")) {
                        var1.setEntity(new AsyncHttpClient.InflatingEntity(var3));
                        return;
                     }
                  }
               }
            }

         }
      });
      this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
         public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
            AuthState var3 = (AuthState)var2.getAttribute("http.auth.target-scope");
            CredentialsProvider var4 = (CredentialsProvider)var2.getAttribute("http.auth.credentials-provider");
            HttpHost var5 = (HttpHost)var2.getAttribute("http.target_host");
            if(var3.getAuthScheme() == null) {
               Credentials var6 = var4.getCredentials(new AuthScope(var5.getHostName(), var5.getPort()));
               if(var6 != null) {
                  var3.setAuthScheme(new BasicScheme());
                  var3.setCredentials(var6);
               }
            }

         }
      }, 0);
      this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
   }

   public AsyncHttpClient(boolean var1, int var2, int var3) {
      this(getDefaultSchemeRegistry(var1, var2, var3));
   }

   private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase var1, HttpEntity var2) {
      if(var2 != null) {
         var1.setEntity(var2);
      }

      return var1;
   }

   public static void endEntityViaReflection(HttpEntity param0) {
      // $FF: Couldn't be decompiled
   }

   private static SchemeRegistry getDefaultSchemeRegistry(boolean var0, int var1, int var2) {
      if(var0) {
         log.method_1("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn\'t verify SSL certificates.");
      }

      if(var1 < 1) {
         var1 = 80;
         log.method_1("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
      }

      if(var2 < 1) {
         var2 = 443;
         log.method_1("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
      }

      SSLSocketFactory var3;
      if(var0) {
         var3 = MySSLSocketFactory.getFixedSocketFactory();
      } else {
         var3 = SSLSocketFactory.getSocketFactory();
      }

      SchemeRegistry var4 = new SchemeRegistry();
      var4.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), var1));
      var4.register(new Scheme("https", var3, var2));
      return var4;
   }

   public static String getUrlWithQueryString(boolean var0, String var1, RequestParams var2) {
      if(var1 == null) {
         return null;
      } else {
         if(var0) {
            label29: {
               String var9;
               try {
                  URL var7 = new URL(URLDecoder.decode(var1, "UTF-8"));
                  var9 = (new URI(var7.getProtocol(), var7.getUserInfo(), var7.getHost(), var7.getPort(), var7.getPath(), var7.getQuery(), var7.getRef())).toASCIIString();
               } catch (Exception var10) {
                  log.method_4("AsyncHttpClient", "getUrlWithQueryString encoding URL", var10);
                  break label29;
               }

               var1 = var9;
            }
         }

         if(var2 != null) {
            String var3 = var2.getParamString().trim();
            if(!var3.equals("") && !var3.equals("?")) {
               StringBuilder var4 = (new StringBuilder()).append(var1);
               String var5;
               if(var1.contains("?")) {
                  var5 = "&";
               } else {
                  var5 = "?";
               }

               String var6 = var4.append(var5).toString();
               var1 = var6 + var3;
            }
         }

         return var1;
      }
   }

   public static boolean isInputStreamGZIPCompressed(PushbackInputStream var0) throws IOException {
      byte var1 = 1;
      if(var0 == null) {
         return false;
      } else {
         byte[] var2 = new byte[2];

         int var3;
         int var6;
         for(var3 = 0; var3 < 2; var3 += var6) {
            int var4 = 2 - var3;
            boolean var8 = false;

            try {
               var8 = true;
               var6 = var0.read(var2, var3, var4);
               var8 = false;
            } finally {
               if(var8) {
                  var0.unread(var2, 0, var3);
               }
            }

            if(var6 < 0) {
               var0.unread(var2, 0, var3);
               return false;
            }
         }

         var0.unread(var2, 0, var3);
         if('謟' != (255 & var2[0] | '\uff00' & var2[var1] << 8)) {
            var1 = 0;
         }

         return (boolean)var1;
      }
   }

   private HttpEntity paramsToEntity(RequestParams var1, ResponseHandlerInterface var2) {
      HttpEntity var3 = null;
      if(var1 != null) {
         HttpEntity var5;
         try {
            var5 = var1.getEntity(var2);
         } catch (IOException var6) {
            if(var2 != null) {
               var2.sendFailureMessage(0, (Header[])null, (byte[])null, var6);
               return null;
            }

            var6.printStackTrace();
            return null;
         }

         var3 = var5;
      }

      return var3;
   }

   public static void silentCloseInputStream(InputStream var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            log.method_8("AsyncHttpClient", "Cannot close input stream", var2);
            return;
         }
      }

   }

   public static void silentCloseOutputStream(OutputStream var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            log.method_8("AsyncHttpClient", "Cannot close output stream", var2);
            return;
         }
      }

   }

   protected ClientConnectionManager createConnectionManager(SchemeRegistry var1, BasicHttpParams var2) {
      return new ThreadSafeClientConnManager(var2, var1);
   }

   public RequestHandle get(Context var1, String var2, RequestParams var3, ResponseHandlerInterface var4) {
      return this.sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, var2, var3)), (String)null, var4, var1);
   }

   public RequestHandle get(String var1, RequestParams var2, ResponseHandlerInterface var3) {
      return this.get((Context)null, var1, var2, var3);
   }

   protected ExecutorService getDefaultThreadPool() {
      return Executors.newCachedThreadPool();
   }

   protected URI getURI(String var1) {
      return URI.create(var1).normalize();
   }

   protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient var1, HttpContext var2, HttpUriRequest var3, String var4, ResponseHandlerInterface var5, Context var6) {
      return new AsyncHttpRequest(var1, var2, var3, var5);
   }

   public RequestHandle post(Context var1, String var2, RequestParams var3, ResponseHandlerInterface var4) {
      return this.post(var1, var2, this.paramsToEntity(var3, var4), (String)null, var4);
   }

   public RequestHandle post(Context var1, String var2, HttpEntity var3, String var4, ResponseHandlerInterface var5) {
      return this.sendRequest(this.httpClient, this.httpContext, this.addEntityToRequestBase(new HttpPost(this.getURI(var2)), var3), var4, var5, var1);
   }

   public RequestHandle post(String var1, RequestParams var2, ResponseHandlerInterface var3) {
      return this.post((Context)null, var1, var2, var3);
   }

   protected RequestHandle sendRequest(DefaultHttpClient param1, HttpContext param2, HttpUriRequest param3, String param4, ResponseHandlerInterface param5, Context param6) {
      // $FF: Couldn't be decompiled
   }

   public void setConnectTimeout(int var1) {
      if(var1 < 1000) {
         var1 = 10000;
      }

      this.connectTimeout = var1;
      HttpParams var2 = this.httpClient.getParams();
      ConnManagerParams.setTimeout(var2, (long)this.connectTimeout);
      HttpConnectionParams.setConnectionTimeout(var2, this.connectTimeout);
   }

   public void setCookieStore(CookieStore var1) {
      this.httpContext.setAttribute("http.cookie-store", var1);
   }

   public void setResponseTimeout(int var1) {
      if(var1 < 1000) {
         var1 = 10000;
      }

      this.responseTimeout = var1;
      HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.responseTimeout);
   }

   public void setTimeout(int var1) {
      if(var1 < 1000) {
         var1 = 10000;
      }

      this.setConnectTimeout(var1);
      this.setResponseTimeout(var1);
   }

   public void setUserAgent(String var1) {
      HttpProtocolParams.setUserAgent(this.httpClient.getParams(), var1);
   }

   private static class InflatingEntity extends HttpEntityWrapper {
      GZIPInputStream gzippedStream;
      PushbackInputStream pushbackStream;
      InputStream wrappedStream;

      public InflatingEntity(HttpEntity var1) {
         super(var1);
      }

      public void consumeContent() throws IOException {
         AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
         AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
         AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
         super.consumeContent();
      }

      public InputStream getContent() throws IOException {
         this.wrappedStream = this.wrappedEntity.getContent();
         this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
         if(AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream)) {
            this.gzippedStream = new GZIPInputStream(this.pushbackStream);
            return this.gzippedStream;
         } else {
            return this.pushbackStream;
         }
      }

      public long getContentLength() {
         return this.wrappedEntity == null?0L:this.wrappedEntity.getContentLength();
      }
   }
}

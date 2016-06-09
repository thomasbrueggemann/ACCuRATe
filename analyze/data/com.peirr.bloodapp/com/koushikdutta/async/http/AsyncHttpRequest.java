package com.koushikdutta.async.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.libcore.RequestHeaders;
import java.net.URI;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;

public class AsyncHttpRequest {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   public static final int DEFAULT_TIMEOUT = 30000;
   String LOGTAG;
   long executionTime;
   int logLevel;
   private AsyncHttpRequestBody mBody;
   private boolean mFollowRedirect;
   @Deprecated
   private Handler mHandler;
   private RequestHeaders mHeaders;
   private String mMethod;
   private RawHeaders mRawHeaders;
   int mTimeout;
   String proxyHost;
   int proxyPort;

   static {
      boolean var0;
      if(!AsyncHttpRequest.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public AsyncHttpRequest(URI var1, String var2) {
      this(var1, var2, (RawHeaders)null);
   }

   public AsyncHttpRequest(URI var1, String var2, RawHeaders var3) {
      this.mRawHeaders = new RawHeaders();
      Handler var4;
      if(Looper.myLooper() == null) {
         var4 = null;
      } else {
         var4 = new Handler();
      }

      this.mHandler = var4;
      this.mFollowRedirect = true;
      this.mTimeout = 30000;
      this.proxyPort = -1;
      if(!$assertionsDisabled && var1 == null) {
         throw new AssertionError();
      } else {
         this.mMethod = var2;
         if(var3 == null) {
            var3 = new RawHeaders();
         }

         this.mRawHeaders = var3;
         this.mHeaders = new RequestHeaders(var1, this.mRawHeaders);
         this.mRawHeaders.setStatusLine(this.getRequestLine().toString());
         this.mHeaders.setHost(var1.getHost());
         if(this.mHeaders.getUserAgent() == null) {
            this.mHeaders.setUserAgent(this.getDefaultUserAgent());
         }

         this.mHeaders.setAcceptEncoding("gzip, deflate");
         this.mHeaders.setConnection("keep-alive");
         this.mHeaders.getHeaders().set("Accept", "*/*");
      }
   }

   public static AsyncHttpRequest create(HttpRequest var0) {
      AsyncHttpRequest var1 = new AsyncHttpRequest(URI.create(var0.getRequestLine().getUri()), var0.getRequestLine().getMethod());
      Header[] var2 = var0.getAllHeaders();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Header var5 = var2[var4];
         var1.getHeaders().getHeaders().add(var5.getName(), var5.getValue());
      }

      return var1;
   }

   private String getLogMessage(String var1) {
      long var2;
      if(this.executionTime != 0L) {
         var2 = System.currentTimeMillis() - this.executionTime;
      } else {
         var2 = 0L;
      }

      Object[] var4 = new Object[]{Long.valueOf(var2), this.getUri(), var1};
      return String.format("(%d ms) %s: %s", var4);
   }

   public AsyncHttpRequest addHeader(String var1, String var2) {
      this.getHeaders().getHeaders().add(var1, var2);
      return this;
   }

   public HttpRequest asHttpRequest() {
      return new AsyncHttpRequest.HttpRequestWrapper(this);
   }

   public void disableProxy() {
      this.proxyHost = null;
      this.proxyPort = -1;
   }

   public void enableProxy(String var1, int var2) {
      this.proxyHost = var1;
      this.proxyPort = var2;
   }

   public AsyncHttpRequestBody getBody() {
      return this.mBody;
   }

   protected final String getDefaultUserAgent() {
      String var1 = System.getProperty("http.agent");
      return var1 != null?var1:"Java" + System.getProperty("java.version");
   }

   public boolean getFollowRedirect() {
      return this.mFollowRedirect;
   }

   @Deprecated
   public Handler getHandler() {
      return this.mHandler;
   }

   public RequestHeaders getHeaders() {
      return this.mHeaders;
   }

   public String getMethod() {
      return this.mMethod;
   }

   public String getProxyHost() {
      return this.proxyHost;
   }

   public int getProxyPort() {
      return this.proxyPort;
   }

   public RequestLine getProxyRequestLine() {
      return new RequestLine() {
         public String getMethod() {
            return AsyncHttpRequest.this.mMethod;
         }

         public ProtocolVersion getProtocolVersion() {
            return new ProtocolVersion("HTTP", 1, 1);
         }

         public String getUri() {
            return AsyncHttpRequest.this.getUri().toString();
         }

         public String toString() {
            Object[] var1 = new Object[]{AsyncHttpRequest.this.mMethod, AsyncHttpRequest.this.getUri()};
            return String.format("%s %s HTTP/1.1", var1);
         }
      };
   }

   public RequestLine getRequestLine() {
      return new RequestLine() {
         public String getMethod() {
            return AsyncHttpRequest.this.mMethod;
         }

         public ProtocolVersion getProtocolVersion() {
            return new ProtocolVersion("HTTP", 1, 1);
         }

         public String getUri() {
            return AsyncHttpRequest.this.getUri().toString();
         }

         public String toString() {
            String var1 = AsyncHttpRequest.this.getUri().getRawPath();
            if(var1.length() == 0) {
               var1 = "/";
            }

            String var2 = AsyncHttpRequest.this.getUri().getRawQuery();
            if(var2 != null && var2.length() != 0) {
               var1 = var1 + "?" + var2;
            }

            Object[] var3 = new Object[]{AsyncHttpRequest.this.mMethod, var1};
            return String.format("%s %s HTTP/1.1", var3);
         }
      };
   }

   public String getRequestString() {
      return this.mRawHeaders.toHeaderString();
   }

   public int getTimeout() {
      return this.mTimeout;
   }

   public URI getUri() {
      return this.mHeaders.getUri();
   }

   public void logd(String var1) {
      if(this.LOGTAG != null && this.logLevel <= 3) {
         Log.d(this.LOGTAG, this.getLogMessage(var1));
      }
   }

   public void logd(String var1, Exception var2) {
      if(this.LOGTAG != null && this.logLevel <= 3) {
         Log.d(this.LOGTAG, this.getLogMessage(var1));
         Log.d(this.LOGTAG, var2.getMessage(), var2);
      }
   }

   public void loge(String var1) {
      if(this.LOGTAG != null && this.logLevel <= 6) {
         Log.e(this.LOGTAG, this.getLogMessage(var1));
      }
   }

   public void loge(String var1, Exception var2) {
      if(this.LOGTAG != null && this.logLevel <= 6) {
         Log.e(this.LOGTAG, this.getLogMessage(var1));
         Log.e(this.LOGTAG, var2.getMessage(), var2);
      }
   }

   public void logi(String var1) {
      if(this.LOGTAG != null && this.logLevel <= 4) {
         Log.i(this.LOGTAG, this.getLogMessage(var1));
      }
   }

   public void logv(String var1) {
      if(this.LOGTAG != null && this.logLevel <= 2) {
         Log.v(this.LOGTAG, this.getLogMessage(var1));
      }
   }

   public void logw(String var1) {
      if(this.LOGTAG != null && this.logLevel <= 5) {
         Log.w(this.LOGTAG, this.getLogMessage(var1));
      }
   }

   public void onHandshakeException(AsyncSSLException var1) {
   }

   public void setBody(AsyncHttpRequestBody var1) {
      this.mBody = var1;
   }

   public AsyncHttpRequest setFollowRedirect(boolean var1) {
      this.mFollowRedirect = var1;
      return this;
   }

   @Deprecated
   public AsyncHttpRequest setHandler(Handler var1) {
      this.mHandler = var1;
      return this;
   }

   public AsyncHttpRequest setHeader(String var1, String var2) {
      this.getHeaders().getHeaders().set(var1, var2);
      return this;
   }

   public void setLogging(String var1, int var2) {
      this.LOGTAG = var1;
      this.logLevel = var2;
   }

   public AsyncHttpRequest setMethod(String var1) {
      if(this.getClass() != AsyncHttpRequest.class) {
         throw new UnsupportedOperationException("can\'t change method on a subclass of AsyncHttpRequest");
      } else {
         this.mMethod = var1;
         this.mRawHeaders.setStatusLine(this.getRequestLine().toString());
         return this;
      }
   }

   public AsyncHttpRequest setTimeout(int var1) {
      this.mTimeout = var1;
      return this;
   }

   private static class HttpRequestWrapper implements HttpRequest {
      // $FF: synthetic field
      static final boolean $assertionsDisabled;
      HttpParams params;
      AsyncHttpRequest request;

      static {
         boolean var0;
         if(!AsyncHttpRequest.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         $assertionsDisabled = var0;
      }

      public HttpRequestWrapper(AsyncHttpRequest var1) {
         this.request = var1;
      }

      public void addHeader(String var1, String var2) {
         this.request.getHeaders().getHeaders().add(var1, var2);
      }

      public void addHeader(Header var1) {
         this.request.getHeaders().getHeaders().add(var1.getName(), var1.getValue());
      }

      public boolean containsHeader(String var1) {
         return this.request.getHeaders().getHeaders().get(var1) != null;
      }

      public Header[] getAllHeaders() {
         Header[] var1 = new Header[this.request.getHeaders().getHeaders().length()];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = new BasicHeader(this.request.getHeaders().getHeaders().getFieldName(var2), this.request.getHeaders().getHeaders().getValue(var2));
         }

         return var1;
      }

      public Header getFirstHeader(String var1) {
         String var2 = this.request.getHeaders().getHeaders().get(var1);
         return var2 == null?null:new BasicHeader(var1, var2);
      }

      public Header[] getHeaders(String var1) {
         List var2 = (List)this.request.getHeaders().getHeaders().toMultimap().get(var1);
         Header[] var3;
         if(var2 == null) {
            var3 = new Header[0];
         } else {
            var3 = new Header[var2.size()];

            for(int var4 = 0; var4 < var3.length; ++var4) {
               var3[var4] = new BasicHeader(var1, (String)var2.get(var4));
            }
         }

         return var3;
      }

      public Header getLastHeader(String var1) {
         Header[] var2 = this.getHeaders(var1);
         return var2.length == 0?null:var2[-1 + var2.length];
      }

      public HttpParams getParams() {
         return this.params;
      }

      public ProtocolVersion getProtocolVersion() {
         return new ProtocolVersion("HTTP", 1, 1);
      }

      public RequestLine getRequestLine() {
         return this.request.getRequestLine();
      }

      public HeaderIterator headerIterator() {
         if(!$assertionsDisabled) {
            throw new AssertionError();
         } else {
            return null;
         }
      }

      public HeaderIterator headerIterator(String var1) {
         if(!$assertionsDisabled) {
            throw new AssertionError();
         } else {
            return null;
         }
      }

      public void removeHeader(Header var1) {
         this.request.getHeaders().getHeaders().removeAll(var1.getName());
      }

      public void removeHeaders(String var1) {
         this.request.getHeaders().getHeaders().removeAll(var1);
      }

      public void setHeader(String var1, String var2) {
         this.request.getHeaders().getHeaders().set(var1, var2);
      }

      public void setHeader(Header var1) {
         this.setHeader(var1.getName(), var1.getValue());
      }

      public void setHeaders(Header[] var1) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            this.setHeader(var1[var3]);
         }

      }

      public void setParams(HttpParams var1) {
         this.params = var1;
      }
   }
}

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import cz.msebera.android.httpclient.client.protocol.RequestProxyAuthentication;
import cz.msebera.android.httpclient.client.protocol.RequestTargetAuthentication;
import cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.params.SyncBasicHttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestExpectContinue;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;

@Deprecated
public class DefaultHttpClient extends AbstractHttpClient {
   public DefaultHttpClient() {
      super((ClientConnectionManager)null, (HttpParams)null);
   }

   public DefaultHttpClient(ClientConnectionManager var1, HttpParams var2) {
      super(var1, var2);
   }

   public static void setDefaultHttpParams(HttpParams var0) {
      HttpProtocolParams.setVersion(var0, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(var0, HTTP.DEF_CONTENT_CHARSET.name());
      HttpConnectionParams.setTcpNoDelay(var0, true);
      HttpConnectionParams.setSocketBufferSize(var0, 8192);
      HttpProtocolParams.setUserAgent(var0, HttpClientBuilder.DEFAULT_USER_AGENT);
   }

   protected HttpParams createHttpParams() {
      SyncBasicHttpParams var1 = new SyncBasicHttpParams();
      setDefaultHttpParams(var1);
      return var1;
   }

   protected BasicHttpProcessor createHttpProcessor() {
      BasicHttpProcessor var1 = new BasicHttpProcessor();
      var1.addInterceptor((HttpRequestInterceptor)(new RequestDefaultHeaders()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestContent()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestTargetHost()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestClientConnControl()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestUserAgent()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestExpectContinue()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestAddCookies()));
      var1.addInterceptor((HttpResponseInterceptor)(new ResponseProcessCookies()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestAuthCache()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestTargetAuthentication()));
      var1.addInterceptor((HttpRequestInterceptor)(new RequestProxyAuthentication()));
      return var1;
   }
}

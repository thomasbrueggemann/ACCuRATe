package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.RequestDirector;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionManagerFactory;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.client.BasicCookieStore;
import cz.msebera.android.httpclient.impl.client.BasicCredentialsProvider;
import cz.msebera.android.httpclient.impl.client.ClientParamsStack;
import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.impl.client.DefaultHttpRequestRetryHandler;
import cz.msebera.android.httpclient.impl.client.DefaultRedirectStrategy;
import cz.msebera.android.httpclient.impl.client.DefaultRequestDirector;
import cz.msebera.android.httpclient.impl.client.DefaultUserTokenHandler;
import cz.msebera.android.httpclient.impl.client.ProxyAuthenticationStrategy;
import cz.msebera.android.httpclient.impl.client.TargetAuthenticationStrategy;
import cz.msebera.android.httpclient.impl.conn.BasicClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.DefaultHttpRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.impl.cookie.BestMatchSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.IgnoreSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.NetscapeDraftSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2109SpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import java.io.IOException;

@Deprecated
public abstract class AbstractHttpClient extends CloseableHttpClient {
   private BackoffManager backoffManager;
   private ClientConnectionManager connManager;
   private ConnectionBackoffStrategy connectionBackoffStrategy;
   private CookieStore cookieStore;
   private CredentialsProvider credsProvider;
   private HttpParams defaultParams;
   private ConnectionKeepAliveStrategy keepAliveStrategy;
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   private BasicHttpProcessor mutableProcessor;
   private ImmutableHttpProcessor protocolProcessor;
   private AuthenticationStrategy proxyAuthStrategy;
   private RedirectStrategy redirectStrategy;
   private HttpRequestExecutor requestExec;
   private HttpRequestRetryHandler retryHandler;
   private ConnectionReuseStrategy reuseStrategy;
   private HttpRoutePlanner routePlanner;
   private AuthSchemeRegistry supportedAuthSchemes;
   private CookieSpecRegistry supportedCookieSpecs;
   private AuthenticationStrategy targetAuthStrategy;
   private UserTokenHandler userTokenHandler;

   protected AbstractHttpClient(ClientConnectionManager var1, HttpParams var2) {
      this.defaultParams = var2;
      this.connManager = var1;
   }

   private HttpProcessor getProtocolProcessor() {
      // $FF: Couldn't be decompiled
   }

   public void addRequestInterceptor(HttpRequestInterceptor var1) {
      synchronized(this){}

      try {
         this.getHttpProcessor().addInterceptor(var1);
         this.protocolProcessor = null;
      } finally {
         ;
      }

   }

   public void addRequestInterceptor(HttpRequestInterceptor var1, int var2) {
      synchronized(this){}

      try {
         this.getHttpProcessor().addInterceptor(var1, var2);
         this.protocolProcessor = null;
      } finally {
         ;
      }

   }

   public void addResponseInterceptor(HttpResponseInterceptor var1) {
      synchronized(this){}

      try {
         this.getHttpProcessor().addInterceptor(var1);
         this.protocolProcessor = null;
      } finally {
         ;
      }

   }

   public void close() {
      this.getConnectionManager().shutdown();
   }

   protected AuthSchemeRegistry createAuthSchemeRegistry() {
      AuthSchemeRegistry var1 = new AuthSchemeRegistry();
      var1.register("Basic", new BasicSchemeFactory());
      var1.register("Digest", new DigestSchemeFactory());
      var1.register("NTLM", new NTLMSchemeFactory());
      return var1;
   }

   protected ClientConnectionManager createClientConnectionManager() {
      SchemeRegistry var1 = SchemeRegistryFactory.createDefault();
      HttpParams var2 = this.getParams();
      String var3 = (String)var2.getParameter("http.connection-manager.factory-class-name");
      ClientConnectionManagerFactory var4 = null;
      if(var3 != null) {
         try {
            var4 = (ClientConnectionManagerFactory)Class.forName(var3).newInstance();
         } catch (ClassNotFoundException var8) {
            throw new IllegalStateException("Invalid class name: " + var3);
         } catch (IllegalAccessException var9) {
            throw new IllegalAccessError(var9.getMessage());
         } catch (InstantiationException var10) {
            throw new InstantiationError(var10.getMessage());
         }
      }

      return (ClientConnectionManager)(var4 != null?var4.newInstance(var2, var1):new BasicClientConnectionManager(var1));
   }

   protected RequestDirector createClientRequestDirector(HttpRequestExecutor var1, ClientConnectionManager var2, ConnectionReuseStrategy var3, ConnectionKeepAliveStrategy var4, HttpRoutePlanner var5, HttpProcessor var6, HttpRequestRetryHandler var7, RedirectStrategy var8, AuthenticationStrategy var9, AuthenticationStrategy var10, UserTokenHandler var11, HttpParams var12) {
      return new DefaultRequestDirector(this.log, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
      return new DefaultConnectionKeepAliveStrategy();
   }

   protected ConnectionReuseStrategy createConnectionReuseStrategy() {
      return new DefaultConnectionReuseStrategy();
   }

   protected CookieSpecRegistry createCookieSpecRegistry() {
      CookieSpecRegistry var1 = new CookieSpecRegistry();
      var1.register("best-match", new BestMatchSpecFactory());
      var1.register("compatibility", new BrowserCompatSpecFactory());
      var1.register("netscape", new NetscapeDraftSpecFactory());
      var1.register("rfc2109", new RFC2109SpecFactory());
      var1.register("rfc2965", new RFC2965SpecFactory());
      var1.register("ignoreCookies", new IgnoreSpecFactory());
      return var1;
   }

   protected CookieStore createCookieStore() {
      return new BasicCookieStore();
   }

   protected CredentialsProvider createCredentialsProvider() {
      return new BasicCredentialsProvider();
   }

   protected HttpContext createHttpContext() {
      BasicHttpContext var1 = new BasicHttpContext();
      var1.setAttribute("http.scheme-registry", this.getConnectionManager().getSchemeRegistry());
      var1.setAttribute("http.authscheme-registry", this.getAuthSchemes());
      var1.setAttribute("http.cookiespec-registry", this.getCookieSpecs());
      var1.setAttribute("http.cookie-store", this.getCookieStore());
      var1.setAttribute("http.auth.credentials-provider", this.getCredentialsProvider());
      return var1;
   }

   protected abstract HttpParams createHttpParams();

   protected abstract BasicHttpProcessor createHttpProcessor();

   protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
      return new DefaultHttpRequestRetryHandler();
   }

   protected HttpRoutePlanner createHttpRoutePlanner() {
      return new DefaultHttpRoutePlanner(this.getConnectionManager().getSchemeRegistry());
   }

   protected AuthenticationStrategy createProxyAuthenticationStrategy() {
      return new ProxyAuthenticationStrategy();
   }

   protected HttpRequestExecutor createRequestExecutor() {
      return new HttpRequestExecutor();
   }

   protected AuthenticationStrategy createTargetAuthenticationStrategy() {
      return new TargetAuthenticationStrategy();
   }

   protected UserTokenHandler createUserTokenHandler() {
      return new DefaultUserTokenHandler();
   }

   protected HttpParams determineParams(HttpRequest var1) {
      return new ClientParamsStack((HttpParams)null, this.getParams(), var1.getParams(), (HttpParams)null);
   }

   protected final CloseableHttpResponse doExecute(HttpHost param1, HttpRequest param2, HttpContext param3) throws IOException, ClientProtocolException {
      // $FF: Couldn't be decompiled
   }

   public final AuthSchemeRegistry getAuthSchemes() {
      synchronized(this){}

      AuthSchemeRegistry var2;
      try {
         if(this.supportedAuthSchemes == null) {
            this.supportedAuthSchemes = this.createAuthSchemeRegistry();
         }

         var2 = this.supportedAuthSchemes;
      } finally {
         ;
      }

      return var2;
   }

   public final BackoffManager getBackoffManager() {
      synchronized(this){}

      BackoffManager var2;
      try {
         var2 = this.backoffManager;
      } finally {
         ;
      }

      return var2;
   }

   public final ConnectionBackoffStrategy getConnectionBackoffStrategy() {
      synchronized(this){}

      ConnectionBackoffStrategy var2;
      try {
         var2 = this.connectionBackoffStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
      synchronized(this){}

      ConnectionKeepAliveStrategy var2;
      try {
         if(this.keepAliveStrategy == null) {
            this.keepAliveStrategy = this.createConnectionKeepAliveStrategy();
         }

         var2 = this.keepAliveStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final ClientConnectionManager getConnectionManager() {
      synchronized(this){}

      ClientConnectionManager var2;
      try {
         if(this.connManager == null) {
            this.connManager = this.createClientConnectionManager();
         }

         var2 = this.connManager;
      } finally {
         ;
      }

      return var2;
   }

   public final ConnectionReuseStrategy getConnectionReuseStrategy() {
      synchronized(this){}

      ConnectionReuseStrategy var2;
      try {
         if(this.reuseStrategy == null) {
            this.reuseStrategy = this.createConnectionReuseStrategy();
         }

         var2 = this.reuseStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final CookieSpecRegistry getCookieSpecs() {
      synchronized(this){}

      CookieSpecRegistry var2;
      try {
         if(this.supportedCookieSpecs == null) {
            this.supportedCookieSpecs = this.createCookieSpecRegistry();
         }

         var2 = this.supportedCookieSpecs;
      } finally {
         ;
      }

      return var2;
   }

   public final CookieStore getCookieStore() {
      synchronized(this){}

      CookieStore var2;
      try {
         if(this.cookieStore == null) {
            this.cookieStore = this.createCookieStore();
         }

         var2 = this.cookieStore;
      } finally {
         ;
      }

      return var2;
   }

   public final CredentialsProvider getCredentialsProvider() {
      synchronized(this){}

      CredentialsProvider var2;
      try {
         if(this.credsProvider == null) {
            this.credsProvider = this.createCredentialsProvider();
         }

         var2 = this.credsProvider;
      } finally {
         ;
      }

      return var2;
   }

   protected final BasicHttpProcessor getHttpProcessor() {
      synchronized(this){}

      BasicHttpProcessor var2;
      try {
         if(this.mutableProcessor == null) {
            this.mutableProcessor = this.createHttpProcessor();
         }

         var2 = this.mutableProcessor;
      } finally {
         ;
      }

      return var2;
   }

   public final HttpRequestRetryHandler getHttpRequestRetryHandler() {
      synchronized(this){}

      HttpRequestRetryHandler var2;
      try {
         if(this.retryHandler == null) {
            this.retryHandler = this.createHttpRequestRetryHandler();
         }

         var2 = this.retryHandler;
      } finally {
         ;
      }

      return var2;
   }

   public final HttpParams getParams() {
      synchronized(this){}

      HttpParams var2;
      try {
         if(this.defaultParams == null) {
            this.defaultParams = this.createHttpParams();
         }

         var2 = this.defaultParams;
      } finally {
         ;
      }

      return var2;
   }

   public final AuthenticationStrategy getProxyAuthenticationStrategy() {
      synchronized(this){}

      AuthenticationStrategy var2;
      try {
         if(this.proxyAuthStrategy == null) {
            this.proxyAuthStrategy = this.createProxyAuthenticationStrategy();
         }

         var2 = this.proxyAuthStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final RedirectStrategy getRedirectStrategy() {
      synchronized(this){}

      RedirectStrategy var2;
      try {
         if(this.redirectStrategy == null) {
            this.redirectStrategy = new DefaultRedirectStrategy();
         }

         var2 = this.redirectStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final HttpRequestExecutor getRequestExecutor() {
      synchronized(this){}

      HttpRequestExecutor var2;
      try {
         if(this.requestExec == null) {
            this.requestExec = this.createRequestExecutor();
         }

         var2 = this.requestExec;
      } finally {
         ;
      }

      return var2;
   }

   public final HttpRoutePlanner getRoutePlanner() {
      synchronized(this){}

      HttpRoutePlanner var2;
      try {
         if(this.routePlanner == null) {
            this.routePlanner = this.createHttpRoutePlanner();
         }

         var2 = this.routePlanner;
      } finally {
         ;
      }

      return var2;
   }

   public final AuthenticationStrategy getTargetAuthenticationStrategy() {
      synchronized(this){}

      AuthenticationStrategy var2;
      try {
         if(this.targetAuthStrategy == null) {
            this.targetAuthStrategy = this.createTargetAuthenticationStrategy();
         }

         var2 = this.targetAuthStrategy;
      } finally {
         ;
      }

      return var2;
   }

   public final UserTokenHandler getUserTokenHandler() {
      synchronized(this){}

      UserTokenHandler var2;
      try {
         if(this.userTokenHandler == null) {
            this.userTokenHandler = this.createUserTokenHandler();
         }

         var2 = this.userTokenHandler;
      } finally {
         ;
      }

      return var2;
   }

   public void setHttpRequestRetryHandler(HttpRequestRetryHandler var1) {
      synchronized(this){}

      try {
         this.retryHandler = var1;
      } finally {
         ;
      }

   }
}

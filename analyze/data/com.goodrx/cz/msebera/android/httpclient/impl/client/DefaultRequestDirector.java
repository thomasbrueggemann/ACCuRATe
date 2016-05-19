package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.RequestDirector;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.HttpClientParams;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.AuthenticationStrategyAdaptor;
import cz.msebera.android.httpclient.impl.client.DefaultRedirectStrategyAdaptor;
import cz.msebera.android.httpclient.impl.client.EntityEnclosingRequestWrapper;
import cz.msebera.android.httpclient.impl.client.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.client.RequestWrapper;
import cz.msebera.android.httpclient.impl.client.RoutedRequest;
import cz.msebera.android.httpclient.impl.client.TunnelRefusedException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.net.URI;

@Deprecated
public class DefaultRequestDirector implements RequestDirector {
   private final HttpAuthenticator authenticator;
   protected final ClientConnectionManager connManager;
   private int execCount;
   protected final HttpProcessor httpProcessor;
   protected final ConnectionKeepAliveStrategy keepAliveStrategy;
   public HttpClientAndroidLog log;
   protected ManagedClientConnection managedConn;
   private final int maxRedirects;
   protected final HttpParams params;
   @Deprecated
   protected final AuthenticationHandler proxyAuthHandler;
   protected final AuthState proxyAuthState;
   protected final AuthenticationStrategy proxyAuthStrategy;
   private int redirectCount;
   @Deprecated
   protected final RedirectHandler redirectHandler;
   protected final RedirectStrategy redirectStrategy;
   protected final HttpRequestExecutor requestExec;
   protected final HttpRequestRetryHandler retryHandler;
   protected final ConnectionReuseStrategy reuseStrategy;
   protected final HttpRoutePlanner routePlanner;
   @Deprecated
   protected final AuthenticationHandler targetAuthHandler;
   protected final AuthState targetAuthState;
   protected final AuthenticationStrategy targetAuthStrategy;
   protected final UserTokenHandler userTokenHandler;
   private HttpHost virtualHost;

   public DefaultRequestDirector(HttpClientAndroidLog var1, HttpRequestExecutor var2, ClientConnectionManager var3, ConnectionReuseStrategy var4, ConnectionKeepAliveStrategy var5, HttpRoutePlanner var6, HttpProcessor var7, HttpRequestRetryHandler var8, RedirectStrategy var9, AuthenticationStrategy var10, AuthenticationStrategy var11, UserTokenHandler var12, HttpParams var13) {
      Args.notNull(var1, "Log");
      Args.notNull(var2, "Request executor");
      Args.notNull(var3, "Client connection manager");
      Args.notNull(var4, "Connection reuse strategy");
      Args.notNull(var5, "Connection keep alive strategy");
      Args.notNull(var6, "Route planner");
      Args.notNull(var7, "HTTP protocol processor");
      Args.notNull(var8, "HTTP request retry handler");
      Args.notNull(var9, "Redirect strategy");
      Args.notNull(var10, "Target authentication strategy");
      Args.notNull(var11, "Proxy authentication strategy");
      Args.notNull(var12, "User token handler");
      Args.notNull(var13, "HTTP parameters");
      this.log = var1;
      this.authenticator = new HttpAuthenticator(var1);
      this.requestExec = var2;
      this.connManager = var3;
      this.reuseStrategy = var4;
      this.keepAliveStrategy = var5;
      this.routePlanner = var6;
      this.httpProcessor = var7;
      this.retryHandler = var8;
      this.redirectStrategy = var9;
      this.targetAuthStrategy = var10;
      this.proxyAuthStrategy = var11;
      this.userTokenHandler = var12;
      this.params = var13;
      if(var9 instanceof DefaultRedirectStrategyAdaptor) {
         this.redirectHandler = ((DefaultRedirectStrategyAdaptor)var9).getHandler();
      } else {
         this.redirectHandler = null;
      }

      if(var10 instanceof AuthenticationStrategyAdaptor) {
         this.targetAuthHandler = ((AuthenticationStrategyAdaptor)var10).getHandler();
      } else {
         this.targetAuthHandler = null;
      }

      if(var11 instanceof AuthenticationStrategyAdaptor) {
         this.proxyAuthHandler = ((AuthenticationStrategyAdaptor)var11).getHandler();
      } else {
         this.proxyAuthHandler = null;
      }

      this.managedConn = null;
      this.execCount = 0;
      this.redirectCount = 0;
      this.targetAuthState = new AuthState();
      this.proxyAuthState = new AuthState();
      this.maxRedirects = this.params.getIntParameter("http.protocol.max-redirects", 100);
   }

   private void abortConnection() {
      ManagedClientConnection var1 = this.managedConn;
      if(var1 != null) {
         this.managedConn = null;

         try {
            var1.abortConnection();
         } catch (IOException var5) {
            if(this.log.isDebugEnabled()) {
               this.log.debug(var5.getMessage(), var5);
            }
         }

         try {
            var1.releaseConnection();
         } catch (IOException var4) {
            this.log.debug("Error releasing connection", var4);
            return;
         }
      }

   }

   private void tryConnect(RoutedRequest param1, HttpContext param2) throws HttpException, IOException {
      // $FF: Couldn't be decompiled
   }

   private HttpResponse tryExecute(RoutedRequest var1, HttpContext var2) throws HttpException, IOException {
      RequestWrapper var3 = var1.getRequest();
      HttpRoute var4 = var1.getRoute();
      IOException var5 = null;

      while(true) {
         ++this.execCount;
         var3.incrementExecCount();
         if(!var3.isRepeatable()) {
            this.log.debug("Cannot retry non-repeatable request");
            if(var5 != null) {
               throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", var5);
            }

            throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
         }

         try {
            if(!this.managedConn.isOpen()) {
               if(var4.isTunnelled()) {
                  this.log.debug("Proxied connection. Need to start over.");
                  return null;
               }

               this.log.debug("Reopening the direct connection.");
               this.managedConn.open(var4, var2, this.params);
            }

            if(this.log.isDebugEnabled()) {
               this.log.debug("Attempt " + this.execCount + " to execute request");
            }

            return this.requestExec.execute(var3, this.managedConn, var2);
         } catch (IOException var10) {
            this.log.debug("Closing the connection.");

            try {
               this.managedConn.close();
            } catch (IOException var9) {
               ;
            }

            if(!this.retryHandler.retryRequest(var10, var3.getExecCount(), var2)) {
               if(var10 instanceof NoHttpResponseException) {
                  NoHttpResponseException var8 = new NoHttpResponseException(var4.getTargetHost().toHostString() + " failed to respond");
                  var8.setStackTrace(var10.getStackTrace());
                  throw var8;
               }

               throw var10;
            }

            if(this.log.isInfoEnabled()) {
               this.log.info("I/O exception (" + var10.getClass().getName() + ") caught when processing request to " + var4 + ": " + var10.getMessage());
            }

            if(this.log.isDebugEnabled()) {
               this.log.debug(var10.getMessage(), var10);
            }

            if(this.log.isInfoEnabled()) {
               this.log.info("Retrying request to " + var4);
            }

            var5 = var10;
         }
      }
   }

   private RequestWrapper wrapRequest(HttpRequest var1) throws ProtocolException {
      return (RequestWrapper)(var1 instanceof HttpEntityEnclosingRequest?new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)var1):new RequestWrapper(var1));
   }

   protected HttpRequest createConnectRequest(HttpRoute var1, HttpContext var2) {
      HttpHost var3 = var1.getTargetHost();
      String var4 = var3.getHostName();
      int var5 = var3.getPort();
      if(var5 < 0) {
         var5 = this.connManager.getSchemeRegistry().getScheme(var3.getSchemeName()).getDefaultPort();
      }

      StringBuilder var6 = new StringBuilder(6 + var4.length());
      var6.append(var4);
      var6.append(':');
      var6.append(Integer.toString(var5));
      return new BasicHttpRequest("CONNECT", var6.toString(), HttpProtocolParams.getVersion(this.params));
   }

   protected boolean createTunnelToProxy(HttpRoute var1, int var2, HttpContext var3) throws HttpException, IOException {
      throw new HttpException("Proxy chains are not supported.");
   }

   protected boolean createTunnelToTarget(HttpRoute var1, HttpContext var2) throws HttpException, IOException {
      HttpHost var3 = var1.getProxyHost();
      HttpHost var4 = var1.getTargetHost();

      while(true) {
         HttpResponse var6;
         do {
            if(!this.managedConn.isOpen()) {
               this.managedConn.open(var1, var2, this.params);
            }

            HttpRequest var5 = this.createConnectRequest(var1, var2);
            var5.setParams(this.params);
            var2.setAttribute("http.target_host", var4);
            var2.setAttribute("http.route", var1);
            var2.setAttribute("http.proxy_host", var3);
            var2.setAttribute("http.connection", this.managedConn);
            var2.setAttribute("http.request", var5);
            this.requestExec.preProcess(var5, this.httpProcessor, var2);
            var6 = this.requestExec.execute(var5, this.managedConn, var2);
            var6.setParams(this.params);
            this.requestExec.postProcess(var6, this.httpProcessor, var2);
            if(var6.getStatusLine().getStatusCode() < 200) {
               throw new HttpException("Unexpected response to CONNECT request: " + var6.getStatusLine());
            }
         } while(!HttpClientParams.isAuthenticating(this.params));

         if(!this.authenticator.isAuthenticationRequested(var3, var6, this.proxyAuthStrategy, this.proxyAuthState, var2) || !this.authenticator.authenticate(var3, var6, this.proxyAuthStrategy, this.proxyAuthState, var2)) {
            if(var6.getStatusLine().getStatusCode() > 299) {
               HttpEntity var7 = var6.getEntity();
               if(var7 != null) {
                  var6.setEntity(new BufferedHttpEntity(var7));
               }

               this.managedConn.close();
               throw new TunnelRefusedException("CONNECT refused by proxy: " + var6.getStatusLine(), var6);
            } else {
               this.managedConn.markReusable();
               return false;
            }
         }

         if(this.reuseStrategy.keepAlive(var6, var2)) {
            this.log.debug("Connection kept alive");
            EntityUtils.consume(var6.getEntity());
         } else {
            this.managedConn.close();
         }
      }
   }

   protected HttpRoute determineRoute(HttpHost var1, HttpRequest var2, HttpContext var3) throws HttpException {
      HttpRoutePlanner var4 = this.routePlanner;
      if(var1 == null) {
         var1 = (HttpHost)var2.getParams().getParameter("http.default-host");
      }

      return var4.determineRoute(var1, var2, var3);
   }

   protected void establishRoute(HttpRoute var1, HttpContext var2) throws HttpException, IOException {
      BasicRouteDirector var3 = new BasicRouteDirector();

      int var5;
      do {
         HttpRoute var4 = this.managedConn.getRoute();
         var5 = var3.nextStep(var1, var4);
         switch(var5) {
         case -1:
            throw new HttpException("Unable to establish route: planned = " + var1 + "; current = " + var4);
         case 0:
            break;
         case 1:
         case 2:
            this.managedConn.open(var1, var2, this.params);
            break;
         case 3:
            boolean var8 = this.createTunnelToTarget(var1, var2);
            this.log.debug("Tunnel to target created.");
            this.managedConn.tunnelTarget(var8, this.params);
            break;
         case 4:
            int var6 = -1 + var4.getHopCount();
            boolean var7 = this.createTunnelToProxy(var1, var6, var2);
            this.log.debug("Tunnel to proxy created.");
            this.managedConn.tunnelProxy(var1.getHopTarget(var6), var7, this.params);
            break;
         case 5:
            this.managedConn.layerProtocol(var2, this.params);
            break;
         default:
            throw new IllegalStateException("Unknown step indicator " + var5 + " from RouteDirector.");
         }
      } while(var5 > 0);

   }

   public HttpResponse execute(HttpHost param1, HttpRequest param2, HttpContext param3) throws HttpException, IOException {
      // $FF: Couldn't be decompiled
   }

   protected RoutedRequest handleResponse(RoutedRequest var1, HttpResponse var2, HttpContext var3) throws HttpException, IOException {
      HttpRoute var4 = var1.getRoute();
      RequestWrapper var5 = var1.getRequest();
      HttpParams var6 = var5.getParams();
      if(HttpClientParams.isAuthenticating(var6)) {
         HttpHost var14 = (HttpHost)var3.getAttribute("http.target_host");
         if(var14 == null) {
            var14 = var4.getTargetHost();
         }

         if(var14.getPort() < 0) {
            Scheme var21 = this.connManager.getSchemeRegistry().getScheme(var14);
            HttpHost var22 = new HttpHost(var14.getHostName(), var21.getDefaultPort(), var14.getSchemeName());
            var14 = var22;
         }

         boolean var15 = this.authenticator.isAuthenticationRequested(var14, var2, this.targetAuthStrategy, this.targetAuthState, var3);
         HttpHost var16 = var4.getProxyHost();
         if(var16 == null) {
            var16 = var4.getTargetHost();
         }

         boolean var17 = this.authenticator.isAuthenticationRequested(var16, var2, this.proxyAuthStrategy, this.proxyAuthState, var3);
         if(var15) {
            HttpAuthenticator var18 = this.authenticator;
            AuthenticationStrategy var19 = this.targetAuthStrategy;
            AuthState var20 = this.targetAuthState;
            if(var18.authenticate(var14, var2, var19, var20, var3)) {
               return var1;
            }
         }

         if(var17 && this.authenticator.authenticate(var16, var2, this.proxyAuthStrategy, this.proxyAuthState, var3)) {
            return var1;
         }
      }

      if(HttpClientParams.isRedirecting(var6) && this.redirectStrategy.isRedirected(var5, var2, var3)) {
         if(this.redirectCount >= this.maxRedirects) {
            throw new RedirectException("Maximum redirects (" + this.maxRedirects + ") exceeded");
         } else {
            ++this.redirectCount;
            this.virtualHost = null;
            HttpUriRequest var7 = this.redirectStrategy.getRedirect(var5, var2, var3);
            var7.setHeaders(var5.getOriginal().getAllHeaders());
            URI var8 = var7.getURI();
            HttpHost var9 = URIUtils.extractHost(var8);
            if(var9 == null) {
               throw new ProtocolException("Redirect URI does not specify a valid host name: " + var8);
            } else {
               if(!var4.getTargetHost().equals(var9)) {
                  this.log.debug("Resetting target auth state");
                  this.targetAuthState.reset();
                  AuthScheme var13 = this.proxyAuthState.getAuthScheme();
                  if(var13 != null && var13.isConnectionBased()) {
                     this.log.debug("Resetting proxy auth state");
                     this.proxyAuthState.reset();
                  }
               }

               RequestWrapper var10 = this.wrapRequest(var7);
               var10.setParams(var6);
               HttpRoute var11 = this.determineRoute(var9, var10, var3);
               RoutedRequest var12 = new RoutedRequest(var10, var11);
               if(this.log.isDebugEnabled()) {
                  this.log.debug("Redirecting to \'" + var8 + "\' via " + var11);
               }

               return var12;
            }
         }
      } else {
         return null;
      }
   }

   protected void releaseConnection() {
      try {
         this.managedConn.releaseConnection();
      } catch (IOException var2) {
         this.log.debug("IOException releasing connection", var2);
      }

      this.managedConn = null;
   }

   protected void rewriteRequestURI(RequestWrapper param1, HttpRoute param2) throws ProtocolException {
      // $FF: Couldn't be decompiled
   }
}

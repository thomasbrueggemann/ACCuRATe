package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpCoreContext;

public class HttpClientContext extends HttpCoreContext {
   public HttpClientContext() {
   }

   public HttpClientContext(HttpContext var1) {
      super(var1);
   }

   public static HttpClientContext adapt(HttpContext var0) {
      return var0 instanceof HttpClientContext?(HttpClientContext)var0:new HttpClientContext(var0);
   }

   private <T> Lookup<T> getLookup(String var1, Class<T> var2) {
      return (Lookup)this.getAttribute(var1, Lookup.class);
   }

   public AuthCache getAuthCache() {
      return (AuthCache)this.getAttribute("http.auth.auth-cache", AuthCache.class);
   }

   public Lookup<AuthSchemeProvider> getAuthSchemeRegistry() {
      return this.getLookup("http.authscheme-registry", AuthSchemeProvider.class);
   }

   public CookieOrigin getCookieOrigin() {
      return (CookieOrigin)this.getAttribute("http.cookie-origin", CookieOrigin.class);
   }

   public CookieSpec getCookieSpec() {
      return (CookieSpec)this.getAttribute("http.cookie-spec", CookieSpec.class);
   }

   public Lookup<CookieSpecProvider> getCookieSpecRegistry() {
      return this.getLookup("http.cookiespec-registry", CookieSpecProvider.class);
   }

   public CookieStore getCookieStore() {
      return (CookieStore)this.getAttribute("http.cookie-store", CookieStore.class);
   }

   public CredentialsProvider getCredentialsProvider() {
      return (CredentialsProvider)this.getAttribute("http.auth.credentials-provider", CredentialsProvider.class);
   }

   public RouteInfo getHttpRoute() {
      return (RouteInfo)this.getAttribute("http.route", HttpRoute.class);
   }

   public AuthState getProxyAuthState() {
      return (AuthState)this.getAttribute("http.auth.proxy-scope", AuthState.class);
   }

   public RequestConfig getRequestConfig() {
      RequestConfig var1 = (RequestConfig)this.getAttribute("http.request-config", RequestConfig.class);
      return var1 != null?var1:RequestConfig.DEFAULT;
   }

   public AuthState getTargetAuthState() {
      return (AuthState)this.getAttribute("http.auth.target-scope", AuthState.class);
   }

   public void setAuthCache(AuthCache var1) {
      this.setAttribute("http.auth.auth-cache", var1);
   }
}

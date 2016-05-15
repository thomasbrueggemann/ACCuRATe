package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;
import java.util.Collection;

@Deprecated
public final class HttpClientParamConfig {
   public static RequestConfig getRequestConfig(HttpParams var0) {
      RequestConfig.Builder var1 = RequestConfig.custom().setSocketTimeout(var0.getIntParameter("http.socket.timeout", 0)).setStaleConnectionCheckEnabled(var0.getBooleanParameter("http.connection.stalecheck", true)).setConnectTimeout(var0.getIntParameter("http.connection.timeout", 0)).setExpectContinueEnabled(var0.getBooleanParameter("http.protocol.expect-continue", false)).setProxy((HttpHost)var0.getParameter("http.route.default-proxy")).setLocalAddress((InetAddress)var0.getParameter("http.route.local-address")).setProxyPreferredAuthSchemes((Collection)var0.getParameter("http.auth.proxy-scheme-pref")).setTargetPreferredAuthSchemes((Collection)var0.getParameter("http.auth.target-scheme-pref")).setAuthenticationEnabled(var0.getBooleanParameter("http.protocol.handle-authentication", true)).setCircularRedirectsAllowed(var0.getBooleanParameter("http.protocol.allow-circular-redirects", false)).setConnectionRequestTimeout((int)var0.getLongParameter("http.conn-manager.timeout", 0L)).setCookieSpec((String)var0.getParameter("http.protocol.cookie-policy")).setMaxRedirects(var0.getIntParameter("http.protocol.max-redirects", 50)).setRedirectsEnabled(var0.getBooleanParameter("http.protocol.handle-redirects", true));
      boolean var2;
      if(!var0.getBooleanParameter("http.protocol.reject-relative-redirect", false)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var1.setRelativeRedirectsAllowed(var2).build();
   }
}

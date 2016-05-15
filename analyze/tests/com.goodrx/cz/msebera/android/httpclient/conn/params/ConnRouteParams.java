package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;

@Deprecated
public class ConnRouteParams {
   public static final HttpHost NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
   public static final HttpRoute NO_ROUTE;

   static {
      NO_ROUTE = new HttpRoute(NO_HOST);
   }

   public static HttpHost getDefaultProxy(HttpParams var0) {
      Args.notNull(var0, "Parameters");
      HttpHost var2 = (HttpHost)var0.getParameter("http.route.default-proxy");
      if(var2 != null && NO_HOST.equals(var2)) {
         var2 = null;
      }

      return var2;
   }

   public static HttpRoute getForcedRoute(HttpParams var0) {
      Args.notNull(var0, "Parameters");
      HttpRoute var2 = (HttpRoute)var0.getParameter("http.route.forced-route");
      if(var2 != null && NO_ROUTE.equals(var2)) {
         var2 = null;
      }

      return var2;
   }

   public static InetAddress getLocalAddress(HttpParams var0) {
      Args.notNull(var0, "Parameters");
      return (InetAddress)var0.getParameter("http.route.local-address");
   }
}

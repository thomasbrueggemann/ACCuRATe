package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public final class ConnManagerParams {
   private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = new ConnPerRoute() {
      public int getMaxForRoute(HttpRoute var1) {
         return 2;
      }
   };

   public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      ConnPerRoute var2 = (ConnPerRoute)var0.getParameter("http.conn-manager.max-per-route");
      if(var2 == null) {
         var2 = DEFAULT_CONN_PER_ROUTE;
      }

      return var2;
   }

   public static int getMaxTotalConnections(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getIntParameter("http.conn-manager.max-total", 20);
   }

   public static void setMaxConnectionsPerRoute(HttpParams var0, ConnPerRoute var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setParameter("http.conn-manager.max-per-route", var1);
   }

   public static void setMaxTotalConnections(HttpParams var0, int var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setIntParameter("http.conn-manager.max-total", var1);
   }

   @Deprecated
   public static void setTimeout(HttpParams var0, long var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setLongParameter("http.conn-manager.timeout", var1);
   }
}

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class ConnPerRouteBean implements ConnPerRoute {
   private volatile int defaultMax;
   private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap;

   public ConnPerRouteBean() {
      this(2);
   }

   public ConnPerRouteBean(int var1) {
      this.maxPerHostMap = new ConcurrentHashMap();
      this.setDefaultMaxPerRoute(var1);
   }

   public int getMaxForRoute(HttpRoute var1) {
      Args.notNull(var1, "HTTP route");
      Integer var3 = (Integer)this.maxPerHostMap.get(var1);
      return var3 != null?var3.intValue():this.defaultMax;
   }

   public void setDefaultMaxPerRoute(int var1) {
      Args.positive(var1, "Defautl max per route");
      this.defaultMax = var1;
   }

   public String toString() {
      return this.maxPerHostMap.toString();
   }
}

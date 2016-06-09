package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class HttpRoute implements RouteInfo, Cloneable {
   private final RouteInfo.LayerType layered;
   private final InetAddress localAddress;
   private final List<HttpHost> proxyChain;
   private final boolean secure;
   private final HttpHost targetHost;
   private final RouteInfo.TunnelType tunnelled;

   public HttpRoute(HttpHost var1) {
      this(var1, (InetAddress)null, (List)Collections.emptyList(), false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
   }

   public HttpRoute(HttpHost var1, InetAddress var2, HttpHost var3, boolean var4) {
      List var5 = Collections.singletonList(Args.notNull(var3, "Proxy host"));
      RouteInfo.TunnelType var6;
      if(var4) {
         var6 = RouteInfo.TunnelType.TUNNELLED;
      } else {
         var6 = RouteInfo.TunnelType.PLAIN;
      }

      RouteInfo.LayerType var7;
      if(var4) {
         var7 = RouteInfo.LayerType.LAYERED;
      } else {
         var7 = RouteInfo.LayerType.PLAIN;
      }

      this(var1, var2, var5, var4, var6, var7);
   }

   private HttpRoute(HttpHost var1, InetAddress var2, List<HttpHost> var3, boolean var4, RouteInfo.TunnelType var5, RouteInfo.LayerType var6) {
      Args.notNull(var1, "Target host");
      this.targetHost = var1;
      this.localAddress = var2;
      if(var3 != null && !var3.isEmpty()) {
         this.proxyChain = new ArrayList(var3);
      } else {
         this.proxyChain = null;
      }

      if(var5 == RouteInfo.TunnelType.TUNNELLED) {
         boolean var8;
         if(this.proxyChain != null) {
            var8 = true;
         } else {
            var8 = false;
         }

         Args.check(var8, "Proxy required if tunnelled");
      }

      this.secure = var4;
      if(var5 == null) {
         var5 = RouteInfo.TunnelType.PLAIN;
      }

      this.tunnelled = var5;
      if(var6 == null) {
         var6 = RouteInfo.LayerType.PLAIN;
      }

      this.layered = var6;
   }

   public HttpRoute(HttpHost var1, InetAddress var2, boolean var3) {
      this(var1, var2, Collections.emptyList(), var3, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
   }

   public HttpRoute(HttpHost var1, InetAddress var2, HttpHost[] var3, boolean var4, RouteInfo.TunnelType var5, RouteInfo.LayerType var6) {
      List var7;
      if(var3 != null) {
         var7 = Arrays.asList(var3);
      } else {
         var7 = null;
      }

      this(var1, var2, var7, var4, var5, var6);
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof HttpRoute)) {
            return false;
         }

         HttpRoute var2 = (HttpRoute)var1;
         if(this.secure != var2.secure || this.tunnelled != var2.tunnelled || this.layered != var2.layered || !LangUtils.equals(this.targetHost, var2.targetHost) || !LangUtils.equals(this.localAddress, var2.localAddress) || !LangUtils.equals(this.proxyChain, var2.proxyChain)) {
            return false;
         }
      }

      return true;
   }

   public final int getHopCount() {
      return this.proxyChain != null?1 + this.proxyChain.size():1;
   }

   public final HttpHost getHopTarget(int var1) {
      Args.notNegative(var1, "Hop index");
      int var3 = this.getHopCount();
      boolean var4;
      if(var1 < var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      Args.check(var4, "Hop index exceeds tracked route length");
      return var1 < var3 - 1?(HttpHost)this.proxyChain.get(var1):this.targetHost;
   }

   public final InetAddress getLocalAddress() {
      return this.localAddress;
   }

   public final HttpHost getProxyHost() {
      return this.proxyChain != null && !this.proxyChain.isEmpty()?(HttpHost)this.proxyChain.get(0):null;
   }

   public final HttpHost getTargetHost() {
      return this.targetHost;
   }

   public final int hashCode() {
      int var1 = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
      if(this.proxyChain != null) {
         for(Iterator var2 = this.proxyChain.iterator(); var2.hasNext(); var1 = LangUtils.hashCode(var1, (HttpHost)var2.next())) {
            ;
         }
      }

      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(var1, this.secure), this.tunnelled), this.layered);
   }

   public final boolean isLayered() {
      return this.layered == RouteInfo.LayerType.LAYERED;
   }

   public final boolean isSecure() {
      return this.secure;
   }

   public final boolean isTunnelled() {
      return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(50 + 30 * this.getHopCount());
      if(this.localAddress != null) {
         var1.append(this.localAddress);
         var1.append("->");
      }

      var1.append('{');
      if(this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
         var1.append('t');
      }

      if(this.layered == RouteInfo.LayerType.LAYERED) {
         var1.append('l');
      }

      if(this.secure) {
         var1.append('s');
      }

      var1.append("}->");
      if(this.proxyChain != null) {
         Iterator var5 = this.proxyChain.iterator();

         while(var5.hasNext()) {
            var1.append((HttpHost)var5.next());
            var1.append("->");
         }
      }

      var1.append(this.targetHost);
      return var1.toString();
   }
}

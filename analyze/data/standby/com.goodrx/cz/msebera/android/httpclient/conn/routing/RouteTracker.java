package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;

public final class RouteTracker implements RouteInfo, Cloneable {
   private boolean connected;
   private RouteInfo.LayerType layered;
   private final InetAddress localAddress;
   private HttpHost[] proxyChain;
   private boolean secure;
   private final HttpHost targetHost;
   private RouteInfo.TunnelType tunnelled;

   public RouteTracker(HttpHost var1, InetAddress var2) {
      Args.notNull(var1, "Target host");
      this.targetHost = var1;
      this.localAddress = var2;
      this.tunnelled = RouteInfo.TunnelType.PLAIN;
      this.layered = RouteInfo.LayerType.PLAIN;
   }

   public RouteTracker(HttpRoute var1) {
      this(var1.getTargetHost(), var1.getLocalAddress());
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public final void connectProxy(HttpHost var1, boolean var2) {
      Args.notNull(var1, "Proxy host");
      boolean var4;
      if(!this.connected) {
         var4 = true;
      } else {
         var4 = false;
      }

      Asserts.check(var4, "Already connected");
      this.connected = true;
      this.proxyChain = new HttpHost[]{var1};
      this.secure = var2;
   }

   public final void connectTarget(boolean var1) {
      boolean var2;
      if(!this.connected) {
         var2 = true;
      } else {
         var2 = false;
      }

      Asserts.check(var2, "Already connected");
      this.connected = true;
      this.secure = var1;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof RouteTracker)) {
            return false;
         }

         RouteTracker var2 = (RouteTracker)var1;
         if(this.connected != var2.connected || this.secure != var2.secure || this.tunnelled != var2.tunnelled || this.layered != var2.layered || !LangUtils.equals(this.targetHost, var2.targetHost) || !LangUtils.equals(this.localAddress, var2.localAddress) || !LangUtils.equals(this.proxyChain, var2.proxyChain)) {
            return false;
         }
      }

      return true;
   }

   public final int getHopCount() {
      boolean var1 = this.connected;
      byte var2 = 0;
      if(var1) {
         if(this.proxyChain != null) {
            return 1 + this.proxyChain.length;
         }

         var2 = 1;
      }

      return var2;
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
      return var1 < var3 - 1?this.proxyChain[var1]:this.targetHost;
   }

   public final InetAddress getLocalAddress() {
      return this.localAddress;
   }

   public final HttpHost getProxyHost() {
      return this.proxyChain == null?null:this.proxyChain[0];
   }

   public final HttpHost getTargetHost() {
      return this.targetHost;
   }

   public final int hashCode() {
      int var1 = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
      if(this.proxyChain != null) {
         HttpHost[] var2 = this.proxyChain;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            var1 = LangUtils.hashCode(var1, var2[var4]);
         }
      }

      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(var1, this.connected), this.secure), this.tunnelled), this.layered);
   }

   public final boolean isConnected() {
      return this.connected;
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

   public final void layerProtocol(boolean var1) {
      Asserts.check(this.connected, "No layered protocol unless connected");
      this.layered = RouteInfo.LayerType.LAYERED;
      this.secure = var1;
   }

   public void reset() {
      this.connected = false;
      this.proxyChain = null;
      this.tunnelled = RouteInfo.TunnelType.PLAIN;
      this.layered = RouteInfo.LayerType.PLAIN;
      this.secure = false;
   }

   public final HttpRoute toRoute() {
      return !this.connected?null:new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder(50 + 30 * this.getHopCount());
      var1.append("RouteTracker[");
      if(this.localAddress != null) {
         var1.append(this.localAddress);
         var1.append("->");
      }

      var1.append('{');
      if(this.connected) {
         var1.append('c');
      }

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
         HttpHost[] var7 = this.proxyChain;
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            var1.append(var7[var9]);
            var1.append("->");
         }
      }

      var1.append(this.targetHost);
      var1.append(']');
      return var1.toString();
   }

   public final void tunnelProxy(HttpHost var1, boolean var2) {
      Args.notNull(var1, "Proxy host");
      Asserts.check(this.connected, "No tunnel unless connected");
      Asserts.notNull(this.proxyChain, "No tunnel without proxy");
      HttpHost[] var4 = new HttpHost[1 + this.proxyChain.length];
      System.arraycopy(this.proxyChain, 0, var4, 0, this.proxyChain.length);
      var4[-1 + var4.length] = var1;
      this.proxyChain = var4;
      this.secure = var2;
   }

   public final void tunnelTarget(boolean var1) {
      Asserts.check(this.connected, "No tunnel unless connected");
      Asserts.notNull(this.proxyChain, "No tunnel without proxy");
      this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
      this.secure = var1;
   }
}

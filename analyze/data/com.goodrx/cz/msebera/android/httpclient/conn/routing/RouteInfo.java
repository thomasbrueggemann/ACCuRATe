package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpHost;
import java.net.InetAddress;

public interface RouteInfo {
   int getHopCount();

   HttpHost getHopTarget(int var1);

   InetAddress getLocalAddress();

   HttpHost getProxyHost();

   HttpHost getTargetHost();

   boolean isLayered();

   boolean isSecure();

   boolean isTunnelled();

   public static enum LayerType {
      LAYERED,
      PLAIN;

      static {
         RouteInfo.LayerType[] var0 = new RouteInfo.LayerType[]{PLAIN, LAYERED};
      }
   }

   public static enum TunnelType {
      PLAIN,
      TUNNELLED;

      static {
         RouteInfo.TunnelType[] var0 = new RouteInfo.TunnelType[]{PLAIN, TUNNELLED};
      }
   }
}

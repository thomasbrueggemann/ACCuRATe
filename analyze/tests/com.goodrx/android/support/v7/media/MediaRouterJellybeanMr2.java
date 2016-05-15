package android.support.v7.media;

import android.media.MediaRouter.Callback;

final class MediaRouterJellybeanMr2 {
   public static void addCallback(Object var0, int var1, Object var2, int var3) {
      ((android.media.MediaRouter)var0).addCallback(var1, (Callback)var2, var3);
   }

   public static Object getDefaultRoute(Object var0) {
      return ((android.media.MediaRouter)var0).getDefaultRoute();
   }

   public static final class RouteInfo {
      public static CharSequence getDescription(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getDescription();
      }

      public static boolean isConnecting(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).isConnecting();
      }
   }

   public static final class UserRouteInfo {
      public static void setDescription(Object var0, CharSequence var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setDescription(var1);
      }
   }
}

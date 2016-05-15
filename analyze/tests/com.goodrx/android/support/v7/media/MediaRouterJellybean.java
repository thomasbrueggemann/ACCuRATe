package android.support.v7.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.RemoteControlClient;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class MediaRouterJellybean {
   public static final int ALL_ROUTE_TYPES = 8388611;
   public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
   public static final int ROUTE_TYPE_LIVE_VIDEO = 2;
   public static final int ROUTE_TYPE_USER = 8388608;
   private static final String TAG = "MediaRouterJellybean";

   public static void addCallback(Object var0, int var1, Object var2) {
      ((android.media.MediaRouter)var0).addCallback(var1, (android.media.MediaRouter.Callback)var2);
   }

   public static void addUserRoute(Object var0, Object var1) {
      ((android.media.MediaRouter)var0).addUserRoute((android.media.MediaRouter.UserRouteInfo)var1);
   }

   public static Object createCallback(MediaRouterJellybean.Callback var0) {
      return new MediaRouterJellybean.CallbackProxy(var0);
   }

   public static Object createRouteCategory(Object var0, String var1, boolean var2) {
      return ((android.media.MediaRouter)var0).createRouteCategory(var1, var2);
   }

   public static Object createUserRoute(Object var0, Object var1) {
      return ((android.media.MediaRouter)var0).createUserRoute((android.media.MediaRouter.RouteCategory)var1);
   }

   public static Object createVolumeCallback(MediaRouterJellybean.VolumeCallback var0) {
      return new MediaRouterJellybean.VolumeCallbackProxy(var0);
   }

   public static List getCategories(Object var0) {
      android.media.MediaRouter var1 = (android.media.MediaRouter)var0;
      int var2 = var1.getCategoryCount();
      ArrayList var3 = new ArrayList(var2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.add(var1.getCategoryAt(var4));
      }

      return var3;
   }

   public static Object getMediaRouter(Context var0) {
      return var0.getSystemService("media_router");
   }

   public static List getRoutes(Object var0) {
      android.media.MediaRouter var1 = (android.media.MediaRouter)var0;
      int var2 = var1.getRouteCount();
      ArrayList var3 = new ArrayList(var2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.add(var1.getRouteAt(var4));
      }

      return var3;
   }

   public static Object getSelectedRoute(Object var0, int var1) {
      return ((android.media.MediaRouter)var0).getSelectedRoute(var1);
   }

   public static void removeCallback(Object var0, Object var1) {
      ((android.media.MediaRouter)var0).removeCallback((android.media.MediaRouter.Callback)var1);
   }

   public static void removeUserRoute(Object var0, Object var1) {
      ((android.media.MediaRouter)var0).removeUserRoute((android.media.MediaRouter.UserRouteInfo)var1);
   }

   public static void selectRoute(Object var0, int var1, Object var2) {
      ((android.media.MediaRouter)var0).selectRoute(var1, (android.media.MediaRouter.RouteInfo)var2);
   }

   public interface Callback {
      void onRouteAdded(Object var1);

      void onRouteChanged(Object var1);

      void onRouteGrouped(Object var1, Object var2, int var3);

      void onRouteRemoved(Object var1);

      void onRouteSelected(int var1, Object var2);

      void onRouteUngrouped(Object var1, Object var2);

      void onRouteUnselected(int var1, Object var2);

      void onRouteVolumeChanged(Object var1);
   }

   static class CallbackProxy<T extends MediaRouterJellybean.Callback> extends android.media.MediaRouter.Callback {
      protected final T mCallback;

      public CallbackProxy(T var1) {
         this.mCallback = var1;
      }

      public void onRouteAdded(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2) {
         this.mCallback.onRouteAdded(var2);
      }

      public void onRouteChanged(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2) {
         this.mCallback.onRouteChanged(var2);
      }

      public void onRouteGrouped(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2, android.media.MediaRouter.RouteGroup var3, int var4) {
         this.mCallback.onRouteGrouped(var2, var3, var4);
      }

      public void onRouteRemoved(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2) {
         this.mCallback.onRouteRemoved(var2);
      }

      public void onRouteSelected(android.media.MediaRouter var1, int var2, android.media.MediaRouter.RouteInfo var3) {
         this.mCallback.onRouteSelected(var2, var3);
      }

      public void onRouteUngrouped(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2, android.media.MediaRouter.RouteGroup var3) {
         this.mCallback.onRouteUngrouped(var2, var3);
      }

      public void onRouteUnselected(android.media.MediaRouter var1, int var2, android.media.MediaRouter.RouteInfo var3) {
         this.mCallback.onRouteUnselected(var2, var3);
      }

      public void onRouteVolumeChanged(android.media.MediaRouter var1, android.media.MediaRouter.RouteInfo var2) {
         this.mCallback.onRouteVolumeChanged(var2);
      }
   }

   public static final class GetDefaultRouteWorkaround {
      private Method mGetSystemAudioRouteMethod;

      public GetDefaultRouteWorkaround() {
         if(VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 17) {
            try {
               this.mGetSystemAudioRouteMethod = android.media.MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException var2) {
               ;
            }
         } else {
            throw new UnsupportedOperationException();
         }
      }

      public Object getDefaultRoute(Object var1) {
         android.media.MediaRouter var2 = (android.media.MediaRouter)var1;
         if(this.mGetSystemAudioRouteMethod != null) {
            try {
               Object var5 = this.mGetSystemAudioRouteMethod.invoke(var2, new Object[0]);
               return var5;
            } catch (IllegalAccessException var6) {
               ;
            } catch (InvocationTargetException var7) {
               ;
            }
         }

         return var2.getRouteAt(0);
      }
   }

   public static final class RouteCategory {
      public static CharSequence getName(Object var0, Context var1) {
         return ((android.media.MediaRouter.RouteCategory)var0).getName(var1);
      }

      public static List getRoutes(Object var0) {
         ArrayList var1 = new ArrayList();
         ((android.media.MediaRouter.RouteCategory)var0).getRoutes(var1);
         return var1;
      }

      public static int getSupportedTypes(Object var0) {
         return ((android.media.MediaRouter.RouteCategory)var0).getSupportedTypes();
      }

      public static boolean isGroupable(Object var0) {
         return ((android.media.MediaRouter.RouteCategory)var0).isGroupable();
      }
   }

   public static final class RouteGroup {
      public static List getGroupedRoutes(Object var0) {
         android.media.MediaRouter.RouteGroup var1 = (android.media.MediaRouter.RouteGroup)var0;
         int var2 = var1.getRouteCount();
         ArrayList var3 = new ArrayList(var2);

         for(int var4 = 0; var4 < var2; ++var4) {
            var3.add(var1.getRouteAt(var4));
         }

         return var3;
      }
   }

   public static final class RouteInfo {
      public static Object getCategory(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getCategory();
      }

      public static Object getGroup(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getGroup();
      }

      public static Drawable getIconDrawable(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getIconDrawable();
      }

      public static CharSequence getName(Object var0, Context var1) {
         return ((android.media.MediaRouter.RouteInfo)var0).getName(var1);
      }

      public static int getPlaybackStream(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getPlaybackStream();
      }

      public static int getPlaybackType(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getPlaybackType();
      }

      public static CharSequence getStatus(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getStatus();
      }

      public static int getSupportedTypes(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getSupportedTypes();
      }

      public static Object getTag(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getTag();
      }

      public static int getVolume(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getVolume();
      }

      public static int getVolumeHandling(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getVolumeHandling();
      }

      public static int getVolumeMax(Object var0) {
         return ((android.media.MediaRouter.RouteInfo)var0).getVolumeMax();
      }

      public static boolean isGroup(Object var0) {
         return var0 instanceof android.media.MediaRouter.RouteGroup;
      }

      public static void requestSetVolume(Object var0, int var1) {
         ((android.media.MediaRouter.RouteInfo)var0).requestSetVolume(var1);
      }

      public static void requestUpdateVolume(Object var0, int var1) {
         ((android.media.MediaRouter.RouteInfo)var0).requestUpdateVolume(var1);
      }

      public static void setTag(Object var0, Object var1) {
         ((android.media.MediaRouter.RouteInfo)var0).setTag(var1);
      }
   }

   public static final class SelectRouteWorkaround {
      private Method mSelectRouteIntMethod;

      public SelectRouteWorkaround() {
         if(VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 17) {
            try {
               Class[] var2 = new Class[]{Integer.TYPE, android.media.MediaRouter.RouteInfo.class};
               this.mSelectRouteIntMethod = android.media.MediaRouter.class.getMethod("selectRouteInt", var2);
            } catch (NoSuchMethodException var3) {
               ;
            }
         } else {
            throw new UnsupportedOperationException();
         }
      }

      public void selectRoute(Object var1, int var2, Object var3) {
         android.media.MediaRouter var4 = (android.media.MediaRouter)var1;
         android.media.MediaRouter.RouteInfo var5 = (android.media.MediaRouter.RouteInfo)var3;
         if((8388608 & var5.getSupportedTypes()) == 0) {
            if(this.mSelectRouteIntMethod != null) {
               try {
                  Method var11 = this.mSelectRouteIntMethod;
                  Object[] var12 = new Object[]{Integer.valueOf(var2), var5};
                  var11.invoke(var4, var12);
                  return;
               } catch (IllegalAccessException var13) {
                  Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", var13);
               } catch (InvocationTargetException var14) {
                  Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", var14);
               }
            } else {
               Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
            }
         }

         var4.selectRoute(var2, var5);
      }
   }

   public static final class UserRouteInfo {
      public static void setIconDrawable(Object var0, Drawable var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setIconDrawable(var1);
      }

      public static void setName(Object var0, CharSequence var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setName(var1);
      }

      public static void setPlaybackStream(Object var0, int var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setPlaybackStream(var1);
      }

      public static void setPlaybackType(Object var0, int var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setPlaybackType(var1);
      }

      public static void setRemoteControlClient(Object var0, Object var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setRemoteControlClient((RemoteControlClient)var1);
      }

      public static void setStatus(Object var0, CharSequence var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setStatus(var1);
      }

      public static void setVolume(Object var0, int var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setVolume(var1);
      }

      public static void setVolumeCallback(Object var0, Object var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setVolumeCallback((android.media.MediaRouter.VolumeCallback)var1);
      }

      public static void setVolumeHandling(Object var0, int var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setVolumeHandling(var1);
      }

      public static void setVolumeMax(Object var0, int var1) {
         ((android.media.MediaRouter.UserRouteInfo)var0).setVolumeMax(var1);
      }
   }

   public interface VolumeCallback {
      void onVolumeSetRequest(Object var1, int var2);

      void onVolumeUpdateRequest(Object var1, int var2);
   }

   static class VolumeCallbackProxy<T extends MediaRouterJellybean.VolumeCallback> extends android.media.MediaRouter.VolumeCallback {
      protected final T mCallback;

      public VolumeCallbackProxy(T var1) {
         this.mCallback = var1;
      }

      public void onVolumeSetRequest(android.media.MediaRouter.RouteInfo var1, int var2) {
         this.mCallback.onVolumeSetRequest(var1, var2);
      }

      public void onVolumeUpdateRequest(android.media.MediaRouter.RouteInfo var1, int var2) {
         this.mCallback.onVolumeUpdateRequest(var1, var2);
      }
   }
}

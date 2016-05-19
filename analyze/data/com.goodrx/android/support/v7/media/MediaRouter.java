package android.support.v7.media;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.media.MediaRouteDescriptor;
import android.support.v7.media.MediaRouteDiscoveryRequest;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.RegisteredMediaRouteProviderWatcher;
import android.support.v7.media.RemoteControlClientCompat;
import android.support.v7.media.SystemMediaRouteProvider;
import android.util.Log;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class MediaRouter {
   public static final int AVAILABILITY_FLAG_IGNORE_DEFAULT_ROUTE = 1;
   public static final int AVAILABILITY_FLAG_REQUIRE_MATCH = 2;
   public static final int CALLBACK_FLAG_FORCE_DISCOVERY = 8;
   public static final int CALLBACK_FLAG_PERFORM_ACTIVE_SCAN = 1;
   public static final int CALLBACK_FLAG_REQUEST_DISCOVERY = 4;
   public static final int CALLBACK_FLAG_UNFILTERED_EVENTS = 2;
   private static final boolean DEBUG = Log.isLoggable("MediaRouter", 3);
   private static final String TAG = "MediaRouter";
   public static final int UNSELECT_REASON_DISCONNECTED = 1;
   public static final int UNSELECT_REASON_ROUTE_CHANGED = 3;
   public static final int UNSELECT_REASON_STOPPED = 2;
   public static final int UNSELECT_REASON_UNKNOWN;
   static MediaRouter.GlobalMediaRouter sGlobal;
   final ArrayList<MediaRouter.CallbackRecord> mCallbackRecords = new ArrayList();
   final Context mContext;

   MediaRouter(Context var1) {
      this.mContext = var1;
   }

   static void checkCallingThread() {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException("The media router service must only be accessed on the application\'s main thread.");
      }
   }

   static <T> boolean equal(T var0, T var1) {
      return var0 == var1 || var0 != null && var1 != null && var0.equals(var1);
   }

   private int findCallbackRecord(MediaRouter.Callback var1) {
      int var2 = this.mCallbackRecords.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         if(((MediaRouter.CallbackRecord)this.mCallbackRecords.get(var3)).mCallback == var1) {
            return var3;
         }
      }

      return -1;
   }

   public static MediaRouter getInstance(@NonNull Context var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else {
         checkCallingThread();
         if(sGlobal == null) {
            sGlobal = new MediaRouter.GlobalMediaRouter(var0.getApplicationContext());
            sGlobal.start();
         }

         return sGlobal.getRouter(var0);
      }
   }

   public void addCallback(MediaRouteSelector var1, MediaRouter.Callback var2) {
      this.addCallback(var1, var2, 0);
   }

   public void addCallback(@NonNull MediaRouteSelector var1, @NonNull MediaRouter.Callback var2, int var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("callback must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "addCallback: selector=" + var1 + ", callback=" + var2 + ", flags=" + Integer.toHexString(var3));
         }

         int var4 = this.findCallbackRecord(var2);
         MediaRouter.CallbackRecord var5;
         if(var4 < 0) {
            var5 = new MediaRouter.CallbackRecord(this, var2);
            this.mCallbackRecords.add(var5);
         } else {
            var5 = (MediaRouter.CallbackRecord)this.mCallbackRecords.get(var4);
         }

         int var7 = var3 & ~var5.mFlags;
         boolean var8 = false;
         if(var7 != 0) {
            var5.mFlags |= var3;
            var8 = true;
         }

         if(!var5.mSelector.contains(var1)) {
            var5.mSelector = (new MediaRouteSelector.Builder(var5.mSelector)).addSelector(var1).build();
            var8 = true;
         }

         if(var8) {
            sGlobal.updateDiscoveryRequest();
         }

      }
   }

   public void addProvider(@NonNull MediaRouteProvider var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("providerInstance must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "addProvider: " + var1);
         }

         sGlobal.addProvider(var1);
      }
   }

   public void addRemoteControlClient(@NonNull Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("remoteControlClient must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "addRemoteControlClient: " + var1);
         }

         sGlobal.addRemoteControlClient(var1);
      }
   }

   @NonNull
   public MediaRouter.RouteInfo getDefaultRoute() {
      checkCallingThread();
      return sGlobal.getDefaultRoute();
   }

   public MediaSessionCompat.Token getMediaSessionToken() {
      return sGlobal.getMediaSessionToken();
   }

   public List<MediaRouter.ProviderInfo> getProviders() {
      checkCallingThread();
      return sGlobal.getProviders();
   }

   public List<MediaRouter.RouteInfo> getRoutes() {
      checkCallingThread();
      return sGlobal.getRoutes();
   }

   @NonNull
   public MediaRouter.RouteInfo getSelectedRoute() {
      checkCallingThread();
      return sGlobal.getSelectedRoute();
   }

   public boolean isRouteAvailable(@NonNull MediaRouteSelector var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         checkCallingThread();
         return sGlobal.isRouteAvailable(var1, var2);
      }
   }

   public void removeCallback(@NonNull MediaRouter.Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "removeCallback: callback=" + var1);
         }

         int var2 = this.findCallbackRecord(var1);
         if(var2 >= 0) {
            this.mCallbackRecords.remove(var2);
            sGlobal.updateDiscoveryRequest();
         }

      }
   }

   public void removeProvider(@NonNull MediaRouteProvider var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("providerInstance must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "removeProvider: " + var1);
         }

         sGlobal.removeProvider(var1);
      }
   }

   public void removeRemoteControlClient(@NonNull Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("remoteControlClient must not be null");
      } else {
         if(DEBUG) {
            Log.d("MediaRouter", "removeRemoteControlClient: " + var1);
         }

         sGlobal.removeRemoteControlClient(var1);
      }
   }

   public void selectRoute(@NonNull MediaRouter.RouteInfo var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("route must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "selectRoute: " + var1);
         }

         sGlobal.selectRoute(var1);
      }
   }

   public void setMediaSession(Object var1) {
      if(DEBUG) {
         Log.d("MediaRouter", "addMediaSession: " + var1);
      }

      sGlobal.setMediaSession(var1);
   }

   public void setMediaSessionCompat(MediaSessionCompat var1) {
      if(DEBUG) {
         Log.d("MediaRouter", "addMediaSessionCompat: " + var1);
      }

      sGlobal.setMediaSessionCompat(var1);
   }

   public void unselect(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         checkCallingThread();
         sGlobal.selectRoute(this.getDefaultRoute(), var1);
      } else {
         throw new IllegalArgumentException("Unsupported reason to unselect route");
      }
   }

   @NonNull
   public MediaRouter.RouteInfo updateSelectedRoute(@NonNull MediaRouteSelector var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         checkCallingThread();
         if(DEBUG) {
            Log.d("MediaRouter", "updateSelectedRoute: " + var1);
         }

         MediaRouter.RouteInfo var2 = sGlobal.getSelectedRoute();
         if(!var2.isDefault() && !var2.matchesSelector(var1)) {
            var2 = sGlobal.getDefaultRoute();
            sGlobal.selectRoute(var2);
         }

         return var2;
      }
   }

   public abstract static class Callback {
      public void onProviderAdded(MediaRouter var1, MediaRouter.ProviderInfo var2) {
      }

      public void onProviderChanged(MediaRouter var1, MediaRouter.ProviderInfo var2) {
      }

      public void onProviderRemoved(MediaRouter var1, MediaRouter.ProviderInfo var2) {
      }

      public void onRouteAdded(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRouteChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRoutePresentationDisplayChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRouteRemoved(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRouteSelected(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRouteUnselected(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }

      public void onRouteVolumeChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
      }
   }

   private static final class CallbackRecord {
      public final MediaRouter.Callback mCallback;
      public int mFlags;
      public final MediaRouter mRouter;
      public MediaRouteSelector mSelector;

      public CallbackRecord(MediaRouter var1, MediaRouter.Callback var2) {
         this.mRouter = var1;
         this.mCallback = var2;
         this.mSelector = MediaRouteSelector.EMPTY;
      }

      public boolean filterRouteEvent(MediaRouter.RouteInfo var1) {
         return (2 & this.mFlags) != 0 || var1.matchesSelector(this.mSelector);
      }
   }

   public abstract static class ControlRequestCallback {
      public void onError(String var1, Bundle var2) {
      }

      public void onResult(Bundle var1) {
      }
   }

   private static final class GlobalMediaRouter implements RegisteredMediaRouteProviderWatcher.Callback, SystemMediaRouteProvider.SyncCallback {
      private final Context mApplicationContext;
      private final MediaRouter.CallbackHandler mCallbackHandler = new MediaRouter.CallbackHandler();
      private MediaSessionCompat mCompatSession;
      private MediaRouter.RouteInfo mDefaultRoute;
      private MediaRouteDiscoveryRequest mDiscoveryRequest;
      private final DisplayManagerCompat mDisplayManager;
      private final boolean mLowRam;
      private MediaRouter.MediaSessionRecord mMediaSession;
      private final RemoteControlClientCompat.PlaybackInfo mPlaybackInfo = new RemoteControlClientCompat.PlaybackInfo();
      private final MediaRouter.ProviderCallback mProviderCallback = new MediaRouter.ProviderCallback();
      private final ArrayList<MediaRouter.ProviderInfo> mProviders = new ArrayList();
      private MediaSessionCompat mRccMediaSession;
      private RegisteredMediaRouteProviderWatcher mRegisteredProviderWatcher;
      private final ArrayList<MediaRouter.RemoteControlClientRecord> mRemoteControlClients = new ArrayList();
      private final ArrayList<WeakReference<MediaRouter>> mRouters = new ArrayList();
      private final ArrayList<MediaRouter.RouteInfo> mRoutes = new ArrayList();
      private MediaRouter.RouteInfo mSelectedRoute;
      private MediaRouteProvider.RouteController mSelectedRouteController;
      private MediaSessionCompat.OnActiveChangeListener mSessionActiveListener = new MediaSessionCompat.OnActiveChangeListener() {
         public void onActiveChanged() {
            if(GlobalMediaRouter.this.mRccMediaSession != null) {
               if(!GlobalMediaRouter.this.mRccMediaSession.isActive()) {
                  GlobalMediaRouter.this.removeRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
                  return;
               }

               GlobalMediaRouter.this.addRemoteControlClient(GlobalMediaRouter.this.mRccMediaSession.getRemoteControlClient());
            }

         }
      };
      private final SystemMediaRouteProvider mSystemProvider;

      GlobalMediaRouter(Context var1) {
         this.mApplicationContext = var1;
         this.mDisplayManager = DisplayManagerCompat.getInstance(var1);
         this.mLowRam = ActivityManagerCompat.isLowRamDevice((ActivityManager)var1.getSystemService("activity"));
         this.mSystemProvider = SystemMediaRouteProvider.obtain(var1, this);
         this.addProvider(this.mSystemProvider);
      }

      // $FF: synthetic method
      static ArrayList access$1500(MediaRouter.GlobalMediaRouter var0) {
         return var0.mRouters;
      }

      private String assignRouteUniqueId(MediaRouter.ProviderInfo var1, String var2) {
         String var3 = var1.getComponentName().flattenToShortString() + ":" + var2;
         if(this.findRouteByUniqueId(var3) < 0) {
            return var3;
         } else {
            int var4 = 2;

            while(true) {
               Locale var5 = Locale.US;
               Object[] var6 = new Object[]{var3, Integer.valueOf(var4)};
               String var7 = String.format(var5, "%s_%d", var6);
               if(this.findRouteByUniqueId(var7) < 0) {
                  return var7;
               }

               ++var4;
            }
         }
      }

      private MediaRouter.RouteInfo chooseFallbackRoute() {
         Iterator var1 = this.mRoutes.iterator();

         MediaRouter.RouteInfo var2;
         do {
            if(!var1.hasNext()) {
               return this.mDefaultRoute;
            }

            var2 = (MediaRouter.RouteInfo)var1.next();
         } while(var2 == this.mDefaultRoute || !this.isSystemLiveAudioOnlyRoute(var2) || !this.isRouteSelectable(var2));

         return var2;
      }

      private int findProviderInfo(MediaRouteProvider var1) {
         int var2 = this.mProviders.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((MediaRouter.ProviderInfo)this.mProviders.get(var3)).mProviderInstance == var1) {
               return var3;
            }
         }

         return -1;
      }

      private int findRemoteControlClientRecord(Object var1) {
         int var2 = this.mRemoteControlClients.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((MediaRouter.RemoteControlClientRecord)this.mRemoteControlClients.get(var3)).getRemoteControlClient() == var1) {
               return var3;
            }
         }

         return -1;
      }

      private int findRouteByUniqueId(String var1) {
         int var2 = this.mRoutes.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((MediaRouter.RouteInfo)this.mRoutes.get(var3)).mUniqueId.equals(var1)) {
               return var3;
            }
         }

         return -1;
      }

      private boolean isRouteSelectable(MediaRouter.RouteInfo var1) {
         return var1.mDescriptor != null && var1.mEnabled;
      }

      private boolean isSystemDefaultRoute(MediaRouter.RouteInfo var1) {
         return var1.getProviderInstance() == this.mSystemProvider && var1.mDescriptorId.equals("DEFAULT_ROUTE");
      }

      private boolean isSystemLiveAudioOnlyRoute(MediaRouter.RouteInfo var1) {
         return var1.getProviderInstance() == this.mSystemProvider && var1.supportsControlCategory("android.media.intent.category.LIVE_AUDIO") && !var1.supportsControlCategory("android.media.intent.category.LIVE_VIDEO");
      }

      private void setSelectedRouteInternal(MediaRouter.RouteInfo var1, int var2) {
         if(this.mSelectedRoute != var1) {
            if(this.mSelectedRoute != null) {
               if(MediaRouter.DEBUG) {
                  Log.d("MediaRouter", "Route unselected: " + this.mSelectedRoute + " reason: " + var2);
               }

               this.mCallbackHandler.post(263, this.mSelectedRoute);
               if(this.mSelectedRouteController != null) {
                  this.mSelectedRouteController.onUnselect(var2);
                  this.mSelectedRouteController.onRelease();
                  this.mSelectedRouteController = null;
               }
            }

            this.mSelectedRoute = var1;
            if(this.mSelectedRoute != null) {
               this.mSelectedRouteController = var1.getProviderInstance().onCreateRouteController(var1.mDescriptorId);
               if(this.mSelectedRouteController != null) {
                  this.mSelectedRouteController.onSelect();
               }

               if(MediaRouter.DEBUG) {
                  Log.d("MediaRouter", "Route selected: " + this.mSelectedRoute);
               }

               this.mCallbackHandler.post(262, this.mSelectedRoute);
            }

            this.updatePlaybackInfoFromSelectedRoute();
         }

      }

      private void updatePlaybackInfoFromSelectedRoute() {
         if(this.mSelectedRoute != null) {
            this.mPlaybackInfo.volume = this.mSelectedRoute.getVolume();
            this.mPlaybackInfo.volumeMax = this.mSelectedRoute.getVolumeMax();
            this.mPlaybackInfo.volumeHandling = this.mSelectedRoute.getVolumeHandling();
            this.mPlaybackInfo.playbackStream = this.mSelectedRoute.getPlaybackStream();
            this.mPlaybackInfo.playbackType = this.mSelectedRoute.getPlaybackType();
            int var1 = this.mRemoteControlClients.size();

            for(int var2 = 0; var2 < var1; ++var2) {
               ((MediaRouter.RemoteControlClientRecord)this.mRemoteControlClients.get(var2)).updatePlaybackInfo();
            }

            if(this.mMediaSession != null) {
               if(this.mSelectedRoute != this.getDefaultRoute()) {
                  int var3 = this.mPlaybackInfo.volumeHandling;
                  byte var4 = 0;
                  if(var3 == 1) {
                     var4 = 2;
                  }

                  this.mMediaSession.configureVolume(var4, this.mPlaybackInfo.volumeMax, this.mPlaybackInfo.volume);
                  return;
               }

               this.mMediaSession.clearVolumeHandling();
            }
         } else if(this.mMediaSession != null) {
            this.mMediaSession.clearVolumeHandling();
            return;
         }

      }

      private void updateProviderContents(MediaRouter.ProviderInfo var1, MediaRouteProviderDescriptor var2) {
         if(var1.updateDescriptor(var2)) {
            boolean var3 = false;
            int var4 = 0;
            if(var2 != null) {
               if(!var2.isValid()) {
                  Log.w("MediaRouter", "Ignoring invalid provider descriptor: " + var2);
                  var3 = false;
                  var4 = 0;
               } else {
                  List var14 = var2.getRoutes();
                  int var15 = var14.size();
                  int var16 = 0;

                  int var17;
                  int var23;
                  for(var17 = 0; var16 < var15; var17 = var23) {
                     MediaRouteDescriptor var18 = (MediaRouteDescriptor)var14.get(var16);
                     String var19 = var18.getId();
                     int var20 = var1.findRouteByDescriptorId(var19);
                     if(var20 < 0) {
                        MediaRouter.RouteInfo var21 = new MediaRouter.RouteInfo(var1, var19, this.assignRouteUniqueId(var1, var19));
                        ArrayList var22 = var1.mRoutes;
                        var23 = var17 + 1;
                        var22.add(var17, var21);
                        this.mRoutes.add(var21);
                        var21.updateDescriptor(var18);
                        if(MediaRouter.DEBUG) {
                           Log.d("MediaRouter", "Route added: " + var21);
                        }

                        this.mCallbackHandler.post(257, var21);
                     } else if(var20 < var17) {
                        Log.w("MediaRouter", "Ignoring route descriptor with duplicate id: " + var18);
                        var23 = var17;
                     } else {
                        MediaRouter.RouteInfo var27 = (MediaRouter.RouteInfo)var1.mRoutes.get(var20);
                        ArrayList var28 = var1.mRoutes;
                        var23 = var17 + 1;
                        Collections.swap(var28, var20, var17);
                        int var29 = var27.updateDescriptor(var18);
                        if(var29 != 0) {
                           if((var29 & 1) != 0) {
                              if(MediaRouter.DEBUG) {
                                 Log.d("MediaRouter", "Route changed: " + var27);
                              }

                              this.mCallbackHandler.post(259, var27);
                           }

                           if((var29 & 2) != 0) {
                              if(MediaRouter.DEBUG) {
                                 Log.d("MediaRouter", "Route volume changed: " + var27);
                              }

                              this.mCallbackHandler.post(260, var27);
                           }

                           if((var29 & 4) != 0) {
                              if(MediaRouter.DEBUG) {
                                 Log.d("MediaRouter", "Route presentation display changed: " + var27);
                              }

                              this.mCallbackHandler.post(261, var27);
                           }

                           if(var27 == this.mSelectedRoute) {
                              var3 = true;
                           }
                        }
                     }

                     ++var16;
                  }

                  var4 = var17;
               }
            }

            for(int var5 = -1 + var1.mRoutes.size(); var5 >= var4; --var5) {
               MediaRouter.RouteInfo var10 = (MediaRouter.RouteInfo)var1.mRoutes.get(var5);
               var10.updateDescriptor((MediaRouteDescriptor)null);
               this.mRoutes.remove(var10);
            }

            this.updateSelectedRouteIfNeeded(var3);

            for(int var6 = -1 + var1.mRoutes.size(); var6 >= var4; --var6) {
               MediaRouter.RouteInfo var8 = (MediaRouter.RouteInfo)var1.mRoutes.remove(var6);
               if(MediaRouter.DEBUG) {
                  Log.d("MediaRouter", "Route removed: " + var8);
               }

               this.mCallbackHandler.post(258, var8);
            }

            if(MediaRouter.DEBUG) {
               Log.d("MediaRouter", "Provider changed: " + var1);
            }

            this.mCallbackHandler.post(515, var1);
         }

      }

      private void updateProviderDescriptor(MediaRouteProvider var1, MediaRouteProviderDescriptor var2) {
         int var3 = this.findProviderInfo(var1);
         if(var3 >= 0) {
            this.updateProviderContents((MediaRouter.ProviderInfo)this.mProviders.get(var3), var2);
         }

      }

      private void updateSelectedRouteIfNeeded(boolean var1) {
         if(this.mDefaultRoute != null && !this.isRouteSelectable(this.mDefaultRoute)) {
            Log.i("MediaRouter", "Clearing the default route because it is no longer selectable: " + this.mDefaultRoute);
            this.mDefaultRoute = null;
         }

         if(this.mDefaultRoute == null && !this.mRoutes.isEmpty()) {
            Iterator var3 = this.mRoutes.iterator();

            while(var3.hasNext()) {
               MediaRouter.RouteInfo var4 = (MediaRouter.RouteInfo)var3.next();
               if(this.isSystemDefaultRoute(var4) && this.isRouteSelectable(var4)) {
                  this.mDefaultRoute = var4;
                  Log.i("MediaRouter", "Found default route: " + this.mDefaultRoute);
                  break;
               }
            }
         }

         if(this.mSelectedRoute != null && !this.isRouteSelectable(this.mSelectedRoute)) {
            Log.i("MediaRouter", "Unselecting the current route because it is no longer selectable: " + this.mSelectedRoute);
            this.setSelectedRouteInternal((MediaRouter.RouteInfo)null, 0);
         }

         if(this.mSelectedRoute == null) {
            this.setSelectedRouteInternal(this.chooseFallbackRoute(), 0);
         } else if(var1) {
            this.updatePlaybackInfoFromSelectedRoute();
            return;
         }

      }

      public void addProvider(MediaRouteProvider var1) {
         if(this.findProviderInfo(var1) < 0) {
            MediaRouter.ProviderInfo var2 = new MediaRouter.ProviderInfo(var1);
            this.mProviders.add(var2);
            if(MediaRouter.DEBUG) {
               Log.d("MediaRouter", "Provider added: " + var2);
            }

            this.mCallbackHandler.post(513, var2);
            this.updateProviderContents(var2, var1.getDescriptor());
            var1.setCallback(this.mProviderCallback);
            var1.setDiscoveryRequest(this.mDiscoveryRequest);
         }

      }

      public void addRemoteControlClient(Object var1) {
         if(this.findRemoteControlClientRecord(var1) < 0) {
            MediaRouter.RemoteControlClientRecord var2 = new MediaRouter.RemoteControlClientRecord(var1);
            this.mRemoteControlClients.add(var2);
         }

      }

      public ContentResolver getContentResolver() {
         return this.mApplicationContext.getContentResolver();
      }

      public MediaRouter.RouteInfo getDefaultRoute() {
         if(this.mDefaultRoute == null) {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
         } else {
            return this.mDefaultRoute;
         }
      }

      public Display getDisplay(int var1) {
         return this.mDisplayManager.getDisplay(var1);
      }

      public MediaSessionCompat.Token getMediaSessionToken() {
         return this.mMediaSession != null?this.mMediaSession.getToken():(this.mCompatSession != null?this.mCompatSession.getSessionToken():null);
      }

      public Context getProviderContext(String var1) {
         if(var1.equals("android")) {
            return this.mApplicationContext;
         } else {
            try {
               Context var3 = this.mApplicationContext.createPackageContext(var1, 4);
               return var3;
            } catch (NameNotFoundException var4) {
               return null;
            }
         }
      }

      public List<MediaRouter.ProviderInfo> getProviders() {
         return this.mProviders;
      }

      public MediaRouter getRouter(Context var1) {
         int var2 = this.mRouters.size();

         while(true) {
            --var2;
            if(var2 < 0) {
               MediaRouter var3 = new MediaRouter(var1);
               this.mRouters.add(new WeakReference(var3));
               return var3;
            }

            MediaRouter var5 = (MediaRouter)((WeakReference)this.mRouters.get(var2)).get();
            if(var5 == null) {
               this.mRouters.remove(var2);
            } else if(var5.mContext == var1) {
               return var5;
            }
         }
      }

      public List<MediaRouter.RouteInfo> getRoutes() {
         return this.mRoutes;
      }

      public MediaRouter.RouteInfo getSelectedRoute() {
         if(this.mSelectedRoute == null) {
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
         } else {
            return this.mSelectedRoute;
         }
      }

      public MediaRouter.RouteInfo getSystemRouteByDescriptorId(String var1) {
         int var2 = this.findProviderInfo(this.mSystemProvider);
         if(var2 >= 0) {
            MediaRouter.ProviderInfo var3 = (MediaRouter.ProviderInfo)this.mProviders.get(var2);
            int var4 = var3.findRouteByDescriptorId(var1);
            if(var4 >= 0) {
               return (MediaRouter.RouteInfo)var3.mRoutes.get(var4);
            }
         }

         return null;
      }

      public boolean isRouteAvailable(MediaRouteSelector var1, int var2) {
         if(!var1.isEmpty()) {
            if((var2 & 2) == 0 && this.mLowRam) {
               return true;
            }

            int var3 = this.mRoutes.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               MediaRouter.RouteInfo var5 = (MediaRouter.RouteInfo)this.mRoutes.get(var4);
               if(((var2 & 1) == 0 || !var5.isDefault()) && var5.matchesSelector(var1)) {
                  return true;
               }
            }
         }

         return false;
      }

      public void removeProvider(MediaRouteProvider var1) {
         int var2 = this.findProviderInfo(var1);
         if(var2 >= 0) {
            var1.setCallback((MediaRouteProvider.Callback)null);
            var1.setDiscoveryRequest((MediaRouteDiscoveryRequest)null);
            MediaRouter.ProviderInfo var3 = (MediaRouter.ProviderInfo)this.mProviders.get(var2);
            this.updateProviderContents(var3, (MediaRouteProviderDescriptor)null);
            if(MediaRouter.DEBUG) {
               Log.d("MediaRouter", "Provider removed: " + var3);
            }

            this.mCallbackHandler.post(514, var3);
            this.mProviders.remove(var2);
         }

      }

      public void removeRemoteControlClient(Object var1) {
         int var2 = this.findRemoteControlClientRecord(var1);
         if(var2 >= 0) {
            ((MediaRouter.RemoteControlClientRecord)this.mRemoteControlClients.remove(var2)).disconnect();
         }

      }

      public void requestSetVolume(MediaRouter.RouteInfo var1, int var2) {
         if(var1 == this.mSelectedRoute && this.mSelectedRouteController != null) {
            this.mSelectedRouteController.onSetVolume(var2);
         }

      }

      public void requestUpdateVolume(MediaRouter.RouteInfo var1, int var2) {
         if(var1 == this.mSelectedRoute && this.mSelectedRouteController != null) {
            this.mSelectedRouteController.onUpdateVolume(var2);
         }

      }

      public void selectRoute(MediaRouter.RouteInfo var1) {
         this.selectRoute(var1, 3);
      }

      public void selectRoute(MediaRouter.RouteInfo var1, int var2) {
         if(!this.mRoutes.contains(var1)) {
            Log.w("MediaRouter", "Ignoring attempt to select removed route: " + var1);
         } else if(!var1.mEnabled) {
            Log.w("MediaRouter", "Ignoring attempt to select disabled route: " + var1);
         } else {
            this.setSelectedRouteInternal(var1, var2);
         }
      }

      public void sendControlRequest(MediaRouter.RouteInfo var1, Intent var2, MediaRouter.ControlRequestCallback var3) {
         if((var1 != this.mSelectedRoute || this.mSelectedRouteController == null || !this.mSelectedRouteController.onControlRequest(var2, var3)) && var3 != null) {
            var3.onError((String)null, (Bundle)null);
         }
      }

      public void setMediaSession(Object var1) {
         if(this.mMediaSession != null) {
            this.mMediaSession.clearVolumeHandling();
         }

         if(var1 == null) {
            this.mMediaSession = null;
         } else {
            this.mMediaSession = new MediaRouter.MediaSessionRecord(var1);
            this.updatePlaybackInfoFromSelectedRoute();
         }
      }

      public void setMediaSessionCompat(MediaSessionCompat var1) {
         this.mCompatSession = var1;
         if(VERSION.SDK_INT >= 21) {
            Object var2;
            if(var1 != null) {
               var2 = var1.getMediaSession();
            } else {
               var2 = null;
            }

            this.setMediaSession(var2);
         } else if(VERSION.SDK_INT >= 14) {
            if(this.mRccMediaSession != null) {
               this.removeRemoteControlClient(this.mRccMediaSession.getRemoteControlClient());
               this.mRccMediaSession.removeOnActiveChangeListener(this.mSessionActiveListener);
            }

            this.mRccMediaSession = var1;
            if(var1 != null) {
               var1.addOnActiveChangeListener(this.mSessionActiveListener);
               if(var1.isActive()) {
                  this.addRemoteControlClient(var1.getRemoteControlClient());
                  return;
               }
            }
         }

      }

      public void start() {
         this.mRegisteredProviderWatcher = new RegisteredMediaRouteProviderWatcher(this.mApplicationContext, this);
         this.mRegisteredProviderWatcher.start();
      }

      public void updateDiscoveryRequest() {
         boolean var1 = false;
         boolean var2 = false;
         MediaRouteSelector.Builder var3 = new MediaRouteSelector.Builder();
         int var4 = this.mRouters.size();

         while(true) {
            while(true) {
               --var4;
               if(var4 < 0) {
                  MediaRouteSelector var5;
                  if(var1) {
                     var5 = var3.build();
                  } else {
                     var5 = MediaRouteSelector.EMPTY;
                  }

                  if(this.mDiscoveryRequest == null || !this.mDiscoveryRequest.getSelector().equals(var5) || this.mDiscoveryRequest.isActiveScan() != var2) {
                     if(var5.isEmpty() && !var2) {
                        if(this.mDiscoveryRequest == null) {
                           return;
                        }

                        this.mDiscoveryRequest = null;
                     } else {
                        this.mDiscoveryRequest = new MediaRouteDiscoveryRequest(var5, var2);
                     }

                     if(MediaRouter.DEBUG) {
                        Log.d("MediaRouter", "Updated discovery request: " + this.mDiscoveryRequest);
                     }

                     if(var1 && !var2 && this.mLowRam) {
                        Log.i("MediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                     }

                     int var6 = this.mProviders.size();

                     for(int var7 = 0; var7 < var6; ++var7) {
                        ((MediaRouter.ProviderInfo)this.mProviders.get(var7)).mProviderInstance.setDiscoveryRequest(this.mDiscoveryRequest);
                     }
                  }

                  return;
               }

               MediaRouter var10 = (MediaRouter)((WeakReference)this.mRouters.get(var4)).get();
               if(var10 == null) {
                  this.mRouters.remove(var4);
               } else {
                  int var11 = var10.mCallbackRecords.size();

                  for(int var12 = 0; var12 < var11; ++var12) {
                     MediaRouter.CallbackRecord var13 = (MediaRouter.CallbackRecord)var10.mCallbackRecords.get(var12);
                     var3.addSelector(var13.mSelector);
                     if((1 & var13.mFlags) != 0) {
                        var2 = true;
                        var1 = true;
                     }

                     if((4 & var13.mFlags) != 0 && !this.mLowRam) {
                        var1 = true;
                     }

                     if((8 & var13.mFlags) != 0) {
                        var1 = true;
                     }
                  }
               }
            }
         }
      }
   }

   private final class CallbackHandler extends Handler {
      public static final int MSG_PROVIDER_ADDED = 513;
      public static final int MSG_PROVIDER_CHANGED = 515;
      public static final int MSG_PROVIDER_REMOVED = 514;
      public static final int MSG_ROUTE_ADDED = 257;
      public static final int MSG_ROUTE_CHANGED = 259;
      public static final int MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED = 261;
      public static final int MSG_ROUTE_REMOVED = 258;
      public static final int MSG_ROUTE_SELECTED = 262;
      public static final int MSG_ROUTE_UNSELECTED = 263;
      public static final int MSG_ROUTE_VOLUME_CHANGED = 260;
      private static final int MSG_TYPE_MASK = 65280;
      private static final int MSG_TYPE_PROVIDER = 512;
      private static final int MSG_TYPE_ROUTE = 256;
      private final ArrayList<MediaRouter.CallbackRecord> mTempCallbackRecords;

      private CallbackHandler() {
         this.mTempCallbackRecords = new ArrayList();
      }

      // $FF: synthetic method
      CallbackHandler(Object var2) {
         this();
      }

      private void invokeCallback(MediaRouter.CallbackRecord var1, int var2, Object var3) {
         MediaRouter var4 = var1.mRouter;
         MediaRouter.Callback var5 = var1.mCallback;
         switch(65280 & var2) {
         case 256:
            MediaRouter.RouteInfo var7 = (MediaRouter.RouteInfo)var3;
            if(var1.filterRouteEvent(var7)) {
               switch(var2) {
               case 257:
                  var5.onRouteAdded(var4, var7);
                  return;
               case 258:
                  var5.onRouteRemoved(var4, var7);
                  return;
               case 259:
                  var5.onRouteChanged(var4, var7);
                  return;
               case 260:
                  var5.onRouteVolumeChanged(var4, var7);
                  return;
               case 261:
                  var5.onRoutePresentationDisplayChanged(var4, var7);
                  return;
               case 262:
                  var5.onRouteSelected(var4, var7);
                  return;
               case 263:
                  var5.onRouteUnselected(var4, var7);
                  return;
               default:
                  return;
               }
            }
         default:
            return;
         case 512:
            MediaRouter.ProviderInfo var6 = (MediaRouter.ProviderInfo)var3;
            switch(var2) {
            case 513:
               var5.onProviderAdded(var4, var6);
               return;
            case 514:
               var5.onProviderRemoved(var4, var6);
               return;
            case 515:
               var5.onProviderChanged(var4, var6);
               return;
            default:
            }
         }
      }

      private void syncWithSystemProvider(int var1, Object var2) {
         switch(var1) {
         case 257:
            MediaRouter.super.mSystemProvider.onSyncRouteAdded((MediaRouter.RouteInfo)var2);
            return;
         case 258:
            MediaRouter.super.mSystemProvider.onSyncRouteRemoved((MediaRouter.RouteInfo)var2);
            return;
         case 259:
            MediaRouter.super.mSystemProvider.onSyncRouteChanged((MediaRouter.RouteInfo)var2);
            return;
         case 260:
         case 261:
         default:
            return;
         case 262:
            MediaRouter.super.mSystemProvider.onSyncRouteSelected((MediaRouter.RouteInfo)var2);
         }
      }

      public void handleMessage(Message param1) {
         // $FF: Couldn't be decompiled
      }

      public void post(int var1, Object var2) {
         this.obtainMessage(var1, var2).sendToTarget();
      }
   }

   private final class MediaSessionRecord {
      private int mControlType;
      private int mMaxVolume;
      private final MediaSessionCompat mMsCompat;
      private VolumeProviderCompat mVpCompat;

      public MediaSessionRecord(Object var2) {
         this.mMsCompat = MediaSessionCompat.obtain(MediaRouter.super.mApplicationContext, var2);
      }

      public void clearVolumeHandling() {
         this.mMsCompat.setPlaybackToLocal(MediaRouter.super.mPlaybackInfo.playbackStream);
         this.mVpCompat = null;
      }

      public void configureVolume(final int var1, final int var2, final int var3) {
         if(this.mVpCompat != null && var1 == this.mControlType && var2 == this.mMaxVolume) {
            this.mVpCompat.setCurrentVolume(var3);
         } else {
            this.mVpCompat = new VolumeProviderCompat(var1, var2, var3) {
               public void onAdjustVolume(final int var1) {
                  MediaRouter.super.mCallbackHandler.post(new Runnable() {
                     public void run() {
                        if(MediaRouter.super.mSelectedRoute != null) {
                           MediaRouter.super.mSelectedRoute.requestUpdateVolume(var1);
                        }

                     }
                  });
               }

               public void onSetVolumeTo(final int var1) {
                  MediaRouter.super.mCallbackHandler.post(new Runnable() {
                     public void run() {
                        if(MediaRouter.super.mSelectedRoute != null) {
                           MediaRouter.super.mSelectedRoute.requestSetVolume(var1);
                        }

                     }
                  });
               }
            };
            this.mMsCompat.setPlaybackToRemote(this.mVpCompat);
         }
      }

      public MediaSessionCompat.Token getToken() {
         return this.mMsCompat.getSessionToken();
      }
   }

   private final class ProviderCallback extends MediaRouteProvider.Callback {
      private ProviderCallback() {
      }

      // $FF: synthetic method
      ProviderCallback(Object var2) {
         this();
      }

      public void onDescriptorChanged(MediaRouteProvider var1, MediaRouteProviderDescriptor var2) {
         MediaRouter.super.updateProviderDescriptor(var1, var2);
      }
   }

   private final class RemoteControlClientRecord implements RemoteControlClientCompat.VolumeCallback {
      private boolean mDisconnected;
      private final RemoteControlClientCompat mRccCompat;

      public RemoteControlClientRecord(Object var2) {
         this.mRccCompat = RemoteControlClientCompat.obtain(MediaRouter.super.mApplicationContext, var2);
         this.mRccCompat.setVolumeCallback(this);
         this.updatePlaybackInfo();
      }

      public void disconnect() {
         this.mDisconnected = true;
         this.mRccCompat.setVolumeCallback((RemoteControlClientCompat.VolumeCallback)null);
      }

      public Object getRemoteControlClient() {
         return this.mRccCompat.getRemoteControlClient();
      }

      public void onVolumeSetRequest(int var1) {
         if(!this.mDisconnected && MediaRouter.super.mSelectedRoute != null) {
            MediaRouter.super.mSelectedRoute.requestSetVolume(var1);
         }

      }

      public void onVolumeUpdateRequest(int var1) {
         if(!this.mDisconnected && MediaRouter.super.mSelectedRoute != null) {
            MediaRouter.super.mSelectedRoute.requestUpdateVolume(var1);
         }

      }

      public void updatePlaybackInfo() {
         this.mRccCompat.setPlaybackInfo(MediaRouter.super.mPlaybackInfo);
      }
   }

   public static final class ProviderInfo {
      private MediaRouteProviderDescriptor mDescriptor;
      private final MediaRouteProvider.ProviderMetadata mMetadata;
      private final MediaRouteProvider mProviderInstance;
      private Resources mResources;
      private boolean mResourcesNotAvailable;
      private final ArrayList<MediaRouter.RouteInfo> mRoutes = new ArrayList();

      ProviderInfo(MediaRouteProvider var1) {
         this.mProviderInstance = var1;
         this.mMetadata = var1.getMetadata();
      }

      int findRouteByDescriptorId(String var1) {
         int var2 = this.mRoutes.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((MediaRouter.RouteInfo)this.mRoutes.get(var3)).mDescriptorId.equals(var1)) {
               return var3;
            }
         }

         return -1;
      }

      public ComponentName getComponentName() {
         return this.mMetadata.getComponentName();
      }

      public String getPackageName() {
         return this.mMetadata.getPackageName();
      }

      public MediaRouteProvider getProviderInstance() {
         MediaRouter.checkCallingThread();
         return this.mProviderInstance;
      }

      Resources getResources() {
         if(this.mResources == null && !this.mResourcesNotAvailable) {
            String var1 = this.getPackageName();
            Context var2 = MediaRouter.sGlobal.getProviderContext(var1);
            if(var2 != null) {
               this.mResources = var2.getResources();
            } else {
               Log.w("MediaRouter", "Unable to obtain resources for route provider package: " + var1);
               this.mResourcesNotAvailable = true;
            }
         }

         return this.mResources;
      }

      public List<MediaRouter.RouteInfo> getRoutes() {
         MediaRouter.checkCallingThread();
         return this.mRoutes;
      }

      public String toString() {
         return "MediaRouter.RouteProviderInfo{ packageName=" + this.getPackageName() + " }";
      }

      boolean updateDescriptor(MediaRouteProviderDescriptor var1) {
         if(this.mDescriptor != var1) {
            this.mDescriptor = var1;
            return true;
         } else {
            return false;
         }
      }
   }

   public static final class RouteInfo {
      static final int CHANGE_GENERAL = 1;
      static final int CHANGE_PRESENTATION_DISPLAY = 4;
      static final int CHANGE_VOLUME = 2;
      public static final int PLAYBACK_TYPE_LOCAL = 0;
      public static final int PLAYBACK_TYPE_REMOTE = 1;
      public static final int PLAYBACK_VOLUME_FIXED = 0;
      public static final int PLAYBACK_VOLUME_VARIABLE = 1;
      private boolean mCanDisconnect;
      private boolean mConnecting;
      private final ArrayList<IntentFilter> mControlFilters = new ArrayList();
      private String mDescription;
      private MediaRouteDescriptor mDescriptor;
      private final String mDescriptorId;
      private boolean mEnabled;
      private Bundle mExtras;
      private String mName;
      private int mPlaybackStream;
      private int mPlaybackType;
      private Display mPresentationDisplay;
      private int mPresentationDisplayId = -1;
      private final MediaRouter.ProviderInfo mProvider;
      private IntentSender mSettingsIntent;
      private final String mUniqueId;
      private int mVolume;
      private int mVolumeHandling;
      private int mVolumeMax;

      RouteInfo(MediaRouter.ProviderInfo var1, String var2, String var3) {
         this.mProvider = var1;
         this.mDescriptorId = var2;
         this.mUniqueId = var3;
      }

      public boolean canDisconnect() {
         return this.mCanDisconnect;
      }

      public List<IntentFilter> getControlFilters() {
         return this.mControlFilters;
      }

      @Nullable
      public String getDescription() {
         return this.mDescription;
      }

      String getDescriptorId() {
         return this.mDescriptorId;
      }

      @Nullable
      public Bundle getExtras() {
         return this.mExtras;
      }

      @NonNull
      public String getId() {
         return this.mUniqueId;
      }

      public String getName() {
         return this.mName;
      }

      public int getPlaybackStream() {
         return this.mPlaybackStream;
      }

      public int getPlaybackType() {
         return this.mPlaybackType;
      }

      @Nullable
      public Display getPresentationDisplay() {
         MediaRouter.checkCallingThread();
         if(this.mPresentationDisplayId >= 0 && this.mPresentationDisplay == null) {
            this.mPresentationDisplay = MediaRouter.sGlobal.getDisplay(this.mPresentationDisplayId);
         }

         return this.mPresentationDisplay;
      }

      public MediaRouter.ProviderInfo getProvider() {
         return this.mProvider;
      }

      MediaRouteProvider getProviderInstance() {
         return this.mProvider.getProviderInstance();
      }

      @Nullable
      public IntentSender getSettingsIntent() {
         return this.mSettingsIntent;
      }

      public int getVolume() {
         return this.mVolume;
      }

      public int getVolumeHandling() {
         return this.mVolumeHandling;
      }

      public int getVolumeMax() {
         return this.mVolumeMax;
      }

      public boolean isConnecting() {
         return this.mConnecting;
      }

      public boolean isDefault() {
         MediaRouter.checkCallingThread();
         return MediaRouter.sGlobal.getDefaultRoute() == this;
      }

      public boolean isEnabled() {
         return this.mEnabled;
      }

      public boolean isSelected() {
         MediaRouter.checkCallingThread();
         return MediaRouter.sGlobal.getSelectedRoute() == this;
      }

      public boolean matchesSelector(@NonNull MediaRouteSelector var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("selector must not be null");
         } else {
            MediaRouter.checkCallingThread();
            return var1.matchesControlFilters(this.mControlFilters);
         }
      }

      public void requestSetVolume(int var1) {
         MediaRouter.checkCallingThread();
         MediaRouter.sGlobal.requestSetVolume(this, Math.min(this.mVolumeMax, Math.max(0, var1)));
      }

      public void requestUpdateVolume(int var1) {
         MediaRouter.checkCallingThread();
         if(var1 != 0) {
            MediaRouter.sGlobal.requestUpdateVolume(this, var1);
         }

      }

      public void select() {
         MediaRouter.checkCallingThread();
         MediaRouter.sGlobal.selectRoute(this);
      }

      public void sendControlRequest(@NonNull Intent var1, @Nullable MediaRouter.ControlRequestCallback var2) {
         if(var1 == null) {
            throw new IllegalArgumentException("intent must not be null");
         } else {
            MediaRouter.checkCallingThread();
            MediaRouter.sGlobal.sendControlRequest(this, var1, var2);
         }
      }

      public boolean supportsControlAction(@NonNull String var1, @NonNull String var2) {
         if(var1 == null) {
            throw new IllegalArgumentException("category must not be null");
         } else if(var2 == null) {
            throw new IllegalArgumentException("action must not be null");
         } else {
            MediaRouter.checkCallingThread();
            int var3 = this.mControlFilters.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               IntentFilter var5 = (IntentFilter)this.mControlFilters.get(var4);
               if(var5.hasCategory(var1) && var5.hasAction(var2)) {
                  return true;
               }
            }

            return false;
         }
      }

      public boolean supportsControlCategory(@NonNull String var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("category must not be null");
         } else {
            MediaRouter.checkCallingThread();
            int var2 = this.mControlFilters.size();

            for(int var3 = 0; var3 < var2; ++var3) {
               if(((IntentFilter)this.mControlFilters.get(var3)).hasCategory(var1)) {
                  return true;
               }
            }

            return false;
         }
      }

      public boolean supportsControlRequest(@NonNull Intent var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("intent must not be null");
         } else {
            MediaRouter.checkCallingThread();
            ContentResolver var2 = MediaRouter.sGlobal.getContentResolver();
            int var3 = this.mControlFilters.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(((IntentFilter)this.mControlFilters.get(var4)).match(var2, var1, true, "MediaRouter") >= 0) {
                  return true;
               }
            }

            return false;
         }
      }

      public String toString() {
         return "MediaRouter.RouteInfo{ uniqueId=" + this.mUniqueId + ", name=" + this.mName + ", description=" + this.mDescription + ", enabled=" + this.mEnabled + ", connecting=" + this.mConnecting + ", canDisconnect=" + this.mCanDisconnect + ", playbackType=" + this.mPlaybackType + ", playbackStream=" + this.mPlaybackStream + ", volumeHandling=" + this.mVolumeHandling + ", volume=" + this.mVolume + ", volumeMax=" + this.mVolumeMax + ", presentationDisplayId=" + this.mPresentationDisplayId + ", extras=" + this.mExtras + ", settingsIntent=" + this.mSettingsIntent + ", providerPackageName=" + this.mProvider.getPackageName() + " }";
      }

      int updateDescriptor(MediaRouteDescriptor var1) {
         MediaRouteDescriptor var2 = this.mDescriptor;
         int var3 = 0;
         if(var2 != var1) {
            this.mDescriptor = var1;
            var3 = 0;
            if(var1 != null) {
               boolean var4 = MediaRouter.equal(this.mName, var1.getName());
               var3 = 0;
               if(!var4) {
                  this.mName = var1.getName();
                  var3 = 0 | 1;
               }

               if(!MediaRouter.equal(this.mDescription, var1.getDescription())) {
                  this.mDescription = var1.getDescription();
                  var3 |= 1;
               }

               if(this.mEnabled != var1.isEnabled()) {
                  this.mEnabled = var1.isEnabled();
                  var3 |= 1;
               }

               if(this.mConnecting != var1.isConnecting()) {
                  this.mConnecting = var1.isConnecting();
                  var3 |= 1;
               }

               if(!this.mControlFilters.equals(var1.getControlFilters())) {
                  this.mControlFilters.clear();
                  this.mControlFilters.addAll(var1.getControlFilters());
                  var3 |= 1;
               }

               if(this.mPlaybackType != var1.getPlaybackType()) {
                  this.mPlaybackType = var1.getPlaybackType();
                  var3 |= 1;
               }

               if(this.mPlaybackStream != var1.getPlaybackStream()) {
                  this.mPlaybackStream = var1.getPlaybackStream();
                  var3 |= 1;
               }

               if(this.mVolumeHandling != var1.getVolumeHandling()) {
                  this.mVolumeHandling = var1.getVolumeHandling();
                  var3 |= 3;
               }

               if(this.mVolume != var1.getVolume()) {
                  this.mVolume = var1.getVolume();
                  var3 |= 3;
               }

               if(this.mVolumeMax != var1.getVolumeMax()) {
                  this.mVolumeMax = var1.getVolumeMax();
                  var3 |= 3;
               }

               if(this.mPresentationDisplayId != var1.getPresentationDisplayId()) {
                  this.mPresentationDisplayId = var1.getPresentationDisplayId();
                  this.mPresentationDisplay = null;
                  var3 |= 5;
               }

               if(!MediaRouter.equal(this.mExtras, var1.getExtras())) {
                  this.mExtras = var1.getExtras();
                  var3 |= 1;
               }

               if(!MediaRouter.equal(this.mSettingsIntent, var1.getSettingsActivity())) {
                  this.mSettingsIntent = var1.getSettingsActivity();
                  var3 |= 1;
               }

               if(this.mCanDisconnect != var1.canDisconnectAndKeepPlaying()) {
                  this.mCanDisconnect = var1.canDisconnectAndKeepPlaying();
                  var3 |= 5;
               }
            }
         }

         return var3;
      }
   }
}

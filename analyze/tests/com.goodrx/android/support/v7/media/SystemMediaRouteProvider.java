package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v7.media.MediaRouteDescriptor;
import android.support.v7.media.MediaRouteDiscoveryRequest;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouterJellybean;
import android.support.v7.media.MediaRouterJellybeanMr1;
import android.support.v7.media.MediaRouterJellybeanMr2;
import android.support.v7.mediarouter.class_16;
import android.view.Display;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

abstract class SystemMediaRouteProvider extends MediaRouteProvider {
   public static final String DEFAULT_ROUTE_ID = "DEFAULT_ROUTE";
   public static final String PACKAGE_NAME = "android";
   private static final String TAG = "SystemMediaRouteProvider";

   protected SystemMediaRouteProvider(Context var1) {
      super(var1, new MediaRouteProvider.ProviderMetadata(new ComponentName("android", SystemMediaRouteProvider.class.getName())));
   }

   public static SystemMediaRouteProvider obtain(Context var0, SystemMediaRouteProvider.SyncCallback var1) {
      return (SystemMediaRouteProvider)(VERSION.SDK_INT >= 18?new SystemMediaRouteProvider.JellybeanMr2Impl(var0, var1):(VERSION.SDK_INT >= 17?new SystemMediaRouteProvider.JellybeanMr1Impl(var0, var1):(VERSION.SDK_INT >= 16?new SystemMediaRouteProvider.JellybeanImpl(var0, var1):new SystemMediaRouteProvider.LegacyImpl(var0))));
   }

   public void onSyncRouteAdded(MediaRouter.RouteInfo var1) {
   }

   public void onSyncRouteChanged(MediaRouter.RouteInfo var1) {
   }

   public void onSyncRouteRemoved(MediaRouter.RouteInfo var1) {
   }

   public void onSyncRouteSelected(MediaRouter.RouteInfo var1) {
   }

   static class JellybeanImpl extends SystemMediaRouteProvider implements MediaRouterJellybean.Callback, MediaRouterJellybean.VolumeCallback {
      private static final ArrayList<IntentFilter> LIVE_AUDIO_CONTROL_FILTERS;
      private static final ArrayList<IntentFilter> LIVE_VIDEO_CONTROL_FILTERS;
      protected boolean mActiveScan;
      protected final Object mCallbackObj;
      protected boolean mCallbackRegistered;
      private MediaRouterJellybean.GetDefaultRouteWorkaround mGetDefaultRouteWorkaround;
      protected int mRouteTypes;
      protected final Object mRouterObj;
      private MediaRouterJellybean.SelectRouteWorkaround mSelectRouteWorkaround;
      private final SystemMediaRouteProvider.SyncCallback mSyncCallback;
      protected final ArrayList<SystemMediaRouteProvider.SystemRouteRecord> mSystemRouteRecords = new ArrayList();
      protected final Object mUserRouteCategoryObj;
      protected final ArrayList<SystemMediaRouteProvider.UserRouteRecord> mUserRouteRecords = new ArrayList();
      protected final Object mVolumeCallbackObj;

      static {
         IntentFilter var0 = new IntentFilter();
         var0.addCategory("android.media.intent.category.LIVE_AUDIO");
         LIVE_AUDIO_CONTROL_FILTERS = new ArrayList();
         LIVE_AUDIO_CONTROL_FILTERS.add(var0);
         IntentFilter var2 = new IntentFilter();
         var2.addCategory("android.media.intent.category.LIVE_VIDEO");
         LIVE_VIDEO_CONTROL_FILTERS = new ArrayList();
         LIVE_VIDEO_CONTROL_FILTERS.add(var2);
      }

      public JellybeanImpl(Context var1, SystemMediaRouteProvider.SyncCallback var2) {
         super(var1);
         this.mSyncCallback = var2;
         this.mRouterObj = MediaRouterJellybean.getMediaRouter(var1);
         this.mCallbackObj = this.createCallbackObj();
         this.mVolumeCallbackObj = this.createVolumeCallbackObj();
         Resources var3 = var1.getResources();
         this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, var3.getString(class_16.string.mr_user_route_category_name), false);
         this.updateSystemRoutes();
      }

      private boolean addSystemRouteNoPublish(Object var1) {
         if(this.getUserRouteRecord(var1) == null && this.findSystemRouteRecord(var1) < 0) {
            SystemMediaRouteProvider.SystemRouteRecord var2 = new SystemMediaRouteProvider.SystemRouteRecord(var1, this.assignRouteId(var1));
            this.updateSystemRouteDescriptor(var2);
            this.mSystemRouteRecords.add(var2);
            return true;
         } else {
            return false;
         }
      }

      private String assignRouteId(Object var1) {
         boolean var2;
         if(this.getDefaultRoute() == var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         String var5;
         if(var2) {
            var5 = "DEFAULT_ROUTE";
         } else {
            Locale var3 = Locale.US;
            Object[] var4 = new Object[]{Integer.valueOf(this.getRouteName(var1).hashCode())};
            var5 = String.format(var3, "ROUTE_%08x", var4);
         }

         if(this.findSystemRouteRecordByDescriptorId(var5) < 0) {
            return var5;
         } else {
            int var6 = 2;

            while(true) {
               Locale var7 = Locale.US;
               Object[] var8 = new Object[]{var5, Integer.valueOf(var6)};
               String var9 = String.format(var7, "%s_%d", var8);
               if(this.findSystemRouteRecordByDescriptorId(var9) < 0) {
                  return var9;
               }

               ++var6;
            }
         }
      }

      private void updateSystemRoutes() {
         boolean var1 = false;

         for(Iterator var2 = MediaRouterJellybean.getRoutes(this.mRouterObj).iterator(); var2.hasNext(); var1 |= this.addSystemRouteNoPublish(var2.next())) {
            ;
         }

         if(var1) {
            this.publishRoutes();
         }

      }

      protected Object createCallbackObj() {
         return MediaRouterJellybean.createCallback(this);
      }

      protected Object createVolumeCallbackObj() {
         return MediaRouterJellybean.createVolumeCallback(this);
      }

      protected int findSystemRouteRecord(Object var1) {
         int var2 = this.mSystemRouteRecords.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var3)).mRouteObj == var1) {
               return var3;
            }
         }

         return -1;
      }

      protected int findSystemRouteRecordByDescriptorId(String var1) {
         int var2 = this.mSystemRouteRecords.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var3)).mRouteDescriptorId.equals(var1)) {
               return var3;
            }
         }

         return -1;
      }

      protected int findUserRouteRecord(MediaRouter.RouteInfo var1) {
         int var2 = this.mUserRouteRecords.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((SystemMediaRouteProvider.UserRouteRecord)this.mUserRouteRecords.get(var3)).mRoute == var1) {
               return var3;
            }
         }

         return -1;
      }

      protected Object getDefaultRoute() {
         if(this.mGetDefaultRouteWorkaround == null) {
            this.mGetDefaultRouteWorkaround = new MediaRouterJellybean.GetDefaultRouteWorkaround();
         }

         return this.mGetDefaultRouteWorkaround.getDefaultRoute(this.mRouterObj);
      }

      protected String getRouteName(Object var1) {
         CharSequence var2 = MediaRouterJellybean.RouteInfo.getName(var1, this.getContext());
         return var2 != null?var2.toString():"";
      }

      protected SystemMediaRouteProvider.UserRouteRecord getUserRouteRecord(Object var1) {
         Object var2 = MediaRouterJellybean.RouteInfo.getTag(var1);
         return var2 instanceof SystemMediaRouteProvider.UserRouteRecord?(SystemMediaRouteProvider.UserRouteRecord)var2:null;
      }

      protected void onBuildSystemRouteDescriptor(SystemMediaRouteProvider.SystemRouteRecord var1, MediaRouteDescriptor.Builder var2) {
         int var3 = MediaRouterJellybean.RouteInfo.getSupportedTypes(var1.mRouteObj);
         if((var3 & 1) != 0) {
            var2.addControlFilters(LIVE_AUDIO_CONTROL_FILTERS);
         }

         if((var3 & 2) != 0) {
            var2.addControlFilters(LIVE_VIDEO_CONTROL_FILTERS);
         }

         var2.setPlaybackType(MediaRouterJellybean.RouteInfo.getPlaybackType(var1.mRouteObj));
         var2.setPlaybackStream(MediaRouterJellybean.RouteInfo.getPlaybackStream(var1.mRouteObj));
         var2.setVolume(MediaRouterJellybean.RouteInfo.getVolume(var1.mRouteObj));
         var2.setVolumeMax(MediaRouterJellybean.RouteInfo.getVolumeMax(var1.mRouteObj));
         var2.setVolumeHandling(MediaRouterJellybean.RouteInfo.getVolumeHandling(var1.mRouteObj));
      }

      public MediaRouteProvider.RouteController onCreateRouteController(String var1) {
         int var2 = this.findSystemRouteRecordByDescriptorId(var1);
         return var2 >= 0?new SystemMediaRouteProvider.SystemRouteController(((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2)).mRouteObj):null;
      }

      public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest var1) {
         boolean var2 = false;
         int var3 = 0;
         if(var1 != null) {
            List var4 = var1.getSelector().getControlCategories();
            int var5 = var4.size();

            for(int var6 = 0; var6 < var5; ++var6) {
               String var7 = (String)var4.get(var6);
               if(var7.equals("android.media.intent.category.LIVE_AUDIO")) {
                  var3 |= 1;
               } else if(var7.equals("android.media.intent.category.LIVE_VIDEO")) {
                  var3 |= 2;
               } else {
                  var3 |= 8388608;
               }
            }

            var2 = var1.isActiveScan();
         }

         if(this.mRouteTypes != var3 || this.mActiveScan != var2) {
            this.mRouteTypes = var3;
            this.mActiveScan = var2;
            this.updateCallback();
            this.updateSystemRoutes();
         }

      }

      public void onRouteAdded(Object var1) {
         if(this.addSystemRouteNoPublish(var1)) {
            this.publishRoutes();
         }

      }

      public void onRouteChanged(Object var1) {
         if(this.getUserRouteRecord(var1) == null) {
            int var2 = this.findSystemRouteRecord(var1);
            if(var2 >= 0) {
               this.updateSystemRouteDescriptor((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2));
               this.publishRoutes();
            }
         }

      }

      public void onRouteGrouped(Object var1, Object var2, int var3) {
      }

      public void onRouteRemoved(Object var1) {
         if(this.getUserRouteRecord(var1) == null) {
            int var2 = this.findSystemRouteRecord(var1);
            if(var2 >= 0) {
               this.mSystemRouteRecords.remove(var2);
               this.publishRoutes();
            }
         }

      }

      public void onRouteSelected(int var1, Object var2) {
         if(var2 == MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611)) {
            SystemMediaRouteProvider.UserRouteRecord var3 = this.getUserRouteRecord(var2);
            if(var3 != null) {
               var3.mRoute.select();
               return;
            }

            int var4 = this.findSystemRouteRecord(var2);
            if(var4 >= 0) {
               SystemMediaRouteProvider.SystemRouteRecord var5 = (SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var4);
               MediaRouter.RouteInfo var6 = this.mSyncCallback.getSystemRouteByDescriptorId(var5.mRouteDescriptorId);
               if(var6 != null) {
                  var6.select();
                  return;
               }
            }
         }

      }

      public void onRouteUngrouped(Object var1, Object var2) {
      }

      public void onRouteUnselected(int var1, Object var2) {
      }

      public void onRouteVolumeChanged(Object var1) {
         if(this.getUserRouteRecord(var1) == null) {
            int var2 = this.findSystemRouteRecord(var1);
            if(var2 >= 0) {
               SystemMediaRouteProvider.SystemRouteRecord var3 = (SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2);
               int var4 = MediaRouterJellybean.RouteInfo.getVolume(var1);
               if(var4 != var3.mRouteDescriptor.getVolume()) {
                  var3.mRouteDescriptor = (new MediaRouteDescriptor.Builder(var3.mRouteDescriptor)).setVolume(var4).build();
                  this.publishRoutes();
               }
            }
         }

      }

      public void onSyncRouteAdded(MediaRouter.RouteInfo var1) {
         if(var1.getProviderInstance() != this) {
            Object var3 = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
            SystemMediaRouteProvider.UserRouteRecord var4 = new SystemMediaRouteProvider.UserRouteRecord(var1, var3);
            MediaRouterJellybean.RouteInfo.setTag(var3, var4);
            MediaRouterJellybean.UserRouteInfo.setVolumeCallback(var3, this.mVolumeCallbackObj);
            this.updateUserRouteProperties(var4);
            this.mUserRouteRecords.add(var4);
            MediaRouterJellybean.addUserRoute(this.mRouterObj, var3);
         } else {
            int var2 = this.findSystemRouteRecord(MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611));
            if(var2 >= 0 && ((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2)).mRouteDescriptorId.equals(var1.getDescriptorId())) {
               var1.select();
               return;
            }
         }

      }

      public void onSyncRouteChanged(MediaRouter.RouteInfo var1) {
         if(var1.getProviderInstance() != this) {
            int var2 = this.findUserRouteRecord(var1);
            if(var2 >= 0) {
               this.updateUserRouteProperties((SystemMediaRouteProvider.UserRouteRecord)this.mUserRouteRecords.get(var2));
            }
         }

      }

      public void onSyncRouteRemoved(MediaRouter.RouteInfo var1) {
         if(var1.getProviderInstance() != this) {
            int var2 = this.findUserRouteRecord(var1);
            if(var2 >= 0) {
               SystemMediaRouteProvider.UserRouteRecord var3 = (SystemMediaRouteProvider.UserRouteRecord)this.mUserRouteRecords.remove(var2);
               MediaRouterJellybean.RouteInfo.setTag(var3.mRouteObj, (Object)null);
               MediaRouterJellybean.UserRouteInfo.setVolumeCallback(var3.mRouteObj, (Object)null);
               MediaRouterJellybean.removeUserRoute(this.mRouterObj, var3.mRouteObj);
            }
         }

      }

      public void onSyncRouteSelected(MediaRouter.RouteInfo var1) {
         if(var1.isSelected()) {
            if(var1.getProviderInstance() != this) {
               int var3 = this.findUserRouteRecord(var1);
               if(var3 >= 0) {
                  this.selectRoute(((SystemMediaRouteProvider.UserRouteRecord)this.mUserRouteRecords.get(var3)).mRouteObj);
                  return;
               }
            } else {
               int var2 = this.findSystemRouteRecordByDescriptorId(var1.getDescriptorId());
               if(var2 >= 0) {
                  this.selectRoute(((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2)).mRouteObj);
                  return;
               }
            }
         }

      }

      public void onVolumeSetRequest(Object var1, int var2) {
         SystemMediaRouteProvider.UserRouteRecord var3 = this.getUserRouteRecord(var1);
         if(var3 != null) {
            var3.mRoute.requestSetVolume(var2);
         }

      }

      public void onVolumeUpdateRequest(Object var1, int var2) {
         SystemMediaRouteProvider.UserRouteRecord var3 = this.getUserRouteRecord(var1);
         if(var3 != null) {
            var3.mRoute.requestUpdateVolume(var2);
         }

      }

      protected void publishRoutes() {
         MediaRouteProviderDescriptor.Builder var1 = new MediaRouteProviderDescriptor.Builder();
         int var2 = this.mSystemRouteRecords.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.addRoute(((SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var3)).mRouteDescriptor);
         }

         this.setDescriptor(var1.build());
      }

      protected void selectRoute(Object var1) {
         if(this.mSelectRouteWorkaround == null) {
            this.mSelectRouteWorkaround = new MediaRouterJellybean.SelectRouteWorkaround();
         }

         this.mSelectRouteWorkaround.selectRoute(this.mRouterObj, 8388611, var1);
      }

      protected void updateCallback() {
         if(this.mCallbackRegistered) {
            this.mCallbackRegistered = false;
            MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
         }

         if(this.mRouteTypes != 0) {
            this.mCallbackRegistered = true;
            MediaRouterJellybean.addCallback(this.mRouterObj, this.mRouteTypes, this.mCallbackObj);
         }

      }

      protected void updateSystemRouteDescriptor(SystemMediaRouteProvider.SystemRouteRecord var1) {
         MediaRouteDescriptor.Builder var2 = new MediaRouteDescriptor.Builder(var1.mRouteDescriptorId, this.getRouteName(var1.mRouteObj));
         this.onBuildSystemRouteDescriptor(var1, var2);
         var1.mRouteDescriptor = var2.build();
      }

      protected void updateUserRouteProperties(SystemMediaRouteProvider.UserRouteRecord var1) {
         MediaRouterJellybean.UserRouteInfo.setName(var1.mRouteObj, var1.mRoute.getName());
         MediaRouterJellybean.UserRouteInfo.setPlaybackType(var1.mRouteObj, var1.mRoute.getPlaybackType());
         MediaRouterJellybean.UserRouteInfo.setPlaybackStream(var1.mRouteObj, var1.mRoute.getPlaybackStream());
         MediaRouterJellybean.UserRouteInfo.setVolume(var1.mRouteObj, var1.mRoute.getVolume());
         MediaRouterJellybean.UserRouteInfo.setVolumeMax(var1.mRouteObj, var1.mRoute.getVolumeMax());
         MediaRouterJellybean.UserRouteInfo.setVolumeHandling(var1.mRouteObj, var1.mRoute.getVolumeHandling());
      }
   }

   protected final class SystemRouteController extends MediaRouteProvider.RouteController {
      private final Object mRouteObj;

      public SystemRouteController(Object var2) {
         this.mRouteObj = var2;
      }

      public void onSetVolume(int var1) {
         MediaRouterJellybean.RouteInfo.requestSetVolume(this.mRouteObj, var1);
      }

      public void onUpdateVolume(int var1) {
         MediaRouterJellybean.RouteInfo.requestUpdateVolume(this.mRouteObj, var1);
      }
   }

   protected static final class SystemRouteRecord {
      public MediaRouteDescriptor mRouteDescriptor;
      public final String mRouteDescriptorId;
      public final Object mRouteObj;

      public SystemRouteRecord(Object var1, String var2) {
         this.mRouteObj = var1;
         this.mRouteDescriptorId = var2;
      }
   }

   protected static final class UserRouteRecord {
      public final MediaRouter.RouteInfo mRoute;
      public final Object mRouteObj;

      public UserRouteRecord(MediaRouter.RouteInfo var1, Object var2) {
         this.mRoute = var1;
         this.mRouteObj = var2;
      }
   }

   private static class JellybeanMr1Impl extends SystemMediaRouteProvider.JellybeanImpl implements MediaRouterJellybeanMr1.Callback {
      private MediaRouterJellybeanMr1.ActiveScanWorkaround mActiveScanWorkaround;
      private MediaRouterJellybeanMr1.IsConnectingWorkaround mIsConnectingWorkaround;

      public JellybeanMr1Impl(Context var1, SystemMediaRouteProvider.SyncCallback var2) {
         super(var1, var2);
      }

      protected Object createCallbackObj() {
         return MediaRouterJellybeanMr1.createCallback(this);
      }

      protected boolean isConnecting(SystemMediaRouteProvider.SystemRouteRecord var1) {
         if(this.mIsConnectingWorkaround == null) {
            this.mIsConnectingWorkaround = new MediaRouterJellybeanMr1.IsConnectingWorkaround();
         }

         return this.mIsConnectingWorkaround.isConnecting(var1.mRouteObj);
      }

      protected void onBuildSystemRouteDescriptor(SystemMediaRouteProvider.SystemRouteRecord var1, MediaRouteDescriptor.Builder var2) {
         super.onBuildSystemRouteDescriptor(var1, var2);
         if(!MediaRouterJellybeanMr1.RouteInfo.isEnabled(var1.mRouteObj)) {
            var2.setEnabled(false);
         }

         if(this.isConnecting(var1)) {
            var2.setConnecting(true);
         }

         Display var3 = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(var1.mRouteObj);
         if(var3 != null) {
            var2.setPresentationDisplayId(var3.getDisplayId());
         }

      }

      public void onRoutePresentationDisplayChanged(Object var1) {
         int var2 = this.findSystemRouteRecord(var1);
         if(var2 >= 0) {
            SystemMediaRouteProvider.SystemRouteRecord var3 = (SystemMediaRouteProvider.SystemRouteRecord)this.mSystemRouteRecords.get(var2);
            Display var4 = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(var1);
            int var5;
            if(var4 != null) {
               var5 = var4.getDisplayId();
            } else {
               var5 = -1;
            }

            if(var5 != var3.mRouteDescriptor.getPresentationDisplayId()) {
               var3.mRouteDescriptor = (new MediaRouteDescriptor.Builder(var3.mRouteDescriptor)).setPresentationDisplayId(var5).build();
               this.publishRoutes();
            }
         }

      }

      protected void updateCallback() {
         super.updateCallback();
         if(this.mActiveScanWorkaround == null) {
            this.mActiveScanWorkaround = new MediaRouterJellybeanMr1.ActiveScanWorkaround(this.getContext(), this.getHandler());
         }

         MediaRouterJellybeanMr1.ActiveScanWorkaround var1 = this.mActiveScanWorkaround;
         int var2;
         if(this.mActiveScan) {
            var2 = this.mRouteTypes;
         } else {
            var2 = 0;
         }

         var1.setActiveScanRouteTypes(var2);
      }
   }

   private static class JellybeanMr2Impl extends SystemMediaRouteProvider.JellybeanMr1Impl {
      public JellybeanMr2Impl(Context var1, SystemMediaRouteProvider.SyncCallback var2) {
         super(var1, var2);
      }

      protected Object getDefaultRoute() {
         return MediaRouterJellybeanMr2.getDefaultRoute(this.mRouterObj);
      }

      protected boolean isConnecting(SystemMediaRouteProvider.SystemRouteRecord var1) {
         return MediaRouterJellybeanMr2.RouteInfo.isConnecting(var1.mRouteObj);
      }

      protected void onBuildSystemRouteDescriptor(SystemMediaRouteProvider.SystemRouteRecord var1, MediaRouteDescriptor.Builder var2) {
         super.onBuildSystemRouteDescriptor(var1, var2);
         CharSequence var3 = MediaRouterJellybeanMr2.RouteInfo.getDescription(var1.mRouteObj);
         if(var3 != null) {
            var2.setDescription(var3.toString());
         }

      }

      protected void selectRoute(Object var1) {
         MediaRouterJellybean.selectRoute(this.mRouterObj, 8388611, var1);
      }

      protected void updateCallback() {
         byte var1 = 1;
         if(this.mCallbackRegistered) {
            MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
         }

         this.mCallbackRegistered = (boolean)var1;
         Object var2 = this.mRouterObj;
         int var3 = this.mRouteTypes;
         Object var4 = this.mCallbackObj;
         if(!this.mActiveScan) {
            var1 = 0;
         }

         MediaRouterJellybeanMr2.addCallback(var2, var3, var4, var1 | 2);
      }

      protected void updateUserRouteProperties(SystemMediaRouteProvider.UserRouteRecord var1) {
         super.updateUserRouteProperties(var1);
         MediaRouterJellybeanMr2.UserRouteInfo.setDescription(var1.mRouteObj, var1.mRoute.getDescription());
      }
   }

   static class LegacyImpl extends SystemMediaRouteProvider {
      private static final ArrayList<IntentFilter> CONTROL_FILTERS;
      private static final int PLAYBACK_STREAM = 3;
      private final AudioManager mAudioManager;
      private int mLastReportedVolume = -1;
      private final SystemMediaRouteProvider.VolumeChangeReceiver mVolumeChangeReceiver;

      static {
         IntentFilter var0 = new IntentFilter();
         var0.addCategory("android.media.intent.category.LIVE_AUDIO");
         var0.addCategory("android.media.intent.category.LIVE_VIDEO");
         CONTROL_FILTERS = new ArrayList();
         CONTROL_FILTERS.add(var0);
      }

      public LegacyImpl(Context var1) {
         super(var1);
         this.mAudioManager = (AudioManager)var1.getSystemService("audio");
         this.mVolumeChangeReceiver = new SystemMediaRouteProvider.VolumeChangeReceiver();
         var1.registerReceiver(this.mVolumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
         this.publishRoutes();
      }

      private void publishRoutes() {
         Resources var1 = this.getContext().getResources();
         int var2 = this.mAudioManager.getStreamMaxVolume(3);
         this.mLastReportedVolume = this.mAudioManager.getStreamVolume(3);
         MediaRouteDescriptor var3 = (new MediaRouteDescriptor.Builder("DEFAULT_ROUTE", var1.getString(class_16.string.mr_system_route_name))).addControlFilters(CONTROL_FILTERS).setPlaybackStream(3).setPlaybackType(0).setVolumeHandling(1).setVolumeMax(var2).setVolume(this.mLastReportedVolume).build();
         this.setDescriptor((new MediaRouteProviderDescriptor.Builder()).addRoute(var3).build());
      }

      public MediaRouteProvider.RouteController onCreateRouteController(String var1) {
         return var1.equals("DEFAULT_ROUTE")?new SystemMediaRouteProvider.DefaultRouteController():null;
      }
   }

   final class DefaultRouteController extends MediaRouteProvider.RouteController {
      public void onSetVolume(int var1) {
         SystemMediaRouteProvider.super.mAudioManager.setStreamVolume(3, var1, 0);
         SystemMediaRouteProvider.super.publishRoutes();
      }

      public void onUpdateVolume(int var1) {
         int var2 = SystemMediaRouteProvider.super.mAudioManager.getStreamVolume(3);
         if(Math.min(SystemMediaRouteProvider.super.mAudioManager.getStreamMaxVolume(3), Math.max(0, var2 + var1)) != var2) {
            SystemMediaRouteProvider.super.mAudioManager.setStreamVolume(3, var2, 0);
         }

         SystemMediaRouteProvider.super.publishRoutes();
      }
   }

   final class VolumeChangeReceiver extends BroadcastReceiver {
      public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
      public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
      public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";

      public void onReceive(Context var1, Intent var2) {
         if(var2.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && var2.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
            int var3 = var2.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
            if(var3 >= 0 && var3 != SystemMediaRouteProvider.super.mLastReportedVolume) {
               SystemMediaRouteProvider.super.publishRoutes();
            }
         }

      }
   }

   public interface SyncCallback {
      MediaRouter.RouteInfo getSystemRouteByDescriptorId(String var1);
   }
}

package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.parse.GCMService;
import com.parse.GcmRegistrar;
import com.parse.ManifestInfo;
import com.parse.PLog;
import com.parse.PPNSUtil;
import com.parse.ParseInstallation;
import com.parse.ParsePlugins;
import com.parse.ProxyService;
import com.parse.PushType;
import com.parse.ServiceUtils;
import java.util.List;

public final class PushService extends Service {
   static final String ACTION_START_IF_REQUIRED = "com.parse.PushService.startIfRequired";
   private static final String TAG = "com.parse.PushService";
   private static boolean loggedStartError = false;
   private static List<PushService.ServiceLifecycleCallbacks> serviceLifecycleCallbacks = null;
   private ProxyService proxy;

   private static Object[] collectServiceLifecycleCallbacks() {
      // $FF: Couldn't be decompiled
   }

   private static void dispatchOnServiceCreated(Service var0) {
      Object[] var1 = collectServiceLifecycleCallbacks();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            ((PushService.ServiceLifecycleCallbacks)var1[var3]).onServiceCreated(var0);
         }
      }

   }

   private static void dispatchOnServiceDestroyed(Service var0) {
      Object[] var1 = collectServiceLifecycleCallbacks();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            ((PushService.ServiceLifecycleCallbacks)var1[var3]).onServiceDestroyed(var0);
         }
      }

   }

   static void registerServiceLifecycleCallbacks(PushService.ServiceLifecycleCallbacks param0) {
      // $FF: Couldn't be decompiled
   }

   static void startServiceIfRequired(Context var0) {
      switch(null.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()]) {
      case 1:
         ParseInstallation var2 = ParseInstallation.getCurrentInstallation();
         if(var2.getPushType() == PushType.GCM) {
            PLog.method_367("com.parse.PushService", "Detected a client that used to use GCM and is now using PPNS.");
            var2.removePushType();
            var2.removeDeviceToken();
            var2.saveEventually();
         }

         ServiceUtils.runIntentInService(var0, new Intent("com.parse.PushService.startIfRequired"), PushService.class);
         return;
      case 2:
         GcmRegistrar.getInstance().registerAsync();
         return;
      default:
         if(!loggedStartError) {
            PLog.method_361("com.parse.PushService", "Tried to use push, but this app is not configured for push due to: " + ManifestInfo.getNonePushTypeLogMessage());
            loggedStartError = true;
         }

      }
   }

   static void stopServiceIfRequired(Context var0) {
      switch(null.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()]) {
      case 1:
         var0.stopService(new Intent(var0, PushService.class));
         return;
      default:
      }
   }

   static void unregisterServiceLifecycleCallbacks(PushService.ServiceLifecycleCallbacks param0) {
      // $FF: Couldn't be decompiled
   }

   public IBinder onBind(Intent var1) {
      throw new IllegalArgumentException("You cannot bind directly to the PushService. Use PushService.subscribe instead.");
   }

   public void onCreate() {
      super.onCreate();
      if(ParsePlugins.Android.get().applicationContext() == null) {
         PLog.method_361("com.parse.PushService", "The Parse push service cannot start because Parse.initialize has not yet been called. If you call Parse.initialize from an Activity\'s onCreate, that call should instead be in the Application.onCreate. Be sure your Application class is registered in your AndroidManifest.xml with the android:name property of your <application> tag.");
         this.stopSelf();
      } else {
         switch(null.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()]) {
         case 1:
            this.proxy = PPNSUtil.newPPNSService(this);
            break;
         case 2:
            this.proxy = new GCMService(this);
            break;
         default:
            PLog.method_361("com.parse.PushService", "PushService somehow started even though this device doesn\'t support push.");
         }

         if(this.proxy != null) {
            this.proxy.onCreate();
         }

         dispatchOnServiceCreated(this);
      }
   }

   public void onDestroy() {
      if(this.proxy != null) {
         this.proxy.onDestroy();
      }

      dispatchOnServiceDestroyed(this);
      super.onDestroy();
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      switch(null.$SwitchMap$com$parse$PushType[ManifestInfo.getPushType().ordinal()]) {
      case 1:
      case 2:
         return this.proxy.onStartCommand(var1, var2, var3);
      default:
         PLog.method_361("com.parse.PushService", "Started push service even though no push service is enabled: " + var1);
         ServiceUtils.completeWakefulIntent(var1);
         return 2;
      }
   }

   interface ServiceLifecycleCallbacks {
      void onServiceCreated(Service var1);

      void onServiceDestroyed(Service var1);
   }
}

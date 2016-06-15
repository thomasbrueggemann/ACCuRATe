package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_1000;
import com.google.android.gms.wearable.internal.class_187;
import com.google.android.gms.wearable.internal.class_985;

public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener {
   public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
   // $FF: renamed from: CS java.lang.String
   private String field_4470;
   // $FF: renamed from: Nk android.os.IBinder
   private IBinder field_4471;
   // $FF: renamed from: Pj int
   private volatile int field_4472 = -1;
   private Handler axn;
   private Object axo = new Object();
   private boolean axp;

   // $FF: renamed from: a (com.google.android.gms.wearable.WearableListenerService) java.lang.String
   // $FF: synthetic method
   static String method_5814(WearableListenerService var0) {
      return var0.field_4470;
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.WearableListenerService) void
   // $FF: synthetic method
   static void method_5815(WearableListenerService var0) throws SecurityException {
      var0.method_5820();
   }

   // $FF: renamed from: bh (int) boolean
   private boolean method_5816(int var1) {
      String[] var2 = this.getPackageManager().getPackagesForUid(var1);
      boolean var3 = false;
      if(var2 != null) {
         int var4 = 0;

         while(true) {
            int var5 = var2.length;
            var3 = false;
            if(var4 >= var5) {
               break;
            }

            if("com.google.android.gms".equals(var2[var4])) {
               var3 = true;
               break;
            }

            ++var4;
         }
      }

      return var3;
   }

   // $FF: renamed from: c (com.google.android.gms.wearable.WearableListenerService) java.lang.Object
   // $FF: synthetic method
   static Object method_5817(WearableListenerService var0) {
      return var0.axo;
   }

   // $FF: renamed from: d (com.google.android.gms.wearable.WearableListenerService) boolean
   // $FF: synthetic method
   static boolean method_5818(WearableListenerService var0) {
      return var0.axp;
   }

   // $FF: renamed from: e (com.google.android.gms.wearable.WearableListenerService) android.os.Handler
   // $FF: synthetic method
   static Handler method_5819(WearableListenerService var0) {
      return var0.axn;
   }

   // $FF: renamed from: rl () void
   private void method_5820() throws SecurityException {
      int var1 = Binder.getCallingUid();
      if(var1 != this.field_4472) {
         if(GooglePlayServicesUtil.method_4806(this.getPackageManager(), "com.google.android.gms") && this.method_5816(var1)) {
            this.field_4472 = var1;
         } else {
            throw new SecurityException("Caller is not GooglePlayServices");
         }
      }
   }

   public final IBinder onBind(Intent var1) {
      return "com.google.android.gms.wearable.BIND_LISTENER".equals(var1.getAction())?this.field_4471:null;
   }

   public void onCreate() {
      super.onCreate();
      if(Log.isLoggable("WearableLS", 3)) {
         Log.d("WearableLS", "onCreate: " + this.getPackageName());
      }

      this.field_4470 = this.getPackageName();
      HandlerThread var1 = new HandlerThread("WearableListenerService");
      var1.start();
      this.axn = new Handler(var1.getLooper());
      this.field_4471 = new WearableListenerService.class_1469();
   }

   public void onDataChanged(DataEventBuffer var1) {
   }

   public void onDestroy() {
      // $FF: Couldn't be decompiled
   }

   public void onMessageReceived(MessageEvent var1) {
   }

   public void onPeerConnected(Node var1) {
   }

   public void onPeerDisconnected(Node var1) {
   }

   private class class_1469 extends class_187.class_1336 {
      private class_1469() {
      }

      // $FF: synthetic method
      class_1469(Object var2) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
      public void method_976(class_1000 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.al) void
      public void method_977(class_985 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
      public void method_978(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.al) void
      public void method_979(class_985 param1) {
         // $FF: Couldn't be decompiled
      }
   }
}

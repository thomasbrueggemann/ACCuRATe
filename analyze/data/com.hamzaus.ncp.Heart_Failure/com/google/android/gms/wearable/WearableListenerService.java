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
import com.google.android.gms.wearable.internal.class_150;
import com.google.android.gms.wearable.internal.class_770;
import com.google.android.gms.wearable.internal.class_773;

public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener {
   public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
   // $FF: renamed from: Gz android.os.IBinder
   private IBinder field_4320;
   private volatile int aln = -1;
   private Handler alo;
   private Object alp = new Object();
   private boolean alq;
   // $FF: renamed from: xN java.lang.String
   private String field_4321;

   // $FF: renamed from: a (com.google.android.gms.wearable.WearableListenerService) java.lang.String
   // $FF: synthetic method
   static String method_4540(WearableListenerService var0) {
      return var0.field_4321;
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.WearableListenerService) void
   // $FF: synthetic method
   static void method_4541(WearableListenerService var0) throws SecurityException {
      var0.method_4546();
   }

   // $FF: renamed from: c (com.google.android.gms.wearable.WearableListenerService) java.lang.Object
   // $FF: synthetic method
   static Object method_4542(WearableListenerService var0) {
      return var0.alp;
   }

   // $FF: renamed from: d (com.google.android.gms.wearable.WearableListenerService) boolean
   // $FF: synthetic method
   static boolean method_4543(WearableListenerService var0) {
      return var0.alq;
   }

   // $FF: renamed from: e (com.google.android.gms.wearable.WearableListenerService) android.os.Handler
   // $FF: synthetic method
   static Handler method_4544(WearableListenerService var0) {
      return var0.alo;
   }

   // $FF: renamed from: ed (int) boolean
   private boolean method_4545(int var1) {
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

   // $FF: renamed from: ni () void
   private void method_4546() throws SecurityException {
      int var1 = Binder.getCallingUid();
      if(var1 != this.aln) {
         if(GooglePlayServicesUtil.method_3838(this.getPackageManager(), "com.google.android.gms") && this.method_4545(var1)) {
            this.aln = var1;
         } else {
            throw new SecurityException("Caller is not GooglePlayServices");
         }
      }
   }

   public final IBinder onBind(Intent var1) {
      return "com.google.android.gms.wearable.BIND_LISTENER".equals(var1.getAction())?this.field_4320:null;
   }

   public void onCreate() {
      super.onCreate();
      if(Log.isLoggable("WearableLS", 3)) {
         Log.d("WearableLS", "onCreate: " + this.getPackageName());
      }

      this.field_4321 = this.getPackageName();
      HandlerThread var1 = new HandlerThread("WearableListenerService");
      var1.start();
      this.alo = new Handler(var1.getLooper());
      this.field_4320 = new WearableListenerService.class_1125();
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

   private class class_1125 extends class_150.class_1306 {
      private class_1125() {
      }

      // $FF: synthetic method
      class_1125(Object var2) {
         this();
      }

      // $FF: renamed from: Y (com.google.android.gms.common.data.DataHolder) void
      public void method_799(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.af) void
      public void method_800(class_773 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai) void
      public void method_801(class_770 param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.wearable.internal.ai) void
      public void method_802(class_770 param1) {
         // $FF: Couldn't be decompiled
      }
   }
}

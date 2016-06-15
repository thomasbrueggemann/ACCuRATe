package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.class_190;
import com.google.android.gms.drive.internal.class_265;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
   public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
   // $FF: renamed from: Pg java.util.concurrent.CountDownLatch
   private CountDownLatch field_743;
   // $FF: renamed from: Ph com.google.android.gms.drive.events.DriveEventService$a
   DriveEventService.class_1091 field_744;
   // $FF: renamed from: Pi boolean
   boolean field_745;
   // $FF: renamed from: Pj int
   int field_746;
   private final String mName;

   protected DriveEventService() {
      this("DriveEventService");
   }

   protected DriveEventService(String var1) {
      this.field_745 = false;
      this.field_746 = -1;
      this.mName = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEventService) void
   // $FF: synthetic method
   static void method_2199(DriveEventService var0) throws SecurityException {
      var0.method_2204();
   }

   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnEventResponse) void
   private void method_2201(OnEventResponse var1) {
      DriveEvent var2 = var1.method_3562();
      class_265.method_1702("DriveEventService", "handleEventMessage: " + var2);

      try {
         switch(var2.getType()) {
         case 1:
            this.onChange((ChangeEvent)var2);
            return;
         case 2:
            this.onCompletion((CompletionEvent)var2);
            return;
         default:
            class_265.method_1703(this.mName, "Unhandled event: " + var2);
         }
      } catch (Exception var4) {
         class_265.method_1700(this.mName, var4, "Error handling event: " + var2);
      }
   }

   // $FF: renamed from: bh (int) boolean
   private boolean method_2203(int var1) {
      String[] var2 = this.getPackageManager().getPackagesForUid(var1);
      boolean var3 = false;
      if(var2 != null) {
         int var4 = var2.length;
         int var5 = 0;

         while(true) {
            var3 = false;
            if(var5 >= var4) {
               break;
            }

            if("com.google.android.gms".equals(var2[var5])) {
               var3 = true;
               break;
            }

            ++var5;
         }
      }

      return var3;
   }

   // $FF: renamed from: iD () void
   private void method_2204() throws SecurityException {
      int var1 = this.getCallingUid();
      if(var1 != this.field_746) {
         if(GooglePlayServicesUtil.method_4806(this.getPackageManager(), "com.google.android.gms") && this.method_2203(var1)) {
            this.field_746 = var1;
         } else {
            throw new SecurityException("Caller is not GooglePlayServices");
         }
      }
   }

   protected int getCallingUid() {
      return Binder.getCallingUid();
   }

   public final IBinder onBind(Intent var1) {
      synchronized(this){}
      boolean var9 = false;

      IBinder var3;
      IBinder var4;
      label88: {
         try {
            var9 = true;
            if("com.google.android.gms.drive.events.HANDLE_EVENT".equals(var1.getAction())) {
               if(this.field_744 == null && !this.field_745) {
                  this.field_745 = true;
                  final CountDownLatch var5 = new CountDownLatch(1);
                  this.field_743 = new CountDownLatch(1);
                  (new Thread() {
                     public void run() {
                        try {
                           Looper.prepare();
                           DriveEventService.this.field_744 = DriveEventService.this.new class_1091();
                           DriveEventService.this.field_745 = false;
                           var5.countDown();
                           class_265.method_1702("DriveEventService", "Bound and starting loop");
                           Looper.loop();
                           class_265.method_1702("DriveEventService", "Finished loop");
                        } finally {
                           if(DriveEventService.this.field_743 != null) {
                              DriveEventService.this.field_743.countDown();
                           }

                        }

                     }
                  }).start();

                  try {
                     if(!var5.await(5000L, TimeUnit.MILLISECONDS)) {
                        class_265.method_1704("DriveEventService", "Failed to synchronously initialize event handler.");
                     }
                  } catch (InterruptedException var10) {
                     throw new RuntimeException("Unable to start event handler", var10);
                  }
               }

               var4 = (new DriveEventService.class_1092()).asBinder();
               var9 = false;
               break label88;
            }

            var9 = false;
         } finally {
            if(var9) {
               ;
            }
         }

         var3 = null;
         return var3;
      }

      var3 = var4;
      return var3;
   }

   public void onChange(ChangeEvent var1) {
      class_265.method_1703(this.mName, "Unhandled change event: " + var1);
   }

   public void onCompletion(CompletionEvent var1) {
      class_265.method_1703(this.mName, "Unhandled completion event: " + var1);
   }

   public void onDestroy() {
      synchronized(this){}

      try {
         class_265.method_1702("DriveEventService", "onDestroy");
         if(this.field_744 != null) {
            Message var2 = this.field_744.method_5527();
            this.field_744.sendMessage(var2);
            this.field_744 = null;

            try {
               if(!this.field_743.await(5000L, TimeUnit.MILLISECONDS)) {
                  class_265.method_1703("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
               }
            } catch (InterruptedException var7) {
               ;
            }

            this.field_743 = null;
         }

         super.onDestroy();
      } finally {
         ;
      }

   }

   public boolean onUnbind(Intent var1) {
      return true;
   }

   final class class_1091 extends Handler {
      // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEventService$a, com.google.android.gms.drive.internal.OnEventResponse) android.os.Message
      // $FF: synthetic method
      static Message method_5525(DriveEventService.class_1091 var0, OnEventResponse var1) {
         return var0.method_5526(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.drive.internal.OnEventResponse) android.os.Message
      private Message method_5526(OnEventResponse var1) {
         return this.obtainMessage(1, var1);
      }

      // $FF: renamed from: iE () android.os.Message
      private Message method_5527() {
         return this.obtainMessage(2);
      }

      public void handleMessage(Message var1) {
         class_265.method_1702("DriveEventService", "handleMessage message type:" + var1.what);
         switch(var1.what) {
         case 1:
            DriveEventService.this.method_2201((OnEventResponse)var1.obj);
            return;
         case 2:
            this.getLooper().quit();
            return;
         default:
            class_265.method_1703("DriveEventService", "Unexpected message type:" + var1.what);
         }
      }
   }

   final class class_1092 extends class_190.class_1244 {
      // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
      public void method_1011(OnEventResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}

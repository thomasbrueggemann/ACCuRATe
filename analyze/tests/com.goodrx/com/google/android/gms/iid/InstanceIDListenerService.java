package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.iid.zzc;
import com.google.android.gms.iid.zzd;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
   static String ACTION = "action";
   private static String zzaLH = "gcm.googleapis.com/refresh";
   private static String zzaMY = "google.com/iid";
   private static String zzaMZ = "CMD";
   MessengerCompat zzaMW;
   BroadcastReceiver zzaMX;
   int zzaNa;
   int zzaNb;

   static void zza(Context var0, zzd var1) {
      var1.zzyG();
      Intent var2 = new Intent("com.google.android.gms.iid.InstanceID");
      var2.putExtra(zzaMZ, "RST");
      var2.setPackage(var0.getPackageName());
      var0.startService(var2);
   }

   static void zzaM(Context var0) {
      Intent var1 = new Intent("com.google.android.gms.iid.InstanceID");
      var1.setPackage(var0.getPackageName());
      var1.putExtra(zzaMZ, "SYNC");
      var0.startService(var1);
   }

   public IBinder onBind(Intent var1) {
      return var1 != null && "com.google.android.gms.iid.InstanceID".equals(var1.getAction())?this.zzaMW.getBinder():null;
   }

   public void onCreate() {
      IntentFilter var1 = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
      var1.addCategory(this.getPackageName());
      this.registerReceiver(this.zzaMX, var1, "com.google.android.c2dm.permission.RECEIVE", (Handler)null);
   }

   public void onDestroy() {
      this.unregisterReceiver(this.zzaMX);
   }

   public int onStartCommand(Intent param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void onTokenRefresh() {
   }

   void stop() {
      // $FF: Couldn't be decompiled
   }

   public void zzal(boolean var1) {
      this.onTokenRefresh();
   }

   void zzhl(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzp(Intent var1) {
      String var2 = var1.getStringExtra("subtype");
      InstanceID var4;
      if(var2 == null) {
         var4 = InstanceID.getInstance(this);
      } else {
         Bundle var3 = new Bundle();
         var3.putString("subtype", var2);
         var4 = InstanceID.zza(this, var3);
      }

      String var5 = var1.getStringExtra(zzaMZ);
      if(var1.getStringExtra("error") == null && var1.getStringExtra("registration_id") == null) {
         if(Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Service command " + var2 + " " + var5 + " " + var1.getExtras());
         }

         if(var1.getStringExtra("unregistered") != null) {
            zzd var9 = var4.zzyB();
            if(var2 == null) {
               var2 = "";
            }

            var9.zzef(var2);
            var4.zzyC().zzw(var1);
            return;
         }

         if(zzaLH.equals(var1.getStringExtra("from"))) {
            var4.zzyB().zzef(var2);
            this.zzal(false);
            return;
         }

         if("RST".equals(var5)) {
            var4.zzyA();
            this.zzal(true);
            return;
         }

         if("RST_FULL".equals(var5)) {
            if(!var4.zzyB().isEmpty()) {
               var4.zzyB().zzyG();
               this.zzal(true);
               return;
            }
         } else {
            if("SYNC".equals(var5)) {
               var4.zzyB().zzef(var2);
               this.zzal(false);
               return;
            }

            if("PING".equals(var5)) {
               try {
                  GoogleCloudMessaging.getInstance(this).send(zzaMY, zzc.zzyF(), 0L, var1.getExtras());
                  return;
               } catch (IOException var10) {
                  Log.w("InstanceID", "Failed to send ping response");
                  return;
               }
            }
         }
      } else {
         if(Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + var2);
         }

         var4.zzyC().zzw(var1);
      }

   }
}

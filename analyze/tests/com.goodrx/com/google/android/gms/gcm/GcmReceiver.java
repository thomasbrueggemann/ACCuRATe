package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

public class GcmReceiver extends WakefulBroadcastReceiver {
   private static String zzaLH = "gcm.googleapis.com/refresh";

   private void zzj(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }

   private void zzk(Context var1, Intent var2) {
      ResolveInfo var3 = var1.getPackageManager().resolveService(var2, 0);
      if(var3 != null && var3.serviceInfo != null) {
         ServiceInfo var5 = var3.serviceInfo;
         if(var1.getPackageName().equals(var5.packageName) && var5.name != null) {
            String var7 = var5.name;
            if(var7.startsWith(".")) {
               var7 = var1.getPackageName() + var7;
            }

            if(Log.isLoggable("GcmReceiver", 3)) {
               Log.d("GcmReceiver", "Restricting intent to a specific service: " + var7);
            }

            var2.setClassName(var1.getPackageName(), var7);
         } else {
            Log.e("GcmReceiver", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + var5.packageName + "/" + var5.name);
         }
      } else {
         Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
      }
   }

   public void onReceive(Context var1, Intent var2) {
      var2.setComponent((ComponentName)null);
      var2.setPackage(var1.getPackageName());
      if(VERSION.SDK_INT <= 18) {
         var2.removeCategory(var1.getPackageName());
      }

      String var5 = var2.getStringExtra("from");
      if("com.google.android.c2dm.intent.REGISTRATION".equals(var2.getAction()) || "google.com/iid".equals(var5) || zzaLH.equals(var5)) {
         var2.setAction("com.google.android.gms.iid.InstanceID");
      }

      String var7 = var2.getStringExtra("gcm.rawData64");
      if(var7 != null) {
         var2.putExtra("rawData", Base64.decode(var7, 0));
         var2.removeExtra("gcm.rawData64");
      }

      if("com.google.android.c2dm.intent.RECEIVE".equals(var2.getAction())) {
         this.zzi(var1, var2);
      } else {
         this.zzj(var1, var2);
      }

      if(this.isOrderedBroadcast() && this.getResultCode() == 0) {
         this.setResultCode(-1);
      }

   }

   public void zzi(Context var1, Intent var2) {
      this.zzj(var1, var2);
   }
}

package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;

abstract class zzn extends BroadcastReceiver {
   protected Context mContext;

   @Nullable
   public static <T extends zzn> T zza(Context var0, T var1) {
      return zza(var0, var1, com.google.android.gms.common.zzc.zzoK());
   }

   @Nullable
   public static <T extends zzn> T zza(Context var0, T var1, com.google.android.gms.common.zzc var2) {
      IntentFilter var3 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
      var3.addDataScheme("package");
      var0.registerReceiver(var1, var3);
      var1.mContext = var0;
      if(!var2.zzi(var0, "com.google.android.gms")) {
         var1.zzpJ();
         var1.unregister();
         var1 = null;
      }

      return var1;
   }

   public void onReceive(Context var1, Intent var2) {
      Uri var3 = var2.getData();
      String var4 = null;
      if(var3 != null) {
         var4 = var3.getSchemeSpecificPart();
      }

      if("com.google.android.gms".equals(var4)) {
         this.zzpJ();
         this.unregister();
      }

   }

   public void unregister() {
      synchronized(this){}

      try {
         if(this.mContext != null) {
            this.mContext.unregisterReceiver(this);
         }

         this.mContext = null;
      } finally {
         ;
      }

   }

   protected abstract void zzpJ();
}

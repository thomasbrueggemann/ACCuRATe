package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;

public class CampaignTrackingService extends Service {
   private static Boolean zzOO;
   private Handler mHandler;

   private Handler getHandler() {
      Handler var1 = this.mHandler;
      if(var1 == null) {
         var1 = new Handler(this.getMainLooper());
         this.mHandler = var1;
      }

      return var1;
   }

   public static boolean zzZ(Context var0) {
      zzx.zzz(var0);
      if(zzOO != null) {
         return zzOO.booleanValue();
      } else {
         boolean var2 = zzam.zza(var0, CampaignTrackingService.class);
         zzOO = Boolean.valueOf(var2);
         return var2;
      }
   }

   private void zziz() {
      // $FF: Couldn't be decompiled
   }

   public IBinder onBind(Intent var1) {
      return null;
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public void onCreate() {
      super.onCreate();
      zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is starting up");
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public void onDestroy() {
      zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is shutting down");
      super.onDestroy();
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public int onStartCommand(Intent var1, int var2, final int var3) {
      this.zziz();
      zzf var4 = zzf.zzaa(this);
      final zzaf var5 = var4.zzjm();
      String var6 = null;
      if(var4.zzjn().zzkr()) {
         var5.zzbh("Unexpected installation campaign (package side)");
      } else {
         var6 = var1.getStringExtra("referrer");
      }

      final Handler var7 = this.getHandler();
      if(TextUtils.isEmpty(var6)) {
         if(!var4.zzjn().zzkr()) {
            var5.zzbg("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
         }

         var4.zzjo().zzf(new Runnable() {
            public void run() {
               CampaignTrackingService.this.zza(var5, var7, var3);
            }
         });
         return 2;
      } else {
         int var8 = var4.zzjn().zzkv();
         if(var6.length() > var8) {
            var5.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(var6.length()), Integer.valueOf(var8));
            var6 = var6.substring(0, var8);
         }

         var5.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(var3), var6);
         var4.zziH().zza(var6, new Runnable() {
            public void run() {
               CampaignTrackingService.this.zza(var5, var7, var3);
            }
         });
         return 2;
      }
   }

   protected void zza(final zzaf var1, Handler var2, final int var3) {
      var2.post(new Runnable() {
         public void run() {
            boolean var1x = CampaignTrackingService.this.stopSelfResult(var3);
            if(var1x) {
               var1.zza("Install campaign broadcast processed", Boolean.valueOf(var1x));
            }

         }
      });
   }
}

package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class AnalyticsService extends Service {
   private static Boolean zzOO;
   private final Handler mHandler = new Handler();

   public static boolean zzZ(Context var0) {
      zzx.zzz(var0);
      if(zzOO != null) {
         return zzOO.booleanValue();
      } else {
         boolean var2 = zzam.zza(var0, AnalyticsService.class);
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
      zzf var1 = zzf.zzaa(this);
      zzaf var2 = var1.zzjm();
      if(var1.zzjn().zzkr()) {
         var2.zzbd("Device AnalyticsService is starting up");
      } else {
         var2.zzbd("Local AnalyticsService is starting up");
      }
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public void onDestroy() {
      zzf var1 = zzf.zzaa(this);
      zzaf var2 = var1.zzjm();
      if(var1.zzjn().zzkr()) {
         var2.zzbd("Device AnalyticsService is shutting down");
      } else {
         var2.zzbd("Local AnalyticsService is shutting down");
      }

      super.onDestroy();
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public int onStartCommand(Intent var1, int var2, final int var3) {
      this.zziz();
      final zzf var4 = zzf.zzaa(this);
      final zzaf var5 = var4.zzjm();
      String var6 = var1.getAction();
      if(var4.zzjn().zzkr()) {
         var5.zza("Device AnalyticsService called. startId, action", Integer.valueOf(var3), var6);
      } else {
         var5.zza("Local AnalyticsService called. startId, action", Integer.valueOf(var3), var6);
      }

      if("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(var6)) {
         var4.zziH().zza(new zzw() {
            public void zzc(Throwable var1) {
               AnalyticsService.this.mHandler.post(new Runnable() {
                  public void run() {
                     if(AnalyticsService.this.stopSelfResult(var3)) {
                        if(!var4.zzjn().zzkr()) {
                           var5.zzbd("Local AnalyticsService processed last dispatch request");
                           return;
                        }

                        var5.zzbd("Device AnalyticsService processed last dispatch request");
                     }

                  }
               });
            }
         });
      }

      return 2;
   }
}

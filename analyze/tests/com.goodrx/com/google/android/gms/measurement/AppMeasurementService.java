package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzw;

public final class AppMeasurementService extends Service {
   private static Boolean zzOO;
   private final Handler mHandler = new Handler();

   private zzp zzAo() {
      return zzw.zzaT(this).zzAo();
   }

   public static boolean zzZ(Context var0) {
      zzx.zzz(var0);
      if(zzOO != null) {
         return zzOO.booleanValue();
      } else {
         boolean var2 = zzaj.zza(var0, AppMeasurementService.class);
         zzOO = Boolean.valueOf(var2);
         return var2;
      }
   }

   private void zziz() {
      // $FF: Couldn't be decompiled
   }

   @MainThread
   public IBinder onBind(Intent var1) {
      if(var1 == null) {
         this.zzAo().zzCE().zzfg("onBind called with null intent");
         return null;
      } else {
         String var2 = var1.getAction();
         if("com.google.android.gms.measurement.START".equals(var2)) {
            return new com.google.android.gms.measurement.internal.zzx(zzw.zzaT(this));
         } else {
            this.zzAo().zzCF().zzj("onBind received unknown action", var2);
            return null;
         }
      }
   }

   @MainThread
   public void onCreate() {
      super.onCreate();
      zzw var1 = zzw.zzaT(this);
      zzp var2 = var1.zzAo();
      if(var1.zzCp().zzkr()) {
         var2.zzCK().zzfg("Device AppMeasurementService is starting up");
      } else {
         var2.zzCK().zzfg("Local AppMeasurementService is starting up");
      }
   }

   @MainThread
   public void onDestroy() {
      zzw var1 = zzw.zzaT(this);
      zzp var2 = var1.zzAo();
      if(var1.zzCp().zzkr()) {
         var2.zzCK().zzfg("Device AppMeasurementService is shutting down");
      } else {
         var2.zzCK().zzfg("Local AppMeasurementService is shutting down");
      }

      super.onDestroy();
   }

   @MainThread
   public void onRebind(Intent var1) {
      if(var1 == null) {
         this.zzAo().zzCE().zzfg("onRebind called with null intent");
      } else {
         String var2 = var1.getAction();
         this.zzAo().zzCK().zzj("onRebind called. action", var2);
      }
   }

   @MainThread
   public int onStartCommand(Intent var1, int var2, final int var3) {
      this.zziz();
      final zzw var4 = zzw.zzaT(this);
      final zzp var5 = var4.zzAo();
      String var6 = var1.getAction();
      if(var4.zzCp().zzkr()) {
         var5.zzCK().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(var3), var6);
      } else {
         var5.zzCK().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(var3), var6);
      }

      if("com.google.android.gms.measurement.UPLOAD".equals(var6)) {
         var4.zzCn().zzg(new Runnable() {
            public void run() {
               var4.zzDc();
               AppMeasurementService.this.mHandler.post(new Runnable() {
                  public void run() {
                     if(AppMeasurementService.this.stopSelfResult(var3)) {
                        if(!var4.zzCp().zzkr()) {
                           var5.zzCK().zzfg("Local AppMeasurementService processed last upload request");
                           return;
                        }

                        var5.zzCK().zzfg("Device AppMeasurementService processed last upload request");
                     }

                  }
               });
            }
         });
      }

      return 2;
   }

   @MainThread
   public boolean onUnbind(Intent var1) {
      if(var1 == null) {
         this.zzAo().zzCE().zzfg("onUnbind called with null intent");
         return true;
      } else {
         String var2 = var1.getAction();
         this.zzAo().zzCK().zzj("onUnbind called for intent. action", var2);
         return true;
      }
   }
}

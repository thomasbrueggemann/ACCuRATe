package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.internal.zzw;

abstract class zzf {
   private static volatile Handler zzRC;
   private volatile long zzRD;
   private final zzw zzaTV;
   private boolean zzaVI;
   private final Runnable zzx;

   zzf(zzw var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzaTV = var1;
      this.zzaVI = true;
      this.zzx = new Runnable() {
         public void run() {
            if(Looper.myLooper() == Looper.getMainLooper()) {
               zzf.this.zzaTV.zzCn().zzg(this);
            } else {
               boolean var1 = zzf.this.zzbw();
               zzf.this.zzRD = 0L;
               if(var1 && zzf.this.zzaVI) {
                  zzf.this.run();
                  return;
               }
            }

         }
      };
   }

   private Handler getHandler() {
      // $FF: Couldn't be decompiled
   }

   public void cancel() {
      this.zzRD = 0L;
      this.getHandler().removeCallbacks(this.zzx);
   }

   public abstract void run();

   public boolean zzbw() {
      return this.zzRD != 0L;
   }

   public void zzt(long var1) {
      this.cancel();
      if(var1 >= 0L) {
         this.zzRD = this.zzaTV.zzjl().currentTimeMillis();
         if(!this.getHandler().postDelayed(this.zzx, var1)) {
            this.zzaTV.zzAo().zzCE().zzj("Failed to schedule delayed post. time", Long.valueOf(var1));
         }
      }

   }
}

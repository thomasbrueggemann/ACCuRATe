package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.analytics.internal.zzf;

abstract class zzt {
   private static volatile Handler zzRC;
   private final zzf zzQj;
   private volatile long zzRD;
   private boolean zzRE;
   private final Runnable zzx;

   zzt(zzf var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzQj = var1;
      this.zzx = new Runnable() {
         public void run() {
            if(Looper.myLooper() == Looper.getMainLooper()) {
               zzt.this.zzQj.zzjo().zzf(this);
            } else {
               boolean var1 = zzt.this.zzbw();
               zzt.this.zzRD = 0L;
               if(var1 && !zzt.this.zzRE) {
                  zzt.this.run();
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

   public long zzkY() {
      return this.zzRD == 0L?0L:Math.abs(this.zzQj.zzjl().currentTimeMillis() - this.zzRD);
   }

   public void zzt(long var1) {
      this.cancel();
      if(var1 >= 0L) {
         this.zzRD = this.zzQj.zzjl().currentTimeMillis();
         if(!this.getHandler().postDelayed(this.zzx, var1)) {
            this.zzQj.zzjm().zze("Failed to schedule delayed post. time", Long.valueOf(var1));
         }
      }

   }

   public void zzu(long var1) {
      long var3 = 0L;
      if(this.zzbw()) {
         if(var1 < var3) {
            this.cancel();
            return;
         }

         long var5 = var1 - Math.abs(this.zzQj.zzjl().currentTimeMillis() - this.zzRD);
         if(var5 >= var3) {
            var3 = var5;
         }

         this.getHandler().removeCallbacks(this.zzx);
         if(!this.getHandler().postDelayed(this.zzx, var3)) {
            this.zzQj.zzjm().zze("Failed to adjust delayed post. time", Long.valueOf(var3));
            return;
         }
      }

   }
}

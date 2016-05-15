package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzn;
import com.google.android.gms.internal.zzr;
import java.util.concurrent.Executor;

public class zze implements zzn {
   private final Executor zzs;

   public zze(final Handler var1) {
      this.zzs = new Executor() {
         public void execute(Runnable var1x) {
            var1.post(var1x);
         }
      };
   }

   public void zza(zzk<?> var1, zzm<?> var2) {
      this.zza(var1, var2, (Runnable)null);
   }

   public void zza(zzk<?> var1, zzm<?> var2, Runnable var3) {
      var1.zzv();
      var1.zzc("post-response");
      this.zzs.execute(new zze.zza(var1, var2, var3));
   }

   public void zza(zzk<?> var1, zzr var2) {
      var1.zzc("post-error");
      zzm var3 = zzm.zzd(var2);
      this.zzs.execute(new zze.zza(var1, var3, (Runnable)null));
   }

   private class zza implements Runnable {
      private final zzk zzv;
      private final zzm zzw;
      private final Runnable zzx;

      public zza(zzk var2, zzm var3, Runnable var4) {
         this.zzv = var2;
         this.zzw = var3;
         this.zzx = var4;
      }

      public void run() {
         if(this.zzv.isCanceled()) {
            this.zzv.zzd("canceled-at-delivery");
         } else {
            if(this.zzw.isSuccess()) {
               this.zzv.zza(this.zzw.result);
            } else {
               this.zzv.zzc(this.zzw.zzah);
            }

            if(this.zzw.zzai) {
               this.zzv.zzc("intermediate-response");
            } else {
               this.zzv.zzd("done");
            }

            if(this.zzx != null) {
               this.zzx.run();
               return;
            }
         }

      }
   }
}

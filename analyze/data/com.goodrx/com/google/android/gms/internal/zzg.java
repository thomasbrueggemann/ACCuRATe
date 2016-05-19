package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzf;
import com.google.android.gms.internal.zzi;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzn;
import com.google.android.gms.internal.zzr;
import com.google.android.gms.internal.zzs;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
   private final zzb zzj;
   private final zzn zzk;
   private volatile boolean zzl = false;
   private final BlockingQueue<zzk<?>> zzy;
   private final zzf zzz;

   public zzg(BlockingQueue<zzk<?>> var1, zzf var2, zzb var3, zzn var4) {
      this.zzy = var1;
      this.zzz = var2;
      this.zzj = var3;
      this.zzk = var4;
   }

   @TargetApi(14)
   private void zzb(zzk<?> var1) {
      if(VERSION.SDK_INT >= 14) {
         TrafficStats.setThreadStatsTag(var1.zzg());
      }

   }

   private void zzb(zzk<?> var1, zzr var2) {
      zzr var3 = var1.zzb(var2);
      this.zzk.zza(var1, var3);
   }

   public void quit() {
      this.zzl = true;
      this.interrupt();
   }

   public void run() {
      Process.setThreadPriority(10);

      while(true) {
         long var1;
         zzk var4;
         while(true) {
            var1 = SystemClock.elapsedRealtime();

            try {
               var4 = (zzk)this.zzy.take();
               break;
            } catch (InterruptedException var11) {
               if(this.zzl) {
                  return;
               }
            }
         }

         try {
            var4.zzc("network-queue-take");
            if(var4.isCanceled()) {
               var4.zzd("network-discard-cancelled");
            } else {
               this.zzb(var4);
               zzi var9 = this.zzz.zza(var4);
               var4.zzc("network-http-complete");
               if(var9.zzB && var4.zzw()) {
                  var4.zzd("not-modified");
               } else {
                  zzm var10 = var4.zza(var9);
                  var4.zzc("network-parse-complete");
                  if(var4.zzr() && var10.zzag != null) {
                     this.zzj.zza(var4.zzh(), var10.zzag);
                     var4.zzc("network-cache-written");
                  }

                  var4.zzv();
                  this.zzk.zza(var4, var10);
               }
            }
         } catch (zzr var12) {
            var12.zza(SystemClock.elapsedRealtime() - var1);
            this.zzb(var4, var12);
         } catch (Exception var13) {
            Object[] var6 = new Object[]{var13.toString()};
            zzs.zza(var13, "Unhandled exception %s", var6);
            zzr var7 = new zzr(var13);
            var7.zza(SystemClock.elapsedRealtime() - var1);
            this.zzk.zza(var4, var7);
         }
      }
   }
}

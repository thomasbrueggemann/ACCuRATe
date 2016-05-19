package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzg;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzl;
import com.google.android.gms.analytics.internal.zzw;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb extends zzd {
   private final zzl zzQb;

   public zzb(zzf var1, zzg var2) {
      super(var1);
      com.google.android.gms.common.internal.zzx.zzz(var2);
      this.zzQb = var2.zzj(var1);
   }

   void onServiceConnected() {
      this.zzjk();
      this.zzQb.onServiceConnected();
   }

   public void start() {
      this.zzQb.start();
   }

   public void zzJ(final boolean var1) {
      this.zza("Network connectivity status changed", Boolean.valueOf(var1));
      this.zzjo().zzf(new Runnable() {
         public void run() {
            zzb.this.zzQb.zzJ(var1);
         }
      });
   }

   public long zza(zzh var1) {
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzjk();
      long var3 = this.zzQb.zza(var1, true);
      if(var3 == 0L) {
         this.zzQb.zzc(var1);
      }

      return var3;
   }

   public void zza(final zzab var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzjv();
      this.zzb("Hit delivery requested", var1);
      this.zzjo().zzf(new Runnable() {
         public void run() {
            zzb.this.zzQb.zza(var1);
         }
      });
   }

   public void zza(final zzw var1) {
      this.zzjv();
      this.zzjo().zzf(new Runnable() {
         public void run() {
            zzb.this.zzQb.zzb(var1);
         }
      });
   }

   public void zza(final String var1, final Runnable var2) {
      com.google.android.gms.common.internal.zzx.zzh(var1, "campaign param can\'t be empty");
      this.zzjo().zzf(new Runnable() {
         public void run() {
            zzb.this.zzQb.zzbl(var1);
            if(var2 != null) {
               var2.run();
            }

         }
      });
   }

   protected void zziJ() {
      this.zzQb.zza();
   }

   public void zzjd() {
      this.zzjv();
      Context var1 = this.getContext();
      if(AnalyticsReceiver.zzY(var1) && AnalyticsService.zzZ(var1)) {
         Intent var2 = new Intent(var1, AnalyticsService.class);
         var2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
         var1.startService(var2);
      } else {
         this.zza((zzw)null);
      }
   }

   public boolean zzje() {
      this.zzjv();
      Future var1 = this.zzjo().zzc(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.zzdt();
         }

         public Void zzdt() throws Exception {
            zzb.this.zzQb.zzka();
            return null;
         }
      });

      try {
         var1.get(4L, TimeUnit.SECONDS);
         return true;
      } catch (InterruptedException var5) {
         this.zzd("syncDispatchLocalHits interrupted", var5);
         return false;
      } catch (ExecutionException var6) {
         this.zze("syncDispatchLocalHits failed", var6);
         return false;
      } catch (TimeoutException var7) {
         this.zzd("syncDispatchLocalHits timed out", var7);
         return false;
      }
   }

   public void zzjf() {
      this.zzjv();
      com.google.android.gms.measurement.zzg.zzjk();
      this.zzQb.zzjf();
   }

   public void zzjg() {
      this.zzbd("Radio powered up");
      this.zzjd();
   }

   void zzjh() {
      this.zzjk();
      this.zzQb.zzjh();
   }
}

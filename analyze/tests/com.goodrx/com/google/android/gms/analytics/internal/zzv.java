package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;

public class zzv extends zzd {
   private boolean zzRG;
   private boolean zzRH;
   private AlarmManager zzRI = (AlarmManager)this.getContext().getSystemService("alarm");

   protected zzv(zzf var1) {
      super(var1);
   }

   private PendingIntent zzld() {
      Intent var1 = new Intent(this.getContext(), AnalyticsReceiver.class);
      var1.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      return PendingIntent.getBroadcast(this.getContext(), 0, var1, 0);
   }

   public void cancel() {
      this.zzjv();
      this.zzRH = false;
      this.zzRI.cancel(this.zzld());
   }

   public boolean zzbw() {
      return this.zzRH;
   }

   protected void zziJ() {
      // $FF: Couldn't be decompiled
   }

   public boolean zzlb() {
      return this.zzRG;
   }

   public void zzlc() {
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zza(this.zzlb(), "Receiver not registered");
      long var1 = this.zzjn().zzkA();
      if(var1 > 0L) {
         this.cancel();
         long var3 = var1 + this.zzjl().elapsedRealtime();
         this.zzRH = true;
         this.zzRI.setInexactRepeating(2, var3, 0L, this.zzld());
      }

   }
}

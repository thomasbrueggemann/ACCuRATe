package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;

public class zzag extends zzz {
   private boolean zzRH;
   private final AlarmManager zzRI = (AlarmManager)this.getContext().getSystemService("alarm");

   protected zzag(zzw var1) {
      super(var1);
   }

   private PendingIntent zzld() {
      Intent var1 = new Intent(this.getContext(), AppMeasurementReceiver.class);
      var1.setAction("com.google.android.gms.measurement.UPLOAD");
      return PendingIntent.getBroadcast(this.getContext(), 0, var1, 0);
   }

   public void cancel() {
      this.zzjv();
      this.zzRH = false;
      this.zzRI.cancel(this.zzld());
   }

   protected void zziJ() {
      this.zzRI.cancel(this.zzld());
   }

   public void zzt(long var1) {
      this.zzjv();
      boolean var3;
      if(var1 > 0L) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.google.android.gms.common.internal.zzx.zzac(var3);
      com.google.android.gms.common.internal.zzx.zza(AppMeasurementReceiver.zzY(this.getContext()), "Receiver not registered/enabled");
      com.google.android.gms.common.internal.zzx.zza(AppMeasurementService.zzZ(this.getContext()), "Service not registered/enabled");
      this.cancel();
      long var4 = var1 + this.zzjl().elapsedRealtime();
      this.zzRH = true;
      this.zzRI.setInexactRepeating(2, var4, Math.max(this.zzCp().zzBZ(), var1), this.zzld());
   }
}

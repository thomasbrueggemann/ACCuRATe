package com.google.android.gms.measurement;

import android.os.Bundle;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzw;

public class AppMeasurement {
   private final zzw zzaTV;

   public AppMeasurement(zzw var1) {
      zzx.zzz(var1);
      this.zzaTV = var1;
   }

   public interface zza {
      @WorkerThread
      void zza(String var1, String var2, Bundle var3, long var4);
   }
}

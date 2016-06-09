package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.measurement.internal.zzm;

public class zzo extends com.google.android.gms.common.internal.zzj<zzm> {
   public zzo(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 93, var3, var4, var5);
   }

   // $FF: synthetic method
   public IInterface zzW(IBinder var1) {
      return this.zzdo(var1);
   }

   public zzm zzdo(IBinder var1) {
      return zzm.zza.zzdn(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.measurement.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.measurement.internal.IMeasurementService";
   }
}

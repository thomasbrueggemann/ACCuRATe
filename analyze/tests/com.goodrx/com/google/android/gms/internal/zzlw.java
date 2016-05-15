package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzly;

public class zzlw extends com.google.android.gms.common.internal.zzj<zzly> {
   public zzlw(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 40, var3, var4, var5);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzaK(var1);
   }

   protected zzly zzaK(IBinder var1) {
      return zzly.zza.zzaM(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.clearcut.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
   }
}

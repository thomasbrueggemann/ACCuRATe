package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkx;

public class zzkw extends com.google.android.gms.common.internal.zzj<zzkx> {
   public zzkw(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 92, var3, var4, var5);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzat(var1);
   }

   protected zzkx zzat(IBinder var1) {
      return zzkx.zza.zzau(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.auth.api.consent.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.auth.api.consent.internal.IConsentService";
   }
}

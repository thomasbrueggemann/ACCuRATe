package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

public class zzo extends com.google.android.gms.common.internal.zzj<zzh> {
   private final com.google.android.gms.auth.api.signin.zzg zzXK;

   public zzo(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, com.google.android.gms.auth.api.signin.zzg var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      super(var1, var2, 87, var3, var5, var6);
      this.zzXK = (com.google.android.gms.auth.api.signin.zzg)zzx.zzz(var4);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzaB(var1);
   }

   protected zzh zzaB(IBinder var1) {
      return zzh.zza.zzaD(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.auth.api.signin.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.auth.api.signin.internal.ISignInService";
   }
}

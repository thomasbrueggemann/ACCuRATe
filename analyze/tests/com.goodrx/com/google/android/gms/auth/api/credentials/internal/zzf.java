package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.internal.zzj;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzf extends com.google.android.gms.common.internal.zzj<zzj> {
   @Nullable
   private final Auth.AuthCredentialsOptions zzWA;

   public zzf(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Auth.AuthCredentialsOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      super(var1, var2, 68, var3, var5, var6);
      this.zzWA = var4;
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzav(var1);
   }

   protected zzj zzav(IBinder var1) {
      return zzj.zza.zzax(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.auth.api.credentials.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
   }

   protected Bundle zzml() {
      return this.zzWA == null?new Bundle():this.zzWA.zzml();
   }
}

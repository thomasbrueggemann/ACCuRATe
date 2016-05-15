package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzad<T extends IInterface> extends zzj<T> {
   private final Api.zzd<T> zzamx;

   public zzad(Context var1, Looper var2, int var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, zzf var6, Api.zzd var7) {
      super(var1, var2, var3, var6, var4, var5);
      this.zzamx = var7;
   }

   protected T zzW(IBinder var1) {
      return this.zzamx.zzW(var1);
   }

   protected void zzc(int var1, T var2) {
      this.zzamx.zza(var1, var2);
   }

   protected String zzgu() {
      return this.zzamx.zzgu();
   }

   protected String zzgv() {
      return this.zzamx.zzgv();
   }
}

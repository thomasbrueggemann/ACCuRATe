package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zzmj;

public final class zzmf {
   public static final Api<Api.NoOptions> API;
   public static final Api.zzc<zzmj> zzUI = new Api.zzc();
   private static final Api.zza<zzmj, Api.NoOptions> zzUJ = new Api.zza() {
      // $FF: synthetic method
      public Api.zzb zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.zzf(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public zzmj zzf(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzmj(var1, var2, var3, var5, var6);
      }
   };
   public static final zzmg zzamA;

   static {
      API = new Api("Common.API", zzUJ, zzUI);
      zzamA = new zzmh();
   }
}

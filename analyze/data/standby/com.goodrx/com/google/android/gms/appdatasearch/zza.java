package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;

public final class zza {
   public static final Api<Api.NoOptions> zzTA;
   public static final zzk zzTB;
   public static final Api.zzc<zzki> zzTy = new Api.zzc();
   private static final Api.zza<zzki, Api.NoOptions> zzTz = new Api.zza() {
      public zzki zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzki(var1, var2, var3, var5, var6);
      }
   };

   static {
      zzTA = new Api("AppDataSearch.LIGHTWEIGHT_API", zzTz, zzTy);
      zzTB = new zzkk();
   }
}

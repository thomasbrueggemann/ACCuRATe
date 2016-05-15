package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;

public final class zzb {
   public static final Api<Api.NoOptions> API;
   public static final Api.zzc<zzlw> zzUI = new Api.zzc();
   public static final Api.zza<zzlw, Api.NoOptions> zzUJ = new Api.zza() {
      // $FF: synthetic method
      public Api.zzb zza(Context var1, Looper var2, zzf var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.zze(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public zzlw zze(Context var1, Looper var2, zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzlw(var1, var2, var3, var5, var6);
      }
   };
   public static final zzc zzaeQ;

   static {
      API = new Api("ClearcutLogger.API", zzUJ, zzUI);
      zzaeQ = new zzlv();
   }

   public interface zzb {
   }
}

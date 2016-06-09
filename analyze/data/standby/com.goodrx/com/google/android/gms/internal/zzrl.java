package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzro;

public final class zzrl {
   public static final Api<zzro> API;
   public static final Api.zzc<com.google.android.gms.signin.internal.zzh> zzUI = new Api.zzc();
   public static final Api.zza<com.google.android.gms.signin.internal.zzh, zzro> zzUJ = new Api.zza() {
      public com.google.android.gms.signin.internal.zzh zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, zzro var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         zzro var7;
         if(var4 == null) {
            var7 = zzro.zzbgV;
         } else {
            var7 = var4;
         }

         return new com.google.android.gms.signin.internal.zzh(var1, var2, true, var3, var7, var5, var6);
      }
   };
   public static final Scope zzWW = new Scope("profile");
   public static final Scope zzWX = new Scope("email");
   public static final Api<zzrl.zza> zzaoG;
   public static final Api.zzc<com.google.android.gms.signin.internal.zzh> zzavN = new Api.zzc();
   static final Api.zza<com.google.android.gms.signin.internal.zzh, zzrl.zza> zzbgS = new Api.zza() {
      public com.google.android.gms.signin.internal.zzh zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, zzrl.zza var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new com.google.android.gms.signin.internal.zzh(var1, var2, false, var3, var4.zzFF(), var5, var6);
      }
   };
   public static final zzrm zzbgT;

   static {
      API = new Api("SignIn.API", zzUJ, zzUI);
      zzaoG = new Api("SignIn.INTERNAL_API", zzbgS, zzavN);
      zzbgT = new com.google.android.gms.signin.internal.zzg();
   }

   public static class zza implements Api.HasOptions {
      private final Bundle zzbgU;

      public Bundle zzFF() {
         return this.zzbgU;
      }
   }
}

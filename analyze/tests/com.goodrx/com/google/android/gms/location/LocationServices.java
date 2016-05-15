package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.SettingsApi;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

public class LocationServices {
   public static final Api<Api.NoOptions> API;
   public static final FusedLocationProviderApi FusedLocationApi;
   public static final GeofencingApi GeofencingApi;
   public static final SettingsApi SettingsApi;
   private static final Api.zzc<zzl> zzUI = new Api.zzc();
   private static final Api.zza<zzl, Api.NoOptions> zzUJ = new Api.zza() {
      // $FF: synthetic method
      public Api.zzb zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.zzn(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public zzl zzn(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzl(var1, var2, var5, var6, "locationServices", var3);
      }
   };

   static {
      API = new Api("LocationServices.API", zzUJ, zzUI);
      FusedLocationApi = new com.google.android.gms.location.internal.zzd();
      GeofencingApi = new com.google.android.gms.location.internal.zzf();
      SettingsApi = new zzq();
   }

   public static zzl zzi(GoogleApiClient var0) {
      boolean var1 = true;
      boolean var2;
      if(var0 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      zzx.zzb(var2, "GoogleApiClient parameter is required.");
      zzl var3 = (zzl)var0.zza(zzUI);
      if(var3 == null) {
         var1 = false;
      }

      zzx.zza(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   public abstract static class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzl> {
      public zza(GoogleApiClient var1) {
         super(LocationServices.zzUI, var1);
      }
   }
}

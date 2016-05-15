package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import java.util.Collections;
import java.util.List;

public final class Auth {
   public static final Api<Auth.AuthCredentialsOptions> CREDENTIALS_API;
   public static final CredentialsApi CredentialsApi;
   public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
   public static final GoogleSignInApi GoogleSignInApi;
   public static final Api<Auth.zza> PROXY_API;
   public static final ProxyApi ProxyApi;
   private static final Api.zza<zzf, Auth.AuthCredentialsOptions> zzVA = new Api.zza() {
      public zzf zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Auth.AuthCredentialsOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzf(var1, var2, var3, var4, var5, var6);
      }
   };
   private static final Api.zza<zzks, Api.NoOptions> zzVB = new Api.zza() {
      // $FF: synthetic method
      public Api.zzb zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.zzc(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public zzks zzc(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzks(var1, var2, var3, var5, var6);
      }
   };
   private static final Api.zza<zzkw, Api.NoOptions> zzVC = new Api.zza() {
      // $FF: synthetic method
      public Api.zzb zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.zzd(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      public zzkw zzd(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzkw(var1, var2, var3, var5, var6);
      }
   };
   private static final Api.zza<zzo, zzg> zzVD = new Api.zza() {
      public zzo zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, zzg var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzo(var1, var2, var3, var4, var5, var6);
      }
   };
   private static final Api.zza<zzd, GoogleSignInOptions> zzVE = new Api.zza() {
      public zzd zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, @Nullable GoogleSignInOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzd(var1, var2, var3, var4, var5, var6);
      }

      public List<Scope> zza(@Nullable GoogleSignInOptions var1) {
         return (List)(var1 == null?Collections.emptyList():var1.zzmN());
      }

      // $FF: synthetic method
      public List zzo(@Nullable Object var1) {
         return this.zza((GoogleSignInOptions)var1);
      }
   };
   public static final Api<zzg> zzVF;
   public static final Api<Api.NoOptions> zzVG;
   public static final Api<Api.NoOptions> zzVH;
   public static final zzkq zzVI;
   public static final com.google.android.gms.auth.api.signin.zzf zzVJ;
   public static final com.google.android.gms.auth.api.consent.zza zzVK;
   public static final Api.zzc<zzkz> zzVt = new Api.zzc();
   public static final Api.zzc<zzf> zzVu = new Api.zzc();
   public static final Api.zzc<zzks> zzVv = new Api.zzc();
   public static final Api.zzc<zzo> zzVw = new Api.zzc();
   public static final Api.zzc<zzd> zzVx = new Api.zzc();
   public static final Api.zzc<zzkw> zzVy = new Api.zzc();
   private static final Api.zza<zzkz, Auth.zza> zzVz = new Api.zza() {
      public zzkz zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Auth.zza var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzkz(var1, var2, var3, var4, var5, var6);
      }
   };

   static {
      PROXY_API = new Api("Auth.PROXY_API", zzVz, zzVt);
      CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzVA, zzVu);
      zzVF = new Api("Auth.SIGN_IN_API", zzVD, zzVw);
      GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
      zzVG = new Api("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
      zzVH = new Api("Auth.CONSENT_API", zzVC, zzVy);
      ProxyApi = new zzld();
      CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
      zzVI = new zzkr();
      zzVJ = new zzn();
      GoogleSignInApi = new zzc();
      zzVK = new zzkv();
   }

   public static final class AuthCredentialsOptions implements Api.Optional {
      private final String zzVL;
      private final PasswordSpecification zzVM;

      public Bundle zzml() {
         Bundle var1 = new Bundle();
         var1.putString("consumer_package", this.zzVL);
         var1.putParcelable("password_specification", this.zzVM);
         return var1;
      }
   }

   public static final class zza implements Api.Optional {
      private final Bundle zzVN;

      public Bundle zzms() {
         return new Bundle(this.zzVN);
      }
   }
}

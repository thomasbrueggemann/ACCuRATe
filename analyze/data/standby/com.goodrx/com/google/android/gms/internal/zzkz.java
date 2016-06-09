package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzlb;

public final class zzkz extends com.google.android.gms.common.internal.zzj<zzlb> {
   private final Bundle zzVN;

   public zzkz(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, Auth.zza var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      super(var1, var2, 16, var3, var5, var6);
      Bundle var7;
      if(var4 == null) {
         var7 = new Bundle();
      } else {
         var7 = var4.zzms();
      }

      this.zzVN = var7;
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzay(var1);
   }

   protected zzlb zzay(IBinder var1) {
      return zzlb.zza.zzaA(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.auth.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.auth.api.internal.IAuthService";
   }

   public boolean zzmE() {
      com.google.android.gms.common.internal.zzf var1 = this.zzqH();
      return !TextUtils.isEmpty(var1.getAccountName()) && !var1.zzb(Auth.PROXY_API).isEmpty();
   }

   protected Bundle zzml() {
      return this.zzVN;
   }
}

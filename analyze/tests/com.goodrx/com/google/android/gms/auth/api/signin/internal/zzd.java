package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;

public class zzd extends com.google.android.gms.common.internal.zzj<zzh> {
   private final GoogleSignInOptions zzXx;

   public zzd(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleSignInOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      super(var1, var2, 91, var3, var5, var6);
      if(var4 == null) {
         var4 = (new GoogleSignInOptions.Builder()).build();
      }

      if(!var3.zzqt().isEmpty()) {
         GoogleSignInOptions.Builder var7 = new GoogleSignInOptions.Builder(var4);
         Iterator var8 = var3.zzqt().iterator();

         while(var8.hasNext()) {
            var7.requestScopes((Scope)var8.next(), new Scope[0]);
         }

         var4 = var7.build();
      }

      this.zzXx = var4;
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

   public boolean zznb() {
      return true;
   }

   public Intent zznc() {
      SignInConfiguration var1 = (new com.google.android.gms.auth.api.signin.zzg.zza(this.getContext().getPackageName())).zzi(this.zzXx).zzmY().zzmX();
      Intent var2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
      var2.setClass(this.getContext(), SignInHubActivity.class);
      var2.putExtra("config", var1);
      return var2;
   }

   public GoogleSignInOptions zznd() {
      return this.zzXx;
   }
}

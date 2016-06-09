package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzd;
import com.google.android.gms.signin.internal.zze;

public class zzh extends com.google.android.gms.common.internal.zzj<zze> implements zzrn {
   private final com.google.android.gms.common.internal.zzf zzahz;
   private Integer zzale;
   private final Bundle zzbgU;
   private final boolean zzbhi;

   public zzh(Context var1, Looper var2, boolean var3, com.google.android.gms.common.internal.zzf var4, Bundle var5, GoogleApiClient.ConnectionCallbacks var6, GoogleApiClient.OnConnectionFailedListener var7) {
      super(var1, var2, 44, var4, var6, var7);
      this.zzbhi = var3;
      this.zzahz = var4;
      this.zzbgU = var5;
      this.zzale = var4.zzqz();
   }

   public zzh(Context var1, Looper var2, boolean var3, com.google.android.gms.common.internal.zzf var4, zzro var5, GoogleApiClient.ConnectionCallbacks var6, GoogleApiClient.OnConnectionFailedListener var7) {
      this(var1, var2, var3, var4, zza(var4), var6, var7);
   }

   private ResolveAccountRequest zzFN() {
      Account var1 = this.zzahz.zzqq();
      boolean var2 = "<<default account>>".equals(var1.name);
      GoogleSignInAccount var3 = null;
      if(var2) {
         var3 = zzq.zzaf(this.getContext()).zzno();
      }

      return new ResolveAccountRequest(var1, this.zzale.intValue(), var3);
   }

   public static Bundle zza(com.google.android.gms.common.internal.zzf var0) {
      zzro var1 = var0.zzqy();
      Integer var2 = var0.zzqz();
      Bundle var3 = new Bundle();
      var3.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", var0.getAccount());
      if(var2 != null) {
         var3.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", var2.intValue());
      }

      if(var1 != null) {
         var3.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", var1.zzFH());
         var3.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", var1.zzmO());
         var3.putString("com.google.android.gms.signin.internal.serverClientId", var1.zzmR());
         var3.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
         var3.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", var1.zzmQ());
         var3.putString("com.google.android.gms.signin.internal.hostedDomain", var1.zzmS());
         var3.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", var1.zzFI());
      }

      return var3;
   }

   public void connect() {
      this.zza((GoogleApiClient.zza)(new com.google.android.gms.common.internal.zzj.zzf()));
   }

   public void zzFG() {
      try {
         ((zze)this.zzqJ()).zzka(this.zzale.intValue());
      } catch (RemoteException var2) {
         Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
      }
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzec(var1);
   }

   public void zza(zzp var1, boolean var2) {
      try {
         ((zze)this.zzqJ()).zza(var1, this.zzale.intValue(), var2);
      } catch (RemoteException var4) {
         Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
      }
   }

   public void zza(zzd var1) {
      zzx.zzb(var1, "Expecting a valid ISignInCallbacks");

      try {
         ResolveAccountRequest var7 = this.zzFN();
         ((zze)this.zzqJ()).zza(new SignInRequest(var7), var1);
      } catch (RemoteException var9) {
         Log.w("SignInClientImpl", "Remote service probably died when signIn is called");

         try {
            var1.zzb(new SignInResponse(8));
         } catch (RemoteException var8) {
            Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", var9);
         }
      }
   }

   protected zze zzec(IBinder var1) {
      return zze.zza.zzeb(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.signin.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.signin.internal.ISignInService";
   }

   public boolean zzmE() {
      return this.zzbhi;
   }

   protected Bundle zzml() {
      String var1 = this.zzahz.zzqv();
      if(!this.getContext().getPackageName().equals(var1)) {
         this.zzbgU.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzahz.zzqv());
      }

      return this.zzbgU;
   }
}

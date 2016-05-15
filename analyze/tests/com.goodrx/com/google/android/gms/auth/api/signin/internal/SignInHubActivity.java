package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.zzb;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.auth.api.signin.internal.zzm;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlf;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

@KeepName
@Instrumented
public class SignInHubActivity extends FragmentActivity implements TraceFieldInterface {
   private zzq zzXP;
   private zzk zzXQ;
   private SignInConfiguration zzXR;
   private boolean zzXS;
   private String zzXT;
   private String zzXU;
   private boolean zzXV;
   private int zzXW;
   private Intent zzXX;

   private void zza(int var1, int var2, Intent var3) {
      Iterator var4 = this.zzXQ.zznh().iterator();

      while(var4.hasNext() && !((zzlf)var4.next()).zza(var1, var2, var3, this.zzbO(this.zzXU))) {
         ;
      }

      if(var2 == 0) {
         this.finish();
      }

   }

   private void zza(int var1, Intent var2) {
      if(var2 != null) {
         SignInAccount var3 = (SignInAccount)var2.getParcelableExtra("signInAccount");
         if(var3 != null && var3.zzmV() != null) {
            GoogleSignInAccount var4 = var3.zzmV();
            this.zzXP.zzb(var4, this.zzXR.zznm());
            var2.removeExtra("signInAccount");
            var2.putExtra("googleSignInAccount", var4);
            this.zzXV = true;
            this.zzXW = var1;
            this.zzXX = var2;
            this.zzd(var1, var2);
            return;
         }

         if(var2.hasExtra("errorCode")) {
            this.zzaS(var2.getIntExtra("errorCode", 8));
            return;
         }
      }

      this.zzaS(8);
   }

   private void zzaR(int var1) {
      Intent var2 = new Intent();
      var2.putExtra("errorCode", var1);
      this.setResult(0, var2);
      this.finish();
   }

   private void zzaS(int var1) {
      Status var2 = new Status(var1);
      Intent var3 = new Intent();
      var3.putExtra("googleSignInStatus", var2);
      this.setResult(0, var3);
      this.finish();
   }

   private void zzb(int var1, Intent var2) {
      if(var1 == -1) {
         SignInAccount var10 = (SignInAccount)var2.getParcelableExtra("signInAccount");
         if(var10 != null) {
            this.zzXP.zzb(var10, this.zzXR);
            String var12 = var2.getStringExtra("accessToken");
            if(!TextUtils.isEmpty(var12) && !TextUtils.isEmpty(this.zzXU)) {
               HashSet var13 = new HashSet(Arrays.asList(TextUtils.split(this.zzXU, " ")));
               zzm.zzbN(var10.getUserId()).zza(var13, new zzm.zza(var12, var2.getLongExtra("accessTokenExpiresAtSecs", 0L)));
               var2.removeExtra("accessTokenExpiresAtSecs");
            }

            this.setResult(-1, var2);
            this.finish();
         } else {
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            this.zzaR(2);
         }
      } else if(var2 == null) {
         this.finish();
      } else {
         String var3 = var2.getStringExtra("email");
         com.google.android.gms.auth.api.signin.zzd var4 = com.google.android.gms.auth.api.signin.zzd.zzbL(var2.getStringExtra("idProvider"));
         if(var4 == null) {
            this.setResult(var1, var2);
            this.finish();
         } else {
            this.zzXT = var2.getStringExtra("pendingToken");
            zzlf var5 = this.zzXQ.zza(var4);
            if(var5 == null) {
               CharSequence var8 = var4.zzae(this);
               Log.w("AuthSignInClient", var8 + " is not supported. Please check your configuration");
               this.zzaR(1);
            } else {
               int var6 = var2.getIntExtra("idpAction", -1);
               if(var6 == 0) {
                  if(TextUtils.isEmpty(var3)) {
                     var5.zza(this.zzbO(this.zzXU));
                  } else {
                     var5.zza(var3, this.zzbO(this.zzXU));
                  }
               } else if(var6 == 1 && !TextUtils.isEmpty(this.zzXT) && !TextUtils.isEmpty(var3)) {
                  var5.zza(var3, this.zzXT, this.zzbO(this.zzXU));
               } else {
                  Log.w("AuthSignInClient", "Internal error!");
                  this.zzaR(2);
               }
            }
         }
      }
   }

   private zzlf.zza zzbO(final String var1) {
      return new zzlf.zza() {
         public void zzk(Intent var1x) {
            if(var1x != null) {
               if(!TextUtils.isEmpty(var1)) {
                  var1x.putExtra("scopes", var1);
               }

               SignInHubActivity.this.zzj(var1x);
            } else {
               Log.w("AuthSignInClient", "Idp signin failed!");
               SignInHubActivity.this.zzaR(4);
            }
         }
      };
   }

   private void zzc(int var1, Intent var2) {
      if(var1 == 0) {
         this.setResult(0, var2);
         this.finish();
      } else {
         Intent var3 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
         var3.putExtra("idpTokenType", IdpTokenType.zzXA);
         var3.putExtra("idpToken", var2.getStringExtra("idpToken"));
         var3.putExtra("pendingToken", this.zzXT);
         var3.putExtra("idProvider", com.google.android.gms.auth.api.signin.zzd.zzXi.zzmT());
         this.zzj(var3);
      }
   }

   private void zzd(int var1, Intent var2) {
      this.getSupportLoaderManager().initLoader(0, (Bundle)null, new SignInHubActivity.zza(null));
   }

   private void zzj(Intent var1) {
      var1.setPackage("com.google.android.gms");
      var1.putExtra("config", this.zzXR);
      char var4;
      if(this.zzXS) {
         var4 = 'ꀂ';
      } else {
         var4 = 'ꀁ';
      }

      try {
         this.startActivityForResult(var1, var4);
      } catch (ActivityNotFoundException var6) {
         Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
         if(this.zzXS) {
            this.zzaS(8);
         } else {
            this.zzaR(2);
         }
      }
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      return true;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      this.setResult(0);
      switch(var1) {
      case 40961:
         this.zzb(var2, var3);
         return;
      case 40962:
         this.zza(var2, var3);
         return;
      case 45057:
         this.zzc(var2, var3);
         return;
      default:
         this.zza(var1, var2, var3);
      }
   }

   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("pendingToken", this.zzXT);
      var1.putBoolean("signingInGoogleApiClients", this.zzXV);
      if(this.zzXV) {
         var1.putInt("signInResultCode", this.zzXW);
         var1.putParcelable("signInResultData", this.zzXX);
      }

   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   private class zza implements LoaderManager.LoaderCallbacks<Void> {
      private zza() {
      }

      // $FF: synthetic method
      zza(Object var2) {
         this();
      }

      public Loader<Void> onCreateLoader(int var1, Bundle var2) {
         return new zzb(SignInHubActivity.this, GoogleApiClient.zzoV());
      }

      // $FF: synthetic method
      public void onLoadFinished(Loader var1, Object var2) {
         this.zza(var1, (Void)var2);
      }

      public void onLoaderReset(Loader<Void> var1) {
      }

      public void zza(Loader<Void> var1, Void var2) {
         SignInHubActivity.this.setResult(SignInHubActivity.this.zzXW, SignInHubActivity.this.zzXX);
         SignInHubActivity.this.finish();
      }
   }
}

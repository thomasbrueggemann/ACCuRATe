package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzx;

public class zzg implements Api.HasOptions {
   private final SignInConfiguration zzXo;

   private zzg(SignInConfiguration var1) {
      this.zzXo = var1;
   }

   // $FF: synthetic method
   zzg(SignInConfiguration var1, Object var2) {
      this(var1);
   }

   public SignInConfiguration zzmX() {
      return this.zzXo;
   }

   public static class zza {
      private final SignInConfiguration zzXo;

      public zza(String var1) {
         zzx.zzcM(var1);
         this.zzXo = new SignInConfiguration(var1);
      }

      public zzg.zza zzi(GoogleSignInOptions var1) {
         zzx.zzz(var1);
         this.zzXo.zzj(var1);
         return this;
      }

      public zzg zzmY() {
         boolean var1;
         if(this.zzXo.zznl() == null && this.zzXo.zznm() == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         zzx.zza(var1, "Must support either Facebook, Google or Email sign-in.");
         return new zzg(this.zzXo);
      }
   }
}

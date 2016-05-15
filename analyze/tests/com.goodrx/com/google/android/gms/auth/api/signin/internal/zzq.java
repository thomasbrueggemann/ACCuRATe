package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzq {
   private static final Lock zzYa = new ReentrantLock();
   private static zzq zzYb;
   private final Lock zzYc = new ReentrantLock();
   private final SharedPreferences zzYd;

   zzq(Context var1) {
      this.zzYd = var1.getSharedPreferences("com.google.android.gms.signin", 0);
   }

   public static zzq zzaf(Context var0) {
      zzx.zzz(var0);
      zzYa.lock();

      zzq var3;
      try {
         if(zzYb == null) {
            zzYb = new zzq(var0.getApplicationContext());
         }

         var3 = zzYb;
      } finally {
         zzYa.unlock();
      }

      return var3;
   }

   private String zzs(String var1, String var2) {
      return var1 + ":" + var2;
   }

   void zza(GoogleSignInAccount var1, GoogleSignInOptions var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      String var5 = var1.zzmL();
      this.zzr(this.zzs("googleSignInAccount", var5), var1.zzmM());
      this.zzr(this.zzs("googleSignInOptions", var5), var2.zzmI());
   }

   void zza(SignInAccount var1, SignInConfiguration var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      String var5 = var1.getUserId();
      SignInAccount var6 = this.zzbP(var5);
      if(var6 != null && var6.zzmV() != null) {
         this.zzbU(var6.zzmV().zzmL());
      }

      this.zzr(this.zzs("signInConfiguration", var5), var2.zzmI());
      this.zzr(this.zzs("signInAccount", var5), var1.zzmI());
      if(var1.zzmV() != null) {
         this.zza(var1.zzmV(), var2.zznm());
      }

   }

   public void zzb(GoogleSignInAccount var1, GoogleSignInOptions var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      this.zzr("defaultGoogleSignInAccount", var1.zzmL());
      this.zza(var1, var2);
   }

   public void zzb(SignInAccount var1, SignInConfiguration var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      this.zznq();
      this.zzr("defaultSignInAccount", var1.getUserId());
      if(var1.zzmV() != null) {
         this.zzr("defaultGoogleSignInAccount", var1.zzmV().zzmL());
      }

      this.zza(var1, var2);
   }

   SignInAccount zzbP(String param1) {
      // $FF: Couldn't be decompiled
   }

   GoogleSignInAccount zzbQ(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         String var2 = this.zzbS(this.zzs("googleSignInAccount", var1));
         if(var2 != null) {
            try {
               GoogleSignInAccount var4 = GoogleSignInAccount.zzbH(var2);
               return var4;
            } catch (JSONException var5) {
               return null;
            }
         }
      }

      return null;
   }

   GoogleSignInOptions zzbR(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         String var2 = this.zzbS(this.zzs("googleSignInOptions", var1));
         if(var2 != null) {
            try {
               GoogleSignInOptions var4 = GoogleSignInOptions.zzbJ(var2);
               return var4;
            } catch (JSONException var5) {
               return null;
            }
         }
      }

      return null;
   }

   protected String zzbS(String var1) {
      this.zzYc.lock();

      String var3;
      try {
         var3 = this.zzYd.getString(var1, (String)null);
      } finally {
         this.zzYc.unlock();
      }

      return var3;
   }

   void zzbT(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         SignInAccount var2 = this.zzbP(var1);
         this.zzbV(this.zzs("signInAccount", var1));
         this.zzbV(this.zzs("signInConfiguration", var1));
         if(var2 != null && var2.zzmV() != null) {
            this.zzbU(var2.zzmV().zzmL());
            return;
         }
      }

   }

   void zzbU(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.zzbV(this.zzs("googleSignInAccount", var1));
         this.zzbV(this.zzs("googleSignInOptions", var1));
      }
   }

   protected void zzbV(String var1) {
      this.zzYc.lock();

      try {
         this.zzYd.edit().remove(var1).apply();
      } finally {
         this.zzYc.unlock();
      }

   }

   public GoogleSignInAccount zzno() {
      return this.zzbQ(this.zzbS("defaultGoogleSignInAccount"));
   }

   public GoogleSignInOptions zznp() {
      return this.zzbR(this.zzbS("defaultGoogleSignInAccount"));
   }

   public void zznq() {
      String var1 = this.zzbS("defaultSignInAccount");
      this.zzbV("defaultSignInAccount");
      this.zznr();
      this.zzbT(var1);
   }

   public void zznr() {
      String var1 = this.zzbS("defaultGoogleSignInAccount");
      this.zzbV("defaultGoogleSignInAccount");
      this.zzbU(var1);
   }

   protected void zzr(String var1, String var2) {
      this.zzYc.lock();

      try {
         this.zzYd.edit().putString(var1, var2).apply();
      } finally {
         this.zzYc.unlock();
      }

   }
}

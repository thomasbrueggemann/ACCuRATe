package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
   public static final Creator<SignInConfiguration> CREATOR = new zzp();
   final int versionCode;
   private final String zzXL;
   private EmailSignInOptions zzXM;
   private GoogleSignInOptions zzXN;
   private String zzXO;
   private String zzXd;

   SignInConfiguration(int var1, String var2, String var3, EmailSignInOptions var4, GoogleSignInOptions var5, String var6) {
      this.versionCode = var1;
      this.zzXL = zzx.zzcM(var2);
      this.zzXd = var3;
      this.zzXM = var4;
      this.zzXN = var5;
      this.zzXO = var6;
   }

   public SignInConfiguration(String var1) {
      this(2, var1, (String)null, (EmailSignInOptions)null, (GoogleSignInOptions)null, (String)null);
   }

   private JSONObject zzmJ() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("consumerPackageName", this.zzXL);
         if(!TextUtils.isEmpty(this.zzXd)) {
            var1.put("serverClientId", this.zzXd);
         }

         if(this.zzXM != null) {
            var1.put("emailSignInOptions", this.zzXM.zzmI());
         }

         if(this.zzXN != null) {
            var1.put("googleSignInOptions", this.zzXN.zzmI());
         }

         if(!TextUtils.isEmpty(this.zzXO)) {
            var1.put("apiKey", this.zzXO);
         }

         return var1;
      } catch (JSONException var3) {
         throw new RuntimeException(var3);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      return (new zze()).zzp(this.zzXL).zzp(this.zzXd).zzp(this.zzXO).zzp(this.zzXM).zzp(this.zzXN).zzne();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }

   public SignInConfiguration zzj(GoogleSignInOptions var1) {
      this.zzXN = (GoogleSignInOptions)zzx.zzb(var1, "GoogleSignInOptions cannot be null.");
      return this;
   }

   public String zzmI() {
      JSONObject var1 = this.zzmJ();
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }

   public String zzmR() {
      return this.zzXd;
   }

   public String zznk() {
      return this.zzXL;
   }

   public EmailSignInOptions zznl() {
      return this.zzXM;
   }

   public GoogleSignInOptions zznm() {
      return this.zzXN;
   }

   public String zznn() {
      return this.zzXO;
   }
}

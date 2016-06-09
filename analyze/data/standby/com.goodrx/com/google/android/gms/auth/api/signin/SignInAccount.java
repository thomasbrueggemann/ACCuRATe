package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
   public static final Creator<SignInAccount> CREATOR = new zze();
   final int versionCode;
   private String zzWP;
   private String zzWQ;
   private Uri zzWR;
   private String zzWk;
   private String zzXj;
   private GoogleSignInAccount zzXm;
   private String zzXn;
   private String zzrG;

   SignInAccount(int var1, String var2, String var3, String var4, String var5, Uri var6, GoogleSignInAccount var7, String var8, String var9) {
      this.versionCode = var1;
      this.zzWP = zzx.zzh(var4, "Email cannot be empty.");
      this.zzWQ = var5;
      this.zzWR = var6;
      this.zzXj = var2;
      this.zzWk = var3;
      this.zzXm = var7;
      this.zzrG = zzx.zzcM(var8);
      this.zzXn = var9;
   }

   public static SignInAccount zza(zzd var0, String var1, String var2, String var3, Uri var4, String var5, String var6) {
      String var7 = null;
      if(var0 != null) {
         var7 = var0.zzmT();
      }

      return new SignInAccount(2, var7, var1, var2, var3, var4, (GoogleSignInAccount)null, var5, var6);
   }

   public static SignInAccount zzbM(String var0) throws JSONException {
      if(TextUtils.isEmpty(var0)) {
         return null;
      } else {
         new JSONObject;
         JSONObject var2 = JSONObjectInstrumentation.init(var0);
         String var3 = var2.optString("photoUrl", (String)null);
         Uri var4;
         if(!TextUtils.isEmpty(var3)) {
            var4 = Uri.parse(var3);
         } else {
            var4 = null;
         }

         return zza(zzd.zzbL(var2.optString("providerId", (String)null)), var2.optString("tokenId", (String)null), var2.getString("email"), var2.optString("displayName", (String)null), var4, var2.getString("localId"), var2.optString("refreshToken")).zza(GoogleSignInAccount.zzbH(var2.optString("googleSignInAccount")));
      }
   }

   private JSONObject zzmJ() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("email", this.getEmail());
         if(!TextUtils.isEmpty(this.zzWQ)) {
            var1.put("displayName", this.zzWQ);
         }

         if(this.zzWR != null) {
            var1.put("photoUrl", this.zzWR.toString());
         }

         if(!TextUtils.isEmpty(this.zzXj)) {
            var1.put("providerId", this.zzXj);
         }

         if(!TextUtils.isEmpty(this.zzWk)) {
            var1.put("tokenId", this.zzWk);
         }

         if(this.zzXm != null) {
            var1.put("googleSignInAccount", this.zzXm.zzmI());
         }

         if(!TextUtils.isEmpty(this.zzXn)) {
            var1.put("refreshToken", this.zzXn);
         }

         var1.put("localId", this.getUserId());
         return var1;
      } catch (JSONException var3) {
         throw new RuntimeException(var3);
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getDisplayName() {
      return this.zzWQ;
   }

   public String getEmail() {
      return this.zzWP;
   }

   public String getIdToken() {
      return this.zzWk;
   }

   public Uri getPhotoUrl() {
      return this.zzWR;
   }

   public String getUserId() {
      return this.zzrG;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   public SignInAccount zza(GoogleSignInAccount var1) {
      this.zzXm = var1;
      return this;
   }

   public String zzmI() {
      JSONObject var1 = this.zzmJ();
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }

   String zzmT() {
      return this.zzXj;
   }

   public zzd zzmU() {
      return zzd.zzbL(this.zzXj);
   }

   public GoogleSignInAccount zzmV() {
      return this.zzXm;
   }

   public String zzmW() {
      return this.zzXn;
   }
}

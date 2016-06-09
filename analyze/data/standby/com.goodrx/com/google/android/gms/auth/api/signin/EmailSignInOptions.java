package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
   public static final Creator<EmailSignInOptions> CREATOR = new zza();
   final int versionCode;
   private final Uri zzWL;
   private String zzWM;
   private Uri zzWN;

   EmailSignInOptions(int var1, Uri var2, String var3, Uri var4) {
      zzx.zzb(var2, "Server widget url cannot be null in order to use email/password sign in.");
      zzx.zzh(var2.toString(), "Server widget url cannot be null in order to use email/password sign in.");
      zzx.zzb(Patterns.WEB_URL.matcher(var2.toString()).matches(), "Invalid server widget url");
      this.versionCode = var1;
      this.zzWL = var2;
      this.zzWM = var3;
      this.zzWN = var4;
   }

   private JSONObject zzmJ() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("serverWidgetUrl", this.zzWL.toString());
         if(!TextUtils.isEmpty(this.zzWM)) {
            var1.put("modeQueryName", this.zzWM);
         }

         if(this.zzWN != null) {
            var1.put("tosUrl", this.zzWN.toString());
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
      return (new com.google.android.gms.auth.api.signin.internal.zze()).zzp(this.zzWL).zzp(this.zzWN).zzp(this.zzWM).zzne();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public Uri zzmF() {
      return this.zzWL;
   }

   public Uri zzmG() {
      return this.zzWN;
   }

   public String zzmH() {
      return this.zzWM;
   }

   public String zzmI() {
      JSONObject var1 = this.zzmJ();
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }
}

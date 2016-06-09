package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.zzb;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
   public static final Creator<GoogleSignInAccount> CREATOR = new zzb();
   public static zzmq zzWO = zzmt.zzsc();
   private static Comparator<Scope> zzWV = new Comparator() {
      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.zza((Scope)var1, (Scope)var2);
      }

      public int zza(Scope var1, Scope var2) {
         return var1.zzpb().compareTo(var2.zzpb());
      }
   };
   final int versionCode;
   List<Scope> zzVs;
   private String zzWP;
   private String zzWQ;
   private Uri zzWR;
   private String zzWS;
   private long zzWT;
   private String zzWU;
   private String zzWk;
   private String zzyv;

   GoogleSignInAccount(int var1, String var2, String var3, String var4, String var5, Uri var6, String var7, long var8, String var10, List<Scope> var11) {
      this.versionCode = var1;
      this.zzyv = var2;
      this.zzWk = var3;
      this.zzWP = var4;
      this.zzWQ = var5;
      this.zzWR = var6;
      this.zzWS = var7;
      this.zzWT = var8;
      this.zzWU = var10;
      this.zzVs = var11;
   }

   public static GoogleSignInAccount zza(@Nullable String var0, @Nullable String var1, @Nullable String var2, @Nullable String var3, @Nullable Uri var4, @Nullable Long var5, @NonNull String var6, @NonNull Set<Scope> var7) {
      if(var5 == null) {
         var5 = Long.valueOf(zzWO.currentTimeMillis() / 1000L);
      }

      return new GoogleSignInAccount(2, var0, var1, var2, var3, var4, (String)null, var5.longValue(), zzx.zzcM(var6), new ArrayList((Collection)zzx.zzz(var7)));
   }

   @Nullable
   public static GoogleSignInAccount zzbH(@Nullable String var0) throws JSONException {
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

         long var5 = Long.parseLong(var2.getString("expirationTime"));
         HashSet var7 = new HashSet();
         JSONArray var8 = var2.getJSONArray("grantedScopes");
         int var9 = var8.length();

         for(int var10 = 0; var10 < var9; ++var10) {
            var7.add(new Scope(var8.getString(var10)));
         }

         return zza(var2.optString("id"), var2.optString("tokenId", (String)null), var2.optString("email", (String)null), var2.optString("displayName", (String)null), var4, Long.valueOf(var5), var2.getString("obfuscatedIdentifier"), var7).zzbI(var2.optString("serverAuthCode", (String)null));
      }
   }

   private JSONObject zzmJ() {
      // $FF: Couldn't be decompiled
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof GoogleSignInAccount)?false:((GoogleSignInAccount)var1).zzmI().equals(this.zzmI());
   }

   @Nullable
   public String getDisplayName() {
      return this.zzWQ;
   }

   @Nullable
   public String getEmail() {
      return this.zzWP;
   }

   @Nullable
   public String getId() {
      return this.zzyv;
   }

   @Nullable
   public String getIdToken() {
      return this.zzWk;
   }

   @Nullable
   public Uri getPhotoUrl() {
      return this.zzWR;
   }

   @Nullable
   public String getServerAuthCode() {
      return this.zzWS;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public GoogleSignInAccount zzbI(String var1) {
      this.zzWS = var1;
      return this;
   }

   public String zzmI() {
      JSONObject var1 = this.zzmJ();
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }

   public long zzmK() {
      return this.zzWT;
   }

   @NonNull
   public String zzmL() {
      return this.zzWU;
   }

   public String zzmM() {
      JSONObject var1 = this.zzmJ();
      var1.remove("serverAuthCode");
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }
}

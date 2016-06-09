package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions implements Api.Optional, SafeParcelable {
   public static final Creator<GoogleSignInOptions> CREATOR = new zzc();
   public static final GoogleSignInOptions DEFAULT_SIGN_IN = (new GoogleSignInOptions.Builder()).requestId().requestProfile().build();
   private static Comparator<Scope> zzWV = new Comparator() {
      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.zza((Scope)var1, (Scope)var2);
      }

      public int zza(Scope var1, Scope var2) {
         return var1.zzpb().compareTo(var2.zzpb());
      }
   };
   public static final Scope zzWW = new Scope("profile");
   public static final Scope zzWX = new Scope("email");
   public static final Scope zzWY = new Scope("openid");
   final int versionCode;
   private Account zzTI;
   private final ArrayList<Scope> zzWZ;
   private boolean zzXa;
   private final boolean zzXb;
   private final boolean zzXc;
   private String zzXd;
   private String zzXe;

   GoogleSignInOptions(int var1, ArrayList<Scope> var2, Account var3, boolean var4, boolean var5, boolean var6, String var7, String var8) {
      this.versionCode = var1;
      this.zzWZ = var2;
      this.zzTI = var3;
      this.zzXa = var4;
      this.zzXb = var5;
      this.zzXc = var6;
      this.zzXd = var7;
      this.zzXe = var8;
   }

   private GoogleSignInOptions(Set<Scope> var1, Account var2, boolean var3, boolean var4, boolean var5, String var6, String var7) {
      this(2, new ArrayList(var1), var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   GoogleSignInOptions(Set var1, Account var2, boolean var3, boolean var4, boolean var5, String var6, String var7, Object var8) {
      this(var1, var2, var3, var4, var5, var6, var7);
   }

   @Nullable
   public static GoogleSignInOptions zzbJ(@Nullable String var0) throws JSONException {
      if(TextUtils.isEmpty(var0)) {
         return null;
      } else {
         new JSONObject;
         JSONObject var2 = JSONObjectInstrumentation.init(var0);
         HashSet var3 = new HashSet();
         JSONArray var4 = var2.getJSONArray("scopes");
         int var5 = var4.length();

         for(int var6 = 0; var6 < var5; ++var6) {
            var3.add(new Scope(var4.getString(var6)));
         }

         String var7 = var2.optString("accountName", (String)null);
         Account var8;
         if(!TextUtils.isEmpty(var7)) {
            var8 = new Account(var7, "com.google");
         } else {
            var8 = null;
         }

         return new GoogleSignInOptions(var3, var8, var2.getBoolean("idTokenRequested"), var2.getBoolean("serverAuthRequested"), var2.getBoolean("forceCodeForRefreshToken"), var2.optString("serverClientId", (String)null), var2.optString("hostedDomain", (String)null));
      }
   }

   private JSONObject zzmJ() {
      // $FF: Couldn't be decompiled
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public Account getAccount() {
      return this.zzTI;
   }

   public int hashCode() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.zzWZ.iterator();

      while(var2.hasNext()) {
         var1.add(((Scope)var2.next()).zzpb());
      }

      Collections.sort(var1);
      return (new com.google.android.gms.auth.api.signin.internal.zze()).zzp(var1).zzp(this.zzTI).zzp(this.zzXd).zzP(this.zzXc).zzP(this.zzXa).zzP(this.zzXb).zzne();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   public String zzmI() {
      JSONObject var1 = this.zzmJ();
      return !(var1 instanceof JSONObject)?var1.toString():JSONObjectInstrumentation.toString((JSONObject)var1);
   }

   public ArrayList<Scope> zzmN() {
      return new ArrayList(this.zzWZ);
   }

   public boolean zzmO() {
      return this.zzXa;
   }

   public boolean zzmP() {
      return this.zzXb;
   }

   public boolean zzmQ() {
      return this.zzXc;
   }

   public String zzmR() {
      return this.zzXd;
   }

   public String zzmS() {
      return this.zzXe;
   }

   public static final class Builder {
      private Account zzTI;
      private boolean zzXa;
      private boolean zzXb;
      private boolean zzXc;
      private String zzXd;
      private String zzXe;
      private Set<Scope> zzXf = new HashSet();

      public Builder() {
      }

      public Builder(@NonNull GoogleSignInOptions var1) {
         zzx.zzz(var1);
         this.zzXf = new HashSet(var1.zzWZ);
         this.zzXb = var1.zzXb;
         this.zzXc = var1.zzXc;
         this.zzXa = var1.zzXa;
         this.zzXd = var1.zzXd;
         this.zzTI = var1.zzTI;
         this.zzXe = var1.zzXe;
      }

      public GoogleSignInOptions build() {
         if(this.zzXa && (this.zzTI == null || !this.zzXf.isEmpty())) {
            this.requestId();
         }

         return new GoogleSignInOptions(this.zzXf, this.zzTI, this.zzXa, this.zzXb, this.zzXc, this.zzXd, this.zzXe, null);
      }

      public GoogleSignInOptions.Builder requestId() {
         this.zzXf.add(GoogleSignInOptions.zzWY);
         return this;
      }

      public GoogleSignInOptions.Builder requestProfile() {
         this.zzXf.add(GoogleSignInOptions.zzWW);
         return this;
      }

      public GoogleSignInOptions.Builder requestScopes(Scope var1, Scope... var2) {
         this.zzXf.add(var1);
         this.zzXf.addAll(Arrays.asList(var2));
         return this;
      }
   }
}

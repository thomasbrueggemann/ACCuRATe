package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.auth.api.credentials.zza;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
   public static final Creator<Credential> CREATOR = new zza();
   @Nullable
   private final String mName;
   final int mVersionCode;
   @Nullable
   private final Uri zzVV;
   private final List<IdToken> zzVW;
   @Nullable
   private final String zzVX;
   @Nullable
   private final String zzVY;
   @Nullable
   private final String zzVZ;
   @Nullable
   private final String zzWa;
   private final String zzyv;

   Credential(int var1, String var2, String var3, Uri var4, List<IdToken> var5, String var6, String var7, String var8, String var9) {
      this.mVersionCode = var1;
      String var10 = ((String)zzx.zzb(var2, "credential identifier cannot be null")).trim();
      zzx.zzh(var10, "credential identifier cannot be empty");
      this.zzyv = var10;
      if(var3 != null && TextUtils.isEmpty(var3.trim())) {
         var3 = null;
      }

      this.mName = var3;
      this.zzVV = var4;
      List var12;
      if(var5 == null) {
         var12 = Collections.emptyList();
      } else {
         var12 = Collections.unmodifiableList(var5);
      }

      this.zzVW = var12;
      this.zzVX = var6;
      if(var6 != null && var6.isEmpty()) {
         throw new IllegalArgumentException("password cannot be empty");
      } else {
         if(!TextUtils.isEmpty(var7)) {
            String var13 = Uri.parse(var7).getScheme();
            boolean var14;
            if(!"http".equalsIgnoreCase(var13) && !"https".equalsIgnoreCase(var13)) {
               var14 = false;
            } else {
               var14 = true;
            }

            zzx.zzac(var14);
         }

         this.zzVY = var7;
         this.zzVZ = var8;
         this.zzWa = var9;
         if(!TextUtils.isEmpty(this.zzVX) && !TextUtils.isEmpty(this.zzVY)) {
            throw new IllegalStateException("password and accountType cannot both be set");
         }
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Credential)) {
            return false;
         }

         Credential var2 = (Credential)var1;
         if(!TextUtils.equals(this.zzyv, var2.zzyv) || !TextUtils.equals(this.mName, var2.mName) || !zzw.equal(this.zzVV, var2.zzVV) || !TextUtils.equals(this.zzVX, var2.zzVX) || !TextUtils.equals(this.zzVY, var2.zzVY) || !TextUtils.equals(this.zzVZ, var2.zzVZ)) {
            return false;
         }
      }

      return true;
   }

   @Nullable
   public String getAccountType() {
      return this.zzVY;
   }

   @Nullable
   public String getGeneratedPassword() {
      return this.zzVZ;
   }

   public String getId() {
      return this.zzyv;
   }

   public List<IdToken> getIdTokens() {
      return this.zzVW;
   }

   @Nullable
   public String getName() {
      return this.mName;
   }

   @Nullable
   public String getPassword() {
      return this.zzVX;
   }

   @Nullable
   public Uri getProfilePictureUri() {
      return this.zzVV;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzyv, this.mName, this.zzVV, this.zzVX, this.zzVY, this.zzVZ};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public String zzmx() {
      return this.zzWa;
   }
}

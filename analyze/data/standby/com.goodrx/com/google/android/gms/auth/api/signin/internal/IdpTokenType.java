package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdpTokenType implements SafeParcelable {
   public static final Creator<IdpTokenType> CREATOR = new zzj();
   public static final IdpTokenType zzXA = new IdpTokenType("accessToken");
   public static final IdpTokenType zzXB = new IdpTokenType("idToken");
   final int versionCode;
   private final String zzXC;

   IdpTokenType(int var1, String var2) {
      this.versionCode = var1;
      this.zzXC = zzx.zzcM(var2);
   }

   private IdpTokenType(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = false;
      if(var1 != null) {
         boolean var4;
         try {
            var4 = this.zzXC.equals(((IdpTokenType)var1).zzng());
         } catch (ClassCastException var5) {
            return false;
         }

         var2 = false;
         if(var4) {
            var2 = true;
         }
      }

      return var2;
   }

   public int hashCode() {
      return this.zzXC.hashCode();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public String zzng() {
      return this.zzXC;
   }
}

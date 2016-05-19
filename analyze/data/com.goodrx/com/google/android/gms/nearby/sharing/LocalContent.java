package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.zzb;

public class LocalContent implements SafeParcelable {
   public static final Creator<LocalContent> CREATOR = new zzb();
   private int type;
   private final int versionCode;
   private String zzbdf;

   private LocalContent() {
      this.versionCode = 1;
   }

   LocalContent(int var1, int var2, String var3) {
      this.versionCode = var1;
      this.type = var2;
      this.zzbdf = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof LocalContent)) {
            return false;
         }

         LocalContent var2 = (LocalContent)var1;
         if(!zzw.equal(Integer.valueOf(this.type), Integer.valueOf(var2.type)) || !zzw.equal(this.zzbdf, var2.zzbdf)) {
            return false;
         }
      }

      return true;
   }

   public int getType() {
      return this.type;
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.type), this.zzbdf};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("LocalContent[contentUri=").append(this.zzbdf).append(", type=");
      String var2;
      if(this.type == 1) {
         var2 = "PUBLIC_CONTENT";
      } else {
         var2 = "APP_CONTENT";
      }

      return var1.append(var2).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public String zzEK() {
      return this.zzbdf;
   }
}

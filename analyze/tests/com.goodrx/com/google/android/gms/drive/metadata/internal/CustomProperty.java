package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.zzc;

public class CustomProperty implements SafeParcelable {
   public static final Creator<CustomProperty> CREATOR = new zzc();
   final String mValue;
   final int mVersionCode;
   final CustomPropertyKey zzasN;

   CustomProperty(int var1, CustomPropertyKey var2, String var3) {
      this.mVersionCode = var1;
      zzx.zzb(var2, "key");
      this.zzasN = var2;
      this.mValue = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1.getClass() == this.getClass()) {
            CustomProperty var2 = (CustomProperty)var1;
            if(zzw.equal(this.zzasN, var2.zzasN) && zzw.equal(this.mValue, var2.mValue)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public String getValue() {
      return this.mValue;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzasN, this.mValue};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   public CustomPropertyKey zztB() {
      return this.zzasN;
   }
}

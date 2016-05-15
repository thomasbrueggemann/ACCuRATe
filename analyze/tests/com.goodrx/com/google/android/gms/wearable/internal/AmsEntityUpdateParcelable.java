package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzf;

public class AmsEntityUpdateParcelable implements SafeParcelable {
   public static final Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
   private final String mValue;
   final int mVersionCode;
   private byte zzbrF;
   private final byte zzbrG;

   AmsEntityUpdateParcelable(int var1, byte var2, byte var3, String var4) {
      this.zzbrF = var2;
      this.mVersionCode = var1;
      this.zzbrG = var3;
      this.mValue = var4;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         }

         AmsEntityUpdateParcelable var2 = (AmsEntityUpdateParcelable)var1;
         if(this.zzbrF != var2.zzbrF) {
            return false;
         }

         if(this.mVersionCode != var2.mVersionCode) {
            return false;
         }

         if(this.zzbrG != var2.zzbrG) {
            return false;
         }

         if(!this.mValue.equals(var2.mValue)) {
            return false;
         }
      }

      return true;
   }

   public String getValue() {
      return this.mValue;
   }

   public int hashCode() {
      return 31 * (31 * (31 * this.mVersionCode + this.zzbrF) + this.zzbrG) + this.mValue.hashCode();
   }

   public String toString() {
      return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.zzbrF + ", mAttributeId=" + this.zzbrG + ", mValue=\'" + this.mValue + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public byte zzIA() {
      return this.zzbrG;
   }

   public byte zzIz() {
      return this.zzbrF;
   }
}

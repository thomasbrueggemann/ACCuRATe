package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzc;

@Deprecated
public class CountrySpecification implements SafeParcelable {
   public static final Creator<CountrySpecification> CREATOR = new zzc();
   private final int mVersionCode;
   String zzJU;

   CountrySpecification(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzJU = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}

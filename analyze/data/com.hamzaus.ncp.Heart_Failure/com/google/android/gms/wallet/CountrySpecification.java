package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_723;

@Deprecated
public class CountrySpecification implements SafeParcelable {
   public static final Creator<CountrySpecification> CREATOR = new class_723();
   // $FF: renamed from: rc java.lang.String
   String field_4313;
   // $FF: renamed from: xJ int
   private final int field_4314;

   CountrySpecification(int var1, String var2) {
      this.field_4314 = var1;
      this.field_4313 = var2;
   }

   public CountrySpecification(String var1) {
      this.field_4314 = 1;
      this.field_4313 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getCountryCode() {
      return this.field_4313;
   }

   public int getVersionCode() {
      return this.field_4314;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_723.method_4101(this, var1, var2);
   }
}

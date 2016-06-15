package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_942;

@Deprecated
public class CountrySpecification implements SafeParcelable {
   public static final Creator<CountrySpecification> CREATOR = new class_942();
   // $FF: renamed from: CK int
   private final int field_4465;
   // $FF: renamed from: vk java.lang.String
   String field_4466;

   CountrySpecification(int var1, String var2) {
      this.field_4465 = var1;
      this.field_4466 = var2;
   }

   public CountrySpecification(String var1) {
      this.field_4465 = 1;
      this.field_4466 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getCountryCode() {
      return this.field_4466;
   }

   public int getVersionCode() {
      return this.field_4465;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_942.method_5212(this, var1, var2);
   }
}

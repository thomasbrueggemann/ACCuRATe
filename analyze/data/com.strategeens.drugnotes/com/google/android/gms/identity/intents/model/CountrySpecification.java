package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.class_855;

public class CountrySpecification implements SafeParcelable {
   public static final Creator<CountrySpecification> CREATOR = new class_855();
   // $FF: renamed from: CK int
   private final int field_3093;
   // $FF: renamed from: vk java.lang.String
   String field_3094;

   CountrySpecification(int var1, String var2) {
      this.field_3093 = var1;
      this.field_3094 = var2;
   }

   public CountrySpecification(String var1) {
      this.field_3093 = 1;
      this.field_3094 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getCountryCode() {
      return this.field_3094;
   }

   public int getVersionCode() {
      return this.field_3093;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_855.method_4765(this, var1, var2);
   }
}

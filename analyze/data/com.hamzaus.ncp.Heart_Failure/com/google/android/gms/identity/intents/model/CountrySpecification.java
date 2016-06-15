package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.class_661;

public class CountrySpecification implements SafeParcelable {
   public static final Creator<CountrySpecification> CREATOR = new class_661();
   // $FF: renamed from: rc java.lang.String
   String field_3127;
   // $FF: renamed from: xJ int
   private final int field_3128;

   CountrySpecification(int var1, String var2) {
      this.field_3128 = var1;
      this.field_3127 = var2;
   }

   public CountrySpecification(String var1) {
      this.field_3128 = 1;
      this.field_3127 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public String getCountryCode() {
      return this.field_3127;
   }

   public int getVersionCode() {
      return this.field_3128;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_661.method_3807(this, var1, var2);
   }
}

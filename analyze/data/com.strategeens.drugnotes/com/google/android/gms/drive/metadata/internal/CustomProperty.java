package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.class_875;
import com.google.android.gms.internal.class_335;

public class CustomProperty implements SafeParcelable {
   public static final Creator<CustomProperty> CREATOR = new class_875();
   // $FF: renamed from: CK int
   final int field_3420;
   // $FF: renamed from: Rg com.google.android.gms.drive.metadata.CustomPropertyKey
   final CustomPropertyKey field_3421;
   final String mValue;

   CustomProperty(int var1, CustomPropertyKey var2, String var3) {
      this.field_3420 = var1;
      class_335.method_2306(var2, "key");
      this.field_3421 = var2;
      this.mValue = var3;
   }

   public CustomProperty(CustomPropertyKey var1, String var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public String getValue() {
      return this.mValue;
   }

   // $FF: renamed from: iX () com.google.android.gms.drive.metadata.CustomPropertyKey
   public CustomPropertyKey method_4353() {
      return this.field_3421;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_875.method_4937(this, var1, var2);
   }
}

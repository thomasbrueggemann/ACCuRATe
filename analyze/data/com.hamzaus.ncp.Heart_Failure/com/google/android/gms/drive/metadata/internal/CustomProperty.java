package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.class_678;
import com.google.android.gms.internal.class_347;

public class CustomProperty implements SafeParcelable {
   public static final Creator<CustomProperty> CREATOR = new class_678();
   // $FF: renamed from: JN com.google.android.gms.drive.metadata.CustomPropertyKey
   final CustomPropertyKey field_3341;
   final String mValue;
   // $FF: renamed from: xJ int
   final int field_3342;

   CustomProperty(int var1, CustomPropertyKey var2, String var3) {
      this.field_3342 = var1;
      class_347.method_2166(var2, "key");
      this.field_3341 = var2;
      this.mValue = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_678.method_3952(this, var1, var2);
   }
}

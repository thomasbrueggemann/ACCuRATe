package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_230;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class DeleteCustomPropertyRequest implements SafeParcelable {
   public static final Creator<DeleteCustomPropertyRequest> CREATOR = new class_230();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_2980;
   // $FF: renamed from: IG com.google.android.gms.drive.metadata.CustomPropertyKey
   final CustomPropertyKey field_2981;
   // $FF: renamed from: xJ int
   final int field_2982;

   DeleteCustomPropertyRequest(int var1, DriveId var2, CustomPropertyKey var3) {
      this.field_2982 = var1;
      this.field_2980 = var2;
      this.field_2981 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_230.method_1419(this, var1, var2);
   }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_231;

public class DeleteResourceRequest implements SafeParcelable {
   public static final Creator<DeleteResourceRequest> CREATOR = new class_231();
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   final DriveId field_3920;
   // $FF: renamed from: xJ int
   final int field_3921;

   DeleteResourceRequest(int var1, DriveId var2) {
      this.field_3921 = var1;
      this.field_3920 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_231.method_1422(this, var1, var2);
   }
}

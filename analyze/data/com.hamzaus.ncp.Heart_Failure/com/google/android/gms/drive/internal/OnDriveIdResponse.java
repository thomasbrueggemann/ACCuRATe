package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_792;

public class OnDriveIdResponse implements SafeParcelable {
   public static final Creator<OnDriveIdResponse> CREATOR = new class_792();
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   DriveId field_3112;
   // $FF: renamed from: xJ int
   final int field_3113;

   OnDriveIdResponse(int var1, DriveId var2) {
      this.field_3113 = var1;
      this.field_3112 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_3112;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_792.method_4413(this, var1, var2);
   }
}

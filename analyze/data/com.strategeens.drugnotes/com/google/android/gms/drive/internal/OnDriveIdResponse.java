package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1016;

public class OnDriveIdResponse implements SafeParcelable {
   public static final Creator<OnDriveIdResponse> CREATOR = new class_1016();
   // $FF: renamed from: CK int
   final int field_3061;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   DriveId field_3062;

   OnDriveIdResponse(int var1, DriveId var2) {
      this.field_3061 = var1;
      this.field_3062 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_3062;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1016.method_5597(this, var1, var2);
   }
}

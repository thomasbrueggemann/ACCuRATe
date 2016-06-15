package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_280;

public class DeleteResourceRequest implements SafeParcelable {
   public static final Creator<DeleteResourceRequest> CREATOR = new class_280();
   // $FF: renamed from: CK int
   final int field_3987;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_3988;

   DeleteResourceRequest(int var1, DriveId var2) {
      this.field_3987 = var1;
      this.field_3988 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_280.method_1763(this, var1, var2);
   }
}

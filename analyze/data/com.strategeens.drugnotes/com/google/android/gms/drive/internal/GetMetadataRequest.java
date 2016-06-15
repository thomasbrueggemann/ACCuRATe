package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1021;

public class GetMetadataRequest implements SafeParcelable {
   public static final Creator<GetMetadataRequest> CREATOR = new class_1021();
   // $FF: renamed from: CK int
   final int field_4450;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_4451;

   GetMetadataRequest(int var1, DriveId var2) {
      this.field_4450 = var1;
      this.field_4451 = var2;
   }

   public GetMetadataRequest(DriveId var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1021.method_5613(this, var1, var2);
   }
}

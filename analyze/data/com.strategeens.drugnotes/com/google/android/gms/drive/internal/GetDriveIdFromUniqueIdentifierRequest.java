package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1022;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
   public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new class_1022();
   // $FF: renamed from: CK int
   final int field_4079;
   // $FF: renamed from: QC java.lang.String
   final String field_4080;
   // $FF: renamed from: QD boolean
   final boolean field_4081;

   GetDriveIdFromUniqueIdentifierRequest(int var1, String var2, boolean var3) {
      this.field_4079 = var1;
      this.field_4080 = var2;
      this.field_4081 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1022.method_5616(this, var1, var2);
   }
}

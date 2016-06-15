package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1020;

public class ListParentsRequest implements SafeParcelable {
   public static final Creator<ListParentsRequest> CREATOR = new class_1020();
   // $FF: renamed from: CK int
   final int field_2493;
   // $FF: renamed from: QE com.google.android.gms.drive.DriveId
   final DriveId field_2494;

   ListParentsRequest(int var1, DriveId var2) {
      this.field_2493 = var1;
      this.field_2494 = var2;
   }

   public ListParentsRequest(DriveId var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1020.method_5609(this, var1, var2);
   }
}

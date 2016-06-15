package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1019;

public class LoadRealtimeRequest implements SafeParcelable {
   public static final Creator<LoadRealtimeRequest> CREATOR = new class_1019();
   // $FF: renamed from: CK int
   final int field_3751;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_3752;
   // $FF: renamed from: QF boolean
   final boolean field_3753;

   LoadRealtimeRequest(int var1, DriveId var2, boolean var3) {
      this.field_3751 = var1;
      this.field_3752 = var2;
      this.field_3753 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1019.method_5606(this, var1, var2);
   }
}

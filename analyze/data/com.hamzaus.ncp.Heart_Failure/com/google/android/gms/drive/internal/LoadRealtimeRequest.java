package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_795;

public class LoadRealtimeRequest implements SafeParcelable {
   public static final Creator<LoadRealtimeRequest> CREATOR = new class_795();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3609;
   // $FF: renamed from: Jp boolean
   final boolean field_3610;
   // $FF: renamed from: xJ int
   final int field_3611;

   LoadRealtimeRequest(int var1, DriveId var2, boolean var3) {
      this.field_3611 = var1;
      this.field_3609 = var2;
      this.field_3610 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_795.method_4422(this, var1, var2);
   }
}

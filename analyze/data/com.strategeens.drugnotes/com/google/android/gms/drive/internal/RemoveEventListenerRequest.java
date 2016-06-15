package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1027;

public class RemoveEventListenerRequest implements SafeParcelable {
   public static final Creator<RemoveEventListenerRequest> CREATOR = new class_1027();
   // $FF: renamed from: CK int
   final int field_3659;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_3660;
   // $FF: renamed from: Pm int
   final int field_3661;

   RemoveEventListenerRequest(int var1, DriveId var2, int var3) {
      this.field_3659 = var1;
      this.field_3660 = var2;
      this.field_3661 = var3;
   }

   public RemoveEventListenerRequest(DriveId var1, int var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1027.method_5633(this, var1, var2);
   }
}

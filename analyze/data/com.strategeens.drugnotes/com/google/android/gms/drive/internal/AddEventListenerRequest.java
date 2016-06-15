package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_250;

public class AddEventListenerRequest implements SafeParcelable {
   public static final Creator<AddEventListenerRequest> CREATOR = new class_250();
   // $FF: renamed from: CK int
   final int field_3860;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_3861;
   // $FF: renamed from: Pm int
   final int field_3862;

   AddEventListenerRequest(int var1, DriveId var2, int var3) {
      this.field_3860 = var1;
      this.field_3861 = var2;
      this.field_3862 = var3;
   }

   public AddEventListenerRequest(DriveId var1, int var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_250.method_1651(this, var1, var2);
   }
}

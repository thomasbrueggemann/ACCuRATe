package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_782;

public class OpenContentsRequest implements SafeParcelable {
   public static final Creator<OpenContentsRequest> CREATOR = new class_782();
   // $FF: renamed from: Hv int
   final int field_4322;
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   final DriveId field_4323;
   // $FF: renamed from: xJ int
   final int field_4324;

   OpenContentsRequest(int var1, DriveId var2, int var3) {
      this.field_4324 = var1;
      this.field_4323 = var2;
      this.field_4322 = var3;
   }

   public OpenContentsRequest(DriveId var1, int var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_782.method_4383(this, var1, var2);
   }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1006;

public class OpenContentsRequest implements SafeParcelable {
   public static final Creator<OpenContentsRequest> CREATOR = new class_1006();
   // $FF: renamed from: CK int
   final int field_4473;
   // $FF: renamed from: Oi int
   final int field_4474;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_4475;
   // $FF: renamed from: QT int
   final int field_4476;

   OpenContentsRequest(int var1, DriveId var2, int var3, int var4) {
      this.field_4473 = var1;
      this.field_4475 = var2;
      this.field_4474 = var3;
      this.field_4476 = var4;
   }

   public OpenContentsRequest(DriveId var1, int var2, int var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1006.method_5567(this, var1, var2);
   }
}

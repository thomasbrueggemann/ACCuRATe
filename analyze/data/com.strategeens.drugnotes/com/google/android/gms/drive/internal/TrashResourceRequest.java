package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1024;

public class TrashResourceRequest implements SafeParcelable {
   public static final Creator<TrashResourceRequest> CREATOR = new class_1024();
   // $FF: renamed from: CK int
   final int field_4373;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_4374;

   TrashResourceRequest(int var1, DriveId var2) {
      this.field_4373 = var1;
      this.field_4374 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1024.method_5624(this, var1, var2);
   }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1025;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
   public static final Creator<UpdateMetadataRequest> CREATOR = new class_1025();
   // $FF: renamed from: CK int
   final int field_4156;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_4157;
   // $FF: renamed from: Pq com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4158;

   UpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.field_4156 = var1;
      this.field_4157 = var2;
      this.field_4158 = var3;
   }

   public UpdateMetadataRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1025.method_5627(this, var1, var2);
   }
}

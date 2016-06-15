package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_778;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
   public static final Creator<UpdateMetadataRequest> CREATOR = new class_778();
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   final DriveId field_4047;
   // $FF: renamed from: Is com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4048;
   // $FF: renamed from: xJ int
   final int field_4049;

   UpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.field_4049 = var1;
      this.field_4047 = var2;
      this.field_4048 = var3;
   }

   public UpdateMetadataRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_778.method_4371(this, var1, var2);
   }
}

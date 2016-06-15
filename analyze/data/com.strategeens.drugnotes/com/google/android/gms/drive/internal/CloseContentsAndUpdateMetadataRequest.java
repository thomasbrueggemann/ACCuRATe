package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.class_272;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
   public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new class_272();
   // $FF: renamed from: CK int
   final int field_4405;
   // $FF: renamed from: Oy java.lang.String
   final String field_4406;
   // $FF: renamed from: Oz boolean
   final boolean field_4407;
   // $FF: renamed from: Pp com.google.android.gms.drive.DriveId
   final DriveId field_4408;
   // $FF: renamed from: Pq com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4409;
   // $FF: renamed from: Pr com.google.android.gms.drive.Contents
   final Contents field_4410;
   // $FF: renamed from: Ps int
   final int field_4411;

   CloseContentsAndUpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, boolean var5, String var6, int var7) {
      this.field_4405 = var1;
      this.field_4408 = var2;
      this.field_4409 = var3;
      this.field_4410 = var4;
      this.field_4407 = var5;
      this.field_4406 = var6;
      this.field_4411 = var7;
   }

   public CloseContentsAndUpdateMetadataRequest(DriveId var1, MetadataBundle var2, Contents var3, ExecutionOptions var4) {
      this(1, var1, var2, var3, var4.method_4310(), var4.method_4309(), var4.method_4311());
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_272.method_1735(this, var1, var2);
   }
}

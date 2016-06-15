package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_222;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
   public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new class_222();
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   final DriveId field_4246;
   // $FF: renamed from: Is com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4247;
   // $FF: renamed from: It com.google.android.gms.drive.Contents
   final Contents field_4248;
   // $FF: renamed from: Iu boolean
   final boolean field_4249;
   // $FF: renamed from: Iv java.lang.String
   final String field_4250;
   // $FF: renamed from: xJ int
   final int field_4251;

   CloseContentsAndUpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, boolean var5, String var6) {
      this.field_4251 = var1;
      this.field_4246 = var2;
      this.field_4247 = var3;
      this.field_4248 = var4;
      this.field_4249 = var5;
      this.field_4250 = var6;
   }

   public CloseContentsAndUpdateMetadataRequest(DriveId var1, MetadataBundle var2, Contents var3, boolean var4, String var5) {
      this(1, var1, var2, var3, var4, var5);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_222.method_1393(this, var1, var2);
   }
}

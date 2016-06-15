package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_227;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_347;

public class CreateFileRequest implements SafeParcelable {
   public static final Creator<CreateFileRequest> CREATOR = new class_227();
   // $FF: renamed from: IA com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3724;
   // $FF: renamed from: IB java.lang.Integer
   final Integer field_3725;
   // $FF: renamed from: IC com.google.android.gms.drive.DriveId
   final DriveId field_3726;
   // $FF: renamed from: IE boolean
   final boolean field_3727;
   // $FF: renamed from: It com.google.android.gms.drive.Contents
   final Contents field_3728;
   // $FF: renamed from: Iv java.lang.String
   final String field_3729;
   // $FF: renamed from: xJ int
   final int field_3730;

   CreateFileRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, Integer var5, boolean var6, String var7) {
      this.field_3730 = var1;
      this.field_3726 = (DriveId)class_347.method_2170(var2);
      this.field_3724 = (MetadataBundle)class_347.method_2170(var3);
      if(var5 != null && var5.intValue() != 0) {
         this.field_3728 = null;
      } else {
         this.field_3728 = (Contents)class_347.method_2170(var4);
      }

      this.field_3725 = var5;
      this.field_3727 = var6;
      this.field_3729 = var7;
   }

   public CreateFileRequest(DriveId var1, MetadataBundle var2, Contents var3, int var4, boolean var5, String var6) {
      this(2, var1, var2, var3, Integer.valueOf(var4), var5, var6);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_227.method_1409(this, var1, var2);
   }
}

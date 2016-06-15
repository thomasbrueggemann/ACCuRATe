package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_228;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_347;

public class CreateFolderRequest implements SafeParcelable {
   public static final Creator<CreateFolderRequest> CREATOR = new class_228();
   // $FF: renamed from: IA com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3257;
   // $FF: renamed from: IC com.google.android.gms.drive.DriveId
   final DriveId field_3258;
   // $FF: renamed from: xJ int
   final int field_3259;

   CreateFolderRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.field_3259 = var1;
      this.field_3258 = (DriveId)class_347.method_2170(var2);
      this.field_3257 = (MetadataBundle)class_347.method_2170(var3);
   }

   public CreateFolderRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_228.method_1412(this, var1, var2);
   }
}

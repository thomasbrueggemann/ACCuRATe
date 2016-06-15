package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_278;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_335;

public class CreateFolderRequest implements SafeParcelable {
   public static final Creator<CreateFolderRequest> CREATOR = new class_278();
   // $FF: renamed from: CK int
   final int field_3207;
   // $FF: renamed from: Px com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3208;
   // $FF: renamed from: Pz com.google.android.gms.drive.DriveId
   final DriveId field_3209;

   CreateFolderRequest(int var1, DriveId var2, MetadataBundle var3) {
      this.field_3207 = var1;
      this.field_3209 = (DriveId)class_335.method_2311(var2);
      this.field_3208 = (MetadataBundle)class_335.method_2311(var3);
   }

   public CreateFolderRequest(DriveId var1, MetadataBundle var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_278.method_1756(this, var1, var2);
   }
}

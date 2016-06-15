package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<CreateFileIntentSenderRequest> CREATOR = new class_276();
   // $FF: renamed from: CK int
   final int field_3781;
   // $FF: renamed from: OH java.lang.String
   final String field_3782;
   // $FF: renamed from: OJ com.google.android.gms.drive.DriveId
   final DriveId field_3783;
   // $FF: renamed from: Px com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3784;
   // $FF: renamed from: Py java.lang.Integer
   final Integer field_3785;
   // $FF: renamed from: ve int
   final int field_3786;

   CreateFileIntentSenderRequest(int var1, MetadataBundle var2, int var3, String var4, DriveId var5, Integer var6) {
      this.field_3781 = var1;
      this.field_3784 = var2;
      this.field_3786 = var3;
      this.field_3782 = var4;
      this.field_3783 = var5;
      this.field_3785 = var6;
   }

   public CreateFileIntentSenderRequest(MetadataBundle var1, int var2, String var3, DriveId var4, int var5) {
      this(1, var1, var2, var3, var4, Integer.valueOf(var5));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_276.method_1748(this, var1, var2);
   }
}

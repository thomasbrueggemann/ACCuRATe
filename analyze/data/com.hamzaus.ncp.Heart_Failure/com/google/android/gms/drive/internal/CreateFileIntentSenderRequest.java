package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_226;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<CreateFileIntentSenderRequest> CREATOR = new class_226();
   // $FF: renamed from: HV java.lang.String
   final String field_3656;
   // $FF: renamed from: HX com.google.android.gms.drive.DriveId
   final DriveId field_3657;
   // $FF: renamed from: IA com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3658;
   // $FF: renamed from: IB java.lang.Integer
   final Integer field_3659;
   // $FF: renamed from: qX int
   final int field_3660;
   // $FF: renamed from: xJ int
   final int field_3661;

   CreateFileIntentSenderRequest(int var1, MetadataBundle var2, int var3, String var4, DriveId var5, Integer var6) {
      this.field_3661 = var1;
      this.field_3658 = var2;
      this.field_3660 = var3;
      this.field_3656 = var4;
      this.field_3657 = var5;
      this.field_3659 = var6;
   }

   public CreateFileIntentSenderRequest(MetadataBundle var1, int var2, String var3, DriveId var4, int var5) {
      this(1, var1, var2, var3, var4, Integer.valueOf(var5));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_226.method_1406(this, var1, var2);
   }
}

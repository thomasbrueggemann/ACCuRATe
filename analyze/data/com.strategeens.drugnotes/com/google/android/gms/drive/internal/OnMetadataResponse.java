package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1009;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
   public static final Creator<OnMetadataResponse> CREATOR = new class_1009();
   // $FF: renamed from: CK int
   final int field_4510;
   // $FF: renamed from: Px com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4511;

   OnMetadataResponse(int var1, MetadataBundle var2) {
      this.field_4510 = var1;
      this.field_4511 = var2;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iU () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public MetadataBundle method_5866() {
      return this.field_4511;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1009.method_5576(this, var1, var2);
   }
}

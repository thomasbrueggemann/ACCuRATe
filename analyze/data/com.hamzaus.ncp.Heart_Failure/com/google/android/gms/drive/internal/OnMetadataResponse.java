package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_788;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
   public static final Creator<OnMetadataResponse> CREATOR = new class_788();
   // $FF: renamed from: IA com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4367;
   // $FF: renamed from: xJ int
   final int field_4368;

   OnMetadataResponse(int var1, MetadataBundle var2) {
      this.field_4368 = var1;
      this.field_4367 = var2;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gw () com.google.android.gms.drive.metadata.internal.MetadataBundle
   public MetadataBundle method_4602() {
      return this.field_4367;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_788.method_4401(this, var1, var2);
   }
}

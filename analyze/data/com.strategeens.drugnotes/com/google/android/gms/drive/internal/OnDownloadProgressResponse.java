package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1015;

public class OnDownloadProgressResponse implements SafeParcelable {
   public static final Creator<OnDownloadProgressResponse> CREATOR = new class_1015();
   // $FF: renamed from: CK int
   final int field_2934;
   // $FF: renamed from: QL long
   final long field_2935;
   // $FF: renamed from: QM long
   final long field_2936;

   OnDownloadProgressResponse(int var1, long var2, long var4) {
      this.field_2934 = var1;
      this.field_2935 = var2;
      this.field_2936 = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iO () long
   public long method_3886() {
      return this.field_2935;
   }

   // $FF: renamed from: iP () long
   public long method_3887() {
      return this.field_2936;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1015.method_5594(this, var1, var2);
   }
}

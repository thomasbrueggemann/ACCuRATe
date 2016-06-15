package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_480;
import com.google.android.gms.drive.internal.class_1012;

public class OnListParentsResponse extends class_480 implements SafeParcelable {
   public static final Creator<OnListParentsResponse> CREATOR = new class_1012();
   // $FF: renamed from: CK int
   final int field_1660;
   // $FF: renamed from: QR com.google.android.gms.common.data.DataHolder
   final DataHolder field_1661;

   OnListParentsResponse(int var1, DataHolder var2) {
      this.field_1660 = var1;
      this.field_1661 = var2;
   }

   // $FF: renamed from: I (android.os.Parcel, int) void
   protected void method_3026(Parcel var1, int var2) {
      class_1012.method_5585(this, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iT () com.google.android.gms.common.data.DataHolder
   public DataHolder method_3028() {
      return this.field_1661;
   }
}

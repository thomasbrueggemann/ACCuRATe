package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_480;
import com.google.android.gms.drive.internal.class_1011;

public class OnListEntriesResponse extends class_480 implements SafeParcelable {
   public static final Creator<OnListEntriesResponse> CREATOR = new class_1011();
   // $FF: renamed from: CK int
   final int field_1662;
   // $FF: renamed from: PJ boolean
   final boolean field_1663;
   // $FF: renamed from: QQ com.google.android.gms.common.data.DataHolder
   final DataHolder field_1664;

   OnListEntriesResponse(int var1, DataHolder var2, boolean var3) {
      this.field_1662 = var1;
      this.field_1664 = var2;
      this.field_1663 = var3;
   }

   // $FF: renamed from: I (android.os.Parcel, int) void
   protected void method_3026(Parcel var1, int var2) {
      class_1011.method_5582(this, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: iR () com.google.android.gms.common.data.DataHolder
   public DataHolder method_3029() {
      return this.field_1664;
   }

   // $FF: renamed from: iS () boolean
   public boolean method_3030() {
      return this.field_1663;
   }
}

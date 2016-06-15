package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1005;

public class OnSyncMoreResponse implements SafeParcelable {
   public static final Creator<OnSyncMoreResponse> CREATOR = new class_1005();
   // $FF: renamed from: CK int
   final int field_4138;
   // $FF: renamed from: PJ boolean
   final boolean field_4139;

   OnSyncMoreResponse(int var1, boolean var2) {
      this.field_4138 = var1;
      this.field_4139 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1005.method_5564(this, var1, var2);
   }
}

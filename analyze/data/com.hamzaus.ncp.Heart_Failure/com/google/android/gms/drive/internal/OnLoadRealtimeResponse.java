package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_786;

public class OnLoadRealtimeResponse implements SafeParcelable {
   public static final Creator<OnLoadRealtimeResponse> CREATOR = new class_786();
   // $FF: renamed from: Jz boolean
   final boolean field_3502;
   // $FF: renamed from: xJ int
   final int field_3503;

   OnLoadRealtimeResponse(int var1, boolean var2) {
      this.field_3503 = var1;
      this.field_3502 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_786.method_4395(this, var1, var2);
   }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_785;

public class OnSyncMoreResponse implements SafeParcelable {
   public static final Creator<OnSyncMoreResponse> CREATOR = new class_785();
   // $FF: renamed from: IM boolean
   final boolean field_4029;
   // $FF: renamed from: xJ int
   final int field_4030;

   OnSyncMoreResponse(int var1, boolean var2) {
      this.field_4030 = var1;
      this.field_4029 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_785.method_4392(this, var1, var2);
   }
}

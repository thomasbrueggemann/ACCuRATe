package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_595;

public class EndCompoundOperationRequest implements SafeParcelable {
   public static final Creator<EndCompoundOperationRequest> CREATOR = new class_595();
   // $FF: renamed from: xJ int
   final int field_4188;

   public EndCompoundOperationRequest() {
      this(1);
   }

   EndCompoundOperationRequest(int var1) {
      this.field_4188 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_595.method_3341(this, var1, var2);
   }
}

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_594;

public class BeginCompoundOperationRequest implements SafeParcelable {
   public static final Creator<BeginCompoundOperationRequest> CREATOR = new class_594();
   // $FF: renamed from: Lg boolean
   final boolean field_4073;
   final String mName;
   // $FF: renamed from: xJ int
   final int field_4074;

   BeginCompoundOperationRequest(int var1, boolean var2, String var3) {
      this.field_4074 = var1;
      this.field_4073 = var2;
      this.mName = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_594.method_3337(this, var1, var2);
   }
}

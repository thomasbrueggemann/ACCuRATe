package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_224;

public class CreateContentsRequest implements SafeParcelable {
   public static final Creator<CreateContentsRequest> CREATOR = new class_224();
   // $FF: renamed from: xJ int
   final int field_4064;

   public CreateContentsRequest() {
      this(1);
   }

   CreateContentsRequest(int var1) {
      this.field_4064 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_224.method_1399(this, var1, var2);
   }
}

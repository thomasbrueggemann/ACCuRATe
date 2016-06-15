package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_281;

public class DisconnectRequest implements SafeParcelable {
   public static final Creator<DisconnectRequest> CREATOR = new class_281();
   // $FF: renamed from: CK int
   final int field_4387;

   public DisconnectRequest() {
      this(1);
   }

   DisconnectRequest(int var1) {
      this.field_4387 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_281.method_1766(this, var1, var2);
   }
}

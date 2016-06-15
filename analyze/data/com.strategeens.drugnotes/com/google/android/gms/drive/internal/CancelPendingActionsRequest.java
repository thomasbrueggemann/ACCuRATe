package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_270;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
   public static final Creator<CancelPendingActionsRequest> CREATOR = new class_270();
   // $FF: renamed from: CK int
   final int field_3201;
   // $FF: renamed from: Pb java.util.List
   final List<String> field_3202;

   CancelPendingActionsRequest(int var1, List<String> var2) {
      this.field_3201 = var1;
      this.field_3202 = var2;
   }

   public CancelPendingActionsRequest(List<String> var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_270.method_1706(this, var1, var2);
   }
}

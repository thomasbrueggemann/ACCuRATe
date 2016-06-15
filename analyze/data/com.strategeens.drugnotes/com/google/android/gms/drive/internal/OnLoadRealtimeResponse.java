package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1010;

public class OnLoadRealtimeResponse implements SafeParcelable {
   public static final Creator<OnLoadRealtimeResponse> CREATOR = new class_1010();
   // $FF: renamed from: CK int
   final int field_3621;
   // $FF: renamed from: wg boolean
   final boolean field_3622;

   OnLoadRealtimeResponse(int var1, boolean var2) {
      this.field_3621 = var1;
      this.field_3622 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1010.method_5579(this, var1, var2);
   }
}

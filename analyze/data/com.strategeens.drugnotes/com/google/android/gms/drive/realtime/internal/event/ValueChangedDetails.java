package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_308;

public class ValueChangedDetails implements SafeParcelable {
   public static final Creator<ValueChangedDetails> CREATOR = new class_308();
   // $FF: renamed from: CK int
   final int field_1267;
   // $FF: renamed from: Tj int
   final int field_1268;

   ValueChangedDetails(int var1, int var2) {
      this.field_1267 = var1;
      this.field_1268 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_308.method_2181(this, var1, var2);
   }
}

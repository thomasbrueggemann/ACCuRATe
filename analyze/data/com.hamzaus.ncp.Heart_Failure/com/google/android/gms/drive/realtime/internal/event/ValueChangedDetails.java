package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_254;

public class ValueChangedDetails implements SafeParcelable {
   public static final Creator<ValueChangedDetails> CREATOR = new class_254();
   // $FF: renamed from: LJ int
   final int field_1581;
   // $FF: renamed from: xJ int
   final int field_1582;

   ValueChangedDetails(int var1, int var2) {
      this.field_1582 = var1;
      this.field_1581 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_254.method_1795(this, var1, var2);
   }
}

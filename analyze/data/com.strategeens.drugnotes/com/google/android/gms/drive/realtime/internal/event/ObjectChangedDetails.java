package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_313;

public class ObjectChangedDetails implements SafeParcelable {
   public static final Creator<ObjectChangedDetails> CREATOR = new class_313();
   // $FF: renamed from: CK int
   final int field_1201;
   // $FF: renamed from: SO int
   final int field_1202;
   // $FF: renamed from: SP int
   final int field_1203;

   ObjectChangedDetails(int var1, int var2, int var3) {
      this.field_1201 = var1;
      this.field_1202 = var2;
      this.field_1203 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_313.method_2196(this, var1, var2);
   }
}

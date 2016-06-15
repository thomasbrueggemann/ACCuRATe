package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_304;

public class ValuesSetDetails implements SafeParcelable {
   public static final Creator<ValuesSetDetails> CREATOR = new class_304();
   // $FF: renamed from: CK int
   final int field_1806;
   // $FF: renamed from: SO int
   final int field_1807;
   // $FF: renamed from: SP int
   final int field_1808;
   final int mIndex;

   ValuesSetDetails(int var1, int var2, int var3, int var4) {
      this.field_1806 = var1;
      this.mIndex = var2;
      this.field_1807 = var3;
      this.field_1808 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_304.method_2169(this, var1, var2);
   }
}

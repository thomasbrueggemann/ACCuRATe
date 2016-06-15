package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_255;

public class ReferenceShiftedDetails implements SafeParcelable {
   public static final Creator<ReferenceShiftedDetails> CREATOR = new class_255();
   // $FF: renamed from: LE java.lang.String
   final String field_3842;
   // $FF: renamed from: LF java.lang.String
   final String field_3843;
   // $FF: renamed from: LG int
   final int field_3844;
   // $FF: renamed from: LH int
   final int field_3845;
   // $FF: renamed from: xJ int
   final int field_3846;

   ReferenceShiftedDetails(int var1, String var2, String var3, int var4, int var5) {
      this.field_3846 = var1;
      this.field_3842 = var2;
      this.field_3843 = var3;
      this.field_3844 = var4;
      this.field_3845 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_255.method_1798(this, var1, var2);
   }
}

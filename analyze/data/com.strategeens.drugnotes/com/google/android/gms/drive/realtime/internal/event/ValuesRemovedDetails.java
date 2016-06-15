package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_306;

public class ValuesRemovedDetails implements SafeParcelable {
   public static final Creator<ValuesRemovedDetails> CREATOR = new class_306();
   // $FF: renamed from: CK int
   final int field_1800;
   // $FF: renamed from: SO int
   final int field_1801;
   // $FF: renamed from: SP int
   final int field_1802;
   // $FF: renamed from: Tm java.lang.String
   final String field_1803;
   // $FF: renamed from: Tn int
   final int field_1804;
   final int mIndex;

   ValuesRemovedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.field_1800 = var1;
      this.mIndex = var2;
      this.field_1801 = var3;
      this.field_1802 = var4;
      this.field_1803 = var5;
      this.field_1804 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_306.method_2175(this, var1, var2);
   }
}

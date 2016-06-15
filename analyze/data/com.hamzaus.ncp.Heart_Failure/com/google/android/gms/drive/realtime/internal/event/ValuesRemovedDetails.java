package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_252;

public class ValuesRemovedDetails implements SafeParcelable {
   public static final Creator<ValuesRemovedDetails> CREATOR = new class_252();
   // $FF: renamed from: LC int
   final int field_2103;
   // $FF: renamed from: LD int
   final int field_2104;
   // $FF: renamed from: LM java.lang.String
   final String field_2105;
   // $FF: renamed from: LN int
   final int field_2106;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_2107;

   ValuesRemovedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.field_2107 = var1;
      this.mIndex = var2;
      this.field_2103 = var3;
      this.field_2104 = var4;
      this.field_2105 = var5;
      this.field_2106 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_252.method_1789(this, var1, var2);
   }
}

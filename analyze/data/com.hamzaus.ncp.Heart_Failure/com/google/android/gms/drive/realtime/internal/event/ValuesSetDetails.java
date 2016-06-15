package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_250;

public class ValuesSetDetails implements SafeParcelable {
   public static final Creator<ValuesSetDetails> CREATOR = new class_250();
   // $FF: renamed from: LC int
   final int field_2109;
   // $FF: renamed from: LD int
   final int field_2110;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_2111;

   ValuesSetDetails(int var1, int var2, int var3, int var4) {
      this.field_2111 = var1;
      this.mIndex = var2;
      this.field_2109 = var3;
      this.field_2110 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_250.method_1783(this, var1, var2);
   }
}

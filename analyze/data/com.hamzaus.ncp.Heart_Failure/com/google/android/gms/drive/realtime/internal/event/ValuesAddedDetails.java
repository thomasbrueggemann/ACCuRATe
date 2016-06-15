package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_251;

public class ValuesAddedDetails implements SafeParcelable {
   public static final Creator<ValuesAddedDetails> CREATOR = new class_251();
   // $FF: renamed from: LC int
   final int field_3332;
   // $FF: renamed from: LD int
   final int field_3333;
   // $FF: renamed from: LK java.lang.String
   final String field_3334;
   // $FF: renamed from: LL int
   final int field_3335;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_3336;

   ValuesAddedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.field_3336 = var1;
      this.mIndex = var2;
      this.field_3332 = var3;
      this.field_3333 = var4;
      this.field_3334 = var5;
      this.field_3335 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_251.method_1786(this, var1, var2);
   }
}

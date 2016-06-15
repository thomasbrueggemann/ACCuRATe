package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_256;

public class TextDeletedDetails implements SafeParcelable {
   public static final Creator<TextDeletedDetails> CREATOR = new class_256();
   // $FF: renamed from: LI int
   final int field_3199;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_3200;

   TextDeletedDetails(int var1, int var2, int var3) {
      this.field_3200 = var1;
      this.mIndex = var2;
      this.field_3199 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_256.method_1801(this, var1, var2);
   }
}

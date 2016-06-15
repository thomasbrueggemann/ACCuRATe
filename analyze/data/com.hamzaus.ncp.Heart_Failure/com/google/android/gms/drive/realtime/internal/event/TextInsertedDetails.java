package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_253;

public class TextInsertedDetails implements SafeParcelable {
   public static final Creator<TextInsertedDetails> CREATOR = new class_253();
   // $FF: renamed from: LI int
   final int field_3669;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_3670;

   TextInsertedDetails(int var1, int var2, int var3) {
      this.field_3670 = var1;
      this.mIndex = var2;
      this.field_3669 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_253.method_1792(this, var1, var2);
   }
}

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_307;

public class TextInsertedDetails implements SafeParcelable {
   public static final Creator<TextInsertedDetails> CREATOR = new class_307();
   // $FF: renamed from: CK int
   final int field_3793;
   // $FF: renamed from: Ti int
   final int field_3794;
   final int mIndex;

   TextInsertedDetails(int var1, int var2, int var3) {
      this.field_3793 = var1;
      this.mIndex = var2;
      this.field_3794 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_307.method_2178(this, var1, var2);
   }
}

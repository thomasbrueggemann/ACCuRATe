package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_310;

public class TextDeletedDetails implements SafeParcelable {
   public static final Creator<TextDeletedDetails> CREATOR = new class_310();
   // $FF: renamed from: CK int
   final int field_3155;
   // $FF: renamed from: Ti int
   final int field_3156;
   final int mIndex;

   TextDeletedDetails(int var1, int var2, int var3) {
      this.field_3155 = var1;
      this.mIndex = var2;
      this.field_3156 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_310.method_2187(this, var1, var2);
   }
}

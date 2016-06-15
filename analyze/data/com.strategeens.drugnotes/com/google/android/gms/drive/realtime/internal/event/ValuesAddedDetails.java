package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_305;

public class ValuesAddedDetails implements SafeParcelable {
   public static final Creator<ValuesAddedDetails> CREATOR = new class_305();
   // $FF: renamed from: CK int
   final int field_3379;
   // $FF: renamed from: SO int
   final int field_3380;
   // $FF: renamed from: SP int
   final int field_3381;
   // $FF: renamed from: Tk java.lang.String
   final String field_3382;
   // $FF: renamed from: Tl int
   final int field_3383;
   final int mIndex;

   ValuesAddedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.field_3379 = var1;
      this.mIndex = var2;
      this.field_3380 = var3;
      this.field_3381 = var4;
      this.field_3382 = var5;
      this.field_3383 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_305.method_2172(this, var1, var2);
   }
}

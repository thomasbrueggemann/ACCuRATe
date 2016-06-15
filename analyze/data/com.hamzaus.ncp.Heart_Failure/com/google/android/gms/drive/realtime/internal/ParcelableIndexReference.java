package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_597;

public class ParcelableIndexReference implements SafeParcelable {
   public static final Creator<ParcelableIndexReference> CREATOR = new class_597();
   // $FF: renamed from: Ln java.lang.String
   final String field_3565;
   // $FF: renamed from: Lo boolean
   final boolean field_3566;
   final int mIndex;
   // $FF: renamed from: xJ int
   final int field_3567;

   ParcelableIndexReference(int var1, String var2, int var3, boolean var4) {
      this.field_3567 = var1;
      this.field_3565 = var2;
      this.mIndex = var3;
      this.field_3566 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_597.method_3349(this, var1, var2);
   }
}

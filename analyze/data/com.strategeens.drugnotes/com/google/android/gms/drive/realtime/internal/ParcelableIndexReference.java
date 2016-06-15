package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_702;

public class ParcelableIndexReference implements SafeParcelable {
   public static final Creator<ParcelableIndexReference> CREATOR = new class_702();
   // $FF: renamed from: CK int
   final int field_3687;
   // $FF: renamed from: SM java.lang.String
   final String field_3688;
   // $FF: renamed from: SN boolean
   final boolean field_3689;
   final int mIndex;

   ParcelableIndexReference(int var1, String var2, int var3, boolean var4) {
      this.field_3687 = var1;
      this.field_3688 = var2;
      this.mIndex = var3;
      this.field_3689 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_702.method_4013(this, var1, var2);
   }
}

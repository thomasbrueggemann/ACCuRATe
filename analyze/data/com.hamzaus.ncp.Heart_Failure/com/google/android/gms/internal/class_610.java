package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_611;
import com.google.android.gms.internal.lh;

// $FF: renamed from: com.google.android.gms.internal.lh
public final class class_610 implements SafeParcelable {
   public static final Creator<lh> CREATOR = new class_611();
   int[] aka;
   // $FF: renamed from: xJ int
   private final int field_3326;

   class_610() {
      this(1, (int[])null);
   }

   class_610(int var1, int[] var2) {
      this.field_3326 = var1;
      this.aka = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3326;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_611.method_3583(this, var1, var2);
   }
}

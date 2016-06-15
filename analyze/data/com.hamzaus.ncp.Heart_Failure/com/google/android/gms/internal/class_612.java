package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_613;
import com.google.android.gms.internal.lj;

// $FF: renamed from: com.google.android.gms.internal.lj
public final class class_612 implements SafeParcelable {
   public static final Creator<lj> CREATOR = new class_613();
   String[] akb;
   byte[][] akc;
   // $FF: renamed from: xJ int
   private final int field_3327;

   class_612() {
      this(1, new String[0], new byte[0][]);
   }

   class_612(int var1, String[] var2, byte[][] var3) {
      this.field_3327 = var1;
      this.akb = var2;
      this.akc = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3327;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_613.method_3586(this, var1, var2);
   }
}

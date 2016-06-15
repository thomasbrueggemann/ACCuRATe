package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_789;
import com.google.android.gms.internal.py;

// $FF: renamed from: com.google.android.gms.internal.py
public final class class_788 implements SafeParcelable {
   public static final Creator<py> CREATOR = new class_789();
   // $FF: renamed from: CK int
   private final int field_3441;
   String[] avY;
   byte[][] avZ;

   class_788() {
      this(1, new String[0], new byte[0][]);
   }

   class_788(int var1, String[] var2, byte[][] var3) {
      this.field_3441 = var1;
      this.avY = var2;
      this.avZ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3441;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_789.method_4412(this, var1, var2);
   }
}

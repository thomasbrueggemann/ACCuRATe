package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_787;
import com.google.android.gms.internal.pw;

// $FF: renamed from: com.google.android.gms.internal.pw
public final class class_797 implements SafeParcelable {
   public static final Creator<pw> CREATOR = new class_787();
   // $FF: renamed from: CK int
   private final int field_3443;
   int[] avX;

   class_797() {
      this(1, (int[])null);
   }

   class_797(int var1, int[] var2) {
      this.field_3443 = var1;
      this.avX = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3443;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_787.method_4409(this, var1, var2);
   }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_345;

// $FF: renamed from: com.google.android.gms.internal.hs
public class class_340 implements SafeParcelable {
   public static final class_345 CREATOR = new class_345();
   // $FF: renamed from: GQ java.lang.String
   public final String field_1407;
   // $FF: renamed from: GR int
   public final int field_1408;
   // $FF: renamed from: xJ int
   final int field_1409;

   public class_340(int var1, String var2, int var3) {
      this.field_1409 = var1;
      this.field_1407 = var2;
      this.field_1408 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_345.method_2150(this, var1, var2);
   }
}

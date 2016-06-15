package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_610;
import com.google.android.gms.internal.lh;

// $FF: renamed from: com.google.android.gms.internal.li
public class class_611 implements Creator<lh> {
   // $FF: renamed from: a (com.google.android.gms.internal.lh, android.os.Parcel, int) void
   static void method_3583(class_610 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3374(var1, 2, var0.aka, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ce (android.os.Parcel) com.google.android.gms.internal.lh
   public class_610 method_3584(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      int[] var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = class_600.method_3416(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_610(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3584(var1);
   }

   // $FF: renamed from: dK (int) com.google.android.gms.internal.lh[]
   public class_610[] method_3585(int var1) {
      return new class_610[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3585(var1);
   }
}

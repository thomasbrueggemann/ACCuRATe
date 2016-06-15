package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.gk;

// $FF: renamed from: com.google.android.gms.internal.gl
public class class_333 implements Creator<gk> {
   // $FF: renamed from: a (com.google.android.gms.internal.gk, android.os.Parcel, int) void
   static void method_2123(class_334 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3359(var1, 2, var0.method_2126());
      class_599.method_3372(var1, 3, var0.method_2127());
      class_599.method_3381(var1, 4, var0.method_2128());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: Y (int) com.google.android.gms.internal.gk[]
   public class_334[] method_2124(int var1) {
      return new class_334[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2125(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2124(var1);
   }

   // $FF: renamed from: v (android.os.Parcel) com.google.android.gms.internal.gk
   public class_334 method_2125(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      double var4 = 0.0D;
      boolean var6 = false;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var4 = class_600.method_3408(var1, var8);
            break;
         case 3:
            var6 = class_600.method_3398(var1, var8);
            break;
         case 4:
            var2 = class_600.method_3402(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_334(var7, var4, var6, var2);
      }
   }
}

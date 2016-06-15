package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.class_312;
import com.google.android.gms.internal.jl;

// $FF: renamed from: com.google.android.gms.internal.jm
public class class_311 implements Creator<jl> {
   // $FF: renamed from: a (com.google.android.gms.internal.jl, android.os.Parcel, int) void
   static void method_2019(class_312 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.method_2026());
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.method_2027());
      class_599.method_3365(var1, 3, var0.method_2028(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bu (android.os.Parcel) com.google.android.gms.internal.jl
   public class_312 method_2020(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      int var4 = -1;
      class_310 var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var2 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var4 = class_600.method_3402(var1, var7);
            break;
         case 3:
            var5 = (class_310)class_600.method_3390(var1, var7, class_310.CREATOR);
            break;
         case 1000:
            var6 = class_600.method_3402(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_312(var6, var2, var4, var5);
      }
   }

   // $FF: renamed from: cP (int) com.google.android.gms.internal.jl[]
   public class_312[] method_2021(int var1) {
      return new class_312[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2020(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2021(var1);
   }
}

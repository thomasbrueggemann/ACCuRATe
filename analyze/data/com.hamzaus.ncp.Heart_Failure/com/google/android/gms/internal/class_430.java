package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.dv;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.dw
public class class_430 implements Creator<dv> {
   // $FF: renamed from: a (com.google.android.gms.internal.dv, android.os.Parcel, int) void
   static void method_2595(class_431 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3369(var1, 2, var0.field_1888, false);
      class_599.method_3369(var1, 3, var0.field_1889, false);
      class_599.method_3370(var1, 4, var0.field_1885, false);
      class_599.method_3381(var1, 5, var0.errorCode);
      class_599.method_3370(var1, 6, var0.field_1886, false);
      class_599.method_3361(var1, 7, var0.field_1890);
      class_599.method_3372(var1, 8, var0.field_1891);
      class_599.method_3361(var1, 9, var0.field_1892);
      class_599.method_3370(var1, 10, var0.field_1893, false);
      class_599.method_3361(var1, 11, var0.field_1887);
      class_599.method_3381(var1, 12, var0.orientation);
      class_599.method_3369(var1, 13, var0.field_1894, false);
      class_599.method_3361(var1, 14, var0.field_1895);
      class_599.method_3369(var1, 15, var0.field_1896, false);
      class_599.method_3369(var1, 19, var0.field_1898, false);
      class_599.method_3372(var1, 18, var0.field_1897);
      class_599.method_3369(var1, 21, var0.field_1899, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2596(var1);
   }

   // $FF: renamed from: i (android.os.Parcel) com.google.android.gms.internal.dv
   public class_431 method_2596(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ArrayList var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      long var9 = 0L;
      boolean var11 = false;
      long var12 = 0L;
      ArrayList var14 = null;
      long var15 = 0L;
      int var17 = 0;
      String var18 = null;
      long var19 = 0L;
      String var21 = null;
      boolean var22 = false;
      String var23 = null;
      String var24 = null;

      while(var1.dataPosition() < var2) {
         int var25 = class_600.method_3383(var1);
         switch(class_600.method_3394(var25)) {
         case 1:
            var3 = class_600.method_3402(var1, var25);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var25);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var25);
            break;
         case 4:
            var6 = class_600.method_3386(var1, var25);
            break;
         case 5:
            var7 = class_600.method_3402(var1, var25);
            break;
         case 6:
            var8 = class_600.method_3386(var1, var25);
            break;
         case 7:
            var9 = class_600.method_3404(var1, var25);
            break;
         case 8:
            var11 = class_600.method_3398(var1, var25);
            break;
         case 9:
            var12 = class_600.method_3404(var1, var25);
            break;
         case 10:
            var14 = class_600.method_3386(var1, var25);
            break;
         case 11:
            var15 = class_600.method_3404(var1, var25);
            break;
         case 12:
            var17 = class_600.method_3402(var1, var25);
            break;
         case 13:
            var18 = class_600.method_3410(var1, var25);
            break;
         case 14:
            var19 = class_600.method_3404(var1, var25);
            break;
         case 15:
            var21 = class_600.method_3410(var1, var25);
            break;
         case 16:
         case 17:
         case 20:
         default:
            class_600.method_3395(var1, var25);
            break;
         case 18:
            var22 = class_600.method_3398(var1, var25);
            break;
         case 19:
            var23 = class_600.method_3410(var1, var25);
            break;
         case 21:
            var24 = class_600.method_3410(var1, var25);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_431(var3, var4, var5, var6, var7, var8, var9, var11, var12, var14, var15, var17, var18, var19, var21, var22, var23, var24);
      }
   }

   // $FF: renamed from: n (int) com.google.android.gms.internal.dv[]
   public class_431[] method_2597(int var1) {
      return new class_431[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2597(var1);
   }
}

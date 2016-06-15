package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_391;
import com.google.android.gms.internal.fq;

// $FF: renamed from: com.google.android.gms.internal.fr
public class class_387 implements Creator<fq> {
   // $FF: renamed from: a (com.google.android.gms.internal.fq, android.os.Parcel, int) void
   static void method_2464(class_388 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.name, false);
      class_599.method_3381(var1, 1000, var0.field_1747);
      class_599.method_3369(var1, 2, var0.field_1748, false);
      class_599.method_3372(var1, 3, var0.field_1749);
      class_599.method_3381(var1, 4, var0.weight);
      class_599.method_3372(var1, 5, var0.field_1750);
      class_599.method_3369(var1, 6, var0.field_1751, false);
      class_599.method_3375(var1, 7, var0.field_1752, var2, false);
      class_599.method_3374(var1, 8, var0.field_1753, false);
      class_599.method_3369(var1, 11, var0.field_1754, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: J (int) com.google.android.gms.internal.fq[]
   public class_388[] method_2465(int var1) {
      return new class_388[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2466(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2465(var1);
   }

   // $FF: renamed from: p (android.os.Parcel) com.google.android.gms.internal.fq
   public class_388 method_2466(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      int var5 = 1;
      int[] var6 = null;
      class_391[] var7 = null;
      String var8 = null;
      boolean var9 = false;
      String var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_600.method_3383(var1);
         switch(class_600.method_3394(var13)) {
         case 1:
            var11 = class_600.method_3410(var1, var13);
            break;
         case 2:
            var10 = class_600.method_3410(var1, var13);
            break;
         case 3:
            var9 = class_600.method_3398(var1, var13);
            break;
         case 4:
            var5 = class_600.method_3402(var1, var13);
            break;
         case 5:
            var2 = class_600.method_3398(var1, var13);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var13);
            break;
         case 7:
            var7 = (class_391[])class_600.method_3396(var1, var13, class_391.CREATOR);
            break;
         case 8:
            var6 = class_600.method_3416(var1, var13);
            break;
         case 11:
            var3 = class_600.method_3410(var1, var13);
            break;
         case 1000:
            var12 = class_600.method_3402(var1, var13);
            break;
         default:
            class_600.method_3395(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_388(var12, var11, var10, var9, var5, var2, var8, var7, var6, var3);
      }
   }
}

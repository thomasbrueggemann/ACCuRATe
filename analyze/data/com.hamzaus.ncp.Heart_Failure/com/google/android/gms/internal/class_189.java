package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.class_167;

// $FF: renamed from: com.google.android.gms.internal.ay
public class class_189 implements Creator<ax> {
   // $FF: renamed from: a (com.google.android.gms.internal.ax, android.os.Parcel, int) void
   static void method_1302(class_167 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3381(var1, 2, var0.field_530);
      class_599.method_3381(var1, 3, var0.backgroundColor);
      class_599.method_3381(var1, 4, var0.field_531);
      class_599.method_3381(var1, 5, var0.field_532);
      class_599.method_3381(var1, 6, var0.field_533);
      class_599.method_3381(var1, 7, var0.field_534);
      class_599.method_3381(var1, 8, var0.field_535);
      class_599.method_3381(var1, 9, var0.field_536);
      class_599.method_3369(var1, 10, var0.field_537, false);
      class_599.method_3381(var1, 11, var0.field_538);
      class_599.method_3369(var1, 12, var0.field_539, false);
      class_599.method_3381(var1, 13, var0.field_540);
      class_599.method_3381(var1, 14, var0.field_541);
      class_599.method_3369(var1, 15, var0.field_542, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1303(var1);
   }

   // $FF: renamed from: d (android.os.Parcel) com.google.android.gms.internal.ax
   public class_167 method_1303(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      int var15 = 0;
      int var16 = 0;
      String var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = class_600.method_3383(var1);
         switch(class_600.method_3394(var18)) {
         case 1:
            var3 = class_600.method_3402(var1, var18);
            break;
         case 2:
            var4 = class_600.method_3402(var1, var18);
            break;
         case 3:
            var5 = class_600.method_3402(var1, var18);
            break;
         case 4:
            var6 = class_600.method_3402(var1, var18);
            break;
         case 5:
            var7 = class_600.method_3402(var1, var18);
            break;
         case 6:
            var8 = class_600.method_3402(var1, var18);
            break;
         case 7:
            var9 = class_600.method_3402(var1, var18);
            break;
         case 8:
            var10 = class_600.method_3402(var1, var18);
            break;
         case 9:
            var11 = class_600.method_3402(var1, var18);
            break;
         case 10:
            var12 = class_600.method_3410(var1, var18);
            break;
         case 11:
            var13 = class_600.method_3402(var1, var18);
            break;
         case 12:
            var14 = class_600.method_3410(var1, var18);
            break;
         case 13:
            var15 = class_600.method_3402(var1, var18);
            break;
         case 14:
            var16 = class_600.method_3402(var1, var18);
            break;
         case 15:
            var17 = class_600.method_3410(var1, var18);
            break;
         default:
            class_600.method_3395(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_167(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   // $FF: renamed from: f (int) com.google.android.gms.internal.ax[]
   public class_167[] method_1304(int var1) {
      return new class_167[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1304(var1);
   }
}

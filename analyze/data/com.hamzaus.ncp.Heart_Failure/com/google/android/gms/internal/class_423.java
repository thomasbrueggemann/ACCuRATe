package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.ci;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_453;

// $FF: renamed from: com.google.android.gms.internal.ch
public class class_423 implements Creator<ci> {
   // $FF: renamed from: a (com.google.android.gms.internal.ci, android.os.Parcel, int) void
   static void method_2566(class_424 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3365(var1, 2, var0.field_1867, var2, false);
      class_599.method_3363(var1, 3, var0.method_2571(), false);
      class_599.method_3363(var1, 4, var0.method_2572(), false);
      class_599.method_3363(var1, 5, var0.method_2573(), false);
      class_599.method_3363(var1, 6, var0.method_2574(), false);
      class_599.method_3369(var1, 7, var0.field_1872, false);
      class_599.method_3372(var1, 8, var0.field_1873);
      class_599.method_3369(var1, 9, var0.field_1861, false);
      class_599.method_3363(var1, 10, var0.method_2576(), false);
      class_599.method_3381(var1, 11, var0.orientation);
      class_599.method_3381(var1, 12, var0.field_1863);
      class_599.method_3369(var1, 13, var0.field_1860, false);
      class_599.method_3365(var1, 14, var0.field_1859, var2, false);
      class_599.method_3363(var1, 15, var0.method_2575(), false);
      class_599.method_3365(var1, 17, var0.field_1866, var2, false);
      class_599.method_3369(var1, 16, var0.field_1865, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2567(var1);
   }

   // $FF: renamed from: f (android.os.Parcel) com.google.android.gms.internal.ci
   public class_424 method_2567(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      class_421 var4 = null;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;
      IBinder var8 = null;
      String var9 = null;
      boolean var10 = false;
      String var11 = null;
      IBinder var12 = null;
      int var13 = 0;
      int var14 = 0;
      String var15 = null;
      class_373 var16 = null;
      IBinder var17 = null;
      String var18 = null;
      class_453 var19 = null;

      while(var1.dataPosition() < var2) {
         int var20 = class_600.method_3383(var1);
         switch(class_600.method_3394(var20)) {
         case 1:
            var3 = class_600.method_3402(var1, var20);
            break;
         case 2:
            var4 = (class_421)class_600.method_3390(var1, var20, class_421.CREATOR);
            break;
         case 3:
            var5 = class_600.method_3411(var1, var20);
            break;
         case 4:
            var6 = class_600.method_3411(var1, var20);
            break;
         case 5:
            var7 = class_600.method_3411(var1, var20);
            break;
         case 6:
            var8 = class_600.method_3411(var1, var20);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var20);
            break;
         case 8:
            var10 = class_600.method_3398(var1, var20);
            break;
         case 9:
            var11 = class_600.method_3410(var1, var20);
            break;
         case 10:
            var12 = class_600.method_3411(var1, var20);
            break;
         case 11:
            var13 = class_600.method_3402(var1, var20);
            break;
         case 12:
            var14 = class_600.method_3402(var1, var20);
            break;
         case 13:
            var15 = class_600.method_3410(var1, var20);
            break;
         case 14:
            var16 = (class_373)class_600.method_3390(var1, var20, class_373.CREATOR);
            break;
         case 15:
            var17 = class_600.method_3411(var1, var20);
            break;
         case 16:
            var18 = class_600.method_3410(var1, var20);
            break;
         case 17:
            var19 = (class_453)class_600.method_3390(var1, var20, class_453.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var20);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_424(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
      }
   }

   // $FF: renamed from: j (int) com.google.android.gms.internal.ci[]
   public class_424[] method_2568(int var1) {
      return new class_424[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2568(var1);
   }
}

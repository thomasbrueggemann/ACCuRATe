package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_346;

// $FF: renamed from: com.google.android.gms.internal.ia
public class class_294 implements Creator<class_285.class_944> {
   // $FF: renamed from: a (com.google.android.gms.internal.hz$a, android.os.Parcel, int) void
   static void method_1973(class_285.class_944 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.method_3224());
      class_599.method_3372(var1, 3, var0.method_3215());
      class_599.method_3381(var1, 4, var0.method_3213());
      class_599.method_3372(var1, 5, var0.method_3216());
      class_599.method_3369(var1, 6, var0.method_3217(), false);
      class_599.method_3381(var1, 7, var0.method_3218());
      class_599.method_3369(var1, 8, var0.method_3220(), false);
      class_599.method_3365(var1, 9, var0.method_3222(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: H (android.os.Parcel) com.google.android.gms.internal.hz$a
   public class_285.class_944 method_1974(Parcel var1) {
      class_346 var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      int var8 = 0;
      boolean var9 = false;
      int var10 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_600.method_3383(var1);
         switch(class_600.method_3394(var12)) {
         case 1:
            var11 = class_600.method_3402(var1, var12);
            break;
         case 2:
            var10 = class_600.method_3402(var1, var12);
            break;
         case 3:
            var9 = class_600.method_3398(var1, var12);
            break;
         case 4:
            var8 = class_600.method_3402(var1, var12);
            break;
         case 5:
            var7 = class_600.method_3398(var1, var12);
            break;
         case 6:
            var6 = class_600.method_3410(var1, var12);
            break;
         case 7:
            var3 = class_600.method_3402(var1, var12);
            break;
         case 8:
            var5 = class_600.method_3410(var1, var12);
            break;
         case 9:
            var2 = (class_346)class_600.method_3390(var1, var12, class_346.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_285.class_944(var11, var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: aw (int) com.google.android.gms.internal.hz$a[]
   public class_285.class_944[] method_1975(int var1) {
      return new class_285.class_944[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1974(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1975(var1);
   }
}

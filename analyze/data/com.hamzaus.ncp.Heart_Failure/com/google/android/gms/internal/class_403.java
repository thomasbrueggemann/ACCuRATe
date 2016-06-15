package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_398;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.fh;

// $FF: renamed from: com.google.android.gms.internal.fi
public class class_403 implements Creator<fh> {
   // $FF: renamed from: a (com.google.android.gms.internal.fh, android.os.Parcel, int) void
   static void method_2489(class_402 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3375(var1, 1, var0.field_1782, var2, false);
      class_599.method_3381(var1, 1000, var0.field_1781);
      class_599.method_3369(var1, 2, var0.field_1783, false);
      class_599.method_3372(var1, 3, var0.field_1784);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: D (int) com.google.android.gms.internal.fh[]
   public class_402[] method_2490(int var1) {
      return new class_402[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2491(var1);
   }

   // $FF: renamed from: l (android.os.Parcel) com.google.android.gms.internal.fh
   public class_402 method_2491(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = class_600.method_3385(var1);
      class_398[] var5 = null;

      int var6;
      boolean var8;
      for(var6 = 0; var1.dataPosition() < var4; var3 = var8) {
         int var7 = class_600.method_3383(var1);
         String var9;
         class_398[] var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            class_398[] var16 = (class_398[])class_600.method_3396(var1, var7, class_398.CREATOR);
            var11 = var6;
            var10 = var16;
            var8 = var3;
            var9 = var2;
            break;
         case 2:
            String var12 = class_600.method_3410(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var3;
            break;
         case 3:
            var8 = class_600.method_3398(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var6;
            break;
         case 1000:
            int var14 = class_600.method_3402(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var14;
            var8 = var3;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var3;
            var9 = var2;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var2 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_402(var6, var5, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2490(var1);
   }
}

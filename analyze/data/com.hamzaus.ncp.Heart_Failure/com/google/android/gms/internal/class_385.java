package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_400;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.fs;

// $FF: renamed from: com.google.android.gms.internal.ft
public class class_385 implements Creator<fs> {
   // $FF: renamed from: a (com.google.android.gms.internal.fs, android.os.Parcel, int) void
   static void method_2454(class_386 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.field_1743, var2, false);
      class_599.method_3381(var1, 1000, var0.field_1742);
      class_599.method_3361(var1, 2, var0.field_1744);
      class_599.method_3381(var1, 3, var0.field_1745);
      class_599.method_3369(var1, 4, var0.field_1741, false);
      class_599.method_3365(var1, 5, var0.field_1746, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: K (int) com.google.android.gms.internal.fs[]
   public class_386[] method_2455(int var1) {
      return new class_386[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2456(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2455(var1);
   }

   // $FF: renamed from: q (android.os.Parcel) com.google.android.gms.internal.fs
   public class_386 method_2456(Parcel var1) {
      int var2 = 0;
      class_402 var3 = null;
      int var4 = class_600.method_3385(var1);
      long var5 = 0L;
      String var7 = null;
      class_400 var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var8 = (class_400)class_600.method_3390(var1, var10, class_400.CREATOR);
            break;
         case 2:
            var5 = class_600.method_3404(var1, var10);
            break;
         case 3:
            var2 = class_600.method_3402(var1, var10);
            break;
         case 4:
            var7 = class_600.method_3410(var1, var10);
            break;
         case 5:
            var3 = (class_402)class_600.method_3390(var1, var10, class_402.CREATOR);
            break;
         case 1000:
            var9 = class_600.method_3402(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_386(var9, var8, var5, var2, var7, var3);
      }
   }
}

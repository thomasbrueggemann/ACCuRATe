package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.plus.internal.PlusCommonExtras;

// $FF: renamed from: com.google.android.gms.plus.internal.f
public class class_673 implements Creator<PlusCommonExtras> {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.PlusCommonExtras, android.os.Parcel, int) void
   static void method_3919(PlusCommonExtras var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.method_2679(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.method_2680(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bC (android.os.Parcel) com.google.android.gms.plus.internal.PlusCommonExtras
   public PlusCommonExtras method_3920(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var5 = class_600.method_3410(var1, var6);
            break;
         case 2:
            var2 = class_600.method_3410(var1, var6);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new PlusCommonExtras(var4, var5, var2);
      }
   }

   // $FF: renamed from: cZ (int) com.google.android.gms.plus.internal.PlusCommonExtras[]
   public PlusCommonExtras[] method_3921(int var1) {
      return new PlusCommonExtras[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3920(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3921(var1);
   }
}

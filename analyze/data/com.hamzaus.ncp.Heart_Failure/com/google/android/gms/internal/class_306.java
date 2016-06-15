package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_305;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.jr;

// $FF: renamed from: com.google.android.gms.internal.js
public class class_306 implements Creator<jr> {
   // $FF: renamed from: a (com.google.android.gms.internal.jr, android.os.Parcel, int) void
   static void method_2003(class_305 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_1154);
      class_599.method_3365(var1, 2, var0.method_2002(), var2, false);
      class_599.method_3361(var1, 3, var0.getInterval());
      class_599.method_3381(var1, 4, var0.getPriority());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bx (android.os.Parcel) com.google.android.gms.internal.jr
   public class_305 method_2004(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      class_310 var4 = null;
      long var5 = class_305.field_1151;
      int var7 = 102;

      while(var1.dataPosition() < var2) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 2:
            var4 = (class_310)class_600.method_3390(var1, var8, class_310.CREATOR);
            break;
         case 3:
            var5 = class_600.method_3404(var1, var8);
            break;
         case 4:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_305(var3, var4, var5, var7);
      }
   }

   // $FF: renamed from: cS (int) com.google.android.gms.internal.jr[]
   public class_305[] method_2005(int var1) {
      return new class_305[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2004(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2005(var1);
   }
}

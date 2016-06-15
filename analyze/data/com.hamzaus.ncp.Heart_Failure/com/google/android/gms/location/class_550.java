package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.location.b;
import com.google.android.gms.location.class_549;

// $FF: renamed from: com.google.android.gms.location.c
public class class_550 implements Creator<b> {
   // $FF: renamed from: a (com.google.android.gms.location.b, android.os.Parcel, int) void
   static void method_3118(class_549 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2948);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.field_2949);
      class_599.method_3361(var1, 3, var0.field_2950);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bs (android.os.Parcel) com.google.android.gms.location.b
   public class_549 method_3119(Parcel var1) {
      int var2 = 1;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      long var5 = 0L;
      int var7 = var2;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var2 = class_600.method_3402(var1, var8);
            break;
         case 3:
            var5 = class_600.method_3404(var1, var8);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_549(var4, var7, var2, var5);
      }
   }

   // $FF: renamed from: cL (int) com.google.android.gms.location.b[]
   public class_549[] method_3120(int var1) {
      return new class_549[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3119(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3120(var1);
   }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.ew;

// $FF: renamed from: com.google.android.gms.internal.ex
public class class_372 implements Creator<ew> {
   // $FF: renamed from: a (com.google.android.gms.internal.ew, android.os.Parcel, int) void
   static void method_2373(class_373 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3369(var1, 2, var0.field_1607, false);
      class_599.method_3381(var1, 3, var0.field_1608);
      class_599.method_3381(var1, 4, var0.field_1609);
      class_599.method_3372(var1, 5, var0.field_1610);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2374(var1);
   }

   // $FF: renamed from: j (android.os.Parcel) com.google.android.gms.internal.ew
   public class_373 method_2374(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var8);
            break;
         case 3:
            var6 = class_600.method_3402(var1, var8);
            break;
         case 4:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 5:
            var2 = class_600.method_3398(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_373(var7, var4, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2375(var1);
   }

   // $FF: renamed from: q (int) com.google.android.gms.internal.ew[]
   public class_373[] method_2375(int var1) {
      return new class_373[var1];
   }
}

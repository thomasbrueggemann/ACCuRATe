package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_303;
import com.google.android.gms.internal.jt;

// $FF: renamed from: com.google.android.gms.internal.ju
public class class_304 implements Creator<jt> {
   // $FF: renamed from: a (com.google.android.gms.internal.jt, android.os.Parcel, int) void
   static void method_1998(class_303 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.field_1148, false);
      class_599.method_3381(var1, 1000, var0.field_1149);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: by (android.os.Parcel) com.google.android.gms.internal.jt
   public class_303 method_1999(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = class_600.method_3410(var1, var5);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_303(var3, var4);
      }
   }

   // $FF: renamed from: cT (int) com.google.android.gms.internal.jt[]
   public class_303[] method_2000(int var1) {
      return new class_303[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1999(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2000(var1);
   }
}

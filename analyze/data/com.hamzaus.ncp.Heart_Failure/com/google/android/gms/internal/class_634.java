package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.kb;

// $FF: renamed from: com.google.android.gms.internal.kc
public class class_634 implements Creator<kb> {
   // $FF: renamed from: a (com.google.android.gms.internal.kb, android.os.Parcel, int) void
   static void method_3631(class_298 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.field_1008, false);
      class_599.method_3381(var1, 1000, var0.versionCode);
      class_599.method_3369(var1, 2, var0.field_1009, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bB (android.os.Parcel) com.google.android.gms.internal.kb
   public class_298 method_3632(Parcel var1) {
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
         return new class_298(var4, var5, var2);
      }
   }

   // $FF: renamed from: cW (int) com.google.android.gms.internal.kb[]
   public class_298[] method_3633(int var1) {
      return new class_298[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3632(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3633(var1);
   }
}
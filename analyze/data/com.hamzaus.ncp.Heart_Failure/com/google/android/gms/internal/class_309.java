package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_303;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.jn;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.jo
public class class_309 implements Creator<jn> {
   // $FF: renamed from: a (com.google.android.gms.internal.jn, android.os.Parcel, int) void
   static void method_2012(class_310 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3380(var1, 1, var0.field_1158, false);
      class_599.method_3381(var1, 1000, var0.field_1167);
      class_599.method_3369(var1, 2, var0.method_2016(), false);
      class_599.method_3372(var1, 3, var0.method_2017());
      class_599.method_3380(var1, 4, var0.field_1161, false);
      class_599.method_3369(var1, 5, var0.method_2018(), false);
      class_599.method_3370(var1, 6, var0.field_1163, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bv (android.os.Parcel) com.google.android.gms.internal.jn
   public class_310 method_2013(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = class_600.method_3385(var1);
      String var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      ArrayList var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var8 = class_600.method_3397(var1, var10, class_303.CREATOR);
            break;
         case 2:
            var7 = class_600.method_3410(var1, var10);
            break;
         case 3:
            var2 = class_600.method_3398(var1, var10);
            break;
         case 4:
            var6 = class_600.method_3397(var1, var10, class_299.CREATOR);
            break;
         case 5:
            var5 = class_600.method_3410(var1, var10);
            break;
         case 6:
            var3 = class_600.method_3386(var1, var10);
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
         return new class_310(var9, var8, var7, var2, var6, var5, var3);
      }
   }

   // $FF: renamed from: cQ (int) com.google.android.gms.internal.jn[]
   public class_310[] method_2014(int var1) {
      return new class_310[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2013(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2014(var1);
   }
}

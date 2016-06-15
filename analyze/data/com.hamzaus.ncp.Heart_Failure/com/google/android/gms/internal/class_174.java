package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_182;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.ak
public class class_174 implements Creator<aj> {
   // $FF: renamed from: a (com.google.android.gms.internal.aj, android.os.Parcel, int) void
   static void method_1271(class_182 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3361(var1, 2, var0.field_579);
      class_599.method_3362(var1, 3, var0.extras, false);
      class_599.method_3381(var1, 4, var0.field_580);
      class_599.method_3370(var1, 5, var0.field_581, false);
      class_599.method_3372(var1, 6, var0.field_582);
      class_599.method_3381(var1, 7, var0.field_583);
      class_599.method_3372(var1, 8, var0.field_584);
      class_599.method_3369(var1, 9, var0.field_585, false);
      class_599.method_3365(var1, 10, var0.field_586, var2, false);
      class_599.method_3365(var1, 11, var0.field_587, var2, false);
      class_599.method_3369(var1, 12, var0.field_588, false);
      class_599.method_3362(var1, 13, var0.field_589, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: b (android.os.Parcel) com.google.android.gms.internal.aj
   public class_182 method_1272(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      long var4 = 0L;
      Bundle var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      boolean var9 = false;
      int var10 = 0;
      boolean var11 = false;
      String var12 = null;
      class_167 var13 = null;
      Location var14 = null;
      String var15 = null;
      Bundle var16 = null;

      while(var1.dataPosition() < var2) {
         int var17 = class_600.method_3383(var1);
         switch(class_600.method_3394(var17)) {
         case 1:
            var3 = class_600.method_3402(var1, var17);
            break;
         case 2:
            var4 = class_600.method_3404(var1, var17);
            break;
         case 3:
            var6 = class_600.method_3412(var1, var17);
            break;
         case 4:
            var7 = class_600.method_3402(var1, var17);
            break;
         case 5:
            var8 = class_600.method_3386(var1, var17);
            break;
         case 6:
            var9 = class_600.method_3398(var1, var17);
            break;
         case 7:
            var10 = class_600.method_3402(var1, var17);
            break;
         case 8:
            var11 = class_600.method_3398(var1, var17);
            break;
         case 9:
            var12 = class_600.method_3410(var1, var17);
            break;
         case 10:
            var13 = (class_167)class_600.method_3390(var1, var17, class_167.CREATOR);
            break;
         case 11:
            var14 = (Location)class_600.method_3390(var1, var17, Location.CREATOR);
            break;
         case 12:
            var15 = class_600.method_3410(var1, var17);
            break;
         case 13:
            var16 = class_600.method_3412(var1, var17);
            break;
         default:
            class_600.method_3395(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_182(var3, var4, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   // $FF: renamed from: c (int) com.google.android.gms.internal.aj[]
   public class_182[] method_1273(int var1) {
      return new class_182[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1272(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1273(var1);
   }
}

package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.dt;

// $FF: renamed from: com.google.android.gms.internal.du
public class class_432 implements Creator<dt> {
   // $FF: renamed from: a (com.google.android.gms.internal.dt, android.os.Parcel, int) void
   static void method_2598(class_433 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3362(var1, 2, var0.field_1903, false);
      class_599.method_3365(var1, 3, var0.field_1904, var2, false);
      class_599.method_3365(var1, 4, var0.field_1902, var2, false);
      class_599.method_3369(var1, 5, var0.field_1900, false);
      class_599.method_3365(var1, 6, var0.applicationInfo, var2, false);
      class_599.method_3365(var1, 7, var0.field_1905, var2, false);
      class_599.method_3369(var1, 8, var0.field_1906, false);
      class_599.method_3369(var1, 9, var0.field_1907, false);
      class_599.method_3369(var1, 10, var0.field_1908, false);
      class_599.method_3365(var1, 11, var0.field_1901, var2, false);
      class_599.method_3362(var1, 12, var0.field_1909, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2599(var1);
   }

   // $FF: renamed from: h (android.os.Parcel) com.google.android.gms.internal.dt
   public class_433 method_2599(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      Bundle var4 = null;
      class_182 var5 = null;
      class_172 var6 = null;
      String var7 = null;
      ApplicationInfo var8 = null;
      PackageInfo var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      class_373 var13 = null;
      Bundle var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = class_600.method_3383(var1);
         switch(class_600.method_3394(var15)) {
         case 1:
            var3 = class_600.method_3402(var1, var15);
            break;
         case 2:
            var4 = class_600.method_3412(var1, var15);
            break;
         case 3:
            var5 = (class_182)class_600.method_3390(var1, var15, class_182.CREATOR);
            break;
         case 4:
            var6 = (class_172)class_600.method_3390(var1, var15, class_172.CREATOR);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var15);
            break;
         case 6:
            var8 = (ApplicationInfo)class_600.method_3390(var1, var15, ApplicationInfo.CREATOR);
            break;
         case 7:
            var9 = (PackageInfo)class_600.method_3390(var1, var15, PackageInfo.CREATOR);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var15);
            break;
         case 9:
            var11 = class_600.method_3410(var1, var15);
            break;
         case 10:
            var12 = class_600.method_3410(var1, var15);
            break;
         case 11:
            var13 = (class_373)class_600.method_3390(var1, var15, class_373.CREATOR);
            break;
         case 12:
            var14 = class_600.method_3412(var1, var15);
            break;
         default:
            class_600.method_3395(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_433(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: renamed from: m (int) com.google.android.gms.internal.dt[]
   public class_433[] method_2600(int var1) {
      return new class_433[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2600(var1);
   }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.cf;
import com.google.android.gms.internal.class_421;

// $FF: renamed from: com.google.android.gms.internal.ce
public class class_420 implements Creator<cf> {
   // $FF: renamed from: a (com.google.android.gms.internal.cf, android.os.Parcel, int) void
   static void method_2550(class_421 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3369(var1, 2, var0.field_1840, false);
      class_599.method_3369(var1, 3, var0.field_1841, false);
      class_599.method_3369(var1, 4, var0.mimeType, false);
      class_599.method_3369(var1, 5, var0.packageName, false);
      class_599.method_3369(var1, 6, var0.field_1842, false);
      class_599.method_3369(var1, 7, var0.field_1843, false);
      class_599.method_3369(var1, 8, var0.field_1844, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2551(var1);
   }

   // $FF: renamed from: e (android.os.Parcel) com.google.android.gms.internal.cf
   public class_421 method_2551(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var4 = class_600.method_3402(var1, var11);
            break;
         case 2:
            var10 = class_600.method_3410(var1, var11);
            break;
         case 3:
            var9 = class_600.method_3410(var1, var11);
            break;
         case 4:
            var8 = class_600.method_3410(var1, var11);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var11);
            break;
         case 6:
            var6 = class_600.method_3410(var1, var11);
            break;
         case 7:
            var5 = class_600.method_3410(var1, var11);
            break;
         case 8:
            var2 = class_600.method_3410(var1, var11);
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_421(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: i (int) com.google.android.gms.internal.cf[]
   public class_421[] method_2552(int var1) {
      return new class_421[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2552(var1);
   }
}
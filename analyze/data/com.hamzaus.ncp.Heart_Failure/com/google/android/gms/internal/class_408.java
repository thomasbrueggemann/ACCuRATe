package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_407;
import com.google.android.gms.internal.cr;

// $FF: renamed from: com.google.android.gms.internal.cq
public class class_408 implements Creator<cr> {
   // $FF: renamed from: a (com.google.android.gms.internal.cr, android.os.Parcel, int) void
   static void method_2514(class_407 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3363(var1, 2, var0.method_2510(), false);
      class_599.method_3363(var1, 3, var0.method_2511(), false);
      class_599.method_3363(var1, 4, var0.method_2512(), false);
      class_599.method_3363(var1, 5, var0.method_2513(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2515(var1);
   }

   // $FF: renamed from: g (android.os.Parcel) com.google.android.gms.internal.cr
   public class_407 method_2515(Parcel var1) {
      IBinder var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var4 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var7 = class_600.method_3411(var1, var8);
            break;
         case 3:
            var6 = class_600.method_3411(var1, var8);
            break;
         case 4:
            var5 = class_600.method_3411(var1, var8);
            break;
         case 5:
            var2 = class_600.method_3411(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_407(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: k (int) com.google.android.gms.internal.cr[]
   public class_407[] method_2516(int var1) {
      return new class_407[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2516(var1);
   }
}

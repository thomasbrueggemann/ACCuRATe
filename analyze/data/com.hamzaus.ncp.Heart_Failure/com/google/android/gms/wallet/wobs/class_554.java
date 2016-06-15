package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.wobs.class_551;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.h
public class class_554 implements Creator<g> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.g, android.os.Parcel, int) void
   static void method_3137(class_551 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.akQ);
      class_599.method_3369(var1, 3, var0.akR, false);
      class_599.method_3359(var1, 4, var0.akS);
      class_599.method_3369(var1, 5, var0.akT, false);
      class_599.method_3361(var1, 6, var0.akU);
      class_599.method_3381(var1, 7, var0.akV);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cm (android.os.Parcel) com.google.android.gms.wallet.wobs.g
   public class_551 method_3138(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      double var5 = 0.0D;
      long var7 = 0L;
      int var9 = -1;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_600.method_3383(var1);
         switch(class_600.method_3394(var12)) {
         case 1:
            var11 = class_600.method_3402(var1, var12);
            break;
         case 2:
            var3 = class_600.method_3402(var1, var12);
            break;
         case 3:
            var10 = class_600.method_3410(var1, var12);
            break;
         case 4:
            var5 = class_600.method_3408(var1, var12);
            break;
         case 5:
            var2 = class_600.method_3410(var1, var12);
            break;
         case 6:
            var7 = class_600.method_3404(var1, var12);
            break;
         case 7:
            var9 = class_600.method_3402(var1, var12);
            break;
         default:
            class_600.method_3395(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_551(var11, var3, var10, var5, var2, var7, var9);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3138(var1);
   }

   // $FF: renamed from: dU (int) com.google.android.gms.wallet.wobs.g[]
   public class_551[] method_3139(int var1) {
      return new class_551[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3139(var1);
   }
}

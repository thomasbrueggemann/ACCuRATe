package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.wobs.class_560;
import com.google.android.gms.wallet.wobs.class_562;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.q
public class class_563 implements Creator<p> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.p, android.os.Parcel, int) void
   static void method_3154(class_562 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.akW, false);
      class_599.method_3369(var1, 3, var0.field_2975, false);
      class_599.method_3365(var1, 4, var0.ala, var2, false);
      class_599.method_3365(var1, 5, var0.alb, var2, false);
      class_599.method_3365(var1, 6, var0.alc, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cr (android.os.Parcel) com.google.android.gms.wallet.wobs.p
   public class_562 method_3155(Parcel var1) {
      class_560 var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      class_560 var5 = null;
      class_566 var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var4 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var8 = class_600.method_3410(var1, var9);
            break;
         case 3:
            var7 = class_600.method_3410(var1, var9);
            break;
         case 4:
            var6 = (class_566)class_600.method_3390(var1, var9, class_566.CREATOR);
            break;
         case 5:
            var5 = (class_560)class_600.method_3390(var1, var9, class_560.CREATOR);
            break;
         case 6:
            var2 = (class_560)class_600.method_3390(var1, var9, class_560.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_562(var4, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3155(var1);
   }

   // $FF: renamed from: dZ (int) com.google.android.gms.wallet.wobs.p[]
   public class_562[] method_3156(int var1) {
      return new class_562[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3156(var1);
   }
}

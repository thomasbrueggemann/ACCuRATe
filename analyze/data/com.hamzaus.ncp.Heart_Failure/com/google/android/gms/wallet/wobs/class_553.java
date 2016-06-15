package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.wobs.class_551;
import com.google.android.gms.wallet.wobs.class_552;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.i
public class class_553 implements Creator<f> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.f, android.os.Parcel, int) void
   static void method_3134(class_552 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.label, false);
      class_599.method_3365(var1, 3, var0.akP, var2, false);
      class_599.method_3369(var1, 4, var0.type, false);
      class_599.method_3365(var1, 5, var0.ajp, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cn (android.os.Parcel) com.google.android.gms.wallet.wobs.f
   public class_552 method_3135(Parcel var1) {
      class_566 var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;
      class_551 var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var4 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var7 = class_600.method_3410(var1, var8);
            break;
         case 3:
            var6 = (class_551)class_600.method_3390(var1, var8, class_551.CREATOR);
            break;
         case 4:
            var5 = class_600.method_3410(var1, var8);
            break;
         case 5:
            var2 = (class_566)class_600.method_3390(var1, var8, class_566.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_552(var4, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3135(var1);
   }

   // $FF: renamed from: dV (int) com.google.android.gms.wallet.wobs.f[]
   public class_552[] method_3136(int var1) {
      return new class_552[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3136(var1);
   }
}

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.wallet.wobs.class_556;
import com.google.android.gms.wallet.wobs.class_558;
import com.google.android.gms.wallet.wobs.d;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.e
public class class_557 implements Creator<d> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.d, android.os.Parcel, int) void
   static void method_3143(class_558 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.akM, false);
      class_599.method_3369(var1, 3, var0.akN, false);
      class_599.method_3380(var1, 4, var0.akO, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cl (android.os.Parcel) com.google.android.gms.wallet.wobs.d
   public class_558 method_3144(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      ArrayList var5 = class_291.method_1966();
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var4 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var6 = class_600.method_3410(var1, var7);
            break;
         case 3:
            var2 = class_600.method_3410(var1, var7);
            break;
         case 4:
            var5 = class_600.method_3397(var1, var7, class_556.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_558(var4, var6, var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3144(var1);
   }

   // $FF: renamed from: dT (int) com.google.android.gms.wallet.wobs.d[]
   public class_558[] method_3145(int var1) {
      return new class_558[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3145(var1);
   }
}

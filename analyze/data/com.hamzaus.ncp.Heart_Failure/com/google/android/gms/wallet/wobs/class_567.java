package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.m
public class class_567 implements Creator<l> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.l, android.os.Parcel, int) void
   static void method_3160(class_566 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.akX);
      class_599.method_3361(var1, 3, var0.akY);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cp (android.os.Parcel) com.google.android.gms.wallet.wobs.l
   public class_566 method_3161(Parcel var1) {
      long var2 = 0L;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      long var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var6 = class_600.method_3404(var1, var8);
            break;
         case 3:
            var2 = class_600.method_3404(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_566(var5, var6, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3161(var1);
   }

   // $FF: renamed from: dX (int) com.google.android.gms.wallet.wobs.l[]
   public class_566[] method_3162(int var1) {
      return new class_566[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3162(var1);
   }
}

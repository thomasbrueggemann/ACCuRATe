package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_716;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.e
public class class_717 implements Creator<d> {
   // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Parcel, int) void
   static void method_4081(class_716 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.aiL, var2, false);
      class_599.method_3365(var1, 3, var0.aiM, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bT (android.os.Parcel) com.google.android.gms.wallet.d
   public class_716 method_4082(Parcel var1) {
      OfferWalletObject var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      LoyaltyWalletObject var5;
      OfferWalletObject var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         LoyaltyWalletObject var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            LoyaltyWalletObject var10 = (LoyaltyWalletObject)class_600.method_3390(var1, var6, LoyaltyWalletObject.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (OfferWalletObject)class_600.method_3390(var1, var6, OfferWalletObject.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_600.method_3395(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_716(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4082(var1);
   }

   // $FF: renamed from: dz (int) com.google.android.gms.wallet.d[]
   public class_716[] method_4083(int var1) {
      return new class_716[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4083(var1);
   }
}

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_935;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.e
public class class_936 implements Creator<d> {
   // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Parcel, int) void
   static void method_5192(class_935 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.auJ, var2, false);
      class_704.method_4034(var1, 3, var0.auK, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5193(var1);
   }

   // $FF: renamed from: dM (android.os.Parcel) com.google.android.gms.wallet.d
   public class_935 method_5193(Parcel var1) {
      OfferWalletObject var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      LoyaltyWalletObject var5;
      OfferWalletObject var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         LoyaltyWalletObject var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            LoyaltyWalletObject var10 = (LoyaltyWalletObject)class_705.method_4061(var1, var6, LoyaltyWalletObject.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (OfferWalletObject)class_705.method_4061(var1, var6, OfferWalletObject.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_935(var4, var5, var2);
      }
   }

   // $FF: renamed from: fT (int) com.google.android.gms.wallet.d[]
   public class_935[] method_5194(int var1) {
      return new class_935[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5194(var1);
   }
}
package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.k
public class class_938 implements Creator<MaskedWallet> {
   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWallet, android.os.Parcel, int) void
   static void method_5198(MaskedWallet var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.auL, false);
      class_704.method_4038(var1, 3, var0.auM, false);
      class_704.method_4045(var1, 4, var0.auR, false);
      class_704.method_4038(var1, 5, var0.auO, false);
      class_704.method_4034(var1, 6, var0.auP, var2, false);
      class_704.method_4034(var1, 7, var0.auQ, var2, false);
      class_704.method_4044(var1, 8, var0.avw, var2, false);
      class_704.method_4044(var1, 9, var0.avx, var2, false);
      class_704.method_4034(var1, 10, var0.auS, var2, false);
      class_704.method_4034(var1, 11, var0.auT, var2, false);
      class_704.method_4044(var1, 12, var0.auU, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5199(var1);
   }

   // $FF: renamed from: dS (android.os.Parcel) com.google.android.gms.wallet.MaskedWallet
   public MaskedWallet method_5199(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String[] var6 = null;
      String var7 = null;
      Address var8 = null;
      Address var9 = null;
      LoyaltyWalletObject[] var10 = null;
      OfferWalletObject[] var11 = null;
      UserAddress var12 = null;
      UserAddress var13 = null;
      InstrumentInfo[] var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = class_705.method_4058(var1);
         switch(class_705.method_4065(var15)) {
         case 1:
            var3 = class_705.method_4073(var1, var15);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var15);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var15);
            break;
         case 4:
            var6 = class_705.method_4053(var1, var15);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var15);
            break;
         case 6:
            var8 = (Address)class_705.method_4061(var1, var15, Address.CREATOR);
            break;
         case 7:
            var9 = (Address)class_705.method_4061(var1, var15, Address.CREATOR);
            break;
         case 8:
            var10 = (LoyaltyWalletObject[])class_705.method_4067(var1, var15, LoyaltyWalletObject.CREATOR);
            break;
         case 9:
            var11 = (OfferWalletObject[])class_705.method_4067(var1, var15, OfferWalletObject.CREATOR);
            break;
         case 10:
            var12 = (UserAddress)class_705.method_4061(var1, var15, UserAddress.CREATOR);
            break;
         case 11:
            var13 = (UserAddress)class_705.method_4061(var1, var15, UserAddress.CREATOR);
            break;
         case 12:
            var14 = (InstrumentInfo[])class_705.method_4067(var1, var15, InstrumentInfo.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new MaskedWallet(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: renamed from: fZ (int) com.google.android.gms.wallet.MaskedWallet[]
   public MaskedWallet[] method_5200(int var1) {
      return new MaskedWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5200(var1);
   }
}

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.k
public class class_719 implements Creator<MaskedWallet> {
   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWallet, android.os.Parcel, int) void
   static void method_4087(MaskedWallet var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.aiN, false);
      class_599.method_3369(var1, 3, var0.aiO, false);
      class_599.method_3376(var1, 4, var0.aiT, false);
      class_599.method_3369(var1, 5, var0.aiQ, false);
      class_599.method_3365(var1, 6, var0.aiR, var2, false);
      class_599.method_3365(var1, 7, var0.aiS, var2, false);
      class_599.method_3375(var1, 8, var0.ajz, var2, false);
      class_599.method_3375(var1, 9, var0.ajA, var2, false);
      class_599.method_3365(var1, 10, var0.aiU, var2, false);
      class_599.method_3365(var1, 11, var0.aiV, var2, false);
      class_599.method_3375(var1, 12, var0.aiW, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bZ (android.os.Parcel) com.google.android.gms.wallet.MaskedWallet
   public MaskedWallet method_4088(Parcel var1) {
      int var2 = class_600.method_3385(var1);
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
         int var15 = class_600.method_3383(var1);
         switch(class_600.method_3394(var15)) {
         case 1:
            var3 = class_600.method_3402(var1, var15);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var15);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var15);
            break;
         case 4:
            var6 = class_600.method_3384(var1, var15);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var15);
            break;
         case 6:
            var8 = (Address)class_600.method_3390(var1, var15, Address.CREATOR);
            break;
         case 7:
            var9 = (Address)class_600.method_3390(var1, var15, Address.CREATOR);
            break;
         case 8:
            var10 = (LoyaltyWalletObject[])class_600.method_3396(var1, var15, LoyaltyWalletObject.CREATOR);
            break;
         case 9:
            var11 = (OfferWalletObject[])class_600.method_3396(var1, var15, OfferWalletObject.CREATOR);
            break;
         case 10:
            var12 = (UserAddress)class_600.method_3390(var1, var15, UserAddress.CREATOR);
            break;
         case 11:
            var13 = (UserAddress)class_600.method_3390(var1, var15, UserAddress.CREATOR);
            break;
         case 12:
            var14 = (InstrumentInfo[])class_600.method_3396(var1, var15, InstrumentInfo.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new MaskedWallet(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4088(var1);
   }

   // $FF: renamed from: dF (int) com.google.android.gms.wallet.MaskedWallet[]
   public MaskedWallet[] method_4089(int var1) {
      return new MaskedWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4089(var1);
   }
}

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;

// $FF: renamed from: com.google.android.gms.wallet.f
public class class_933 implements Creator<FullWallet> {
   // $FF: renamed from: a (com.google.android.gms.wallet.FullWallet, android.os.Parcel, int) void
   static void method_5186(FullWallet var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.auL, false);
      class_704.method_4038(var1, 3, var0.auM, false);
      class_704.method_4034(var1, 4, var0.auN, var2, false);
      class_704.method_4038(var1, 5, var0.auO, false);
      class_704.method_4034(var1, 6, var0.auP, var2, false);
      class_704.method_4034(var1, 7, var0.auQ, var2, false);
      class_704.method_4045(var1, 8, var0.auR, false);
      class_704.method_4034(var1, 9, var0.auS, var2, false);
      class_704.method_4034(var1, 10, var0.auT, var2, false);
      class_704.method_4044(var1, 11, var0.auU, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5187(var1);
   }

   // $FF: renamed from: dN (android.os.Parcel) com.google.android.gms.wallet.FullWallet
   public FullWallet method_5187(Parcel var1) {
      InstrumentInfo[] var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      UserAddress var5 = null;
      UserAddress var6 = null;
      String[] var7 = null;
      Address var8 = null;
      Address var9 = null;
      String var10 = null;
      ProxyCard var11 = null;
      String var12 = null;
      String var13 = null;

      while(var1.dataPosition() < var3) {
         int var14 = class_705.method_4058(var1);
         switch(class_705.method_4065(var14)) {
         case 1:
            var4 = class_705.method_4073(var1, var14);
            break;
         case 2:
            var13 = class_705.method_4081(var1, var14);
            break;
         case 3:
            var12 = class_705.method_4081(var1, var14);
            break;
         case 4:
            var11 = (ProxyCard)class_705.method_4061(var1, var14, ProxyCard.CREATOR);
            break;
         case 5:
            var10 = class_705.method_4081(var1, var14);
            break;
         case 6:
            var9 = (Address)class_705.method_4061(var1, var14, Address.CREATOR);
            break;
         case 7:
            var8 = (Address)class_705.method_4061(var1, var14, Address.CREATOR);
            break;
         case 8:
            var7 = class_705.method_4053(var1, var14);
            break;
         case 9:
            var6 = (UserAddress)class_705.method_4061(var1, var14, UserAddress.CREATOR);
            break;
         case 10:
            var5 = (UserAddress)class_705.method_4061(var1, var14, UserAddress.CREATOR);
            break;
         case 11:
            var2 = (InstrumentInfo[])class_705.method_4067(var1, var14, InstrumentInfo.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new FullWallet(var4, var13, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: fU (int) com.google.android.gms.wallet.FullWallet[]
   public FullWallet[] method_5188(int var1) {
      return new FullWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5188(var1);
   }
}

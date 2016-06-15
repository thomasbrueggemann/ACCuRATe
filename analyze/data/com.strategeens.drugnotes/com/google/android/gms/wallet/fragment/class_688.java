package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

// $FF: renamed from: com.google.android.gms.wallet.fragment.a
public class class_688 implements Creator<WalletFragmentInitParams> {
   // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentInitParams, android.os.Parcel, int) void
   static void method_3880(WalletFragmentInitParams var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4496);
      class_704.method_4038(var1, 2, var0.getAccountName(), false);
      class_704.method_4034(var1, 3, var0.getMaskedWalletRequest(), var2, false);
      class_704.method_4050(var1, 4, var0.getMaskedWalletRequestCode());
      class_704.method_4034(var1, 5, var0.getMaskedWallet(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3881(var1);
   }

   // $FF: renamed from: dZ (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentInitParams
   public WalletFragmentInitParams method_3881(Parcel var1) {
      MaskedWallet var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = -1;
      MaskedWalletRequest var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var7 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var6 = (MaskedWalletRequest)class_705.method_4061(var1, var8, MaskedWalletRequest.CREATOR);
            break;
         case 4:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 5:
            var2 = (MaskedWallet)class_705.method_4061(var1, var8, MaskedWallet.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new WalletFragmentInitParams(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: gh (int) com.google.android.gms.wallet.fragment.WalletFragmentInitParams[]
   public WalletFragmentInitParams[] method_3882(int var1) {
      return new WalletFragmentInitParams[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3882(var1);
   }
}

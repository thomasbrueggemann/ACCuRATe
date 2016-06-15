package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

// $FF: renamed from: com.google.android.gms.wallet.fragment.a
public class class_584 implements Creator<WalletFragmentInitParams> {
   // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentInitParams, android.os.Parcel, int) void
   static void method_3267(WalletFragmentInitParams var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4343);
      class_599.method_3369(var1, 2, var0.getAccountName(), false);
      class_599.method_3365(var1, 3, var0.getMaskedWalletRequest(), var2, false);
      class_599.method_3381(var1, 4, var0.getMaskedWalletRequestCode());
      class_599.method_3365(var1, 5, var0.getMaskedWallet(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cg (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentInitParams
   public WalletFragmentInitParams method_3268(Parcel var1) {
      MaskedWallet var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      int var5 = -1;
      MaskedWalletRequest var6 = null;
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
            var6 = (MaskedWalletRequest)class_600.method_3390(var1, var8, MaskedWalletRequest.CREATOR);
            break;
         case 4:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 5:
            var2 = (MaskedWallet)class_600.method_3390(var1, var8, MaskedWallet.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new WalletFragmentInitParams(var4, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3268(var1);
   }

   // $FF: renamed from: dN (int) com.google.android.gms.wallet.fragment.WalletFragmentInitParams[]
   public WalletFragmentInitParams[] method_3269(int var1) {
      return new WalletFragmentInitParams[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3269(var1);
   }
}

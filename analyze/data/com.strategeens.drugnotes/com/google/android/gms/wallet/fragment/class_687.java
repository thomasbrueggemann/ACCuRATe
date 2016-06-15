package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

// $FF: renamed from: com.google.android.gms.wallet.fragment.b
public class class_687 implements Creator<WalletFragmentOptions> {
   // $FF: renamed from: a (com.google.android.gms.wallet.fragment.WalletFragmentOptions, android.os.Parcel, int) void
   static void method_3877(WalletFragmentOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4388);
      class_704.method_4050(var1, 2, var0.getEnvironment());
      class_704.method_4050(var1, 3, var0.getTheme());
      class_704.method_4034(var1, 4, var0.getFragmentStyle(), var2, false);
      class_704.method_4050(var1, 5, var0.getMode());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3878(var1);
   }

   // $FF: renamed from: ea (android.os.Parcel) com.google.android.gms.wallet.fragment.WalletFragmentOptions
   public WalletFragmentOptions method_3878(Parcel var1) {
      int var2 = 1;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      WalletFragmentStyle var5 = null;
      int var6 = var2;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4073(var1, var8);
            break;
         case 3:
            var3 = class_705.method_4073(var1, var8);
            break;
         case 4:
            var5 = (WalletFragmentStyle)class_705.method_4061(var1, var8, WalletFragmentStyle.CREATOR);
            break;
         case 5:
            var2 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new WalletFragmentOptions(var7, var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: gi (int) com.google.android.gms.wallet.fragment.WalletFragmentOptions[]
   public WalletFragmentOptions[] method_3879(int var1) {
      return new WalletFragmentOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3879(var1);
   }
}

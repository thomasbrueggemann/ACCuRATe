package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.l
public class class_944 implements Creator<MaskedWalletRequest> {
   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Parcel, int) void
   static void method_5218(MaskedWalletRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.auM, false);
      class_704.method_4041(var1, 3, var0.avz);
      class_704.method_4041(var1, 4, var0.avA);
      class_704.method_4041(var1, 5, var0.avB);
      class_704.method_4038(var1, 6, var0.avC, false);
      class_704.method_4038(var1, 7, var0.auG, false);
      class_704.method_4038(var1, 8, var0.avD, false);
      class_704.method_4034(var1, 9, var0.auV, var2, false);
      class_704.method_4041(var1, 10, var0.avE);
      class_704.method_4041(var1, 11, var0.avF);
      class_704.method_4044(var1, 12, var0.avG, var2, false);
      class_704.method_4041(var1, 13, var0.avH);
      class_704.method_4041(var1, 14, var0.avI);
      class_704.method_4051(var1, 15, var0.avJ, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5219(var1);
   }

   // $FF: renamed from: dT (android.os.Parcel) com.google.android.gms.wallet.MaskedWalletRequest
   public MaskedWalletRequest method_5219(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      Cart var11 = null;
      boolean var12 = false;
      boolean var13 = false;
      CountrySpecification[] var14 = null;
      boolean var15 = true;
      boolean var16 = true;
      ArrayList var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = class_705.method_4058(var1);
         switch(class_705.method_4065(var18)) {
         case 1:
            var3 = class_705.method_4073(var1, var18);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var18);
            break;
         case 3:
            var5 = class_705.method_4069(var1, var18);
            break;
         case 4:
            var6 = class_705.method_4069(var1, var18);
            break;
         case 5:
            var7 = class_705.method_4069(var1, var18);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var18);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var18);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var18);
            break;
         case 9:
            var11 = (Cart)class_705.method_4061(var1, var18, Cart.CREATOR);
            break;
         case 10:
            var12 = class_705.method_4069(var1, var18);
            break;
         case 11:
            var13 = class_705.method_4069(var1, var18);
            break;
         case 12:
            var14 = (CountrySpecification[])class_705.method_4067(var1, var18, CountrySpecification.CREATOR);
            break;
         case 13:
            var15 = class_705.method_4069(var1, var18);
            break;
         case 14:
            var16 = class_705.method_4069(var1, var18);
            break;
         case 15:
            var17 = class_705.method_4068(var1, var18, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new MaskedWalletRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   // $FF: renamed from: ga (int) com.google.android.gms.wallet.MaskedWalletRequest[]
   public MaskedWalletRequest[] method_5220(int var1) {
      return new MaskedWalletRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5220(var1);
   }
}

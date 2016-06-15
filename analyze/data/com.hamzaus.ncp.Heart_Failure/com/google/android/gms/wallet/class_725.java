package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.l
public class class_725 implements Creator<MaskedWalletRequest> {
   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Parcel, int) void
   static void method_4107(MaskedWalletRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.aiO, false);
      class_599.method_3372(var1, 3, var0.ajC);
      class_599.method_3372(var1, 4, var0.ajD);
      class_599.method_3372(var1, 5, var0.ajE);
      class_599.method_3369(var1, 6, var0.ajF, false);
      class_599.method_3369(var1, 7, var0.aiI, false);
      class_599.method_3369(var1, 8, var0.ajG, false);
      class_599.method_3365(var1, 9, var0.aiX, var2, false);
      class_599.method_3372(var1, 10, var0.ajH);
      class_599.method_3372(var1, 11, var0.ajI);
      class_599.method_3375(var1, 12, var0.ajJ, var2, false);
      class_599.method_3372(var1, 13, var0.ajK);
      class_599.method_3372(var1, 14, var0.ajL);
      class_599.method_3380(var1, 15, var0.ajM, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ca (android.os.Parcel) com.google.android.gms.wallet.MaskedWalletRequest
   public MaskedWalletRequest method_4108(Parcel var1) {
      int var2 = class_600.method_3385(var1);
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
         int var18 = class_600.method_3383(var1);
         switch(class_600.method_3394(var18)) {
         case 1:
            var3 = class_600.method_3402(var1, var18);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var18);
            break;
         case 3:
            var5 = class_600.method_3398(var1, var18);
            break;
         case 4:
            var6 = class_600.method_3398(var1, var18);
            break;
         case 5:
            var7 = class_600.method_3398(var1, var18);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var18);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var18);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var18);
            break;
         case 9:
            var11 = (Cart)class_600.method_3390(var1, var18, Cart.CREATOR);
            break;
         case 10:
            var12 = class_600.method_3398(var1, var18);
            break;
         case 11:
            var13 = class_600.method_3398(var1, var18);
            break;
         case 12:
            var14 = (CountrySpecification[])class_600.method_3396(var1, var18, CountrySpecification.CREATOR);
            break;
         case 13:
            var15 = class_600.method_3398(var1, var18);
            break;
         case 14:
            var16 = class_600.method_3398(var1, var18);
            break;
         case 15:
            var17 = class_600.method_3397(var1, var18, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new MaskedWalletRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4108(var1);
   }

   // $FF: renamed from: dG (int) com.google.android.gms.wallet.MaskedWalletRequest[]
   public MaskedWalletRequest[] method_4109(int var1) {
      return new MaskedWalletRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4109(var1);
   }
}

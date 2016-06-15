package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;

// $FF: renamed from: com.google.android.gms.wallet.f
public class class_714 implements Creator<FullWallet> {
   // $FF: renamed from: a (com.google.android.gms.wallet.FullWallet, android.os.Parcel, int) void
   static void method_4075(FullWallet var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.aiN, false);
      class_599.method_3369(var1, 3, var0.aiO, false);
      class_599.method_3365(var1, 4, var0.aiP, var2, false);
      class_599.method_3369(var1, 5, var0.aiQ, false);
      class_599.method_3365(var1, 6, var0.aiR, var2, false);
      class_599.method_3365(var1, 7, var0.aiS, var2, false);
      class_599.method_3376(var1, 8, var0.aiT, false);
      class_599.method_3365(var1, 9, var0.aiU, var2, false);
      class_599.method_3365(var1, 10, var0.aiV, var2, false);
      class_599.method_3375(var1, 11, var0.aiW, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bU (android.os.Parcel) com.google.android.gms.wallet.FullWallet
   public FullWallet method_4076(Parcel var1) {
      InstrumentInfo[] var2 = null;
      int var3 = class_600.method_3385(var1);
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
         int var14 = class_600.method_3383(var1);
         switch(class_600.method_3394(var14)) {
         case 1:
            var4 = class_600.method_3402(var1, var14);
            break;
         case 2:
            var13 = class_600.method_3410(var1, var14);
            break;
         case 3:
            var12 = class_600.method_3410(var1, var14);
            break;
         case 4:
            var11 = (ProxyCard)class_600.method_3390(var1, var14, ProxyCard.CREATOR);
            break;
         case 5:
            var10 = class_600.method_3410(var1, var14);
            break;
         case 6:
            var9 = (Address)class_600.method_3390(var1, var14, Address.CREATOR);
            break;
         case 7:
            var8 = (Address)class_600.method_3390(var1, var14, Address.CREATOR);
            break;
         case 8:
            var7 = class_600.method_3384(var1, var14);
            break;
         case 9:
            var6 = (UserAddress)class_600.method_3390(var1, var14, UserAddress.CREATOR);
            break;
         case 10:
            var5 = (UserAddress)class_600.method_3390(var1, var14, UserAddress.CREATOR);
            break;
         case 11:
            var2 = (InstrumentInfo[])class_600.method_3396(var1, var14, InstrumentInfo.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new FullWallet(var4, var13, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4076(var1);
   }

   // $FF: renamed from: dA (int) com.google.android.gms.wallet.FullWallet[]
   public FullWallet[] method_4077(int var1) {
      return new FullWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4077(var1);
   }
}

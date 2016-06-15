package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.n
public class class_727 implements Creator<OfferWalletObject> {
   // $FF: renamed from: a (com.google.android.gms.wallet.OfferWalletObject, android.os.Parcel, int) void
   static void method_4113(OfferWalletObject var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.field_4295, false);
      class_599.method_3369(var1, 3, var0.ajQ, false);
      class_599.method_3365(var1, 4, var0.ajR, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cc (android.os.Parcel) com.google.android.gms.wallet.OfferWalletObject
   public OfferWalletObject method_4114(Parcel var1) {
      CommonWalletObject var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var4 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var6 = class_600.method_3410(var1, var7);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var7);
            break;
         case 4:
            var2 = (CommonWalletObject)class_600.method_3390(var1, var7, CommonWalletObject.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new OfferWalletObject(var4, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4114(var1);
   }

   // $FF: renamed from: dI (int) com.google.android.gms.wallet.OfferWalletObject[]
   public OfferWalletObject[] method_4115(int var1) {
      return new OfferWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4115(var1);
   }
}

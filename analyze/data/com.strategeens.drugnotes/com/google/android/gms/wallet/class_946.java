package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// $FF: renamed from: com.google.android.gms.wallet.n
public class class_946 implements Creator<OfferWalletObject> {
   // $FF: renamed from: a (com.google.android.gms.wallet.OfferWalletObject, android.os.Parcel, int) void
   static void method_5224(OfferWalletObject var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.field_4449, false);
      class_704.method_4038(var1, 3, var0.avN, false);
      class_704.method_4034(var1, 4, var0.avO, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5225(var1);
   }

   // $FF: renamed from: dV (android.os.Parcel) com.google.android.gms.wallet.OfferWalletObject
   public OfferWalletObject method_5225(Parcel var1) {
      CommonWalletObject var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var4 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var7);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var7);
            break;
         case 4:
            var2 = (CommonWalletObject)class_705.method_4061(var1, var7, CommonWalletObject.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new OfferWalletObject(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: gc (int) com.google.android.gms.wallet.OfferWalletObject[]
   public OfferWalletObject[] method_5226(int var1) {
      return new OfferWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5226(var1);
   }
}

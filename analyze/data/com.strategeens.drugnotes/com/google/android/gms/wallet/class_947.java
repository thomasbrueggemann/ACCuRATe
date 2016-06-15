package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.ProxyCard;

// $FF: renamed from: com.google.android.gms.wallet.o
public class class_947 implements Creator<ProxyCard> {
   // $FF: renamed from: a (com.google.android.gms.wallet.ProxyCard, android.os.Parcel, int) void
   static void method_5227(ProxyCard var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.avP, false);
      class_704.method_4038(var1, 3, var0.avQ, false);
      class_704.method_4050(var1, 4, var0.avR);
      class_704.method_4050(var1, 5, var0.avS);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5228(var1);
   }

   // $FF: renamed from: dW (android.os.Parcel) com.google.android.gms.wallet.ProxyCard
   public ProxyCard method_5228(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var2 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 5:
            var3 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new ProxyCard(var7, var6, var2, var5, var3);
      }
   }

   // $FF: renamed from: gd (int) com.google.android.gms.wallet.ProxyCard[]
   public ProxyCard[] method_5229(int var1) {
      return new ProxyCard[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5229(var1);
   }
}

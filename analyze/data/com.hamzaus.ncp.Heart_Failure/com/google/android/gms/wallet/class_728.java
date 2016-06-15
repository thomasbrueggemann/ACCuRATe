package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.ProxyCard;

// $FF: renamed from: com.google.android.gms.wallet.o
public class class_728 implements Creator<ProxyCard> {
   // $FF: renamed from: a (com.google.android.gms.wallet.ProxyCard, android.os.Parcel, int) void
   static void method_4116(ProxyCard var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.ajS, false);
      class_599.method_3369(var1, 3, var0.ajT, false);
      class_599.method_3381(var1, 4, var0.ajU);
      class_599.method_3381(var1, 5, var0.ajV);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cd (android.os.Parcel) com.google.android.gms.wallet.ProxyCard
   public ProxyCard method_4117(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var6 = class_600.method_3410(var1, var8);
            break;
         case 3:
            var2 = class_600.method_3410(var1, var8);
            break;
         case 4:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 5:
            var3 = class_600.method_3402(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new ProxyCard(var7, var6, var2, var5, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4117(var1);
   }

   // $FF: renamed from: dJ (int) com.google.android.gms.wallet.ProxyCard[]
   public ProxyCard[] method_4118(int var1) {
      return new ProxyCard[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4118(var1);
   }
}

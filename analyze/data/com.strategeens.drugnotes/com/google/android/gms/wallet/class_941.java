package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.LineItem;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.b
public class class_941 implements Creator<Cart> {
   // $FF: renamed from: a (com.google.android.gms.wallet.Cart, android.os.Parcel, int) void
   static void method_5208(Cart var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.auF, false);
      class_704.method_4038(var1, 3, var0.auG, false);
      class_704.method_4051(var1, 4, var0.auH, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5209(var1);
   }

   // $FF: renamed from: dK (android.os.Parcel) com.google.android.gms.wallet.Cart
   public Cart method_5209(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ArrayList var5 = new ArrayList();
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
            var2 = class_705.method_4081(var1, var7);
            break;
         case 4:
            var5 = class_705.method_4068(var1, var7, LineItem.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new Cart(var4, var6, var2, var5);
      }
   }

   // $FF: renamed from: fR (int) com.google.android.gms.wallet.Cart[]
   public Cart[] method_5210(int var1) {
      return new Cart[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5210(var1);
   }
}

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.LineItem;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.b
public class class_722 implements Creator<Cart> {
   // $FF: renamed from: a (com.google.android.gms.wallet.Cart, android.os.Parcel, int) void
   static void method_4097(Cart var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.aiH, false);
      class_599.method_3369(var1, 3, var0.aiI, false);
      class_599.method_3380(var1, 4, var0.aiJ, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bR (android.os.Parcel) com.google.android.gms.wallet.Cart
   public Cart method_4098(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      ArrayList var5 = new ArrayList();
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
            var2 = class_600.method_3410(var1, var7);
            break;
         case 4:
            var5 = class_600.method_3397(var1, var7, LineItem.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new Cart(var4, var6, var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4098(var1);
   }

   // $FF: renamed from: dx (int) com.google.android.gms.wallet.Cart[]
   public Cart[] method_4099(int var1) {
      return new Cart[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4099(var1);
   }
}

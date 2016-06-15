package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.wobs.class_552;
import com.google.android.gms.wallet.wobs.class_558;
import com.google.android.gms.wallet.wobs.class_560;
import com.google.android.gms.wallet.wobs.class_562;
import com.google.android.gms.wallet.wobs.class_564;
import com.google.android.gms.wallet.wobs.class_566;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.j
public class class_718 implements Creator<LoyaltyWalletObject> {
   // $FF: renamed from: a (com.google.android.gms.wallet.LoyaltyWalletObject, android.os.Parcel, int) void
   static void method_4084(LoyaltyWalletObject var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.field_2925, false);
      class_599.method_3369(var1, 3, var0.ajf, false);
      class_599.method_3369(var1, 4, var0.ajg, false);
      class_599.method_3369(var1, 5, var0.ajh, false);
      class_599.method_3369(var1, 6, var0.aji, false);
      class_599.method_3369(var1, 7, var0.ajj, false);
      class_599.method_3369(var1, 8, var0.ajk, false);
      class_599.method_3369(var1, 9, var0.ajl, false);
      class_599.method_3369(var1, 10, var0.ajm, false);
      class_599.method_3369(var1, 11, var0.ajn, false);
      class_599.method_3381(var1, 12, var0.state);
      class_599.method_3380(var1, 13, var0.ajo, false);
      class_599.method_3365(var1, 14, var0.ajp, var2, false);
      class_599.method_3380(var1, 15, var0.ajq, false);
      class_599.method_3369(var1, 17, var0.ajs, false);
      class_599.method_3369(var1, 16, var0.ajr, false);
      class_599.method_3372(var1, 19, var0.aju);
      class_599.method_3380(var1, 18, var0.ajt, false);
      class_599.method_3380(var1, 21, var0.ajw, false);
      class_599.method_3380(var1, 20, var0.ajv, false);
      class_599.method_3365(var1, 23, var0.ajy, var2, false);
      class_599.method_3380(var1, 22, var0.ajx, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bY (android.os.Parcel) com.google.android.gms.wallet.LoyaltyWalletObject
   public LoyaltyWalletObject method_4085(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      String var13 = null;
      int var14 = 0;
      ArrayList var15 = class_291.method_1966();
      class_566 var16 = null;
      ArrayList var17 = class_291.method_1966();
      String var18 = null;
      String var19 = null;
      ArrayList var20 = class_291.method_1966();
      boolean var21 = false;
      ArrayList var22 = class_291.method_1966();
      ArrayList var23 = class_291.method_1966();
      ArrayList var24 = class_291.method_1966();
      class_552 var25 = null;

      while(var1.dataPosition() < var2) {
         int var26 = class_600.method_3383(var1);
         switch(class_600.method_3394(var26)) {
         case 1:
            var3 = class_600.method_3402(var1, var26);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var26);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var26);
            break;
         case 4:
            var6 = class_600.method_3410(var1, var26);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var26);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var26);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var26);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var26);
            break;
         case 9:
            var11 = class_600.method_3410(var1, var26);
            break;
         case 10:
            var12 = class_600.method_3410(var1, var26);
            break;
         case 11:
            var13 = class_600.method_3410(var1, var26);
            break;
         case 12:
            var14 = class_600.method_3402(var1, var26);
            break;
         case 13:
            var15 = class_600.method_3397(var1, var26, class_562.CREATOR);
            break;
         case 14:
            var16 = (class_566)class_600.method_3390(var1, var26, class_566.CREATOR);
            break;
         case 15:
            var17 = class_600.method_3397(var1, var26, LatLng.CREATOR);
            break;
         case 16:
            var18 = class_600.method_3410(var1, var26);
            break;
         case 17:
            var19 = class_600.method_3410(var1, var26);
            break;
         case 18:
            var20 = class_600.method_3397(var1, var26, class_558.CREATOR);
            break;
         case 19:
            var21 = class_600.method_3398(var1, var26);
            break;
         case 20:
            var22 = class_600.method_3397(var1, var26, class_560.CREATOR);
            break;
         case 21:
            var23 = class_600.method_3397(var1, var26, class_564.CREATOR);
            break;
         case 22:
            var24 = class_600.method_3397(var1, var26, class_560.CREATOR);
            break;
         case 23:
            var25 = (class_552)class_600.method_3390(var1, var26, class_552.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var26);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new LoyaltyWalletObject(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4085(var1);
   }

   // $FF: renamed from: dE (int) com.google.android.gms.wallet.LoyaltyWalletObject[]
   public LoyaltyWalletObject[] method_4086(int var1) {
      return new LoyaltyWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4086(var1);
   }
}

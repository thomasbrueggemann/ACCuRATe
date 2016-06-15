package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_724;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.class_660;
import com.google.android.gms.wallet.wobs.class_662;
import com.google.android.gms.wallet.wobs.class_664;
import com.google.android.gms.wallet.wobs.class_666;
import com.google.android.gms.wallet.wobs.class_668;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.a
public class class_661 implements Creator<CommonWalletObject> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.CommonWalletObject, android.os.Parcel, int) void
   static void method_3781(CommonWalletObject var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.field_4431, false);
      class_704.method_4038(var1, 3, var0.avk, false);
      class_704.method_4038(var1, 4, var0.name, false);
      class_704.method_4038(var1, 5, var0.ave, false);
      class_704.method_4038(var1, 6, var0.avg, false);
      class_704.method_4038(var1, 7, var0.avh, false);
      class_704.method_4038(var1, 8, var0.avi, false);
      class_704.method_4038(var1, 9, var0.avj, false);
      class_704.method_4050(var1, 10, var0.state);
      class_704.method_4051(var1, 11, var0.avl, false);
      class_704.method_4034(var1, 12, var0.avm, var2, false);
      class_704.method_4051(var1, 13, var0.avn, false);
      class_704.method_4038(var1, 14, var0.avo, false);
      class_704.method_4038(var1, 15, var0.avp, false);
      class_704.method_4041(var1, 17, var0.avr);
      class_704.method_4051(var1, 16, var0.avq, false);
      class_704.method_4051(var1, 19, var0.avt, false);
      class_704.method_4051(var1, 18, var0.avs, false);
      class_704.method_4051(var1, 20, var0.avu, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3782(var1);
   }

   // $FF: renamed from: ec (android.os.Parcel) com.google.android.gms.wallet.wobs.CommonWalletObject
   public CommonWalletObject method_3782(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      int var12 = 0;
      ArrayList var13 = class_724.method_4217();
      class_668 var14 = null;
      ArrayList var15 = class_724.method_4217();
      String var16 = null;
      String var17 = null;
      ArrayList var18 = class_724.method_4217();
      boolean var19 = false;
      ArrayList var20 = class_724.method_4217();
      ArrayList var21 = class_724.method_4217();
      ArrayList var22 = class_724.method_4217();

      while(var1.dataPosition() < var2) {
         int var23 = class_705.method_4058(var1);
         switch(class_705.method_4065(var23)) {
         case 1:
            var3 = class_705.method_4073(var1, var23);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var23);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var23);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var23);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var23);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var23);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var23);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var23);
            break;
         case 9:
            var11 = class_705.method_4081(var1, var23);
            break;
         case 10:
            var12 = class_705.method_4073(var1, var23);
            break;
         case 11:
            var13 = class_705.method_4068(var1, var23, class_664.CREATOR);
            break;
         case 12:
            var14 = (class_668)class_705.method_4061(var1, var23, class_668.CREATOR);
            break;
         case 13:
            var15 = class_705.method_4068(var1, var23, LatLng.CREATOR);
            break;
         case 14:
            var16 = class_705.method_4081(var1, var23);
            break;
         case 15:
            var17 = class_705.method_4081(var1, var23);
            break;
         case 16:
            var18 = class_705.method_4068(var1, var23, class_660.CREATOR);
            break;
         case 17:
            var19 = class_705.method_4069(var1, var23);
            break;
         case 18:
            var20 = class_705.method_4068(var1, var23, class_662.CREATOR);
            break;
         case 19:
            var21 = class_705.method_4068(var1, var23, class_666.CREATOR);
            break;
         case 20:
            var22 = class_705.method_4068(var1, var23, class_662.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var23);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new CommonWalletObject(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22);
      }
   }

   // $FF: renamed from: gl (int) com.google.android.gms.wallet.wobs.CommonWalletObject[]
   public CommonWalletObject[] method_3783(int var1) {
      return new CommonWalletObject[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3783(var1);
   }
}

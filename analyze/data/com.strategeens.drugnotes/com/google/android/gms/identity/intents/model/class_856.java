package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.identity.intents.model.UserAddress;

// $FF: renamed from: com.google.android.gms.identity.intents.model.b
public class class_856 implements Creator<UserAddress> {
   // $FF: renamed from: a (com.google.android.gms.identity.intents.model.UserAddress, android.os.Parcel, int) void
   static void method_4768(UserAddress var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.name, false);
      class_704.method_4038(var1, 3, var0.afK, false);
      class_704.method_4038(var1, 4, var0.afL, false);
      class_704.method_4038(var1, 5, var0.afM, false);
      class_704.method_4038(var1, 6, var0.afN, false);
      class_704.method_4038(var1, 7, var0.afO, false);
      class_704.method_4038(var1, 8, var0.afP, false);
      class_704.method_4038(var1, 9, var0.afQ, false);
      class_704.method_4038(var1, 10, var0.field_3776, false);
      class_704.method_4038(var1, 11, var0.afR, false);
      class_704.method_4038(var1, 12, var0.afS, false);
      class_704.method_4038(var1, 13, var0.afT, false);
      class_704.method_4041(var1, 14, var0.afU);
      class_704.method_4038(var1, 15, var0.afV, false);
      class_704.method_4038(var1, 16, var0.afW, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cH (android.os.Parcel) com.google.android.gms.identity.intents.model.UserAddress
   public UserAddress method_4769(Parcel var1) {
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
      String var12 = null;
      String var13 = null;
      String var14 = null;
      String var15 = null;
      boolean var16 = false;
      String var17 = null;
      String var18 = null;

      while(var1.dataPosition() < var2) {
         int var19 = class_705.method_4058(var1);
         switch(class_705.method_4065(var19)) {
         case 1:
            var3 = class_705.method_4073(var1, var19);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var19);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var19);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var19);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var19);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var19);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var19);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var19);
            break;
         case 9:
            var11 = class_705.method_4081(var1, var19);
            break;
         case 10:
            var12 = class_705.method_4081(var1, var19);
            break;
         case 11:
            var13 = class_705.method_4081(var1, var19);
            break;
         case 12:
            var14 = class_705.method_4081(var1, var19);
            break;
         case 13:
            var15 = class_705.method_4081(var1, var19);
            break;
         case 14:
            var16 = class_705.method_4069(var1, var19);
            break;
         case 15:
            var17 = class_705.method_4081(var1, var19);
            break;
         case 16:
            var18 = class_705.method_4081(var1, var19);
            break;
         default:
            class_705.method_4066(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new UserAddress(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4769(var1);
   }

   // $FF: renamed from: eu (int) com.google.android.gms.identity.intents.model.UserAddress[]
   public UserAddress[] method_4770(int var1) {
      return new UserAddress[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4770(var1);
   }
}

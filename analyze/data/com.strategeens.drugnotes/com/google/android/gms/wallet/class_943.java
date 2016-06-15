package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.Address;

// $FF: renamed from: com.google.android.gms.wallet.a
public class class_943 implements Creator<Address> {
   // $FF: renamed from: a (com.google.android.gms.wallet.Address, android.os.Parcel, int) void
   static void method_5215(Address var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.name, false);
      class_704.method_4038(var1, 3, var0.afK, false);
      class_704.method_4038(var1, 4, var0.afL, false);
      class_704.method_4038(var1, 5, var0.afM, false);
      class_704.method_4038(var1, 6, var0.field_3189, false);
      class_704.method_4038(var1, 7, var0.auD, false);
      class_704.method_4038(var1, 8, var0.auE, false);
      class_704.method_4038(var1, 9, var0.afR, false);
      class_704.method_4038(var1, 10, var0.afT, false);
      class_704.method_4041(var1, 11, var0.afU);
      class_704.method_4038(var1, 12, var0.afV, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5216(var1);
   }

   // $FF: renamed from: dJ (android.os.Parcel) com.google.android.gms.wallet.Address
   public Address method_5216(Parcel var1) {
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
      boolean var13 = false;
      String var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = class_705.method_4058(var1);
         switch(class_705.method_4065(var15)) {
         case 1:
            var3 = class_705.method_4073(var1, var15);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var15);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var15);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var15);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var15);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var15);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var15);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var15);
            break;
         case 9:
            var11 = class_705.method_4081(var1, var15);
            break;
         case 10:
            var12 = class_705.method_4081(var1, var15);
            break;
         case 11:
            var13 = class_705.method_4069(var1, var15);
            break;
         case 12:
            var14 = class_705.method_4081(var1, var15);
            break;
         default:
            class_705.method_4066(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new Address(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: renamed from: fQ (int) com.google.android.gms.wallet.Address[]
   public Address[] method_5217(int var1) {
      return new Address[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5217(var1);
   }
}

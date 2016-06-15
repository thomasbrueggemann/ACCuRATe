package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.class_404;
import com.google.android.gms.internal.hd;

// $FF: renamed from: com.google.android.gms.internal.he
public class class_403 implements Creator<hd> {
   // $FF: renamed from: a (com.google.android.gms.internal.hd, android.os.Parcel, int) void
   static void method_2708(class_404 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4044(var1, 1, var0.field_1259, var2, false);
      class_704.method_4050(var1, 1000, var0.field_1258);
      class_704.method_4038(var1, 2, var0.field_1260, false);
      class_704.method_4041(var1, 3, var0.field_1261);
      class_704.method_4034(var1, 4, var0.account, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: J (int) com.google.android.gms.internal.hd[]
   public class_404[] method_2709(int var1) {
      return new class_404[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2710(var1);
   }

   // $FF: renamed from: l (android.os.Parcel) com.google.android.gms.internal.hd
   public class_404 method_2710(Parcel var1) {
      boolean var2 = false;
      Account var3 = null;
      int var4 = class_705.method_4059(var1);
      String var5 = null;
      class_394[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var6 = (class_394[])class_705.method_4067(var1, var8, class_394.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var2 = class_705.method_4069(var1, var8);
            break;
         case 4:
            var3 = (Account)class_705.method_4061(var1, var8, Account.CREATOR);
            break;
         case 1000:
            var7 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_404(var7, var6, var5, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2709(var1);
   }
}

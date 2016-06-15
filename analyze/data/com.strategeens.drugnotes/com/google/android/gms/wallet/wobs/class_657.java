package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_658;

// $FF: renamed from: com.google.android.gms.wallet.wobs.c
public class class_657 implements Creator<b> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.b, android.os.Parcel, int) void
   static void method_3768(class_658 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.label, false);
      class_704.method_4038(var1, 3, var0.value, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3769(var1);
   }

   // $FF: renamed from: ed (android.os.Parcel) com.google.android.gms.wallet.wobs.b
   public class_658 method_3769(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var6);
            break;
         case 3:
            var2 = class_705.method_4081(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_658(var4, var5, var2);
      }
   }

   // $FF: renamed from: gm (int) com.google.android.gms.wallet.wobs.b[]
   public class_658[] method_3770(int var1) {
      return new class_658[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3770(var1);
   }
}

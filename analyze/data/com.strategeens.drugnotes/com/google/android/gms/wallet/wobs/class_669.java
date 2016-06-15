package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.m
public class class_669 implements Creator<l> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.l, android.os.Parcel, int) void
   static void method_3795(class_668 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.awU);
      class_704.method_4030(var1, 3, var0.awV);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3796(var1);
   }

   // $FF: renamed from: ei (android.os.Parcel) com.google.android.gms.wallet.wobs.l
   public class_668 method_3796(Parcel var1) {
      long var2 = 0L;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      long var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4075(var1, var8);
            break;
         case 3:
            var2 = class_705.method_4075(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_668(var5, var6, var2);
      }
   }

   // $FF: renamed from: gr (int) com.google.android.gms.wallet.wobs.l[]
   public class_668[] method_3797(int var1) {
      return new class_668[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3797(var1);
   }
}

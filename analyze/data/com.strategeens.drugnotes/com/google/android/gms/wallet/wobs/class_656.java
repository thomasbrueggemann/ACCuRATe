package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.wobs.class_653;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.h
public class class_656 implements Creator<g> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.g, android.os.Parcel, int) void
   static void method_3765(class_653 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.awN);
      class_704.method_4038(var1, 3, var0.awO, false);
      class_704.method_4028(var1, 4, var0.awP);
      class_704.method_4038(var1, 5, var0.awQ, false);
      class_704.method_4030(var1, 6, var0.awR);
      class_704.method_4050(var1, 7, var0.awS);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3766(var1);
   }

   // $FF: renamed from: ef (android.os.Parcel) com.google.android.gms.wallet.wobs.g
   public class_653 method_3766(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      double var5 = 0.0D;
      long var7 = 0L;
      int var9 = -1;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4073(var1, var12);
            break;
         case 2:
            var3 = class_705.method_4073(var1, var12);
            break;
         case 3:
            var10 = class_705.method_4081(var1, var12);
            break;
         case 4:
            var5 = class_705.method_4079(var1, var12);
            break;
         case 5:
            var2 = class_705.method_4081(var1, var12);
            break;
         case 6:
            var7 = class_705.method_4075(var1, var12);
            break;
         case 7:
            var9 = class_705.method_4073(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_653(var11, var3, var10, var5, var2, var7, var9);
      }
   }

   // $FF: renamed from: go (int) com.google.android.gms.wallet.wobs.g[]
   public class_653[] method_3767(int var1) {
      return new class_653[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3767(var1);
   }
}

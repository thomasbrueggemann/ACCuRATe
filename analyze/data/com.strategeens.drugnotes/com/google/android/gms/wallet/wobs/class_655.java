package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.wobs.class_653;
import com.google.android.gms.wallet.wobs.class_654;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.i
public class class_655 implements Creator<f> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.f, android.os.Parcel, int) void
   static void method_3762(class_654 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.label, false);
      class_704.method_4034(var1, 3, var0.awM, var2, false);
      class_704.method_4038(var1, 4, var0.type, false);
      class_704.method_4034(var1, 5, var0.avm, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3763(var1);
   }

   // $FF: renamed from: eg (android.os.Parcel) com.google.android.gms.wallet.wobs.f
   public class_654 method_3763(Parcel var1) {
      class_668 var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      class_653 var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var7 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var6 = (class_653)class_705.method_4061(var1, var8, class_653.CREATOR);
            break;
         case 4:
            var5 = class_705.method_4081(var1, var8);
            break;
         case 5:
            var2 = (class_668)class_705.method_4061(var1, var8, class_668.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_654(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: gp (int) com.google.android.gms.wallet.wobs.f[]
   public class_654[] method_3764(int var1) {
      return new class_654[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3764(var1);
   }
}

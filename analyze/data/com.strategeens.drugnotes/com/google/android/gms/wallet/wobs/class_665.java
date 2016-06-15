package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wallet.wobs.class_662;
import com.google.android.gms.wallet.wobs.class_664;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.q
public class class_665 implements Creator<p> {
   // $FF: renamed from: a (com.google.android.gms.wallet.wobs.p, android.os.Parcel, int) void
   static void method_3789(class_664 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.awT, false);
      class_704.method_4038(var1, 3, var0.field_2879, false);
      class_704.method_4034(var1, 4, var0.awX, var2, false);
      class_704.method_4034(var1, 5, var0.awY, var2, false);
      class_704.method_4034(var1, 6, var0.awZ, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3790(var1);
   }

   // $FF: renamed from: ek (android.os.Parcel) com.google.android.gms.wallet.wobs.p
   public class_664 method_3790(Parcel var1) {
      class_662 var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      class_662 var5 = null;
      class_668 var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var4 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var8 = class_705.method_4081(var1, var9);
            break;
         case 3:
            var7 = class_705.method_4081(var1, var9);
            break;
         case 4:
            var6 = (class_668)class_705.method_4061(var1, var9, class_668.CREATOR);
            break;
         case 5:
            var5 = (class_662)class_705.method_4061(var1, var9, class_662.CREATOR);
            break;
         case 6:
            var2 = (class_662)class_705.method_4061(var1, var9, class_662.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_664(var4, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: gt (int) com.google.android.gms.wallet.wobs.p[]
   public class_664[] method_3791(int var1) {
      return new class_664[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3791(var1);
   }
}

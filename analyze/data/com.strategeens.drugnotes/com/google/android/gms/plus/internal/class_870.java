package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.plus.internal.PlusCommonExtras;

// $FF: renamed from: com.google.android.gms.plus.internal.f
public class class_870 implements Creator<PlusCommonExtras> {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.PlusCommonExtras, android.os.Parcel, int) void
   static void method_4881(PlusCommonExtras var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.method_3036(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.method_3037(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4882(var1);
   }

   // $FF: renamed from: dv (android.os.Parcel) com.google.android.gms.plus.internal.PlusCommonExtras
   public PlusCommonExtras method_4882(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4081(var1, var6);
            break;
         case 2:
            var2 = class_705.method_4081(var1, var6);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new PlusCommonExtras(var4, var5, var2);
      }
   }

   // $FF: renamed from: ft (int) com.google.android.gms.plus.internal.PlusCommonExtras[]
   public PlusCommonExtras[] method_4883(int var1) {
      return new PlusCommonExtras[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4883(var1);
   }
}

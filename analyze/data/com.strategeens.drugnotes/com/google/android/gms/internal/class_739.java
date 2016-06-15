package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_738;
import com.google.android.gms.internal.ko;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.kp
public class class_739 implements Creator<ko> {
   // $FF: renamed from: a (com.google.android.gms.internal.ko, android.os.Parcel, int) void
   static void method_4288(class_738 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.method_4287(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: K (android.os.Parcel) com.google.android.gms.internal.ko
   public class_738 method_4289(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4068(var1, var5, class_738.class_1325.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_738(var3, var4);
      }
   }

   // $FF: renamed from: aL (int) com.google.android.gms.internal.ko[]
   public class_738[] method_4290(int var1) {
      return new class_738[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4289(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4290(var1);
   }
}

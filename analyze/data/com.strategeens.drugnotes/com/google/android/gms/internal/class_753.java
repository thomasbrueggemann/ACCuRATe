package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_747;
import com.google.android.gms.internal.class_751;
import com.google.android.gms.internal.class_763;
import com.google.android.gms.internal.nu;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.nv
public class class_753 implements Creator<nu> {
   // $FF: renamed from: a (com.google.android.gms.internal.nu, android.os.Parcel, int) void
   static void method_4330(class_763 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.ahn, false);
      class_704.method_4050(var1, 1000, var0.field_3424);
      class_704.method_4038(var1, 2, var0.method_4365(), false);
      class_704.method_4041(var1, 3, var0.method_4366());
      class_704.method_4051(var1, 4, var0.aht, false);
      class_704.method_4049(var1, 6, var0.ahu, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cQ (android.os.Parcel) com.google.android.gms.internal.nu
   public class_763 method_4331(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = null;
      String var6 = null;
      ArrayList var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var7 = class_705.method_4068(var1, var9, class_747.CREATOR);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var9);
            break;
         case 3:
            var2 = class_705.method_4069(var1, var9);
            break;
         case 4:
            var5 = class_705.method_4068(var1, var9, class_751.CREATOR);
            break;
         case 6:
            var3 = class_705.method_4055(var1, var9);
            break;
         case 1000:
            var8 = class_705.method_4073(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_763(var8, var7, var6, var2, var5, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4331(var1);
   }

   // $FF: renamed from: eM (int) com.google.android.gms.internal.nu[]
   public class_763[] method_4332(int var1) {
      return new class_763[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4332(var1);
   }
}

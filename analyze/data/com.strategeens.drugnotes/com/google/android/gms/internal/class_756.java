package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_754;
import com.google.android.gms.internal.class_763;
import com.google.android.gms.internal.ny;

// $FF: renamed from: com.google.android.gms.internal.nz
public class class_756 implements Creator<ny> {
   // $FF: renamed from: a (com.google.android.gms.internal.ny, android.os.Parcel, int) void
   static void method_4337(class_754 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1000, var0.field_3415);
      class_704.method_4034(var1, 2, var0.method_4333(), var2, false);
      class_704.method_4030(var1, 3, var0.getInterval());
      class_704.method_4050(var1, 4, var0.getPriority());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cS (android.os.Parcel) com.google.android.gms.internal.ny
   public class_754 method_4338(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      class_763 var4 = null;
      long var5 = class_754.ahz;
      int var7 = 102;

      while(var1.dataPosition() < var2) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 2:
            var4 = (class_763)class_705.method_4061(var1, var8, class_763.CREATOR);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var8);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_754(var3, var4, var5, var7);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4338(var1);
   }

   // $FF: renamed from: eO (int) com.google.android.gms.internal.ny[]
   public class_754[] method_4339(int var1) {
      return new class_754[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4339(var1);
   }
}

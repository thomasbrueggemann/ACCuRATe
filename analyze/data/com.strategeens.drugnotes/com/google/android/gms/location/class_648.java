package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.location.class_650;
import com.google.android.gms.location.e;

// $FF: renamed from: com.google.android.gms.location.f
public class class_648 implements Creator<e> {
   // $FF: renamed from: a (com.google.android.gms.location.e, android.os.Parcel, int) void
   static void method_3715(class_650 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.agw);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.agx);
      class_704.method_4030(var1, 3, var0.agy);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cK (android.os.Parcel) com.google.android.gms.location.e
   public class_650 method_3716(Parcel var1) {
      int var2 = 1;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      long var5 = 0L;
      int var7 = var2;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var2 = class_705.method_4073(var1, var8);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var8);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_650(var4, var7, var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3716(var1);
   }

   // $FF: renamed from: eE (int) com.google.android.gms.location.e[]
   public class_650[] method_3717(int var1) {
      return new class_650[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3717(var1);
   }
}

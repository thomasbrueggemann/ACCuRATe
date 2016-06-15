package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_392;
import com.google.android.gms.internal.hp;

// $FF: renamed from: com.google.android.gms.internal.hq
public class class_389 implements Creator<hp> {
   // $FF: renamed from: a (com.google.android.gms.internal.hp, android.os.Parcel, int) void
   static void method_2667(class_388 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.name, false);
      class_704.method_4050(var1, 1000, var0.field_1210);
      class_704.method_4038(var1, 2, var0.field_1211, false);
      class_704.method_4041(var1, 3, var0.field_1212);
      class_704.method_4050(var1, 4, var0.weight);
      class_704.method_4041(var1, 5, var0.field_1213);
      class_704.method_4038(var1, 6, var0.field_1214, false);
      class_704.method_4044(var1, 7, var0.field_1215, var2, false);
      class_704.method_4043(var1, 8, var0.field_1216, false);
      class_704.method_4038(var1, 11, var0.field_1217, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: R (int) com.google.android.gms.internal.hp[]
   public class_388[] method_2668(int var1) {
      return new class_388[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2669(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2668(var1);
   }

   // $FF: renamed from: r (android.os.Parcel) com.google.android.gms.internal.hp
   public class_388 method_2669(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      int var5 = 1;
      int[] var6 = null;
      class_392[] var7 = null;
      String var8 = null;
      boolean var9 = false;
      String var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var11 = class_705.method_4081(var1, var13);
            break;
         case 2:
            var10 = class_705.method_4081(var1, var13);
            break;
         case 3:
            var9 = class_705.method_4069(var1, var13);
            break;
         case 4:
            var5 = class_705.method_4073(var1, var13);
            break;
         case 5:
            var2 = class_705.method_4069(var1, var13);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var13);
            break;
         case 7:
            var7 = (class_392[])class_705.method_4067(var1, var13, class_392.CREATOR);
            break;
         case 8:
            var6 = class_705.method_4087(var1, var13);
            break;
         case 11:
            var3 = class_705.method_4081(var1, var13);
            break;
         case 1000:
            var12 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_388(var12, var11, var10, var9, var5, var2, var8, var7, var6, var3);
      }
   }
}

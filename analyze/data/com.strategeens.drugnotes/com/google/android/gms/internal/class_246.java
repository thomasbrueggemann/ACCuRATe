package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_245;

// $FF: renamed from: com.google.android.gms.internal.bk
public class class_246 implements Creator<bj> {
   // $FF: renamed from: a (com.google.android.gms.internal.bj, android.os.Parcel, int) void
   static void method_1616(class_245 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4050(var1, 2, var0.field_491);
      class_704.method_4050(var1, 3, var0.backgroundColor);
      class_704.method_4050(var1, 4, var0.field_492);
      class_704.method_4050(var1, 5, var0.field_493);
      class_704.method_4050(var1, 6, var0.field_494);
      class_704.method_4050(var1, 7, var0.field_495);
      class_704.method_4050(var1, 8, var0.field_496);
      class_704.method_4050(var1, 9, var0.field_497);
      class_704.method_4038(var1, 10, var0.field_498, false);
      class_704.method_4050(var1, 11, var0.field_499);
      class_704.method_4038(var1, 12, var0.field_500, false);
      class_704.method_4050(var1, 13, var0.field_501);
      class_704.method_4050(var1, 14, var0.field_502);
      class_704.method_4038(var1, 15, var0.field_503, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1617(var1);
   }

   // $FF: renamed from: d (android.os.Parcel) com.google.android.gms.internal.bj
   public class_245 method_1617(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      int var15 = 0;
      int var16 = 0;
      String var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = class_705.method_4058(var1);
         switch(class_705.method_4065(var18)) {
         case 1:
            var3 = class_705.method_4073(var1, var18);
            break;
         case 2:
            var4 = class_705.method_4073(var1, var18);
            break;
         case 3:
            var5 = class_705.method_4073(var1, var18);
            break;
         case 4:
            var6 = class_705.method_4073(var1, var18);
            break;
         case 5:
            var7 = class_705.method_4073(var1, var18);
            break;
         case 6:
            var8 = class_705.method_4073(var1, var18);
            break;
         case 7:
            var9 = class_705.method_4073(var1, var18);
            break;
         case 8:
            var10 = class_705.method_4073(var1, var18);
            break;
         case 9:
            var11 = class_705.method_4073(var1, var18);
            break;
         case 10:
            var12 = class_705.method_4081(var1, var18);
            break;
         case 11:
            var13 = class_705.method_4073(var1, var18);
            break;
         case 12:
            var14 = class_705.method_4081(var1, var18);
            break;
         case 13:
            var15 = class_705.method_4073(var1, var18);
            break;
         case 14:
            var16 = class_705.method_4073(var1, var18);
            break;
         case 15:
            var17 = class_705.method_4081(var1, var18);
            break;
         default:
            class_705.method_4066(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_245(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   // $FF: renamed from: i (int) com.google.android.gms.internal.bj[]
   public class_245[] method_1618(int var1) {
      return new class_245[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1618(var1);
   }
}

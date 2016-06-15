package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.fj;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.fk
public class class_439 implements Creator<fj> {
   // $FF: renamed from: a (com.google.android.gms.internal.fj, android.os.Parcel, int) void
   static void method_2879(class_438 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4038(var1, 2, var0.field_1443, false);
      class_704.method_4038(var1, 3, var0.field_1445, false);
      class_704.method_4049(var1, 4, var0.field_1441, false);
      class_704.method_4050(var1, 5, var0.errorCode);
      class_704.method_4049(var1, 6, var0.field_1442, false);
      class_704.method_4030(var1, 7, var0.field_1446);
      class_704.method_4041(var1, 8, var0.field_1447);
      class_704.method_4030(var1, 9, var0.field_1448);
      class_704.method_4049(var1, 10, var0.field_1449, false);
      class_704.method_4030(var1, 11, var0.field_1440);
      class_704.method_4050(var1, 12, var0.orientation);
      class_704.method_4038(var1, 13, var0.field_1450, false);
      class_704.method_4030(var1, 14, var0.field_1451);
      class_704.method_4038(var1, 15, var0.field_1452, false);
      class_704.method_4038(var1, 19, var0.field_1454, false);
      class_704.method_4041(var1, 18, var0.field_1453);
      class_704.method_4038(var1, 21, var0.field_1455, false);
      class_704.method_4041(var1, 23, var0.field_1457);
      class_704.method_4041(var1, 22, var0.field_1456);
      class_704.method_4041(var1, 25, var0.field_1458);
      class_704.method_4041(var1, 24, var0.field_1444);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2880(var1);
   }

   // $FF: renamed from: i (android.os.Parcel) com.google.android.gms.internal.fj
   public class_438 method_2880(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ArrayList var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      long var9 = 0L;
      boolean var11 = false;
      long var12 = 0L;
      ArrayList var14 = null;
      long var15 = 0L;
      int var17 = 0;
      String var18 = null;
      long var19 = 0L;
      String var21 = null;
      boolean var22 = false;
      String var23 = null;
      String var24 = null;
      boolean var25 = false;
      boolean var26 = false;
      boolean var27 = false;
      boolean var28 = false;

      while(var1.dataPosition() < var2) {
         int var29 = class_705.method_4058(var1);
         switch(class_705.method_4065(var29)) {
         case 1:
            var3 = class_705.method_4073(var1, var29);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var29);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var29);
            break;
         case 4:
            var6 = class_705.method_4055(var1, var29);
            break;
         case 5:
            var7 = class_705.method_4073(var1, var29);
            break;
         case 6:
            var8 = class_705.method_4055(var1, var29);
            break;
         case 7:
            var9 = class_705.method_4075(var1, var29);
            break;
         case 8:
            var11 = class_705.method_4069(var1, var29);
            break;
         case 9:
            var12 = class_705.method_4075(var1, var29);
            break;
         case 10:
            var14 = class_705.method_4055(var1, var29);
            break;
         case 11:
            var15 = class_705.method_4075(var1, var29);
            break;
         case 12:
            var17 = class_705.method_4073(var1, var29);
            break;
         case 13:
            var18 = class_705.method_4081(var1, var29);
            break;
         case 14:
            var19 = class_705.method_4075(var1, var29);
            break;
         case 15:
            var21 = class_705.method_4081(var1, var29);
            break;
         case 16:
         case 17:
         case 20:
         default:
            class_705.method_4066(var1, var29);
            break;
         case 18:
            var22 = class_705.method_4069(var1, var29);
            break;
         case 19:
            var23 = class_705.method_4081(var1, var29);
            break;
         case 21:
            var24 = class_705.method_4081(var1, var29);
            break;
         case 22:
            var25 = class_705.method_4069(var1, var29);
            break;
         case 23:
            var26 = class_705.method_4069(var1, var29);
            break;
         case 24:
            var27 = class_705.method_4069(var1, var29);
            break;
         case 25:
            var28 = class_705.method_4069(var1, var29);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_438(var3, var4, var5, var6, var7, var8, var9, var11, var12, var14, var15, var17, var18, var19, var21, var22, var23, var24, var25, var26, var27, var28);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2881(var1);
   }

   // $FF: renamed from: r (int) com.google.android.gms.internal.fj[]
   public class_438[] method_2881(int var1) {
      return new class_438[var1];
   }
}

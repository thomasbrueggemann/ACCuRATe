package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_245;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.aw
public class class_209 implements Creator<av> {
   // $FF: renamed from: a (com.google.android.gms.internal.av, android.os.Parcel, int) void
   static void method_1505(class_218 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4030(var1, 2, var0.field_357);
      class_704.method_4031(var1, 3, var0.extras, false);
      class_704.method_4050(var1, 4, var0.field_358);
      class_704.method_4049(var1, 5, var0.field_359, false);
      class_704.method_4041(var1, 6, var0.field_360);
      class_704.method_4050(var1, 7, var0.field_361);
      class_704.method_4041(var1, 8, var0.field_362);
      class_704.method_4038(var1, 9, var0.field_363, false);
      class_704.method_4034(var1, 10, var0.field_364, var2, false);
      class_704.method_4034(var1, 11, var0.field_365, var2, false);
      class_704.method_4038(var1, 12, var0.field_366, false);
      class_704.method_4031(var1, 13, var0.field_367, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: b (android.os.Parcel) com.google.android.gms.internal.av
   public class_218 method_1506(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      long var4 = 0L;
      Bundle var6 = null;
      int var7 = 0;
      ArrayList var8 = null;
      boolean var9 = false;
      int var10 = 0;
      boolean var11 = false;
      String var12 = null;
      class_245 var13 = null;
      Location var14 = null;
      String var15 = null;
      Bundle var16 = null;

      while(var1.dataPosition() < var2) {
         int var17 = class_705.method_4058(var1);
         switch(class_705.method_4065(var17)) {
         case 1:
            var3 = class_705.method_4073(var1, var17);
            break;
         case 2:
            var4 = class_705.method_4075(var1, var17);
            break;
         case 3:
            var6 = class_705.method_4083(var1, var17);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var17);
            break;
         case 5:
            var8 = class_705.method_4055(var1, var17);
            break;
         case 6:
            var9 = class_705.method_4069(var1, var17);
            break;
         case 7:
            var10 = class_705.method_4073(var1, var17);
            break;
         case 8:
            var11 = class_705.method_4069(var1, var17);
            break;
         case 9:
            var12 = class_705.method_4081(var1, var17);
            break;
         case 10:
            var13 = (class_245)class_705.method_4061(var1, var17, class_245.CREATOR);
            break;
         case 11:
            var14 = (Location)class_705.method_4061(var1, var17, Location.CREATOR);
            break;
         case 12:
            var15 = class_705.method_4081(var1, var17);
            break;
         case 13:
            var16 = class_705.method_4083(var1, var17);
            break;
         default:
            class_705.method_4066(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_218(var3, var4, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1506(var1);
   }

   // $FF: renamed from: f (int) com.google.android.gms.internal.av[]
   public class_218[] method_1507(int var1) {
      return new class_218[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1507(var1);
   }
}

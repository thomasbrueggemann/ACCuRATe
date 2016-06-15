package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_462;
import com.google.android.gms.internal.class_531;
import com.google.android.gms.internal.dr;

// $FF: renamed from: com.google.android.gms.internal.dq
public class class_463 implements Creator<dr> {
   // $FF: renamed from: a (com.google.android.gms.internal.dr, android.os.Parcel, int) void
   static void method_2944(class_462 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4034(var1, 2, var0.field_1557, var2, false);
      class_704.method_4032(var1, 3, var0.method_2938(), false);
      class_704.method_4032(var1, 4, var0.method_2939(), false);
      class_704.method_4032(var1, 5, var0.method_2940(), false);
      class_704.method_4032(var1, 6, var0.method_2941(), false);
      class_704.method_4038(var1, 7, var0.field_1562, false);
      class_704.method_4041(var1, 8, var0.field_1563);
      class_704.method_4038(var1, 9, var0.field_1564, false);
      class_704.method_4032(var1, 10, var0.method_2943(), false);
      class_704.method_4050(var1, 11, var0.orientation);
      class_704.method_4050(var1, 12, var0.field_1566);
      class_704.method_4038(var1, 13, var0.field_1556, false);
      class_704.method_4034(var1, 14, var0.field_1555, var2, false);
      class_704.method_4032(var1, 15, var0.method_2942(), false);
      class_704.method_4034(var1, 17, var0.field_1569, var2, false);
      class_704.method_4038(var1, 16, var0.field_1568, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2945(var1);
   }

   // $FF: renamed from: f (android.os.Parcel) com.google.android.gms.internal.dr
   public class_462 method_2945(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      class_458 var4 = null;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;
      IBinder var8 = null;
      String var9 = null;
      boolean var10 = false;
      String var11 = null;
      IBinder var12 = null;
      int var13 = 0;
      int var14 = 0;
      String var15 = null;
      class_369 var16 = null;
      IBinder var17 = null;
      String var18 = null;
      class_531 var19 = null;

      while(var1.dataPosition() < var2) {
         int var20 = class_705.method_4058(var1);
         switch(class_705.method_4065(var20)) {
         case 1:
            var3 = class_705.method_4073(var1, var20);
            break;
         case 2:
            var4 = (class_458)class_705.method_4061(var1, var20, class_458.CREATOR);
            break;
         case 3:
            var5 = class_705.method_4082(var1, var20);
            break;
         case 4:
            var6 = class_705.method_4082(var1, var20);
            break;
         case 5:
            var7 = class_705.method_4082(var1, var20);
            break;
         case 6:
            var8 = class_705.method_4082(var1, var20);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var20);
            break;
         case 8:
            var10 = class_705.method_4069(var1, var20);
            break;
         case 9:
            var11 = class_705.method_4081(var1, var20);
            break;
         case 10:
            var12 = class_705.method_4082(var1, var20);
            break;
         case 11:
            var13 = class_705.method_4073(var1, var20);
            break;
         case 12:
            var14 = class_705.method_4073(var1, var20);
            break;
         case 13:
            var15 = class_705.method_4081(var1, var20);
            break;
         case 14:
            var16 = (class_369)class_705.method_4061(var1, var20, class_369.CREATOR);
            break;
         case 15:
            var17 = class_705.method_4082(var1, var20);
            break;
         case 16:
            var18 = class_705.method_4081(var1, var20);
            break;
         case 17:
            var19 = (class_531)class_705.method_4061(var1, var20, class_531.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var20);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_462(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
      }
   }

   // $FF: renamed from: n (int) com.google.android.gms.internal.dr[]
   public class_462[] method_2946(int var1) {
      return new class_462[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2946(var1);
   }
}

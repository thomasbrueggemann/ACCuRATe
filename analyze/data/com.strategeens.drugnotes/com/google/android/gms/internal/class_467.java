package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.ea;

// $FF: renamed from: com.google.android.gms.internal.dz
public class class_467 implements Creator<ea> {
   // $FF: renamed from: a (com.google.android.gms.internal.ea, android.os.Parcel, int) void
   static void method_2972(class_411 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4032(var1, 3, var0.method_2729(), false);
      class_704.method_4032(var1, 4, var0.method_2730(), false);
      class_704.method_4032(var1, 5, var0.method_2731(), false);
      class_704.method_4032(var1, 6, var0.method_2728(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2973(var1);
   }

   // $FF: renamed from: g (android.os.Parcel) com.google.android.gms.internal.ea
   public class_411 method_2973(Parcel var1) {
      IBinder var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
         default:
            class_705.method_4066(var1, var8);
            break;
         case 3:
            var7 = class_705.method_4082(var1, var8);
            break;
         case 4:
            var6 = class_705.method_4082(var1, var8);
            break;
         case 5:
            var5 = class_705.method_4082(var1, var8);
            break;
         case 6:
            var2 = class_705.method_4082(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_411(var4, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2974(var1);
   }

   // $FF: renamed from: o (int) com.google.android.gms.internal.ea[]
   public class_411[] method_2974(int var1) {
      return new class_411[var1];
   }
}

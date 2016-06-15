package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.n
public class class_1043 implements Creator<RawDataPoint> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataPoint, android.os.Parcel, int) void
   static void method_5738(RawDataPoint var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4030(var1, 1, var0.field_4205);
      class_704.method_4050(var1, 1000, var0.field_4202);
      class_704.method_4030(var1, 2, var0.field_4206);
      class_704.method_4044(var1, 3, var0.field_4207, var2, false);
      class_704.method_4050(var1, 4, var0.field_4203);
      class_704.method_4050(var1, 5, var0.field_4204);
      class_704.method_4030(var1, 6, var0.field_4208);
      class_704.method_4030(var1, 7, var0.field_4209);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bA (android.os.Parcel) com.google.android.gms.fitness.data.RawDataPoint
   public RawDataPoint method_5739(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      long var4 = 0L;
      long var6 = 0L;
      Value[] var8 = null;
      int var9 = 0;
      int var10 = 0;
      long var11 = 0L;
      long var13 = 0L;

      while(var1.dataPosition() < var2) {
         int var15 = class_705.method_4058(var1);
         switch(class_705.method_4065(var15)) {
         case 1:
            var4 = class_705.method_4075(var1, var15);
            break;
         case 2:
            var6 = class_705.method_4075(var1, var15);
            break;
         case 3:
            var8 = (Value[])class_705.method_4067(var1, var15, Value.CREATOR);
            break;
         case 4:
            var9 = class_705.method_4073(var1, var15);
            break;
         case 5:
            var10 = class_705.method_4073(var1, var15);
            break;
         case 6:
            var11 = class_705.method_4075(var1, var15);
            break;
         case 7:
            var13 = class_705.method_4075(var1, var15);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var15);
            break;
         default:
            class_705.method_4066(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new RawDataPoint(var3, var4, var6, var8, var9, var10, var11, var13);
      }
   }

   // $FF: renamed from: cT (int) com.google.android.gms.fitness.data.RawDataPoint[]
   public RawDataPoint[] method_5740(int var1) {
      return new RawDataPoint[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5739(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5740(var1);
   }
}

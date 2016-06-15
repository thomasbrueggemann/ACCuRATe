package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.o
public class class_1042 implements Creator<RawDataSet> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataSet, android.os.Parcel, int) void
   static void method_5735(RawDataSet var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2821);
      class_704.method_4050(var1, 1000, var0.field_2820);
      class_704.method_4050(var1, 2, var0.field_2822);
      class_704.method_4051(var1, 3, var0.field_2823, false);
      class_704.method_4041(var1, 4, var0.field_2824);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bB (android.os.Parcel) com.google.android.gms.fitness.data.RawDataSet
   public RawDataSet method_5736(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      ArrayList var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var6 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 3:
            var4 = class_705.method_4068(var1, var8, RawDataPoint.CREATOR);
            break;
         case 4:
            var2 = class_705.method_4069(var1, var8);
            break;
         case 1000:
            var7 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new RawDataSet(var7, var6, var5, var4, var2);
      }
   }

   // $FF: renamed from: cU (int) com.google.android.gms.fitness.data.RawDataSet[]
   public RawDataSet[] method_5737(int var1) {
      return new RawDataSet[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5736(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5737(var1);
   }
}

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.u
public class class_1052 implements Creator<Value> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.Value, android.os.Parcel, int) void
   static void method_5776(Value var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getFormat());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4041(var1, 2, var0.isSet());
      class_704.method_4029(var1, 3, var0.method_3267());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bF (android.os.Parcel) com.google.android.gms.fitness.data.Value
   public Value method_5777(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      float var4 = 0.0F;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var2 = class_705.method_4069(var1, var7);
            break;
         case 3:
            var4 = class_705.method_4078(var1, var7);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new Value(var6, var5, var2, var4);
      }
   }

   // $FF: renamed from: cZ (int) com.google.android.gms.fitness.data.Value[]
   public Value[] method_5778(int var1) {
      return new Value[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5777(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5778(var1);
   }
}

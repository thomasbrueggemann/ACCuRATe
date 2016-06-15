package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.b
public class class_926 implements Creator<DataReadResult> {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult, android.os.Parcel, int) void
   static void method_5143(DataReadResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4052(var1, 1, var0.method_3985(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getStatus(), var2, false);
      class_704.method_4052(var1, 3, var0.method_3984(), false);
      class_704.method_4050(var1, 5, var0.method_3983());
      class_704.method_4051(var1, 6, var0.method_3982(), false);
      class_704.method_4051(var1, 7, var0.method_3986(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ce (android.os.Parcel) com.google.android.gms.fitness.result.DataReadResult
   public DataReadResult method_5144(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = null;
      Status var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            class_705.method_4064(var1, var10, var5, this.getClass().getClassLoader());
            break;
         case 2:
            var8 = (Status)class_705.method_4061(var1, var10, Status.CREATOR);
            break;
         case 3:
            class_705.method_4064(var1, var10, var6, this.getClass().getClassLoader());
            break;
         case 5:
            var2 = class_705.method_4073(var1, var10);
            break;
         case 6:
            var7 = class_705.method_4068(var1, var10, DataSource.CREATOR);
            break;
         case 7:
            var3 = class_705.method_4068(var1, var10, DataType.CREATOR);
            break;
         case 1000:
            var9 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new DataReadResult(var9, var5, var8, var6, var2, var7, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5144(var1);
   }

   // $FF: renamed from: dz (int) com.google.android.gms.fitness.result.DataReadResult[]
   public DataReadResult[] method_5145(int var1) {
      return new DataReadResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5145(var1);
   }
}

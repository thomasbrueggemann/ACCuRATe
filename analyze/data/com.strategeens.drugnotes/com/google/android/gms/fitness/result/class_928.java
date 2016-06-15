package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataTypeResult;

// $FF: renamed from: com.google.android.gms.fitness.result.d
public class class_928 implements Creator<DataTypeResult> {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.DataTypeResult, android.os.Parcel, int) void
   static void method_5149(DataTypeResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getStatus(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 3, var0.getDataType(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cg (android.os.Parcel) com.google.android.gms.fitness.result.DataTypeResult
   public DataTypeResult method_5150(Parcel var1) {
      DataType var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      Status var5;
      DataType var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         Status var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            Status var12 = (Status)class_705.method_4061(var1, var6, Status.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 3:
            var7 = (DataType)class_705.method_4061(var1, var6, DataType.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new DataTypeResult(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5150(var1);
   }

   // $FF: renamed from: dB (int) com.google.android.gms.fitness.result.DataTypeResult[]
   public DataTypeResult[] method_5151(int var1) {
      return new DataTypeResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5151(var1);
   }
}

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_483;

// $FF: renamed from: com.google.android.gms.fitness.request.ak
public class class_484 implements Creator<aj> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, android.os.Parcel, int) void
   static void method_3079(class_483 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataType(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getDataSource(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cc (android.os.Parcel) com.google.android.gms.fitness.request.aj
   public class_483 method_3080(Parcel var1) {
      DataSource var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      DataType var5;
      DataSource var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         DataType var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            DataType var12 = (DataType)class_705.method_4061(var1, var6, DataType.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = (DataSource)class_705.method_4061(var1, var6, DataSource.CREATOR);
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
         return new class_483(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3080(var1);
   }

   // $FF: renamed from: dx (int) com.google.android.gms.fitness.request.aj[]
   public class_483[] method_3081(int var1) {
      return new class_483[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3081(var1);
   }
}

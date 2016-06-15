package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.h
public class class_505 implements Creator<DataSourcesRequest> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, android.os.Parcel, int) void
   static void method_3177(DataSourcesRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getDataTypes(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4039(var1, 2, var0.method_4816(), false);
      class_704.method_4041(var1, 3, var0.method_4815());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bM (android.os.Parcel) com.google.android.gms.fitness.request.DataSourcesRequest
   public DataSourcesRequest method_3178(Parcel var1) {
      ArrayList var2 = null;
      boolean var3 = false;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var5 = class_705.method_4068(var1, var7, DataType.CREATOR);
            break;
         case 2:
            var2 = class_705.method_4054(var1, var7);
            break;
         case 3:
            var3 = class_705.method_4069(var1, var7);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSourcesRequest(var6, var5, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3178(var1);
   }

   // $FF: renamed from: dg (int) com.google.android.gms.fitness.request.DataSourcesRequest[]
   public DataSourcesRequest[] method_3179(int var1) {
      return new DataSourcesRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3179(var1);
   }
}

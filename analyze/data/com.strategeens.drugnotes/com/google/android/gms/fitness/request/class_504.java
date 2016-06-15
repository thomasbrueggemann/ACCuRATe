package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.g
public class class_504 implements Creator<DataReadRequest> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, android.os.Parcel, int) void
   static void method_3174(DataReadRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getDataTypes(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.getDataSources(), false);
      class_704.method_4030(var1, 3, var0.method_5128());
      class_704.method_4030(var1, 4, var0.method_5129());
      class_704.method_4051(var1, 5, var0.getAggregatedDataTypes(), false);
      class_704.method_4051(var1, 6, var0.getAggregatedDataSources(), false);
      class_704.method_4050(var1, 7, var0.getBucketType());
      class_704.method_4030(var1, 8, var0.method_5127());
      class_704.method_4034(var1, 9, var0.getActivityDataSource(), var2, false);
      class_704.method_4050(var1, 10, var0.getLimit());
      class_704.method_4041(var1, 12, var0.method_5126());
      class_704.method_4041(var1, 13, var0.method_5125());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bL (android.os.Parcel) com.google.android.gms.fitness.request.DataReadRequest
   public DataReadRequest method_3175(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      ArrayList var4 = null;
      ArrayList var5 = null;
      long var6 = 0L;
      long var8 = 0L;
      ArrayList var10 = null;
      ArrayList var11 = null;
      int var12 = 0;
      long var13 = 0L;
      DataSource var15 = null;
      int var16 = 0;
      boolean var17 = false;
      boolean var18 = false;

      while(var1.dataPosition() < var2) {
         int var19 = class_705.method_4058(var1);
         switch(class_705.method_4065(var19)) {
         case 1:
            var4 = class_705.method_4068(var1, var19, DataType.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4068(var1, var19, DataSource.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4075(var1, var19);
            break;
         case 4:
            var8 = class_705.method_4075(var1, var19);
            break;
         case 5:
            var10 = class_705.method_4068(var1, var19, DataType.CREATOR);
            break;
         case 6:
            var11 = class_705.method_4068(var1, var19, DataSource.CREATOR);
            break;
         case 7:
            var12 = class_705.method_4073(var1, var19);
            break;
         case 8:
            var13 = class_705.method_4075(var1, var19);
            break;
         case 9:
            var15 = (DataSource)class_705.method_4061(var1, var19, DataSource.CREATOR);
            break;
         case 10:
            var16 = class_705.method_4073(var1, var19);
            break;
         case 12:
            var17 = class_705.method_4069(var1, var19);
            break;
         case 13:
            var18 = class_705.method_4069(var1, var19);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var19);
            break;
         default:
            class_705.method_4066(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new DataReadRequest(var3, var4, var5, var6, var8, var10, var11, var12, var13, var15, var16, var17, var18);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3175(var1);
   }

   // $FF: renamed from: df (int) com.google.android.gms.fitness.request.DataReadRequest[]
   public DataReadRequest[] method_3176(int var1) {
      return new DataReadRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3176(var1);
   }
}

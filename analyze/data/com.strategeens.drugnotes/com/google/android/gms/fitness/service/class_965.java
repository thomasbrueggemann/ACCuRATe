package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

// $FF: renamed from: com.google.android.gms.fitness.service.a
public class class_965 implements Creator<FitnessSensorServiceRequest> {
   // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, android.os.Parcel, int) void
   static void method_5385(FitnessSensorServiceRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4032(var1, 2, var0.method_5093(), false);
      class_704.method_4030(var1, 3, var0.method_5092());
      class_704.method_4030(var1, 4, var0.method_5094());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ck (android.os.Parcel) com.google.android.gms.fitness.service.FitnessSensorServiceRequest
   public FitnessSensorServiceRequest method_5386(Parcel var1) {
      long var2 = 0L;
      IBinder var4 = null;
      int var5 = class_705.method_4059(var1);
      int var6 = 0;
      long var7 = var2;
      DataSource var9 = null;

      while(var1.dataPosition() < var5) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = (DataSource)class_705.method_4061(var1, var10, DataSource.CREATOR);
            break;
         case 2:
            var4 = class_705.method_4082(var1, var10);
            break;
         case 3:
            var7 = class_705.method_4075(var1, var10);
            break;
         case 4:
            var2 = class_705.method_4075(var1, var10);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_705.class_1425("Overread allowed size end=" + var5, var1);
      } else {
         return new FitnessSensorServiceRequest(var6, var9, var4, var7, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5386(var1);
   }

   // $FF: renamed from: dF (int) com.google.android.gms.fitness.service.FitnessSensorServiceRequest[]
   public FitnessSensorServiceRequest[] method_5387(int var1) {
      return new FitnessSensorServiceRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5387(var1);
   }
}

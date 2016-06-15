package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.ac
public class class_493 implements Creator<StartBleScanRequest> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.StartBleScanRequest, android.os.Parcel, int) void
   static void method_3110(StartBleScanRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getDataTypes(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4032(var1, 2, var0.method_3044(), false);
      class_704.method_4050(var1, 3, var0.getTimeoutSecs());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bY (android.os.Parcel) com.google.android.gms.fitness.request.StartBleScanRequest
   public StartBleScanRequest method_3111(Parcel var1) {
      IBinder var2 = null;
      int var3 = 0;
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
            var2 = class_705.method_4082(var1, var7);
            break;
         case 3:
            var3 = class_705.method_4073(var1, var7);
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
         return new StartBleScanRequest(var6, var5, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3111(var1);
   }

   // $FF: renamed from: dt (int) com.google.android.gms.fitness.request.StartBleScanRequest[]
   public StartBleScanRequest[] method_3112(int var1) {
      return new StartBleScanRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3112(var1);
   }
}

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.result.BleDevicesResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.a
public class class_927 implements Creator<BleDevicesResult> {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult, android.os.Parcel, int) void
   static void method_5146(BleDevicesResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getClaimedBleDevices(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getStatus(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cd (android.os.Parcel) com.google.android.gms.fitness.result.BleDevicesResult
   public BleDevicesResult method_5147(Parcel var1) {
      Status var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4068(var1, var6, BleDevice.CREATOR);
            break;
         case 2:
            var2 = (Status)class_705.method_4061(var1, var6, Status.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new BleDevicesResult(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5147(var1);
   }

   // $FF: renamed from: dy (int) com.google.android.gms.fitness.result.BleDevicesResult[]
   public BleDevicesResult[] method_5148(int var1) {
      return new BleDevicesResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5148(var1);
   }
}

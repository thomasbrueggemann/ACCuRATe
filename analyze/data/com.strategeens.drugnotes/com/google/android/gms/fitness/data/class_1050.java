package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.c
public class class_1050 implements Creator<BleDevice> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.BleDevice, android.os.Parcel, int) void
   static void method_5758(BleDevice var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getAddress(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getName(), false);
      class_704.method_4049(var1, 3, var0.getSupportedProfiles(), false);
      class_704.method_4051(var1, 4, var0.getDataTypes(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: br (android.os.Parcel) com.google.android.gms.fitness.data.BleDevice
   public BleDevice method_5759(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ArrayList var5 = null;
      String var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4081(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var5 = class_705.method_4055(var1, var8);
            break;
         case 4:
            var2 = class_705.method_4068(var1, var8, DataType.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new BleDevice(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: cI (int) com.google.android.gms.fitness.data.BleDevice[]
   public BleDevice[] method_5760(int var1) {
      return new BleDevice[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5759(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5760(var1);
   }
}

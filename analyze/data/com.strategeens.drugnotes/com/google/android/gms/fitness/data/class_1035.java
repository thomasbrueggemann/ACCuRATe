package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.class_1051;

// $FF: renamed from: com.google.android.gms.fitness.data.g
public class class_1035 implements Creator<DataSource> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSource, android.os.Parcel, int) void
   static void method_5714(DataSource var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataType(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getName(), false);
      class_704.method_4050(var1, 3, var0.getType());
      class_704.method_4034(var1, 4, var0.getDevice(), var2, false);
      class_704.method_4034(var1, 5, var0.method_3133(), var2, false);
      class_704.method_4038(var1, 6, var0.getStreamName(), false);
      class_704.method_4041(var1, 7, var0.method_3134());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bv (android.os.Parcel) com.google.android.gms.fitness.data.DataSource
   public DataSource method_5715(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      class_1051 var5 = null;
      Device var6 = null;
      int var7 = 0;
      String var8 = null;
      DataType var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var9 = (DataType)class_705.method_4061(var1, var11, DataType.CREATOR);
            break;
         case 2:
            var8 = class_705.method_4081(var1, var11);
            break;
         case 3:
            var7 = class_705.method_4073(var1, var11);
            break;
         case 4:
            var6 = (Device)class_705.method_4061(var1, var11, Device.CREATOR);
            break;
         case 5:
            var5 = (class_1051)class_705.method_4061(var1, var11, class_1051.CREATOR);
            break;
         case 6:
            var3 = class_705.method_4081(var1, var11);
            break;
         case 7:
            var2 = class_705.method_4069(var1, var11);
            break;
         case 1000:
            var10 = class_705.method_4073(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSource(var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }

   // $FF: renamed from: cO (int) com.google.android.gms.fitness.data.DataSource[]
   public DataSource[] method_5716(int var1) {
      return new DataSource[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5715(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5716(var1);
   }
}

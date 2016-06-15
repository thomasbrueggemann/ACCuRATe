package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.data.f
public class class_1036 implements Creator<DataSet> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSet, android.os.Parcel, int) void
   static void method_5717(DataSet var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getDataType(), var2, false);
      class_704.method_4052(var1, 3, var0.method_5137(), false);
      class_704.method_4051(var1, 4, var0.method_5138(), false);
      class_704.method_4041(var1, 5, var0.method_5136());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bu (android.os.Parcel) com.google.android.gms.fitness.data.DataSet
   public DataSet method_5718(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = new ArrayList();
      DataType var6 = null;
      DataSource var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var7 = (DataSource)class_705.method_4061(var1, var9, DataSource.CREATOR);
            break;
         case 2:
            var6 = (DataType)class_705.method_4061(var1, var9, DataType.CREATOR);
            break;
         case 3:
            class_705.method_4064(var1, var9, var5, this.getClass().getClassLoader());
            break;
         case 4:
            var3 = class_705.method_4068(var1, var9, DataSource.CREATOR);
            break;
         case 5:
            var2 = class_705.method_4069(var1, var9);
            break;
         case 1000:
            var8 = class_705.method_4073(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSet(var8, var7, var6, var5, var3, var2);
      }
   }

   // $FF: renamed from: cN (int) com.google.android.gms.fitness.data.DataSet[]
   public DataSet[] method_5719(int var1) {
      return new DataSet[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5718(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5719(var1);
   }
}

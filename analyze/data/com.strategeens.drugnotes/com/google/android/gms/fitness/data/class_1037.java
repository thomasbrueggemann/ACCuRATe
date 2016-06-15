package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;

// $FF: renamed from: com.google.android.gms.fitness.data.e
public class class_1037 implements Creator<DataPoint> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataPoint, android.os.Parcel, int) void
   static void method_5720(DataPoint var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 3, var0.getTimestampNanos());
      class_704.method_4030(var1, 4, var0.method_4298());
      class_704.method_4044(var1, 5, var0.method_4295(), var2, false);
      class_704.method_4034(var1, 6, var0.getOriginalDataSource(), var2, false);
      class_704.method_4030(var1, 7, var0.method_4296());
      class_704.method_4030(var1, 8, var0.method_4297());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bt (android.os.Parcel) com.google.android.gms.fitness.data.DataPoint
   public DataPoint method_5721(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      DataSource var4 = null;
      long var5 = 0L;
      long var7 = 0L;
      Value[] var9 = null;
      DataSource var10 = null;
      long var11 = 0L;
      long var13 = 0L;

      while(var1.dataPosition() < var2) {
         int var15 = class_705.method_4058(var1);
         switch(class_705.method_4065(var15)) {
         case 1:
            var4 = (DataSource)class_705.method_4061(var1, var15, DataSource.CREATOR);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var15);
            break;
         case 4:
            var7 = class_705.method_4075(var1, var15);
            break;
         case 5:
            var9 = (Value[])class_705.method_4067(var1, var15, Value.CREATOR);
            break;
         case 6:
            var10 = (DataSource)class_705.method_4061(var1, var15, DataSource.CREATOR);
            break;
         case 7:
            var11 = class_705.method_4075(var1, var15);
            break;
         case 8:
            var13 = class_705.method_4075(var1, var15);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var15);
            break;
         default:
            class_705.method_4066(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new DataPoint(var3, var4, var5, var7, var9, var10, var11, var13);
      }
   }

   // $FF: renamed from: cM (int) com.google.android.gms.fitness.data.DataPoint[]
   public DataPoint[] method_5722(int var1) {
      return new DataPoint[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5721(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5722(var1);
   }
}

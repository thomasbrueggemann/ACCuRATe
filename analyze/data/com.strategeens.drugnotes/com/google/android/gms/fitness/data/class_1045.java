package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

// $FF: renamed from: com.google.android.gms.fitness.data.s
public class class_1045 implements Creator<Subscription> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.Subscription, android.os.Parcel, int) void
   static void method_5744(Subscription var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getDataType(), var2, false);
      class_704.method_4030(var1, 3, var0.method_4754());
      class_704.method_4050(var1, 4, var0.getAccuracyMode());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bE (android.os.Parcel) com.google.android.gms.fitness.data.Subscription
   public Subscription method_5745(Parcel var1) {
      DataType var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      DataSource var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var7 = (DataSource)class_705.method_4061(var1, var9, DataSource.CREATOR);
            break;
         case 2:
            var2 = (DataType)class_705.method_4061(var1, var9, DataType.CREATOR);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var9);
            break;
         case 4:
            var3 = class_705.method_4073(var1, var9);
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
         return new Subscription(var8, var7, var2, var5, var3);
      }
   }

   // $FF: renamed from: cY (int) com.google.android.gms.fitness.data.Subscription[]
   public Subscription[] method_5746(int var1) {
      return new Subscription[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5745(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5746(var1);
   }
}

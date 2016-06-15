package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_776;
import com.google.android.gms.internal.ms;

// $FF: renamed from: com.google.android.gms.internal.mt
public class class_777 implements Creator<ms> {
   // $FF: renamed from: a (com.google.android.gms.internal.ms, android.os.Parcel, int) void
   static void method_4395(class_776 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bH (android.os.Parcel) com.google.android.gms.internal.ms
   public class_776 method_4396(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      DataSource var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var4 = (DataSource)class_705.method_4061(var1, var5, DataSource.CREATOR);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_776(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4396(var1);
   }

   // $FF: renamed from: db (int) com.google.android.gms.internal.ms[]
   public class_776[] method_4397(int var1) {
      return new class_776[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4397(var1);
   }
}

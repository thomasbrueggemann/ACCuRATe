package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.StorageStats;

// $FF: renamed from: com.google.android.gms.drive.g
public class class_685 implements Creator<StorageStats> {
   // $FF: renamed from: a (com.google.android.gms.drive.StorageStats, android.os.Parcel, int) void
   static void method_3871(StorageStats var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2858);
      class_704.method_4030(var1, 2, var0.field_2859);
      class_704.method_4030(var1, 3, var0.field_2860);
      class_704.method_4030(var1, 4, var0.field_2861);
      class_704.method_4030(var1, 5, var0.field_2862);
      class_704.method_4050(var1, 6, var0.field_2863);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: V (android.os.Parcel) com.google.android.gms.drive.StorageStats
   public StorageStats method_3872(Parcel var1) {
      int var2 = 0;
      long var3 = 0L;
      int var5 = class_705.method_4059(var1);
      long var6 = var3;
      long var8 = var3;
      long var10 = var3;
      int var12 = 0;

      while(var1.dataPosition() < var5) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var12 = class_705.method_4073(var1, var13);
            break;
         case 2:
            var10 = class_705.method_4075(var1, var13);
            break;
         case 3:
            var8 = class_705.method_4075(var1, var13);
            break;
         case 4:
            var6 = class_705.method_4075(var1, var13);
            break;
         case 5:
            var3 = class_705.method_4075(var1, var13);
            break;
         case 6:
            var2 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_705.class_1425("Overread allowed size end=" + var5, var1);
      } else {
         return new StorageStats(var12, var10, var8, var6, var3, var2);
      }
   }

   // $FF: renamed from: bd (int) com.google.android.gms.drive.StorageStats[]
   public StorageStats[] method_3873(int var1) {
      return new StorageStats[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3872(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3873(var1);
   }
}

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.StorageStats;

// $FF: renamed from: com.google.android.gms.drive.e
public class class_581 implements Creator<StorageStats> {
   // $FF: renamed from: a (com.google.android.gms.drive.StorageStats, android.os.Parcel, int) void
   static void method_3258(StorageStats var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2969);
      class_599.method_3361(var1, 2, var0.field_2964);
      class_599.method_3361(var1, 3, var0.field_2965);
      class_599.method_3361(var1, 4, var0.field_2966);
      class_599.method_3361(var1, 5, var0.field_2967);
      class_599.method_3381(var1, 6, var0.field_2968);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: O (android.os.Parcel) com.google.android.gms.drive.StorageStats
   public StorageStats method_3259(Parcel var1) {
      int var2 = 0;
      long var3 = 0L;
      int var5 = class_600.method_3385(var1);
      long var6 = var3;
      long var8 = var3;
      long var10 = var3;
      int var12 = 0;

      while(var1.dataPosition() < var5) {
         int var13 = class_600.method_3383(var1);
         switch(class_600.method_3394(var13)) {
         case 1:
            var12 = class_600.method_3402(var1, var13);
            break;
         case 2:
            var10 = class_600.method_3404(var1, var13);
            break;
         case 3:
            var8 = class_600.method_3404(var1, var13);
            break;
         case 4:
            var6 = class_600.method_3404(var1, var13);
            break;
         case 5:
            var3 = class_600.method_3404(var1, var13);
            break;
         case 6:
            var2 = class_600.method_3402(var1, var13);
            break;
         default:
            class_600.method_3395(var1, var13);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_600.class_1103("Overread allowed size end=" + var5, var1);
      } else {
         return new StorageStats(var12, var10, var8, var6, var3, var2);
      }
   }

   // $FF: renamed from: aI (int) com.google.android.gms.drive.StorageStats[]
   public StorageStats[] method_3260(int var1) {
      return new StorageStats[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3259(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3260(var1);
   }
}

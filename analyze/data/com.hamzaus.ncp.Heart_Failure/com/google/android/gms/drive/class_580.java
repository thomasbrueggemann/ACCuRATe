package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.c
public class class_580 implements Creator<DriveId> {
   // $FF: renamed from: a (com.google.android.gms.drive.DriveId, android.os.Parcel, int) void
   static void method_3255(DriveId var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2183);
      class_599.method_3369(var1, 2, var0.field_2179, false);
      class_599.method_3361(var1, 3, var0.field_2180);
      class_599.method_3361(var1, 4, var0.field_2181);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: N (android.os.Parcel) com.google.android.gms.drive.DriveId
   public DriveId method_3256(Parcel var1) {
      long var2 = 0L;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      String var6 = null;
      long var7 = var2;

      while(var1.dataPosition() < var4) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var5 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var6 = class_600.method_3410(var1, var9);
            break;
         case 3:
            var7 = class_600.method_3404(var1, var9);
            break;
         case 4:
            var2 = class_600.method_3404(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new DriveId(var5, var6, var7, var2);
      }
   }

   // $FF: renamed from: aH (int) com.google.android.gms.drive.DriveId[]
   public DriveId[] method_3257(int var1) {
      return new DriveId[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3256(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3257(var1);
   }
}

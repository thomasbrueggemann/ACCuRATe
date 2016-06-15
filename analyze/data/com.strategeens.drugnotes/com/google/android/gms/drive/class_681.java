package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.c
public class class_681 implements Creator<DriveId> {
   // $FF: renamed from: a (com.google.android.gms.drive.DriveId, android.os.Parcel, int) void
   static void method_3859(DriveId var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_1923);
      class_704.method_4038(var1, 2, var0.field_1924, false);
      class_704.method_4030(var1, 3, var0.field_1925);
      class_704.method_4030(var1, 4, var0.field_1926);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: S (android.os.Parcel) com.google.android.gms.drive.DriveId
   public DriveId method_3860(Parcel var1) {
      long var2 = 0L;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      String var6 = null;
      long var7 = var2;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var5 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var9);
            break;
         case 3:
            var7 = class_705.method_4075(var1, var9);
            break;
         case 4:
            var2 = class_705.method_4075(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new DriveId(var5, var6, var7, var2);
      }
   }

   // $FF: renamed from: aY (int) com.google.android.gms.drive.DriveId[]
   public DriveId[] method_3861(int var1) {
      return new DriveId[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3860(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3861(var1);
   }
}

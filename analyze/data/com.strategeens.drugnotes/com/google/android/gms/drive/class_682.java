package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DrivePreferences;

// $FF: renamed from: com.google.android.gms.drive.d
public class class_682 implements Creator<DrivePreferences> {
   // $FF: renamed from: a (com.google.android.gms.drive.DrivePreferences, android.os.Parcel, int) void
   static void method_3862(DrivePreferences var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3919);
      class_704.method_4041(var1, 2, var0.field_3920);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: T (android.os.Parcel) com.google.android.gms.drive.DrivePreferences
   public DrivePreferences method_3863(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      while(var1.dataPosition() < var3) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var4 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var2 = class_705.method_4069(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new DrivePreferences(var4, var2);
      }
   }

   // $FF: renamed from: aZ (int) com.google.android.gms.drive.DrivePreferences[]
   public DrivePreferences[] method_3864(int var1) {
      return new DrivePreferences[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3863(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3864(var1);
   }
}

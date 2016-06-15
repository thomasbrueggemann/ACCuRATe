package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.a
public class class_684 implements Creator<Contents> {
   // $FF: renamed from: a (com.google.android.gms.drive.Contents, android.os.Parcel, int) void
   static void method_3868(Contents var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3098);
      class_704.method_4034(var1, 2, var0.field_3099, var2, false);
      class_704.method_4050(var1, 3, var0.field_3103);
      class_704.method_4050(var1, 4, var0.field_3100);
      class_704.method_4034(var1, 5, var0.field_3101, var2, false);
      class_704.method_4041(var1, 7, var0.field_3102);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: R (android.os.Parcel) com.google.android.gms.drive.Contents
   public Contents method_3869(Parcel var1) {
      DriveId var2 = null;
      boolean var3 = false;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      int var6 = 0;
      ParcelFileDescriptor var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var8 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var7 = (ParcelFileDescriptor)class_705.method_4061(var1, var9, ParcelFileDescriptor.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4073(var1, var9);
            break;
         case 4:
            var5 = class_705.method_4073(var1, var9);
            break;
         case 5:
            var2 = (DriveId)class_705.method_4061(var1, var9, DriveId.CREATOR);
            break;
         case 6:
         default:
            class_705.method_4066(var1, var9);
            break;
         case 7:
            var3 = class_705.method_4069(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new Contents(var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: aX (int) com.google.android.gms.drive.Contents[]
   public Contents[] method_3870(int var1) {
      return new Contents[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3869(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3870(var1);
   }
}

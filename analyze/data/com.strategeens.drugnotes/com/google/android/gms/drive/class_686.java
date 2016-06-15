package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.UserMetadata;

// $FF: renamed from: com.google.android.gms.drive.h
public class class_686 implements Creator<UserMetadata> {
   // $FF: renamed from: a (com.google.android.gms.drive.UserMetadata, android.os.Parcel, int) void
   static void method_3874(UserMetadata var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2608);
      class_704.method_4038(var1, 2, var0.field_2609, false);
      class_704.method_4038(var1, 3, var0.field_2610, false);
      class_704.method_4038(var1, 4, var0.field_2611, false);
      class_704.method_4041(var1, 5, var0.field_2612);
      class_704.method_4038(var1, 6, var0.field_2613, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: W (android.os.Parcel) com.google.android.gms.drive.UserMetadata
   public UserMetadata method_3875(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      String var5 = null;
      String var6 = null;
      String var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var8 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var7 = class_705.method_4081(var1, var9);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var9);
            break;
         case 4:
            var5 = class_705.method_4081(var1, var9);
            break;
         case 5:
            var2 = class_705.method_4069(var1, var9);
            break;
         case 6:
            var3 = class_705.method_4081(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new UserMetadata(var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: be (int) com.google.android.gms.drive.UserMetadata[]
   public UserMetadata[] method_3876(int var1) {
      return new UserMetadata[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3875(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3876(var1);
   }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.internal.bf
public class class_1028 implements Creator<SetResourceParentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, android.os.Parcel, int) void
   static void method_5636(SetResourceParentsRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3215);
      class_704.method_4034(var1, 2, var0.field_3216, var2, false);
      class_704.method_4051(var1, 3, var0.field_3217, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aJ (android.os.Parcel) com.google.android.gms.drive.internal.SetResourceParentsRequest
   public SetResourceParentsRequest method_5637(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      DriveId var5;
      ArrayList var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         DriveId var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            DriveId var10 = (DriveId)class_705.method_4061(var1, var6, DriveId.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_705.method_4068(var1, var6, DriveId.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new SetResourceParentsRequest(var4, var5, var2);
      }
   }

   // $FF: renamed from: bY (int) com.google.android.gms.drive.internal.SetResourceParentsRequest[]
   public SetResourceParentsRequest[] method_5638(int var1) {
      return new SetResourceParentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5637(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5638(var1);
   }
}

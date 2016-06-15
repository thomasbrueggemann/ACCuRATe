package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.k
public class class_277 implements Creator<CreateFileRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, android.os.Parcel, int) void
   static void method_1753(CreateFileRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3871);
      class_704.method_4034(var1, 2, var0.field_3879, var2, false);
      class_704.method_4034(var1, 3, var0.field_3877, var2, false);
      class_704.method_4034(var1, 4, var0.field_3876, var2, false);
      class_704.method_4036(var1, 5, var0.field_3878, false);
      class_704.method_4041(var1, 6, var0.field_3873);
      class_704.method_4038(var1, 7, var0.field_3872, false);
      class_704.method_4050(var1, 8, var0.field_3874);
      class_704.method_4050(var1, 9, var0.field_3875);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ah (android.os.Parcel) com.google.android.gms.drive.internal.CreateFileRequest
   public CreateFileRequest method_1754(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      boolean var6 = false;
      Integer var7 = null;
      Contents var8 = null;
      MetadataBundle var9 = null;
      DriveId var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4073(var1, var12);
            break;
         case 2:
            var10 = (DriveId)class_705.method_4061(var1, var12, DriveId.CREATOR);
            break;
         case 3:
            var9 = (MetadataBundle)class_705.method_4061(var1, var12, MetadataBundle.CREATOR);
            break;
         case 4:
            var8 = (Contents)class_705.method_4061(var1, var12, Contents.CREATOR);
            break;
         case 5:
            var7 = class_705.method_4074(var1, var12);
            break;
         case 6:
            var6 = class_705.method_4069(var1, var12);
            break;
         case 7:
            var3 = class_705.method_4081(var1, var12);
            break;
         case 8:
            var5 = class_705.method_4073(var1, var12);
            break;
         case 9:
            var2 = class_705.method_4073(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileRequest(var11, var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: bs (int) com.google.android.gms.drive.internal.CreateFileRequest[]
   public CreateFileRequest[] method_1755(int var1) {
      return new CreateFileRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1754(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1755(var1);
   }
}

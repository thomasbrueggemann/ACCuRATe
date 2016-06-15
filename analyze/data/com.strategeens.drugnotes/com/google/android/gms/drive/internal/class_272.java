package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.f
public class class_272 implements Creator<CloseContentsAndUpdateMetadataRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, android.os.Parcel, int) void
   static void method_1735(CloseContentsAndUpdateMetadataRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4405);
      class_704.method_4034(var1, 2, var0.field_4408, var2, false);
      class_704.method_4034(var1, 3, var0.field_4409, var2, false);
      class_704.method_4034(var1, 4, var0.field_4410, var2, false);
      class_704.method_4041(var1, 5, var0.field_4407);
      class_704.method_4038(var1, 6, var0.field_4406, false);
      class_704.method_4050(var1, 7, var0.field_4411);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ad (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
   public CloseContentsAndUpdateMetadataRequest method_1736(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      boolean var5 = false;
      Contents var6 = null;
      MetadataBundle var7 = null;
      DriveId var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var8 = (DriveId)class_705.method_4061(var1, var10, DriveId.CREATOR);
            break;
         case 3:
            var7 = (MetadataBundle)class_705.method_4061(var1, var10, MetadataBundle.CREATOR);
            break;
         case 4:
            var6 = (Contents)class_705.method_4061(var1, var10, Contents.CREATOR);
            break;
         case 5:
            var5 = class_705.method_4069(var1, var10);
            break;
         case 6:
            var3 = class_705.method_4081(var1, var10);
            break;
         case 7:
            var2 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CloseContentsAndUpdateMetadataRequest(var9, var8, var7, var6, var5, var3, var2);
      }
   }

   // $FF: renamed from: bn (int) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest[]
   public CloseContentsAndUpdateMetadataRequest[] method_1737(int var1) {
      return new CloseContentsAndUpdateMetadataRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1736(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1737(var1);
   }
}

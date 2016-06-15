package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.e
public class class_222 implements Creator<CloseContentsAndUpdateMetadataRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, android.os.Parcel, int) void
   static void method_1393(CloseContentsAndUpdateMetadataRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4251);
      class_599.method_3365(var1, 2, var0.field_4246, var2, false);
      class_599.method_3365(var1, 3, var0.field_4247, var2, false);
      class_599.method_3365(var1, 4, var0.field_4248, var2, false);
      class_599.method_3372(var1, 5, var0.field_4249);
      class_599.method_3369(var1, 6, var0.field_4250, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: U (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
   public CloseContentsAndUpdateMetadataRequest method_1394(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      Contents var5 = null;
      MetadataBundle var6 = null;
      DriveId var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var8 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var7 = (DriveId)class_600.method_3390(var1, var9, DriveId.CREATOR);
            break;
         case 3:
            var6 = (MetadataBundle)class_600.method_3390(var1, var9, MetadataBundle.CREATOR);
            break;
         case 4:
            var5 = (Contents)class_600.method_3390(var1, var9, Contents.CREATOR);
            break;
         case 5:
            var2 = class_600.method_3398(var1, var9);
            break;
         case 6:
            var3 = class_600.method_3410(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new CloseContentsAndUpdateMetadataRequest(var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: aP (int) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest[]
   public CloseContentsAndUpdateMetadataRequest[] method_1395(int var1) {
      return new CloseContentsAndUpdateMetadataRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1394(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1395(var1);
   }
}
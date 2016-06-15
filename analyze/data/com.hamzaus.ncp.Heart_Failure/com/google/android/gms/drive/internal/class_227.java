package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.j
public class class_227 implements Creator<CreateFileRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, android.os.Parcel, int) void
   static void method_1409(CreateFileRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3730);
      class_599.method_3365(var1, 2, var0.field_3726, var2, false);
      class_599.method_3365(var1, 3, var0.field_3724, var2, false);
      class_599.method_3365(var1, 4, var0.field_3728, var2, false);
      class_599.method_3367(var1, 5, var0.field_3725, false);
      class_599.method_3372(var1, 6, var0.field_3727);
      class_599.method_3369(var1, 7, var0.field_3729, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: Y (android.os.Parcel) com.google.android.gms.drive.internal.CreateFileRequest
   public CreateFileRequest method_1410(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      Integer var5 = null;
      Contents var6 = null;
      MetadataBundle var7 = null;
      DriveId var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var9 = class_600.method_3402(var1, var10);
            break;
         case 2:
            var8 = (DriveId)class_600.method_3390(var1, var10, DriveId.CREATOR);
            break;
         case 3:
            var7 = (MetadataBundle)class_600.method_3390(var1, var10, MetadataBundle.CREATOR);
            break;
         case 4:
            var6 = (Contents)class_600.method_3390(var1, var10, Contents.CREATOR);
            break;
         case 5:
            var5 = class_600.method_3403(var1, var10);
            break;
         case 6:
            var2 = class_600.method_3398(var1, var10);
            break;
         case 7:
            var3 = class_600.method_3410(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileRequest(var9, var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: aU (int) com.google.android.gms.drive.internal.CreateFileRequest[]
   public CreateFileRequest[] method_1411(int var1) {
      return new CreateFileRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1410(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1411(var1);
   }
}

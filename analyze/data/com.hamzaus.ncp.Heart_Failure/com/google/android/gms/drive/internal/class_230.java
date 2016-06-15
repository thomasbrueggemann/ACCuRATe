package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.DeleteCustomPropertyRequest;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

// $FF: renamed from: com.google.android.gms.drive.internal.m
public class class_230 implements Creator<DeleteCustomPropertyRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.DeleteCustomPropertyRequest, android.os.Parcel, int) void
   static void method_1419(DeleteCustomPropertyRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2982);
      class_599.method_3365(var1, 2, var0.field_2980, var2, false);
      class_599.method_3365(var1, 3, var0.field_2981, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aW (int) com.google.android.gms.drive.internal.DeleteCustomPropertyRequest[]
   public DeleteCustomPropertyRequest[] method_1420(int var1) {
      return new DeleteCustomPropertyRequest[var1];
   }

   // $FF: renamed from: aa (android.os.Parcel) com.google.android.gms.drive.internal.DeleteCustomPropertyRequest
   public DeleteCustomPropertyRequest method_1421(Parcel var1) {
      CustomPropertyKey var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      DriveId var5;
      CustomPropertyKey var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         DriveId var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            DriveId var10 = (DriveId)class_600.method_3390(var1, var6, DriveId.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (CustomPropertyKey)class_600.method_3390(var1, var6, CustomPropertyKey.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_600.method_3395(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new DeleteCustomPropertyRequest(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1421(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1420(var1);
   }
}

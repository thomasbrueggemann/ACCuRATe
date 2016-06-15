package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.AddEventListenerRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.a
public class class_205 implements Creator<AddEventListenerRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.AddEventListenerRequest, android.os.Parcel, int) void
   static void method_1343(AddEventListenerRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3719);
      class_599.method_3365(var1, 2, var0.field_3716, var2, false);
      class_599.method_3381(var1, 3, var0.field_3717);
      class_599.method_3365(var1, 4, var0.field_3718, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: R (android.os.Parcel) com.google.android.gms.drive.internal.AddEventListenerRequest
   public AddEventListenerRequest method_1344(Parcel var1) {
      PendingIntent var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      DriveId var5 = null;

      int var6;
      PendingIntent var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         int var9;
         DriveId var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var3;
            var10 = var5;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            DriveId var14 = (DriveId)class_600.method_3390(var1, var7, DriveId.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var3;
            break;
         case 3:
            int var12 = class_600.method_3402(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (PendingIntent)class_600.method_3390(var1, var7, PendingIntent.CREATOR);
            var9 = var3;
            var10 = var5;
            var11 = var6;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var3;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var3 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new AddEventListenerRequest(var6, var5, var3, var2);
      }
   }

   // $FF: renamed from: aM (int) com.google.android.gms.drive.internal.AddEventListenerRequest[]
   public AddEventListenerRequest[] method_1345(int var1) {
      return new AddEventListenerRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1344(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1345(var1);
   }
}

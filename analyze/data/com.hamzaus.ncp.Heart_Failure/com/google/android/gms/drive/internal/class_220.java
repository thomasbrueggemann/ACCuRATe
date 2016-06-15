package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.y
public class class_220 implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, android.os.Parcel, int) void
   static void method_1387(GetDriveIdFromUniqueIdentifierRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3987);
      class_599.method_3369(var1, 2, var0.field_3985, false);
      class_599.method_3372(var1, 3, var0.field_3986);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aZ (int) com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest[]
   public GetDriveIdFromUniqueIdentifierRequest[] method_1388(int var1) {
      return new GetDriveIdFromUniqueIdentifierRequest[var1];
   }

   // $FF: renamed from: ad (android.os.Parcel) com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest
   public GetDriveIdFromUniqueIdentifierRequest method_1389(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var5 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var6);
            break;
         case 3:
            var2 = class_600.method_3398(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new GetDriveIdFromUniqueIdentifierRequest(var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1389(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1388(var1);
   }
}

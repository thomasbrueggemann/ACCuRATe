package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.b
public class class_204 implements Creator<AuthorizeAccessRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.AuthorizeAccessRequest, android.os.Parcel, int) void
   static void method_1340(AuthorizeAccessRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3977);
      class_599.method_3361(var1, 2, var0.field_3976);
      class_599.method_3365(var1, 3, var0.field_3975, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: S (android.os.Parcel) com.google.android.gms.drive.internal.AuthorizeAccessRequest
   public AuthorizeAccessRequest method_1341(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      long var4 = 0L;
      DriveId var6 = null;

      while(var1.dataPosition() < var2) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var3 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var4 = class_600.method_3404(var1, var7);
            break;
         case 3:
            var6 = (DriveId)class_600.method_3390(var1, var7, DriveId.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new AuthorizeAccessRequest(var3, var4, var6);
      }
   }

   // $FF: renamed from: aN (int) com.google.android.gms.drive.internal.AuthorizeAccessRequest[]
   public AuthorizeAccessRequest[] method_1342(int var1) {
      return new AuthorizeAccessRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1341(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1342(var1);
   }
}

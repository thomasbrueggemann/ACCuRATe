package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.internal.av
public class class_779 implements Creator<SetResourceParentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.SetResourceParentsRequest, android.os.Parcel, int) void
   static void method_4374(SetResourceParentsRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3266);
      class_599.method_3365(var1, 2, var0.field_3264, var2, false);
      class_599.method_3380(var1, 3, var0.field_3265, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aw (android.os.Parcel) com.google.android.gms.drive.internal.SetResourceParentsRequest
   public SetResourceParentsRequest method_4375(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      DriveId var5;
      ArrayList var7;
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
            var7 = class_600.method_3397(var1, var6, DriveId.CREATOR);
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
         return new SetResourceParentsRequest(var4, var5, var2);
      }
   }

   // $FF: renamed from: bs (int) com.google.android.gms.drive.internal.SetResourceParentsRequest[]
   public SetResourceParentsRequest[] method_4376(int var1) {
      return new SetResourceParentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4375(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4376(var1);
   }
}

package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
   static void method_4210(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3358(var1, 2, var0.method_1428());
      class_599.method_3358(var1, 3, var0.method_1429());
      class_599.method_3381(var1, 4, var0.getMapType());
      class_599.method_3365(var1, 5, var0.getCamera(), var2, false);
      class_599.method_3358(var1, 6, var0.method_1430());
      class_599.method_3358(var1, 7, var0.method_1431());
      class_599.method_3358(var1, 8, var0.method_1432());
      class_599.method_3358(var1, 9, var0.method_1433());
      class_599.method_3358(var1, 10, var0.method_1434());
      class_599.method_3358(var1, 11, var0.method_1435());
      class_599.method_3357(var1, var3);
   }

   public GoogleMapOptions createFromParcel(Parcel var1) {
      byte var2 = 0;
      int var3 = class_600.method_3385(var1);
      CameraPosition var4 = null;
      byte var5 = 0;
      byte var6 = 0;
      byte var7 = 0;
      byte var8 = 0;
      byte var9 = 0;
      int var10 = 0;
      byte var11 = 0;
      byte var12 = 0;
      int var13 = 0;

      while(var1.dataPosition() < var3) {
         int var14 = class_600.method_3383(var1);
         switch(class_600.method_3394(var14)) {
         case 1:
            var13 = class_600.method_3402(var1, var14);
            break;
         case 2:
            var12 = class_600.method_3400(var1, var14);
            break;
         case 3:
            var11 = class_600.method_3400(var1, var14);
            break;
         case 4:
            var10 = class_600.method_3402(var1, var14);
            break;
         case 5:
            var4 = (CameraPosition)class_600.method_3390(var1, var14, CameraPosition.CREATOR);
            break;
         case 6:
            var9 = class_600.method_3400(var1, var14);
            break;
         case 7:
            var8 = class_600.method_3400(var1, var14);
            break;
         case 8:
            var7 = class_600.method_3400(var1, var14);
            break;
         case 9:
            var6 = class_600.method_3400(var1, var14);
            break;
         case 10:
            var5 = class_600.method_3400(var1, var14);
            break;
         case 11:
            var2 = class_600.method_3400(var1, var14);
            break;
         default:
            class_600.method_3395(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new GoogleMapOptions(var13, var12, var11, var10, var4, var9, var8, var7, var6, var5, var2);
      }
   }

   public GoogleMapOptions[] newArray(int var1) {
      return new GoogleMapOptions[var1];
   }
}

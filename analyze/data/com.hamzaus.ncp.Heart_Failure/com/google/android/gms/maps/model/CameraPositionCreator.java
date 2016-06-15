package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class CameraPositionCreator implements Creator<CameraPosition> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.CameraPosition, android.os.Parcel, int) void
   static void method_4006(CameraPosition var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.target, var2, false);
      class_599.method_3360(var1, 3, var0.zoom);
      class_599.method_3360(var1, 4, var0.tilt);
      class_599.method_3360(var1, 5, var0.bearing);
      class_599.method_3357(var1, var3);
   }

   public CameraPosition createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      LatLng var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var4 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var5 = (LatLng)class_600.method_3390(var1, var8, LatLng.CREATOR);
            break;
         case 3:
            var7 = class_600.method_3407(var1, var8);
            break;
         case 4:
            var6 = class_600.method_3407(var1, var8);
            break;
         case 5:
            var2 = class_600.method_3407(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new CameraPosition(var4, var5, var7, var6, var2);
      }
   }

   public CameraPosition[] newArray(int var1) {
      return new CameraPosition[var1];
   }
}

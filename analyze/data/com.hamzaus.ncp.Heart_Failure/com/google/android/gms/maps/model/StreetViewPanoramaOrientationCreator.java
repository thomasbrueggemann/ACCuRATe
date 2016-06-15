package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanoramaOrientationCreator implements Creator<StreetViewPanoramaOrientation> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaOrientation, android.os.Parcel, int) void
   static void method_3664(StreetViewPanoramaOrientation var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3360(var1, 2, var0.tilt);
      class_599.method_3360(var1, 3, var0.bearing);
      class_599.method_3357(var1, var3);
   }

   public StreetViewPanoramaOrientation createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      float var5 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var4 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var5 = class_600.method_3407(var1, var6);
            break;
         case 3:
            var2 = class_600.method_3407(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaOrientation(var4, var5, var2);
      }
   }

   public StreetViewPanoramaOrientation[] newArray(int var1) {
      return new StreetViewPanoramaOrientation[var1];
   }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaCameraCreator implements Creator<StreetViewPanoramaCamera> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaCamera, android.os.Parcel, int) void
   static void method_3323(StreetViewPanoramaCamera var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3360(var1, 2, var0.zoom);
      class_599.method_3360(var1, 3, var0.tilt);
      class_599.method_3360(var1, 4, var0.bearing);
      class_599.method_3357(var1, var3);
   }

   public StreetViewPanoramaCamera createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_600.method_3385(var1);
      float var4 = 0.0F;
      int var5 = 0;
      float var6 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var5 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var4 = class_600.method_3407(var1, var7);
            break;
         case 3:
            var6 = class_600.method_3407(var1, var7);
            break;
         case 4:
            var2 = class_600.method_3407(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaCamera(var5, var4, var6, var2);
      }
   }

   public StreetViewPanoramaCamera[] newArray(int var1) {
      return new StreetViewPanoramaCamera[var1];
   }
}

package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaOptionsCreator implements Creator<StreetViewPanoramaOptions> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.StreetViewPanoramaOptions, android.os.Parcel, int) void
   static void method_2284(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getStreetViewPanoramaCamera(), var2, false);
      class_599.method_3369(var1, 3, var0.getPanoramaId(), false);
      class_599.method_3365(var1, 4, var0.getPosition(), var2, false);
      class_599.method_3367(var1, 5, var0.getRadius(), false);
      class_599.method_3358(var1, 6, var0.method_4278());
      class_599.method_3358(var1, 7, var0.method_4277());
      class_599.method_3358(var1, 8, var0.method_4279());
      class_599.method_3358(var1, 9, var0.method_4275());
      class_599.method_3358(var1, 10, var0.method_4276());
      class_599.method_3357(var1, var3);
   }

   public StreetViewPanoramaOptions createFromParcel(Parcel var1) {
      Integer var2 = null;
      byte var3 = 0;
      int var4 = class_600.method_3385(var1);
      byte var5 = 0;
      byte var6 = 0;
      byte var7 = 0;
      byte var8 = 0;
      LatLng var9 = null;
      String var10 = null;
      StreetViewPanoramaCamera var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_600.method_3383(var1);
         switch(class_600.method_3394(var13)) {
         case 1:
            var12 = class_600.method_3402(var1, var13);
            break;
         case 2:
            var11 = (StreetViewPanoramaCamera)class_600.method_3390(var1, var13, StreetViewPanoramaCamera.CREATOR);
            break;
         case 3:
            var10 = class_600.method_3410(var1, var13);
            break;
         case 4:
            var9 = (LatLng)class_600.method_3390(var1, var13, LatLng.CREATOR);
            break;
         case 5:
            var2 = class_600.method_3403(var1, var13);
            break;
         case 6:
            var8 = class_600.method_3400(var1, var13);
            break;
         case 7:
            var7 = class_600.method_3400(var1, var13);
            break;
         case 8:
            var6 = class_600.method_3400(var1, var13);
            break;
         case 9:
            var5 = class_600.method_3400(var1, var13);
            break;
         case 10:
            var3 = class_600.method_3400(var1, var13);
            break;
         default:
            class_600.method_3395(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new StreetViewPanoramaOptions(var12, var11, var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   public StreetViewPanoramaOptions[] newArray(int var1) {
      return new StreetViewPanoramaOptions[var1];
   }
}

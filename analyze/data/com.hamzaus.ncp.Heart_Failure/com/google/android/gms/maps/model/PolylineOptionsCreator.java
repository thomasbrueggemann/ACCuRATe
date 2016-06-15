package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.PolylineOptions, android.os.Parcel, int) void
   static void method_4315(PolylineOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3380(var1, 2, var0.getPoints(), false);
      class_599.method_3360(var1, 3, var0.getWidth());
      class_599.method_3381(var1, 4, var0.getColor());
      class_599.method_3360(var1, 5, var0.getZIndex());
      class_599.method_3372(var1, 6, var0.isVisible());
      class_599.method_3372(var1, 7, var0.isGeodesic());
      class_599.method_3357(var1, var3);
   }

   public PolylineOptions createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = class_600.method_3385(var1);
      ArrayList var5 = null;
      boolean var6 = false;
      int var7 = 0;
      float var8 = 0.0F;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var9 = class_600.method_3402(var1, var10);
            break;
         case 2:
            var5 = class_600.method_3397(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var8 = class_600.method_3407(var1, var10);
            break;
         case 4:
            var7 = class_600.method_3402(var1, var10);
            break;
         case 5:
            var2 = class_600.method_3407(var1, var10);
            break;
         case 6:
            var6 = class_600.method_3398(var1, var10);
            break;
         case 7:
            var3 = class_600.method_3398(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new PolylineOptions(var9, var5, var8, var7, var2, var6, var3);
      }
   }

   public PolylineOptions[] newArray(int var1) {
      return new PolylineOptions[var1];
   }
}

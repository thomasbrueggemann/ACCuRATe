package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class CircleOptionsCreator implements Creator<CircleOptions> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.CircleOptions, android.os.Parcel, int) void
   static void method_4164(CircleOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getCenter(), var2, false);
      class_599.method_3359(var1, 3, var0.getRadius());
      class_599.method_3360(var1, 4, var0.getStrokeWidth());
      class_599.method_3381(var1, 5, var0.getStrokeColor());
      class_599.method_3381(var1, 6, var0.getFillColor());
      class_599.method_3360(var1, 7, var0.getZIndex());
      class_599.method_3372(var1, 8, var0.isVisible());
      class_599.method_3357(var1, var3);
   }

   public CircleOptions createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = class_600.method_3385(var1);
      LatLng var5 = null;
      double var6 = 0.0D;
      int var8 = 0;
      int var9 = 0;
      float var10 = 0.0F;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_600.method_3383(var1);
         switch(class_600.method_3394(var12)) {
         case 1:
            var11 = class_600.method_3402(var1, var12);
            break;
         case 2:
            var5 = (LatLng)class_600.method_3390(var1, var12, LatLng.CREATOR);
            break;
         case 3:
            var6 = class_600.method_3408(var1, var12);
            break;
         case 4:
            var10 = class_600.method_3407(var1, var12);
            break;
         case 5:
            var9 = class_600.method_3402(var1, var12);
            break;
         case 6:
            var8 = class_600.method_3402(var1, var12);
            break;
         case 7:
            var2 = class_600.method_3407(var1, var12);
            break;
         case 8:
            var3 = class_600.method_3398(var1, var12);
            break;
         default:
            class_600.method_3395(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new CircleOptions(var11, var5, var6, var10, var9, var8, var2, var3);
      }
   }

   public CircleOptions[] newArray(int var1) {
      return new CircleOptions[var1];
   }
}

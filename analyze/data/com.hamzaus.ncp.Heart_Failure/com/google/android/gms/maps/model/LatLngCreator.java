package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;

public class LatLngCreator implements Creator<LatLng> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, android.os.Parcel, int) void
   static void method_3104(LatLng var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3359(var1, 2, var0.latitude);
      class_599.method_3359(var1, 3, var0.longitude);
      class_599.method_3357(var1, var3);
   }

   public LatLng createFromParcel(Parcel var1) {
      double var2 = 0.0D;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      double var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var6 = class_600.method_3408(var1, var8);
            break;
         case 3:
            var2 = class_600.method_3408(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new LatLng(var5, var6, var2);
      }
   }

   public LatLng[] newArray(int var1) {
      return new LatLng[var1];
   }
}

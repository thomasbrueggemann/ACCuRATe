package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, android.os.Parcel, int) void
   static void method_3592(LatLngBounds var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.southwest, var2, false);
      class_599.method_3365(var1, 3, var0.northeast, var2, false);
      class_599.method_3357(var1, var3);
   }

   public LatLngBounds createFromParcel(Parcel var1) {
      LatLng var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      LatLng var5;
      LatLng var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         LatLng var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            LatLng var10 = (LatLng)class_600.method_3390(var1, var6, LatLng.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (LatLng)class_600.method_3390(var1, var6, LatLng.CREATOR);
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
         return new LatLngBounds(var4, var5, var2);
      }
   }

   public LatLngBounds[] newArray(int var1) {
      return new LatLngBounds[var1];
   }
}

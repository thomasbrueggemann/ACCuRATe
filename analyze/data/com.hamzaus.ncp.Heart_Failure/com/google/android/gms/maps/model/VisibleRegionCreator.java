package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.VisibleRegion, android.os.Parcel, int) void
   static void method_3951(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.nearLeft, var2, false);
      class_599.method_3365(var1, 3, var0.nearRight, var2, false);
      class_599.method_3365(var1, 4, var0.farLeft, var2, false);
      class_599.method_3365(var1, 5, var0.farRight, var2, false);
      class_599.method_3365(var1, 6, var0.latLngBounds, var2, false);
      class_599.method_3357(var1, var3);
   }

   public VisibleRegion createFromParcel(Parcel var1) {
      LatLngBounds var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      LatLng var5 = null;
      LatLng var6 = null;
      LatLng var7 = null;
      LatLng var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var4 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var8 = (LatLng)class_600.method_3390(var1, var9, LatLng.CREATOR);
            break;
         case 3:
            var7 = (LatLng)class_600.method_3390(var1, var9, LatLng.CREATOR);
            break;
         case 4:
            var6 = (LatLng)class_600.method_3390(var1, var9, LatLng.CREATOR);
            break;
         case 5:
            var5 = (LatLng)class_600.method_3390(var1, var9, LatLng.CREATOR);
            break;
         case 6:
            var2 = (LatLngBounds)class_600.method_3390(var1, var9, LatLngBounds.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new VisibleRegion(var4, var8, var7, var6, var5, var2);
      }
   }

   public VisibleRegion[] newArray(int var1) {
      return new VisibleRegion[var1];
   }
}

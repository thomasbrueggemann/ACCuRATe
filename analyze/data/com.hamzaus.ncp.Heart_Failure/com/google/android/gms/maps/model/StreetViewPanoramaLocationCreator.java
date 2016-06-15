package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class StreetViewPanoramaLocationCreator implements Creator<StreetViewPanoramaLocation> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaLocation, android.os.Parcel, int) void
   static void method_4062(StreetViewPanoramaLocation var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3375(var1, 2, var0.links, var2, false);
      class_599.method_3365(var1, 3, var0.position, var2, false);
      class_599.method_3369(var1, 4, var0.panoId, false);
      class_599.method_3357(var1, var3);
   }

   public StreetViewPanoramaLocation createFromParcel(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      LatLng var5 = null;

      StreetViewPanoramaLink[] var6;
      String var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         LatLng var9;
         StreetViewPanoramaLink[] var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            StreetViewPanoramaLink[] var14 = (StreetViewPanoramaLink[])class_600.method_3396(var1, var7, StreetViewPanoramaLink.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            LatLng var12 = (LatLng)class_600.method_3390(var1, var7, LatLng.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = class_600.method_3410(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaLocation(var4, var6, var5, var2);
      }
   }

   public StreetViewPanoramaLocation[] newArray(int var1) {
      return new StreetViewPanoramaLocation[var1];
   }
}

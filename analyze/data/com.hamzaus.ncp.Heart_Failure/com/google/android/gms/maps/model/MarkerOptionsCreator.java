package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
   static void method_3641(MarkerOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getPosition(), var2, false);
      class_599.method_3369(var1, 3, var0.getTitle(), false);
      class_599.method_3369(var1, 4, var0.getSnippet(), false);
      class_599.method_3363(var1, 5, var0.method_2746(), false);
      class_599.method_3360(var1, 6, var0.getAnchorU());
      class_599.method_3360(var1, 7, var0.getAnchorV());
      class_599.method_3372(var1, 8, var0.isDraggable());
      class_599.method_3372(var1, 9, var0.isVisible());
      class_599.method_3372(var1, 10, var0.isFlat());
      class_599.method_3360(var1, 11, var0.getRotation());
      class_599.method_3360(var1, 12, var0.getInfoWindowAnchorU());
      class_599.method_3360(var1, 13, var0.getInfoWindowAnchorV());
      class_599.method_3360(var1, 14, var0.getAlpha());
      class_599.method_3357(var1, var3);
   }

   public MarkerOptions createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      LatLng var4 = null;
      String var5 = null;
      String var6 = null;
      IBinder var7 = null;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      float var13 = 0.0F;
      float var14 = 0.5F;
      float var15 = 0.0F;
      float var16 = 1.0F;

      while(var1.dataPosition() < var2) {
         int var17 = class_600.method_3383(var1);
         switch(class_600.method_3394(var17)) {
         case 1:
            var3 = class_600.method_3402(var1, var17);
            break;
         case 2:
            var4 = (LatLng)class_600.method_3390(var1, var17, LatLng.CREATOR);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var17);
            break;
         case 4:
            var6 = class_600.method_3410(var1, var17);
            break;
         case 5:
            var7 = class_600.method_3411(var1, var17);
            break;
         case 6:
            var8 = class_600.method_3407(var1, var17);
            break;
         case 7:
            var9 = class_600.method_3407(var1, var17);
            break;
         case 8:
            var10 = class_600.method_3398(var1, var17);
            break;
         case 9:
            var11 = class_600.method_3398(var1, var17);
            break;
         case 10:
            var12 = class_600.method_3398(var1, var17);
            break;
         case 11:
            var13 = class_600.method_3407(var1, var17);
            break;
         case 12:
            var14 = class_600.method_3407(var1, var17);
            break;
         case 13:
            var15 = class_600.method_3407(var1, var17);
            break;
         case 14:
            var16 = class_600.method_3407(var1, var17);
            break;
         default:
            class_600.method_3395(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new MarkerOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   public MarkerOptions[] newArray(int var1) {
      return new MarkerOptions[var1];
   }
}

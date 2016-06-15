package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class StreetViewPanoramaLinkCreator implements Creator<StreetViewPanoramaLink> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaLink, android.os.Parcel, int) void
   static void method_4175(StreetViewPanoramaLink var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.panoId, false);
      class_599.method_3360(var1, 3, var0.bearing);
      class_599.method_3357(var1, var3);
   }

   public StreetViewPanoramaLink createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      float var5 = 0.0F;

      while(var1.dataPosition() < var2) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var3 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var6);
            break;
         case 3:
            var5 = class_600.method_3407(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new StreetViewPanoramaLink(var3, var4, var5);
      }
   }

   public StreetViewPanoramaLink[] newArray(int var1) {
      return new StreetViewPanoramaLink[var1];
   }
}

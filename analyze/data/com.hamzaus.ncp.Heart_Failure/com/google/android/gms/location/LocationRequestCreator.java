package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.location.LocationRequest;

public class LocationRequestCreator implements Creator<LocationRequest> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.os.Parcel, int) void
   static void method_3335(LocationRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.mPriority);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.field_3677);
      class_599.method_3361(var1, 3, var0.field_3678);
      class_599.method_3372(var1, 4, var0.field_3679);
      class_599.method_3361(var1, 5, var0.field_3676);
      class_599.method_3381(var1, 6, var0.field_3680);
      class_599.method_3360(var1, 7, var0.field_3681);
      class_599.method_3357(var1, var3);
   }

   public LocationRequest createFromParcel(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      int var4 = 102;
      long var5 = 3600000L;
      long var7 = 600000L;
      long var9 = Long.MAX_VALUE;
      int var11 = Integer.MAX_VALUE;
      float var12 = 0.0F;
      int var13 = 0;

      while(var1.dataPosition() < var3) {
         int var14 = class_600.method_3383(var1);
         switch(class_600.method_3394(var14)) {
         case 1:
            var4 = class_600.method_3402(var1, var14);
            break;
         case 2:
            var5 = class_600.method_3404(var1, var14);
            break;
         case 3:
            var7 = class_600.method_3404(var1, var14);
            break;
         case 4:
            var2 = class_600.method_3398(var1, var14);
            break;
         case 5:
            var9 = class_600.method_3404(var1, var14);
            break;
         case 6:
            var11 = class_600.method_3402(var1, var14);
            break;
         case 7:
            var12 = class_600.method_3407(var1, var14);
            break;
         case 1000:
            var13 = class_600.method_3402(var1, var14);
            break;
         default:
            class_600.method_3395(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new LocationRequest(var13, var4, var5, var7, var2, var9, var11, var12);
      }
   }

   public LocationRequest[] newArray(int var1) {
      return new LocationRequest[var1];
   }
}

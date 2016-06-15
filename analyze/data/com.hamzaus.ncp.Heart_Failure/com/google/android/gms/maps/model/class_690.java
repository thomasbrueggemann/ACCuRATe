package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.GroundOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.c
public class class_690 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.GroundOverlayOptions, android.os.Parcel, int) void
   static void method_4007(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3363(var1, 2, var0.method_3309(), false);
      class_599.method_3365(var1, 3, var0.getLocation(), var2, false);
      class_599.method_3360(var1, 4, var0.getWidth());
      class_599.method_3360(var1, 5, var0.getHeight());
      class_599.method_3365(var1, 6, var0.getBounds(), var2, false);
      class_599.method_3360(var1, 7, var0.getBearing());
      class_599.method_3360(var1, 8, var0.getZIndex());
      class_599.method_3372(var1, 9, var0.isVisible());
      class_599.method_3360(var1, 10, var0.getTransparency());
      class_599.method_3360(var1, 11, var0.getAnchorU());
      class_599.method_3360(var1, 12, var0.getAnchorV());
      class_599.method_3357(var1, var3);
   }
}

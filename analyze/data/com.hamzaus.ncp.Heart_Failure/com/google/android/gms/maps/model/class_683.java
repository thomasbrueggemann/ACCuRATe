package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.PolygonOptions;

// $FF: renamed from: com.google.android.gms.maps.model.g
public class class_683 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.PolygonOptions, android.os.Parcel, int) void
   static void method_3999(PolygonOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3380(var1, 2, var0.getPoints(), false);
      class_599.method_3382(var1, 3, var0.method_3851(), false);
      class_599.method_3360(var1, 4, var0.getStrokeWidth());
      class_599.method_3381(var1, 5, var0.getStrokeColor());
      class_599.method_3381(var1, 6, var0.getFillColor());
      class_599.method_3360(var1, 7, var0.getZIndex());
      class_599.method_3372(var1, 8, var0.isVisible());
      class_599.method_3372(var1, 9, var0.isGeodesic());
      class_599.method_3357(var1, var3);
   }
}

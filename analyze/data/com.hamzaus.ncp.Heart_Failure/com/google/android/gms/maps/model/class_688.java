package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.PolylineOptions;

// $FF: renamed from: com.google.android.gms.maps.model.h
public class class_688 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.PolylineOptions, android.os.Parcel, int) void
   static void method_4004(PolylineOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3380(var1, 2, var0.getPoints(), false);
      class_599.method_3360(var1, 3, var0.getWidth());
      class_599.method_3381(var1, 4, var0.getColor());
      class_599.method_3360(var1, 5, var0.getZIndex());
      class_599.method_3372(var1, 6, var0.isVisible());
      class_599.method_3372(var1, 7, var0.isGeodesic());
      class_599.method_3357(var1, var3);
   }
}

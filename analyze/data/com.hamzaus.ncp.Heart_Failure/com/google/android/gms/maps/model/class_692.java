package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.CameraPosition;

// $FF: renamed from: com.google.android.gms.maps.model.a
public class class_692 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.CameraPosition, android.os.Parcel, int) void
   static void method_4009(CameraPosition var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.target, var2, false);
      class_599.method_3360(var1, 3, var0.zoom);
      class_599.method_3360(var1, 4, var0.tilt);
      class_599.method_3360(var1, 5, var0.bearing);
      class_599.method_3357(var1, var3);
   }
}

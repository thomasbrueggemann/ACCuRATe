package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.MarkerOptions;

// $FF: renamed from: com.google.android.gms.maps.model.f
public class class_682 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
   static void method_3980(MarkerOptions var0, Parcel var1, int var2) {
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
      class_599.method_3357(var1, var3);
   }
}

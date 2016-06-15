package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.TileOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.j
public class class_686 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.TileOverlayOptions, android.os.Parcel, int) void
   static void method_4002(TileOverlayOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3363(var1, 2, var0.method_3458(), false);
      class_599.method_3372(var1, 3, var0.isVisible());
      class_599.method_3360(var1, 4, var0.getZIndex());
      class_599.method_3357(var1, var3);
   }
}

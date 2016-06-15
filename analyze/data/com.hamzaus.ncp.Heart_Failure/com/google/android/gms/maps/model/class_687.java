package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.model.VisibleRegion;

// $FF: renamed from: com.google.android.gms.maps.model.k
public class class_687 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.VisibleRegion, android.os.Parcel, int) void
   static void method_4003(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.nearLeft, var2, false);
      class_599.method_3365(var1, 3, var0.nearRight, var2, false);
      class_599.method_3365(var1, 4, var0.farLeft, var2, false);
      class_599.method_3365(var1, 5, var0.farRight, var2, false);
      class_599.method_3365(var1, 6, var0.latLngBounds, var2, false);
      class_599.method_3357(var1, var3);
   }
}

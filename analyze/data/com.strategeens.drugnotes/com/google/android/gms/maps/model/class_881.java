package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.VisibleRegion;

// $FF: renamed from: com.google.android.gms.maps.model.z
public class class_881 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.VisibleRegion, android.os.Parcel, int) void
   static void method_4969(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.nearLeft, var2, false);
      class_704.method_4034(var1, 3, var0.nearRight, var2, false);
      class_704.method_4034(var1, 4, var0.farLeft, var2, false);
      class_704.method_4034(var1, 5, var0.farRight, var2, false);
      class_704.method_4034(var1, 6, var0.latLngBounds, var2, false);
      class_704.method_4026(var1, var3);
   }
}

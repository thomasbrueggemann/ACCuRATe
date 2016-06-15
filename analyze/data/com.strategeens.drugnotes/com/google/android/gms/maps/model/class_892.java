package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.LatLngBounds;

// $FF: renamed from: com.google.android.gms.maps.model.h
public class class_892 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, android.os.Parcel, int) void
   static void method_5010(LatLngBounds var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.southwest, var2, false);
      class_704.method_4034(var1, 3, var0.northeast, var2, false);
      class_704.method_4026(var1, var3);
   }
}

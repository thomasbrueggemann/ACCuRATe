package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.CircleOptions;

// $FF: renamed from: com.google.android.gms.maps.model.d
public class class_888 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.CircleOptions, android.os.Parcel, int) void
   static void method_5002(CircleOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getCenter(), var2, false);
      class_704.method_4028(var1, 3, var0.getRadius());
      class_704.method_4029(var1, 4, var0.getStrokeWidth());
      class_704.method_4050(var1, 5, var0.getStrokeColor());
      class_704.method_4050(var1, 6, var0.getFillColor());
      class_704.method_4029(var1, 7, var0.getZIndex());
      class_704.method_4041(var1, 8, var0.isVisible());
      class_704.method_4026(var1, var3);
   }
}

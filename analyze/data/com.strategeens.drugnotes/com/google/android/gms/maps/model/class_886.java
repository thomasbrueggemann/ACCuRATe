package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.GroundOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.f
public class class_886 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.GroundOverlayOptions, android.os.Parcel, int) void
   static void method_4980(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4032(var1, 2, var0.method_3955(), false);
      class_704.method_4034(var1, 3, var0.getLocation(), var2, false);
      class_704.method_4029(var1, 4, var0.getWidth());
      class_704.method_4029(var1, 5, var0.getHeight());
      class_704.method_4034(var1, 6, var0.getBounds(), var2, false);
      class_704.method_4029(var1, 7, var0.getBearing());
      class_704.method_4029(var1, 8, var0.getZIndex());
      class_704.method_4041(var1, 9, var0.isVisible());
      class_704.method_4029(var1, 10, var0.getTransparency());
      class_704.method_4029(var1, 11, var0.getAnchorU());
      class_704.method_4029(var1, 12, var0.getAnchorV());
      class_704.method_4026(var1, var3);
   }
}

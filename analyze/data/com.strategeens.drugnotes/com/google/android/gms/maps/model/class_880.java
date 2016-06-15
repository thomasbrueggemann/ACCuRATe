package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.TileOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.x
public class class_880 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.TileOverlayOptions, android.os.Parcel, int) void
   static void method_4968(TileOverlayOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4032(var1, 2, var0.method_4137(), false);
      class_704.method_4041(var1, 3, var0.isVisible());
      class_704.method_4029(var1, 4, var0.getZIndex());
      class_704.method_4026(var1, var3);
   }
}

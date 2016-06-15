package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.Tile;

// $FF: renamed from: com.google.android.gms.maps.model.v
public class class_885 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.Tile, android.os.Parcel, int) void
   static void method_4979(Tile var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.width);
      class_704.method_4050(var1, 3, var0.height);
      class_704.method_4042(var1, 4, var0.data, false);
      class_704.method_4026(var1, var3);
   }
}

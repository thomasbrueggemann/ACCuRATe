package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.model.MarkerOptions;

// $FF: renamed from: com.google.android.gms.maps.model.l
public class class_896 {
   // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
   static void method_5018(MarkerOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getPosition(), var2, false);
      class_704.method_4038(var1, 3, var0.getTitle(), false);
      class_704.method_4038(var1, 4, var0.getSnippet(), false);
      class_704.method_4032(var1, 5, var0.method_3224(), false);
      class_704.method_4029(var1, 6, var0.getAnchorU());
      class_704.method_4029(var1, 7, var0.getAnchorV());
      class_704.method_4041(var1, 8, var0.isDraggable());
      class_704.method_4041(var1, 9, var0.isVisible());
      class_704.method_4026(var1, var3);
   }
}

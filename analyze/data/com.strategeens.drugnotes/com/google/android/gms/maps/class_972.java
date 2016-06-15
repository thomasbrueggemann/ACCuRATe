package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.maps.GoogleMapOptions;

// $FF: renamed from: com.google.android.gms.maps.b
public class class_972 {
   // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
   static void method_5412(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4027(var1, 2, var0.method_1770());
      class_704.method_4027(var1, 3, var0.method_1771());
      class_704.method_4050(var1, 4, var0.getMapType());
      class_704.method_4034(var1, 5, var0.getCamera(), var2, false);
      class_704.method_4027(var1, 6, var0.method_1772());
      class_704.method_4027(var1, 7, var0.method_1773());
      class_704.method_4027(var1, 8, var0.method_1774());
      class_704.method_4027(var1, 9, var0.method_1775());
      class_704.method_4027(var1, 10, var0.method_1776());
      class_704.method_4027(var1, 11, var0.method_1777());
      class_704.method_4026(var1, var3);
   }
}

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.maps.GoogleMapOptions;

// $FF: renamed from: com.google.android.gms.maps.a
public class class_751 {
   // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
   static void method_4292(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3358(var1, 2, var0.method_1428());
      class_599.method_3358(var1, 3, var0.method_1429());
      class_599.method_3381(var1, 4, var0.getMapType());
      class_599.method_3365(var1, 5, var0.getCamera(), var2, false);
      class_599.method_3358(var1, 6, var0.method_1430());
      class_599.method_3358(var1, 7, var0.method_1431());
      class_599.method_3358(var1, 8, var0.method_1432());
      class_599.method_3358(var1, 9, var0.method_1433());
      class_599.method_3358(var1, 10, var0.method_1434());
      class_599.method_3358(var1, 11, var0.method_1435());
      class_599.method_3357(var1, var3);
   }
}

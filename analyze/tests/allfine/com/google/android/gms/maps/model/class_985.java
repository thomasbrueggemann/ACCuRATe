package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.PolylineOptions;

// $FF: renamed from: com.google.android.gms.maps.model.p
public class class_985 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.PolylineOptions, android.os.Parcel, int) void
    static void method_5177(PolylineOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4326(var1, 2, var0.getPoints(), false);
        class_823.method_4304(var1, 3, var0.getWidth());
        class_823.method_4325(var1, 4, var0.getColor());
        class_823.method_4304(var1, 5, var0.getZIndex());
        class_823.method_4316(var1, 6, var0.isVisible());
        class_823.method_4316(var1, 7, var0.isGeodesic());
        class_823.method_4301(var1, var3);
    }
}

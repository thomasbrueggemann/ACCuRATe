package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.CircleOptions;

// $FF: renamed from: com.google.android.gms.maps.model.d
public class class_973 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.CircleOptions, android.os.Parcel, int) void
    static void method_5151(CircleOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getCenter(), var2, false);
        class_823.method_4303(var1, 3, var0.getRadius());
        class_823.method_4304(var1, 4, var0.getStrokeWidth());
        class_823.method_4325(var1, 5, var0.getStrokeColor());
        class_823.method_4325(var1, 6, var0.getFillColor());
        class_823.method_4304(var1, 7, var0.getZIndex());
        class_823.method_4316(var1, 8, var0.isVisible());
        class_823.method_4301(var1, var3);
    }
}

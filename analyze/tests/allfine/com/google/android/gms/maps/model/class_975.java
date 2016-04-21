package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.model.j
public class class_975 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, android.os.Parcel, int) void
    static void method_5155(LatLng var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4303(var1, 2, var0.latitude);
        class_823.method_4303(var1, 3, var0.longitude);
        class_823.method_4301(var1, var3);
    }
}

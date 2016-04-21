package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.VisibleRegion;

// $FF: renamed from: com.google.android.gms.maps.model.z
public class class_966 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.VisibleRegion, android.os.Parcel, int) void
    static void method_5118(VisibleRegion var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.nearLeft, var2, false);
        class_823.method_4309(var1, 3, var0.nearRight, var2, false);
        class_823.method_4309(var1, 4, var0.farLeft, var2, false);
        class_823.method_4309(var1, 5, var0.farRight, var2, false);
        class_823.method_4309(var1, 6, var0.latLngBounds, var2, false);
        class_823.method_4301(var1, var3);
    }
}

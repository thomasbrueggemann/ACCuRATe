package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.CameraPosition;

// $FF: renamed from: com.google.android.gms.maps.model.b
public class class_988 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.CameraPosition, android.os.Parcel, int) void
    static void method_5184(CameraPosition var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.target, var2, false);
        class_823.method_4304(var1, 3, var0.zoom);
        class_823.method_4304(var1, 4, var0.tilt);
        class_823.method_4304(var1, 5, var0.bearing);
        class_823.method_4301(var1, var3);
    }
}

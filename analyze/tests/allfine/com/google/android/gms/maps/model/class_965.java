package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.TileOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.x
public class class_965 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.TileOverlayOptions, android.os.Parcel, int) void
    static void method_5117(TileOverlayOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4307(var1, 2, var0.method_4401(), false);
        class_823.method_4316(var1, 3, var0.isVisible());
        class_823.method_4304(var1, 4, var0.getZIndex());
        class_823.method_4301(var1, var3);
    }
}

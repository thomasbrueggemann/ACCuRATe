package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.GroundOverlayOptions;

// $FF: renamed from: com.google.android.gms.maps.model.f
public class class_971 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.GroundOverlayOptions, android.os.Parcel, int) void
    static void method_5147(GroundOverlayOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4307(var1, 2, var0.method_4202(), false);
        class_823.method_4309(var1, 3, var0.getLocation(), var2, false);
        class_823.method_4304(var1, 4, var0.getWidth());
        class_823.method_4304(var1, 5, var0.getHeight());
        class_823.method_4309(var1, 6, var0.getBounds(), var2, false);
        class_823.method_4304(var1, 7, var0.getBearing());
        class_823.method_4304(var1, 8, var0.getZIndex());
        class_823.method_4316(var1, 9, var0.isVisible());
        class_823.method_4304(var1, 10, var0.getTransparency());
        class_823.method_4304(var1, 11, var0.getAnchorU());
        class_823.method_4304(var1, 12, var0.getAnchorV());
        class_823.method_4301(var1, var3);
    }
}

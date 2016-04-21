package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.MarkerOptions;

// $FF: renamed from: com.google.android.gms.maps.model.l
public class class_981 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
    static void method_5167(MarkerOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getPosition(), var2, false);
        class_823.method_4313(var1, 3, var0.getTitle(), false);
        class_823.method_4313(var1, 4, var0.getSnippet(), false);
        class_823.method_4307(var1, 5, var0.method_3184(), false);
        class_823.method_4304(var1, 6, var0.getAnchorU());
        class_823.method_4304(var1, 7, var0.getAnchorV());
        class_823.method_4316(var1, 8, var0.isDraggable());
        class_823.method_4316(var1, 9, var0.isVisible());
        class_823.method_4301(var1, var3);
    }
}

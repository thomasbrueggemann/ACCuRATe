package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.model.Tile;

// $FF: renamed from: com.google.android.gms.maps.model.v
public class class_970 {
    // $FF: renamed from: a (com.google.android.gms.maps.model.Tile, android.os.Parcel, int) void
    static void method_5128(Tile var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.width);
        class_823.method_4325(var1, 3, var0.height);
        class_823.method_4317(var1, 4, var0.data, false);
        class_823.method_4301(var1, var3);
    }
}

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.maps.GoogleMapOptions;

// $FF: renamed from: com.google.android.gms.maps.b
public class class_1058 {
    // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
    static void method_5538(GoogleMapOptions var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getVersionCode());
        class_823.method_4302(var1, 2, var0.method_1794());
        class_823.method_4302(var1, 3, var0.method_1795());
        class_823.method_4325(var1, 4, var0.getMapType());
        class_823.method_4309(var1, 5, var0.getCamera(), var2, false);
        class_823.method_4302(var1, 6, var0.method_1796());
        class_823.method_4302(var1, 7, var0.method_1797());
        class_823.method_4302(var1, 8, var0.method_1798());
        class_823.method_4302(var1, 9, var0.method_1799());
        class_823.method_4302(var1, 10, var0.method_1800());
        class_823.method_4302(var1, 11, var0.method_1801());
        class_823.method_4301(var1, var3);
    }
}

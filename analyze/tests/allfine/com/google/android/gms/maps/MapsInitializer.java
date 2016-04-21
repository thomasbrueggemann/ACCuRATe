package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.class_127;
import com.google.android.gms.maps.internal.class_814;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    // $FF: renamed from: a (com.google.android.gms.maps.internal.c) void
    public static void method_5720(class_127 var0) {
        try {
            CameraUpdateFactory.method_5318(var0.method_653());
            BitmapDescriptorFactory.method_5258(var0.method_654());
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public static int initialize(Context var0) {
        class_1090.method_5685(var0);

        class_127 var3;
        try {
            var3 = class_814.method_4233(var0);
        } catch (GooglePlayServicesNotAvailableException var4) {
            return var4.errorCode;
        }

        method_5720(var3);
        return 0;
    }
}

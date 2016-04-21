package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate aja;

    Projection(IProjectionDelegate var1) {
        this.aja = var1;
    }

    public LatLng fromScreenLocation(Point var1) {
        try {
            LatLng var3 = this.aja.fromScreenLocation(class_1046.method_5437(var1));
            return var3;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            VisibleRegion var2 = this.aja.getVisibleRegion();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public Point toScreenLocation(LatLng var1) {
        try {
            Point var3 = (Point)class_1046.method_5436(this.aja.toScreenLocation(var1));
            return var3;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }
}

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate aim;

    // $FF: renamed from: a (com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate) void
    static void method_5318(ICameraUpdateFactoryDelegate var0) {
        if(aim == null) {
            aim = (ICameraUpdateFactoryDelegate)class_1090.method_5685(var0);
        }
    }

    // $FF: renamed from: mp () com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    private static ICameraUpdateFactoryDelegate method_5319() {
        return (ICameraUpdateFactoryDelegate)class_1090.method_5681(aim, "CameraUpdateFactory is not initialized");
    }

    public static CameraUpdate newCameraPosition(CameraPosition var0) {
        try {
            CameraUpdate var1 = new CameraUpdate(method_5319().newCameraPosition(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static CameraUpdate newLatLng(LatLng var0) {
        try {
            CameraUpdate var1 = new CameraUpdate(method_5319().newLatLng(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1) {
        try {
            CameraUpdate var2 = new CameraUpdate(method_5319().newLatLngBounds(var0, var1));
            return var2;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1, int var2, int var3) {
        try {
            CameraUpdate var4 = new CameraUpdate(method_5319().newLatLngBoundsWithSize(var0, var1, var2, var3));
            return var4;
        } catch (RemoteException var6) {
            throw new RuntimeRemoteException(var6);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng var0, float var1) {
        try {
            CameraUpdate var2 = new CameraUpdate(method_5319().newLatLngZoom(var0, var1));
            return var2;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public static CameraUpdate scrollBy(float var0, float var1) {
        try {
            CameraUpdate var2 = new CameraUpdate(method_5319().scrollBy(var0, var1));
            return var2;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public static CameraUpdate zoomBy(float var0) {
        try {
            CameraUpdate var1 = new CameraUpdate(method_5319().zoomBy(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static CameraUpdate zoomBy(float var0, Point var1) {
        try {
            CameraUpdate var2 = new CameraUpdate(method_5319().zoomByWithFocus(var0, var1.x, var1.y));
            return var2;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            CameraUpdate var0 = new CameraUpdate(method_5319().zoomIn());
            return var0;
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            CameraUpdate var0 = new CameraUpdate(method_5319().zoomOut());
            return var0;
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public static CameraUpdate zoomTo(float var0) {
        try {
            CameraUpdate var1 = new CameraUpdate(method_5319().zoomTo(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}

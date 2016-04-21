package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_58;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0F;
    public static final float HUE_BLUE = 240.0F;
    public static final float HUE_CYAN = 180.0F;
    public static final float HUE_GREEN = 120.0F;
    public static final float HUE_MAGENTA = 300.0F;
    public static final float HUE_ORANGE = 30.0F;
    public static final float HUE_RED = 0.0F;
    public static final float HUE_ROSE = 330.0F;
    public static final float HUE_VIOLET = 270.0F;
    public static final float HUE_YELLOW = 60.0F;
    private static class_58 ajA;

    // $FF: renamed from: a (com.google.android.gms.maps.model.internal.a) void
    public static void method_5258(class_58 var0) {
        if(ajA == null) {
            ajA = (class_58)class_1090.method_5685(var0);
        }
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            BitmapDescriptor var0 = new BitmapDescriptor(method_5259().method_306());
            return var0;
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public static BitmapDescriptor defaultMarker(float var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_301(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static BitmapDescriptor fromAsset(String var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_302(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_300(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static BitmapDescriptor fromFile(String var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_303(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static BitmapDescriptor fromPath(String var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_304(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public static BitmapDescriptor fromResource(int var0) {
        try {
            BitmapDescriptor var1 = new BitmapDescriptor(method_5259().method_305(var0));
            return var1;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    // $FF: renamed from: mN () com.google.android.gms.maps.model.internal.a
    private static class_58 method_5259() {
        return (class_58)class_1090.method_5681(ajA, "IBitmapDescriptorFactory is not initialized");
    }
}

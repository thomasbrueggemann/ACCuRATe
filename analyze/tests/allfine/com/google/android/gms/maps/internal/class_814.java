package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.maps.internal.class_127;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.u
public class class_814 {
    private static Context ajx;
    private static class_127 ajy;

    // $FF: renamed from: S (android.content.Context) com.google.android.gms.maps.internal.c
    public static class_127 method_4233(Context var0) throws GooglePlayServicesNotAvailableException {
        class_1090.method_5685(var0);
        if(ajy != null) {
            return ajy;
        } else {
            method_4234(var0);
            ajy = method_4235(var0);

            try {
                ajy.method_649(class_1046.method_5437(getRemoteContext(var0).getResources()), 6171000);
            } catch (RemoteException var3) {
                throw new RuntimeRemoteException(var3);
            }

            return ajy;
        }
    }

    // $FF: renamed from: T (android.content.Context) void
    private static void method_4234(Context var0) throws GooglePlayServicesNotAvailableException {
        int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
        switch(var1) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(var1);
        }
    }

    // $FF: renamed from: U (android.content.Context) com.google.android.gms.maps.internal.c
    private static class_127 method_4235(Context var0) {
        if(method_4238()) {
            Log.i(u.class.getSimpleName(), "Making Creator statically");
            return (class_127)method_4237(method_4239());
        } else {
            Log.i(u.class.getSimpleName(), "Making Creator dynamically");
            return class_127.class_1356.method_4423((IBinder)method_4236(getRemoteContext(var0).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
    }

    // $FF: renamed from: a (java.lang.ClassLoader, java.lang.String) java.lang.Object
    private static <T> T method_4236(ClassLoader var0, String var1) {
        try {
            Object var3 = method_4237(((ClassLoader)class_1090.method_5685(var0)).loadClass(var1));
            return var3;
        } catch (ClassNotFoundException var4) {
            throw new IllegalStateException("Unable to find dynamic class " + var1);
        }
    }

    // $FF: renamed from: c (java.lang.Class) java.lang.Object
    private static <T> T method_4237(Class<?> var0) {
        try {
            Object var3 = var0.newInstance();
            return var3;
        } catch (InstantiationException var4) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + var0.getName());
        } catch (IllegalAccessException var5) {
            throw new IllegalStateException("Unable to call the default constructor of " + var0.getName());
        }
    }

    private static Context getRemoteContext(Context var0) {
        if(ajx == null) {
            if(method_4238()) {
                ajx = var0.getApplicationContext();
            } else {
                ajx = GooglePlayServicesUtil.getRemoteContext(var0);
            }
        }

        return ajx;
    }

    // $FF: renamed from: mK () boolean
    private static boolean method_4238() {
        return false;
    }

    // $FF: renamed from: mL () java.lang.Class
    private static Class<?> method_4239() {
        try {
            if(VERSION.SDK_INT < 15) {
                return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
            } else {
                Class var1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
                return var1;
            }
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }
}

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.dynamic.class_216;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_475;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.en
@ez
public final class class_221 extends g<ej> {
    // $FF: renamed from: sK com.google.android.gms.internal.en
    private static final class_221 field_548 = new class_221();

    private class_221() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    // $FF: renamed from: c (android.app.Activity) boolean
    private static boolean method_1519(Activity var0) throws class_221.class_1286 {
        Intent var1 = var0.getIntent();
        if(!var1.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            throw new class_221.class_1286("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        } else {
            return var1.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
    }

    // $FF: renamed from: e (android.app.Activity) com.google.android.gms.internal.ei
    public static class_30 method_1520(Activity var0) {
        try {
            if(method_1519(var0)) {
                class_378.method_2457("Using AdOverlay from the client jar.");
                return new class_475(var0);
            } else {
                class_30 var2 = field_548.method_1521(var0);
                return var2;
            }
        } catch (class_221.class_1286 var3) {
            class_378.method_2461(var3.getMessage());
            return null;
        }
    }

    // $FF: renamed from: f (android.app.Activity) com.google.android.gms.internal.ei
    private class_30 method_1521(Activity var1) {
        try {
            class_206 var4 = class_1046.method_5437(var1);
            class_30 var5 = class_30.class_1156.method_2885(((class_31)this.L(var1)).method_160(var4));
            return var5;
        } catch (RemoteException var6) {
            class_378.method_2465("Could not create remote InAppPurchaseManager.", var6);
            return null;
        } catch (class_216.class_1677 var7) {
            class_378.method_2465("Could not create remote InAppPurchaseManager.", var7);
            return null;
        }
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    // $FF: synthetic method
    protected Object method_1506(IBinder var1) {
        return this.method_1522(var1);
    }

    // $FF: renamed from: y (android.os.IBinder) com.google.android.gms.internal.ej
    protected class_31 method_1522(IBinder var1) {
        return class_31.class_1472.method_4997(var1);
    }

    private static final class class_1286 extends Exception {
        public class_1286(String var1) {
            super(var1);
        }
    }
}

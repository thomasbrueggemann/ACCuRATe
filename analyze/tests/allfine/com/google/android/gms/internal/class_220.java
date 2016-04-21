package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.dynamic.class_216;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dr
@ez
public final class class_220 extends g<dt> {
    // $FF: renamed from: sh com.google.android.gms.internal.dr
    private static final class_220 field_547 = new class_220();

    private class_220() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    // $FF: renamed from: b (android.app.Activity) com.google.android.gms.internal.ds
    public static class_47 method_1515(Activity var0) {
        try {
            if(method_1516(var0)) {
                class_378.method_2457("Using AdOverlay from the client jar.");
                return new class_487(var0);
            } else {
                class_47 var2 = field_547.method_1517(var0);
                return var2;
            }
        } catch (class_220.class_1283 var3) {
            class_378.method_2461(var3.getMessage());
            return null;
        }
    }

    // $FF: renamed from: c (android.app.Activity) boolean
    private static boolean method_1516(Activity var0) throws class_220.class_1283 {
        Intent var1 = var0.getIntent();
        if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            throw new class_220.class_1283("Ad overlay requires the useClientJar flag in intent extras.");
        } else {
            return var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
    }

    // $FF: renamed from: d (android.app.Activity) com.google.android.gms.internal.ds
    private class_47 method_1517(Activity var1) {
        try {
            class_206 var4 = class_1046.method_5437(var1);
            class_47 var5 = class_47.class_1337.method_2975(((class_49)this.L(var1)).method_186(var4));
            return var5;
        } catch (RemoteException var6) {
            class_378.method_2465("Could not create remote AdOverlay.", var6);
            return null;
        } catch (class_216.class_1677 var7) {
            class_378.method_2465("Could not create remote AdOverlay.", var7);
            return null;
        }
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    // $FF: synthetic method
    protected Object method_1506(IBinder var1) {
        return this.method_1518(var1);
    }

    // $FF: renamed from: o (android.os.IBinder) com.google.android.gms.internal.dt
    protected class_49 method_1518(IBinder var1) {
        return class_49.class_1217.method_4746(var1);
    }

    private static final class class_1283 extends Exception {
        public class_1283(String var1) {
            super(var1);
        }
    }
}

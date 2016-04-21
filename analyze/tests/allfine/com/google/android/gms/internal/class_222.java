package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.dynamic.class_216;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.be;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.class_6;
import com.google.android.gms.internal.class_7;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.au
@ez
public final class class_222 extends g<be> {
    // $FF: renamed from: nS com.google.android.gms.internal.au
    private static final class_222 field_549 = new class_222();

    private class_222() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cs) com.google.android.gms.internal.bd
    public static class_7 method_1523(Context var0, class_242 var1, String var2, class_457 var3) {
        Object var4;
        if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) == 0) {
            var4 = field_549.method_1524(var0, var1, var2, var3);
            if(var4 != null) {
                return (class_7)var4;
            }
        }

        class_378.method_2457("Using AdManager from the client jar.");
        var4 = new class_538(var0, var1, var2, var3, new class_379(6171000, 6171000, true));
        return (class_7)var4;
    }

    // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cs) com.google.android.gms.internal.bd
    private class_7 method_1524(Context var1, class_242 var2, String var3, class_457 var4) {
        try {
            class_206 var7 = class_1046.method_5437(var1);
            class_7 var8 = class_7.class_1579.method_3274(((class_6)this.L(var1)).method_12(var7, var2, var3, var4, 6171000));
            return var8;
        } catch (RemoteException var9) {
            class_378.method_2465("Could not create remote AdManager.", var9);
            return null;
        } catch (class_216.class_1677 var10) {
            class_378.method_2465("Could not create remote AdManager.", var10);
            return null;
        }
    }

    // $FF: renamed from: c (android.os.IBinder) com.google.android.gms.internal.be
    protected class_6 method_1525(IBinder var1) {
        return class_6.class_1655.method_6000(var1);
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    // $FF: synthetic method
    protected Object method_1506(IBinder var1) {
        return this.method_1525(var1);
    }
}

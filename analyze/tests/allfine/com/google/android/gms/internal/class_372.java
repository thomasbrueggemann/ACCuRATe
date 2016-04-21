package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_252;
import com.google.android.gms.internal.class_301;
import com.google.android.gms.internal.class_37;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_434;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_449;
import com.google.android.gms.internal.class_467;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.fg
@ez
public abstract class class_372 extends class_370 {
    // $FF: renamed from: pQ com.google.android.gms.internal.fi
    private final class_448 field_1353;
    // $FF: renamed from: tu com.google.android.gms.internal.ff$a
    private final class_449.class_1624 field_1354;

    public class_372(class_448 var1, class_449.class_1624 var2) {
        this.field_1353 = var1;
        this.field_1354 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fm, com.google.android.gms.internal.fi) com.google.android.gms.internal.fk
    private static class_447 method_2427(class_37 var0, class_448 var1) {
        try {
            class_447 var6 = var0.method_166(var1);
            return var6;
        } catch (RemoteException var7) {
            class_378.method_2465("Could not fetch ad response from ad request service.", var7);
            return null;
        } catch (NullPointerException var8) {
            class_378.method_2465("Could not fetch ad response from ad request service due to an Exception.", var8);
            return null;
        } catch (SecurityException var9) {
            class_378.method_2465("Could not fetch ad response from ad request service due to an Exception.", var9);
            return null;
        } catch (Throwable var10) {
            class_389.method_2561(var10);
            return null;
        }
    }

    // $FF: renamed from: cC () void
    public abstract void method_2428();

    // $FF: renamed from: cD () com.google.android.gms.internal.fm
    public abstract class_37 method_2429();

    // $FF: renamed from: co () void
    public final void method_2419() {
        // $FF: Couldn't be decompiled
    }

    public final void onStop() {
        this.method_2428();
    }

    @ez
    public static final class class_1740 extends class_372 {
        private final Context mContext;

        public class_1740(Context var1, class_448 var2, class_449.class_1624 var3) {
            super(var2, var3);
            this.mContext = var1;
        }

        // $FF: renamed from: cC () void
        public void method_2428() {
        }

        // $FF: renamed from: cD () com.google.android.gms.internal.fm
        public class_37 method_2429() {
            Bundle var1 = class_389.method_2553();
            class_252 var2 = new class_252(var1.getString("gads:sdk_core_location"), var1.getString("gads:sdk_core_experiment_id"), var1.getString("gads:block_autoclicks_experiment_id"));
            return class_434.method_2761(this.mContext, var2, new class_467(), new class_439());
        }
    }

    @ez
    public static final class class_1741 extends class_372 implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
        // $FF: renamed from: mw java.lang.Object
        private final Object field_1355 = new Object();
        // $FF: renamed from: tu com.google.android.gms.internal.ff$a
        private final class_449.class_1624 field_1356;
        // $FF: renamed from: tv com.google.android.gms.internal.fh
        private final class_301 field_1357;

        public class_1741(Context var1, class_448 var2, class_449.class_1624 var3) {
            super(var2, var3);
            this.field_1356 = var3;
            this.field_1357 = new class_301(var1, this, this, var2.field_1712.field_1389);
            this.field_1357.connect();
        }

        // $FF: renamed from: cC () void
        public void method_2428() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: cD () com.google.android.gms.internal.fm
        public class_37 method_2429() {
            // $FF: Couldn't be decompiled
        }

        public void onConnected(Bundle var1) {
            this.start();
        }

        public void onConnectionFailed(ConnectionResult var1) {
            this.field_1356.method_888(new class_447(0));
        }

        public void onDisconnected() {
            class_378.method_2457("Disconnected from remote ad request service.");
        }
    }
}

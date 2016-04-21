package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_245;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cf
@ez
public final class class_466 {
    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.cf$b) void
    public static void method_2850(Context var0, class_466.class_1659 var1) {
        if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
            var1.method_1056(class_245.method_1600());
        } else {
            new class_466.class_1658(var0, var1);
        }
    }

    public static final class class_1658 implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
        // $FF: renamed from: mw java.lang.Object
        private final Object field_5331;
        // $FF: renamed from: pN com.google.android.gms.internal.cf$b
        private final class_466.class_1659 field_5332;
        // $FF: renamed from: pO com.google.android.gms.internal.cg
        private final class_300 field_5333;

        public class_1658(Context var1, class_466.class_1659 var2) {
            this(var1, var2, false);
        }

        class_1658(Context var1, class_466.class_1659 var2, boolean var3) {
            this.field_5331 = new Object();
            this.field_5332 = var2;
            this.field_5333 = new class_300(var1, this, this, 6171000);
            if(!var3) {
                this.field_5333.connect();
            }

        }

        public void onConnected(Bundle param1) {
            // $FF: Couldn't be decompiled
        }

        public void onConnectionFailed(ConnectionResult var1) {
            this.field_5332.method_1056(class_245.method_1600());
        }

        public void onDisconnected() {
            class_378.method_2457("Disconnected from remote ad request service.");
        }
    }

    public interface class_1659 {
        // $FF: renamed from: a (android.os.Bundle) void
        void method_1056(Bundle var1);
    }
}

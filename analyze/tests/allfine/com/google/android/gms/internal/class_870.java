package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.class_871;

// $FF: renamed from: com.google.android.gms.internal.nf
public class class_870 implements class_871.class_1815 {
    private final class_871 akD;
    private boolean akE;

    public class_870(Context var1, int var2) {
        this(var1, var2, (String)null);
    }

    public class_870(Context var1, int var2, String var3) {
        this(var1, var2, var3, (String)null, true);
    }

    public class_870(Context var1, int var2, String var3, String var4, boolean var5) {
        this.akD = new class_871(var1, var2, var3, var4, this, var5);
        this.akE = true;
    }

    // $FF: renamed from: mT () void
    private void method_4529() {
        if(!this.akE) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    // $FF: renamed from: a (java.lang.String, byte[], java.lang.String[]) void
    public void method_4530(String var1, byte[] var2, String... var3) {
        this.method_4529();
        this.akD.method_4532(var1, var2, var3);
    }

    // $FF: renamed from: b (android.app.PendingIntent) void
    public void method_1065(PendingIntent var1) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + var1);
    }

    // $FF: renamed from: mU () void
    public void method_1066() {
        this.akD.stop();
    }

    // $FF: renamed from: mV () void
    public void method_1067() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void send() {
        this.method_4529();
        this.akD.start();
        this.akE = false;
    }
}

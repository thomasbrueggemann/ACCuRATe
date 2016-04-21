package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_872;
import com.google.android.gms.internal.class_875;
import com.google.android.gms.internal.class_876;

// $FF: renamed from: com.google.android.gms.internal.ng
public class class_871 {
    private final class_296 akF;
    private class_876 akG;

    public class_871(Context var1, int var2, String var3, String var4, class_871.class_1815 var5, boolean var6) {
        String var7 = var1.getPackageName();

        int var10;
        try {
            var10 = var1.getPackageManager().getPackageInfo(var7, 0).versionCode;
        } catch (NameNotFoundException var11) {
            Log.wtf("PlayLogger", "This can\'t happen.");
            var10 = 0;
        }

        this.akG = new class_876(var7, var10, var2, var3, var4, var6);
        this.akF = new class_296(var1, new class_875(var5));
    }

    // $FF: renamed from: a (long, java.lang.String, byte[], java.lang.String[]) void
    public void method_4531(long var1, String var3, byte[] var4, String... var5) {
        this.akF.method_1868(this.akG, new class_872(var1, var3, var4, var5));
    }

    // $FF: renamed from: b (java.lang.String, byte[], java.lang.String[]) void
    public void method_4532(String var1, byte[] var2, String... var3) {
        this.method_4531(System.currentTimeMillis(), var1, var2, var3);
    }

    public void start() {
        this.akF.start();
    }

    public void stop() {
        this.akF.stop();
    }

    public interface class_1815 {
        // $FF: renamed from: b (android.app.PendingIntent) void
        void method_1065(PendingIntent var1);

        // $FF: renamed from: mU () void
        void method_1066();

        // $FF: renamed from: mV () void
        void method_1067();
    }
}

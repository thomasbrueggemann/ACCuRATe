package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import com.google.android.gms.analytics.class_938;
import java.io.File;

// $FF: renamed from: com.google.android.gms.analytics.o
class class_933 {
    // $FF: renamed from: ag (java.lang.String) boolean
    static boolean method_4840(String var0) {
        if(version() < 9) {
            return false;
        } else {
            File var1 = new File(var0);
            var1.setReadable(false, false);
            var1.setWritable(false, false);
            var1.setReadable(true, true);
            var1.setWritable(true, true);
            return true;
        }
    }

    public static int version() {
        try {
            int var1 = Integer.parseInt(VERSION.SDK);
            return var1;
        } catch (NumberFormatException var2) {
            class_938.method_4858("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}

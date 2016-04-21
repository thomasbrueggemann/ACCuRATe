package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import com.google.analytics.tracking.android.Log;
import java.io.File;

class FutureApis {
    static boolean setOwnerOnlyReadWrite(String var0) {
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
            Log.method_2104("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}

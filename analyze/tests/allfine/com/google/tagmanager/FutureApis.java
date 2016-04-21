package com.google.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.tagmanager.Log;
import java.io.File;

class FutureApis {
    @TargetApi(9)
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
            Log.method_5503("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}

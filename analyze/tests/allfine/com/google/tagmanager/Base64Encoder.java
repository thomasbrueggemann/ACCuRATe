package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Base64;

class Base64Encoder {
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int URL_SAFE = 2;

    public static byte[] decode(String var0, int var1) {
        boolean var2 = true;
        if(getSdkVersion() >= 8) {
            int var4 = 2;
            if((var1 & 1) != 0) {
                var4 |= 1;
            }

            if((var1 & 2) != 0) {
                var4 |= 8;
            }

            return android.util.Base64.decode(var0, var4);
        } else {
            if((var1 & 1) == 0) {
                ;
            }

            if((var1 & 2) == 0) {
                var2 = false;
            }

            return var2?Base64.decodeWebSafe(var0):Base64.decode(var0);
        }
    }

    public static String encodeToString(byte[] var0, int var1) {
        boolean var2 = true;
        if(getSdkVersion() >= 8) {
            int var4 = 2;
            if((var1 & 1) != 0) {
                var4 |= 1;
            }

            if((var1 & 2) != 0) {
                var4 |= 8;
            }

            return android.util.Base64.encodeToString(var0, var4);
        } else {
            boolean var3;
            if((var1 & 1) == 0) {
                var3 = var2;
            } else {
                var3 = false;
            }

            if((var1 & 2) == 0) {
                var2 = false;
            }

            return var2?Base64.encodeWebSafe(var0, var3):Base64.encode(var0, var3);
        }
    }

    @VisibleForTesting
    static int getSdkVersion() {
        return VERSION.SDK_INT;
    }
}

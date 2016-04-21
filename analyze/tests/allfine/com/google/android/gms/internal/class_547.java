package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.class_532;
import com.google.android.gms.internal.class_541;
import com.google.android.gms.internal.class_546;
import com.google.android.gms.internal.class_66;
import com.google.android.gms.internal.class_67;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.j
public class class_547 extends class_546 {
    protected class_547(Context var1, class_66 var2, class_67 var3) {
        super(var1, var2, var3);
    }

    // $FF: renamed from: a (java.lang.String, android.content.Context) com.google.android.gms.internal.j
    public static class_547 method_3348(String var0, Context var1) {
        class_532 var2 = new class_532();
        a(var0, var1, var2);
        return new class_547(var1, var2, new class_541(239));
    }

    // $FF: renamed from: b (android.content.Context) void
    protected void method_3333(Context param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: h (android.content.Context) com.google.android.gms.internal.j$a
    class_547.class_1788 method_3349(Context var1) throws IOException, GooglePlayServicesNotAvailableException {
        int var2 = 0;

        AdvertisingIdClient.Info var5;
        try {
            var5 = AdvertisingIdClient.getAdvertisingIdInfo(var1);
        } catch (GooglePlayServicesRepairableException var10) {
            throw new IOException(var10);
        } catch (SecurityException var11) {
            throw new IOException(var11);
        }

        String var6 = var5.getId();
        String var7;
        if(var6 != null && var6.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
            byte[] var8 = new byte[16];

            for(int var9 = 0; var2 < var6.length(); var2 += 2) {
                if(var2 == 8 || var2 == 13 || var2 == 18 || var2 == 23) {
                    ++var2;
                }

                var8[var9] = (byte)((Character.digit(var6.charAt(var2), 16) << 4) + Character.digit(var6.charAt(var2 + 1), 16));
                ++var9;
            }

            var7 = this.ky.method_319(var8, true);
        } else {
            var7 = var6;
        }

        return new class_547.class_1788(var7, var5.isLimitAdTrackingEnabled());
    }

    class class_1788 {
        // $FF: renamed from: kO java.lang.String
        private String field_5041;
        // $FF: renamed from: kP boolean
        private boolean field_5042;

        public class_1788(String var2, boolean var3) {
            this.field_5041 = var2;
            this.field_5042 = var3;
        }

        public String getId() {
            return this.field_5041;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.field_5042;
        }
    }
}

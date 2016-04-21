package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.analytics.class_178;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_953;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.analytics.a
class class_935 implements class_178 {
    // $FF: renamed from: xA com.google.android.gms.analytics.a
    private static class_935 field_4283;
    // $FF: renamed from: xz java.lang.Object
    private static Object field_4284 = new Object();
    private Context mContext;
    // $FF: renamed from: xB com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
    private AdvertisingIdClient.Info field_4285;
    // $FF: renamed from: xC long
    private long field_4286;
    // $FF: renamed from: xD java.lang.String
    private String field_4287;
    // $FF: renamed from: xE boolean
    private boolean field_4288 = false;
    // $FF: renamed from: xF java.lang.Object
    private Object field_4289 = new Object();

    class_935(Context var1) {
        this.mContext = var1.getApplicationContext();
    }

    // $FF: renamed from: a (com.google.android.gms.ads.identifier.AdvertisingIdClient$Info, com.google.android.gms.ads.identifier.AdvertisingIdClient$Info) boolean
    private boolean method_4843(AdvertisingIdClient.Info param1, AdvertisingIdClient.Info param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aa (java.lang.String) java.lang.String
    static String method_4844(String var0) {
        MessageDigest var1 = class_953.method_5026("MD5");
        if(var1 == null) {
            return null;
        } else {
            Locale var2 = Locale.US;
            Object[] var3 = new Object[] {new BigInteger(1, var1.digest(var0.getBytes()))};
            return String.format(var2, "%032X", var3);
        }
    }

    // $FF: renamed from: ab (java.lang.String) boolean
    private boolean method_4845(String var1) {
        try {
            String var4 = method_4844(var1);
            class_938.method_4860("Storing hashed adid.");
            FileOutputStream var5 = this.mContext.openFileOutput("gaClientIdData", 0);
            var5.write(var4.getBytes());
            var5.close();
            this.field_4287 = var4;
            return true;
        } catch (FileNotFoundException var6) {
            class_938.method_4858("Error creating hash file.");
            return false;
        } catch (IOException var7) {
            class_938.method_4858("Error writing to hash file.");
            return false;
        }
    }

    // $FF: renamed from: w (android.content.Context) com.google.android.gms.analytics.l
    public static class_178 method_4846(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: x (android.content.Context) java.lang.String
    static String method_4847(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dG () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
    AdvertisingIdClient.Info method_4848() {
        try {
            AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
            return var6;
        } catch (IllegalStateException var7) {
            class_938.method_4861("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added \'<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (GooglePlayServicesRepairableException var8) {
            class_938.method_4861("GooglePlayServicesRepairableException getting Ad Id Info");
            return null;
        } catch (IOException var9) {
            class_938.method_4861("IOException getting Ad Id Info");
            return null;
        } catch (GooglePlayServicesNotAvailableException var10) {
            class_938.method_4861("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return null;
        } catch (Throwable var11) {
            class_938.method_4861("Unknown exception. Could not get the ad Id.");
            return null;
        }
    }

    public String getValue(String var1) {
        long var2 = System.currentTimeMillis();
        if(var2 - this.field_4286 > 1000L) {
            AdvertisingIdClient.Info var4 = this.method_4848();
            if(this.method_4843(this.field_4285, var4)) {
                this.field_4285 = var4;
            } else {
                this.field_4285 = new AdvertisingIdClient.Info("", false);
            }

            this.field_4286 = var2;
        }

        if(this.field_4285 != null) {
            if("&adid".equals(var1)) {
                return this.field_4285.getId();
            }

            if("&ate".equals(var1)) {
                if(this.field_4285.isLimitAdTrackingEnabled()) {
                    return "0";
                }

                return "1";
            }
        }

        return null;
    }
}

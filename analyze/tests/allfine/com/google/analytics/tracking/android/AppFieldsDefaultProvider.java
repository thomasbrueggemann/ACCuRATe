package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.DefaultProvider;
import com.google.android.gms.common.util.VisibleForTesting;

class AppFieldsDefaultProvider implements DefaultProvider {
    private static AppFieldsDefaultProvider sInstance;
    private static Object sInstanceLock = new Object();
    protected String mAppId;
    protected String mAppInstallerId;
    protected String mAppName;
    protected String mAppVersion;

    @VisibleForTesting
    protected AppFieldsDefaultProvider() {
    }

    private AppFieldsDefaultProvider(Context param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    static void dropInstance() {
        // $FF: Couldn't be decompiled
    }

    public static AppFieldsDefaultProvider getProvider() {
        return sInstance;
    }

    public static void initializeProvider(Context param0) {
        // $FF: Couldn't be decompiled
    }

    public String getValue(String var1) {
        if(var1 != null) {
            if(var1.equals("&an")) {
                return this.mAppName;
            }

            if(var1.equals("&av")) {
                return this.mAppVersion;
            }

            if(var1.equals("&aid")) {
                return this.mAppId;
            }

            if(var1.equals("&aiid")) {
                return this.mAppInstallerId;
            }
        }

        return null;
    }

    public boolean providesField(String var1) {
        return "&an".equals(var1) || "&av".equals(var1) || "&aid".equals(var1) || "&aiid".equals(var1);
    }
}

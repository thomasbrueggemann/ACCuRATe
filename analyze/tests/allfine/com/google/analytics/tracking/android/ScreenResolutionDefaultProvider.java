package com.google.analytics.tracking.android;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.analytics.tracking.android.DefaultProvider;
import com.google.android.gms.common.util.VisibleForTesting;

class ScreenResolutionDefaultProvider implements DefaultProvider {
    private static ScreenResolutionDefaultProvider sInstance;
    private static Object sInstanceLock = new Object();
    private final Context mContext;

    @VisibleForTesting
    protected ScreenResolutionDefaultProvider(Context var1) {
        this.mContext = var1;
    }

    @VisibleForTesting
    static void dropInstance() {
        // $FF: Couldn't be decompiled
    }

    public static ScreenResolutionDefaultProvider getProvider() {
        // $FF: Couldn't be decompiled
    }

    public static void initializeProvider(Context param0) {
        // $FF: Couldn't be decompiled
    }

    protected String getScreenResolutionString() {
        DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
        return var1.widthPixels + "x" + var1.heightPixels;
    }

    public String getValue(String var1) {
        return var1 != null && var1.equals("&sr")?this.getScreenResolutionString():null;
    }

    public boolean providesField(String var1) {
        return "&sr".equals(var1);
    }
}

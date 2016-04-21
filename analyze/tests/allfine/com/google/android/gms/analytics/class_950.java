package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.analytics.class_178;

// $FF: renamed from: com.google.android.gms.analytics.ad
class class_950 implements class_178 {
    // $FF: renamed from: Bi com.google.android.gms.analytics.ad
    private static class_950 field_4454;
    // $FF: renamed from: xz java.lang.Object
    private static Object field_4455 = new Object();
    private final Context mContext;

    protected class_950(Context var1) {
        this.mContext = var1;
    }

    // $FF: renamed from: eQ () com.google.android.gms.analytics.ad
    public static class_950 method_4998() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: y (android.content.Context) void
    public static void method_4999(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ac (java.lang.String) boolean
    public boolean method_5000(String var1) {
        return "&sr".equals(var1);
    }

    // $FF: renamed from: eR () java.lang.String
    protected String method_5001() {
        DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
        return var1.widthPixels + "x" + var1.heightPixels;
    }

    public String getValue(String var1) {
        return var1 != null && var1.equals("&sr")?this.method_5001():null;
    }
}

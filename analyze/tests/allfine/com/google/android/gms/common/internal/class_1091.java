package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;

// $FF: renamed from: com.google.android.gms.common.internal.h
public class class_1091 {
    // $FF: renamed from: Md android.net.Uri
    private static final Uri field_5129 = Uri.parse("http://plus.google.com/");
    // $FF: renamed from: Me android.net.Uri
    private static final Uri field_5130;

    static {
        field_5130 = field_5129.buildUpon().appendPath("circles").appendPath("find").build();
    }

    // $FF: renamed from: aW (java.lang.String) android.content.Intent
    public static Intent method_5686(String var0) {
        Uri var1 = Uri.fromParts("package", var0, (String)null);
        Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        var2.setData(var1);
        return var2;
    }

    // $FF: renamed from: aX (java.lang.String) android.net.Uri
    private static Uri method_5687(String var0) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
    }

    // $FF: renamed from: aY (java.lang.String) android.content.Intent
    public static Intent method_5688(String var0) {
        Intent var1 = new Intent("android.intent.action.VIEW");
        var1.setData(method_5687(var0));
        var1.setPackage("com.android.vending");
        var1.addFlags(524288);
        return var1;
    }

    // $FF: renamed from: gZ () android.content.Intent
    public static Intent method_5689() {
        Intent var0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        var0.setPackage("com.google.android.wearable.app");
        return var0;
    }
}

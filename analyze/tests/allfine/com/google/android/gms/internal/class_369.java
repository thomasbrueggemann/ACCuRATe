package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.class_387;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gp
@ez
public final class class_369 {
    // $FF: renamed from: a (android.content.Context, android.webkit.WebSettings) void
    public static void method_2417(Context var0, WebSettings var1) {
        class_387.method_2539(var0, var1);
        var1.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context var0) {
        return WebSettings.getDefaultUserAgent(var0);
    }
}

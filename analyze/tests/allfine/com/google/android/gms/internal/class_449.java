package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_372;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ff
@ez
public final class class_449 {
    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.fi, com.google.android.gms.internal.ff$a) com.google.android.gms.internal.gg
    public static class_370 method_2804(Context var0, class_448 var1, class_449.class_1624 var2) {
        return var1.field_1712.field_1390?method_2805(var0, var1, var2):method_2806(var0, var1, var2);
    }

    // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.fi, com.google.android.gms.internal.ff$a) com.google.android.gms.internal.gg
    private static class_370 method_2805(Context var0, class_448 var1, class_449.class_1624 var2) {
        class_378.method_2457("Fetching ad response from local ad request service.");
        class_372.class_1740 var3 = new class_372.class_1740(var0, var1, var2);
        var3.start();
        return var3;
    }

    // $FF: renamed from: c (android.content.Context, com.google.android.gms.internal.fi, com.google.android.gms.internal.ff$a) com.google.android.gms.internal.gg
    private static class_370 method_2806(Context var0, class_448 var1, class_449.class_1624 var2) {
        class_378.method_2457("Fetching ad response from remote ad request service.");
        if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
            class_378.method_2461("Failed to connect to remote ad request service.");
            return null;
        } else {
            return new class_372.class_1741(var0, var1, var2);
        }
    }

    public interface class_1624 {
        // $FF: renamed from: a (com.google.android.gms.internal.fk) void
        void method_888(class_447 var1);
    }
}

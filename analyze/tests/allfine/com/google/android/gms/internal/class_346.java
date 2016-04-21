package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.jw;

// $FF: renamed from: com.google.android.gms.internal.jw
public final class class_346 implements class_20 {
    // $FF: renamed from: MS com.google.android.gms.internal.jw
    private static class_346 field_1208;

    // $FF: renamed from: hA () com.google.android.gms.internal.ju
    public static class_20 method_2326() {
        synchronized(jw.class) {}

        class_346 var1;
        try {
            if(field_1208 == null) {
                field_1208 = new class_346();
            }

            var1 = field_1208;
        } finally {
            ;
        }

        return var1;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}

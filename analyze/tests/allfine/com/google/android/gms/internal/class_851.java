package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.kj
public class class_851 {
    // $FF: renamed from: Sv java.util.List
    private static final List<TimeUnit> field_4152;

    static {
        TimeUnit[] var0 = new TimeUnit[] {TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS};
        field_4152 = Arrays.asList(var0);
    }

    // $FF: renamed from: a (long, java.util.concurrent.TimeUnit, java.util.concurrent.TimeUnit) long
    public static long method_4489(long var0, TimeUnit var2, TimeUnit var3) {
        return var2.convert(var3.convert(var0, var2), var3);
    }

    // $FF: renamed from: a (java.util.concurrent.TimeUnit) boolean
    public static boolean method_4490(TimeUnit var0) {
        return method_4491(var0, TimeUnit.MILLISECONDS);
    }

    // $FF: renamed from: a (java.util.concurrent.TimeUnit, java.util.concurrent.TimeUnit) boolean
    private static boolean method_4491(TimeUnit var0, TimeUnit var1) {
        return field_4152.indexOf(var0) < field_4152.indexOf(var1);
    }
}

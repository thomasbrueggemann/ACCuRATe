package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.internal.class_325;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.iv;

// $FF: renamed from: com.google.android.gms.internal.bn
@ez
public final class class_245 {
    // $FF: renamed from: oX com.google.android.gms.internal.iv
    public static iv<String> field_649 = method_1599("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    // $FF: renamed from: oY com.google.android.gms.internal.iv
    public static iv<String> field_650 = method_1599("gads:sdk_core_experiment_id", (String)null);
    // $FF: renamed from: oZ com.google.android.gms.internal.iv
    public static iv<Boolean> field_651 = method_1601("gads:sdk_crash_report_enabled", false);
    // $FF: renamed from: pa com.google.android.gms.internal.iv
    public static iv<Boolean> field_652 = method_1601("gads:sdk_crash_report_full_stacktrace", false);
    // $FF: renamed from: pb com.google.android.gms.internal.iv
    public static iv<Boolean> field_653 = method_1601("gads:block_autoclicks", false);
    // $FF: renamed from: pc com.google.android.gms.internal.iv
    public static iv<String> field_654 = method_1599("gads:block_autoclicks_experiment_id", (String)null);
    // $FF: renamed from: pd com.google.android.gms.internal.iv
    public static iv<Boolean> field_655;
    // $FF: renamed from: pe com.google.android.gms.internal.iv
    public static iv<Integer> field_656;
    // $FF: renamed from: pf com.google.android.gms.internal.iv
    public static iv<Integer> field_657;
    // $FF: renamed from: pg com.google.android.gms.internal.iv
    public static iv<Integer> field_658;
    // $FF: renamed from: ph com.google.android.gms.internal.iv
    public static iv<Integer> field_659;
    // $FF: renamed from: pi com.google.android.gms.internal.iv
    public static iv<Integer> field_660;
    // $FF: renamed from: pj android.os.Bundle
    private static final Bundle field_661 = new Bundle();
    // $FF: renamed from: pk boolean
    private static boolean field_662 = false;

    static {
        field_662 = true;
        field_655 = method_1601("gads:enable_content_fetching", false);
        field_656 = method_1598("gads:content_length_weight", 1);
        field_657 = method_1598("gads:content_age_weight", 1);
        field_658 = method_1598("gads:min_content_len", 11);
        field_659 = method_1598("gads:fingerprint_number", 10);
        field_660 = method_1598("gads:sleep_sec", 10);
    }

    // $FF: renamed from: a (java.lang.String, int) com.google.android.gms.internal.iv
    private static iv<Integer> method_1598(String var0, int var1) {
        field_661.putInt(var0, var1);
        return class_325.method_2239(var0, Integer.valueOf(var1));
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) com.google.android.gms.internal.iv
    private static iv<String> method_1599(String var0, String var1) {
        field_661.putString(var0, var1);
        return class_325.method_2241(var0, var1);
    }

    // $FF: renamed from: bs () android.os.Bundle
    public static Bundle method_1600() {
        return field_661;
    }

    // $FF: renamed from: c (java.lang.String, boolean) com.google.android.gms.internal.iv
    private static iv<Boolean> method_1601(String var0, boolean var1) {
        field_661.putBoolean(var0, var1);
        return class_325.method_2240(var0, var1);
    }
}

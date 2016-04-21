package com.google.android.gms.tagmanager;

import android.net.Uri;

// $FF: renamed from: com.google.android.gms.tagmanager.ce
class class_618 {
    private static class_618 aqd;
    private volatile String aoc;
    private volatile class_618.class_1772 aqe;
    private volatile String aqf;
    private volatile String aqg;

    class_618() {
        this.clear();
    }

    // $FF: renamed from: cI (java.lang.String) java.lang.String
    private String method_3488(String var1) {
        return var1.split("&")[0].split("=")[1];
    }

    // $FF: renamed from: j (android.net.Uri) java.lang.String
    private String method_3489(Uri var1) {
        return var1.getQuery().replace("&gtm_debug=x", "");
    }

    // $FF: renamed from: oJ () com.google.android.gms.tagmanager.ce
    static class_618 method_3490() {
        // $FF: Couldn't be decompiled
    }

    void clear() {
        this.aqe = class_618.class_1772.aqh;
        this.aqf = null;
        this.aoc = null;
        this.aqg = null;
    }

    String getContainerId() {
        return this.aoc;
    }

    // $FF: renamed from: i (android.net.Uri) boolean
    boolean method_3491(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: oK () com.google.android.gms.tagmanager.ce$a
    class_618.class_1772 method_3492() {
        return this.aqe;
    }

    // $FF: renamed from: oL () java.lang.String
    String method_3493() {
        return this.aqf;
    }

    static enum class_1772 {
        aqh,
        aqi,
        aqj;

        static {
            class_618.class_1772[] var0 = new class_618.class_1772[]{aqh, aqi, aqj};
        }
    }
}

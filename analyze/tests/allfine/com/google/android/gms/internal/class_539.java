package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.v
@ez
public class class_539 {
    // $FF: renamed from: lZ com.google.android.gms.internal.v$a
    private class_539.class_1577 field_2883;
    // $FF: renamed from: ma boolean
    private boolean field_2884;
    // $FF: renamed from: mb boolean
    private boolean field_2885;

    public class_539() {
        Bundle var1 = class_389.method_2553();
        boolean var2 = false;
        if(var1 != null) {
            boolean var3 = var1.getBoolean("gads:block_autoclicks", false);
            var2 = false;
            if(var3) {
                var2 = true;
            }
        }

        this.field_2885 = var2;
    }

    public class_539(boolean var1) {
        this.field_2885 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.v$a) void
    public void method_3296(class_539.class_1577 var1) {
        this.field_2883 = var1;
    }

    // $FF: renamed from: ar () void
    public void method_3297() {
        this.field_2884 = true;
    }

    // $FF: renamed from: av () boolean
    public boolean method_3298() {
        return !this.field_2885 || this.field_2884;
    }

    // $FF: renamed from: d (java.lang.String) void
    public void method_3299(String var1) {
        class_378.method_2457("Action was blocked because no click was detected.");
        if(this.field_2883 != null) {
            this.field_2883.method_387(var1);
        }

    }

    public interface class_1577 {
        // $FF: renamed from: e (java.lang.String) void
        void method_387(String var1);
    }

    @ez
    public static class class_1578 implements class_539.class_1577 {
        // $FF: renamed from: mc com.google.android.gms.internal.fz$a
        private final class_438.class_1623 field_3470;
        // $FF: renamed from: md com.google.android.gms.internal.gv
        private final class_381 field_3471;

        public class_1578(class_438.class_1623 var1, class_381 var2) {
            this.field_3470 = var1;
            this.field_3471 = var2;
        }

        // $FF: renamed from: e (java.lang.String) void
        public void method_387(String var1) {
            class_378.method_2457("An auto-clicking creative is blocked");
            Builder var2 = new Builder();
            var2.scheme("https");
            var2.path("//pagead2.googlesyndication.com/pagead/gen_204");
            var2.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if(!TextUtils.isEmpty(var1)) {
                var2.appendQueryParameter("navigationURL", var1);
            }

            if(this.field_3470 != null && this.field_3470.field_5210 != null && !TextUtils.isEmpty(this.field_3470.field_5210.field_1704)) {
                var2.appendQueryParameter("debugDialog", this.field_3470.field_5210.field_1704);
            }

            class_383.method_2522(this.field_3471.getContext(), this.field_3471.method_2489().field_1387, var2.toString());
        }
    }
}

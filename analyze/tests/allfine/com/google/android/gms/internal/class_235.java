package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_539;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.aj
@ez
public class class_235 implements class_0 {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_597;

    public class_235(Context var1, class_379 var2) {
        this.field_597 = class_381.method_2470(var1, new class_242(), false, false, (class_548)null, var2);
    }

    private void runOnUiThread(Runnable var1) {
        if(class_377.method_2455()) {
            var1.run();
        } else {
            class_377.field_1386.post(var1);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ah$a) void
    public void method_0(final class_0.class_1657 var1) {
        this.field_597.method_2486().method_2397(new class_364.class_1738() {
            // $FF: renamed from: a (com.google.android.gms.internal.gv) void
            public void method_831(class_381 var1x) {
                var1.method_719();
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.dn, com.google.android.gms.internal.bw, com.google.android.gms.internal.dq, boolean, com.google.android.gms.internal.bz) void
    public void method_1(class_63 var1, class_46 var2, class_8 var3, class_48 var4, boolean var5, class_42 var6) {
        this.field_597.method_2486().method_2399(var1, var2, var3, var4, var5, var6, new class_539(false));
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.by) void
    public void method_2(String var1, class_9 var2) {
        this.field_597.method_2486().method_2400(var1, var2);
    }

    // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
    public void method_3(final String var1, final JSONObject var2) {
        this.runOnUiThread(new Runnable() {
            public void run() {
                class_235.this.field_597.method_2480(var1, var2);
            }
        });
    }

    public void destroy() {
        this.field_597.destroy();
    }

    // $FF: renamed from: f (java.lang.String) void
    public void method_4(final String var1) {
        this.runOnUiThread(new Runnable() {
            public void run() {
                class_235.this.field_597.loadUrl(var1);
            }
        });
    }

    // $FF: renamed from: g (java.lang.String) void
    public void method_5(String var1) {
        this.field_597.method_2486().method_2400(var1, (class_9)null);
    }

    public void pause() {
        class_383.method_2513(this.field_597);
    }

    public void resume() {
        class_383.method_2518(this.field_597);
    }
}

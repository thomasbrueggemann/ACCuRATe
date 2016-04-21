package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.class_230;
import com.google.android.gms.internal.class_232;
import com.google.android.gms.internal.class_233;
import com.google.android.gms.internal.class_245;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_420;
import com.google.android.gms.internal.class_854;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.an
@ez
public class class_231 extends Thread {
    private boolean mStarted = false;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_572;
    // $FF: renamed from: nf int
    private final int field_573;
    // $FF: renamed from: nh int
    private final int field_574;
    // $FF: renamed from: ns boolean
    private boolean field_575 = false;
    // $FF: renamed from: nt boolean
    private boolean field_576 = false;
    // $FF: renamed from: nu com.google.android.gms.internal.am
    private final class_230 field_577;
    // $FF: renamed from: nv com.google.android.gms.internal.al
    private final class_233 field_578;
    // $FF: renamed from: nw com.google.android.gms.internal.ey
    private final class_420 field_579;
    // $FF: renamed from: nx int
    private final int field_580;
    // $FF: renamed from: ny int
    private final int field_581;
    // $FF: renamed from: nz int
    private final int field_582;

    public class_231(class_230 var1, class_233 var2, Bundle var3, class_420 var4) {
        this.field_577 = var1;
        this.field_578 = var2;
        this.field_579 = var4;
        this.field_572 = new Object();
        this.field_573 = var3.getInt(class_245.field_656.getKey());
        this.field_581 = var3.getInt(class_245.field_657.getKey());
        this.field_574 = var3.getInt(class_245.field_658.getKey());
        this.field_582 = var3.getInt(class_245.field_659.getKey());
        this.field_580 = var3.getInt(class_245.field_660.getKey(), 10);
        this.setName("ContentFetchTask");
    }

    // $FF: renamed from: a (android.app.Activity) void
    private void method_1544(Activity var1) {
        if(var1 != null) {
            Window var2 = var1.getWindow();
            View var3 = null;
            if(var2 != null) {
                View var5 = var1.getWindow().getDecorView();
                var3 = null;
                if(var5 != null) {
                    var3 = var1.getWindow().getDecorView().findViewById(16908290);
                }
            }

            if(var3 != null) {
                this.method_1553(var3);
                return;
            }
        }

    }

    // $FF: renamed from: a (android.webkit.WebView, com.google.android.gms.internal.ak) boolean
    private boolean method_1545(final WebView var1, final class_232 var2) {
        if(!class_854.method_4500()) {
            return false;
        } else {
            var2.method_1562();
            var1.post(new Runnable() {
                // $FF: renamed from: nC android.webkit.ValueCallback
                ValueCallback<String> field_4800 = new ValueCallback() {
                    // $FF: renamed from: k (java.lang.String) void
                    public void method_6007(String var1x) {
                        class_231.this.method_1548(var2, var1, var1x);
                    }

                    // $FF: synthetic method
                    public void onReceiveValue(Object var1x) {
                        this.method_6007((String)var1x);
                    }
                };

                public void run() {
                    if(var1.getSettings().getJavaScriptEnabled()) {
                        var1.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.field_4800);
                    }

                }
            });
            return true;
        }
    }

    // $FF: renamed from: aW () boolean
    private boolean method_1546() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.view.View, com.google.android.gms.internal.ak) com.google.android.gms.internal.an$a
    class_231.class_1287 method_1547(View var1, class_232 var2) {
        int var3 = 0;
        if(var1 == null) {
            return new class_231.class_1287(0, 0);
        } else if(var1 instanceof TextView && !(var1 instanceof EditText)) {
            var2.method_1567(((TextView)var1).getText().toString());
            return new class_231.class_1287(1, 0);
        } else if(var1 instanceof WebView && !(var1 instanceof class_381)) {
            var2.method_1562();
            return this.method_1545((WebView)var1, var2)?new class_231.class_1287(0, 1):new class_231.class_1287(0, 0);
        } else if(!(var1 instanceof ViewGroup)) {
            return new class_231.class_1287(0, 0);
        } else {
            ViewGroup var4 = (ViewGroup)var1;
            int var5 = 0;

            int var6;
            for(var6 = 0; var3 < var4.getChildCount(); ++var3) {
                class_231.class_1287 var7 = this.method_1547(var4.getChildAt(var3), var2);
                var6 += var7.field_4792;
                var5 += var7.field_4793;
            }

            return new class_231.class_1287(var6, var5);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ak, android.webkit.WebView, java.lang.String) void
    void method_1548(class_232 param1, WebView param2, String param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aV () void
    public void method_1549() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aX () com.google.android.gms.internal.ak
    public class_232 method_1550() {
        return this.field_578.method_1569();
    }

    // $FF: renamed from: aY () void
    public void method_1551() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aZ () boolean
    public boolean method_1552() {
        return this.field_575;
    }

    // $FF: renamed from: g (android.view.View) boolean
    boolean method_1553(final View var1) {
        if(var1 == null) {
            return false;
        } else {
            var1.post(new Runnable() {
                public void run() {
                    class_231.this.method_1554(var1);
                }
            });
            return true;
        }
    }

    // $FF: renamed from: h (android.view.View) void
    void method_1554(View var1) {
        try {
            class_232 var2 = new class_232(this.field_573, this.field_581, this.field_574, this.field_582);
            class_231.class_1287 var4 = this.method_1547(var1, var2);
            var2.method_1563();
            if(var4.field_4792 == 0 && var4.field_4793 == 0) {
                return;
            }

            if((var4.field_4793 != 0 || var2.method_1564() != 0) && (var4.field_4793 != 0 || !this.field_578.method_1568(var2))) {
                this.field_578.method_1571(var2);
                return;
            }
        } catch (Exception var5) {
            class_378.method_2463("Exception in fetchContentOnUIThread", var5);
            this.field_579.method_2677(var5);
        }

    }

    public void run() {
        // $FF: Couldn't be decompiled
    }

    public void wakeup() {
        // $FF: Couldn't be decompiled
    }

    @ez
    class class_1287 {
        // $FF: renamed from: nG int
        final int field_4792;
        // $FF: renamed from: nH int
        final int field_4793;

        class_1287(int var2, int var3) {
            this.field_4792 = var2;
            this.field_4793 = var3;
        }
    }
}

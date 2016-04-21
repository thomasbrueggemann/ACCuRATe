package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_387;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_468;
import com.google.android.gms.internal.class_469;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_471;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dk
@ez
public class class_487 extends class_47.class_1337 {
    // $FF: renamed from: ru int
    private static final int field_1961 = Color.argb(0, 0, 0, 0);
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private class_381 field_1962;
    // $FF: renamed from: nr android.app.Activity
    private final Activity field_1963;
    // $FF: renamed from: rA boolean
    private boolean field_1964 = false;
    // $FF: renamed from: rB android.widget.FrameLayout
    private FrameLayout field_1965;
    // $FF: renamed from: rC android.webkit.WebChromeClient.CustomViewCallback
    private CustomViewCallback field_1966;
    // $FF: renamed from: rD boolean
    private boolean field_1967 = false;
    // $FF: renamed from: rE boolean
    private boolean field_1968 = false;
    // $FF: renamed from: rF boolean
    private boolean field_1969 = false;
    // $FF: renamed from: rG android.widget.RelativeLayout
    private RelativeLayout field_1970;
    // $FF: renamed from: rv com.google.android.gms.internal.dm
    private class_469 field_1971;
    // $FF: renamed from: rw com.google.android.gms.internal.do
    private class_468 field_1972;
    // $FF: renamed from: rx com.google.android.gms.internal.dk$c
    private class_487.class_1612 field_1973;
    // $FF: renamed from: ry com.google.android.gms.internal.dp
    private class_471 field_1974;
    // $FF: renamed from: rz boolean
    private boolean field_1975;

    public class_487(Activity var1) {
        this.field_1963 = var1;
    }

    // $FF: renamed from: a (int, int, int, int) android.widget.RelativeLayout.LayoutParams
    private static LayoutParams method_2976(int var0, int var1, int var2, int var3) {
        LayoutParams var4 = new LayoutParams(var2, var3);
        var4.setMargins(var0, var1, 0, 0);
        var4.addRule(10);
        var4.addRule(9);
        return var4;
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.dm) void
    public static void method_2977(Context var0, class_469 var1) {
        Intent var2 = new Intent();
        var2.setClassName(var0, "com.google.android.gms.ads.AdActivity");
        var2.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", var1.field_1802.field_1390);
        class_469.method_2860(var2, var1);
        var2.addFlags(524288);
        if(!(var0 instanceof Activity)) {
            var2.addFlags(268435456);
        }

        var0.startActivity(var2);
    }

    // $FF: renamed from: U () void
    public void method_184() {
        this.field_1975 = true;
    }

    // $FF: renamed from: a (android.view.View, android.webkit.WebChromeClient.CustomViewCallback) void
    public void method_2978(View var1, CustomViewCallback var2) {
        this.field_1965 = new FrameLayout(this.field_1963);
        this.field_1965.setBackgroundColor(-16777216);
        this.field_1965.addView(var1, -1, -1);
        this.field_1963.setContentView(this.field_1965);
        this.method_184();
        this.field_1966 = var2;
        this.field_1964 = true;
    }

    // $FF: renamed from: b (int, int, int, int) void
    public void method_2979(int var1, int var2, int var3, int var4) {
        if(this.field_1972 != null) {
            this.field_1972.setLayoutParams(method_2976(var1, var2, var3, var4));
        }

    }

    // $FF: renamed from: bV () com.google.android.gms.internal.do
    public class_468 method_2980() {
        return this.field_1972;
    }

    // $FF: renamed from: bW () void
    public void method_2981() {
        if(this.field_1971 != null && this.field_1964) {
            this.setRequestedOrientation(this.field_1971.orientation);
        }

        if(this.field_1965 != null) {
            this.field_1963.setContentView(this.field_1970);
            this.method_184();
            this.field_1965.removeAllViews();
            this.field_1965 = null;
        }

        if(this.field_1966 != null) {
            this.field_1966.onCustomViewHidden();
            this.field_1966 = null;
        }

        this.field_1964 = false;
    }

    // $FF: renamed from: bX () void
    public void method_2982() {
        this.field_1970.removeView(this.field_1974);
        this.method_2987(true);
    }

    // $FF: renamed from: bY () void
    void method_2983() {
        if(this.field_1963.isFinishing() && !this.field_1968) {
            this.field_1968 = true;
            if(this.field_1963.isFinishing()) {
                if(this.field_1962 != null) {
                    this.method_2986();
                    this.field_1970.removeView(this.field_1962);
                    if(this.field_1973 != null) {
                        this.field_1962.method_2493(false);
                        this.field_1973.field_3847.addView(this.field_1962, this.field_1973.index, this.field_1973.field_3846);
                    }
                }

                if(this.field_1971 != null && this.field_1971.field_1805 != null) {
                    this.field_1971.field_1805.method_182();
                    return;
                }
            }
        }

    }

    // $FF: renamed from: bZ () void
    void method_2984() {
        this.field_1962.method_2483();
    }

    // $FF: renamed from: c (int, int, int, int) void
    public void method_2985(int var1, int var2, int var3, int var4) {
        if(this.field_1972 == null) {
            this.field_1972 = new class_468(this.field_1963, this.field_1962);
            this.field_1970.addView(this.field_1972, 0, method_2976(var1, var2, var3, var4));
            this.field_1962.method_2486().method_2408(false);
        }

    }

    // $FF: renamed from: ca () void
    void method_2986() {
        this.field_1962.method_2484();
    }

    public void close() {
        this.field_1963.finish();
    }

    // $FF: renamed from: n (boolean) void
    public void method_2987(boolean var1) {
        byte var2;
        if(var1) {
            var2 = 50;
        } else {
            var2 = 32;
        }

        this.field_1974 = new class_471(this.field_1963, var2);
        LayoutParams var3 = new LayoutParams(-2, -2);
        var3.addRule(10);
        byte var4;
        if(var1) {
            var4 = 11;
        } else {
            var4 = 9;
        }

        var3.addRule(var4);
        this.field_1974.method_2871(this.field_1971.field_1809);
        this.field_1970.addView(this.field_1974, var3);
    }

    // $FF: renamed from: o (boolean) void
    public void method_2988(boolean var1) {
        if(this.field_1974 != null) {
            this.field_1974.method_2871(var1);
        }

    }

    public void onCreate(Bundle param1) {
        // $FF: Couldn't be decompiled
    }

    public void onDestroy() {
        if(this.field_1972 != null) {
            this.field_1972.destroy();
        }

        if(this.field_1962 != null) {
            this.field_1970.removeView(this.field_1962);
        }

        this.method_2983();
    }

    public void onPause() {
        if(this.field_1972 != null) {
            this.field_1972.pause();
        }

        this.method_2981();
        if(this.field_1962 != null && (!this.field_1963.isFinishing() || this.field_1973 == null)) {
            class_383.method_2513(this.field_1962);
        }

        this.method_2983();
    }

    public void onRestart() {
    }

    public void onResume() {
        if(this.field_1971 != null && this.field_1971.field_1812 == 4) {
            if(this.field_1967) {
                this.field_1963.finish();
            } else {
                this.field_1967 = true;
            }
        }

        if(this.field_1962 != null) {
            class_383.method_2518(this.field_1962);
        }

    }

    public void onSaveInstanceState(Bundle var1) {
        var1.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.field_1967);
    }

    public void onStart() {
    }

    public void onStop() {
        this.method_2983();
    }

    // $FF: renamed from: p (boolean) void
    void method_2989(boolean var1) throws class_487.class_1610 {
        if(!this.field_1975) {
            this.field_1963.requestWindowFeature(1);
        }

        Window var2 = this.field_1963.getWindow();
        if(!this.field_1969 || this.field_1971.field_1815.field_2874) {
            var2.setFlags(1024, 1024);
        }

        this.setRequestedOrientation(this.field_1971.orientation);
        if(VERSION.SDK_INT >= 11) {
            class_378.method_2457("Enabling hardware acceleration on the AdActivity window.");
            class_387.method_2540(var2);
        }

        this.field_1970 = new class_487.class_1611(this.field_1963, this.field_1971.field_1814);
        if(!this.field_1969) {
            this.field_1970.setBackgroundColor(-16777216);
        } else {
            this.field_1970.setBackgroundColor(field_1961);
        }

        this.field_1963.setContentView(this.field_1970);
        this.method_184();
        boolean var3 = this.field_1971.field_1806.method_2486().method_2406();
        if(var1) {
            this.field_1962 = class_381.method_2470(this.field_1963, this.field_1971.field_1806.method_2475(), true, var3, (class_548)null, this.field_1971.field_1802);
            this.field_1962.method_2486().method_2399((class_63)null, (class_46)null, this.field_1971.field_1807, this.field_1971.field_1811, true, this.field_1971.field_1813, this.field_1971.field_1806.method_2486().method_2405());
            this.field_1962.method_2486().method_2397(new class_364.class_1738() {
                // $FF: renamed from: a (com.google.android.gms.internal.gv) void
                public void method_831(class_381 var1) {
                    var1.method_2483();
                }
            });
            if(this.field_1971.field_1816 != null) {
                this.field_1962.loadUrl(this.field_1971.field_1816);
            } else {
                if(this.field_1971.field_1810 == null) {
                    throw new class_487.class_1610("No URL or HTML to display in ad overlay.");
                }

                this.field_1962.loadDataWithBaseURL(this.field_1971.field_1808, this.field_1971.field_1810, "text/html", "UTF-8", (String)null);
            }
        } else {
            this.field_1962 = this.field_1971.field_1806;
            this.field_1962.setContext(this.field_1963);
        }

        this.field_1962.method_2478(this);
        ViewParent var4 = this.field_1962.getParent();
        if(var4 != null && var4 instanceof ViewGroup) {
            ((ViewGroup)var4).removeView(this.field_1962);
        }

        if(this.field_1969) {
            this.field_1962.setBackgroundColor(field_1961);
        }

        this.field_1970.addView(this.field_1962, -1, -1);
        if(!var1) {
            this.method_2984();
        }

        this.method_2987(var3);
        if(this.field_1962.method_2487()) {
            this.method_2988(true);
        }

    }

    public void setRequestedOrientation(int var1) {
        this.field_1963.setRequestedOrientation(var1);
    }

    @ez
    private static final class class_1610 extends Exception {
        public class_1610(String var1) {
            super(var1);
        }
    }

    @ez
    private static final class class_1611 extends RelativeLayout {
        // $FF: renamed from: ly com.google.android.gms.internal.gm
        private final class_388 field_3845;

        public class_1611(Context var1, String var2) {
            super(var1);
            this.field_3845 = new class_388(var1, var2);
        }

        public boolean onInterceptTouchEvent(MotionEvent var1) {
            this.field_3845.method_2548(var1);
            return false;
        }
    }

    @ez
    private static final class class_1612 {
        public final int index;
        // $FF: renamed from: rI android.view.ViewGroup.LayoutParams
        public final android.view.ViewGroup.LayoutParams field_3846;
        // $FF: renamed from: rJ android.view.ViewGroup
        public final ViewGroup field_3847;

        public class_1612(class_381 var1) throws class_487.class_1610 {
            this.field_3846 = var1.getLayoutParams();
            ViewParent var2 = var1.getParent();
            if(var2 instanceof ViewGroup) {
                this.field_3847 = (ViewGroup)var2;
                this.index = this.field_3847.indexOfChild(var1);
                this.field_3847.removeView(var1);
                var1.method_2493(true);
            } else {
                throw new class_487.class_1610("Could not get the parent of the WebView for an overlay.");
            }
        }
    }
}

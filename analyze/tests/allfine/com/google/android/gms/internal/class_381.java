package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_366;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_387;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ez;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.gv
@ez
public class class_381 extends WebView implements DownloadListener {
    // $FF: renamed from: mG android.view.WindowManager
    private final WindowManager field_1391;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1392 = new Object();
    // $FF: renamed from: qr com.google.android.gms.internal.ay
    private class_242 field_1393;
    // $FF: renamed from: qs com.google.android.gms.internal.gt
    private final class_379 field_1394;
    // $FF: renamed from: sX com.google.android.gms.internal.k
    private final class_548 field_1395;
    // $FF: renamed from: wH com.google.android.gms.internal.gw
    private final class_364 field_1396;
    // $FF: renamed from: wI com.google.android.gms.internal.gv$a
    private final class_381.class_1649 field_1397;
    // $FF: renamed from: wJ com.google.android.gms.internal.dk
    private class_487 field_1398;
    // $FF: renamed from: wK boolean
    private boolean field_1399;
    // $FF: renamed from: wL boolean
    private boolean field_1400;
    // $FF: renamed from: wM boolean
    private boolean field_1401;
    // $FF: renamed from: wN boolean
    private boolean field_1402;

    protected class_381(class_381.class_1649 var1, class_242 var2, boolean var3, boolean var4, class_548 var5, class_379 var6) {
        super(var1);
        this.field_1397 = var1;
        this.field_1393 = var2;
        this.field_1399 = var3;
        this.field_1395 = var5;
        this.field_1394 = var6;
        this.field_1391 = (WindowManager)this.getContext().getSystemService("window");
        this.setBackgroundColor(0);
        WebSettings var7 = this.getSettings();
        var7.setJavaScriptEnabled(true);
        var7.setSavePassword(false);
        var7.setSupportMultipleWindows(true);
        var7.setJavaScriptCanOpenWindowsAutomatically(true);
        class_383.method_2507(var1, var6.field_1387, var7);
        if(VERSION.SDK_INT >= 17) {
            class_369.method_2417(this.getContext(), var7);
        } else if(VERSION.SDK_INT >= 11) {
            class_387.method_2539(this.getContext(), var7);
        }

        this.setDownloadListener(this);
        if(VERSION.SDK_INT >= 11) {
            this.field_1396 = new class_365(this, var4);
        } else {
            this.field_1396 = new class_364(this, var4);
        }

        this.setWebViewClient(this.field_1396);
        if(VERSION.SDK_INT >= 14) {
            this.setWebChromeClient(new class_367(this));
        } else if(VERSION.SDK_INT >= 11) {
            this.setWebChromeClient(new class_366(this));
        }

        this.method_2471();
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay, boolean, boolean, com.google.android.gms.internal.k, com.google.android.gms.internal.gt) com.google.android.gms.internal.gv
    public static class_381 method_2470(Context var0, class_242 var1, boolean var2, boolean var3, class_548 var4, class_379 var5) {
        return new class_381(new class_381.class_1649(var0), var1, var2, var3, var4, var5);
    }

    // $FF: renamed from: dA () void
    private void method_2471() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dB () void
    private void method_2472() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dC () void
    private void method_2473() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: X (java.lang.String) void
    protected void method_2474(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: Y () com.google.android.gms.internal.ay
    public class_242 method_2475() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay) void
    public void method_2476(Context param1, class_242 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ay) void
    public void method_2477(class_242 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.dk) void
    public void method_2478(class_487 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, java.util.Map) void
    public void method_2479(String var1, Map<String, ?> var2) {
        JSONObject var4;
        try {
            var4 = class_383.method_2533(var2);
        } catch (JSONException var5) {
            class_378.method_2461("Could not convert parameters to JSON.");
            return;
        }

        this.method_2481(var1, var4);
    }

    // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
    public void method_2480(String var1, JSONObject var2) {
        if(var2 == null) {
            var2 = new JSONObject();
        }

        String var3 = var2.toString();
        StringBuilder var4 = new StringBuilder();
        var4.append("javascript:" + var1 + "(");
        var4.append(var3);
        var4.append(");");
        this.method_2474(var4.toString());
    }

    // $FF: renamed from: b (java.lang.String, org.json.JSONObject) void
    public void method_2481(String var1, JSONObject var2) {
        if(var2 == null) {
            var2 = new JSONObject();
        }

        String var3 = var2.toString();
        StringBuilder var4 = new StringBuilder();
        var4.append("javascript:AFMA_ReceiveMessage(\'");
        var4.append(var1);
        var4.append("\'");
        var4.append(",");
        var4.append(var3);
        var4.append(");");
        class_378.method_2460("Dispatching AFMA event: " + var4);
        this.method_2474(var4.toString());
    }

    // $FF: renamed from: bS () void
    public void method_2482() {
        if(this.method_2486().method_2406()) {
            DisplayMetrics var1 = new DisplayMetrics();
            Display var2 = this.field_1391.getDefaultDisplay();
            var2.getMetrics(var1);
            int var3 = class_383.method_2532(this.getContext());
            float var4 = 160.0F / (float)var1.densityDpi;
            int var5 = Math.round(var4 * (float)var1.widthPixels);
            int var6 = Math.round(var4 * (float)(var1.heightPixels - var3));

            try {
                this.method_2481("onScreenInfoChanged", (new JSONObject()).put("width", var5).put("height", var6).put("density", (double)var1.density).put("rotation", var2.getRotation()));
            } catch (JSONException var8) {
                class_378.method_2463("Error occured while obtaining screen information.", var8);
            }
        }
    }

    // $FF: renamed from: bZ () void
    public void method_2483() {
        HashMap var1 = new HashMap(1);
        var1.put("version", this.field_1394.field_1387);
        this.method_2479("onshow", var1);
    }

    // $FF: renamed from: ca () void
    public void method_2484() {
        HashMap var1 = new HashMap(1);
        var1.put("version", this.field_1394.field_1387);
        this.method_2479("onhide", var1);
    }

    public void destroy() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dt () com.google.android.gms.internal.dk
    public class_487 method_2485() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: du () com.google.android.gms.internal.gw
    public class_364 method_2486() {
        return this.field_1396;
    }

    // $FF: renamed from: dv () boolean
    public boolean method_2487() {
        return this.field_1402;
    }

    // $FF: renamed from: dw () com.google.android.gms.internal.k
    public class_548 method_2488() {
        return this.field_1395;
    }

    // $FF: renamed from: dx () com.google.android.gms.internal.gt
    public class_379 method_2489() {
        return this.field_1394;
    }

    // $FF: renamed from: dy () boolean
    public boolean method_2490() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dz () android.content.Context
    public Context method_2491() {
        return this.field_1397.method_4261();
    }

    public void evaluateJavascript(String param1, ValueCallback<String> param2) {
        // $FF: Couldn't be decompiled
    }

    public boolean isDestroyed() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: o (boolean) void
    public void method_2492(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    public void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
        try {
            Intent var7 = new Intent("android.intent.action.VIEW");
            var7.setDataAndType(Uri.parse(var1), var4);
            this.getContext().startActivity(var7);
        } catch (ActivityNotFoundException var9) {
            class_378.method_2457("Couldn\'t find an Activity to view url/mimetype: " + var1 + " / " + var4);
        }
    }

    protected void onMeasure(int param1, int param2) {
        // $FF: Couldn't be decompiled
    }

    public boolean onTouchEvent(MotionEvent var1) {
        if(this.field_1395 != null) {
            this.field_1395.method_3354(var1);
        }

        return super.onTouchEvent(var1);
    }

    public void setContext(Context var1) {
        this.field_1397.setBaseContext(var1);
    }

    // $FF: renamed from: x (boolean) void
    public void method_2493(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    @ez
    protected static class class_1649 extends MutableContextWrapper {
        // $FF: renamed from: mD android.content.Context
        private Context field_3934;
        // $FF: renamed from: wO android.app.Activity
        private Activity field_3935;

        public class_1649(Context var1) {
            super(var1);
            this.setBaseContext(var1);
        }

        // $FF: renamed from: dz () android.content.Context
        public Context method_4261() {
            return this.field_3935;
        }

        public void setBaseContext(Context var1) {
            this.field_3934 = var1.getApplicationContext();
            Activity var2;
            if(var1 instanceof Activity) {
                var2 = (Activity)var1;
            } else {
                var2 = null;
            }

            this.field_3935 = var2;
            super.setBaseContext(this.field_3934);
        }

        public void startActivity(Intent var1) {
            if(this.field_3935 != null) {
                this.field_3935.startActivity(var1);
            } else {
                var1.setFlags(268435456);
                this.field_3934.startActivity(var1);
            }
        }
    }
}

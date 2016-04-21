package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_1;
import com.google.android.gms.internal.class_2;
import com.google.android.gms.internal.class_212;
import com.google.android.gms.internal.class_235;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_244;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.gv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.af
@ez
public final class class_207 implements OnGlobalLayoutListener, OnScrollChangedListener {
    // $FF: renamed from: mK long
    private static final long field_36;
    // $FF: renamed from: mA java.lang.ref.WeakReference
    private WeakReference<ViewTreeObserver> field_37;
    // $FF: renamed from: mB java.lang.ref.WeakReference
    private final WeakReference<View> field_38;
    // $FF: renamed from: mC com.google.android.gms.internal.ad
    private final class_212 field_39;
    // $FF: renamed from: mD android.content.Context
    private final Context field_40;
    // $FF: renamed from: mE com.google.android.gms.internal.ah
    private final class_0 field_41;
    // $FF: renamed from: mF boolean
    private boolean field_42;
    // $FF: renamed from: mG android.view.WindowManager
    private final WindowManager field_43;
    // $FF: renamed from: mH android.os.PowerManager
    private final PowerManager field_44;
    // $FF: renamed from: mI android.app.KeyguardManager
    private final KeyguardManager field_45;
    // $FF: renamed from: mJ com.google.android.gms.internal.ag
    private class_1 field_46;
    // $FF: renamed from: mL boolean
    private boolean field_47;
    // $FF: renamed from: mM java.util.concurrent.BlockingQueue
    private final BlockingQueue<Runnable> field_48;
    // $FF: renamed from: mN long
    private long field_49;
    // $FF: renamed from: mO boolean
    private boolean field_50;
    // $FF: renamed from: mP boolean
    private boolean field_51;
    // $FF: renamed from: mQ android.content.BroadcastReceiver
    private BroadcastReceiver field_52;
    // $FF: renamed from: mR java.util.HashSet
    private final HashSet<ac> field_53;
    // $FF: renamed from: mn boolean
    private boolean field_54;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_55;
    // $FF: renamed from: mz java.lang.ref.WeakReference
    private final WeakReference<fz> field_56;

    static {
        field_36 = TimeUnit.MILLISECONDS.toNanos(100L);
    }

    public class_207(Context var1, class_242 var2, class_438 var3, View var4, class_379 var5) {
        this((class_242)var2, (class_438)var3, (class_379)var5, var4, (class_0)(new class_235(var1, var5)));
    }

    public class_207(class_242 var1, class_438 var2, class_379 var3, final View var4, class_0 var5) {
        this.field_55 = new Object();
        this.field_54 = false;
        this.field_47 = false;
        this.field_48 = new ArrayBlockingQueue(2);
        this.field_49 = Long.MIN_VALUE;
        this.field_53 = new HashSet();
        this.field_56 = new WeakReference(var2);
        this.field_38 = new WeakReference(var4);
        this.field_37 = new WeakReference((Object)null);
        this.field_50 = true;
        this.field_39 = new class_212(UUID.randomUUID().toString(), var3, var1.field_636, var2.field_1641);
        this.field_41 = var5;
        this.field_43 = (WindowManager)var4.getContext().getSystemService("window");
        this.field_44 = (PowerManager)var4.getContext().getApplicationContext().getSystemService("power");
        this.field_45 = (KeyguardManager)var4.getContext().getSystemService("keyguard");
        this.field_40 = var4.getContext().getApplicationContext();
        this.method_1074(var5);
        this.field_41.method_0(new class_0.class_1657() {
            // $FF: renamed from: aM () void
            public void method_719() {
                class_207.this.field_42 = true;
                class_207.this.method_1087(var4);
                class_207.this.method_1077();
            }
        });
        this.method_1086(this.field_41);

        try {
            final JSONObject var8 = this.method_1089(var4);
            this.field_48.add(new Runnable() {
                public void run() {
                    class_207.this.method_1075(var8);
                }
            });
        } catch (Throwable var9) {
            ;
        }

        this.field_48.add(new Runnable() {
            public void run() {
                class_207.this.method_1090(false);
            }
        });
        class_378.method_2457("Tracking ad unit: " + this.field_39.method_1484());
    }

    // $FF: renamed from: a (int, android.util.DisplayMetrics) int
    protected int method_1070(int var1, DisplayMetrics var2) {
        float var3 = var2.density;
        return (int)((float)var1 / var3);
    }

    // $FF: renamed from: a (android.view.View, java.util.Map) void
    protected void method_1071(View var1, Map<String, String> var2) {
        this.method_1090(false);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ac) void
    public void method_1072(class_2 var1) {
        this.field_53.add(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ag) void
    public void method_1073(class_1 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ah) void
    protected void method_1074(class_0 var1) {
        var1.method_4("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    // $FF: renamed from: a (org.json.JSONObject) void
    protected void method_1075(JSONObject var1) {
        try {
            JSONArray var2 = new JSONArray();
            JSONObject var3 = new JSONObject();
            var2.put(var1);
            var3.put("units", var2);
            this.field_41.method_3("AFMA_updateActiveView", var3);
        } catch (Throwable var5) {
            class_378.method_2463("Skipping active view message.", var5);
        }
    }

    // $FF: renamed from: a (java.util.Map) boolean
    protected boolean method_1076(Map<String, String> var1) {
        if(var1 == null) {
            return false;
        } else {
            String var2 = (String)var1.get("hashCode");
            boolean var3;
            if(!TextUtils.isEmpty(var2) && var2.equals(this.field_39.method_1484())) {
                var3 = true;
            } else {
                var3 = false;
            }

            return var3;
        }
    }

    // $FF: renamed from: aD () void
    protected void method_1077() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aE () void
    protected void method_1078() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aF () void
    public void method_1079() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aG () void
    protected void method_1080() {
        if(this.field_46 != null) {
            this.field_46.method_6(this);
        }

    }

    // $FF: renamed from: aH () boolean
    public boolean method_1081() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aI () void
    protected void method_1082() {
        View var1 = (View)this.field_38.get();
        if(var1 != null) {
            ViewTreeObserver var2 = (ViewTreeObserver)this.field_37.get();
            ViewTreeObserver var3 = var1.getViewTreeObserver();
            if(var3 != var2) {
                this.field_37 = new WeakReference(var3);
                var3.addOnScrollChangedListener(this);
                var3.addOnGlobalLayoutListener(this);
                return;
            }
        }

    }

    // $FF: renamed from: aJ () void
    protected void method_1083() {
        ViewTreeObserver var1 = (ViewTreeObserver)this.field_37.get();
        if(var1 != null && var1.isAlive()) {
            var1.removeOnScrollChangedListener(this);
            var1.removeGlobalOnLayoutListener(this);
        }
    }

    // $FF: renamed from: aK () org.json.JSONObject
    protected JSONObject method_1084() throws JSONException {
        JSONObject var1 = new JSONObject();
        var1.put("afmaVersion", this.field_39.method_1482()).put("activeViewJSON", this.field_39.method_1483()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.field_39.method_1485()).put("hashCode", this.field_39.method_1484());
        return var1;
    }

    // $FF: renamed from: aL () org.json.JSONObject
    protected JSONObject method_1085() throws JSONException {
        JSONObject var1 = this.method_1084();
        var1.put("doneReasonCode", "u");
        return var1;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ah) void
    protected void method_1086(class_0 var1) {
        var1.method_2("/updateActiveView", new class_9() {
            // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
            public void method_24(gv var1, Map<String, String> var2) {
                if(class_207.this.method_1076(var2)) {
                    class_207.this.method_1071(var1, var2);
                }
            }
        });
        var1.method_2("/untrackActiveViewUnit", new class_9() {
            // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
            public void method_24(gv var1, Map<String, String> var2) {
                if(class_207.this.method_1076(var2)) {
                    class_378.method_2457("Received request to untrack: " + class_207.this.field_39.method_1484());
                    class_207.this.destroy();
                }
            }
        });
        var1.method_2("/visibilityChanged", new class_9() {
            // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
            public void method_24(gv var1, Map<String, String> var2) {
                if(class_207.this.method_1076(var2) && var2.containsKey("isVisible")) {
                    boolean var3;
                    if(!"1".equals(var2.get("isVisible")) && !"true".equals(var2.get("isVisible"))) {
                        var3 = false;
                    } else {
                        var3 = true;
                    }

                    Boolean var4 = Boolean.valueOf(var3);
                    class_207.this.method_1088(var4.booleanValue());
                }
            }
        });
        var1.method_2("/viewabilityChanged", class_244.field_640);
    }

    // $FF: renamed from: d (android.view.View) void
    protected void method_1087(View var1) {
        ArrayList var2 = new ArrayList();
        this.field_48.drainTo(var2);
        Iterator var4 = var2.iterator();

        while(var4.hasNext()) {
            ((Runnable)var4.next()).run();
        }

    }

    // $FF: renamed from: d (boolean) void
    protected void method_1088(boolean var1) {
        Iterator var2 = this.field_53.iterator();

        while(var2.hasNext()) {
            ((class_2)var2.next()).method_8(this, var1);
        }

    }

    protected void destroy() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: e (android.view.View) org.json.JSONObject
    protected JSONObject method_1089(View var1) throws JSONException {
        int[] var2 = new int[2];
        int[] var3 = new int[2];
        var1.getLocationOnScreen(var2);
        var1.getLocationInWindow(var3);
        JSONObject var4 = this.method_1084();
        DisplayMetrics var5 = var1.getContext().getResources().getDisplayMetrics();
        Rect var6 = new Rect();
        var6.left = var2[0];
        var6.top = var2[1];
        var6.right = var6.left + var1.getWidth();
        var6.bottom = var6.top + var1.getHeight();
        Rect var7 = new Rect();
        var7.right = this.field_43.getDefaultDisplay().getWidth();
        var7.bottom = this.field_43.getDefaultDisplay().getHeight();
        Rect var8 = new Rect();
        boolean var9 = var1.getGlobalVisibleRect(var8, (Point)null);
        Rect var10 = new Rect();
        boolean var11 = var1.getLocalVisibleRect(var10);
        var4.put("viewBox", (new JSONObject()).put("top", this.method_1070(var7.top, var5)).put("bottom", this.method_1070(var7.bottom, var5)).put("left", this.method_1070(var7.left, var5)).put("right", this.method_1070(var7.right, var5))).put("adBox", (new JSONObject()).put("top", this.method_1070(var6.top, var5)).put("bottom", this.method_1070(var6.bottom, var5)).put("left", this.method_1070(var6.left, var5)).put("right", this.method_1070(var6.right, var5))).put("globalVisibleBox", (new JSONObject()).put("top", this.method_1070(var8.top, var5)).put("bottom", this.method_1070(var8.bottom, var5)).put("left", this.method_1070(var8.left, var5)).put("right", this.method_1070(var8.right, var5))).put("globalVisibleBoxVisible", var9).put("localVisibleBox", (new JSONObject()).put("top", this.method_1070(var10.top, var5)).put("bottom", this.method_1070(var10.bottom, var5)).put("left", this.method_1070(var10.left, var5)).put("right", this.method_1070(var10.right, var5))).put("localVisibleBoxVisible", var11).put("screenDensity", (double)var5.density).put("isVisible", this.method_1091(var1)).put("isStopped", this.field_47).put("isPaused", this.field_54);
        return var4;
    }

    // $FF: renamed from: e (boolean) void
    protected void method_1090(boolean param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (android.view.View) boolean
    protected boolean method_1091(View var1) {
        return var1.getVisibility() == 0 && var1.isShown() && this.field_44.isScreenOn() && !this.field_45.inKeyguardRestrictedInputMode();
    }

    public void onGlobalLayout() {
        this.method_1090(false);
    }

    public void onScrollChanged() {
        this.method_1090(true);
    }

    public void pause() {
        // $FF: Couldn't be decompiled
    }

    public void resume() {
        // $FF: Couldn't be decompiled
    }

    public void stop() {
        // $FF: Couldn't be decompiled
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.class_251;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_482;
import com.google.android.gms.internal.ez;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dg
@ez
public class class_483 {
    private final Context mContext;
    // $FF: renamed from: mG android.view.WindowManager
    private final WindowManager field_1923;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1924;
    // $FF: renamed from: rg com.google.android.gms.internal.bl
    private final class_251 field_1925;
    // $FF: renamed from: rh android.util.DisplayMetrics
    DisplayMetrics field_1926;
    // $FF: renamed from: ri float
    private float field_1927;
    // $FF: renamed from: rj int
    int field_1928 = -1;
    // $FF: renamed from: rk int
    int field_1929 = -1;
    // $FF: renamed from: rl int
    private int field_1930;
    // $FF: renamed from: rm int
    private int field_1931 = -1;
    // $FF: renamed from: rn int
    private int field_1932 = -1;
    // $FF: renamed from: ro int[]
    private int[] field_1933 = new int[2];

    public class_483(class_381 var1, Context var2, class_251 var3) {
        this.field_1924 = var1;
        this.mContext = var2;
        this.field_1925 = var3;
        this.field_1923 = (WindowManager)var2.getSystemService("window");
        this.method_2956();
        this.method_2959();
        this.method_2957();
    }

    // $FF: renamed from: bM () void
    private void method_2956() {
        this.field_1926 = new DisplayMetrics();
        Display var1 = this.field_1923.getDefaultDisplay();
        var1.getMetrics(this.field_1926);
        this.field_1927 = this.field_1926.density;
        this.field_1930 = var1.getRotation();
    }

    // $FF: renamed from: bO () void
    private void method_2957() {
        this.field_1924.getLocationOnScreen(this.field_1933);
        this.field_1924.measure(0, 0);
        float var1 = 160.0F / (float)this.field_1926.densityDpi;
        this.field_1931 = Math.round(var1 * (float)this.field_1924.getMeasuredWidth());
        this.field_1932 = Math.round(var1 * (float)this.field_1924.getMeasuredHeight());
    }

    // $FF: renamed from: bU () com.google.android.gms.internal.df
    private class_482 method_2958() {
        return (new class_482.class_1661()).method_5928(this.field_1925.method_1609()).method_5927(this.field_1925.method_1610()).method_5929(this.field_1925.method_1613()).method_5930(this.field_1925.method_1611()).method_5931(this.field_1925.method_1612()).method_5926();
    }

    // $FF: renamed from: bN () void
    void method_2959() {
        int var1 = class_383.method_2532(this.mContext);
        float var2 = 160.0F / (float)this.field_1926.densityDpi;
        this.field_1928 = Math.round(var2 * (float)this.field_1926.widthPixels);
        this.field_1929 = Math.round(var2 * (float)(this.field_1926.heightPixels - var1));
    }

    // $FF: renamed from: bP () void
    public void method_2960() {
        this.method_2963();
        this.method_2964();
        this.method_2962();
        this.method_2961();
    }

    // $FF: renamed from: bQ () void
    public void method_2961() {
        if(class_378.method_2466(2)) {
            class_378.method_2459("Dispatching Ready Event.");
        }

        this.field_1924.method_2481("onReadyEventReceived", new JSONObject());
    }

    // $FF: renamed from: bR () void
    public void method_2962() {
        try {
            JSONObject var2 = (new JSONObject()).put("x", this.field_1933[0]).put("y", this.field_1933[1]).put("width", this.field_1931).put("height", this.field_1932);
            this.field_1924.method_2481("onDefaultPositionReceived", var2);
        } catch (JSONException var3) {
            class_378.method_2463("Error occured while dispatching default position.", var3);
        }
    }

    // $FF: renamed from: bS () void
    public void method_2963() {
        try {
            JSONObject var2 = (new JSONObject()).put("width", this.field_1928).put("height", this.field_1929).put("density", (double)this.field_1927).put("rotation", this.field_1930);
            this.field_1924.method_2481("onScreenInfoChanged", var2);
        } catch (JSONException var3) {
            class_378.method_2463("Error occured while obtaining screen information.", var3);
        }
    }

    // $FF: renamed from: bT () void
    public void method_2964() {
        class_482 var1 = this.method_2958();
        this.field_1924.method_2481("onDeviceFeaturesReceived", var1.method_2955());
    }
}

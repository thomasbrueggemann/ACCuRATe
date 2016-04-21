package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dd
@ez
public class class_484 {
    // $FF: renamed from: qT java.util.Set
    static final Set<String> field_1934 = new HashSet(Arrays.asList(new String[] {"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    // $FF: renamed from: lf int
    private int field_1935 = -1;
    // $FF: renamed from: lg int
    private int field_1936 = -1;
    private final Context mContext;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1937;
    // $FF: renamed from: qM java.util.Map
    private final Map<String, String> field_1938;
    // $FF: renamed from: qU int
    private int field_1939 = 0;
    // $FF: renamed from: qV int
    private int field_1940 = 0;
    // $FF: renamed from: qW boolean
    private boolean field_1941 = true;
    // $FF: renamed from: qX java.lang.String
    private String field_1942 = "top-right";

    public class_484(gv var1, Map<String, String> var2) {
        this.field_1937 = var1;
        this.field_1938 = var2;
        this.mContext = var1.method_2491();
    }

    // $FF: renamed from: bG () void
    private void method_2965() {
        int[] var1 = class_383.method_2534(this.mContext);
        if(!TextUtils.isEmpty((CharSequence)this.field_1938.get("width"))) {
            int var4 = class_383.method_2500((String)this.field_1938.get("width"));
            if(this.method_2966(var4, var1[0])) {
                this.field_1935 = var4;
            }
        }

        if(!TextUtils.isEmpty((CharSequence)this.field_1938.get("height"))) {
            int var3 = class_383.method_2500((String)this.field_1938.get("height"));
            if(this.method_2970(var3, var1[1])) {
                this.field_1936 = var3;
            }
        }

        if(!TextUtils.isEmpty((CharSequence)this.field_1938.get("offsetX"))) {
            this.field_1939 = class_383.method_2500((String)this.field_1938.get("offsetX"));
        }

        if(!TextUtils.isEmpty((CharSequence)this.field_1938.get("offsetY"))) {
            this.field_1940 = class_383.method_2500((String)this.field_1938.get("offsetY"));
        }

        if(!TextUtils.isEmpty((CharSequence)this.field_1938.get("allowOffscreen"))) {
            this.field_1941 = Boolean.parseBoolean((String)this.field_1938.get("allowOffscreen"));
        }

        String var2 = (String)this.field_1938.get("customClosePosition");
        if(!TextUtils.isEmpty(var2) && field_1934.contains(var2)) {
            this.field_1942 = var2;
        }

    }

    // $FF: renamed from: b (int, int) boolean
    boolean method_2966(int var1, int var2) {
        return var1 >= 50 && var1 < var2;
    }

    // $FF: renamed from: bH () boolean
    boolean method_2967() {
        return this.field_1935 > -1 && this.field_1936 > -1;
    }

    // $FF: renamed from: bI () void
    void method_2968() {
        try {
            JSONObject var2 = (new JSONObject()).put("x", this.field_1939).put("y", this.field_1940).put("width", this.field_1935).put("height", this.field_1936);
            this.field_1937.method_2481("onSizeChanged", var2);
        } catch (JSONException var3) {
            class_378.method_2463("Error occured while dispatching size change.", var3);
        }
    }

    // $FF: renamed from: bJ () void
    void method_2969() {
        try {
            JSONObject var2 = (new JSONObject()).put("state", "resized");
            this.field_1937.method_2481("onStateChanged", var2);
        } catch (JSONException var3) {
            class_378.method_2463("Error occured while dispatching state change.", var3);
        }
    }

    // $FF: renamed from: c (int, int) boolean
    boolean method_2970(int var1, int var2) {
        return var1 >= 50 && var1 < var2;
    }

    public void execute() {
        class_378.method_2459("PLEASE IMPLEMENT mraid.resize()");
        if(this.mContext == null) {
            class_378.method_2461("Not an activity context. Cannot resize.");
        } else if(this.field_1937.method_2475().field_637) {
            class_378.method_2461("Is interstitial. Cannot resize an interstitial.");
        } else if(this.field_1937.method_2490()) {
            class_378.method_2461("Is expanded. Cannot resize an expanded banner.");
        } else {
            this.method_2965();
            if(!this.method_2967()) {
                class_378.method_2461("Invalid width and height options. Cannot resize.");
            } else {
                WindowManager var1 = (WindowManager)this.mContext.getSystemService("window");
                DisplayMetrics var2 = new DisplayMetrics();
                var1.getDefaultDisplay().getMetrics(var2);
                int var3 = 16 + class_377.method_2450(var2, this.field_1935);
                int var4 = 16 + class_377.method_2450(var2, this.field_1936);
                ViewParent var5 = this.field_1937.getParent();
                if(var5 != null && var5 instanceof ViewGroup) {
                    ((ViewGroup)var5).removeView(this.field_1937);
                }

                LinearLayout var6 = new LinearLayout(this.mContext);
                var6.setBackgroundColor(0);
                PopupWindow var7 = new PopupWindow(this.mContext);
                var7.setHeight(var4);
                var7.setWidth(var3);
                boolean var8;
                if(!this.field_1941) {
                    var8 = true;
                } else {
                    var8 = false;
                }

                var7.setClippingEnabled(var8);
                var7.setContentView(var6);
                var6.addView(this.field_1937, -1, -1);
                var7.showAtLocation(((Activity)this.mContext).getWindow().getDecorView(), 0, this.field_1939, this.field_1940);
                this.field_1937.method_2477(new class_242(this.mContext, new AdSize(this.field_1935, this.field_1936)));
                this.method_2968();
                this.method_2969();
            }
        }
    }
}

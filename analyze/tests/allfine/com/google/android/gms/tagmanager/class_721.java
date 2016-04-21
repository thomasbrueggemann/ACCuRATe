package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.tagmanager.class_70;

// $FF: renamed from: com.google.android.gms.tagmanager.x
class class_721 implements class_70 {
    // $FF: renamed from: xW int
    private int field_3481 = 5;

    // $FF: renamed from: S (java.lang.String) void
    public void method_330(String var1) {
        if(this.field_3481 <= 3) {
            Log.d("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: T (java.lang.String) void
    public void method_331(String var1) {
        if(this.field_3481 <= 6) {
            Log.e("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: U (java.lang.String) void
    public void method_332(String var1) {
        if(this.field_3481 <= 4) {
            Log.i("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: V (java.lang.String) void
    public void method_333(String var1) {
        if(this.field_3481 <= 2) {
            Log.v("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: W (java.lang.String) void
    public void method_334(String var1) {
        if(this.field_3481 <= 5) {
            Log.w("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
    public void method_335(String var1, Throwable var2) {
        if(this.field_3481 <= 6) {
            Log.e("GoogleTagManager", var1, var2);
        }

    }

    // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
    public void method_336(String var1, Throwable var2) {
        if(this.field_3481 <= 5) {
            Log.w("GoogleTagManager", var1, var2);
        }

    }

    public void setLogLevel(int var1) {
        this.field_3481 = var1;
    }
}

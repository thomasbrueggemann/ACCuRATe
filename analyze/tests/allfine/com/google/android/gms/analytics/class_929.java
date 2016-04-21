package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

// $FF: renamed from: com.google.android.gms.analytics.k
class class_929 implements Logger {
    // $FF: renamed from: xW int
    private int field_4243 = 2;

    // $FF: renamed from: ae (java.lang.String) java.lang.String
    private String method_4800(String var1) {
        return Thread.currentThread().toString() + ": " + var1;
    }

    public void error(Exception var1) {
        if(this.field_4243 <= 3) {
            Log.e("GAV4", (String)null, var1);
        }

    }

    public void error(String var1) {
        if(this.field_4243 <= 3) {
            Log.e("GAV4", this.method_4800(var1));
        }

    }

    public int getLogLevel() {
        return this.field_4243;
    }

    public void info(String var1) {
        if(this.field_4243 <= 1) {
            Log.i("GAV4", this.method_4800(var1));
        }

    }

    public void setLogLevel(int var1) {
        this.field_4243 = var1;
    }

    public void verbose(String var1) {
        if(this.field_4243 <= 0) {
            Log.v("GAV4", this.method_4800(var1));
        }

    }

    public void warn(String var1) {
        if(this.field_4243 <= 2) {
            Log.w("GAV4", this.method_4800(var1));
        }

    }
}

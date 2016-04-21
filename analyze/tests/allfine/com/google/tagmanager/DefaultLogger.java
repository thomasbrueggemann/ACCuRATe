package com.google.tagmanager;

import com.google.tagmanager.Logger;

class DefaultLogger implements Logger {
    private static final String LOG_TAG = "GoogleTagManager";
    private Logger.LogLevel mLogLevel;

    DefaultLogger() {
        this.mLogLevel = Logger.LogLevel.WARNING;
    }

    // $FF: renamed from: d (java.lang.String) void
    public void method_67(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.DEBUG.ordinal()) {
            android.util.Log.d("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
    public void method_68(String var1, Throwable var2) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.DEBUG.ordinal()) {
            android.util.Log.d("GoogleTagManager", var1, var2);
        }

    }

    // $FF: renamed from: e (java.lang.String) void
    public void method_69(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            android.util.Log.e("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: e (java.lang.String, java.lang.Throwable) void
    public void method_70(String var1, Throwable var2) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            android.util.Log.e("GoogleTagManager", var1, var2);
        }

    }

    public Logger.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    // $FF: renamed from: i (java.lang.String) void
    public void method_71(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            android.util.Log.i("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: i (java.lang.String, java.lang.Throwable) void
    public void method_72(String var1, Throwable var2) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            android.util.Log.i("GoogleTagManager", var1, var2);
        }

    }

    public void setLogLevel(Logger.LogLevel var1) {
        this.mLogLevel = var1;
    }

    // $FF: renamed from: v (java.lang.String) void
    public void method_73(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            android.util.Log.v("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: v (java.lang.String, java.lang.Throwable) void
    public void method_74(String var1, Throwable var2) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            android.util.Log.v("GoogleTagManager", var1, var2);
        }

    }

    // $FF: renamed from: w (java.lang.String) void
    public void method_75(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            android.util.Log.w("GoogleTagManager", var1);
        }

    }

    // $FF: renamed from: w (java.lang.String, java.lang.Throwable) void
    public void method_76(String var1, Throwable var2) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            android.util.Log.w("GoogleTagManager", var1, var2);
        }

    }
}

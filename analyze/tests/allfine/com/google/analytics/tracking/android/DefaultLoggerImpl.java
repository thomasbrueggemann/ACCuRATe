package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.Logger;
import com.google.android.gms.common.util.VisibleForTesting;

class DefaultLoggerImpl implements Logger {
    @VisibleForTesting
    static final String LOG_TAG = "GAV3";
    private Logger.LogLevel mLogLevel;

    DefaultLoggerImpl() {
        this.mLogLevel = Logger.LogLevel.INFO;
    }

    private String formatMessage(String var1) {
        return Thread.currentThread().toString() + ": " + var1;
    }

    public void error(Exception var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            android.util.Log.e("GAV3", (String)null, var1);
        }

    }

    public void error(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            android.util.Log.e("GAV3", this.formatMessage(var1));
        }

    }

    public Logger.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public void info(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            android.util.Log.i("GAV3", this.formatMessage(var1));
        }

    }

    public void setLogLevel(Logger.LogLevel var1) {
        this.mLogLevel = var1;
    }

    public void verbose(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            android.util.Log.v("GAV3", this.formatMessage(var1));
        }

    }

    public void warn(String var1) {
        if(this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            android.util.Log.w("GAV3", this.formatMessage(var1));
        }

    }
}

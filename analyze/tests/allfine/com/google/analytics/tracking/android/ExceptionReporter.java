package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.ExceptionParser;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.ServiceManager;
import com.google.analytics.tracking.android.StandardExceptionParser;
import com.google.analytics.tracking.android.Tracker;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    static final String DEFAULT_DESCRIPTION = "UncaughtException";
    private ExceptionParser mExceptionParser;
    private final UncaughtExceptionHandler mOriginalHandler;
    private final ServiceManager mServiceManager;
    private final Tracker mTracker;

    public ExceptionReporter(Tracker var1, ServiceManager var2, UncaughtExceptionHandler var3, Context var4) {
        if(var1 == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if(var2 == null) {
            throw new NullPointerException("serviceManager cannot be null");
        } else {
            this.mOriginalHandler = var3;
            this.mTracker = var1;
            this.mServiceManager = var2;
            this.mExceptionParser = new StandardExceptionParser(var4, new ArrayList());
            StringBuilder var5 = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
            String var6;
            if(var3 == null) {
                var6 = "null";
            } else {
                var6 = var3.getClass().getName();
            }

            Log.method_2106(var5.append(var6).toString());
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.mExceptionParser;
    }

    public void setExceptionParser(ExceptionParser var1) {
        this.mExceptionParser = var1;
    }

    public void uncaughtException(Thread var1, Throwable var2) {
        String var3 = "UncaughtException";
        if(this.mExceptionParser != null) {
            String var4;
            if(var1 != null) {
                var4 = var1.getName();
            } else {
                var4 = null;
            }

            var3 = this.mExceptionParser.getDescription(var4, var2);
        }

        Log.method_2106("Tracking Exception: " + var3);
        this.mTracker.send(MapBuilder.createException(var3, Boolean.valueOf(true)).build());
        this.mServiceManager.dispatchLocalHits();
        if(this.mOriginalHandler != null) {
            Log.method_2106("Passing exception to original handler.");
            this.mOriginalHandler.uncaughtException(var1, var2);
        }

    }
}

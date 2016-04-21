package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.class_938;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    // $FF: renamed from: xX java.lang.Thread.UncaughtExceptionHandler
    private final UncaughtExceptionHandler field_4808;
    // $FF: renamed from: xY com.google.android.gms.analytics.Tracker
    private final Tracker field_4809;
    // $FF: renamed from: xZ com.google.android.gms.analytics.ExceptionParser
    private ExceptionParser field_4810;

    public ExceptionReporter(Tracker var1, UncaughtExceptionHandler var2, Context var3) {
        if(var1 == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if(var3 == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.field_4808 = var2;
            this.field_4809 = var1;
            this.field_4810 = new StandardExceptionParser(var3, new ArrayList());
            this.mContext = var3.getApplicationContext();
            StringBuilder var4 = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
            String var5;
            if(var2 == null) {
                var5 = "null";
            } else {
                var5 = var2.getClass().getName();
            }

            class_938.method_4860(var4.append(var5).toString());
        }
    }

    // $FF: renamed from: dY () java.lang.Thread.UncaughtExceptionHandler
    UncaughtExceptionHandler method_5441() {
        return this.field_4808;
    }

    public ExceptionParser getExceptionParser() {
        return this.field_4810;
    }

    public void setExceptionParser(ExceptionParser var1) {
        this.field_4810 = var1;
    }

    public void uncaughtException(Thread var1, Throwable var2) {
        String var3 = "UncaughtException";
        if(this.field_4810 != null) {
            String var4;
            if(var1 != null) {
                var4 = var1.getName();
            } else {
                var4 = null;
            }

            var3 = this.field_4810.getDescription(var4, var2);
        }

        class_938.method_4860("Tracking Exception: " + var3);
        this.field_4809.send((new HitBuilders.ExceptionBuilder()).setDescription(var3).setFatal(true).build());
        GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
        if(this.field_4808 != null) {
            class_938.method_4860("Passing exception to original handler.");
            this.field_4808.uncaughtException(var1, var2);
        }

    }
}

package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.AnalyticsThread;
import com.google.analytics.tracking.android.AppFieldsDefaultProvider;
import com.google.analytics.tracking.android.ClientIdDefaultProvider;
import com.google.analytics.tracking.android.DefaultLoggerImpl;
import com.google.analytics.tracking.android.GAThread;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.ScreenResolutionDefaultProvider;
import com.google.analytics.tracking.android.Tracker;
import com.google.analytics.tracking.android.TrackerHandler;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class GoogleAnalytics extends TrackerHandler {
    private static GoogleAnalytics sInstance;
    private volatile Boolean mAppOptOut;
    private Context mContext;
    private Tracker mDefaultTracker;
    private boolean mDryRun;
    private Logger mLogger;
    private AnalyticsThread mThread;
    private final Map<String, Tracker> mTrackers;

    @VisibleForTesting
    protected GoogleAnalytics(Context var1) {
        this(var1, GAThread.getInstance(var1));
    }

    private GoogleAnalytics(Context var1, AnalyticsThread var2) {
        this.mAppOptOut = Boolean.valueOf(false);
        this.mTrackers = new HashMap();
        if(var1 == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else {
            this.mContext = var1.getApplicationContext();
            this.mThread = var2;
            AppFieldsDefaultProvider.initializeProvider(this.mContext);
            ScreenResolutionDefaultProvider.initializeProvider(this.mContext);
            ClientIdDefaultProvider.initializeProvider(this.mContext);
            this.mLogger = new DefaultLoggerImpl();
        }
    }

    @VisibleForTesting
    static void clearDefaultProviders() {
        AppFieldsDefaultProvider.dropInstance();
        ScreenResolutionDefaultProvider.dropInstance();
        ClientIdDefaultProvider.dropInstance();
    }

    @VisibleForTesting
    static void clearInstance() {
        // $FF: Couldn't be decompiled
    }

    static GoogleAnalytics getInstance() {
        // $FF: Couldn't be decompiled
    }

    public static GoogleAnalytics getInstance(Context param0) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    static GoogleAnalytics getNewInstance(Context param0, AnalyticsThread param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    void close() {
    }

    public void closeTracker(String param1) {
        // $FF: Couldn't be decompiled
    }

    public boolean getAppOptOut() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_OPT_OUT);
        return this.mAppOptOut.booleanValue();
    }

    public Tracker getDefaultTracker() {
        // $FF: Couldn't be decompiled
    }

    public Logger getLogger() {
        return this.mLogger;
    }

    public Tracker getTracker(String var1) {
        return this.getTracker(var1, var1);
    }

    public Tracker getTracker(String param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    public boolean isDryRunEnabled() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_DRY_RUN);
        return this.mDryRun;
    }

    void sendHit(Map<String, String> param1) {
        // $FF: Couldn't be decompiled
    }

    public void setAppOptOut(boolean var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
        this.mAppOptOut = Boolean.valueOf(var1);
        if(this.mAppOptOut.booleanValue()) {
            this.mThread.clearHits();
        }

    }

    public void setDefaultTracker(Tracker param1) {
        // $FF: Couldn't be decompiled
    }

    public void setDryRun(boolean var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_DRY_RUN);
        this.mDryRun = var1;
    }

    public void setLogger(Logger var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_LOGGER);
        this.mLogger = var1;
    }
}

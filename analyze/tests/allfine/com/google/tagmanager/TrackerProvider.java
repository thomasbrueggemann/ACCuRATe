package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Log;
import com.google.tagmanager.Logger;

class TrackerProvider {
    private Context mContext;
    private GoogleAnalytics mGoogleAnalytics;

    TrackerProvider(Context var1) {
        this.mContext = var1;
    }

    @VisibleForTesting
    TrackerProvider(GoogleAnalytics var1) {
        this.mGoogleAnalytics = var1;
        this.mGoogleAnalytics.setLogger(new TrackerProvider.LoggerImpl());
    }

    private void initTrackProviderIfNecessary() {
        synchronized(this) {}

        try {
            if(this.mGoogleAnalytics == null) {
                this.mGoogleAnalytics = GoogleAnalytics.getInstance(this.mContext);
                this.mGoogleAnalytics.setLogger(new TrackerProvider.LoggerImpl());
            }
        } finally {
            ;
        }

    }

    public void close(Tracker var1) {
        this.mGoogleAnalytics.closeTracker(var1.getName());
    }

    public Tracker getTracker(String var1) {
        this.initTrackProviderIfNecessary();
        return this.mGoogleAnalytics.getTracker(var1);
    }

    static class LoggerImpl implements com.google.analytics.tracking.android.Logger {
        private static com.google.analytics.tracking.android.Logger.LogLevel toAnalyticsLogLevel(Logger.LogLevel var0) {
            switch(null.$SwitchMap$com$google$tagmanager$Logger$LogLevel[var0.ordinal()]) {
                case 1:
                case 2:
                    return com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
                case 3:
                    return com.google.analytics.tracking.android.Logger.LogLevel.WARNING;
                case 4:
                case 5:
                    return com.google.analytics.tracking.android.Logger.LogLevel.INFO;
                case 6:
                    return com.google.analytics.tracking.android.Logger.LogLevel.VERBOSE;
                default:
                    return com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
            }
        }

        public void error(Exception var1) {
            Log.method_5504("", var1);
        }

        public void error(String var1) {
            Log.method_5503(var1);
        }

        public com.google.analytics.tracking.android.Logger.LogLevel getLogLevel() {
            Logger.LogLevel var1 = Log.getLogLevel();
            return var1 == null?com.google.analytics.tracking.android.Logger.LogLevel.ERROR:toAnalyticsLogLevel(var1);
        }

        public void info(String var1) {
            Log.method_5505(var1);
        }

        public void setLogLevel(com.google.analytics.tracking.android.Logger.LogLevel var1) {
            Log.method_5509("GA uses GTM logger. Please use TagManager.getLogger().setLogLevel(LogLevel) instead.");
        }

        public void verbose(String var1) {
            Log.method_5507(var1);
        }

        public void warn(String var1) {
            Log.method_5509(var1);
        }
    }
}

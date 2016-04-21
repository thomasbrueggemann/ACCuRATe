package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Clock;
import com.google.analytics.tracking.android.ExceptionReporter;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.ParameterLoader;
import com.google.analytics.tracking.android.ParameterLoaderImpl;
import com.google.analytics.tracking.android.ServiceManager;
import com.google.analytics.tracking.android.Tracker;
import com.google.analytics.tracking.android.TrackerHandler;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker extends Tracker {
    private static final int DEFAULT_SAMPLE_RATE = 100;
    private static final String EASY_TRACKER_NAME = "easy_tracker";
    static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
    private static EasyTracker sInstance;
    private static String sResourcePackageName;
    private int mActivitiesActive;
    private final Map<String, String> mActivityNameMap;
    private Clock mClock;
    private Context mContext;
    private final GoogleAnalytics mGoogleAnalytics;
    private boolean mIsAutoActivityTracking;
    private boolean mIsInForeground;
    private boolean mIsReportUncaughtExceptionsEnabled;
    private long mLastOnStopTime;
    private ParameterLoader mParameterFetcher;
    private ServiceManager mServiceManager;
    private long mSessionTimeout;
    private boolean mStartSessionOnNextSend;
    private Timer mTimer;
    private TimerTask mTimerTask;

    private EasyTracker(Context var1) {
        this(var1, new ParameterLoaderImpl(var1), GoogleAnalytics.getInstance(var1), GAServiceManager.getInstance(), (TrackerHandler)null);
    }

    private EasyTracker(Context var1, ParameterLoader var2, GoogleAnalytics var3, ServiceManager var4, TrackerHandler var5) {
        if(var5 == null) {
            var5 = var3;
        }

        super("easy_tracker", (String)null, (TrackerHandler)var5);
        this.mIsAutoActivityTracking = false;
        this.mActivitiesActive = 0;
        this.mActivityNameMap = new HashMap();
        this.mIsInForeground = false;
        this.mStartSessionOnNextSend = false;
        if(sResourcePackageName != null) {
            var2.setResourcePackageName(sResourcePackageName);
        }

        this.mGoogleAnalytics = var3;
        this.setContext(var1, var2, var4);
        this.mClock = new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
    }

    private void clearExistingTimer() {
        synchronized(this) {}

        try {
            if(this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        } finally {
            ;
        }

    }

    private String getActivityName(Activity var1) {
        String var2 = var1.getClass().getCanonicalName();
        if(this.mActivityNameMap.containsKey(var2)) {
            return (String)this.mActivityNameMap.get(var2);
        } else {
            String var3 = this.mParameterFetcher.getString(var2);
            if(var3 == null) {
                var3 = var2;
            }

            this.mActivityNameMap.put(var2, var3);
            return var3;
        }
    }

    public static EasyTracker getInstance(Context var0) {
        if(sInstance == null) {
            sInstance = new EasyTracker(var0);
        }

        return sInstance;
    }

    private Logger.LogLevel getLogLevelFromString(String var1) {
        try {
            Logger.LogLevel var3 = Logger.LogLevel.valueOf(var1.toUpperCase());
            return var3;
        } catch (IllegalArgumentException var4) {
            return null;
        }
    }

    @VisibleForTesting
    static EasyTracker getNewInstance(Context var0, ParameterLoader var1, GoogleAnalytics var2, ServiceManager var3, TrackerHandler var4) {
        sInstance = new EasyTracker(var0, var1, var2, var3, var4);
        return sInstance;
    }

    private void loadParameters() {
        Log.method_2106("Starting EasyTracker.");
        String var1 = this.mParameterFetcher.getString("ga_trackingId");
        if(TextUtils.isEmpty(var1)) {
            var1 = this.mParameterFetcher.getString("ga_api_key");
        }

        this.set("&tid", var1);
        Log.method_2106("[EasyTracker] trackingId loaded: " + var1);
        String var2 = this.mParameterFetcher.getString("ga_appName");
        if(!TextUtils.isEmpty(var2)) {
            Log.method_2106("[EasyTracker] app name loaded: " + var2);
            this.set("&an", var2);
        }

        String var3 = this.mParameterFetcher.getString("ga_appVersion");
        if(var3 != null) {
            Log.method_2106("[EasyTracker] app version loaded: " + var3);
            this.set("&av", var3);
        }

        String var4 = this.mParameterFetcher.getString("ga_logLevel");
        if(var4 != null) {
            Logger.LogLevel var10 = this.getLogLevelFromString(var4);
            if(var10 != null) {
                Log.method_2106("[EasyTracker] log level loaded: " + var10);
                this.mGoogleAnalytics.getLogger().setLogLevel(var10);
            }
        }

        Double var5 = this.mParameterFetcher.getDoubleFromString("ga_sampleFrequency");
        if(var5 == null) {
            var5 = new Double((double)this.mParameterFetcher.getInt("ga_sampleRate", 100));
        }

        if(var5.doubleValue() != 100.0D) {
            this.set("&sf", Double.toString(var5.doubleValue()));
        }

        Log.method_2106("[EasyTracker] sample rate loaded: " + var5);
        int var6 = this.mParameterFetcher.getInt("ga_dispatchPeriod", 1800);
        Log.method_2106("[EasyTracker] dispatch period loaded: " + var6);
        this.mServiceManager.setLocalDispatchPeriod(var6);
        this.mSessionTimeout = (long)(1000 * this.mParameterFetcher.getInt("ga_sessionTimeout", 30));
        Log.method_2106("[EasyTracker] session timeout loaded: " + this.mSessionTimeout);
        boolean var7;
        if(!this.mParameterFetcher.getBoolean("ga_autoActivityTracking") && !this.mParameterFetcher.getBoolean("ga_auto_activity_tracking")) {
            var7 = false;
        } else {
            var7 = true;
        }

        this.mIsAutoActivityTracking = var7;
        Log.method_2106("[EasyTracker] auto activity tracking loaded: " + this.mIsAutoActivityTracking);
        boolean var8 = this.mParameterFetcher.getBoolean("ga_anonymizeIp");
        if(var8) {
            this.set("&aip", "1");
            Log.method_2106("[EasyTracker] anonymize ip loaded: " + var8);
        }

        this.mIsReportUncaughtExceptionsEnabled = this.mParameterFetcher.getBoolean("ga_reportUncaughtExceptions");
        if(this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, this.mServiceManager, Thread.getDefaultUncaughtExceptionHandler(), this.mContext));
            Log.method_2106("[EasyTracker] report uncaught exceptions loaded: " + this.mIsReportUncaughtExceptionsEnabled);
        }

        boolean var9 = this.mParameterFetcher.getBoolean("ga_dryRun");
        this.mGoogleAnalytics.setDryRun(var9);
    }

    private void setContext(Context var1, ParameterLoader var2, ServiceManager var3) {
        if(var1 == null) {
            Log.method_2104("Context cannot be null");
        }

        this.mContext = var1.getApplicationContext();
        this.mServiceManager = var3;
        this.mParameterFetcher = var2;
        this.loadParameters();
    }

    public static void setResourcePackageName(String var0) {
        sResourcePackageName = var0;
    }

    public void activityStart(Activity var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_START);
        this.clearExistingTimer();
        if(!this.mIsInForeground && this.mActivitiesActive == 0 && this.checkForNewSession()) {
            this.mStartSessionOnNextSend = true;
        }

        this.mIsInForeground = true;
        ++this.mActivitiesActive;
        if(this.mIsAutoActivityTracking) {
            HashMap var2 = new HashMap();
            var2.put("&t", "appview");
            GAUsage.getInstance().setDisableUsage(true);
            this.set("&cd", this.getActivityName(var1));
            this.send(var2);
            GAUsage.getInstance().setDisableUsage(false);
        }

    }

    public void activityStop(Activity var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_STOP);
        this.mActivitiesActive += -1;
        this.mActivitiesActive = Math.max(0, this.mActivitiesActive);
        this.mLastOnStopTime = this.mClock.currentTimeMillis();
        if(this.mActivitiesActive == 0) {
            this.clearExistingTimer();
            this.mTimerTask = new EasyTracker.NotInForegroundTimerTask(null);
            this.mTimer = new Timer("waitForActivityStart");
            this.mTimer.schedule(this.mTimerTask, 1000L);
        }

    }

    boolean checkForNewSession() {
        return this.mSessionTimeout == 0L || this.mSessionTimeout > 0L && this.mClock.currentTimeMillis() > this.mLastOnStopTime + this.mSessionTimeout;
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.mServiceManager.dispatchLocalHits();
    }

    @VisibleForTesting
    int getActivitiesActive() {
        return this.mActivitiesActive;
    }

    @VisibleForTesting
    void overrideUncaughtExceptionHandler(UncaughtExceptionHandler var1) {
        if(this.mIsReportUncaughtExceptionsEnabled) {
            Thread.setDefaultUncaughtExceptionHandler(var1);
        }

    }

    public void send(Map<String, String> var1) {
        if(this.mStartSessionOnNextSend) {
            var1.put("&sc", "start");
            this.mStartSessionOnNextSend = false;
        }

        super.send(var1);
    }

    @VisibleForTesting
    void setClock(Clock var1) {
        this.mClock = var1;
    }

    private class NotInForegroundTimerTask extends TimerTask {
        private NotInForegroundTimerTask() {
        }

        // $FF: synthetic method
        NotInForegroundTimerTask(Object var2) {
            this();
        }

        public void run() {
            EasyTracker.this.mIsInForeground = false;
        }
    }
}

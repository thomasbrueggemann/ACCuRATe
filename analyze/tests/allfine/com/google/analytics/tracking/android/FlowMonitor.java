package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class FlowMonitor {
    static final String HITS_DISPATCHED = "hitsDispatched";
    static final String HITS_DISPATCHED_PARAM = "_s";
    static final String HITS_GENERATED = "hitsGenerated";
    static final String HITS_GENERATED_PARAM = "_g";
    static final String HITS_PAST_PROXY = "hitsPastProxy";
    static final String HITS_PAST_PROXY_PARAM = "_p";
    static final String HITS_STORED_IN_DB = "hitsStoredInDb";
    static final String HITS_STORED_IN_DB_PARAM = "_d";
    private static final int HIT_INTERVAL = 50;
    static final String LAST_QUERY_TIMESTAMP = "lastQueryTimestamp";
    static final String LAST_QUERY_TIMESTAMP_PARAM = "_ts";
    static final String MONITOR_TYPE = "flow";
    static final String MONITOR_TYPE_PARAM = "_t";
    static final String PREFERENCES_LABEL = "GoogleAnalytics";
    private static final long TIME_INTERVAL = 14400000L;
    private static FlowMonitor sInstance;
    Editor mEditor;
    private int mHitsDispatched;
    private int mHitsGenerated;
    private int mHitsPastProxy;
    private int mHitsStoredInDb;
    private long mLastQueryTimeStamp;
    SharedPreferences mPersistentStore;

    @VisibleForTesting
    FlowMonitor(Context var1) {
        this.mPersistentStore = var1.getSharedPreferences("GoogleAnalytics", 0);
        this.mEditor = this.mPersistentStore.edit();
        this.mHitsGenerated = this.mPersistentStore.getInt("hitsGenerated", 0);
        this.mHitsPastProxy = this.mPersistentStore.getInt("hitsPastProxy", 0);
        this.mHitsStoredInDb = this.mPersistentStore.getInt("hitsStoredInDb", 0);
        this.mHitsDispatched = this.mPersistentStore.getInt("hitsDispatched", 0);
        this.mLastQueryTimeStamp = this.mPersistentStore.getLong("lastQueryTimestamp", 0L);
        if(this.mLastQueryTimeStamp == 0L) {
            this.mLastQueryTimeStamp = System.currentTimeMillis();
            this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
            this.mEditor.commit();
        }

    }

    public static FlowMonitor getInstance(Context var0) {
        if(sInstance == null) {
            sInstance = new FlowMonitor(var0);
        }

        return sInstance;
    }

    public String buildAndResetHitsDispatched() {
        StringBuilder var1 = new StringBuilder();
        var1.append("_s").append("=").append(this.mHitsDispatched);
        this.mHitsDispatched = 0;
        this.mEditor.putInt("hitsDispatched", this.mHitsDispatched);
        this.mEditor.commit();
        return var1.toString();
    }

    public Map<String, String> generateHit() {
        HashMap var1 = new HashMap();
        var1.put("_t", "flow");
        var1.put("_ts", String.valueOf(this.mLastQueryTimeStamp));
        this.mLastQueryTimeStamp = System.currentTimeMillis();
        this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
        var1.put("_g", this.getAndResetHitsGeneratedParameter());
        return var1;
    }

    String getAndResetHitsGeneratedParameter() {
        String var1 = String.valueOf(this.mHitsGenerated);
        this.mHitsGenerated = 0;
        this.mEditor.putInt("hitsGenerated", 0);
        this.mEditor.commit();
        return var1;
    }

    public String getAndResetHitsPastProxy() {
        String var1 = String.valueOf(this.mHitsPastProxy);
        this.mHitsPastProxy = 0;
        this.mEditor.putInt("hitsPastProxy", this.mHitsPastProxy);
        this.mEditor.commit();
        return var1;
    }

    public String getAndResetHitsStoredInDb() {
        String var1 = String.valueOf(this.mHitsStoredInDb);
        this.mHitsStoredInDb = 0;
        this.mEditor.putInt("hitsStoredInDb", this.mHitsStoredInDb);
        this.mEditor.commit();
        return var1;
    }

    public void incrementHitsDispatched(int var1) {
        this.mHitsDispatched += var1;
        this.mEditor.putInt("hitsDispatched", var1);
        this.mEditor.commit();
    }

    public void incrementHitsGenerated(int var1) {
        this.mHitsGenerated += var1;
        this.mEditor.putInt("hitsGenerated", var1);
        this.mEditor.commit();
    }

    public void incrementHitsPastProxy(int var1) {
        this.mHitsPastProxy += var1;
        this.mEditor.putInt("hitsPastProxy", var1);
        this.mEditor.commit();
    }

    public void incrementHitsStoredInDb(int var1) {
        this.mHitsStoredInDb += var1;
        this.mEditor.putInt("hitsStoredInDb", var1);
        this.mEditor.commit();
    }

    public boolean shouldReport() {
        return this.mHitsGenerated >= 50 && System.currentTimeMillis() - this.mLastQueryTimeStamp >= 14400000L;
    }
}

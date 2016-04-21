package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_925;
import com.google.android.gms.analytics.class_926;
import com.google.android.gms.analytics.class_927;
import com.google.android.gms.analytics.class_929;
import com.google.android.gms.analytics.class_930;
import com.google.android.gms.analytics.class_931;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_940;
import com.google.android.gms.analytics.class_941;
import com.google.android.gms.analytics.class_942;
import com.google.android.gms.analytics.class_950;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    // $FF: renamed from: AC com.google.android.gms.analytics.GoogleAnalytics
    private static GoogleAnalytics field_2142;
    // $FF: renamed from: Av boolean
    private static boolean field_2143;
    // $FF: renamed from: AA java.util.Set
    private Set<GoogleAnalytics.class_1215> field_2144;
    // $FF: renamed from: AB boolean
    private boolean field_2145;
    // $FF: renamed from: Aw boolean
    private boolean field_2146;
    // $FF: renamed from: Ax com.google.android.gms.analytics.ae
    private class_930 field_2147;
    // $FF: renamed from: Ay java.lang.Boolean
    private volatile Boolean field_2148;
    // $FF: renamed from: Az com.google.android.gms.analytics.Logger
    private Logger field_2149;
    private Context mContext;
    // $FF: renamed from: xL java.lang.String
    private String field_2150;
    // $FF: renamed from: xM java.lang.String
    private String field_2151;
    // $FF: renamed from: ye com.google.android.gms.analytics.f
    private class_174 field_2152;

    protected GoogleAnalytics(Context var1) {
        this(var1, class_941.method_4868(var1), class_931.method_4814());
    }

    private GoogleAnalytics(Context var1, class_174 var2, class_930 var3) {
        this.field_2148 = Boolean.valueOf(false);
        this.field_2145 = false;
        if(var1 == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else {
            this.mContext = var1.getApplicationContext();
            this.field_2152 = var2;
            this.field_2147 = var3;
            class_926.method_4777(this.mContext);
            class_950.method_4999(this.mContext);
            class_927.method_4786(this.mContext);
            this.field_2149 = new class_929();
            this.field_2144 = new HashSet();
            this.method_3059();
        }
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.Tracker) com.google.android.gms.analytics.Tracker
    private Tracker method_3056(Tracker var1) {
        if(this.field_2150 != null) {
            var1.set("&an", this.field_2150);
        }

        if(this.field_2151 != null) {
            var1.set("&av", this.field_2151);
        }

        return var1;
    }

    // $FF: renamed from: ai (java.lang.String) int
    private int method_3057(String var1) {
        String var2 = var1.toLowerCase();
        return "verbose".equals(var2)?0:("info".equals(var2)?1:("warning".equals(var2)?2:("error".equals(var2)?3:-1)));
    }

    // $FF: renamed from: eD () com.google.android.gms.analytics.GoogleAnalytics
    static GoogleAnalytics method_3058() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: eE () void
    private void method_3059() {
        if(!field_2143) {
            ApplicationInfo var2;
            label24: {
                ApplicationInfo var6;
                try {
                    var6 = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
                } catch (NameNotFoundException var7) {
                    class_938.method_4860("PackageManager doesn\'t know about package: " + var7);
                    var2 = null;
                    break label24;
                }

                var2 = var6;
            }

            if(var2 == null) {
                class_938.method_4861("Couldn\'t get ApplicationInfo to load gloabl config.");
                return;
            }

            Bundle var3 = var2.metaData;
            if(var3 != null) {
                int var4 = var3.getInt("com.google.android.gms.analytics.globalConfigResource");
                if(var4 > 0) {
                    class_942 var5 = (class_942)(new class_925(this.mContext)).w(var4);
                    if(var5 != null) {
                        this.method_3061(var5);
                        return;
                    }
                }
            }
        }

    }

    public static GoogleAnalytics getInstance(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.GoogleAnalytics$a) void
    void method_3060(GoogleAnalytics.class_1215 var1) {
        this.field_2144.add(var1);
        if(this.mContext instanceof Application) {
            this.enableAutoActivityReports((Application)this.mContext);
        }

    }

    // $FF: renamed from: a (com.google.android.gms.analytics.v) void
    void method_3061(class_942 var1) {
        class_938.method_4860("Loading global config values.");
        if(var1.method_4889()) {
            this.field_2150 = var1.method_4890();
            class_938.method_4860("app name loaded: " + this.field_2150);
        }

        if(var1.method_4891()) {
            this.field_2151 = var1.method_4892();
            class_938.method_4860("app version loaded: " + this.field_2151);
        }

        if(var1.method_4893()) {
            int var2 = this.method_3057(var1.method_4894());
            if(var2 >= 0) {
                class_938.method_4860("log level loaded: " + var2);
                this.getLogger().setLogLevel(var2);
            }
        }

        if(var1.method_4895()) {
            this.field_2147.setLocalDispatchPeriod(var1.method_4886());
        }

        if(var1.method_4887()) {
            this.setDryRun(var1.method_4888());
        }

    }

    // $FF: renamed from: b (com.google.android.gms.analytics.GoogleAnalytics$a) void
    void method_3062(GoogleAnalytics.class_1215 var1) {
        this.field_2144.remove(var1);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.field_2147.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application var1) {
        if(VERSION.SDK_INT >= 14 && !this.field_2145) {
            var1.registerActivityLifecycleCallbacks(new GoogleAnalytics.class_1216());
            this.field_2145 = true;
        }

    }

    // $FF: renamed from: g (android.app.Activity) void
    void method_3063(Activity var1) {
        Iterator var2 = this.field_2144.iterator();

        while(var2.hasNext()) {
            ((GoogleAnalytics.class_1215)var2.next()).method_163(var1);
        }

    }

    public boolean getAppOptOut() {
        class_940.method_4863().method_4865(class_940.class_1617.field_4937);
        return this.field_2148.booleanValue();
    }

    public Logger getLogger() {
        return this.field_2149;
    }

    // $FF: renamed from: h (android.app.Activity) void
    void method_3064(Activity var1) {
        Iterator var2 = this.field_2144.iterator();

        while(var2.hasNext()) {
            ((GoogleAnalytics.class_1215)var2.next()).method_164(var1);
        }

    }

    public boolean isDryRunEnabled() {
        class_940.method_4863().method_4865(class_940.class_1617.field_4906);
        return this.field_2146;
    }

    public Tracker newTracker(int param1) {
        // $FF: Couldn't be decompiled
    }

    public Tracker newTracker(String param1) {
        // $FF: Couldn't be decompiled
    }

    public void reportActivityStart(Activity var1) {
        if(!this.field_2145) {
            this.method_3063(var1);
        }

    }

    public void reportActivityStop(Activity var1) {
        if(!this.field_2145) {
            this.method_3064(var1);
        }

    }

    public void setAppOptOut(boolean var1) {
        class_940.method_4863().method_4865(class_940.class_1617.field_4936);
        this.field_2148 = Boolean.valueOf(var1);
        if(this.field_2148.booleanValue()) {
            this.field_2152.method_819();
        }

    }

    public void setDryRun(boolean var1) {
        class_940.method_4863().method_4865(class_940.class_1617.field_4905);
        this.field_2146 = var1;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int var1) {
        this.field_2147.setLocalDispatchPeriod(var1);
    }

    public void setLogger(Logger var1) {
        class_940.method_4863().method_4865(class_940.class_1617.field_4907);
        this.field_2149 = var1;
    }

    // $FF: renamed from: u (java.util.Map) void
    void method_3055(Map<String, String> param1) {
        // $FF: Couldn't be decompiled
    }

    interface class_1215 {
        // $FF: renamed from: i (android.app.Activity) void
        void method_163(Activity var1);

        // $FF: renamed from: j (android.app.Activity) void
        void method_164(Activity var1);
    }

    class class_1216 implements ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity var1, Bundle var2) {
        }

        public void onActivityDestroyed(Activity var1) {
        }

        public void onActivityPaused(Activity var1) {
        }

        public void onActivityResumed(Activity var1) {
        }

        public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
        }

        public void onActivityStarted(Activity var1) {
            GoogleAnalytics.this.method_3063(var1);
        }

        public void onActivityStopped(Activity var1) {
            GoogleAnalytics.this.method_3064(var1);
        }
    }
}

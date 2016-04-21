package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.TrackerHandler;
import com.google.android.gms.analytics.class_182;
import com.google.android.gms.analytics.class_926;
import com.google.android.gms.analytics.class_927;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_939;
import com.google.android.gms.analytics.class_940;
import com.google.android.gms.analytics.class_950;
import com.google.android.gms.analytics.class_953;
import com.google.android.gms.analytics.class_954;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    // $FF: renamed from: Bm com.google.android.gms.analytics.TrackerHandler
    private final TrackerHandler field_3956;
    // $FF: renamed from: Bn com.google.android.gms.analytics.ac
    private class_182 field_3957;
    // $FF: renamed from: Bo com.google.android.gms.analytics.h
    private final class_927 field_3958;
    // $FF: renamed from: Bp com.google.android.gms.analytics.ad
    private final class_950 field_3959;
    // $FF: renamed from: Bq com.google.android.gms.analytics.g
    private final class_926 field_3960;
    // $FF: renamed from: Br boolean
    private boolean field_3961;
    // $FF: renamed from: Bs com.google.android.gms.analytics.Tracker$a
    private Tracker.class_1180 field_3962;
    // $FF: renamed from: Bt com.google.android.gms.analytics.ai
    private class_954 field_3963;
    // $FF: renamed from: Bu com.google.android.gms.analytics.ExceptionReporter
    private ExceptionReporter field_3964;
    private Context mContext;
    // $FF: renamed from: qM java.util.Map
    private final Map<String, String> field_3965;

    Tracker(String var1, TrackerHandler var2, Context var3) {
        this(var1, var2, class_927.method_4783(), class_950.method_4998(), class_926.method_4776(), new class_939("tracking"), var3);
    }

    Tracker(String var1, TrackerHandler var2, class_927 var3, class_950 var4, class_926 var5, class_182 var6, Context var7) {
        this.field_3965 = new HashMap();
        this.field_3956 = var2;
        if(var7 != null) {
            this.mContext = var7.getApplicationContext();
        }

        if(var1 != null) {
            this.field_3965.put("&tid", var1);
        }

        this.field_3965.put("useSecure", "1");
        this.field_3958 = var3;
        this.field_3959 = var4;
        this.field_3960 = var5;
        this.field_3965.put("&a", Integer.toString(1 + (new Random()).nextInt(Integer.MAX_VALUE)));
        this.field_3957 = var6;
        this.field_3962 = new Tracker.class_1180();
        this.enableAdvertisingIdCollection(false);
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.ai) void
    void method_4373(class_954 var1) {
        class_938.method_4860("Loading Tracker config values.");
        this.field_3963 = var1;
        if(this.field_3963.method_5029()) {
            String var3 = this.field_3963.method_5030();
            this.set("&tid", var3);
            class_938.method_4860("[Tracker] trackingId loaded: " + var3);
        }

        if(this.field_3963.method_5031()) {
            String var2 = Double.toString(this.field_3963.method_5032());
            this.set("&sf", var2);
            class_938.method_4860("[Tracker] sample frequency loaded: " + var2);
        }

        if(this.field_3963.method_5033()) {
            this.setSessionTimeout((long)this.field_3963.getSessionTimeout());
            class_938.method_4860("[Tracker] session timeout loaded: " + this.method_4374());
        }

        if(this.field_3963.method_5034()) {
            this.enableAutoActivityTracking(this.field_3963.method_5035());
            class_938.method_4860("[Tracker] auto activity tracking loaded: " + this.method_4375());
        }

        if(this.field_3963.method_5036()) {
            if(this.field_3963.method_5037()) {
                this.set("&aip", "1");
                class_938.method_4860("[Tracker] anonymize ip loaded: true");
            }

            class_938.method_4860("[Tracker] anonymize ip loaded: false");
        }

        this.enableExceptionReporting(this.field_3963.method_5038());
    }

    // $FF: renamed from: eT () long
    long method_4374() {
        return this.field_3962.method_2292();
    }

    // $FF: renamed from: eU () boolean
    boolean method_4375() {
        return this.field_3962.method_2293();
    }

    public void enableAdvertisingIdCollection(boolean var1) {
        if(!var1) {
            this.field_3965.put("&ate", (Object)null);
            this.field_3965.put("&adid", (Object)null);
        } else {
            if(this.field_3965.containsKey("&ate")) {
                this.field_3965.remove("&ate");
            }

            if(this.field_3965.containsKey("&adid")) {
                this.field_3965.remove("&adid");
                return;
            }
        }

    }

    public void enableAutoActivityTracking(boolean var1) {
        this.field_3962.enableAutoActivityTracking(var1);
    }

    public void enableExceptionReporting(boolean var1) {
        if(this.field_3961 != var1) {
            this.field_3961 = var1;
            if(var1) {
                this.field_3964 = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.field_3964);
                class_938.method_4860("Uncaught exceptions will be reported to Google Analytics.");
            } else {
                if(this.field_3964 != null) {
                    Thread.setDefaultUncaughtExceptionHandler(this.field_3964.method_5441());
                } else {
                    Thread.setDefaultUncaughtExceptionHandler((UncaughtExceptionHandler)null);
                }

                class_938.method_4860("Uncaught exceptions will not be reported to Google Analytics.");
            }
        }
    }

    public String get(String var1) {
        class_940.method_4863().method_4865(class_940.class_1617.field_4950);
        if(!TextUtils.isEmpty(var1)) {
            if(this.field_3965.containsKey(var1)) {
                return (String)this.field_3965.get(var1);
            }

            if(var1.equals("&ul")) {
                return class_953.method_5021(Locale.getDefault());
            }

            if(this.field_3958 != null && this.field_3958.method_4787(var1)) {
                return this.field_3958.getValue(var1);
            }

            if(this.field_3959 != null && this.field_3959.method_5000(var1)) {
                return this.field_3959.getValue(var1);
            }

            if(this.field_3960 != null && this.field_3960.method_4778(var1)) {
                return this.field_3960.getValue(var1);
            }
        }

        return null;
    }

    public void send(Map<String, String> var1) {
        class_940.method_4863().method_4865(class_940.class_1617.field_4952);
        HashMap var2 = new HashMap();
        var2.putAll(this.field_3965);
        if(var1 != null) {
            var2.putAll(var1);
        }

        if(TextUtils.isEmpty((CharSequence)var2.get("&tid"))) {
            class_938.method_4861(String.format("Missing tracking id (%s) parameter.", new Object[] {"&tid"}));
        }

        String var3 = (String)var2.get("&t");
        if(TextUtils.isEmpty(var3)) {
            class_938.method_4861(String.format("Missing hit type (%s) parameter.", new Object[] {"&t"}));
            var3 = "";
        }

        if(this.field_3962.method_2294()) {
            var2.put("&sc", "start");
        }

        String var4 = var3.toLowerCase();
        if("screenview".equals(var4) || "pageview".equals(var4) || "appview".equals(var4) || TextUtils.isEmpty(var4)) {
            int var5 = 1 + Integer.parseInt((String)this.field_3965.get("&a"));
            if(var5 >= Integer.MAX_VALUE) {
                var5 = 1;
            }

            this.field_3965.put("&a", Integer.toString(var5));
        }

        if(!var4.equals("transaction") && !var4.equals("item") && !this.field_3957.method_839()) {
            class_938.method_4861("Too many hits sent too quickly, rate limiting invoked.");
        } else {
            this.field_3956.method_3055(var2);
        }
    }

    public void set(String var1, String var2) {
        class_1090.method_5681(var1, "Key should be non-null");
        class_940.method_4863().method_4865(class_940.class_1617.field_4951);
        this.field_3965.put(var1, var2);
    }

    public void setAnonymizeIp(boolean var1) {
        this.set("&aip", class_953.method_5019(var1));
    }

    public void setAppId(String var1) {
        this.set("&aid", var1);
    }

    public void setAppInstallerId(String var1) {
        this.set("&aiid", var1);
    }

    public void setAppName(String var1) {
        this.set("&an", var1);
    }

    public void setAppVersion(String var1) {
        this.set("&av", var1);
    }

    public void setClientId(String var1) {
        this.set("&cid", var1);
    }

    public void setEncoding(String var1) {
        this.set("&de", var1);
    }

    public void setHostname(String var1) {
        this.set("&dh", var1);
    }

    public void setLanguage(String var1) {
        this.set("&ul", var1);
    }

    public void setLocation(String var1) {
        this.set("&dl", var1);
    }

    public void setPage(String var1) {
        this.set("&dp", var1);
    }

    public void setReferrer(String var1) {
        this.set("&dr", var1);
    }

    public void setSampleRate(double var1) {
        this.set("&sf", Double.toHexString(var1));
    }

    public void setScreenColors(String var1) {
        this.set("&sd", var1);
    }

    public void setScreenName(String var1) {
        this.set("&cd", var1);
    }

    public void setScreenResolution(int var1, int var2) {
        if(var1 < 0 && var2 < 0) {
            class_938.method_4861("Invalid width or height. The values should be non-negative.");
        } else {
            this.set("&sr", var1 + "x" + var2);
        }
    }

    public void setSessionTimeout(long var1) {
        this.field_3962.setSessionTimeout(1000L * var1);
    }

    public void setTitle(String var1) {
        this.set("&dt", var1);
    }

    public void setUseSecure(boolean var1) {
        this.set("useSecure", class_953.method_5019(var1));
    }

    public void setViewportSize(String var1) {
        this.set("&vp", var1);
    }

    private class class_1180 implements GoogleAnalytics.class_1215 {
        // $FF: renamed from: Bv boolean
        private boolean field_1129 = false;
        // $FF: renamed from: Bw int
        private int field_1130 = 0;
        // $FF: renamed from: Bx long
        private long field_1131 = -1L;
        // $FF: renamed from: By boolean
        private boolean field_1132 = false;
        // $FF: renamed from: Bz long
        private long field_1133;
        // $FF: renamed from: yD com.google.android.gms.internal.ju
        private class_20 field_1134 = class_346.method_2326();

        // $FF: renamed from: eW () void
        private void method_2291() {
            GoogleAnalytics var1 = GoogleAnalytics.method_3058();
            if(var1 == null) {
                class_938.method_4858("GoogleAnalytics isn\'t initialized for the Tracker!");
            } else if(this.field_1131 < 0L && !this.field_1129) {
                var1.method_3062(Tracker.this.field_3962);
            } else {
                var1.method_3060(Tracker.this.field_3962);
            }
        }

        // $FF: renamed from: eT () long
        public long method_2292() {
            return this.field_1131;
        }

        // $FF: renamed from: eU () boolean
        public boolean method_2293() {
            return this.field_1129;
        }

        // $FF: renamed from: eV () boolean
        public boolean method_2294() {
            boolean var1 = this.field_1132;
            this.field_1132 = false;
            return var1;
        }

        // $FF: renamed from: eX () boolean
        boolean method_2295() {
            return this.field_1134.elapsedRealtime() >= this.field_1133 + Math.max(1000L, this.field_1131);
        }

        public void enableAutoActivityTracking(boolean var1) {
            this.field_1129 = var1;
            this.method_2291();
        }

        // $FF: renamed from: i (android.app.Activity) void
        public void method_163(Activity var1) {
            class_940.method_4863().method_4865(class_940.class_1617.field_4911);
            if(this.field_1130 == 0 && this.method_2295()) {
                this.field_1132 = true;
            }

            ++this.field_1130;
            if(this.field_1129) {
                HashMap var2 = new HashMap();
                var2.put("&t", "screenview");
                class_940.method_4863().method_4864(true);
                Tracker var4 = Tracker.this;
                String var5;
                if(Tracker.this.field_3963 != null) {
                    var5 = Tracker.this.field_3963.method_5039(var1);
                } else {
                    var5 = var1.getClass().getCanonicalName();
                }

                var4.set("&cd", var5);
                Tracker.this.send(var2);
                class_940.method_4863().method_4864(false);
            }

        }

        // $FF: renamed from: j (android.app.Activity) void
        public void method_164(Activity var1) {
            class_940.method_4863().method_4865(class_940.class_1617.field_4912);
            this.field_1130 += -1;
            this.field_1130 = Math.max(0, this.field_1130);
            if(this.field_1130 == 0) {
                this.field_1133 = this.field_1134.elapsedRealtime();
            }

        }

        public void setSessionTimeout(long var1) {
            this.field_1131 = var1;
            this.method_2291();
        }
    }
}

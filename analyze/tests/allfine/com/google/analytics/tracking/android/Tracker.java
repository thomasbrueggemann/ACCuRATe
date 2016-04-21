package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.AppFieldsDefaultProvider;
import com.google.analytics.tracking.android.ClientIdDefaultProvider;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.RateLimiter;
import com.google.analytics.tracking.android.ScreenResolutionDefaultProvider;
import com.google.analytics.tracking.android.SendHitRateLimiter;
import com.google.analytics.tracking.android.TrackerHandler;
import com.google.analytics.tracking.android.Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker {
    private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
    private final ClientIdDefaultProvider mClientIdDefaultProvider;
    private final TrackerHandler mHandler;
    private final String mName;
    private final Map<String, String> mParams;
    private RateLimiter mRateLimiter;
    private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;

    Tracker(String var1, String var2, TrackerHandler var3) {
        this(var1, var2, var3, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider(), new SendHitRateLimiter());
    }

    @VisibleForTesting
    Tracker(String var1, String var2, TrackerHandler var3, ClientIdDefaultProvider var4, ScreenResolutionDefaultProvider var5, AppFieldsDefaultProvider var6, RateLimiter var7) {
        this.mParams = new HashMap();
        if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        } else {
            this.mName = var1;
            this.mHandler = var3;
            this.mParams.put("&tid", var2);
            this.mParams.put("useSecure", "1");
            this.mClientIdDefaultProvider = var4;
            this.mScreenResolutionDefaultProvider = var5;
            this.mAppFieldsDefaultProvider = var6;
            this.mRateLimiter = var7;
        }
    }

    public String get(String var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET);
        if(!TextUtils.isEmpty(var1)) {
            if(this.mParams.containsKey(var1)) {
                return (String)this.mParams.get(var1);
            }

            if(var1.equals("&ul")) {
                return Utils.getLanguage(Locale.getDefault());
            }

            if(this.mClientIdDefaultProvider != null && this.mClientIdDefaultProvider.providesField(var1)) {
                return this.mClientIdDefaultProvider.getValue(var1);
            }

            if(this.mScreenResolutionDefaultProvider != null && this.mScreenResolutionDefaultProvider.providesField(var1)) {
                return this.mScreenResolutionDefaultProvider.getValue(var1);
            }

            if(this.mAppFieldsDefaultProvider != null && this.mAppFieldsDefaultProvider.providesField(var1)) {
                return this.mAppFieldsDefaultProvider.getValue(var1);
            }
        }

        return null;
    }

    public String getName() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
        return this.mName;
    }

    @VisibleForTesting
    RateLimiter getRateLimiter() {
        return this.mRateLimiter;
    }

    public void send(Map<String, String> var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
        HashMap var2 = new HashMap();
        var2.putAll(this.mParams);
        if(var1 != null) {
            var2.putAll(var1);
        }

        if(TextUtils.isEmpty((CharSequence)var2.get("&tid"))) {
            Log.method_2107(String.format("Missing tracking id (%s) parameter.", new Object[] {"&tid"}));
        }

        String var3 = (String)var2.get("&t");
        if(TextUtils.isEmpty(var3)) {
            Log.method_2107(String.format("Missing hit type (%s) parameter.", new Object[] {"&t"}));
            var3 = "";
        }

        if(!var3.equals("transaction") && !var3.equals("item") && !this.mRateLimiter.tokenAvailable()) {
            Log.method_2107("Too many hits sent too quickly, rate limiting invoked.");
        } else {
            this.mHandler.sendHit(var2);
        }
    }

    public void set(String var1, String var2) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET);
        if(var2 == null) {
            this.mParams.remove(var1);
        } else {
            this.mParams.put(var1, var2);
        }
    }
}

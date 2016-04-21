package com.google.analytics.tracking.android;

import android.text.TextUtils;

class Hit {
    private final long mHitId;
    private String mHitString;
    private final long mHitTime;
    private String mHitUrlScheme = "https:";

    Hit(String var1, long var2, long var4) {
        this.mHitString = var1;
        this.mHitId = var2;
        this.mHitTime = var4;
    }

    long getHitId() {
        return this.mHitId;
    }

    String getHitParams() {
        return this.mHitString;
    }

    long getHitTime() {
        return this.mHitTime;
    }

    String getHitUrlScheme() {
        return this.mHitUrlScheme;
    }

    void setHitString(String var1) {
        this.mHitString = var1;
    }

    void setHitUrl(String var1) {
        if(var1 != null && !TextUtils.isEmpty(var1.trim()) && var1.toLowerCase().startsWith("http:")) {
            this.mHitUrlScheme = "http:";
        }
    }
}

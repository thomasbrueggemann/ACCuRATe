package com.google.tagmanager;

import android.text.TextUtils;

class Hit {
    private final long mHitFirstDispatchTime;
    private final long mHitId;
    private final long mHitTime;
    private String mHitUrl;

    Hit(long var1, long var3) {
        this.mHitId = var1;
        this.mHitTime = var3;
        this.mHitFirstDispatchTime = 0L;
    }

    Hit(long var1, long var3, long var5) {
        this.mHitId = var1;
        this.mHitTime = var3;
        this.mHitFirstDispatchTime = var5;
    }

    long getHitFirstDispatchTime() {
        return this.mHitFirstDispatchTime;
    }

    long getHitId() {
        return this.mHitId;
    }

    long getHitTime() {
        return this.mHitTime;
    }

    String getHitUrl() {
        return this.mHitUrl;
    }

    void setHitUrl(String var1) {
        if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
            this.mHitUrl = var1;
        }
    }
}

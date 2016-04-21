package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.RateLimiter;

class SendHitRateLimiter implements RateLimiter {
    private long mLastTrackTime;
    private final int mMaxTokens;
    private final long mMillisecondsPerToken;
    private final Object mTokenLock;
    private double mTokens;

    public SendHitRateLimiter() {
        this(60, 2000L);
    }

    public SendHitRateLimiter(int var1, long var2) {
        this.mTokenLock = new Object();
        this.mMaxTokens = var1;
        this.mTokens = (double)this.mMaxTokens;
        this.mMillisecondsPerToken = var2;
    }

    @VisibleForTesting
    void setLastTrackTime(long var1) {
        this.mLastTrackTime = var1;
    }

    @VisibleForTesting
    void setTokensAvailable(long var1) {
        this.mTokens = (double)var1;
    }

    public boolean tokenAvailable() {
        // $FF: Couldn't be decompiled
    }
}

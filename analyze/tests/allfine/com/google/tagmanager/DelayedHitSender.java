package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.HitSender;
import com.google.tagmanager.HitSendingThread;
import com.google.tagmanager.HitSendingThreadImpl;
import com.google.tagmanager.Log;
import com.google.tagmanager.RateLimiter;
import com.google.tagmanager.SendHitRateLimiter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class DelayedHitSender implements HitSender {
    private static DelayedHitSender sInstance;
    private static final Object sInstanceLock = new Object();
    private RateLimiter mRateLimiter;
    private HitSendingThread mSendingThread;
    private String mWrapperQueryParameter;
    private String mWrapperUrl;

    private DelayedHitSender(Context var1) {
        this(HitSendingThreadImpl.getInstance(var1), new SendHitRateLimiter());
    }

    @VisibleForTesting
    DelayedHitSender(HitSendingThread var1, RateLimiter var2) {
        this.mSendingThread = var1;
        this.mRateLimiter = var2;
    }

    public static HitSender getInstance(Context param0) {
        // $FF: Couldn't be decompiled
    }

    public boolean sendHit(String var1) {
        if(!this.mRateLimiter.tokenAvailable()) {
            Log.method_5509("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        } else {
            if(this.mWrapperUrl != null && this.mWrapperQueryParameter != null) {
                try {
                    var1 = this.mWrapperUrl + "?" + this.mWrapperQueryParameter + "=" + URLEncoder.encode(var1, "UTF-8");
                    Log.method_5507("Sending wrapped url hit: " + var1);
                } catch (UnsupportedEncodingException var3) {
                    Log.method_5510("Error wrapping URL for testing.", var3);
                    return false;
                }
            }

            this.mSendingThread.sendHit(var1);
            return true;
        }
    }

    public void setUrlWrapModeForTesting(String var1, String var2) {
        this.mWrapperUrl = var1;
        this.mWrapperQueryParameter = var2;
    }
}

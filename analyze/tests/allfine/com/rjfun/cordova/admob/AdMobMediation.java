package com.rjfun.cordova.admob;

import android.app.Activity;
import com.google.android.gms.ads.AdRequest;
import org.json.JSONObject;

public abstract class AdMobMediation {
    public AdMobMediation(Activity var1, JSONObject var2) {
    }

    public abstract AdRequest.Builder joinAdRequest(AdRequest.Builder var1);

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }
}

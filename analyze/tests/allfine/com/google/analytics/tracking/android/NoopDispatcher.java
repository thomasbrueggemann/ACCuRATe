package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.Dispatcher;
import com.google.analytics.tracking.android.Hit;
import com.google.analytics.tracking.android.HitBuilder;
import com.google.analytics.tracking.android.Log;
import java.util.List;

class NoopDispatcher implements Dispatcher {
    public void close() {
    }

    public int dispatchHits(List<Hit> var1) {
        int var2;
        if(var1 == null) {
            var2 = 0;
        } else {
            var2 = Math.min(var1.size(), 40);
            if(Log.isVerbose()) {
                Log.method_2106("Hits not actually being sent as dispatch is false...");

                for(int var3 = 0; var3 < var2; ++var3) {
                    String var4;
                    if(TextUtils.isEmpty(((Hit)var1.get(var3)).getHitParams())) {
                        var4 = "";
                    } else {
                        var4 = HitBuilder.postProcessHit((Hit)var1.get(var3), System.currentTimeMillis());
                    }

                    String var5;
                    if(TextUtils.isEmpty(var4)) {
                        var5 = "Hit couldn\'t be read, wouldn\'t be sent:";
                    } else if(var4.length() <= 2036) {
                        var5 = "GET would be sent:";
                    } else if(var4.length() > 8192) {
                        var5 = "Would be too big:";
                    } else {
                        var5 = "POST would be sent:";
                    }

                    Log.method_2106(var5 + var4);
                }
            }
        }

        return var2;
    }

    public boolean okToDispatch() {
        return true;
    }

    public void overrideHostUrl(String var1) {
    }
}

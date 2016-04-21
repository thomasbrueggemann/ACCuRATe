package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.analytics.tracking.android.Dispatcher;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Hit;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private GoogleAnalytics gaInstance;
    private final HttpClient httpClient;
    private URL mOverrideHostUrl;
    private final String userAgent;

    SimpleNetworkDispatcher(HttpClient var1, Context var2) {
        this(var1, GoogleAnalytics.getInstance(var2), var2);
    }

    @VisibleForTesting
    SimpleNetworkDispatcher(HttpClient var1, GoogleAnalytics var2, Context var3) {
        this.ctx = var3.getApplicationContext();
        this.userAgent = this.createUserAgentString("GoogleAnalytics", "3.0", VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClient = var1;
        this.gaInstance = var2;
    }

    private HttpEntityEnclosingRequest buildRequest(String var1, String var2) {
        if(TextUtils.isEmpty(var1)) {
            Log.method_2107("Empty hit, discarding.");
            return null;
        } else {
            String var3 = var2 + "?" + var1;
            BasicHttpEntityEnclosingRequest var4;
            if(var3.length() < 2036) {
                var4 = new BasicHttpEntityEnclosingRequest("GET", var3);
            } else {
                var4 = new BasicHttpEntityEnclosingRequest("POST", var2);

                try {
                    var4.setEntity(new StringEntity(var1));
                } catch (UnsupportedEncodingException var6) {
                    Log.method_2107("Encoding error, discarding hit");
                    return null;
                }
            }

            var4.addHeader("User-Agent", this.userAgent);
            return var4;
        }
    }

    private void logDebugInformation(HttpEntityEnclosingRequest param1) {
        // $FF: Couldn't be decompiled
    }

    public void close() {
        this.httpClient.getConnectionManager().shutdown();
    }

    String createUserAgentString(String var1, String var2, String var3, String var4, String var5, String var6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {var1, var2, var3, var4, var5, var6});
    }

    public int dispatchHits(List<Hit> param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    URL getUrl(Hit param1) {
        // $FF: Couldn't be decompiled
    }

    public boolean okToDispatch() {
        NetworkInfo var1 = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if(var1 != null && var1.isConnected()) {
            return true;
        } else {
            Log.method_2106("...no network connectivity");
            return false;
        }
    }

    @VisibleForTesting
    public void overrideHostUrl(String var1) {
        try {
            this.mOverrideHostUrl = new URL(var1);
        } catch (MalformedURLException var3) {
            this.mOverrideHostUrl = null;
        }
    }
}

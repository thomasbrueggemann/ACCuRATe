package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Dispatcher;
import com.google.tagmanager.Hit;
import com.google.tagmanager.Log;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private SimpleNetworkDispatcher.DispatchListener dispatchListener;
    private final HttpClient httpClient;
    private final String userAgent;

    @VisibleForTesting
    SimpleNetworkDispatcher(HttpClient var1, Context var2, SimpleNetworkDispatcher.DispatchListener var3) {
        this.ctx = var2.getApplicationContext();
        this.userAgent = this.createUserAgentString("GoogleTagManager", "3.02", VERSION.RELEASE, getUserAgentLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClient = var1;
        this.dispatchListener = var3;
    }

    private HttpEntityEnclosingRequest constructGtmRequest(URL var1) {
        BasicHttpEntityEnclosingRequest var2 = null;

        URISyntaxException var4;
        label19: {
            BasicHttpEntityEnclosingRequest var3;
            try {
                var3 = new BasicHttpEntityEnclosingRequest("GET", var1.toURI().toString());
            } catch (URISyntaxException var6) {
                var4 = var6;
                break label19;
            }

            try {
                var3.addHeader("User-Agent", this.userAgent);
                return var3;
            } catch (URISyntaxException var5) {
                var4 = var5;
                var2 = var3;
            }
        }

        Log.method_5509("Exception sending hit: " + var4.getClass().getSimpleName());
        Log.method_5509(var4.getMessage());
        return var2;
    }

    static String getUserAgentLanguage(Locale var0) {
        if(var0 != null && var0.getLanguage() != null && var0.getLanguage().length() != 0) {
            StringBuilder var1 = new StringBuilder();
            var1.append(var0.getLanguage().toLowerCase());
            if(var0.getCountry() != null && var0.getCountry().length() != 0) {
                var1.append("-").append(var0.getCountry().toLowerCase());
            }

            return var1.toString();
        } else {
            return null;
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

    public void dispatchHits(List<Hit> param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    URL getUrl(Hit var1) {
        String var2 = var1.getHitUrl();

        try {
            URL var3 = new URL(var2);
            return var3;
        } catch (MalformedURLException var5) {
            Log.method_5503("Error trying to parse the GTM url.");
            return null;
        }
    }

    public boolean okToDispatch() {
        NetworkInfo var1 = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if(var1 != null && var1.isConnected()) {
            return true;
        } else {
            Log.method_5507("...no network connectivity");
            return false;
        }
    }

    public interface DispatchListener {
        void onHitDispatched(Hit var1);

        void onHitPermanentDispatchFailure(Hit var1);

        void onHitTransientDispatchFailure(Hit var1);
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.ez;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// $FF: renamed from: com.google.android.gms.internal.gy
@ez
public class class_365 extends class_364 {
    public class_365(class_381 var1, boolean var2) {
        super(var1, var2);
    }

    // $FF: renamed from: d (android.content.Context, java.lang.String, java.lang.String) android.webkit.WebResourceResponse
    protected WebResourceResponse method_2409(Context var1, String var2, String var3) throws IOException {
        HttpURLConnection var4 = (HttpURLConnection)(new URL(var3)).openConnection();

        WebResourceResponse var6;
        try {
            class_383.method_2512(var1, var2, true, var4, true);
            var4.addRequestProperty("Cache-Control", "max-stale=3600");
            var4.connect();
            var6 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(class_383.method_2504(new InputStreamReader(var4.getInputStream())).getBytes("UTF-8")));
        } finally {
            var4.disconnect();
        }

        return var6;
    }

    public WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
        try {
            if(!"mraid.js".equalsIgnoreCase((new File(var2)).getName())) {
                return super.shouldInterceptRequest(var1, var2);
            } else if(!(var1 instanceof class_381)) {
                class_378.method_2461("Tried to intercept request from a WebView that wasn\'t an AdWebView.");
                return super.shouldInterceptRequest(var1, var2);
            } else {
                class_381 var4 = (class_381)var1;
                var4.method_2486().method_2404();
                if(var4.method_2475().field_637) {
                    class_378.method_2460("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                    return this.method_2409(var4.getContext(), this.md.method_2489().field_1387, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
                } else if(var4.method_2490()) {
                    class_378.method_2460("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                    return this.method_2409(var4.getContext(), this.md.method_2489().field_1387, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
                } else {
                    class_378.method_2460("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
                    WebResourceResponse var5 = this.method_2409(var4.getContext(), this.md.method_2489().field_1387, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
                    return var5;
                }
            }
        } catch (IOException var6) {
            class_378.method_2461("Could not fetch MRAID JS. " + var6.getMessage());
            return super.shouldInterceptRequest(var1, var2);
        }
    }
}

package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.aa;
import com.google.android.gms.analytics.class_177;
import com.google.android.gms.analytics.class_937;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_952;
import com.google.android.gms.analytics.class_953;
import com.google.android.gms.analytics.w;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// $FF: renamed from: com.google.android.gms.analytics.ag
class class_956 implements class_177 {
    // $FF: renamed from: Bj org.apache.http.client.HttpClient
    private final HttpClient field_4477;
    // $FF: renamed from: Bk java.net.URL
    private URL field_4478;
    private final Context mContext;
    // $FF: renamed from: vW java.lang.String
    private final String field_4479;
    // $FF: renamed from: yu com.google.android.gms.analytics.GoogleAnalytics
    private GoogleAnalytics field_4480;

    class_956(HttpClient var1, Context var2) {
        this(var1, GoogleAnalytics.getInstance(var2), var2);
    }

    class_956(HttpClient var1, GoogleAnalytics var2, Context var3) {
        this.mContext = var3.getApplicationContext();
        this.field_4479 = this.method_5046("GoogleAnalytics", "3.0", VERSION.RELEASE, class_953.method_5021(Locale.getDefault()), Build.MODEL, Build.ID);
        this.field_4477 = var1;
        this.field_4480 = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.aa, java.net.URL, boolean) void
    private void method_5043(class_952 param1, URL param2, boolean param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (org.apache.http.HttpEntityEnclosingRequest) void
    private void method_5044(HttpEntityEnclosingRequest param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: h (java.lang.String, java.lang.String) org.apache.http.HttpEntityEnclosingRequest
    private HttpEntityEnclosingRequest method_5045(String var1, String var2) {
        if(TextUtils.isEmpty(var1)) {
            class_938.method_4861("Empty hit, discarding.");
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
                    class_938.method_4861("Encoding error, discarding hit");
                    return null;
                }
            }

            var4.addHeader("User-Agent", this.field_4479);
            return var4;
        }
    }

    // $FF: renamed from: a (java.util.List, com.google.android.gms.analytics.aa, boolean) int
    public int method_826(List<w> param1, aa param2, boolean param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String) java.lang.String
    String method_5046(String var1, String var2, String var3, String var4, String var5, String var6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {var1, var2, var3, var4, var5, var6});
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.w) java.net.URL
    URL method_5047(class_937 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: af (java.lang.String) void
    public void method_827(String var1) {
        try {
            this.field_4478 = new URL(var1);
        } catch (MalformedURLException var3) {
            this.field_4478 = null;
        }
    }

    // $FF: renamed from: dX () boolean
    public boolean method_828() {
        NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if(var1 != null && var1.isConnected()) {
            return true;
        } else {
            class_938.method_4860("...no network connectivity");
            return false;
        }
    }

    // $FF: renamed from: eS () boolean
    boolean method_5048() {
        return 100.0D * Math.random() <= 1.0D;
    }
}

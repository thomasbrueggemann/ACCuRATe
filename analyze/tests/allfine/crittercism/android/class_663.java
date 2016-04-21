package crittercism.android;

import android.os.ConditionVariable;
import crittercism.android.class_106;
import crittercism.android.class_675;
import crittercism.android.class_764;
import crittercism.android.class_87;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.g
public final class class_663 implements class_87, Runnable {
    // $FF: renamed from: a java.util.List
    private List field_3227;
    // $FF: renamed from: b java.net.URL
    private URL field_3228;
    // $FF: renamed from: c long
    private long field_3229;
    // $FF: renamed from: d android.os.ConditionVariable
    private ConditionVariable field_3230;
    // $FF: renamed from: e crittercism.android.au
    private class_106 field_3231;
    // $FF: renamed from: f android.os.ConditionVariable
    private ConditionVariable field_3232;
    // $FF: renamed from: g boolean
    private volatile boolean field_3233;
    // $FF: renamed from: h java.lang.Object
    private final Object field_3234;
    // $FF: renamed from: i int
    private int field_3235;
    // $FF: renamed from: j long
    private volatile long field_3236;

    public class_663(class_106 var1, URL var2) {
        this(var1, var2, (byte)0);
    }

    private class_663(class_106 var1, URL var2, byte var3) {
        this.field_3227 = new LinkedList();
        this.field_3228 = null;
        this.field_3229 = System.currentTimeMillis();
        this.field_3230 = new ConditionVariable(false);
        this.field_3232 = new ConditionVariable(false);
        this.field_3233 = false;
        this.field_3234 = new Object();
        this.field_3235 = 50;
        this.field_3236 = 10000L;
        this.field_3231 = var1;
        this.field_3228 = var2;
        this.field_3235 = 50;
        this.field_3236 = 10000L;
    }

    // $FF: renamed from: a (java.net.HttpURLConnection, org.json.JSONObject) boolean
    private static boolean method_3716(HttpURLConnection var0, JSONObject var1) {
        int var4;
        try {
            var0.getOutputStream().write(var1.toString().getBytes("UTF8"));
            var4 = var0.getResponseCode();
            var0.disconnect();
        } catch (IOException var6) {
            return false;
        } catch (Exception var7) {
            return false;
        }

        boolean var5 = false;
        if(var4 == 202) {
            var5 = true;
        }

        return var5;
    }

    // $FF: renamed from: b () long
    private long method_3717() {
        long var1;
        label11: {
            var1 = 0L;
            long var3 = this.field_3236;
            long var5 = System.currentTimeMillis() - this.field_3229;
            if(var5 > var1) {
                var3 -= var5;
                if(var3 < var1) {
                    break label11;
                }
            }

            var1 = var3;
        }

        long var10000 = this.field_3236;
        return var1;
    }

    // $FF: renamed from: c () java.net.HttpURLConnection
    private HttpURLConnection method_3718() {
        IOException var3;
        HttpURLConnection var4;
        label27: {
            IOException var2;
            try {
                label25: {
                    try {
                        var4 = (HttpURLConnection)this.field_3228.openConnection();
                    } catch (IOException var8) {
                        var2 = var8;
                        break label25;
                    }

                    try {
                        var4.setConnectTimeout(2500);
                        var4.setRequestProperty("User-Agent", "5.1.4");
                        var4.setRequestProperty("Content-Type", "application/json");
                        var4.setDoOutput(true);
                        var4.setRequestMethod("POST");
                        if(var4 instanceof HttpsURLConnection) {
                            HttpsURLConnection var5 = (HttpsURLConnection)var4;
                            SSLContext var6 = SSLContext.getInstance("TLS");
                            var6.init((KeyManager[])null, (TrustManager[])null, (SecureRandom)null);
                            var5.setSSLSocketFactory(var6.getSocketFactory());
                        }

                        return var4;
                    } catch (IOException var7) {
                        var3 = var7;
                        break label27;
                    }
                }
            } catch (GeneralSecurityException var9) {
                class_764.method_4021("Failed to instantiate URLConnection to APM server: " + var9.getMessage());
                return null;
            }

            var3 = var2;
            var4 = null;
        }

        class_764.method_4021("Failed to instantiate URLConnection to APM server: " + var3.getMessage());
        return var4;
    }

    // $FF: renamed from: d () boolean
    private boolean method_3719() {
        return !this.field_3233 && this.field_3227.size() < this.field_3235;
    }

    // $FF: renamed from: a () void
    public final void method_3720() {
        this.field_3232.open();
    }

    // $FF: renamed from: a (int, java.util.concurrent.TimeUnit) void
    public final void method_3721(int var1, TimeUnit var2) {
        this.field_3236 = var2.toMillis((long)var1);
    }

    // $FF: renamed from: a (crittercism.android.c) void
    public final void method_375(class_675 param1) {
        // $FF: Couldn't be decompiled
    }

    public final void run() {
        // $FF: Couldn't be decompiled
    }
}

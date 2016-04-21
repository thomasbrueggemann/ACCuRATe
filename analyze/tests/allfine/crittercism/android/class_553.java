package crittercism.android;

import android.content.Context;
import android.os.ConditionVariable;
import crittercism.android.class_106;
import crittercism.android.class_107;
import crittercism.android.class_552;
import crittercism.android.class_754;
import crittercism.android.class_764;
import crittercism.android.class_795;
import crittercism.android.class_801;
import crittercism.android.class_803;
import crittercism.android.class_806;
import crittercism.android.class_809;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bi
public final class class_553 extends class_552 implements class_107 {
    // $FF: renamed from: a long
    private long field_2987 = System.currentTimeMillis();
    // $FF: renamed from: b long
    private volatile long field_2988 = 10000L;
    // $FF: renamed from: c android.os.ConditionVariable
    private ConditionVariable field_2989 = new ConditionVariable(false);
    // $FF: renamed from: d android.os.ConditionVariable
    private ConditionVariable field_2990 = new ConditionVariable(false);
    // $FF: renamed from: e crittercism.android.au
    private class_106 field_2991;
    // $FF: renamed from: f crittercism.android.bs
    private class_803 field_2992;
    // $FF: renamed from: g crittercism.android.bs
    private class_803 field_2993;
    // $FF: renamed from: h crittercism.android.bs
    private class_803 field_2994;
    // $FF: renamed from: i crittercism.android.bs
    private class_803 field_2995;
    // $FF: renamed from: j java.lang.String
    private String field_2996;
    // $FF: renamed from: k android.content.Context
    private Context field_2997;
    // $FF: renamed from: l boolean
    private volatile boolean field_2998 = false;

    public class_553(Context var1, class_106 var2, class_803 var3, class_803 var4, class_803 var5, class_803 var6, String var7) {
        this.field_2997 = var1;
        this.field_2992 = var3;
        this.field_2993 = var4;
        this.field_2994 = var5;
        this.field_2995 = var6;
        this.field_2991 = var2;
        this.field_2996 = var7;
        class_803 var8 = this.field_2992;
        if(this != null) {
            List var9 = var8.field_3800;
            synchronized(var9) {
                var8.field_3800.add(this);
            }
        }

    }

    // $FF: renamed from: a (org.json.JSONArray) org.json.JSONObject
    private JSONObject method_3391(JSONArray var1) {
        JSONObject var2 = new JSONObject();

        try {
            JSONObject var3 = new JSONObject();
            var3.put("appID", this.field_2991.method_428());
            var3.put("deviceID", this.field_2991.method_430());
            var3.put("crPlatform", "android");
            var3.put("crVersion", this.field_2991.method_431());
            var3.put("deviceModel", this.field_2991.method_437());
            var3.put("osName", "android");
            var3.put("osVersion", this.field_2991.method_438());
            var3.put("carrier", this.field_2991.method_433());
            var3.put("mobileCountryCode", this.field_2991.method_434());
            var3.put("mobileNetworkCode", this.field_2991.method_435());
            var3.put("appVersion", this.field_2991.method_429());
            var3.put("locale", (new class_806.class_1437()).field_4642);
            var2.put("appState", var3);
            var2.put("transactions", var1);
            if(method_3392(var1)) {
                var2.put("breadcrumbs", (new class_801(this.field_2993)).field_3795);
                var2.put("endpoints", (new class_801(this.field_2994)).field_3795);
                var2.put("systemBreadcrumbs", (new class_801(this.field_2995)).field_3795);
            }

            return var2;
        } catch (JSONException var5) {
            return null;
        }
    }

    // $FF: renamed from: b (org.json.JSONArray) boolean
    private static boolean method_3392(JSONArray var0) {
        int var1 = 0;

        boolean var3;
        while(true) {
            int var2 = var0.length();
            var3 = false;
            if(var1 >= var2) {
                break;
            }

            JSONArray var4 = var0.optJSONArray(var1);
            if(var4 != null) {
                label28: {
                    class_795.class_1378 var7;
                    class_795.class_1378 var8;
                    try {
                        var7 = (new class_795(var4)).method_4145();
                        if(var7 == class_795.class_1378.field_4361 || var7 == class_795.class_1378.field_4367) {
                            break label28;
                        }

                        var8 = class_795.class_1378.field_4366;
                    } catch (JSONException var9) {
                        class_764.method_4019(var9);
                        break label28;
                    } catch (ParseException var10) {
                        class_764.method_4019(var10);
                        break label28;
                    }

                    if(var7 != var8) {
                        var3 = true;
                        break;
                    }
                }
            }

            ++var1;
        }

        return var3;
    }

    // $FF: renamed from: a () void
    public final void method_3390() {
        while(true) {
            if(!this.field_2998) {
                this.field_2989.block();
                this.field_2990.block();
                if(!this.field_2998) {
                    long var1 = this.field_2988 - (System.currentTimeMillis() - this.field_2987);
                    if(var1 > 0L) {
                        try {
                            Thread.sleep(var1);
                        } catch (InterruptedException var14) {
                            ;
                        }
                    }

                    this.field_2987 = System.currentTimeMillis();
                    class_803 var3 = this.field_2992.method_4164(this.field_2997);
                    this.field_2992.method_4166(var3);
                    JSONArray var4 = (new class_801(var3)).field_3795;
                    class_809.method_4197(var3.field_3798);
                    if(var4.length() <= 0 || this.method_3391(var4) == null) {
                        continue;
                    }

                    JSONObject var5 = this.method_3391(var4);

                    try {
                        HttpURLConnection var8 = (new class_754(new URL(this.field_2996))).method_4000();
                        OutputStream var9 = var8.getOutputStream();
                        var9.write(var5.toString().getBytes("UTF8"));
                        var9.close();
                        var8.getResponseCode();
                        var8.disconnect();
                    } catch (IOException var12) {
                        class_764.method_4023();
                    } catch (GeneralSecurityException var13) {
                        class_764.method_4019(var13);
                    }
                    continue;
                }
            }

            return;
        }
    }

    // $FF: renamed from: a (int, java.util.concurrent.TimeUnit) void
    public final void method_3393(int var1, TimeUnit var2) {
        this.field_2988 = var2.toMillis((long)var1);
    }

    // $FF: renamed from: b () void
    public final void method_3394() {
        this.field_2989.open();
    }

    // $FF: renamed from: c () void
    public final void method_631() {
        class_803 var10000 = this.field_2992;
        this.field_2990.open();
    }

    // $FF: renamed from: d () void
    public final void method_632() {
        class_803 var10000 = this.field_2992;
        this.field_2990.close();
    }
}

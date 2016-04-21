package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_611;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_68;
import com.google.android.gms.tagmanager.class_69;
import com.google.android.gms.tagmanager.class_722;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.tagmanager.co
class class_621 implements Runnable {
    private final String aoc;
    private volatile String aoy;
    private final class_611 aqr;
    private final String aqs;
    private bg<class_51.class_1320> aqt;
    private volatile class_722 aqu;
    private volatile String aqv;
    private final Context mContext;

    class_621(Context var1, String var2, class_611 var3, class_722 var4) {
        this.mContext = var1;
        this.aqr = var3;
        this.aoc = var2;
        this.aqu = var4;
        this.aqs = "/r?id=" + var2;
        this.aoy = this.aqs;
        this.aqv = null;
    }

    public class_621(Context var1, String var2, class_722 var3) {
        this(var1, var2, new class_611(), var3);
    }

    // $FF: renamed from: oM () boolean
    private boolean method_3520() {
        NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if(var1 != null && var1.isConnected()) {
            return true;
        } else {
            class_612.method_3458("...no network connectivity");
            return false;
        }
    }

    // $FF: renamed from: oN () void
    private void method_3521() {
        if(!this.method_3520()) {
            this.aqt.method_326(class_68.class_1174.apM);
        } else {
            class_612.method_3458("Start loading resource from network ...");
            String var1 = this.method_3525();
            class_69 var2 = this.aqr.method_3454();

            try {
                InputStream var6;
                try {
                    var6 = var2.method_329(var1);
                } catch (FileNotFoundException var15) {
                    class_612.method_3459("No data is retrieved from the given url: " + var1 + ". Make sure container_id: " + this.aoc + " is correct.");
                    this.aqt.method_326(class_68.class_1174.apO);
                    return;
                } catch (IOException var16) {
                    class_612.method_3461("Error when loading resources from url: " + var1 + " " + var16.getMessage(), var16);
                    this.aqt.method_326(class_68.class_1174.apN);
                    return;
                }

                try {
                    ByteArrayOutputStream var7 = new ByteArrayOutputStream();
                    class_638.method_3593(var6, var7);
                    class_51.class_1320 var9 = class_51.class_1320.method_2170(var7.toByteArray());
                    class_612.method_3458("Successfully loaded supplemented resource: " + var9);
                    if(var9.field_1008 == null && var9.field_1007.length == 0) {
                        class_612.method_3458("No change for container: " + this.aoc);
                    }

                    this.aqt.method_327(var9);
                } catch (IOException var14) {
                    class_612.method_3461("Error when parsing downloaded resources from url: " + var1 + " " + var14.getMessage(), var14);
                    this.aqt.method_326(class_68.class_1174.apO);
                    return;
                }
            } finally {
                var2.close();
            }

            class_612.method_3458("Load resource from network finished.");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
    void method_3522(bg<class_51.class_1320> var1) {
        this.aqt = var1;
    }

    // $FF: renamed from: cJ (java.lang.String) void
    void method_3523(String var1) {
        class_612.method_3455("Setting previous container version: " + var1);
        this.aqv = var1;
    }

    // $FF: renamed from: cu (java.lang.String) void
    void method_3524(String var1) {
        if(var1 == null) {
            this.aoy = this.aqs;
        } else {
            class_612.method_3455("Setting CTFE URL path: " + var1);
            this.aoy = var1;
        }
    }

    // $FF: renamed from: oO () java.lang.String
    String method_3525() {
        String var1 = this.aqu.method_3950() + this.aoy + "&v=a65833898";
        if(this.aqv != null && !this.aqv.trim().equals("")) {
            var1 = var1 + "&pv=" + this.aqv;
        }

        if(class_618.method_3490().method_3492().equals(class_618.class_1772.aqj)) {
            var1 = var1 + "&gtm_debug=x";
        }

        return var1;
    }

    public void run() {
        if(this.aqt == null) {
            throw new IllegalStateException("callback must be set before execute");
        } else {
            this.aqt.method_328();
            this.method_3521();
        }
    }
}

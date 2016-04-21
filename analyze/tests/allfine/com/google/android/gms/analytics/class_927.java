package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_178;
import com.google.android.gms.analytics.class_938;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// $FF: renamed from: com.google.android.gms.analytics.h
class class_927 implements class_178 {
    // $FF: renamed from: xQ com.google.android.gms.analytics.h
    private static class_927 field_4238;
    // $FF: renamed from: xz java.lang.Object
    private static final Object field_4239 = new Object();
    private final Context mContext;
    // $FF: renamed from: xR java.lang.String
    private String field_4240;
    // $FF: renamed from: xS boolean
    private boolean field_4241 = false;
    // $FF: renamed from: xT java.lang.Object
    private final Object field_4242 = new Object();

    protected class_927(Context var1) {
        this.mContext = var1;
        this.method_4785();
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.h) java.lang.Object
    // $FF: synthetic method
    static Object method_4779(class_927 var0) {
        return var0.field_4242;
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.h, java.lang.String) java.lang.String
    // $FF: synthetic method
    static String method_4780(class_927 var0, String var1) {
        var0.field_4240 = var1;
        return var1;
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.h, boolean) boolean
    // $FF: synthetic method
    static boolean method_4781(class_927 var0, boolean var1) {
        var0.field_4241 = var1;
        return var1;
    }

    // $FF: renamed from: ad (java.lang.String) boolean
    private boolean method_4782(String var1) {
        try {
            class_938.method_4860("Storing clientId.");
            FileOutputStream var4 = this.mContext.openFileOutput("gaClientId", 0);
            var4.write(var1.getBytes());
            var4.close();
            return true;
        } catch (FileNotFoundException var5) {
            class_938.method_4858("Error creating clientId file.");
            return false;
        } catch (IOException var6) {
            class_938.method_4858("Error writing to clientId file.");
            return false;
        }
    }

    // $FF: renamed from: dQ () com.google.android.gms.analytics.h
    public static class_927 method_4783() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dS () java.lang.String
    private String method_4784() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dU () void
    private void method_4785() {
        (new Thread("client_id_fetcher") {
            public void run() {
                // $FF: Couldn't be decompiled
            }
        }).start();
    }

    // $FF: renamed from: y (android.content.Context) void
    public static void method_4786(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ac (java.lang.String) boolean
    public boolean method_4787(String var1) {
        return "&cid".equals(var1);
    }

    // $FF: renamed from: dR () java.lang.String
    String method_4788() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dT () java.lang.String
    protected String method_4789() {
        String var1 = UUID.randomUUID().toString().toLowerCase();

        try {
            if(this.method_4782(var1)) {
                return var1;
            }
        } catch (Exception var3) {
            return null;
        }

        var1 = "0";
        return var1;
    }

    // $FF: renamed from: dV () java.lang.String
    String method_4790() {
        // $FF: Couldn't be decompiled
    }

    public String getValue(String var1) {
        return "&cid".equals(var1)?this.method_4784():null;
    }
}

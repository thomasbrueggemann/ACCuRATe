package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_69;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// $FF: renamed from: com.google.android.gms.tagmanager.aw
class class_616 implements class_69 {
    private HttpURLConnection apv;

    // $FF: renamed from: a (java.net.HttpURLConnection) java.io.InputStream
    private InputStream method_3476(HttpURLConnection var1) throws IOException {
        int var2 = var1.getResponseCode();
        if(var2 == 200) {
            return var1.getInputStream();
        } else {
            String var3 = "Bad response: " + var2;
            if(var2 == 404) {
                throw new FileNotFoundException(var3);
            } else {
                throw new IOException(var3);
            }
        }
    }

    // $FF: renamed from: b (java.net.HttpURLConnection) void
    private void method_3477(HttpURLConnection var1) {
        if(var1 != null) {
            var1.disconnect();
        }

    }

    // $FF: renamed from: cD (java.lang.String) java.io.InputStream
    public InputStream method_329(String var1) throws IOException {
        this.apv = this.method_3478(var1);
        return this.method_3476(this.apv);
    }

    // $FF: renamed from: cE (java.lang.String) java.net.HttpURLConnection
    HttpURLConnection method_3478(String var1) throws IOException {
        HttpURLConnection var2 = (HttpURLConnection)(new URL(var1)).openConnection();
        var2.setReadTimeout(20000);
        var2.setConnectTimeout(20000);
        return var2;
    }

    public void close() {
        this.method_3477(this.apv);
    }
}

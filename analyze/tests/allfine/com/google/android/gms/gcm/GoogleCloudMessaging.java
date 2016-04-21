package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging adv;
    private PendingIntent adw;
    final BlockingQueue<Intent> adx = new LinkedBlockingQueue();
    private Handler ady = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message var1) {
            Intent var2 = (Intent)var1.obj;
            GoogleCloudMessaging.this.adx.add(var2);
        }
    };
    private Messenger adz;
    // $FF: renamed from: lB android.content.Context
    private Context field_2211;

    public GoogleCloudMessaging() {
        this.adz = new Messenger(this.ady);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, long, int, android.os.Bundle) void
    private void method_3145(String var1, String var2, long var3, int var5, Bundle var6) throws IOException {
        if(Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if(var1 == null) {
            throw new IllegalArgumentException("Missing \'to\'");
        } else {
            Intent var7 = new Intent("com.google.android.gcm.intent.SEND");
            var7.putExtras(var6);
            this.method_3149(var7);
            var7.setPackage("com.google.android.gms");
            var7.putExtra("google.to", var1);
            var7.putExtra("google.message_id", var2);
            var7.putExtra("google.ttl", Long.toString(var3));
            var7.putExtra("google.delay", Integer.toString(var5));
            this.field_2211.sendOrderedBroadcast(var7, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        }
    }

    // $FF: renamed from: d (java.lang.String[]) void
    private void method_3146(String... var1) {
        String var2 = this.method_3148(var1);
        Intent var3 = new Intent("com.google.android.c2dm.intent.REGISTER");
        var3.setPackage("com.google.android.gms");
        var3.putExtra("google.messenger", this.adz);
        this.method_3149(var3);
        var3.putExtra("sender", var2);
        this.field_2211.startService(var3);
    }

    public static GoogleCloudMessaging getInstance(Context var0) {
        synchronized(GoogleCloudMessaging.class) {}

        GoogleCloudMessaging var2;
        try {
            if(adv == null) {
                adv = new GoogleCloudMessaging();
                adv.field_2211 = var0;
            }

            var2 = adv;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: lN () void
    private void method_3147() {
        Intent var1 = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        var1.setPackage("com.google.android.gms");
        this.adx.clear();
        var1.putExtra("google.messenger", this.adz);
        this.method_3149(var1);
        this.field_2211.startService(var1);
    }

    public void close() {
        this.method_3150();
    }

    // $FF: renamed from: e (java.lang.String[]) java.lang.String
    String method_3148(String... var1) {
        if(var1 != null && var1.length != 0) {
            StringBuilder var2 = new StringBuilder(var1[0]);

            for(int var3 = 1; var3 < var1.length; ++var3) {
                var2.append(',').append(var1[var3]);
            }

            return var2.toString();
        } else {
            throw new IllegalArgumentException("No senderIds");
        }
    }

    public String getMessageType(Intent var1) {
        String var2;
        if(!"com.google.android.c2dm.intent.RECEIVE".equals(var1.getAction())) {
            var2 = null;
        } else {
            var2 = var1.getStringExtra("message_type");
            if(var2 == null) {
                return "gcm";
            }
        }

        return var2;
    }

    // $FF: renamed from: j (android.content.Intent) void
    void method_3149(Intent var1) {
        synchronized(this) {}

        try {
            if(this.adw == null) {
                Intent var3 = new Intent();
                var3.setPackage("com.google.example.invalidpackage");
                this.adw = PendingIntent.getBroadcast(this.field_2211, 0, var3, 0);
            }

            var1.putExtra("app", this.adw);
        } finally {
            ;
        }

    }

    // $FF: renamed from: lO () void
    void method_3150() {
        synchronized(this) {}

        try {
            if(this.adw != null) {
                this.adw.cancel();
                this.adw = null;
            }
        } finally {
            ;
        }

    }

    public String register(String... param1) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public void send(String var1, String var2, long var3, Bundle var5) throws IOException {
        this.method_3145(var1, var2, var3, -1, var5);
    }

    public void send(String var1, String var2, Bundle var3) throws IOException {
        this.send(var1, var2, -1L, var3);
    }

    public void unregister() throws IOException {
        // $FF: Couldn't be decompiled
    }
}

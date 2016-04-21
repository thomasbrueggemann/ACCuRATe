package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_642;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_75;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.tagmanager.as
class class_613 extends Thread implements class_75 {
    private static class_613 app;
    private final LinkedBlockingQueue<Runnable> apo = new LinkedBlockingQueue();
    private volatile class_72 apq;
    private volatile boolean mClosed = false;
    private final Context mContext;
    // $FF: renamed from: yU boolean
    private volatile boolean field_3125 = false;

    private class_613(Context var1) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.start();
    }

    // $FF: renamed from: Z (android.content.Context) com.google.android.gms.tagmanager.as
    static class_613 method_3463(Context var0) {
        if(app == null) {
            app = new class_613(var0);
        }

        return app;
    }

    // $FF: renamed from: g (java.lang.Throwable) java.lang.String
    private String method_3467(Throwable var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        PrintStream var3 = new PrintStream(var2);
        var1.printStackTrace(var3);
        var3.flush();
        return new String(var2.toByteArray());
    }

    // $FF: renamed from: b (java.lang.Runnable) void
    public void method_343(Runnable var1) {
        this.apo.add(var1);
    }

    // $FF: renamed from: b (java.lang.String, long) void
    void method_3468(final String var1, final long var2) {
        this.method_343(new Runnable() {
            public void run() {
                if(class_613.this.apq == null) {
                    class_642 var1x = class_642.method_3629();
                    var1x.method_3630(class_613.this.mContext, class_613.this);
                    class_613.this.apq = var1x.method_3632();
                }

                class_613.this.apq.method_339(var2, var1);
            }
        });
    }

    // $FF: renamed from: cC (java.lang.String) void
    public void method_344(String var1) {
        this.method_3468(var1, System.currentTimeMillis());
    }

    public void run() {
        while(!this.mClosed) {
            try {
                try {
                    Runnable var3 = (Runnable)this.apo.take();
                    if(!this.field_3125) {
                        var3.run();
                    }
                } catch (InterruptedException var4) {
                    class_612.method_3457(var4.toString());
                }
            } catch (Throwable var5) {
                class_612.method_3456("Error on Google TagManager Thread: " + this.method_3467(var5));
                class_612.method_3456("Google TagManager is shutting down.");
                this.field_3125 = true;
            }
        }

    }
}

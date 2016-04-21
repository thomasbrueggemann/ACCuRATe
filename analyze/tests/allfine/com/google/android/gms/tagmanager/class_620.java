package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_209;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_621;
import com.google.android.gms.tagmanager.class_722;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.tagmanager.cp
class class_620 implements class_209.class_1399 {
    private final String aoc;
    private String aoy;
    private bg<class_51.class_1320> aqt;
    private class_722 aqu;
    private final ScheduledExecutorService aqw;
    private final class_620.class_1776 aqx;
    private ScheduledFuture<?> aqy;
    private boolean mClosed;
    private final Context mContext;

    public class_620(Context var1, String var2, class_722 var3) {
        this(var1, var2, var3, (class_620.class_1775)null, (class_620.class_1776)null);
    }

    class_620(Context var1, String var2, class_722 var3, class_620.class_1775 var4, class_620.class_1776 var5) {
        this.aqu = var3;
        this.mContext = var1;
        this.aoc = var2;
        if(var4 == null) {
            var4 = new class_620.class_1775() {
                // $FF: renamed from: oQ () java.util.concurrent.ScheduledExecutorService
                public ScheduledExecutorService method_875() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }

        this.aqw = var4.method_875();
        if(var5 == null) {
            this.aqx = new class_620.class_1776() {
                // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.co
                public class_621 method_876(class_722 var1) {
                    return new class_621(class_620.this.mContext, class_620.this.aoc, var1);
                }
            };
        } else {
            this.aqx = var5;
        }
    }

    // $FF: renamed from: cK (java.lang.String) com.google.android.gms.tagmanager.co
    private class_621 method_3515(String var1) {
        class_621 var2 = this.aqx.method_876(this.aqu);
        var2.method_3522(this.aqt);
        var2.method_3524(this.aoy);
        var2.method_3523(var1);
        return var2;
    }

    // $FF: renamed from: oP () void
    private void method_3516() {
        synchronized(this) {}

        try {
            if(this.mClosed) {
                throw new IllegalStateException("called method after closed");
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
    public void method_224(bg<class_51.class_1320> var1) {
        synchronized(this) {}

        try {
            this.method_3516();
            this.aqt = var1;
        } finally {
            ;
        }

    }

    // $FF: renamed from: cu (java.lang.String) void
    public void method_225(String var1) {
        synchronized(this) {}

        try {
            this.method_3516();
            this.aoy = var1;
        } finally {
            ;
        }

    }

    // $FF: renamed from: e (long, java.lang.String) void
    public void method_226(long var1, String var3) {
        synchronized(this) {}

        try {
            class_612.method_3458("loadAfterDelay: containerId=" + this.aoc + " delay=" + var1);
            this.method_3516();
            if(this.aqt == null) {
                throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
            }

            if(this.aqy != null) {
                this.aqy.cancel(false);
            }

            this.aqy = this.aqw.schedule(this.method_3515(var3), var1, TimeUnit.MILLISECONDS);
        } finally {
            ;
        }

    }

    public void release() {
        synchronized(this) {}

        try {
            this.method_3516();
            if(this.aqy != null) {
                this.aqy.cancel(false);
            }

            this.aqw.shutdown();
            this.mClosed = true;
        } finally {
            ;
        }

    }

    interface class_1776 {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.co
        class_621 method_876(class_722 var1);
    }

    interface class_1775 {
        // $FF: renamed from: oQ () java.util.concurrent.ScheduledExecutorService
        ScheduledExecutorService method_875();
    }
}

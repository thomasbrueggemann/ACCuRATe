package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.class_547;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.g;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.gms.internal.w
@ez
class class_540 implements class_52, Runnable {
    // $FF: renamed from: lr com.google.android.gms.internal.u$b
    private class_538.class_1339 field_2887;
    // $FF: renamed from: me java.util.List
    private final List<Object[]> field_2888 = new Vector();
    // $FF: renamed from: mf java.util.concurrent.atomic.AtomicReference
    private final AtomicReference<g> field_2889 = new AtomicReference();
    // $FF: renamed from: mg java.util.concurrent.CountDownLatch
    CountDownLatch field_2890 = new CountDownLatch(1);

    public class_540(class_538.class_1339 var1) {
        this.field_2887 = var1;
        if(class_377.method_2455()) {
            class_384.method_2537(this);
        } else {
            this.run();
        }
    }

    // $FF: renamed from: ax () void
    private void method_3300() {
        if(!this.field_2888.isEmpty()) {
            Iterator var1 = this.field_2888.iterator();

            while(var1.hasNext()) {
                Object[] var2 = (Object[])var1.next();
                if(var2.length == 1) {
                    ((class_52)this.field_2889.get()).method_230((MotionEvent)var2[0]);
                } else if(var2.length == 3) {
                    ((class_52)this.field_2889.get()).method_229(((Integer)var2[0]).intValue(), ((Integer)var2[1]).intValue(), ((Integer)var2[2]).intValue());
                }
            }
        }

    }

    // $FF: renamed from: a (android.content.Context) java.lang.String
    public String method_227(Context var1) {
        this.method_3302();
        class_52 var2 = (class_52)this.field_2889.get();
        if(var2 != null) {
            this.method_3300();
            return var2.method_227(var1);
        } else {
            return "";
        }
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String) java.lang.String
    public String method_228(Context var1, String var2) {
        this.method_3302();
        class_52 var3 = (class_52)this.field_2889.get();
        if(var3 != null) {
            this.method_3300();
            return var3.method_228(var1, var2);
        } else {
            return "";
        }
    }

    // $FF: renamed from: a (int, int, int) void
    public void method_229(int var1, int var2, int var3) {
        class_52 var4 = (class_52)this.field_2889.get();
        if(var4 != null) {
            this.method_3300();
            var4.method_229(var1, var2, var3);
        } else {
            List var5 = this.field_2888;
            Object[] var6 = new Object[] {Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)};
            var5.add(var6);
        }
    }

    // $FF: renamed from: a (android.view.MotionEvent) void
    public void method_230(MotionEvent var1) {
        class_52 var2 = (class_52)this.field_2889.get();
        if(var2 != null) {
            this.method_3300();
            var2.method_230(var1);
        } else {
            this.field_2888.add(new Object[] {var1});
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.g) void
    protected void method_3301(class_52 var1) {
        this.field_2889.set(var1);
    }

    // $FF: renamed from: aw () void
    protected void method_3302() {
        try {
            this.field_2890.await();
        } catch (InterruptedException var2) {
            class_378.method_2465("Interrupted during GADSignals creation.", var2);
        }
    }

    public void run() {
        try {
            this.method_3301(class_547.method_3348(this.field_2887.field_2245.field_1387, this.field_2887.field_2243));
        } finally {
            this.field_2890.countDown();
            this.field_2887 = null;
        }

    }
}

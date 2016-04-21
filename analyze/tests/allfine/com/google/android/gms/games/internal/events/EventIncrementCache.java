package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object aaq = new Object();
    private Handler aar;
    private boolean aas;
    private HashMap<String, AtomicInteger> aat;
    private int aau;

    public EventIncrementCache(Looper var1, int var2) {
        this.aar = new Handler(var1);
        this.aat = new HashMap();
        this.aau = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.events.EventIncrementCache) void
    // $FF: synthetic method
    static void method_4419(EventIncrementCache var0) {
        var0.method_4420();
    }

    // $FF: renamed from: kQ () void
    private void method_4420() {
        // $FF: Couldn't be decompiled
    }

    public void flush() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: q (java.lang.String, int) void
    protected abstract void method_4421(String var1, int var2);

    // $FF: renamed from: w (java.lang.String, int) void
    public void method_4422(String param1, int param2) {
        // $FF: Couldn't be decompiled
    }
}

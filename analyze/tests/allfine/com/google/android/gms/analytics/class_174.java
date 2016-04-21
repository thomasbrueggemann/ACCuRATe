package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.analytics.f
interface class_174 {
    // $FF: renamed from: dH () void
    void method_819();

    // $FF: renamed from: dN () void
    void method_820();

    // $FF: renamed from: dO () java.util.concurrent.LinkedBlockingQueue
    LinkedBlockingQueue<Runnable> method_821();

    void dispatch();

    Thread getThread();

    // $FF: renamed from: u (java.util.Map) void
    void method_822(Map<String, String> var1);
}

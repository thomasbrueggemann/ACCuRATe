package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.analytics.f
interface class_169 {
   // $FF: renamed from: dQ () void
   void method_845();

   // $FF: renamed from: dW () void
   void method_846();

   // $FF: renamed from: dX () java.util.concurrent.LinkedBlockingQueue
   LinkedBlockingQueue<Runnable> method_847();

   // $FF: renamed from: dY () void
   void method_848();

   void dispatch();

   Thread getThread();

   // $FF: renamed from: u (java.util.Map) void
   void method_849(Map<String, String> var1);
}

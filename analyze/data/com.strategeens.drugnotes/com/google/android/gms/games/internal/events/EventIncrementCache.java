package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
   final Object ack = new Object();
   private Handler acl;
   private boolean acm;
   private HashMap<String, AtomicInteger> acn;
   private int aco;

   public EventIncrementCache(Looper var1, int var2) {
      this.acl = new Handler(var1);
      this.acn = new HashMap();
      this.aco = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.events.EventIncrementCache) void
   // $FF: synthetic method
   static void method_4160(EventIncrementCache var0) {
      var0.method_4161();
   }

   // $FF: renamed from: lX () void
   private void method_4161() {
      // $FF: Couldn't be decompiled
   }

   public void flush() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: r (java.lang.String, int) void
   protected abstract void method_4162(String var1, int var2);

   // $FF: renamed from: y (java.lang.String, int) void
   public void method_4163(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}

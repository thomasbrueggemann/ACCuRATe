package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
   // $FF: renamed from: Rj java.lang.Object
   final Object field_3303 = new Object();
   // $FF: renamed from: Rk android.os.Handler
   private Handler field_3304;
   // $FF: renamed from: Rl boolean
   private boolean field_3305;
   // $FF: renamed from: Rm java.util.HashMap
   private HashMap<String, AtomicInteger> field_3306;
   // $FF: renamed from: Rn int
   private int field_3307;

   public EventIncrementCache(Looper var1, int var2) {
      this.field_3304 = new Handler(var1);
      this.field_3306 = new HashMap();
      this.field_3307 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.games.internal.events.EventIncrementCache) void
   // $FF: synthetic method
   static void method_3472(EventIncrementCache var0) {
      var0.method_3473();
   }

   // $FF: renamed from: hK () void
   private void method_3473() {
      // $FF: Couldn't be decompiled
   }

   public void flush() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: o (java.lang.String, int) void
   protected abstract void method_3474(String var1, int var2);

   // $FF: renamed from: u (java.lang.String, int) void
   public void method_3475(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}

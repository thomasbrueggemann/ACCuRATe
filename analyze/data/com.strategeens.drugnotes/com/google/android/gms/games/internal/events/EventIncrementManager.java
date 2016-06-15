package com.google.android.gms.games.internal.events;

import com.google.android.gms.games.internal.events.EventIncrementCache;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
   private final AtomicReference<EventIncrementCache> acq = new AtomicReference();

   public void flush() {
      EventIncrementCache var1 = (EventIncrementCache)this.acq.get();
      if(var1 != null) {
         var1.flush();
      }

   }

   // $FF: renamed from: lF () com.google.android.gms.games.internal.events.EventIncrementCache
   protected abstract EventIncrementCache method_3115();

   // $FF: renamed from: o (java.lang.String, int) void
   public void method_3116(String var1, int var2) {
      EventIncrementCache var3 = (EventIncrementCache)this.acq.get();
      if(var3 == null) {
         var3 = this.method_3115();
         if(!this.acq.compareAndSet((Object)null, var3)) {
            var3 = (EventIncrementCache)this.acq.get();
         }
      }

      var3.method_4163(var1, var2);
   }
}

package com.google.android.gms.games.internal.events;

import com.google.android.gms.games.internal.events.EventIncrementCache;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
   // $FF: renamed from: Rp java.util.concurrent.atomic.AtomicReference
   private final AtomicReference<EventIncrementCache> field_2155 = new AtomicReference();

   public void flush() {
      EventIncrementCache var1 = (EventIncrementCache)this.field_2155.get();
      if(var1 != null) {
         var1.flush();
      }

   }

   // $FF: renamed from: hs () com.google.android.gms.games.internal.events.EventIncrementCache
   protected abstract EventIncrementCache method_2722();

   // $FF: renamed from: l (java.lang.String, int) void
   public void method_2723(String var1, int var2) {
      EventIncrementCache var3 = (EventIncrementCache)this.field_2155.get();
      if(var3 == null) {
         var3 = this.method_2722();
         if(!this.field_2155.compareAndSet((Object)null, var3)) {
            var3 = (EventIncrementCache)this.field_2155.get();
         }
      }

      var3.method_3475(var1, var2);
   }
}

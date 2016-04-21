package com.google.android.gms.games.internal.events;

import com.google.android.gms.games.internal.events.EventIncrementCache;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> aaw = new AtomicReference();

    public void flush() {
        EventIncrementCache var1 = (EventIncrementCache)this.aaw.get();
        if(var1 != null) {
            var1.flush();
        }

    }

    // $FF: renamed from: ky () com.google.android.gms.games.internal.events.EventIncrementCache
    protected abstract EventIncrementCache method_3073();

    // $FF: renamed from: n (java.lang.String, int) void
    public void method_3074(String var1, int var2) {
        EventIncrementCache var3 = (EventIncrementCache)this.aaw.get();
        if(var3 == null) {
            var3 = this.method_3073();
            if(!this.aaw.compareAndSet((Object)null, var3)) {
                var3 = (EventIncrementCache)this.aaw.get();
            }
        }

        var3.method_4422(var1, var2);
    }
}

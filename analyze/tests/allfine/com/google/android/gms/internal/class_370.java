package com.google.android.gms.internal;

import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gg
@ez
public abstract class class_370 {
    // $FF: renamed from: mk java.lang.Runnable
    private final Runnable field_1344 = new Runnable() {
        public final void run() {
            class_370.this.field_1345 = Thread.currentThread();
            class_370.this.method_2419();
        }
    };
    // $FF: renamed from: wf java.lang.Thread
    private volatile Thread field_1345;

    public final void cancel() {
        this.onStop();
        if(this.field_1345 != null) {
            this.field_1345.interrupt();
        }

    }

    // $FF: renamed from: co () void
    public abstract void method_2419();

    public abstract void onStop();

    public final void start() {
        class_384.method_2537(this.field_1344);
    }
}

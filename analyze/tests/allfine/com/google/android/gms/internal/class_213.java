package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_538;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.u;
import java.lang.ref.WeakReference;

// $FF: renamed from: com.google.android.gms.internal.ab
@ez
public class class_213 {
    // $FF: renamed from: mj com.google.android.gms.internal.ab$a
    private final class_213.class_1279 field_530;
    // $FF: renamed from: mk java.lang.Runnable
    private final Runnable field_531;
    // $FF: renamed from: ml com.google.android.gms.internal.av
    private class_223 field_532;
    // $FF: renamed from: mm boolean
    private boolean field_533;
    // $FF: renamed from: mn boolean
    private boolean field_534;
    // $FF: renamed from: mo long
    private long field_535;

    public class_213(class_538 var1) {
        this(var1, new class_213.class_1279(class_377.field_1386));
    }

    class_213(final class_538 var1, class_213.class_1279 var2) {
        this.field_533 = false;
        this.field_534 = false;
        this.field_535 = 0L;
        this.field_530 = var2;
        this.field_531 = new Runnable() {
            // $FF: renamed from: mp java.lang.ref.WeakReference
            private final WeakReference<u> field_2962 = new WeakReference(var1);

            public void run() {
                class_213.this.field_533 = false;
                class_538 var2 = (class_538)this.field_2962.get();
                if(var2 != null) {
                    var2.method_3295(class_213.this.field_532);
                }

            }
        };
    }

    // $FF: renamed from: a (com.google.android.gms.internal.av, long) void
    public void method_1488(class_223 var1, long var2) {
        if(this.field_533) {
            class_378.method_2461("An ad refresh is already scheduled.");
        } else {
            this.field_532 = var1;
            this.field_533 = true;
            this.field_535 = var2;
            if(!this.field_534) {
                class_378.method_2459("Scheduling ad refresh " + var2 + " milliseconds from now.");
                this.field_530.postDelayed(this.field_531, var2);
                return;
            }
        }

    }

    // $FF: renamed from: ay () boolean
    public boolean method_1489() {
        return this.field_533;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.av) void
    public void method_1490(class_223 var1) {
        this.method_1488(var1, 60000L);
    }

    public void cancel() {
        this.field_533 = false;
        this.field_530.removeCallbacks(this.field_531);
    }

    public void pause() {
        this.field_534 = true;
        if(this.field_533) {
            this.field_530.removeCallbacks(this.field_531);
        }

    }

    public void resume() {
        this.field_534 = false;
        if(this.field_533) {
            this.field_533 = false;
            this.method_1488(this.field_532, this.field_535);
        }

    }

    public static class class_1279 {
        private final Handler mHandler;

        public class_1279(Handler var1) {
            this.mHandler = var1;
        }

        public boolean postDelayed(Runnable var1, long var2) {
            return this.mHandler.postDelayed(var1, var2);
        }

        public void removeCallbacks(Runnable var1) {
            this.mHandler.removeCallbacks(var1);
        }
    }
}

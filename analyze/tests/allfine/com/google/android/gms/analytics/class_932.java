package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_175;
import com.google.android.gms.analytics.class_179;
import com.google.android.gms.analytics.class_186;
import com.google.android.gms.analytics.class_922;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.internal.hb;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.google.android.gms.analytics.r
class class_932 implements class_186, class_922.class_1635, class_922.class_1636 {
    private final Context mContext;
    // $FF: renamed from: yA boolean
    private boolean field_4261;
    // $FF: renamed from: yB boolean
    private boolean field_4262;
    // $FF: renamed from: yC boolean
    private boolean field_4263;
    // $FF: renamed from: yD com.google.android.gms.internal.ju
    private class_20 field_4264;
    // $FF: renamed from: yE long
    private long field_4265;
    // $FF: renamed from: yd com.google.android.gms.analytics.d
    private class_175 field_4266;
    // $FF: renamed from: ye com.google.android.gms.analytics.f
    private final class_174 field_4267;
    // $FF: renamed from: yg boolean
    private boolean field_4268;
    // $FF: renamed from: yq long
    private volatile long field_4269;
    // $FF: renamed from: yr com.google.android.gms.analytics.r$a
    private volatile class_932.class_1159 field_4270;
    // $FF: renamed from: ys com.google.android.gms.analytics.b
    private volatile class_179 field_4271;
    // $FF: renamed from: yt com.google.android.gms.analytics.d
    private class_175 field_4272;
    // $FF: renamed from: yu com.google.android.gms.analytics.GoogleAnalytics
    private final GoogleAnalytics field_4273;
    // $FF: renamed from: yv java.util.Queue
    private final Queue<class_932.class_1160> field_4274;
    // $FF: renamed from: yw int
    private volatile int field_4275;
    // $FF: renamed from: yx java.util.Timer
    private volatile Timer field_4276;
    // $FF: renamed from: yy java.util.Timer
    private volatile Timer field_4277;
    // $FF: renamed from: yz java.util.Timer
    private volatile Timer field_4278;

    class_932(Context var1, class_174 var2) {
        this(var1, var2, (class_175)null, GoogleAnalytics.getInstance(var1));
    }

    class_932(Context var1, class_174 var2, class_175 var3, GoogleAnalytics var4) {
        this.field_4274 = new ConcurrentLinkedQueue();
        this.field_4265 = 300000L;
        this.field_4272 = var3;
        this.mContext = var1;
        this.field_4267 = var2;
        this.field_4273 = var4;
        this.field_4264 = class_346.method_2326();
        this.field_4275 = 0;
        this.field_4270 = class_932.class_1159.field_729;
    }

    // $FF: renamed from: a (java.util.Timer) java.util.Timer
    private Timer method_4822(Timer var1) {
        if(var1 != null) {
            var1.cancel();
        }

        return null;
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.r) void
    // $FF: synthetic method
    static void method_4823(class_932 var0) {
        var0.method_4830();
    }

    // $FF: renamed from: cC () void
    private void method_4826() {
        synchronized(this) {}

        try {
            if(this.field_4271 != null && this.field_4270 == class_932.class_1159.field_724) {
                this.field_4270 = class_932.class_1159.field_728;
                this.field_4271.disconnect();
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: ef () void
    private void method_4829() {
        this.field_4276 = this.method_4822(this.field_4276);
        this.field_4277 = this.method_4822(this.field_4277);
        this.field_4278 = this.method_4822(this.field_4278);
    }

    // $FF: renamed from: eh () void
    private void method_4830() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ei () void
    private void method_4831() {
        this.field_4266.dispatch();
        this.field_4268 = false;
    }

    // $FF: renamed from: ej () void
    private void method_4832() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ek () void
    private void method_4833() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: el () void
    private void method_4834() {
        this.field_4276 = this.method_4822(this.field_4276);
        this.field_4276 = new Timer("Service Reconnect");
        this.field_4276.schedule(new class_932.class_1179(null), 5000L);
    }

    // $FF: renamed from: a (int, android.content.Intent) void
    public void method_1045(int var1, Intent var2) {
        synchronized(this) {}

        try {
            this.field_4270 = class_932.class_1159.field_727;
            if(this.field_4275 < 2) {
                class_938.method_4861("Service unavailable (code=" + var1 + "), will retry.");
                this.method_4834();
            } else {
                class_938.method_4861("Service unavailable (code=" + var1 + "), using local store.");
                this.method_4832();
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: b (java.util.Map, long, java.lang.String, java.util.List) void
    public void method_870(Map<String, String> var1, long var2, String var4, List<hb> var5) {
        class_938.method_4860("putHit called");
        this.field_4274.add(new class_932.class_1160(var1, var2, var4, var5));
        this.method_4830();
    }

    // $FF: renamed from: dH () void
    public void method_871() {
        class_938.method_4860("clearHits called");
        this.field_4274.clear();
        switch(null.field_857[this.field_4270.ordinal()]) {
            case 1:
                this.field_4266.method_825(0L);
                this.field_4261 = false;
                return;
            case 2:
                this.field_4271.method_830();
                this.field_4261 = false;
                return;
            default:
                this.field_4261 = true;
        }
    }

    // $FF: renamed from: dN () void
    public void method_872() {
        // $FF: Couldn't be decompiled
    }

    public void dispatch() {
        switch(null.field_857[this.field_4270.ordinal()]) {
            case 1:
                this.method_4831();
                return;
            default:
                this.field_4268 = true;
            case 2:
        }
    }

    // $FF: renamed from: eg () void
    public void method_873() {
        if(this.field_4271 == null) {
            this.field_4271 = new class_922(this.mContext, this, this);
            this.method_4833();
        }
    }

    public void onConnected() {
        synchronized(this) {}

        try {
            this.field_4277 = this.method_4822(this.field_4277);
            this.field_4275 = 0;
            class_938.method_4860("Connected to service");
            this.field_4270 = class_932.class_1159.field_724;
            if(this.field_4262) {
                this.method_4826();
                this.field_4262 = false;
            } else {
                this.method_4830();
                this.field_4278 = this.method_4822(this.field_4278);
                this.field_4278 = new Timer("disconnect check");
                this.field_4278.schedule(new class_932.class_1158(null), this.field_4265);
            }
        } finally {
            ;
        }

    }

    public void onDisconnected() {
        synchronized(this) {}

        try {
            if(this.field_4270 == class_932.class_1159.field_726) {
                class_938.method_4860("Service blocked.");
                this.method_4829();
            } else if(this.field_4270 == class_932.class_1159.field_728) {
                class_938.method_4860("Disconnected from service");
                this.method_4829();
                this.field_4270 = class_932.class_1159.field_729;
            } else {
                class_938.method_4860("Unexpected disconnect.");
                this.field_4270 = class_932.class_1159.field_727;
                if(this.field_4275 < 2) {
                    this.method_4834();
                } else {
                    this.method_4832();
                }
            }
        } finally {
            ;
        }

    }

    private static enum class_1159 {
        // $FF: renamed from: yH com.google.android.gms.analytics.r$a
        field_723,
        // $FF: renamed from: yI com.google.android.gms.analytics.r$a
        field_724,
        // $FF: renamed from: yJ com.google.android.gms.analytics.r$a
        field_725,
        // $FF: renamed from: yK com.google.android.gms.analytics.r$a
        field_726,
        // $FF: renamed from: yL com.google.android.gms.analytics.r$a
        field_727,
        // $FF: renamed from: yM com.google.android.gms.analytics.r$a
        field_728,
        // $FF: renamed from: yN com.google.android.gms.analytics.r$a
        field_729;

        static {
            class_932.class_1159[] var0 = new class_932.class_1159[]{field_723, field_724, field_725, field_726, field_727, field_728, field_729};
        }
    }

    private class class_1158 extends TimerTask {
        private class_1158() {
        }

        // $FF: synthetic method
        class_1158(Object var2) {
            this();
        }

        public void run() {
            if(class_932.this.field_4270 == class_932.class_1159.field_724 && class_932.this.field_4274.isEmpty() && class_932.this.field_4269 + class_932.this.field_4265 < class_932.this.field_4264.elapsedRealtime()) {
                class_938.method_4860("Disconnecting due to inactivity");
                class_932.this.method_4826();
            } else {
                class_932.this.field_4278.schedule(class_932.this.new class_1158(), class_932.this.field_4265);
            }
        }
    }

    private class class_1161 extends TimerTask {
        private class_1161() {
        }

        // $FF: synthetic method
        class_1161(Object var2) {
            this();
        }

        public void run() {
            if(class_932.this.field_4270 == class_932.class_1159.field_723) {
                class_932.this.method_4832();
            }

        }
    }

    private static class class_1160 {
        // $FF: renamed from: yP java.util.Map
        private final Map<String, String> field_731;
        // $FF: renamed from: yQ long
        private final long field_732;
        // $FF: renamed from: yR java.lang.String
        private final String field_733;
        // $FF: renamed from: yS java.util.List
        private final List<hb> field_734;

        public class_1160(Map<String, String> var1, long var2, String var4, List<hb> var5) {
            this.field_731 = var1;
            this.field_732 = var2;
            this.field_733 = var4;
            this.field_734 = var5;
        }

        // $FF: renamed from: em () java.util.Map
        public Map<String, String> method_1630() {
            return this.field_731;
        }

        // $FF: renamed from: en () long
        public long method_1631() {
            return this.field_732;
        }

        // $FF: renamed from: eo () java.util.List
        public List<hb> method_1632() {
            return this.field_734;
        }

        public String getPath() {
            return this.field_733;
        }

        public String toString() {
            StringBuilder var1 = new StringBuilder();
            var1.append("PATH: ");
            var1.append(this.field_733);
            if(this.field_731 != null) {
                var1.append("  PARAMS: ");
                Iterator var5 = this.field_731.entrySet().iterator();

                while(var5.hasNext()) {
                    Entry var6 = (Entry)var5.next();
                    var1.append((String)var6.getKey());
                    var1.append("=");
                    var1.append((String)var6.getValue());
                    var1.append(",  ");
                }
            }

            return var1.toString();
        }
    }

    private class class_1179 extends TimerTask {
        private class_1179() {
        }

        // $FF: synthetic method
        class_1179(Object var2) {
            this();
        }

        public void run() {
            class_932.this.method_4833();
        }
    }
}

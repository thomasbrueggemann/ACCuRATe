package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_607;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_620;
import com.google.android.gms.tagmanager.class_637;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_68;
import com.google.android.gms.tagmanager.class_715;
import com.google.android.gms.tagmanager.class_722;
import com.google.android.gms.tagmanager.class_76;

// $FF: renamed from: com.google.android.gms.tagmanager.o
class class_209 extends BaseImplementation.AbstractPendingResult<ContainerHolder> {
    // $FF: renamed from: IH android.os.Looper
    private final Looper field_69;
    private class_209.class_1395 aoA;
    private final String aoc;
    private long aoh;
    private final TagManager aoo;
    private final class_209.class_1398 aor;
    private final class_76 aos;
    private final int aot;
    private class_209.class_1400 aou;
    private volatile class_715 aov;
    private volatile boolean aow;
    private class_51.class_1320 aox;
    private String aoy;
    private class_209.class_1399 aoz;
    private final Context mContext;
    // $FF: renamed from: yD com.google.android.gms.internal.ju
    private final class_20 field_70;

    class_209(Context var1, TagManager var2, Looper var3, String var4, int var5, class_209.class_1400 var6, class_209.class_1399 var7, class_20 var8, class_76 var9) {
        Looper var10;
        if(var3 == null) {
            var10 = Looper.getMainLooper();
        } else {
            var10 = var3;
        }

        super(var10);
        this.mContext = var1;
        this.aoo = var2;
        if(var3 == null) {
            var3 = Looper.getMainLooper();
        }

        this.field_69 = var3;
        this.aoc = var4;
        this.aot = var5;
        this.aou = var6;
        this.aoz = var7;
        this.aor = new class_209.class_1398(null);
        this.aox = new class_51.class_1320();
        this.field_70 = var8;
        this.aos = var9;
        if(this.method_1119()) {
            this.method_1122(class_618.method_3490().method_3493());
        }

    }

    public class_209(Context var1, TagManager var2, Looper var3, String var4, int var5, class_722 var6) {
        this(var1, var2, var3, var4, var5, new class_637(var1, var4), new class_620(var1, var4, var6), class_346.method_2326(), new class_607(30, 900000L, 5000L, "refreshing", class_346.method_2326()));
    }

    // $FF: renamed from: T (boolean) void
    private void method_1106(final boolean var1) {
        this.aou.method_220(new class_209.class_1396(null));
        this.aoz.method_224(new class_209.class_1397(null));
        class_638.class_1807 var2 = this.aou.method_222(this.aot);
        if(var2 != null) {
            this.aov = new class_715(this.aoo, this.field_69, new Container(this.mContext, this.aoo.getDataLayer(), this.aoc, 0L, var2), this.aor);
        }

        this.aoA = new class_209.class_1395() {
            // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
            public boolean method_718(Container var1x) {
                if(var1) {
                    if(43200000L + var1x.getLastRefreshTime() < class_209.this.field_70.currentTimeMillis()) {
                        return false;
                    }
                } else if(var1x.isDefault()) {
                    return false;
                }

                return true;
            }
        };
        if(this.method_1119()) {
            this.aoz.method_226(0L, "");
        } else {
            this.aou.method_223();
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$j) void
    private void method_1108(class_51.class_1320 var1) {
        synchronized(this) {}

        try {
            if(this.aou != null) {
                class_167.class_1513 var3 = new class_167.class_1513();
                var3.asr = this.aoh;
                var3.field_952 = new class_51.class_1327();
                var3.ass = var1;
                this.aou.method_221(var3);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$j, long, boolean) void
    private void method_1109(class_51.class_1320 param1, long param2, boolean param4) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j) void
    // $FF: synthetic method
    static void method_1111(class_209 var0, class_51.class_1320 var1) {
        var0.method_1108(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.o, com.google.android.gms.internal.c$j, long, boolean) void
    // $FF: synthetic method
    static void method_1112(class_209 var0, class_51.class_1320 var1, long var2, boolean var4) {
        var0.method_1109(var1, var2, var4);
    }

    // $FF: renamed from: c (com.google.android.gms.tagmanager.o) com.google.android.gms.internal.c$j
    // $FF: synthetic method
    static class_51.class_1320 method_1114(class_209 var0) {
        return var0.aox;
    }

    // $FF: renamed from: d (com.google.android.gms.tagmanager.o) long
    // $FF: synthetic method
    static long method_1115(class_209 var0) {
        return var0.aoh;
    }

    // $FF: renamed from: e (com.google.android.gms.tagmanager.o) boolean
    // $FF: synthetic method
    static boolean method_1116(class_209 var0) {
        return var0.method_1119();
    }

    // $FF: renamed from: oa () boolean
    private boolean method_1119() {
        class_618 var1 = class_618.method_3490();
        return (var1.method_3492() == class_618.class_1772.aqi || var1.method_3492() == class_618.class_1772.aqj) && this.aoc.equals(var1.getContainerId());
    }

    // $FF: renamed from: w (long) void
    private void method_1120(long var1) {
        synchronized(this) {}

        try {
            if(this.aoz == null) {
                class_612.method_3459("Refresh requested, but no network load scheduler.");
            } else {
                this.aoz.method_226(var1, this.aox.field_1009);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: aE (com.google.android.gms.common.api.Status) com.google.android.gms.tagmanager.ContainerHolder
    protected ContainerHolder method_1121(Status var1) {
        if(this.aov != null) {
            return this.aov;
        } else {
            if(var1 == Status.field_4742) {
                class_612.method_3456("timer expired: setting result to failure");
            }

            return new class_715(var1);
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
    // $FF: synthetic method
    protected Result method_1104(Status var1) {
        return this.method_1121(var1);
    }

    // $FF: renamed from: cr (java.lang.String) void
    void method_1122(String var1) {
        synchronized(this) {}

        try {
            this.aoy = var1;
            if(this.aoz != null) {
                this.aoz.method_225(var1);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: nU () java.lang.String
    String method_1123() {
        synchronized(this) {}

        String var2;
        try {
            var2 = this.aoy;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: nX () void
    public void method_1124() {
        class_638.class_1807 var1 = this.aou.method_222(this.aot);
        if(var1 != null) {
            Container var2 = new Container(this.mContext, this.aoo.getDataLayer(), this.aoc, 0L, var1);
            this.b(new class_715(this.aoo, this.field_69, var2, new class_715.class_1204() {
                // $FF: renamed from: cr (java.lang.String) void
                public void method_135(String var1) {
                    class_209.this.method_1122(var1);
                }

                // $FF: renamed from: nU () java.lang.String
                public String method_136() {
                    return class_209.this.method_1123();
                }

                // $FF: renamed from: nW () void
                public void method_137() {
                    class_612.method_3459("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            class_612.method_3456("Default was requested, but no default container was found");
            this.b(this.method_1121(new Status(10, "Default was requested, but no default container was found", (PendingIntent)null)));
        }

        this.aoz = null;
        this.aou = null;
    }

    // $FF: renamed from: nY () void
    public void method_1125() {
        this.method_1106(false);
    }

    // $FF: renamed from: nZ () void
    public void method_1126() {
        this.method_1106(true);
    }

    interface class_1395 {
        // $FF: renamed from: b (com.google.android.gms.tagmanager.Container) boolean
        boolean method_718(Container var1);
    }

    private class class_1396 implements bg<class_167.class_1513> {
        private class_1396() {
        }

        // $FF: synthetic method
        class_1396(Object var2) {
            this();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ol$a) void
        public void method_4405(class_167.class_1513 var1) {
            class_51.class_1320 var3;
            if(var1.ass != null) {
                var3 = var1.ass;
            } else {
                class_51.class_1327 var2 = var1.field_952;
                var3 = new class_51.class_1320();
                var3.field_1008 = var2;
                var3.field_1007 = null;
                var3.field_1009 = var2.version;
            }

            class_209.method_1112(class_209.this, var3, var1.asr, true);
        }

        // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
        public void method_326(class_68.class_1174 var1) {
            if(!class_209.this.aow) {
                class_209.this.method_1120(0L);
            }

        }

        // $FF: renamed from: l (java.lang.Object) void
        // $FF: synthetic method
        public void method_327(Object var1) {
            this.method_4405((class_167.class_1513)var1);
        }

        // $FF: renamed from: ob () void
        public void method_328() {
        }
    }

    private class class_1397 implements bg<class_51.class_1320> {
        private class_1397() {
        }

        // $FF: synthetic method
        class_1397(Object var2) {
            this();
        }

        // $FF: renamed from: a (com.google.android.gms.tagmanager.bg$a) void
        public void method_326(class_68.class_1174 var1) {
            if(class_209.this.aov != null) {
                class_209.this.b(class_209.this.aov);
            } else {
                class_209.this.b(class_209.this.method_1121(Status.field_4742));
            }

            class_209.this.method_1120(3600000L);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.c$j) void
        public void method_4404(class_51.class_1320 param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: l (java.lang.Object) void
        // $FF: synthetic method
        public void method_327(Object var1) {
            this.method_4404((class_51.class_1320)var1);
        }

        // $FF: renamed from: ob () void
        public void method_328() {
        }
    }

    private class class_1398 implements class_715.class_1204 {
        private class_1398() {
        }

        // $FF: synthetic method
        class_1398(Object var2) {
            this();
        }

        // $FF: renamed from: cr (java.lang.String) void
        public void method_135(String var1) {
            class_209.this.method_1122(var1);
        }

        // $FF: renamed from: nU () java.lang.String
        public String method_136() {
            return class_209.this.method_1123();
        }

        // $FF: renamed from: nW () void
        public void method_137() {
            if(class_209.this.aos.method_345()) {
                class_209.this.method_1120(0L);
            }

        }
    }

    interface class_1399 extends Releasable {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
        void method_224(bg<class_51.class_1320> var1);

        // $FF: renamed from: cu (java.lang.String) void
        void method_225(String var1);

        // $FF: renamed from: e (long, java.lang.String) void
        void method_226(long var1, String var3);
    }

    interface class_1400 extends Releasable {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
        void method_220(bg<class_167.class_1513> var1);

        // $FF: renamed from: b (com.google.android.gms.internal.ol$a) void
        void method_221(class_167.class_1513 var1);

        // $FF: renamed from: ff (int) com.google.android.gms.tagmanager.cr$c
        class_638.class_1807 method_222(int var1);

        // $FF: renamed from: oc () void
        void method_223();
    }
}

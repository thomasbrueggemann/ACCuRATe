package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_178;
import com.google.android.gms.analytics.class_186;
import com.google.android.gms.analytics.class_926;
import com.google.android.gms.analytics.class_927;
import com.google.android.gms.analytics.class_932;
import com.google.android.gms.analytics.class_935;
import com.google.android.gms.analytics.class_936;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_940;
import com.google.android.gms.analytics.class_953;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.hb;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.analytics.s
class class_941 extends Thread implements class_174 {
    // $FF: renamed from: yX com.google.android.gms.analytics.s
    private static class_941 field_4305;
    private volatile boolean mClosed = false;
    private final Context mContext;
    // $FF: renamed from: yT java.util.concurrent.LinkedBlockingQueue
    private final LinkedBlockingQueue<Runnable> field_4306 = new LinkedBlockingQueue();
    // $FF: renamed from: yU boolean
    private volatile boolean field_4307 = false;
    // $FF: renamed from: yV java.util.List
    private volatile List<hb> field_4308;
    // $FF: renamed from: yW java.lang.String
    private volatile String field_4309;
    // $FF: renamed from: yY com.google.android.gms.analytics.af
    private volatile class_186 field_4310;

    private class_941(Context var1) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.start();
    }

    // $FF: renamed from: B (android.content.Context) com.google.android.gms.analytics.s
    static class_941 method_4868(Context var0) {
        if(field_4305 == null) {
            field_4305 = new class_941(var0);
        }

        return field_4305;
    }

    // $FF: renamed from: C (android.content.Context) java.lang.String
    static String method_4869(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ah (java.lang.String) int
    static int method_4873(String var0) {
        int var1 = 1;
        if(!TextUtils.isEmpty(var0)) {
            int var2 = -1 + var0.length();
            var1 = 0;

            for(int var3 = var2; var3 >= 0; --var3) {
                char var4 = var0.charAt(var3);
                var1 = var4 + (268435455 & var1 << 6) + (var4 << 14);
                int var5 = 266338304 & var1;
                if(var5 != 0) {
                    var1 ^= var5 >> 21;
                }
            }
        }

        return var1;
    }

    // $FF: renamed from: g (java.lang.Throwable) java.lang.String
    private String method_4880(Throwable var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        PrintStream var3 = new PrintStream(var2);
        var1.printStackTrace(var3);
        var3.flush();
        return new String(var2.toByteArray());
    }

    // $FF: renamed from: v (java.util.Map) java.lang.String
    private String method_4881(Map<String, String> var1) {
        return var1.containsKey("useSecure")?(class_953.method_5027((String)var1.get("useSecure"), true)?"https:":"http:"):"https:";
    }

    // $FF: renamed from: w (java.util.Map) boolean
    private boolean method_4882(Map<String, String> var1) {
        if(var1.get("&sf") == null) {
            return false;
        } else {
            double var2 = class_953.method_5020((String)var1.get("&sf"), 100.0D);
            if(var2 >= 100.0D) {
                return false;
            } else if((double)(method_4873((String)var1.get("&cid")) % 10000) >= var2 * 100.0D) {
                String var4;
                if(var1.get("&t") == null) {
                    var4 = "unknown";
                } else {
                    var4 = (String)var1.get("&t");
                }

                class_938.method_4860(String.format("%s hit sampled out", new Object[] {var4}));
                return true;
            } else {
                return false;
            }
        }
    }

    // $FF: renamed from: x (java.util.Map) void
    private void method_4883(Map<String, String> var1) {
        class_178 var2 = class_935.method_4846(this.mContext);
        class_953.method_5022(var1, "&adid", var2);
        class_953.method_5022(var1, "&ate", var2);
    }

    // $FF: renamed from: y (java.util.Map) void
    private void method_4884(Map<String, String> var1) {
        class_926 var2 = class_926.method_4776();
        class_953.method_5022(var1, "&an", var2);
        class_953.method_5022(var1, "&av", var2);
        class_953.method_5022(var1, "&aid", var2);
        class_953.method_5022(var1, "&aiid", var2);
        var1.put("&v", "1");
    }

    // $FF: renamed from: b (java.lang.Runnable) void
    void method_4885(Runnable var1) {
        this.field_4306.add(var1);
    }

    // $FF: renamed from: dH () void
    public void method_819() {
        this.method_4885(new Runnable() {
            public void run() {
                class_941.this.field_4310.method_871();
            }
        });
    }

    // $FF: renamed from: dN () void
    public void method_820() {
        this.method_4885(new Runnable() {
            public void run() {
                class_941.this.field_4310.method_872();
            }
        });
    }

    // $FF: renamed from: dO () java.util.concurrent.LinkedBlockingQueue
    public LinkedBlockingQueue<Runnable> method_821() {
        return this.field_4306;
    }

    public void dispatch() {
        this.method_4885(new Runnable() {
            public void run() {
                class_941.this.field_4310.dispatch();
            }
        });
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.field_4310.method_873();
        this.field_4308 = new ArrayList();
        this.field_4308.add(new class_409("appendVersion", "&_v".substring(1), "ma4.0.3"));
        this.field_4308.add(new class_409("appendQueueTime", "&qt".substring(1), (String)null));
        this.field_4308.add(new class_409("appendCacheBuster", "&z".substring(1), (String)null));
    }

    public void run() {
        Process.setThreadPriority(10);

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var9) {
            class_938.method_4861("sleep interrupted in GAThread initialize");
        }

        try {
            if(this.field_4310 == null) {
                this.field_4310 = new class_932(this.mContext, this);
            }

            this.init();
            this.field_4309 = method_4869(this.mContext);
            class_938.method_4860("Initialized GA Thread");
        } catch (Throwable var8) {
            class_938.method_4858("Error initializing the GAThread: " + this.method_4880(var8));
            class_938.method_4858("Google Analytics will not start up.");
            this.field_4307 = true;
        }

        while(!this.mClosed) {
            try {
                try {
                    Runnable var5 = (Runnable)this.field_4306.take();
                    if(!this.field_4307) {
                        var5.run();
                    }
                } catch (InterruptedException var6) {
                    class_938.method_4859(var6.toString());
                }
            } catch (Throwable var7) {
                class_938.method_4858("Error on GAThread: " + this.method_4880(var7));
                class_938.method_4858("Google Analytics is shutting down.");
                this.field_4307 = true;
            }
        }

    }

    // $FF: renamed from: u (java.util.Map) void
    public void method_822(Map<String, String> var1) {
        final HashMap var2 = new HashMap(var1);
        String var3 = (String)var1.get("&ht");
        if(var3 != null) {
            try {
                Long.valueOf(var3);
            } catch (NumberFormatException var6) {
                var3 = null;
            }
        }

        if(var3 == null) {
            var2.put("&ht", Long.toString(System.currentTimeMillis()));
        }

        this.method_4885(new Runnable() {
            public void run() {
                class_941.this.method_4883(var2);
                if(TextUtils.isEmpty((CharSequence)var2.get("&cid"))) {
                    var2.put("&cid", class_927.method_4783().getValue("&cid"));
                }

                if(!GoogleAnalytics.getInstance(class_941.this.mContext).getAppOptOut() && !class_941.this.method_4882(var2)) {
                    if(!TextUtils.isEmpty(class_941.this.field_4309)) {
                        class_940.method_4863().method_4864(true);
                        var2.putAll((new HitBuilders.HitBuilder()).setCampaignParamsFromUrl(class_941.this.field_4309).build());
                        class_940.method_4863().method_4864(false);
                        class_941.this.field_4309 = null;
                    }

                    class_941.this.method_4884(var2);
                    Map var1 = class_936.method_4851(var2);
                    class_941.this.field_4310.method_870(var1, Long.valueOf((String)var2.get("&ht")).longValue(), class_941.this.method_4881(var2), class_941.this.field_4308);
                }
            }
        });
    }
}

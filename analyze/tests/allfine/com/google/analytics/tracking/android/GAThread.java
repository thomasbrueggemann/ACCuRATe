package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.AnalyticsThread;
import com.google.analytics.tracking.android.AppFieldsDefaultProvider;
import com.google.analytics.tracking.android.ClientIdDefaultProvider;
import com.google.analytics.tracking.android.GAServiceProxy;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.HitBuilder;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.ServiceProxy;
import com.google.analytics.tracking.android.Utils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread extends Thread implements AnalyticsThread {
    static final String API_VERSION = "1";
    private static final String CLIENT_VERSION = "ma3.0.2";
    private static final int MAX_SAMPLE_RATE = 100;
    private static final int SAMPLE_RATE_MODULO = 10000;
    private static final int SAMPLE_RATE_MULTIPLIER = 100;
    private static GAThread sInstance;
    private volatile String mClientId;
    private volatile boolean mClosed = false;
    private volatile List<Command> mCommands;
    private final Context mContext;
    private volatile boolean mDisabled = false;
    private volatile String mInstallCampaign;
    private volatile ServiceProxy mServiceProxy;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();

    private GAThread(Context var1) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.start();
    }

    @VisibleForTesting
    GAThread(Context var1, ServiceProxy var2) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.mServiceProxy = var2;
        this.start();
    }

    private void fillAppParameters(Map<String, String> var1) {
        AppFieldsDefaultProvider var2 = AppFieldsDefaultProvider.getProvider();
        Utils.putIfAbsent(var1, "&an", var2.getValue("&an"));
        Utils.putIfAbsent(var1, "&av", var2.getValue("&av"));
        Utils.putIfAbsent(var1, "&aid", var2.getValue("&aid"));
        Utils.putIfAbsent(var1, "&aiid", var2.getValue("&aiid"));
        var1.put("&v", "1");
    }

    @VisibleForTesting
    static String getAndClearCampaign(Context param0) {
        // $FF: Couldn't be decompiled
    }

    static GAThread getInstance(Context var0) {
        if(sInstance == null) {
            sInstance = new GAThread(var0);
        }

        return sInstance;
    }

    private String getUrlScheme(Map<String, String> var1) {
        return var1.containsKey("useSecure")?(Utils.safeParseBoolean((String)var1.get("useSecure"), true)?"https:":"http:"):"https:";
    }

    @VisibleForTesting
    static int hashClientIdForSampling(String var0) {
        int var1 = 1;
        if(!TextUtils.isEmpty(var0)) {
            var1 = 0;

            for(int var2 = -1 + var0.length(); var2 >= 0; --var2) {
                char var3 = var0.charAt(var2);
                var1 = var3 + (268435455 & var1 << 6) + (var3 << 14);
                int var4 = var1 & 266338304;
                if(var4 != 0) {
                    var1 ^= var4 >> 21;
                }
            }
        }

        return var1;
    }

    private boolean isSampledOut(Map<String, String> var1) {
        if(var1.get("&sf") == null) {
            return false;
        } else {
            double var2 = Utils.safeParseDouble((String)var1.get("&sf"), 100.0D);
            if(var2 >= 100.0D) {
                return false;
            } else if((double)(hashClientIdForSampling((String)var1.get("&cid")) % 10000) >= 100.0D * var2) {
                String var4;
                if(var1.get("&t") == null) {
                    var4 = "unknown";
                } else {
                    var4 = (String)var1.get("&t");
                }

                Log.method_2106(String.format("%s hit sampled out", new Object[] {var4}));
                return true;
            } else {
                return false;
            }
        }
    }

    private String printStackTrace(Throwable var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        PrintStream var3 = new PrintStream(var2);
        var1.printStackTrace(var3);
        var3.flush();
        return new String(var2.toByteArray());
    }

    public void clearHits() {
        this.queueToThread(new Runnable() {
            public void run() {
                GAThread.this.mServiceProxy.clearHits();
            }
        });
    }

    @VisibleForTesting
    void close() {
        this.mClosed = true;
        this.interrupt();
    }

    public void dispatch() {
        this.queueToThread(new Runnable() {
            public void run() {
                GAThread.this.mServiceProxy.dispatch();
            }
        });
    }

    public LinkedBlockingQueue<Runnable> getQueue() {
        return this.queue;
    }

    public Thread getThread() {
        return this;
    }

    @VisibleForTesting
    protected void init() {
        this.mServiceProxy.createService();
        this.mCommands = new ArrayList();
        this.mCommands.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.2"));
        this.mCommands.add(new Command("appendQueueTime", "&qt".substring(1), (String)null));
        this.mCommands.add(new Command("appendCacheBuster", "&z".substring(1), (String)null));
    }

    @VisibleForTesting
    boolean isDisabled() {
        return this.mDisabled;
    }

    @VisibleForTesting
    void queueToThread(Runnable var1) {
        this.queue.add(var1);
    }

    public void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var9) {
            Log.method_2107("sleep interrupted in GAThread initialize");
        }

        try {
            if(this.mServiceProxy == null) {
                this.mServiceProxy = new GAServiceProxy(this.mContext, this);
            }

            this.init();
            this.mClientId = ClientIdDefaultProvider.getProvider().getValue("&cid");
            this.mInstallCampaign = getAndClearCampaign(this.mContext);
        } catch (Throwable var8) {
            Log.method_2104("Error initializing the GAThread: " + this.printStackTrace(var8));
            Log.method_2104("Google Analytics will not start up.");
            this.mDisabled = true;
        }

        while(!this.mClosed) {
            try {
                try {
                    Runnable var5 = (Runnable)this.queue.take();
                    if(!this.mDisabled) {
                        var5.run();
                    }
                } catch (InterruptedException var6) {
                    Log.method_2105(var6.toString());
                }
            } catch (Throwable var7) {
                Log.method_2104("Error on GAThread: " + this.printStackTrace(var7));
                Log.method_2104("Google Analytics is shutting down.");
                this.mDisabled = true;
            }
        }

    }

    public void sendHit(Map<String, String> var1) {
        final HashMap var2 = new HashMap(var1);
        String var3 = (String)var1.get("&ht");
        if(var3 != null) {
            try {
                Long.valueOf(var3).longValue();
            } catch (NumberFormatException var6) {
                var3 = null;
            }
        }

        if(var3 == null) {
            var2.put("&ht", Long.toString(System.currentTimeMillis()));
        }

        this.queueToThread(new Runnable() {
            public void run() {
                if(TextUtils.isEmpty((CharSequence)var2.get("&cid"))) {
                    var2.put("&cid", GAThread.this.mClientId);
                }

                if(!GoogleAnalytics.getInstance(GAThread.this.mContext).getAppOptOut() && !GAThread.this.isSampledOut(var2)) {
                    if(!TextUtils.isEmpty(GAThread.this.mInstallCampaign)) {
                        GAUsage.getInstance().setDisableUsage(true);
                        var2.putAll((new MapBuilder()).setCampaignParamsFromUrl(GAThread.this.mInstallCampaign).build());
                        GAUsage.getInstance().setDisableUsage(false);
                        GAThread.this.mInstallCampaign = null;
                    }

                    GAThread.this.fillAppParameters(var2);
                    Map var1 = HitBuilder.generateHitParams(var2);
                    GAThread.this.mServiceProxy.putHit(var1, Long.valueOf((String)var2.get("&ht")).longValue(), GAThread.this.getUrlScheme(var2), GAThread.this.mCommands);
                }
            }
        });
    }

    public void setForceLocalDispatch() {
        this.queueToThread(new Runnable() {
            public void run() {
                GAThread.this.mServiceProxy.setForceLocalDispatch();
            }
        });
    }
}

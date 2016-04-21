package com.google.analytics.tracking.android;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.analytics.tracking.android.AnalyticsStore;
import com.google.analytics.tracking.android.AnalyticsStoreStateListener;
import com.google.analytics.tracking.android.AnalyticsThread;
import com.google.analytics.tracking.android.GANetworkReceiver;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.PersistentAnalyticsStore;
import com.google.analytics.tracking.android.ServiceManager;
import com.google.android.gms.common.util.VisibleForTesting;

public class GAServiceManager extends ServiceManager {
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT = new Object();
    private static GAServiceManager instance;
    private boolean connected = true;
    private Context ctx;
    private int dispatchPeriodInSeconds = 1800;
    private Handler handler;
    private boolean listenForNetwork = true;
    private AnalyticsStoreStateListener listener = new AnalyticsStoreStateListener() {
        public void reportStoreIsEmpty(boolean var1) {
            GAServiceManager.this.updatePowerSaveMode(var1, GAServiceManager.this.connected);
        }
    };
    private GANetworkReceiver networkReceiver;
    private boolean pendingDispatch = true;
    private boolean pendingForceLocalDispatch;
    private String pendingHostOverride;
    private AnalyticsStore store;
    private boolean storeIsEmpty = false;
    private volatile AnalyticsThread thread;

    private GAServiceManager() {
    }

    @VisibleForTesting
    GAServiceManager(Context var1, AnalyticsThread var2, AnalyticsStore var3, boolean var4) {
        this.store = var3;
        this.thread = var2;
        this.listenForNetwork = var4;
        this.initialize(var1, var2);
    }

    @VisibleForTesting
    static void clearInstance() {
        instance = null;
    }

    public static GAServiceManager getInstance() {
        if(instance == null) {
            instance = new GAServiceManager();
        }

        return instance;
    }

    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), new Callback() {
            public boolean handleMessage(Message var1) {
                if(1 == var1.what && GAServiceManager.MSG_OBJECT.equals(var1.obj)) {
                    GAUsage.getInstance().setDisableUsage(true);
                    GAServiceManager.this.dispatchLocalHits();
                    GAUsage.getInstance().setDisableUsage(false);
                    if(GAServiceManager.this.dispatchPeriodInSeconds > 0 && !GAServiceManager.this.storeIsEmpty) {
                        GAServiceManager.this.handler.sendMessageDelayed(GAServiceManager.this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long)(1000 * GAServiceManager.this.dispatchPeriodInSeconds));
                    }
                }

                return true;
            }
        });
        if(this.dispatchPeriodInSeconds > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, MSG_OBJECT), (long)(1000 * this.dispatchPeriodInSeconds));
        }

    }

    private void initializeNetworkReceiver() {
        this.networkReceiver = new GANetworkReceiver(this);
        this.networkReceiver.register(this.ctx);
    }

    @Deprecated
    public void dispatchLocalHits() {
        synchronized(this) {}

        try {
            if(this.thread == null) {
                Log.method_2106("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.pendingDispatch = true;
            } else {
                GAUsage.getInstance().setUsage(GAUsage.Field.DISPATCH);
                this.thread.dispatch();
            }
        } finally {
            ;
        }

    }

    @VisibleForTesting
    AnalyticsStoreStateListener getListener() {
        return this.listener;
    }

    AnalyticsStore getStore() {
        synchronized(this) {}

        AnalyticsStore var2;
        try {
            if(this.store == null) {
                if(this.ctx == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }

                this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
                if(this.pendingHostOverride != null) {
                    this.store.getDispatcher().overrideHostUrl(this.pendingHostOverride);
                    this.pendingHostOverride = null;
                }
            }

            if(this.handler == null) {
                this.initializeHandler();
            }

            if(this.networkReceiver == null && this.listenForNetwork) {
                this.initializeNetworkReceiver();
            }

            var2 = this.store;
        } finally {
            ;
        }

        return var2;
    }

    void initialize(Context param1, AnalyticsThread param2) {
        // $FF: Couldn't be decompiled
    }

    void onRadioPowered() {
        synchronized(this) {}

        try {
            if(!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                this.handler.removeMessages(1, MSG_OBJECT);
                this.handler.sendMessage(this.handler.obtainMessage(1, MSG_OBJECT));
            }
        } finally {
            ;
        }

    }

    @VisibleForTesting
    void overrideHostUrl(String var1) {
        synchronized(this) {}

        try {
            if(this.store == null) {
                this.pendingHostOverride = var1;
            } else {
                this.store.getDispatcher().overrideHostUrl(var1);
            }
        } finally {
            ;
        }

    }

    @Deprecated
    public void setForceLocalDispatch() {
        if(this.thread == null) {
            Log.method_2106("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.pendingForceLocalDispatch = true;
        } else {
            GAUsage.getInstance().setUsage(GAUsage.Field.SET_FORCE_LOCAL_DISPATCH);
            this.thread.setForceLocalDispatch();
        }
    }

    @Deprecated
    public void setLocalDispatchPeriod(int param1) {
        // $FF: Couldn't be decompiled
    }

    void updateConnectivityStatus(boolean var1) {
        synchronized(this) {}

        try {
            this.updatePowerSaveMode(this.storeIsEmpty, var1);
        } finally {
            ;
        }

    }

    @VisibleForTesting
    void updatePowerSaveMode(boolean param1, boolean param2) {
        // $FF: Couldn't be decompiled
    }
}

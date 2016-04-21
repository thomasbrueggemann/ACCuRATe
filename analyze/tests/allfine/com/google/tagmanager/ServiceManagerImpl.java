package com.google.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.HitSendingThread;
import com.google.tagmanager.HitStore;
import com.google.tagmanager.HitStoreStateListener;
import com.google.tagmanager.Log;
import com.google.tagmanager.NetworkReceiver;
import com.google.tagmanager.PersistentHitStore;
import com.google.tagmanager.ServiceManager;

class ServiceManagerImpl extends ServiceManager {
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT = new Object();
    private static ServiceManagerImpl instance;
    private boolean connected = true;
    private Context ctx;
    private int dispatchPeriodInSeconds = 1800;
    private Handler handler;
    private boolean listenForNetwork = true;
    private HitStoreStateListener listener = new HitStoreStateListener() {
        public void reportStoreIsEmpty(boolean var1) {
            ServiceManagerImpl.this.updatePowerSaveMode(var1, ServiceManagerImpl.this.connected);
        }
    };
    private NetworkReceiver networkReceiver;
    private boolean pendingDispatch = true;
    private boolean readyToDispatch = false;
    private HitStore store;
    private boolean storeIsEmpty = false;
    private volatile HitSendingThread thread;

    private ServiceManagerImpl() {
    }

    @VisibleForTesting
    ServiceManagerImpl(Context var1, HitSendingThread var2, HitStore var3, boolean var4) {
        this.store = var3;
        this.thread = var2;
        this.listenForNetwork = var4;
        this.initialize(var1, var2);
    }

    @VisibleForTesting
    static void clearInstance() {
        instance = null;
    }

    public static ServiceManagerImpl getInstance() {
        if(instance == null) {
            instance = new ServiceManagerImpl();
        }

        return instance;
    }

    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), new Callback() {
            public boolean handleMessage(Message var1) {
                if(1 == var1.what && ServiceManagerImpl.MSG_OBJECT.equals(var1.obj)) {
                    ServiceManagerImpl.this.dispatch();
                    if(ServiceManagerImpl.this.dispatchPeriodInSeconds > 0 && !ServiceManagerImpl.this.storeIsEmpty) {
                        ServiceManagerImpl.this.handler.sendMessageDelayed(ServiceManagerImpl.this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), (long)(1000 * ServiceManagerImpl.this.dispatchPeriodInSeconds));
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
        this.networkReceiver = new NetworkReceiver(this);
        this.networkReceiver.register(this.ctx);
    }

    public void dispatch() {
        synchronized(this) {}

        try {
            if(!this.readyToDispatch) {
                Log.method_5507("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.pendingDispatch = true;
            } else {
                this.thread.queueToThread(new Runnable() {
                    public void run() {
                        ServiceManagerImpl.this.store.dispatch();
                    }
                });
            }
        } finally {
            ;
        }

    }

    @VisibleForTesting
    HitStoreStateListener getListener() {
        return this.listener;
    }

    HitStore getStore() {
        synchronized(this) {}

        HitStore var2;
        try {
            if(this.store == null) {
                if(this.ctx == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }

                this.store = new PersistentHitStore(this.listener, this.ctx);
            }

            if(this.handler == null) {
                this.initializeHandler();
            }

            this.readyToDispatch = true;
            if(this.pendingDispatch) {
                this.dispatch();
                this.pendingDispatch = false;
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

    void initialize(Context param1, HitSendingThread param2) {
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

    public void setDispatchPeriod(int param1) {
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

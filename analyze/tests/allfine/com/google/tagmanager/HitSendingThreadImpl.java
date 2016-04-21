package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.HitSendingThread;
import com.google.tagmanager.HitStore;
import com.google.tagmanager.Log;
import com.google.tagmanager.ServiceManagerImpl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class HitSendingThreadImpl extends Thread implements HitSendingThread {
    private static HitSendingThreadImpl sInstance;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean mDisabled = false;
    private volatile HitStore mUrlStore;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();

    private HitSendingThreadImpl(Context var1) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.start();
    }

    @VisibleForTesting
    HitSendingThreadImpl(Context var1, HitStore var2) {
        super("GAThread");
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        this.mUrlStore = var2;
        this.start();
    }

    static HitSendingThreadImpl getInstance(Context var0) {
        if(sInstance == null) {
            sInstance = new HitSendingThreadImpl(var0);
        }

        return sInstance;
    }

    private String printStackTrace(Throwable var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        PrintStream var3 = new PrintStream(var2);
        var1.printStackTrace(var3);
        var3.flush();
        return new String(var2.toByteArray());
    }

    @VisibleForTesting
    void close() {
        this.mClosed = true;
        this.interrupt();
    }

    @VisibleForTesting
    int getQueueSize() {
        return this.queue.size();
    }

    @VisibleForTesting
    HitStore getStore() {
        return this.mUrlStore;
    }

    @VisibleForTesting
    boolean isDisabled() {
        return this.mDisabled;
    }

    public void queueToThread(Runnable var1) {
        this.queue.add(var1);
    }

    public void run() {
        while(!this.mClosed) {
            try {
                try {
                    Runnable var3 = (Runnable)this.queue.take();
                    if(!this.mDisabled) {
                        var3.run();
                    }
                } catch (InterruptedException var4) {
                    Log.method_5505(var4.toString());
                }
            } catch (Throwable var5) {
                Log.method_5503("Error on GAThread: " + this.printStackTrace(var5));
                Log.method_5503("Google Analytics is shutting down.");
                this.mDisabled = true;
            }
        }

    }

    public void sendHit(String var1) {
        this.sendHit(var1, System.currentTimeMillis());
    }

    @VisibleForTesting
    void sendHit(final String var1, final long var2) {
        this.queueToThread(new Runnable() {
            public void run() {
                if(HitSendingThreadImpl.this.mUrlStore == null) {
                    ServiceManagerImpl var1x = ServiceManagerImpl.getInstance();
                    var1x.initialize(HitSendingThreadImpl.this.mContext, HitSendingThreadImpl.this);
                    HitSendingThreadImpl.this.mUrlStore = var1x.getStore();
                }

                HitSendingThreadImpl.this.mUrlStore.putHit(var2, var1);
            }
        });
    }
}

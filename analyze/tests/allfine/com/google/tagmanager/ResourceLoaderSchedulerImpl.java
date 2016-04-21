package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container;
import com.google.tagmanager.CtfeHost;
import com.google.tagmanager.LoadCallback;
import com.google.tagmanager.Log;
import com.google.tagmanager.ResourceLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class ResourceLoaderSchedulerImpl implements Container.ResourceLoaderScheduler {
    private static final boolean MAY_INTERRUPT_IF_RUNNING = true;
    private LoadCallback<Serving.SupplementedResource> mCallback;
    private boolean mClosed;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private String mCtfeUrlPathAndQuery;
    private final ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private final ResourceLoaderSchedulerImpl.ResourceLoaderFactory mResourceLoaderFactory;

    public ResourceLoaderSchedulerImpl(Context var1, String var2, CtfeHost var3) {
        this(var1, var2, var3, (ResourceLoaderSchedulerImpl.ScheduledExecutorServiceFactory)null, (ResourceLoaderSchedulerImpl.ResourceLoaderFactory)null);
    }

    @VisibleForTesting
    ResourceLoaderSchedulerImpl(Context var1, String var2, CtfeHost var3, ResourceLoaderSchedulerImpl.ScheduledExecutorServiceFactory var4, ResourceLoaderSchedulerImpl.ResourceLoaderFactory var5) {
        this.mCtfeHost = var3;
        this.mContext = var1;
        this.mContainerId = var2;
        if(var4 == null) {
            var4 = new ResourceLoaderSchedulerImpl.ScheduledExecutorServiceFactory() {
                public ScheduledExecutorService createExecutorService() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }

        this.mExecutor = var4.createExecutorService();
        if(var5 == null) {
            this.mResourceLoaderFactory = new ResourceLoaderSchedulerImpl.ResourceLoaderFactory() {
                public ResourceLoader createResourceLoader(CtfeHost var1) {
                    return new ResourceLoader(ResourceLoaderSchedulerImpl.this.mContext, ResourceLoaderSchedulerImpl.this.mContainerId, var1);
                }
            };
        } else {
            this.mResourceLoaderFactory = var5;
        }
    }

    private ResourceLoader createResourceLoader(String var1) {
        ResourceLoader var2 = this.mResourceLoaderFactory.createResourceLoader(this.mCtfeHost);
        var2.setLoadCallback(this.mCallback);
        var2.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
        var2.setPreviousVersion(var1);
        return var2;
    }

    private void ensureNotClosed() {
        synchronized(this) {}

        try {
            if(this.mClosed) {
                throw new IllegalStateException("called method after closed");
            }
        } finally {
            ;
        }

    }

    public void close() {
        synchronized(this) {}

        try {
            this.ensureNotClosed();
            if(this.mFuture != null) {
                this.mFuture.cancel(false);
            }

            this.mExecutor.shutdown();
            this.mClosed = true;
        } finally {
            ;
        }

    }

    public void loadAfterDelay(long var1, String var3) {
        synchronized(this) {}

        try {
            Log.method_5507("loadAfterDelay: containerId=" + this.mContainerId + " delay=" + var1);
            this.ensureNotClosed();
            if(this.mCallback == null) {
                throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
            }

            if(this.mFuture != null) {
                this.mFuture.cancel(false);
            }

            this.mFuture = this.mExecutor.schedule(this.createResourceLoader(var3), var1, TimeUnit.MILLISECONDS);
        } finally {
            ;
        }

    }

    public void setCtfeURLPathAndQuery(String var1) {
        synchronized(this) {}

        try {
            this.ensureNotClosed();
            this.mCtfeUrlPathAndQuery = var1;
        } finally {
            ;
        }

    }

    public void setLoadCallback(LoadCallback<Serving.SupplementedResource> var1) {
        synchronized(this) {}

        try {
            this.ensureNotClosed();
            this.mCallback = var1;
        } finally {
            ;
        }

    }

    interface ResourceLoaderFactory {
        ResourceLoader createResourceLoader(CtfeHost var1);
    }

    interface ScheduledExecutorServiceFactory {
        ScheduledExecutorService createExecutorService();
    }
}

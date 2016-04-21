package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.AdwordsClickReferrerListener;
import com.google.tagmanager.Container;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.Log;
import com.google.tagmanager.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager sInstance;
    private final TagManager.ContainerProvider mContainerProvider;
    private final ConcurrentMap<String, Container> mContainers;
    private final Context mContext;
    private volatile String mCtfeServerAddr;
    private final DataLayer mDataLayer;
    private volatile TagManager.RefreshMode mRefreshMode;

    @VisibleForTesting
    TagManager(Context var1, TagManager.ContainerProvider var2, DataLayer var3) {
        if(var1 == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.mContext = var1.getApplicationContext();
            this.mContainerProvider = var2;
            this.mRefreshMode = TagManager.RefreshMode.STANDARD;
            this.mContainers = new ConcurrentHashMap();
            this.mDataLayer = var3;
            this.mDataLayer.registerListener(new DataLayer.Listener() {
                public void changed(Map<Object, Object> var1) {
                    Object var2 = var1.get("event");
                    if(var2 != null) {
                        TagManager.this.refreshTagsInAllContainers(var2.toString());
                    }

                }
            });
            this.mDataLayer.registerListener(new AdwordsClickReferrerListener(this.mContext));
        }
    }

    @VisibleForTesting
    static void clearInstance() {
        // $FF: Couldn't be decompiled
    }

    public static TagManager getInstance(Context param0) {
        // $FF: Couldn't be decompiled
    }

    private void refreshTagsInAllContainers(String var1) {
        Iterator var2 = this.mContainers.values().iterator();

        while(var2.hasNext()) {
            ((Container)var2.next()).evaluateTags(var1);
        }

    }

    public Container getContainer(String var1) {
        return (Container)this.mContainers.get(var1);
    }

    public Context getContext() {
        return this.mContext;
    }

    public DataLayer getDataLayer() {
        return this.mDataLayer;
    }

    public Logger getLogger() {
        return Log.getLogger();
    }

    public TagManager.RefreshMode getRefreshMode() {
        return this.mRefreshMode;
    }

    public Container openContainer(String var1, Container.Callback var2) {
        Container var3 = this.mContainerProvider.newContainer(this.mContext, var1, this);
        if(this.mContainers.putIfAbsent(var1, var3) != null) {
            throw new IllegalArgumentException("Container id:" + var1 + " has already been opened.");
        } else {
            if(this.mCtfeServerAddr != null) {
                var3.setCtfeServerAddress(this.mCtfeServerAddr);
            }

            var3.load(var2);
            return var3;
        }
    }

    boolean removeContainer(String var1) {
        return this.mContainers.remove(var1) != null;
    }

    @VisibleForTesting
    void setCtfeServerAddress(String var1) {
        this.mCtfeServerAddr = var1;
    }

    public void setLogger(Logger var1) {
        Log.setLogger(var1);
    }

    boolean setPreviewData(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    public void setRefreshMode(TagManager.RefreshMode var1) {
        this.mRefreshMode = var1;
    }

    static class ContainerOpenException extends RuntimeException {
        private final String mContainerId;

        private ContainerOpenException(String var1) {
            super("Container already open: " + var1);
            this.mContainerId = var1;
        }

        public String getContainerId() {
            return this.mContainerId;
        }
    }

    @VisibleForTesting
    interface ContainerProvider {
        Container newContainer(Context var1, String var2, TagManager var3);
    }

    @Deprecated
    public interface Logger extends Logger {
    }

    public static enum RefreshMode {
        DEFAULT_CONTAINER,
        STANDARD;

        static {
            TagManager.RefreshMode[] var0 = new TagManager.RefreshMode[]{STANDARD, DEFAULT_CONTAINER};
        }
    }
}

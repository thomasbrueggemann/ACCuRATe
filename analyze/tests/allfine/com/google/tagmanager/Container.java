package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Clock;
import com.google.tagmanager.CtfeHost;
import com.google.tagmanager.CustomFunctionCall;
import com.google.tagmanager.EventInfoDistributor;
import com.google.tagmanager.LoadCallback;
import com.google.tagmanager.Log;
import com.google.tagmanager.NoopEventInfoDistributor;
import com.google.tagmanager.PreviewManager;
import com.google.tagmanager.ResourceLoaderSchedulerImpl;
import com.google.tagmanager.ResourceStorageImpl;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.Runtime;
import com.google.tagmanager.TagManager;
import com.google.tagmanager.Types;
import com.google.tagmanager.proto.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
    static final boolean ENABLE_CONTAINER_DEBUG_MODE = false;
    @VisibleForTesting
    static final int MAX_NUMBER_OF_TOKENS = 30;
    static final int MINIMUM_REFRESH_PERIOD_BURST_MODE_MS = 5000;
    static final long MINIMUM_REFRESH_PERIOD_MS = 900000L;
    static final long REFRESH_PERIOD_ON_FAILURE_MS = 3600000L;
    static final long REFRESH_PERIOD_ON_SUCCESS_MS = 43200000L;
    private Clock mClock;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private volatile String mCtfeServerAddress;
    private volatile String mCtfeUrlPathAndQuery;
    @VisibleForTesting
    LoadCallback<Resource.ResourceWithMetadata> mDiskLoadCallback;
    private Map<String, Container.FunctionCallMacroHandler> mFunctionCallMacroHandlers;
    private Map<String, Container.FunctionCallTagHandler> mFunctionCallTagHandlers;
    private Serving.SupplementedResource mLastLoadedSupplementedResource;
    private volatile long mLastRefreshMethodCalledTime;
    private volatile long mLastRefreshTime;
    @VisibleForTesting
    LoadCallback<Serving.SupplementedResource> mNetworkLoadCallback;
    private Container.ResourceLoaderScheduler mNetworkLoadScheduler;
    private volatile int mNumTokens;
    private volatile int mResourceFormatVersion;
    private Container.ResourceStorage mResourceStorage;
    private volatile String mResourceVersion;
    private Runtime mRuntime;
    private final TagManager mTagManager;
    private Container.Callback mUserCallback;

    Container(Context var1, String var2, TagManager var3) {
        this(var1, var2, var3, new ResourceStorageImpl(var1, var2));
    }

    @VisibleForTesting
    Container(Context var1, String var2, TagManager var3, Container.ResourceStorage var4) {
        this.mResourceVersion = "";
        this.mResourceFormatVersion = 0;
        this.mCtfeHost = new CtfeHost();
        this.mContext = var1;
        this.mContainerId = var2;
        this.mTagManager = var3;
        this.mLastLoadedSupplementedResource = new Serving.SupplementedResource();
        this.mResourceStorage = var4;
        this.mNumTokens = 30;
        this.mFunctionCallMacroHandlers = new HashMap();
        this.mFunctionCallTagHandlers = new HashMap();
        this.createInitialContainer();
    }

    // $FF: synthetic method
    static boolean access$700(Container var0) {
        return var0.isContainerPreview();
    }

    // $FF: synthetic method
    static void access$800(Container var0, Serving.SupplementedResource var1) {
        var0.saveResourceToDisk(var1);
    }

    private void callRefreshBegin(Container.RefreshType var1) {
        synchronized(this) {}

        try {
            if(this.mUserCallback != null) {
                this.mUserCallback.containerRefreshBegin(this, var1);
            }
        } finally {
            ;
        }

    }

    private void callRefreshFailure(Container.RefreshType var1, Container.RefreshFailure var2) {
        synchronized(this) {}

        try {
            if(this.mUserCallback != null) {
                this.mUserCallback.containerRefreshFailure(this, var1, var2);
            }
        } finally {
            ;
        }

    }

    private void callRefreshSuccess(Container.RefreshType var1) {
        synchronized(this) {}

        try {
            Log.method_5507("calling containerRefreshSuccess(" + var1 + "): mUserCallback = " + this.mUserCallback);
            if(this.mUserCallback != null) {
                this.mUserCallback.containerRefreshSuccess(this, var1);
            }
        } finally {
            ;
        }

    }

    private void createInitialContainer() {
        String var1 = "tagmanager/" + this.mContainerId;
        Serving.Resource var2 = this.mResourceStorage.loadResourceFromContainerAsset(var1);
        if(var2 != null) {
            this.initEvaluators(var2);
        } else {
            ResourceUtil.ExpandedResource var3 = this.mResourceStorage.loadExpandedResourceFromJsonAsset(var1 + ".json");
            if(var3 == null) {
                Log.method_5509("No default container found; creating an empty container.");
                var3 = ResourceUtil.ExpandedResource.newBuilder().build();
            }

            this.initEvaluatorsWithExpandedResource(var3);
        }
    }

    private Runtime getRuntime() {
        synchronized(this) {}

        Runtime var2;
        try {
            var2 = this.mRuntime;
        } finally {
            ;
        }

        return var2;
    }

    private void initEvaluators(Serving.Resource var1) {
        ResourceUtil.ExpandedResource var3;
        try {
            var3 = ResourceUtil.getExpandedResource(var1);
        } catch (ResourceUtil.InvalidResourceException var4) {
            Log.method_5503("Not loading resource: " + var1 + " because it is invalid: " + var4.toString());
            return;
        }

        this.initEvaluatorsWithExpandedResource(var3);
    }

    private void initEvaluatorsWithExpandedResource(ResourceUtil.ExpandedResource var1) {
        this.mResourceVersion = var1.getVersion();
        this.mResourceFormatVersion = var1.getResourceFormatVersion();
        EventInfoDistributor var2 = this.createEventInfoDistributor(this.mResourceVersion);
        this.setRuntime(new Runtime(this.mContext, var1, this.mTagManager.getDataLayer(), new Container.FunctionCallMacroHandlerAdapter(null), new Container.FunctionCallTagHandlerAdapter(null), var2));
    }

    private boolean isContainerPreview() {
        PreviewManager var1 = PreviewManager.getInstance();
        return (var1.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER || var1.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(var1.getContainerId());
    }

    private boolean isDefaultContainerRefreshMode() {
        return this.mTagManager.getRefreshMode() == TagManager.RefreshMode.DEFAULT_CONTAINER;
    }

    private void saveResourceToDisk(Serving.SupplementedResource var1) {
        synchronized(this) {}

        try {
            if(this.mResourceStorage != null) {
                Resource.ResourceWithMetadata var3 = new Resource.ResourceWithMetadata();
                var3.timeStamp = this.getLastRefreshTime();
                var3.resource = new Serving.Resource();
                var3.supplementedResource = var1;
                this.mResourceStorage.saveResourceToDiskInBackground(var3);
            }
        } finally {
            ;
        }

    }

    private void setRuntime(Runtime var1) {
        synchronized(this) {}

        try {
            this.mRuntime = var1;
        } finally {
            ;
        }

    }

    private void setSupplementals(Serving.Supplemental[] var1) {
        ArrayList var2 = new ArrayList();
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            var2.add(var1[var4]);
        }

        this.getRuntime().setSupplementals(var2);
    }

    private boolean useAvailableToken(long var1) {
        if(this.mLastRefreshMethodCalledTime == 0L) {
            this.mNumTokens += -1;
            return true;
        } else {
            long var3 = var1 - this.mLastRefreshMethodCalledTime;
            if(var3 < 5000L) {
                return false;
            } else {
                if(this.mNumTokens < 30) {
                    this.mNumTokens = Math.min(30, (int)Math.floor((double)(var3 / 900000L)) + this.mNumTokens);
                }

                if(this.mNumTokens > 0) {
                    this.mNumTokens += -1;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public void close() {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    EventInfoDistributor createEventInfoDistributor(String var1) {
        if(PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
            ;
        }

        return new NoopEventInfoDistributor();
    }

    @VisibleForTesting
    void evaluateTags(String var1) {
        this.getRuntime().evaluateTags(var1);
    }

    public boolean getBoolean(String var1) {
        Runtime var2 = this.getRuntime();
        if(var2 == null) {
            Log.method_5503("getBoolean called for closed container.");
            return Types.getDefaultBoolean().booleanValue();
        } else {
            try {
                boolean var4 = Types.valueToBoolean((TypeSystem.Value)var2.evaluateMacroReference(var1).getObject()).booleanValue();
                return var4;
            } catch (Exception var5) {
                Log.method_5503("Calling getBoolean() threw an exception: " + var5.getMessage() + " Returning default value.");
                return Types.getDefaultBoolean().booleanValue();
            }
        }
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    String getCtfeUrlPathAndQuery() {
        return this.mCtfeUrlPathAndQuery;
    }

    public double getDouble(String var1) {
        Runtime var2 = this.getRuntime();
        if(var2 == null) {
            Log.method_5503("getDouble called for closed container.");
            return Types.getDefaultDouble().doubleValue();
        } else {
            try {
                double var4 = Types.valueToDouble((TypeSystem.Value)var2.evaluateMacroReference(var1).getObject()).doubleValue();
                return var4;
            } catch (Exception var6) {
                Log.method_5503("Calling getDouble() threw an exception: " + var6.getMessage() + " Returning default value.");
                return Types.getDefaultDouble().doubleValue();
            }
        }
    }

    public Container.FunctionCallMacroHandler getFunctionCallMacroHandler(String var1) {
        synchronized(this) {}

        Container.FunctionCallMacroHandler var3;
        try {
            var3 = (Container.FunctionCallMacroHandler)this.mFunctionCallMacroHandlers.get(var1);
        } finally {
            ;
        }

        return var3;
    }

    public Container.FunctionCallTagHandler getFunctionCallTagHandler(String var1) {
        synchronized(this) {}

        Container.FunctionCallTagHandler var3;
        try {
            var3 = (Container.FunctionCallTagHandler)this.mFunctionCallTagHandlers.get(var1);
        } finally {
            ;
        }

        return var3;
    }

    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }

    public long getLong(String var1) {
        Runtime var2 = this.getRuntime();
        if(var2 == null) {
            Log.method_5503("getLong called for closed container.");
            return Types.getDefaultInt64().longValue();
        } else {
            try {
                long var4 = Types.valueToInt64((TypeSystem.Value)var2.evaluateMacroReference(var1).getObject()).longValue();
                return var4;
            } catch (Exception var6) {
                Log.method_5503("Calling getLong() threw an exception: " + var6.getMessage() + " Returning default value.");
                return Types.getDefaultInt64().longValue();
            }
        }
    }

    @VisibleForTesting
    String getResourceVersion() {
        return this.mResourceVersion;
    }

    public String getString(String var1) {
        Runtime var2 = this.getRuntime();
        if(var2 == null) {
            Log.method_5503("getString called for closed container.");
            return Types.getDefaultString();
        } else {
            try {
                String var4 = Types.valueToString((TypeSystem.Value)var2.evaluateMacroReference(var1).getObject());
                return var4;
            } catch (Exception var5) {
                Log.method_5503("Calling getString() threw an exception: " + var5.getMessage() + " Returning default value.");
                return Types.getDefaultString();
            }
        }
    }

    public boolean isDefault() {
        return this.getLastRefreshTime() == 0L;
    }

    void load(Container.Callback var1) {
        Clock var2 = new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.load(var1, new ResourceLoaderSchedulerImpl(this.mContext, this.mContainerId, this.mCtfeHost), var2);
    }

    @VisibleForTesting
    void load(Container.Callback var1, Container.ResourceLoaderScheduler var2, final Clock var3) {
        synchronized(this) {}

        try {
            if(this.mDiskLoadCallback != null) {
                throw new RuntimeException("Container already loaded: container ID: " + this.mContainerId);
            }

            this.mClock = var3;
            this.mUserCallback = var1;
            this.mDiskLoadCallback = new LoadCallback() {
                private Container.RefreshFailure failureToRefreshFailure(LoadCallback.Failure var1) {
                    switch(null.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[var1.ordinal()]) {
                        case 1:
                            return Container.RefreshFailure.NO_SAVED_CONTAINER;
                        case 2:
                            return Container.RefreshFailure.IO_ERROR;
                        case 3:
                            return Container.RefreshFailure.SERVER_ERROR;
                        default:
                            return Container.RefreshFailure.UNKNOWN_ERROR;
                    }
                }

                public void onFailure(LoadCallback.Failure var1) {
                    Container.this.callRefreshFailure(Container.RefreshType.SAVED, this.failureToRefreshFailure(var1));
                    if(Container.this.isDefault()) {
                        Container.this.loadAfterDelay(0L);
                    }

                }

                public void onSuccess(Resource.ResourceWithMetadata var1) {
                    if(Container.this.isDefault()) {
                        Serving.Resource var2;
                        if(var1.supplementedResource != null) {
                            var2 = var1.supplementedResource.resource;
                            Container.this.mLastLoadedSupplementedResource = var1.supplementedResource;
                        } else {
                            var2 = var1.resource;
                            Container.this.mLastLoadedSupplementedResource.resource = var2;
                            Container.this.mLastLoadedSupplementedResource.supplemental = null;
                            Container.this.mLastLoadedSupplementedResource.fingerprint = var2.version;
                        }

                        Container.this.initEvaluators(var2);
                        if(Container.this.mLastLoadedSupplementedResource.supplemental != null) {
                            Container.this.setSupplementals(Container.this.mLastLoadedSupplementedResource.supplemental);
                        }

                        Log.method_5507("setting refresh time to saved time: " + var1.timeStamp);
                        Container.this.mLastRefreshTime = var1.timeStamp;
                        Container.this.loadAfterDelay(Math.max(0L, Math.min(43200000L, 43200000L + Container.this.mLastRefreshTime - var3.currentTimeMillis())));
                    }

                    Container.this.callRefreshSuccess(Container.RefreshType.SAVED);
                }

                public void startLoad() {
                    Container.this.callRefreshBegin(Container.RefreshType.SAVED);
                }
            };
            if(this.isDefaultContainerRefreshMode()) {
                Log.method_5505("Container is in DEFAULT_CONTAINER mode. Use default container.");
            } else {
                this.mResourceStorage.setLoadCallback(this.mDiskLoadCallback);
                this.mNetworkLoadCallback = new LoadCallback() {
                    private Container.RefreshFailure failureToRefreshFailure(LoadCallback.Failure var1) {
                        switch(null.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[var1.ordinal()]) {
                            case 1:
                                return Container.RefreshFailure.NO_NETWORK;
                            case 2:
                                return Container.RefreshFailure.NETWORK_ERROR;
                            case 3:
                                return Container.RefreshFailure.SERVER_ERROR;
                            default:
                                return Container.RefreshFailure.UNKNOWN_ERROR;
                        }
                    }

                    public void onFailure(LoadCallback.Failure var1) {
                        Container.this.loadAfterDelay(3600000L);
                        Container.this.callRefreshFailure(Container.RefreshType.NETWORK, this.failureToRefreshFailure(var1));
                    }

                    public void onSuccess(Serving.SupplementedResource param1) {
                        // $FF: Couldn't be decompiled
                    }

                    public void startLoad() {
                        Container.this.callRefreshBegin(Container.RefreshType.NETWORK);
                    }
                };
                var2.setLoadCallback(this.mNetworkLoadCallback);
                if(this.isContainerPreview()) {
                    this.mCtfeUrlPathAndQuery = PreviewManager.getInstance().getCTFEUrlPath();
                    var2.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
                }

                if(this.mCtfeServerAddress != null) {
                    this.mCtfeHost.setCtfeServerAddress(this.mCtfeServerAddress);
                }

                this.mNetworkLoadScheduler = var2;
                this.mResourceStorage.loadResourceFromDiskInBackground();
            }
        } finally {
            ;
        }

    }

    @VisibleForTesting
    void loadAfterDelay(long var1) {
        synchronized(this) {}

        try {
            if(this.mNetworkLoadScheduler != null && !this.isDefaultContainerRefreshMode()) {
                this.mNetworkLoadScheduler.loadAfterDelay(var1, this.mLastLoadedSupplementedResource.fingerprint);
            }
        } finally {
            ;
        }

    }

    public void refresh() {
        synchronized(this) {}

        try {
            if(this.getRuntime() == null) {
                Log.method_5509("refresh called for closed container");
            } else {
                try {
                    if(this.isDefaultContainerRefreshMode()) {
                        Log.method_5509("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
                    } else {
                        long var3 = this.mClock.currentTimeMillis();
                        if(this.useAvailableToken(var3)) {
                            Log.method_5507("Container refresh requested");
                            this.loadAfterDelay(0L);
                            this.mLastRefreshMethodCalledTime = var3;
                        } else {
                            Log.method_5507("Container refresh was called too often. Ignored.");
                        }
                    }
                } catch (Exception var7) {
                    Log.method_5503("Calling refresh() throws an exception: " + var7.getMessage());
                }
            }
        } finally {
            ;
        }

    }

    public void registerFunctionCallMacroHandler(String var1, Container.FunctionCallMacroHandler var2) {
        synchronized(this) {}

        try {
            this.mFunctionCallMacroHandlers.put(var1, var2);
        } finally {
            ;
        }

    }

    public void registerFunctionCallTagHandler(String var1, Container.FunctionCallTagHandler var2) {
        synchronized(this) {}

        try {
            this.mFunctionCallTagHandlers.put(var1, var2);
        } finally {
            ;
        }

    }

    @VisibleForTesting
    void setCtfeServerAddress(String param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    void setCtfeUrlPathAndQuery(String var1) {
        synchronized(this) {}

        try {
            this.mCtfeUrlPathAndQuery = var1;
            if(this.mNetworkLoadScheduler != null) {
                this.mNetworkLoadScheduler.setCtfeURLPathAndQuery(var1);
            }
        } finally {
            ;
        }

    }

    public interface Callback {
        void containerRefreshBegin(Container var1, Container.RefreshType var2);

        void containerRefreshFailure(Container var1, Container.RefreshType var2, Container.RefreshFailure var3);

        void containerRefreshSuccess(Container var1, Container.RefreshType var2);
    }

    public interface FunctionCallMacroHandler {
        Object getValue(String var1, Map<String, Object> var2);
    }

    private class FunctionCallMacroHandlerAdapter implements CustomFunctionCall.CustomEvaluator {
        private FunctionCallMacroHandlerAdapter() {
        }

        // $FF: synthetic method
        FunctionCallMacroHandlerAdapter(Object var2) {
            this();
        }

        public Object evaluate(String var1, Map<String, Object> var2) {
            Container.FunctionCallMacroHandler var3 = Container.this.getFunctionCallMacroHandler(var1);
            return var3 == null?null:var3.getValue(var1, var2);
        }
    }

    public interface FunctionCallTagHandler {
        void execute(String var1, Map<String, Object> var2);
    }

    private class FunctionCallTagHandlerAdapter implements CustomFunctionCall.CustomEvaluator {
        private FunctionCallTagHandlerAdapter() {
        }

        // $FF: synthetic method
        FunctionCallTagHandlerAdapter(Object var2) {
            this();
        }

        public Object evaluate(String var1, Map<String, Object> var2) {
            Container.this.getFunctionCallTagHandler(var1).execute(var1, var2);
            return Types.getDefaultString();
        }
    }

    public static enum RefreshFailure {
        IO_ERROR,
        NETWORK_ERROR,
        NO_NETWORK,
        NO_SAVED_CONTAINER,
        SERVER_ERROR,
        UNKNOWN_ERROR;

        static {
            Container.RefreshFailure[] var0 = new Container.RefreshFailure[]{NO_SAVED_CONTAINER, IO_ERROR, NO_NETWORK, NETWORK_ERROR, SERVER_ERROR, UNKNOWN_ERROR};
        }
    }

    public static enum RefreshType {
        NETWORK,
        SAVED;

        static {
            Container.RefreshType[] var0 = new Container.RefreshType[]{SAVED, NETWORK};
        }
    }

    interface ResourceLoaderScheduler {
        void close();

        void loadAfterDelay(long var1, String var3);

        void setCtfeURLPathAndQuery(String var1);

        void setLoadCallback(LoadCallback<Serving.SupplementedResource> var1);
    }

    interface ResourceStorage {
        void close();

        ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String var1);

        Serving.Resource loadResourceFromContainerAsset(String var1);

        void loadResourceFromDiskInBackground();

        void saveResourceToDiskInBackground(Resource.ResourceWithMetadata var1);

        void setLoadCallback(LoadCallback<Resource.ResourceWithMetadata> var1);
    }
}

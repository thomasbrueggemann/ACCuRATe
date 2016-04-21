package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CtfeHost;
import com.google.tagmanager.LoadCallback;
import com.google.tagmanager.Log;
import com.google.tagmanager.NetworkClient;
import com.google.tagmanager.NetworkClientFactory;
import com.google.tagmanager.PreviewManager;
import com.google.tagmanager.ResourceUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class ResourceLoader implements Runnable {
    private static final String CTFE_URL_PREFIX = "/r?id=";
    private static final String CTFE_URL_SUFFIX = "&v=a62676326";
    private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
    @VisibleForTesting
    static final String SDK_VERSION = "a62676326";
    private LoadCallback<Serving.SupplementedResource> mCallback;
    private final NetworkClientFactory mClientFactory;
    private final String mContainerId;
    private final Context mContext;
    private volatile CtfeHost mCtfeHost;
    private volatile String mCtfeUrlPathAndQuery;
    private final String mDefaultCtfeUrlPathAndQuery;
    private volatile String mPreviousVersion;

    public ResourceLoader(Context var1, String var2, CtfeHost var3) {
        this(var1, var2, new NetworkClientFactory(), var3);
    }

    @VisibleForTesting
    ResourceLoader(Context var1, String var2, NetworkClientFactory var3, CtfeHost var4) {
        this.mContext = var1;
        this.mClientFactory = var3;
        this.mContainerId = var2;
        this.mCtfeHost = var4;
        this.mDefaultCtfeUrlPathAndQuery = "/r?id=" + var2;
        this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
        this.mPreviousVersion = null;
    }

    private void loadResource() {
        if(!this.okToLoad()) {
            this.mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
        } else {
            Log.method_5507("Start loading resource from network ...");
            String var1 = this.getCtfeUrl();
            NetworkClient var2 = this.mClientFactory.createNetworkClient();

            try {
                InputStream var6;
                try {
                    var6 = var2.getInputStream(var1);
                } catch (FileNotFoundException var15) {
                    Log.method_5509("No data is retrieved from the given url: " + var1 + ". Make sure container_id: " + this.mContainerId + " is correct.");
                    this.mCallback.onFailure(LoadCallback.Failure.SERVER_ERROR);
                    return;
                } catch (IOException var16) {
                    Log.method_5510("Error when loading resources from url: " + var1 + " " + var16.getMessage(), var16);
                    this.mCallback.onFailure(LoadCallback.Failure.IO_ERROR);
                    return;
                }

                try {
                    ByteArrayOutputStream var7 = new ByteArrayOutputStream();
                    ResourceUtil.copyStream(var6, var7);
                    Serving.SupplementedResource var9 = Serving.SupplementedResource.parseFrom(var7.toByteArray());
                    Log.method_5507("Successfully loaded supplemented resource: " + var9);
                    if(var9.resource == null) {
                        Log.method_5507("No change for container: " + this.mContainerId);
                    }

                    this.mCallback.onSuccess(var9);
                } catch (IOException var14) {
                    Log.method_5510("Error when parsing downloaded resources from url: " + var1 + " " + var14.getMessage(), var14);
                    this.mCallback.onFailure(LoadCallback.Failure.SERVER_ERROR);
                    return;
                }
            } finally {
                var2.close();
            }

            Log.method_5507("Load resource from network finished.");
        }
    }

    private boolean okToLoad() {
        NetworkInfo var1 = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if(var1 != null && var1.isConnected()) {
            return true;
        } else {
            Log.method_5507("...no network connectivity");
            return false;
        }
    }

    @VisibleForTesting
    String getCtfeUrl() {
        String var1 = this.mCtfeHost.getCtfeServerAddress() + this.mCtfeUrlPathAndQuery + "&v=a62676326";
        if(this.mPreviousVersion != null && !this.mPreviousVersion.trim().equals("")) {
            var1 = var1 + "&pv=" + this.mPreviousVersion;
        }

        if(PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
            var1 = var1 + "&gtm_debug=x";
        }

        return var1;
    }

    public void run() {
        if(this.mCallback == null) {
            throw new IllegalStateException("callback must be set before execute");
        } else {
            this.mCallback.startLoad();
            this.loadResource();
        }
    }

    @VisibleForTesting
    void setCtfeURLPathAndQuery(String var1) {
        if(var1 == null) {
            this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
        } else {
            Log.method_5501("Setting CTFE URL path: " + var1);
            this.mCtfeUrlPathAndQuery = var1;
        }
    }

    void setLoadCallback(LoadCallback<Serving.SupplementedResource> var1) {
        this.mCallback = var1;
    }

    @VisibleForTesting
    void setPreviousVersion(String var1) {
        Log.method_5501("Setting previous container version: " + var1);
        this.mPreviousVersion = var1;
    }
}

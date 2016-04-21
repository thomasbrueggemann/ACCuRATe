package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Container;
import com.google.tagmanager.JsonUtils;
import com.google.tagmanager.LoadCallback;
import com.google.tagmanager.Log;
import com.google.tagmanager.PreviewManager;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.proto.Resource;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class ResourceStorageImpl implements Container.ResourceStorage {
    private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
    private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
    private LoadCallback<Resource.ResourceWithMetadata> mCallback;
    private final String mContainerId;
    private final Context mContext;
    private final ExecutorService mExecutor;

    ResourceStorageImpl(Context var1, String var2) {
        this.mContext = var1;
        this.mContainerId = var2;
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    private String stringFromInputStream(InputStream var1) throws IOException {
        StringWriter var2 = new StringWriter();
        char[] var3 = new char[1024];
        BufferedReader var4 = new BufferedReader(new InputStreamReader(var1, "UTF-8"));

        while(true) {
            int var5 = var4.read(var3);
            if(var5 == -1) {
                return var2.toString();
            }

            var2.write(var3, 0, var5);
        }
    }

    public void close() {
        synchronized(this) {}

        try {
            this.mExecutor.shutdown();
        } finally {
            ;
        }

    }

    @VisibleForTesting
    File getResourceFile() {
        String var1 = "resource_" + this.mContainerId;
        return new File(this.mContext.getDir("google_tagmanager", 0), var1);
    }

    public ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String var1) {
        ResourceUtil.ExpandedResource var2 = null;
        Log.method_5507("loading default container from " + var1);
        AssetManager var3 = this.mContext.getAssets();
        if(var3 == null) {
            Log.method_5509("Looking for default JSON container in package, but no assets were found.");
        } else {
            InputStream var4 = null;
            boolean var20 = false;

            ResourceUtil.ExpandedResource var11;
            label123: {
                label124: {
                    try {
                        var20 = true;
                        var4 = var3.open(var1);
                        var11 = JsonUtils.expandedResourceFromJsonString(this.stringFromInputStream(var4));
                        var20 = false;
                        break label123;
                    } catch (IOException var25) {
                        Log.method_5509("No asset file: " + var1 + " found (or errors reading it).");
                        var20 = false;
                        break label124;
                    } catch (JSONException var26) {
                        Log.method_5509("Error parsing JSON file" + var1 + " : " + var26);
                        var20 = false;
                    } finally {
                        if(var20) {
                            if(var4 != null) {
                                try {
                                    var4.close();
                                } catch (IOException var22) {
                                    ;
                                }
                            }

                        }
                    }

                    var2 = null;
                    if(var4 != null) {
                        try {
                            var4.close();
                            return null;
                        } catch (IOException var21) {
                            return null;
                        }
                    }

                    return var2;
                }

                var2 = null;
                if(var4 != null) {
                    try {
                        var4.close();
                        return null;
                    } catch (IOException var23) {
                        return null;
                    }
                }

                return var2;
            }

            var2 = var11;
            if(var4 != null) {
                try {
                    var4.close();
                    return var2;
                } catch (IOException var24) {
                    return var11;
                }
            }
        }

        return var2;
    }

    public Serving.Resource loadResourceFromContainerAsset(String var1) {
        Log.method_5507("Loading default container from " + var1);
        AssetManager var2 = this.mContext.getAssets();
        if(var2 == null) {
            Log.method_5503("No assets found in package");
            return null;
        } else {
            InputStream var4;
            try {
                var4 = var2.open(var1);
            } catch (IOException var19) {
                Log.method_5509("No asset file: " + var1 + " found.");
                return null;
            }

            try {
                ByteArrayOutputStream var5 = new ByteArrayOutputStream();
                ResourceUtil.copyStream(var4, var5);
                Serving.Resource var10 = Serving.Resource.parseFrom(var5.toByteArray());
                Log.method_5507("Parsed default container: " + var10);
                return var10;
            } catch (IOException var20) {
                Log.method_5509("Error when parsing: " + var1);
            } finally {
                try {
                    var4.close();
                } catch (IOException var18) {
                    ;
                }

            }

            return null;
        }
    }

    @VisibleForTesting
    void loadResourceFromDisk() {
        if(this.mCallback == null) {
            throw new IllegalStateException("callback must be set before execute");
        } else {
            this.mCallback.startLoad();
            Log.method_5507("Start loading resource from disk ...");
            if((PreviewManager.getInstance().getPreviewMode() == PreviewManager.PreviewMode.CONTAINER || PreviewManager.getInstance().getPreviewMode() == PreviewManager.PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(PreviewManager.getInstance().getContainerId())) {
                this.mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
            } else {
                FileInputStream var1;
                try {
                    var1 = new FileInputStream(this.getResourceFile());
                } catch (FileNotFoundException var18) {
                    Log.method_5501("resource not on disk");
                    this.mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
                    return;
                }

                try {
                    ByteArrayOutputStream var2 = new ByteArrayOutputStream();
                    ResourceUtil.copyStream(var1, var2);
                    this.mCallback.onSuccess(Resource.ResourceWithMetadata.parseFrom(var2.toByteArray()));
                } catch (IOException var16) {
                    Log.method_5509("error reading resource from disk");
                    this.mCallback.onFailure(LoadCallback.Failure.IO_ERROR);
                } finally {
                    try {
                        var1.close();
                    } catch (IOException var15) {
                        Log.method_5509("error closing stream for reading resource from disk");
                    }

                }

                Log.method_5507("Load resource from disk finished.");
            }
        }
    }

    public void loadResourceFromDiskInBackground() {
        this.mExecutor.execute(new Runnable() {
            public void run() {
                ResourceStorageImpl.this.loadResourceFromDisk();
            }
        });
    }

    @VisibleForTesting
    boolean saveResourceToDisk(Resource.ResourceWithMetadata var1) {
        File var2 = this.getResourceFile();

        FileOutputStream var3;
        try {
            var3 = new FileOutputStream(var2);
        } catch (FileNotFoundException var18) {
            Log.method_5503("Error opening resource file for writing");
            return false;
        }

        try {
            var3.write(MessageNano.toByteArray(var1));
            return true;
        } catch (IOException var19) {
            Log.method_5509("Error writing resource to disk. Removing resource from disk.");
            var2.delete();
        } finally {
            try {
                var3.close();
            } catch (IOException var17) {
                Log.method_5509("error closing stream for writing resource to disk");
            }

        }

        return false;
    }

    public void saveResourceToDiskInBackground(final Resource.ResourceWithMetadata var1) {
        this.mExecutor.execute(new Runnable() {
            public void run() {
                ResourceStorageImpl.this.saveResourceToDisk(var1);
            }
        });
    }

    public void setLoadCallback(LoadCallback<Resource.ResourceWithMetadata> var1) {
        this.mCallback = var1;
    }
}

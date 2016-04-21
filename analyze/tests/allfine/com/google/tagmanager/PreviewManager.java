package com.google.tagmanager;

import android.net.Uri;

class PreviewManager {
    static final String BASE_DEBUG_QUERY = "&gtm_debug=x";
    private static final String CONTAINER_BASE_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&";
    private static final String CONTAINER_DEBUG_STRING_PATTERN = ".*?&gtm_debug=x$";
    private static final String CONTAINER_PREVIEW_EXIT_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$";
    private static final String CONTAINER_PREVIEW_URL_PATTERN = "^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$";
    static final String CTFE_URL_PATH_PREFIX = "/r?";
    private static PreviewManager sInstance;
    private volatile String mCTFEUrlPath;
    private volatile String mCTFEUrlQuery;
    private volatile String mContainerId;
    private volatile PreviewManager.PreviewMode mPreviewMode;

    PreviewManager() {
        this.clear();
    }

    private String getContainerId(String var1) {
        return var1.split("&")[0].split("=")[1];
    }

    static PreviewManager getInstance() {
        // $FF: Couldn't be decompiled
    }

    private String getQueryWithoutDebugParameter(Uri var1) {
        return var1.getQuery().replace("&gtm_debug=x", "");
    }

    void clear() {
        this.mPreviewMode = PreviewManager.PreviewMode.NONE;
        this.mCTFEUrlPath = null;
        this.mContainerId = null;
        this.mCTFEUrlQuery = null;
    }

    String getCTFEUrlDebugQuery() {
        return this.mCTFEUrlQuery;
    }

    String getCTFEUrlPath() {
        return this.mCTFEUrlPath;
    }

    String getContainerId() {
        return this.mContainerId;
    }

    PreviewManager.PreviewMode getPreviewMode() {
        return this.mPreviewMode;
    }

    boolean setPreviewData(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    static enum PreviewMode {
        CONTAINER,
        CONTAINER_DEBUG,
        NONE;

        static {
            PreviewManager.PreviewMode[] var0 = new PreviewManager.PreviewMode[]{NONE, CONTAINER, CONTAINER_DEBUG};
        }
    }
}

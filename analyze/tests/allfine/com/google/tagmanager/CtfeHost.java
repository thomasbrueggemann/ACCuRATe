package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Log;
import com.google.tagmanager.PreviewManager;

class CtfeHost {
    private static final String CTFE_SERVER_ADDRESS = "https://www.googletagmanager.com";
    @VisibleForTesting
    static final String CTFE_URL_PATH_PREFIX = "/d?";
    static final String DEBUG_EVENT_NUMBER_QUERY = "&event_number=";
    private String mCtfeServerAddress = "https://www.googletagmanager.com";

    String constructCtfeDebugUrl(int var1) {
        return this.mCtfeServerAddress + "/d?" + PreviewManager.getInstance().getCTFEUrlDebugQuery() + "&event_number=" + var1;
    }

    public String getCtfeServerAddress() {
        return this.mCtfeServerAddress;
    }

    public void setCtfeServerAddress(String var1) {
        this.mCtfeServerAddress = var1;
        Log.method_5505("The Ctfe server endpoint was changed to: " + var1);
    }
}

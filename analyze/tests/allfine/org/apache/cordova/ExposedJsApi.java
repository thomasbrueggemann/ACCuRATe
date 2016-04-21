package org.apache.cordova;

import android.webkit.JavascriptInterface;
import org.apache.cordova.CordovaBridge;
import org.json.JSONException;

class ExposedJsApi {
    private CordovaBridge bridge;

    public ExposedJsApi(CordovaBridge var1) {
        this.bridge = var1;
    }

    @JavascriptInterface
    public String exec(int var1, String var2, String var3, String var4, String var5) throws JSONException, IllegalAccessException {
        return this.bridge.jsExec(var1, var2, var3, var4, var5);
    }

    @JavascriptInterface
    public String retrieveJsMessages(int var1, boolean var2) throws IllegalAccessException {
        return this.bridge.jsRetrieveJsMessages(var1, var2);
    }

    @JavascriptInterface
    public void setNativeToJsBridgeMode(int var1, int var2) throws IllegalAccessException {
        this.bridge.jsSetNativeToJsBridgeMode(var1, var2);
    }
}

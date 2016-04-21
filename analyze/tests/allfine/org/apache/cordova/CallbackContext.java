package org.apache.cordova;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class CallbackContext {
    private static final String LOG_TAG = "CordovaPlugin";
    private String callbackId;
    private int changingThreads;
    private boolean finished;
    private CordovaWebView webView;

    public CallbackContext(String var1, CordovaWebView var2) {
        this.callbackId = var1;
        this.webView = var2;
    }

    public void error(int var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, var1));
    }

    public void error(String var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, var1));
    }

    public void error(JSONObject var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, var1));
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public boolean isChangingThreads() {
        return this.changingThreads > 0;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void sendPluginResult(PluginResult param1) {
        // $FF: Couldn't be decompiled
    }

    public void success() {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155));
    }

    public void success(int var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var1));
    }

    public void success(String var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var1));
    }

    public void success(JSONArray var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var1));
    }

    public void success(JSONObject var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var1));
    }

    public void success(byte[] var1) {
        this.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var1));
    }
}

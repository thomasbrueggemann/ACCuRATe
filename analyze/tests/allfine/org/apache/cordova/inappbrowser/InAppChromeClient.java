package org.apache.cordova.inappbrowser;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebStorage.QuotaUpdater;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class InAppChromeClient extends WebChromeClient {
    private String LOG_TAG = "InAppChromeClient";
    private long MAX_QUOTA = 104857600L;
    private CordovaWebView webView;

    public InAppChromeClient(CordovaWebView var1) {
        this.webView = var1;
    }

    public void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
        String var10 = this.LOG_TAG;
        Object[] var11 = new Object[] {Long.valueOf(var5), Long.valueOf(var3), Long.valueOf(var7)};
        LOG.method_4281(var10, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", var11);
        var9.updateQuota(this.MAX_QUOTA);
    }

    public void onGeolocationPermissionsShowPrompt(String var1, Callback var2) {
        super.onGeolocationPermissionsShowPrompt(var1, var2);
        var2.invoke(var1, true, false);
    }

    public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
        if(var4 != null && var4.startsWith("gap")) {
            if(!var4.startsWith("gap-iab://")) {
                LOG.method_4291(this.LOG_TAG, "InAppBrowser does not support Cordova API calls: " + var2 + " " + var4);
                var5.cancel();
                return true;
            }

            String var6 = var4.substring(10);
            if(var6.startsWith("InAppBrowser")) {
                PluginResult var7;
                if(var3 != null && var3.length() != 0) {
                    try {
                        var7 = new PluginResult(PluginResult.Status.field_2155, new JSONArray(var3));
                    } catch (JSONException var9) {
                        var7 = new PluginResult(PluginResult.Status.JSON_EXCEPTION, var9.getMessage());
                    }
                } else {
                    var7 = new PluginResult(PluginResult.Status.field_2155, new JSONArray());
                }

                this.webView.sendPluginResult(var7, var6);
                var5.confirm("");
                return true;
            }
        }

        return false;
    }
}

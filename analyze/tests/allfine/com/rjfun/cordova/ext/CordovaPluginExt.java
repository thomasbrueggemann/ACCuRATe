package com.rjfun.cordova.ext;

import android.app.Activity;
import android.view.View;
import com.rjfun.cordova.ext.PluginAdapterDelegate;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class CordovaPluginExt extends CordovaPlugin implements PluginAdapterDelegate {
    protected PluginAdapterDelegate adapter = null;

    public void fireEvent(String var1, String var2, String var3) {
        if(this.adapter != null) {
            this.adapter.fireEvent(var1, var2, var3);
        } else {
            String var5;
            if("window".equals(var1)) {
                var5 = "var evt=document.createEvent(\'UIEvents\');evt.initUIEvent(\'" + var2 + "\',true,false,window,0);window.dispatchEvent(evt);";
            } else {
                String var4 = "javascript:cordova.fireDocumentEvent(\'" + var2 + "\'";
                if(var3 != null) {
                    var4 = var4 + "," + var3;
                }

                var5 = var4 + ");";
            }

            this.webView.loadUrl(var5);
        }
    }

    public Activity getActivity() {
        return this.adapter != null?this.adapter.getActivity():this.cordova.getActivity();
    }

    public PluginAdapterDelegate getAdapter() {
        return this.adapter;
    }

    public View getView() {
        // $FF: Couldn't be decompiled
    }

    public void sendPluginResult(PluginResult var1, CallbackContext var2) {
        if(this.adapter != null) {
            this.adapter.sendPluginResult(var1, var2);
        } else {
            var2.sendPluginResult(var1);
        }
    }

    public void setAdapter(PluginAdapterDelegate var1) {
        this.adapter = var1;
    }
}

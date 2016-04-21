package com.rjfun.cordova.ext;

import android.app.Activity;
import android.view.View;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public interface PluginAdapterDelegate {
    void fireEvent(String var1, String var2, String var3);

    Activity getActivity();

    View getView();

    void sendPluginResult(PluginResult var1, CallbackContext var2);
}

package org.apache.cordova.statusbar;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Window;
import java.lang.reflect.Method;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

public class StatusBar extends CordovaPlugin {
    private static final String TAG = "StatusBar";

    private void setStatusBarBackgroundColor(String var1) {
        if(VERSION.SDK_INT >= 21 && var1 != null && !var1.isEmpty()) {
            Window var2 = this.cordova.getActivity().getWindow();
            var2.clearFlags(67108864);
            var2.addFlags(Integer.MIN_VALUE);

            try {
                Class var7 = var2.getClass();
                Class[] var8 = new Class[] {Integer.TYPE};
                Method var9 = var7.getDeclaredMethod("setStatusBarColor", var8);
                Object[] var10 = new Object[] {Integer.valueOf(Color.parseColor(var1))};
                var9.invoke(var2, var10);
            } catch (IllegalArgumentException var11) {
                Log.e("StatusBar", "Invalid hexString argument, use f.i. \'#999999\'");
                return;
            } catch (Exception var12) {
                Log.w("StatusBar", "Method window.setStatusBarColor not found for SDK level " + VERSION.SDK_INT);
                return;
            }
        }

    }

    public boolean execute(String var1, final CordovaArgs var2, CallbackContext var3) throws JSONException {
        Log.v("StatusBar", "Executing action: " + var1);
        final Window var5 = this.cordova.getActivity().getWindow();
        if("_ready".equals(var1)) {
            boolean var6;
            if((1024 & var5.getAttributes().flags) == 0) {
                var6 = true;
            } else {
                var6 = false;
            }

            var3.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var6));
        }

        if("show".equals(var1)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    var5.clearFlags(1024);
                }
            });
            return true;
        } else if("hide".equals(var1)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    var5.addFlags(1024);
                }
            });
            return true;
        } else if("backgroundColorByHexString".equals(var1)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        StatusBar.this.setStatusBarBackgroundColor(var2.getString(0));
                    } catch (JSONException var2x) {
                        Log.e("StatusBar", "Invalid hexString argument, use f.i. \'#777777\'");
                    }
                }
            });
            return true;
        } else {
            return false;
        }
    }

    public void initialize(final CordovaInterface var1, CordovaWebView var2) {
        Log.v("StatusBar", "StatusBar: initialization");
        super.initialize(var1, var2);
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                var1.getActivity().getWindow().clearFlags(2048);
                StatusBar.this.setStatusBarBackgroundColor(StatusBar.this.preferences.getString("StatusBarBackgroundColor", "#000000"));
            }
        });
    }
}

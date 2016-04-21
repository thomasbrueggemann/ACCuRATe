package org.apache.cordova.networkinformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkManager extends CordovaPlugin {
    public static final String CDMA = "cdma";
    public static final String CELLULAR = "cellular";
    public static final String EDGE = "edge";
    public static final String EHRPD = "ehrpd";
    public static final String GPRS = "gprs";
    public static final String GSM = "gsm";
    public static final String HSDPA = "hsdpa";
    public static final String HSPA = "hspa";
    public static final String HSPA_PLUS = "hspa+";
    public static final String HSUPA = "hsupa";
    private static final String LOG_TAG = "NetworkManager";
    public static final String LTE = "lte";
    public static final String MOBILE = "mobile";
    public static int NOT_REACHABLE = 0;
    public static final String ONEXRTT = "1xrtt";
    public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
    public static int REACHABLE_VIA_WIFI_NETWORK = 2;
    public static final String TYPE_2G = "2g";
    public static final String TYPE_3G = "3g";
    public static final String TYPE_4G = "4g";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String UMB = "umb";
    public static final String UMTS = "umts";
    public static final String WIFI = "wifi";
    public static final String WIMAX = "wimax";
    private CallbackContext connectionCallbackContext;
    private JSONObject lastInfo = null;
    BroadcastReceiver receiver;
    ConnectivityManager sockMan;

    private JSONObject getConnectionInfo(NetworkInfo var1) {
        String var2 = "none";
        String var3 = "";
        if(var1 != null) {
            if(!var1.isConnected()) {
                var2 = "none";
            } else {
                var2 = this.getType(var1);
            }

            var3 = var1.getExtraInfo();
        }

        Log.d("CordovaNetworkManager", "Connection Type: " + var2);
        Log.d("CordovaNetworkManager", "Connection Extra Info: " + var3);
        JSONObject var6 = new JSONObject();

        try {
            var6.put("type", var2);
            var6.put("extraInfo", var3);
            return var6;
        } catch (JSONException var8) {
            return var6;
        }
    }

    private String getType(NetworkInfo var1) {
        if(var1 != null) {
            String var2 = var1.getTypeName();
            if(var2.toLowerCase().equals("wifi")) {
                return "wifi";
            } else {
                if(var2.toLowerCase().equals("mobile") || var2.toLowerCase().equals("cellular")) {
                    String var3 = var1.getSubtypeName();
                    if(var3.toLowerCase().equals("gsm") || var3.toLowerCase().equals("gprs") || var3.toLowerCase().equals("edge")) {
                        return "2g";
                    }

                    if(var3.toLowerCase().startsWith("cdma") || var3.toLowerCase().equals("umts") || var3.toLowerCase().equals("1xrtt") || var3.toLowerCase().equals("ehrpd") || var3.toLowerCase().equals("hsupa") || var3.toLowerCase().equals("hsdpa") || var3.toLowerCase().equals("hspa")) {
                        return "3g";
                    }

                    if(var3.toLowerCase().equals("lte") || var3.toLowerCase().equals("umb") || var3.toLowerCase().equals("hspa+")) {
                        return "4g";
                    }
                }

                return "unknown";
            }
        } else {
            return "none";
        }
    }

    private void sendUpdate(String var1) {
        if(this.connectionCallbackContext != null) {
            PluginResult var2 = new PluginResult(PluginResult.Status.field_2155, var1);
            var2.setKeepCallback(true);
            this.connectionCallbackContext.sendPluginResult(var2);
        }

        this.webView.postMessage("networkconnection", var1);
    }

    private void updateConnectionInfo(NetworkInfo var1) {
        JSONObject var2 = this.getConnectionInfo(var1);
        if(!var2.equals(this.lastInfo)) {
            String var3 = "";

            label15: {
                String var5;
                try {
                    var5 = var2.get("type").toString();
                } catch (JSONException var6) {
                    break label15;
                }

                var3 = var5;
            }

            this.sendUpdate(var3);
            this.lastInfo = var2;
        }

    }

    public boolean execute(String var1, JSONArray var2, CallbackContext var3) {
        if(var1.equals("getConnectionInfo")) {
            this.connectionCallbackContext = var3;
            NetworkInfo var4 = this.sockMan.getActiveNetworkInfo();
            String var5 = "";

            label15: {
                String var8;
                try {
                    var8 = this.getConnectionInfo(var4).get("type").toString();
                } catch (JSONException var9) {
                    break label15;
                }

                var5 = var8;
            }

            PluginResult var7 = new PluginResult(PluginResult.Status.field_2155, var5);
            var7.setKeepCallback(true);
            var3.sendPluginResult(var7);
            return true;
        } else {
            return false;
        }
    }

    public void initialize(CordovaInterface var1, CordovaWebView var2) {
        super.initialize(var1, var2);
        this.sockMan = (ConnectivityManager)var1.getActivity().getSystemService("connectivity");
        this.connectionCallbackContext = null;
        IntentFilter var3 = new IntentFilter();
        var3.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if(this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(Context var1, Intent var2) {
                    if(NetworkManager.this.webView != null) {
                        NetworkManager.this.updateConnectionInfo(NetworkManager.this.sockMan.getActiveNetworkInfo());
                    }

                }
            };
            var2.getContext().registerReceiver(this.receiver, var3);
        }

    }

    public void onDestroy() {
        if(this.receiver != null) {
            try {
                this.webView.getContext().unregisterReceiver(this.receiver);
            } catch (Exception var5) {
                Log.e("NetworkManager", "Error unregistering network receiver: " + var5.getMessage(), var5);
            } finally {
                this.receiver = null;
            }
        }

    }
}

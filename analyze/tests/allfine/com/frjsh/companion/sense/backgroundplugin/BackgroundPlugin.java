package com.frjsh.companion.sense.backgroundplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.frjsh.companion.sense.backgroundplugin.BackgroundService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class BackgroundPlugin extends CordovaPlugin {
    public static final String ACTION_ADD_LOGBOOKENTRY = "addLogbookEntry";
    public static final String ACTION_ADD_NMEAENTRY = "addNMEAEntry";
    public static final String ACTION_CONFIGURE = "configure";
    public static final String ACTION_FORCE_RECORD_AND_SEND_POSITION = "forceRecordAndSend";
    public static final String ACTION_GET_ANCHORWATCH_STATUS = "getAnchorWatchStatus";
    public static final String ACTION_START = "start";
    public static final String ACTION_START_ANCHORALARM = "startAnchorAlarm";
    public static final String ACTION_START_ANCHORWATCH = "startAnchorWatch";
    public static final String ACTION_STOP = "stop";
    public static final String ACTION_STOP_ANCHORALARM = "stopAnchorAlarm";
    public static final String ACTION_STOP_ANCHORWATCH = "stopAnchorWatch";
    private static final String TAG = "BackgroundPlugin";
    private CallbackContext anchorWatchStatusCallbackContext;
    private CallbackContext callbackContext;
    private String desiredAccuracy = "100";
    private String desiredPowerRequirement = "3";
    private String distanceFilter = "30";
    private String isDebugging = "false";
    private Boolean isEnabled = Boolean.valueOf(false);
    private String locationTimeout = "60";
    private boolean mBindingInProgress = false;
    private boolean mBound = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName param1, IBinder param2) {
            // $FF: Couldn't be decompiled
        }

        public void onServiceDisconnected(ComponentName var1) {
            Log.d("BackgroundPlugin", "onServiceDisconnected: " + var1);
            BackgroundPlugin.this.mBindingInProgress = false;
            BackgroundPlugin.this.mService = null;
            BackgroundPlugin.this.mBound = false;
        }
    };
    private final Messenger mMessenger = new Messenger(new BackgroundPlugin.IncomingHandler());
    private Messenger mService = null;
    private Message messageToBeSentAfterBinding = null;
    private String params;
    private BackgroundPlugin.PhoneGapNotificationReceiver phoneGapNotificationReceiver = null;
    private String recordingInterval = "5";
    private String sendingInterval = "5";
    private String stationaryRadius = "30";
    private String unitId;
    private Intent updateServiceIntent;
    private String url;

    // $FF: synthetic method
    static Messenger access$100(BackgroundPlugin var0) {
        return var0.mService;
    }

    // $FF: synthetic method
    static Message access$300(BackgroundPlugin var0) {
        return var0.messageToBeSentAfterBinding;
    }

    // $FF: synthetic method
    static Message access$302(BackgroundPlugin var0, Message var1) {
        var0.messageToBeSentAfterBinding = var1;
        return var1;
    }

    // $FF: synthetic method
    static CallbackContext access$400(BackgroundPlugin var0) {
        return var0.anchorWatchStatusCallbackContext;
    }

    // $FF: synthetic method
    static CallbackContext access$402(BackgroundPlugin var0, CallbackContext var1) {
        var0.anchorWatchStatusCallbackContext = var1;
        return var1;
    }

    public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
        Activity var4 = this.cordova.getActivity();
        Log.d("BackgroundPlugin", "action: " + var1);
        if(this.phoneGapNotificationReceiver == null) {
            this.phoneGapNotificationReceiver = new BackgroundPlugin.PhoneGapNotificationReceiver();
            var4.registerReceiver(this.phoneGapNotificationReceiver, new IntentFilter("SendNotificationToPhoneGap"));
        }

        Boolean.valueOf(false);
        this.updateServiceIntent = new Intent(var4, BackgroundService.class);
        if("start".equalsIgnoreCase(var1) && !this.isEnabled.booleanValue()) {
            Boolean.valueOf(true);
            if(this.params != null && this.url != null) {
                this.updateServiceIntent.putExtra("url", this.url);
                this.updateServiceIntent.putExtra("unitId", this.unitId);
                this.updateServiceIntent.putExtra("params", this.params);
                this.updateServiceIntent.putExtra("stationaryRadius", this.stationaryRadius);
                this.updateServiceIntent.putExtra("desiredAccuracy", this.desiredAccuracy);
                this.updateServiceIntent.putExtra("desiredPowerRequirement", this.desiredPowerRequirement);
                this.updateServiceIntent.putExtra("distanceFilter", this.distanceFilter);
                this.updateServiceIntent.putExtra("locationTimeout", this.locationTimeout);
                this.updateServiceIntent.putExtra("desiredAccuracy", this.desiredAccuracy);
                this.updateServiceIntent.putExtra("isDebugging", this.isDebugging);
                this.updateServiceIntent.putExtra("recordingInterval", this.recordingInterval);
                this.updateServiceIntent.putExtra("sendingInterval", this.sendingInterval);
                var4.startService(this.updateServiceIntent);
                this.isEnabled = Boolean.valueOf(true);
                PluginResult var96 = new PluginResult(PluginResult.Status.NO_RESULT);
                var96.setKeepCallback(true);
                var3.sendPluginResult(var96);
                this.callbackContext = var3;
                return true;
            }

            var3.error("Call configure before calling start");
        } else {
            if("stop".equalsIgnoreCase(var1)) {
                this.isEnabled = Boolean.valueOf(false);
                Boolean.valueOf(true);
                var4.stopService(this.updateServiceIntent);
                var3.success();
                return true;
            }

            if("startAnchorWatch".equalsIgnoreCase(var1)) {
                Boolean.valueOf(true);
                if(this.params != null && this.url != null) {
                    float var54 = 25.0F;

                    float var57;
                    label172: {
                        double var78;
                        try {
                            var78 = var2.getDouble(0);
                        } catch (Exception var109) {
                            Log.e("BackgroundPlugin", "" + var109, var109);
                            var57 = 0.0F;
                            break label172;
                        }

                        var57 = (float)var78;
                    }

                    float var60;
                    label168: {
                        double var76;
                        try {
                            var76 = var2.getDouble(1);
                        } catch (Exception var108) {
                            Log.e("BackgroundPlugin", "" + var108, var108);
                            var60 = 0.0F;
                            break label168;
                        }

                        var60 = (float)var76;
                    }

                    float var63;
                    label164: {
                        double var74;
                        try {
                            var74 = var2.getDouble(2);
                        } catch (Exception var107) {
                            Log.e("BackgroundPlugin", "" + var107, var107);
                            var63 = 0.0F;
                            break label164;
                        }

                        var63 = (float)var74;
                    }

                    label160: {
                        double var72;
                        try {
                            var72 = var2.getDouble(3);
                        } catch (Exception var106) {
                            Log.e("BackgroundPlugin", "" + var106, var106);
                            break label160;
                        }

                        var54 = (float)var72;
                    }

                    Bundle var66 = new Bundle();
                    var66.putFloat("lat", var57);
                    var66.putFloat("lng", var60);
                    var66.putFloat("accuracy", var63);
                    var66.putFloat("radius", var54);
                    Message var67 = Message.obtain((Handler)null, 9341);
                    var67.setData(var66);
                    if(!this.mBound && !this.mBindingInProgress) {
                        this.messageToBeSentAfterBinding = var67;
                        this.mBindingInProgress = true;
                        var4.bindService(new Intent(var4, BackgroundService.class), this.mConnection, 1);
                        Log.d("BackgroundPlugin", "binding in progress: " + var1);
                    } else if(this.mBound) {
                        try {
                            this.mService.send(var67);
                        } catch (RemoteException var97) {
                            Log.e("BackgroundPlugin", "" + var97, var97);
                        }
                    }

                    var3.success();
                    return true;
                }

                var3.error("Call configure before calling start");
            } else {
                if("stopAnchorWatch".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    if(this.mBound) {
                        Message var50 = Message.obtain((Handler)null, 9342);

                        try {
                            this.mService.send(var50);
                        } catch (RemoteException var98) {
                            Log.e("BackgroundPlugin", "" + var98, var98);
                        }

                        var4.unbindService(this.mConnection);
                        this.mBound = false;
                    }

                    var3.success();
                    return true;
                }

                if("getAnchorWatchStatus".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    if(!this.mBound) {
                        PluginResult var45 = new PluginResult(PluginResult.Status.field_2155, "{ \"active\": false }");
                        var45.setKeepCallback(false);
                        var3.sendPluginResult(var45);
                    } else if(this.mBound) {
                        try {
                            Message var48 = Message.obtain((Handler)null, 9345);
                            var48.replyTo = this.mMessenger;
                            this.mService.send(var48);
                            this.anchorWatchStatusCallbackContext = var3;
                        } catch (RemoteException var99) {
                            Log.e("BackgroundPlugin", "" + var99, var99);
                        }
                    }

                    return true;
                }

                if("startAnchorAlarm".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    Log.d("BackgroundPlugin", "building message");
                    Message var33 = Message.obtain((Handler)null, 9343);
                    Log.d("BackgroundPlugin", "checking service availability");
                    if(!this.mBound && !this.mBindingInProgress) {
                        Log.d("BackgroundPlugin", "not bound, preparing service");
                        this.messageToBeSentAfterBinding = var33;
                        this.mBindingInProgress = true;
                        var4.bindService(new Intent(var4, BackgroundService.class), this.mConnection, 1);
                        Log.d("BackgroundPlugin", "binding in progress: " + var1);
                    } else if(this.mBound) {
                        try {
                            Log.d("BackgroundPlugin", "bound, sending now");
                            this.mService.send(var33);
                            Log.d("BackgroundPlugin", "sent!");
                        } catch (RemoteException var100) {
                            Log.e("BackgroundPlugin", "" + var100, var100);
                        }
                    } else {
                        Log.d("BackgroundPlugin", "bound: " + this.mBound + " binding in progress: " + this.mBindingInProgress + " service: " + this.mService);
                    }

                    Log.d("BackgroundPlugin", "finishing call");
                    var3.success();
                    return true;
                }

                if("stopAnchorAlarm".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    if(this.mBound) {
                        Message var28 = Message.obtain((Handler)null, 9344);

                        try {
                            this.mService.send(var28);
                        } catch (RemoteException var101) {
                            Log.e("BackgroundPlugin", "" + var101, var101);
                        }
                    }

                    var3.success();
                    return true;
                }

                if("addLogbookEntry".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    Bundle var21 = new Bundle();
                    var21.putString("json", var2.getString(0));

                    try {
                        var21.putBoolean("forceSendNow", var2.getBoolean(1));
                    } catch (Exception var103) {
                        var21.putBoolean("forceSendNow", false);
                    }

                    Message var23 = Message.obtain((Handler)null, 9346);
                    var23.setData(var21);
                    if(!this.mBound && !this.mBindingInProgress) {
                        this.messageToBeSentAfterBinding = var23;
                        this.mBindingInProgress = true;
                        var4.bindService(new Intent(var4, BackgroundService.class), this.mConnection, 1);
                    } else if(this.mBound) {
                        try {
                            this.mService.send(var23);
                        } catch (RemoteException var102) {
                            Log.e("BackgroundPlugin", "" + var102, var102);
                        }
                    }

                    var3.success();
                    return true;
                }

                if("addNMEAEntry".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    Bundle var15 = new Bundle();
                    var15.putString("json", var2.getString(0));
                    Message var16 = Message.obtain((Handler)null, 9347);
                    var16.setData(var15);
                    if(!this.mBound && !this.mBindingInProgress) {
                        this.messageToBeSentAfterBinding = var16;
                        this.mBindingInProgress = true;
                        var4.bindService(new Intent(var4, BackgroundService.class), this.mConnection, 1);
                    } else if(this.mBound) {
                        try {
                            this.mService.send(var16);
                        } catch (RemoteException var104) {
                            Log.e("BackgroundPlugin", "" + var104, var104);
                        }
                    }

                    var3.success();
                    return true;
                }

                if("configure".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);

                    try {
                        this.params = var2.getString(0);
                        this.url = var2.getString(1);
                        this.unitId = var2.getString(2);
                        this.stationaryRadius = var2.getString(3);
                        this.distanceFilter = var2.getString(4);
                        this.locationTimeout = var2.getString(5);
                        this.desiredAccuracy = var2.getString(6);
                        this.desiredPowerRequirement = var2.getString(7);
                        this.isDebugging = var2.getString(8);
                        this.recordingInterval = var2.getString(9);
                        this.sendingInterval = var2.getString(10);
                        var3.success();
                        return true;
                    } catch (Exception var110) {
                        Log.e("BackgroundPlugin", "" + var110, var110);
                        var3.error("config error: " + var110.getMessage());
                    }
                } else if("forceRecordAndSend".equalsIgnoreCase(var1)) {
                    Boolean.valueOf(true);
                    if(this.mBound) {
                        Message var8 = Message.obtain((Handler)null, 9348);

                        try {
                            this.mService.send(var8);
                        } catch (RemoteException var105) {
                            Log.e("BackgroundPlugin", "" + var105, var105);
                        }
                    }

                    var3.success();
                    return true;
                }
            }
        }

        return false;
    }

    public void sendNotification(String var1) {
        if(this.callbackContext != null && var1 != null) {
            PluginResult var2 = new PluginResult(PluginResult.Status.field_2155, var1);
            var2.setKeepCallback(true);
            this.callbackContext.sendPluginResult(var2);
        }

    }

    public class IncomingHandler extends Handler {
        public void handleMessage(Message param1) {
            // $FF: Couldn't be decompiled
        }
    }

    public class PhoneGapNotificationReceiver extends BroadcastReceiver {
        public void onReceive(Context var1, Intent var2) {
            if(var2.getAction().equals("SendNotificationToPhoneGap")) {
                BackgroundPlugin.this.sendNotification(var2.getStringExtra("data"));
            }

        }
    }
}

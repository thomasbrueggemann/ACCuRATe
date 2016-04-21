package org.apache.cordova.deviceorientation;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CompassListener extends CordovaPlugin implements SensorEventListener {
    public static int ERROR_FAILED_TO_START = 3;
    public static int RUNNING = 2;
    public static int STARTING = 1;
    public static int STOPPED = 0;
    public long TIMEOUT = 30000L;
    int accuracy;
    private CallbackContext callbackContext;
    float heading = 0.0F;
    long lastAccessTime;
    Sensor mSensor;
    private SensorManager sensorManager;
    int status;
    long timeStamp = 0L;

    public CompassListener() {
        this.setStatus(STOPPED);
    }

    private JSONObject getCompassHeading() throws JSONException {
        JSONObject var1 = new JSONObject();
        var1.put("magneticHeading", (double)this.getHeading());
        var1.put("trueHeading", (double)this.getHeading());
        var1.put("headingAccuracy", 0);
        var1.put("timestamp", this.timeStamp);
        return var1;
    }

    private void setStatus(int var1) {
        this.status = var1;
    }

    private void timeout() {
        if(this.status == STARTING) {
            this.setStatus(ERROR_FAILED_TO_START);
            if(this.callbackContext != null) {
                this.callbackContext.error("Compass listener failed to start.");
            }
        }

    }

    public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
        if(var1.equals("start")) {
            this.start();
            return true;
        } else if(var1.equals("stop")) {
            this.stop();
            return true;
        } else if(var1.equals("getStatus")) {
            int var7 = this.getStatus();
            var3.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, var7));
            return true;
        } else if(var1.equals("getHeading")) {
            if(this.status != RUNNING) {
                if(this.start() == ERROR_FAILED_TO_START) {
                    var3.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, ERROR_FAILED_TO_START));
                    return true;
                }

                (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
                    public void run() {
                        CompassListener.this.timeout();
                    }
                }, 2000L);
            }

            var3.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, this.getCompassHeading()));
            return true;
        } else if(var1.equals("setTimeout")) {
            this.setTimeout(var2.getLong(0));
            return true;
        } else if(var1.equals("getTimeout")) {
            long var4 = this.getTimeout();
            var3.sendPluginResult(new PluginResult(PluginResult.Status.field_2155, (float)var4));
            return true;
        } else {
            return false;
        }
    }

    public float getHeading() {
        this.lastAccessTime = System.currentTimeMillis();
        return this.heading;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTimeout() {
        return this.TIMEOUT;
    }

    public void initialize(CordovaInterface var1, CordovaWebView var2) {
        super.initialize(var1, var2);
        this.sensorManager = (SensorManager)var1.getActivity().getSystemService("sensor");
    }

    public void onAccuracyChanged(Sensor var1, int var2) {
    }

    public void onDestroy() {
        this.stop();
    }

    public void onReset() {
        this.stop();
    }

    public void onSensorChanged(SensorEvent var1) {
        float var2 = var1.values[0];
        this.timeStamp = System.currentTimeMillis();
        this.heading = var2;
        this.setStatus(RUNNING);
        if(this.timeStamp - this.lastAccessTime > this.TIMEOUT) {
            this.stop();
        }

    }

    public void setTimeout(long var1) {
        this.TIMEOUT = var1;
    }

    public int start() {
        if(this.status != RUNNING && this.status != STARTING) {
            List var1 = this.sensorManager.getSensorList(3);
            if(var1 != null && var1.size() > 0) {
                this.mSensor = (Sensor)var1.get(0);
                this.sensorManager.registerListener(this, this.mSensor, 3);
                this.lastAccessTime = System.currentTimeMillis();
                this.setStatus(STARTING);
            } else {
                this.setStatus(ERROR_FAILED_TO_START);
            }

            return this.status;
        } else {
            return this.status;
        }
    }

    public void stop() {
        if(this.status != STOPPED) {
            this.sensorManager.unregisterListener(this);
        }

        this.setStatus(STOPPED);
    }
}

package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.analytics.tracking.android.AnalyticsClient;
import com.google.analytics.tracking.android.Log;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient implements AnalyticsClient {
    private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
    public static final int BIND_FAILED = 1;
    public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
    public static final int REMOTE_EXECUTION_FAILED = 2;
    static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
    private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
    private ServiceConnection mConnection;
    private Context mContext;
    private AnalyticsGmsCoreClient.OnConnectedListener mOnConnectedListener;
    private AnalyticsGmsCoreClient.OnConnectionFailedListener mOnConnectionFailedListener;
    private IAnalyticsService mService;

    public AnalyticsGmsCoreClient(Context var1, AnalyticsGmsCoreClient.OnConnectedListener var2, AnalyticsGmsCoreClient.OnConnectionFailedListener var3) {
        this.mContext = var1;
        if(var2 == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        } else {
            this.mOnConnectedListener = var2;
            if(var3 == null) {
                throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
            } else {
                this.mOnConnectionFailedListener = var3;
            }
        }
    }

    private IAnalyticsService getService() {
        this.checkConnected();
        return this.mService;
    }

    private void onConnectionSuccess() {
        this.mOnConnectedListener.onConnected();
    }

    private void onServiceBound() {
        this.onConnectionSuccess();
    }

    protected void checkConnected() {
        if(!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void clearHits() {
        try {
            this.getService().clearHits();
        } catch (RemoteException var2) {
            Log.method_2104("clear hits failed: " + var2);
        }
    }

    public void connect() {
        Intent var1 = new Intent("com.google.android.gms.analytics.service.START");
        var1.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        var1.putExtra("app_package_name", this.mContext.getPackageName());
        if(this.mConnection != null) {
            Log.method_2104("Calling connect() while still connected, missing disconnect().");
        } else {
            this.mConnection = new AnalyticsGmsCoreClient.AnalyticsServiceConnection();
            boolean var4 = this.mContext.bindService(var1, this.mConnection, 129);
            Log.method_2106("connect: bindService returned " + var4 + " for " + var1);
            if(!var4) {
                this.mConnection = null;
                this.mOnConnectionFailedListener.onConnectionFailed(1, (Intent)null);
                return;
            }
        }

    }

    public void disconnect() {
        this.mService = null;
        if(this.mConnection != null) {
            try {
                this.mContext.unbindService(this.mConnection);
            } catch (IllegalStateException var3) {
                ;
            } catch (IllegalArgumentException var4) {
                ;
            }

            this.mConnection = null;
            this.mOnConnectedListener.onDisconnected();
        }

    }

    public boolean isConnected() {
        return this.mService != null;
    }

    public void sendHit(Map<String, String> var1, long var2, String var4, List<Command> var5) {
        try {
            this.getService().sendHit(var1, var2, var4, var5);
        } catch (RemoteException var7) {
            Log.method_2104("sendHit failed: " + var7);
        }
    }

    final class AnalyticsServiceConnection implements ServiceConnection {
        public void onServiceConnected(ComponentName var1, IBinder var2) {
            Log.method_2106("service connected, binder: " + var2);

            try {
                if("com.google.android.gms.analytics.internal.IAnalyticsService".equals(var2.getInterfaceDescriptor())) {
                    Log.method_2106("bound to service");
                    AnalyticsGmsCoreClient.this.mService = IAnalyticsService.Stub.asInterface(var2);
                    AnalyticsGmsCoreClient.this.onServiceBound();
                    return;
                }
            } catch (RemoteException var4) {
                ;
            }

            AnalyticsGmsCoreClient.this.mContext.unbindService(this);
            AnalyticsGmsCoreClient.this.mConnection = null;
            AnalyticsGmsCoreClient.this.mOnConnectionFailedListener.onConnectionFailed(2, (Intent)null);
        }

        public void onServiceDisconnected(ComponentName var1) {
            Log.method_2106("service disconnected: " + var1);
            AnalyticsGmsCoreClient.this.mConnection = null;
            AnalyticsGmsCoreClient.this.mOnConnectedListener.onDisconnected();
        }
    }

    public interface OnConnectedListener {
        void onConnected();

        void onDisconnected();
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(int var1, Intent var2);
    }
}

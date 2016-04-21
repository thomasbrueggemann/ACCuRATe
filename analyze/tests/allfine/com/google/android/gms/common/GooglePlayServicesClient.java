package com.google.android.gms.common;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

@Deprecated
public interface GooglePlayServicesClient {
    void connect();

    void disconnect();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1);

    boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1);

    void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1);

    void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1);

    void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1);

    void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1);

    @Deprecated
    public interface ConnectionCallbacks {
        void onConnected(Bundle var1);

        void onDisconnected();
    }

    @Deprecated
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult var1);
    }
}

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_299;

@Deprecated
public class ActivityRecognitionClient implements GooglePlayServicesClient {
    private final class_299 aea;

    public ActivityRecognitionClient(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3) {
        this.aea = new class_299(var1, var2, var3, "activity_recognition");
    }

    public void connect() {
        this.aea.connect();
    }

    public void disconnect() {
        this.aea.disconnect();
    }

    public boolean isConnected() {
        return this.aea.isConnected();
    }

    public boolean isConnecting() {
        return this.aea.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
        return this.aea.isConnectionCallbacksRegistered(var1);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        return this.aea.isConnectionFailedListenerRegistered(var1);
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.aea.registerConnectionCallbacks(var1);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.aea.registerConnectionFailedListener(var1);
    }

    public void removeActivityUpdates(PendingIntent var1) {
        try {
            this.aea.removeActivityUpdates(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public void requestActivityUpdates(long var1, PendingIntent var3) {
        try {
            this.aea.requestActivityUpdates(var1, var3);
        } catch (RemoteException var5) {
            throw new IllegalStateException(var5);
        }
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.aea.unregisterConnectionCallbacks(var1);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.aea.unregisterConnectionFailedListener(var1);
    }
}

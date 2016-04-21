package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_828;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class LocationClient implements GooglePlayServicesClient {
    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    private final class_299 aea;

    public LocationClient(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3) {
        this.aea = new class_299(var1, var2, var3, "location");
    }

    public static int getErrorCode(Intent var0) {
        return var0.getIntExtra("gms_error_code", -1);
    }

    public static int getGeofenceTransition(Intent var0) {
        int var1 = var0.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        return var1 != -1 && (var1 == 1 || var1 == 2 || var1 == 4)?var1:-1;
    }

    public static List<Geofence> getTriggeringGeofences(Intent var0) {
        ArrayList var1 = (ArrayList)var0.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if(var1 == null) {
            return null;
        } else {
            ArrayList var2 = new ArrayList(var1.size());
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
                var2.add(class_828.method_4444((byte[])var3.next()));
            }

            return var2;
        }
    }

    public static Location getTriggeringLocation(Intent var0) {
        return (Location)var0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location");
    }

    public static boolean hasError(Intent var0) {
        return var0.hasExtra("gms_error_code");
    }

    public void addGeofences(List<Geofence> var1, PendingIntent var2, LocationClient.OnAddGeofencesResultListener var3) {
        ArrayList var4 = null;
        if(var1 != null) {
            ArrayList var5 = new ArrayList();
            Iterator var6 = var1.iterator();

            while(var6.hasNext()) {
                Geofence var8 = (Geofence)var6.next();
                class_1090.method_5683(var8 instanceof class_828, "Geofence must be created using Geofence.Builder.");
                var5.add((class_828)var8);
            }

            var4 = var5;
        }

        try {
            this.aea.addGeofences(var4, var2, var3);
        } catch (RemoteException var9) {
            throw new IllegalStateException(var9);
        }
    }

    public void connect() {
        this.aea.connect();
    }

    public void disconnect() {
        this.aea.disconnect();
    }

    public Location getLastLocation() {
        return this.aea.getLastLocation();
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

    public void removeGeofences(PendingIntent var1, LocationClient.OnRemoveGeofencesResultListener var2) {
        try {
            this.aea.removeGeofences(var1, var2);
        } catch (RemoteException var4) {
            throw new IllegalStateException(var4);
        }
    }

    public void removeGeofences(List<String> var1, LocationClient.OnRemoveGeofencesResultListener var2) {
        try {
            this.aea.removeGeofences(var1, var2);
        } catch (RemoteException var4) {
            throw new IllegalStateException(var4);
        }
    }

    public void removeLocationUpdates(PendingIntent var1) {
        try {
            this.aea.removeLocationUpdates(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public void removeLocationUpdates(LocationListener var1) {
        try {
            this.aea.removeLocationUpdates(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public void requestLocationUpdates(LocationRequest var1, PendingIntent var2) {
        try {
            this.aea.method_1879(class_826.method_4435(var1), var2);
        } catch (RemoteException var4) {
            throw new IllegalStateException(var4);
        }
    }

    public void requestLocationUpdates(LocationRequest var1, LocationListener var2) {
        try {
            this.aea.method_1876(class_826.method_4435(var1), var2);
        } catch (RemoteException var4) {
            throw new IllegalStateException(var4);
        }
    }

    public void requestLocationUpdates(LocationRequest var1, LocationListener var2, Looper var3) {
        try {
            this.aea.method_1877(class_826.method_4435(var1), var2, var3);
        } catch (RemoteException var5) {
            throw new IllegalStateException(var5);
        }
    }

    public void setMockLocation(Location var1) {
        try {
            this.aea.setMockLocation(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public void setMockMode(boolean var1) {
        try {
            this.aea.setMockMode(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.aea.unregisterConnectionCallbacks(var1);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.aea.unregisterConnectionFailedListener(var1);
    }

    public interface OnAddGeofencesResultListener {
        void onAddGeofencesResult(int var1, String[] var2);
    }

    public interface OnRemoveGeofencesResultListener {
        void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2);

        void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2);
    }
}

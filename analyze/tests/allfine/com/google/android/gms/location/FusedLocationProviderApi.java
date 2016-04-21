package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public interface FusedLocationProviderApi {
    String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    String KEY_MOCK_LOCATION = "mockLocation";

    Location getLastLocation(GoogleApiClient var1);

    PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, PendingIntent var2);

    PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, LocationListener var2);

    PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, LocationRequest var2, PendingIntent var3);

    PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, LocationRequest var2, LocationListener var3);

    PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, LocationRequest var2, LocationListener var3, Looper var4);

    PendingResult<Status> setMockLocation(GoogleApiClient var1, Location var2);

    PendingResult<Status> setMockMode(GoogleApiClient var1, boolean var2);
}

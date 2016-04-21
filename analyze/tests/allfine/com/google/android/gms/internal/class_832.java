package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_828;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lv
public class class_832 implements GeofencingApi {
    public PendingResult<Status> addGeofences(GoogleApiClient var1, List<Geofence> var2, final PendingIntent var3) {
        final ArrayList var6;
        if(var2 != null) {
            ArrayList var4 = new ArrayList(var2.size());
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
                Geofence var7 = (Geofence)var5.next();
                class_1090.method_5683(var7 instanceof class_828, "Geofence must be created using Geofence.Builder.");
                var4.add((class_828)var7);
            }

            var6 = var4;
        } else {
            var6 = null;
        }

        return var1.method_899(new class_832.class_1358(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1259(class_299 var1) throws RemoteException {
                LocationClient.OnAddGeofencesResultListener var2 = new LocationClient.OnAddGeofencesResultListener() {
                    public void onAddGeofencesResult(int var1, String[] var2) {
                        b(LocationStatusCodes.method_2367(var1));
                    }
                };
                var1.addGeofences(var6, var3, var2);
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient var1, final PendingIntent var2) {
        return var1.method_899(new class_832.class_1358(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1260(class_299 var1) throws RemoteException {
                LocationClient.OnRemoveGeofencesResultListener var2x = new LocationClient.OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2x) {
                        b(LocationStatusCodes.method_2367(var1));
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2x) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn\'t have been called");
                    }
                };
                var1.removeGeofences(var2, var2x);
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient var1, final List<String> var2) {
        return var1.method_899(new class_832.class_1358(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1261(class_299 var1) throws RemoteException {
                LocationClient.OnRemoveGeofencesResultListener var2x = new LocationClient.OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2x) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn\'t have been called");
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2x) {
                        b(LocationStatusCodes.method_2367(var1));
                    }
                };
                var1.removeGeofences(var2, var2x);
            }
        });
    }

    private abstract static class class_1358 extends LocationServices.class_1372<Status> {
        private class_1358() {
        }

        // $FF: synthetic method
        class_1358(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1258(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1258(Status var1) {
            return var1;
        }
    }
}

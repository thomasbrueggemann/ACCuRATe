package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// $FF: renamed from: com.google.android.gms.internal.lu
public class class_830 implements FusedLocationProviderApi {
    public Location getLastLocation(GoogleApiClient var1) {
        class_299 var2 = LocationServices.method_3529(var1);

        try {
            Location var4 = var2.getLastLocation();
            return var4;
        } catch (Exception var5) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, final PendingIntent var2) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1254(class_299 var1) throws RemoteException {
                var1.removeLocationUpdates(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, final LocationListener var2) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1255(class_299 var1) throws RemoteException {
                var1.removeLocationUpdates(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final PendingIntent var3) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1256(class_299 var1) throws RemoteException {
                var1.requestLocationUpdates(var2, var3);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final LocationListener var3) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1252(class_299 var1) throws RemoteException {
                var1.requestLocationUpdates(var2, var3, (Looper)null);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final LocationListener var3, final Looper var4) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1257(class_299 var1) throws RemoteException {
                var1.requestLocationUpdates(var2, var3, var4);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient var1, final Location var2) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1251(class_299 var1) throws RemoteException {
                var1.setMockLocation(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient var1, final boolean var2) {
        return var1.method_899(new class_830.class_1586(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.lz) void
            protected void method_1253(class_299 var1) throws RemoteException {
                var1.setMockMode(var2);
                this.b(Status.field_4739);
            }
        });
    }

    private abstract static class class_1586 extends LocationServices.class_1372<Status> {
        private class_1586() {
        }

        // $FF: synthetic method
        class_1586(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1250(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1250(Status var1) {
            return var1;
        }
    }
}

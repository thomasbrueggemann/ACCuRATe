package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_142;
import com.google.android.gms.internal.class_143;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_829;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.class_881;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.me;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lz
public class class_299 extends e<lx> {
    // $FF: renamed from: Dh com.google.android.gms.internal.me
    private final me<lx> field_896;
    private final class_829 aeW;
    private final class_881 aeX;
    private final class_833 aeY;
    private final class_336 aeZ;
    private final String afa;

    public class_299(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6) {
        this(var1, var2, var3, var4, var5, var6, (String)null);
    }

    public class_299(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7) {
        this(var1, var2, var3, var4, var5, var6, var7, (String)null);
    }

    public class_299(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7, String var8) {
        super(var1, var2, var4, var5, new String[0]);
        this.field_896 = new class_299.class_1316();
        this.aeW = new class_829(var1, this.field_896);
        this.afa = var6;
        this.aeX = new class_881(var3, this.field_896, var7);
        this.aeY = class_833.method_4456(var1, var7, var8, this.field_896);
        this.aeZ = class_336.method_2307(var1, this.field_896);
    }

    public class_299(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String var4) {
        super(var1, var2, var3, new String[0]);
        this.field_896 = new class_299.class_1316();
        this.aeW = new class_829(var1, this.field_896);
        this.afa = var4;
        this.aeX = new class_881(var1.getPackageName(), this.field_896, (String)null);
        this.aeY = class_833.method_4456(var1, (String)null, (String)null, this.field_896);
        this.aeZ = class_336.method_2307(var1, this.field_896);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        var3.putString("client_name", this.afa);
        var1.method_974(var2, 6171000, this.getContext().getPackageName(), var3);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ma, com.google.android.gms.location.LocationListener) void
    public void method_1876(class_826 var1, LocationListener var2) throws RemoteException {
        this.method_1877(var1, var2, (Looper)null);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ma, com.google.android.gms.location.LocationListener, android.os.Looper) void
    public void method_1877(class_826 param1, LocationListener param2, Looper param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: aL (android.os.IBinder) com.google.android.gms.internal.lx
    protected class_142 method_1878(IBinder var1) {
        return class_142.class_1276.method_3030(var1);
    }

    public void addGeofences(List<mc> var1, PendingIntent var2, LocationClient.OnAddGeofencesResultListener var3) throws RemoteException {
        this.dJ();
        boolean var4;
        if(var1 != null && var1.size() > 0) {
            var4 = true;
        } else {
            var4 = false;
        }

        class_1090.method_5683(var4, "At least one geofence must be specified.");
        class_1090.method_5681(var2, "PendingIntent must be specified.");
        class_1090.method_5681(var3, "OnAddGeofencesResultListener not provided.");
        class_299.class_1315 var7;
        if(var3 == null) {
            var7 = null;
        } else {
            var7 = new class_299.class_1315(var3, this);
        }

        ((class_142)this.gS()).method_743(var1, var2, var7, this.getContext().getPackageName());
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ma, android.app.PendingIntent) void
    public void method_1879(class_826 var1, PendingIntent var2) throws RemoteException {
        this.aeW.method_4451(var1, var2);
    }

    public void disconnect() {
        // $FF: Couldn't be decompiled
    }

    public Location getLastLocation() {
        return this.aeW.getLastLocation();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1878(var1);
    }

    public void removeActivityUpdates(PendingIntent var1) throws RemoteException {
        this.dJ();
        class_1090.method_5685(var1);
        ((class_142)this.gS()).removeActivityUpdates(var1);
    }

    public void removeGeofences(PendingIntent var1, LocationClient.OnRemoveGeofencesResultListener var2) throws RemoteException {
        this.dJ();
        class_1090.method_5681(var1, "PendingIntent must be specified.");
        class_1090.method_5681(var2, "OnRemoveGeofencesResultListener not provided.");
        class_299.class_1315 var5;
        if(var2 == null) {
            var5 = null;
        } else {
            var5 = new class_299.class_1315(var2, this);
        }

        ((class_142)this.gS()).method_722(var1, var5, this.getContext().getPackageName());
    }

    public void removeGeofences(List<String> var1, LocationClient.OnRemoveGeofencesResultListener var2) throws RemoteException {
        this.dJ();
        boolean var3;
        if(var1 != null && var1.size() > 0) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5683(var3, "geofenceRequestIds can\'t be null nor empty.");
        class_1090.method_5681(var2, "OnRemoveGeofencesResultListener not provided.");
        String[] var5 = (String[])var1.toArray(new String[0]);
        class_299.class_1315 var6;
        if(var2 == null) {
            var6 = null;
        } else {
            var6 = new class_299.class_1315(var2, this);
        }

        ((class_142)this.gS()).method_744(var5, var6, this.getContext().getPackageName());
    }

    public void removeLocationUpdates(PendingIntent var1) throws RemoteException {
        this.aeW.removeLocationUpdates(var1);
    }

    public void removeLocationUpdates(LocationListener var1) throws RemoteException {
        this.aeW.removeLocationUpdates(var1);
    }

    public void requestActivityUpdates(long var1, PendingIntent var3) throws RemoteException {
        this.dJ();
        class_1090.method_5685(var3);
        boolean var5;
        if(var1 >= 0L) {
            var5 = true;
        } else {
            var5 = false;
        }

        class_1090.method_5683(var5, "detectionIntervalMillis must be >= 0");
        ((class_142)this.gS()).method_720(var1, true, var3);
    }

    public void requestLocationUpdates(LocationRequest var1, PendingIntent var2) throws RemoteException {
        this.aeW.requestLocationUpdates(var1, var2);
    }

    public void requestLocationUpdates(LocationRequest param1, LocationListener param2, Looper param3) throws RemoteException {
        // $FF: Couldn't be decompiled
    }

    public void setMockLocation(Location var1) throws RemoteException {
        this.aeW.setMockLocation(var1);
    }

    public void setMockMode(boolean var1) throws RemoteException {
        this.aeW.setMockMode(var1);
    }

    private final class class_1314 extends com/google/android/gms/common/internal/e<lx>.b<LocationClient.OnAddGeofencesResultListener> {
        // $FF: renamed from: HF int
        private final int field_1856;
        private final String[] afb;

        public class_1314(LocationClient.OnAddGeofencesResultListener var2, int var3, String[] var4) {
            super();
            this.field_1856 = LocationStatusCodes.method_2366(var3);
            this.afb = var4;
        }

        // $FF: renamed from: a (com.google.android.gms.location.LocationClient$OnAddGeofencesResultListener) void
        protected void method_2922(LocationClient.OnAddGeofencesResultListener var1) {
            if(var1 != null) {
                var1.onAddGeofencesResult(this.field_1856, this.afb);
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2922((LocationClient.OnAddGeofencesResultListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private static final class class_1315 extends class_143.class_1197 {
        private LocationClient.OnAddGeofencesResultListener afd;
        private LocationClient.OnRemoveGeofencesResultListener afe;
        private class_299 aff;

        public class_1315(LocationClient.OnAddGeofencesResultListener var1, class_299 var2) {
            this.afd = var1;
            this.afe = null;
            this.aff = var2;
        }

        public class_1315(LocationClient.OnRemoveGeofencesResultListener var1, class_299 var2) {
            this.afe = var1;
            this.afd = null;
            this.aff = var2;
        }

        public void onAddGeofencesResult(int var1, String[] var2) throws RemoteException {
            if(this.aff == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            } else {
                class_299 var3 = this.aff;
                class_299 var4 = this.aff;
                var3.a(var4.new class_1314(this.afd, var1, var2));
                this.aff = null;
                this.afd = null;
                this.afe = null;
            }
        }

        public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2) {
            if(this.aff == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
            } else {
                class_299 var3 = this.aff;
                class_299 var4 = this.aff;
                var3.a(var4.new class_1317(1, this.afe, var1, var2));
                this.aff = null;
                this.afd = null;
                this.afe = null;
            }
        }

        public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2) {
            if(this.aff == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
            } else {
                class_299 var3 = this.aff;
                class_299 var4 = this.aff;
                var3.a(var4.new class_1317(2, this.afe, var1, var2));
                this.aff = null;
                this.afd = null;
                this.afe = null;
            }
        }
    }

    private final class class_1316 implements me<lx> {
        private class_1316() {
        }

        // $FF: synthetic method
        class_1316(Object var2) {
            this();
        }

        // $FF: renamed from: dJ () void
        public void method_798() {
            class_299.this.dJ();
        }

        // $FF: renamed from: gS () android.os.IInterface
        // $FF: synthetic method
        public IInterface method_799() {
            return this.method_5782();
        }

        // $FF: renamed from: lZ () com.google.android.gms.internal.lx
        public class_142 method_5782() {
            return (class_142)class_299.this.gS();
        }
    }

    private final class class_1317 extends com/google/android/gms/common/internal/e<lx>.b<LocationClient.OnRemoveGeofencesResultListener> {
        // $FF: renamed from: HF int
        private final int field_1855;
        private final String[] afb;
        private final int afg;
        private final PendingIntent mPendingIntent;

        public class_1317(int var2, LocationClient.OnRemoveGeofencesResultListener var3, int var4, PendingIntent var5) {
            byte var6 = 1;
            super();
            if(var2 != var6) {
                var6 = 0;
            }

            class_1097.method_5710((boolean)var6);
            this.afg = var2;
            this.field_1855 = LocationStatusCodes.method_2366(var4);
            this.mPendingIntent = var5;
            this.afb = null;
        }

        public class_1317(int var2, LocationClient.OnRemoveGeofencesResultListener var3, int var4, String[] var5) {
            super();
            boolean var6;
            if(var2 == 2) {
                var6 = true;
            } else {
                var6 = false;
            }

            class_1097.method_5710(var6);
            this.afg = var2;
            this.field_1855 = LocationStatusCodes.method_2366(var4);
            this.afb = var5;
            this.mPendingIntent = null;
        }

        // $FF: renamed from: a (com.google.android.gms.location.LocationClient$OnRemoveGeofencesResultListener) void
        protected void method_2921(LocationClient.OnRemoveGeofencesResultListener var1) {
            if(var1 != null) {
                switch(this.afg) {
                    case 1:
                        var1.onRemoveGeofencesByPendingIntentResult(this.field_1855, this.mPendingIntent);
                        return;
                    case 2:
                        var1.onRemoveGeofencesByRequestIdsResult(this.field_1855, this.afb);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.afg);
                }
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2921((LocationClient.OnRemoveGeofencesResultListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }
}

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_871;

// $FF: renamed from: com.google.android.gms.internal.nl
public class class_875 implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
    private class_296 akF;
    private final class_871.class_1815 akP;
    private boolean akQ;

    public class_875(class_871.class_1815 var1) {
        this.akP = var1;
        this.akF = null;
        this.akQ = true;
    }

    // $FF: renamed from: R (boolean) void
    public void method_4543(boolean var1) {
        this.akQ = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.no) void
    public void method_4544(class_296 var1) {
        this.akF = var1;
    }

    public void onConnected(Bundle var1) {
        this.akF.method_1867(false);
        if(this.akQ && this.akP != null) {
            this.akP.method_1066();
        }

        this.akQ = false;
    }

    public void onConnectionFailed(ConnectionResult var1) {
        this.akF.method_1867(true);
        if(this.akQ && this.akP != null) {
            if(var1.hasResolution()) {
                this.akP.method_1065(var1.getResolution());
            } else {
                this.akP.method_1067();
            }
        }

        this.akQ = false;
    }

    public void onDisconnected() {
        this.akF.method_1867(true);
    }
}

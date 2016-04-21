package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.common.internal.f
public final class class_1094 {
    // $FF: renamed from: LM com.google.android.gms.common.internal.f$b
    private final class_1094.class_1787 field_5138;
    // $FF: renamed from: LN java.util.ArrayList
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> field_5139 = new ArrayList();
    // $FF: renamed from: LO java.util.ArrayList
    final ArrayList<GoogleApiClient.ConnectionCallbacks> field_5140 = new ArrayList();
    // $FF: renamed from: LP boolean
    private boolean field_5141 = false;
    // $FF: renamed from: LQ java.util.ArrayList
    private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> field_5142 = new ArrayList();
    private final Handler mHandler;

    public class_1094(Context var1, Looper var2, class_1094.class_1787 var3) {
        this.field_5138 = var3;
        this.mHandler = new class_1094.class_1786(var2);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.f) java.util.ArrayList
    // $FF: synthetic method
    static ArrayList method_5703(class_1094 var0) {
        return var0.field_5139;
    }

    // $FF: renamed from: b (com.google.android.gms.common.internal.f) com.google.android.gms.common.internal.f$b
    // $FF: synthetic method
    static class_1094.class_1787 method_5704(class_1094 var0) {
        return var0.field_5138;
    }

    // $FF: renamed from: aB (int) void
    public void method_5705(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.common.ConnectionResult) void
    public void method_5706(ConnectionResult param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (android.os.Bundle) void
    public void method_5707(Bundle param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dL () void
    protected void method_5708() {
        // $FF: Couldn't be decompiled
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks param1) {
        // $FF: Couldn't be decompiled
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
        // $FF: Couldn't be decompiled
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
        // $FF: Couldn't be decompiled
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
        // $FF: Couldn't be decompiled
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
        // $FF: Couldn't be decompiled
    }

    final class class_1786 extends Handler {
        public class_1786(Looper var2) {
            super(var2);
        }

        public void handleMessage(Message param1) {
            // $FF: Couldn't be decompiled
        }
    }

    public interface class_1787 {
        // $FF: renamed from: fC () android.os.Bundle
        Bundle method_950();

        // $FF: renamed from: gq () boolean
        boolean method_951();

        boolean isConnected();
    }
}

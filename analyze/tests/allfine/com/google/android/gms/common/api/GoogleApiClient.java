package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.class_1122;
import com.google.android.gms.common.api.class_1124;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {
    // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
    <C extends Api.class_1478> C method_896(Api.class_1482<C> var1);

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
    <A extends Api.class_1478, R extends Result, T extends BaseImplementation.class_1146<R, A>> T method_897(T var1);

    // $FF: renamed from: a (com.google.android.gms.common.api.Scope) boolean
    boolean method_898(Scope var1);

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
    <A extends Api.class_1478, T extends BaseImplementation.class_1146<? extends Result, A>> T method_899(T var1);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long var1, TimeUnit var3);

    // $FF: renamed from: c (java.lang.Object) com.google.android.gms.common.api.c
    <L> c<L> method_900(L var1);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1);

    boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1);

    void reconnect();

    void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

    void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

    void stopAutoManage(FragmentActivity var1);

    void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

    void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

    public static final class Builder {
        // $FF: renamed from: Dd java.lang.String
        private String field_2118;
        // $FF: renamed from: IH android.os.Looper
        private Looper field_2119;
        // $FF: renamed from: IJ java.util.Set
        private final Set<String> field_2120;
        // $FF: renamed from: IK int
        private int field_2121;
        // $FF: renamed from: IL android.view.View
        private View field_2122;
        // $FF: renamed from: IM java.lang.String
        private String field_2123;
        // $FF: renamed from: IN java.util.Map
        private final Map<Api<?>, Api.ApiOptions> field_2124;
        // $FF: renamed from: IO android.support.v4.app.FragmentActivity
        private FragmentActivity field_2125;
        // $FF: renamed from: IP int
        private int field_2126;
        // $FF: renamed from: IQ com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
        private GoogleApiClient.OnConnectionFailedListener field_2127;
        // $FF: renamed from: IR int
        private int field_2128;
        // $FF: renamed from: IS java.util.Set
        private final Set<GoogleApiClient.ConnectionCallbacks> field_2129;
        // $FF: renamed from: IT java.util.Set
        private final Set<GoogleApiClient.OnConnectionFailedListener> field_2130;
        private final Context mContext;

        public Builder(Context var1) {
            this.field_2120 = new HashSet();
            this.field_2124 = new HashMap();
            this.field_2126 = -1;
            this.field_2128 = 2;
            this.field_2129 = new HashSet();
            this.field_2130 = new HashSet();
            this.mContext = var1;
            this.field_2119 = var1.getMainLooper();
            this.field_2123 = var1.getPackageName();
        }

        public Builder(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3) {
            this(var1);
            class_1090.method_5681(var2, "Must provide a connected listener");
            this.field_2129.add(var2);
            class_1090.method_5681(var3, "Must provide a connection failed listener");
            this.field_2130.add(var3);
        }

        // $FF: renamed from: gl () com.google.android.gms.common.api.GoogleApiClient
        private GoogleApiClient method_3035() {
            class_1124 var1 = class_1124.method_5820(this.field_2125);
            Object var2 = var1.method_5829(this.field_2126);
            if(var2 == null) {
                var2 = new class_1122(this.mContext.getApplicationContext(), this.field_2119, this.method_3036(), this.field_2124, this.field_2129, this.field_2130, this.field_2126, this.field_2128);
            }

            var1.method_5827(this.field_2126, (GoogleApiClient)var2, this.field_2127);
            return (GoogleApiClient)var2;
        }

        public GoogleApiClient.Builder addApi(Api<? extends Api.NotRequiredOptions> var1) {
            this.field_2124.put(var1, (Object)null);
            List var3 = var1.method_3759();
            int var4 = var3.size();

            for(int var5 = 0; var5 < var4; ++var5) {
                this.field_2120.add(((Scope)var3.get(var5)).method_1619());
            }

            return this;
        }

        public <O extends Api.HasOptions> GoogleApiClient.Builder addApi(Api<O> var1, O var2) {
            class_1090.method_5681(var2, "Null options are not permitted for this Api");
            this.field_2124.put(var1, var2);
            List var5 = var1.method_3759();
            int var6 = var5.size();

            for(int var7 = 0; var7 < var6; ++var7) {
                this.field_2120.add(((Scope)var5.get(var7)).method_1619());
            }

            return this;
        }

        public GoogleApiClient.Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
            this.field_2129.add(var1);
            return this;
        }

        public GoogleApiClient.Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
            this.field_2130.add(var1);
            return this;
        }

        public GoogleApiClient.Builder addScope(Scope var1) {
            this.field_2120.add(var1.method_1619());
            return this;
        }

        public GoogleApiClient build() {
            boolean var1;
            if(!this.field_2124.isEmpty()) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5683(var1, "must call addApi() to add at least one API");
            return (GoogleApiClient)(this.field_2126 >= 0?this.method_3035():new class_1122(this.mContext, this.field_2119, this.method_3036(), this.field_2124, this.field_2129, this.field_2130, -1, this.field_2128));
        }

        public GoogleApiClient.Builder enableAutoManage(FragmentActivity var1, int var2, GoogleApiClient.OnConnectionFailedListener var3) {
            boolean var4;
            if(var2 >= 0) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5683(var4, "clientId must be non-negative");
            this.field_2126 = var2;
            this.field_2125 = (FragmentActivity)class_1090.method_5681(var1, "Null activity is not permitted.");
            this.field_2127 = var3;
            return this;
        }

        // $FF: renamed from: gk () com.google.android.gms.common.internal.ClientSettings
        public ClientSettings method_3036() {
            return new ClientSettings(this.field_2118, this.field_2120, this.field_2121, this.field_2122, this.field_2123);
        }

        public GoogleApiClient.Builder setAccountName(String var1) {
            this.field_2118 = var1;
            return this;
        }

        public GoogleApiClient.Builder setGravityForPopups(int var1) {
            this.field_2121 = var1;
            return this;
        }

        public GoogleApiClient.Builder setHandler(Handler var1) {
            class_1090.method_5681(var1, "Handler must not be null");
            this.field_2119 = var1.getLooper();
            return this;
        }

        public GoogleApiClient.Builder setViewForPopups(View var1) {
            this.field_2122 = var1;
            return this;
        }

        public GoogleApiClient.Builder useDefaultAccount() {
            return this.setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        int CAUSE_NETWORK_LOST = 2;
        int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle var1);

        void onConnectionSuspended(int var1);
    }

    public interface OnConnectionFailedListener extends GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult var1);
    }
}

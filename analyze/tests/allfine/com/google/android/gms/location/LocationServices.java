package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_830;
import com.google.android.gms.internal.class_832;
import com.google.android.gms.internal.lz;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.GeofencingApi;

public class LocationServices {
    public static final Api<Api.NoOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    private static final Api.class_1482<lz> field_3154 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<lz, Api.NoOptions> field_3155 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        // $FF: synthetic method
        public Api.class_1478 method_373(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return this.method_3642(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
        }

        // $FF: renamed from: d (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.lz
        public class_299 method_3642(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return new class_299(var1, var2, var1.getPackageName(), var5, var6, "locationServices", var3.getAccountName());
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static FusedLocationProviderApi FusedLocationApi;
    public static GeofencingApi GeofencingApi;

    static {
        API = new Api(field_3155, field_3154, new Scope[0]);
        FusedLocationApi = new class_830();
        GeofencingApi = new class_832();
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.lz
    public static class_299 method_3529(GoogleApiClient var0) {
        boolean var1 = true;
        boolean var2;
        if(var0 != null) {
            var2 = var1;
        } else {
            var2 = false;
        }

        class_1090.method_5683(var2, "GoogleApiClient parameter is required.");
        class_299 var3 = (class_299)var0.method_896(field_3154);
        if(var3 == null) {
            var1 = false;
        }

        class_1090.method_5676(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return var3;
    }

    public abstract static class class_1372<R extends Result> extends BaseImplementation.class_1146<R, lz> {
        public class_1372() {
            super(LocationServices.field_3154);
        }
    }
}

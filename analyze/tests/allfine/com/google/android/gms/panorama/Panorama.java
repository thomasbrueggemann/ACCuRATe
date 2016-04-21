package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.class_295;
import com.google.android.gms.internal.class_879;
import com.google.android.gms.internal.nd;
import com.google.android.gms.panorama.PanoramaApi;

public final class Panorama {
    public static final Api<Api.NoOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<nd> field_5150 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    static final Api.class_1479<nd, Api.NoOptions> field_5151 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        // $FF: synthetic method
        public Api.class_1478 method_373(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return this.method_5479(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
        }

        // $FF: renamed from: e (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.nd
        public class_295 method_5479(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return new class_295(var1, var2, var5, var6);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final PanoramaApi PanoramaApi;

    static {
        API = new Api(field_5151, field_5150, new Scope[0]);
        PanoramaApi = new class_879();
    }
}

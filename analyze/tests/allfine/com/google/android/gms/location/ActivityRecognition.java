package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.lz;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ActivityRecognition {
    public static final Api<Api.NoOptions> API;
    public static ActivityRecognitionApi ActivityRecognitionApi;
    public static final String CLIENT_NAME = "activity_recognition";
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    private static final Api.class_1482<lz> field_4604 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<lz, Api.NoOptions> field_4605 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        // $FF: synthetic method
        public Api.class_1478 method_373(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return this.method_5957(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
        }

        // $FF: renamed from: d (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.lz
        public class_299 method_5957(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return new class_299(var1, var2, var1.getPackageName(), var5, var6, "activity_recognition");
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    static {
        API = new Api(field_4605, field_4604, new Scope[0]);
        ActivityRecognitionApi = new class_834();
    }

    public abstract static class class_1781<R extends Result> extends BaseImplementation.class_1146<R, lz> {
        public class_1781() {
            super(ActivityRecognition.field_4604);
        }
    }
}

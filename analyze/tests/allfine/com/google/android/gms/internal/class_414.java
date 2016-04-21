package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_302;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.hy;

// $FF: renamed from: com.google.android.gms.internal.hd
public final class class_414 {
    // $FF: renamed from: BN com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<hy> field_1535 = new Api.class_1482();
    // $FF: renamed from: BO com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<hy, Api.NoOptions> field_1536 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.hy
        public class_302 method_5564(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return new class_302(var1, var2, var5, var6);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    // $FF: renamed from: BP com.google.android.gms.common.api.Api
    public static final Api<Api.NoOptions> field_1537;
    // $FF: renamed from: BQ com.google.android.gms.internal.hu
    public static final class_24 field_1538;

    static {
        field_1537 = new Api(field_1536, field_1535, new Scope[0]);
        field_1538 = new class_394();
    }
}

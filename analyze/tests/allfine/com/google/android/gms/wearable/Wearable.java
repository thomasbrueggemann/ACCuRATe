package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.class_188;
import com.google.android.gms.wearable.internal.aw;
import com.google.android.gms.wearable.internal.class_1010;
import com.google.android.gms.wearable.internal.class_1081;
import com.google.android.gms.wearable.internal.class_1084;
import com.google.android.gms.wearable.internal.class_292;
import com.google.android.gms.wearable.internal.class_992;

public class Wearable {
    public static final Api<Wearable.WearableOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<aw> field_3624 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<aw, Wearable.WearableOptions> field_3625 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.wearable.Wearable$WearableOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.wearable.internal.aw
        public class_292 method_4046(Context var1, Looper var2, ClientSettings var3, Wearable.WearableOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            if(var4 == null) {
                new Wearable.WearableOptions(new Wearable.Builder(), null);
            }

            return new class_292(var1, var2, var5, var6);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final DataApi DataApi = new class_992();
    public static final MessageApi MessageApi = new class_1081();
    public static final NodeApi NodeApi = new class_1084();
    public static final class_188 avb = new class_1010();

    static {
        API = new Api(field_3625, field_3624, new Scope[0]);
    }

    public static final class WearableOptions implements Api.Optional {
        private WearableOptions(Wearable.Builder var1) {
        }

        // $FF: synthetic method
        WearableOptions(Wearable.Builder var1, Object var2) {
            this(var1);
        }
    }

    public static class Builder {
        public Wearable.WearableOptions build() {
            return new Wearable.WearableOptions(this, null);
        }
    }
}

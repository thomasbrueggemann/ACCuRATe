package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.class_1064;
import com.google.android.gms.internal.class_150;
import com.google.android.gms.internal.class_297;
import com.google.android.gms.internal.class_839;
import com.google.android.gms.internal.class_840;
import com.google.android.gms.internal.class_842;
import com.google.android.gms.internal.class_843;
import com.google.android.gms.internal.class_844;
import com.google.android.gms.internal.class_845;
import com.google.android.gms.internal.class_846;
import com.google.android.gms.internal.class_847;
import com.google.android.gms.internal.class_86;
import com.google.android.gms.internal.kk;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    public static final Api<Api.NoOptions> API;
    public static final BleApi BleApi;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<kk> field_4606 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<kk, Api.NoOptions> field_4607 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        // $FF: synthetic method
        public Api.class_1478 method_373(Context var1, Looper var2, ClientSettings var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            return this.method_3007(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
        }

        // $FF: renamed from: c (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.kk
        public class_86 method_3007(Context var1, Looper var2, ClientSettings var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            String[] var7 = class_1064.method_5563(var3.getScopes());
            return new class_297(var1, var2, var5, var6, var3.getAccountNameOrDefault(), var7);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final ConfigApi ConfigApi;
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final HistoryApi HistoryApi;
    public static final RecordingApi RecordingApi;
    public static final Scope SCOPE_ACTIVITY_READ;
    public static final Scope SCOPE_ACTIVITY_READ_WRITE;
    public static final Scope SCOPE_BODY_READ;
    public static final Scope SCOPE_BODY_READ_WRITE;
    public static final Scope SCOPE_LOCATION_READ;
    public static final Scope SCOPE_LOCATION_READ_WRITE;
    public static final SensorsApi SensorsApi;
    public static final SessionsApi SessionsApi;
    // $FF: renamed from: Sn com.google.android.gms.internal.kv
    public static final class_150 field_4608;

    static {
        API = new Api(field_4607, field_4606, new Scope[0]);
        SensorsApi = new class_842();
        RecordingApi = new class_843();
        SessionsApi = new class_839();
        HistoryApi = new class_845();
        ConfigApi = new class_846();
        BleApi = method_5252();
        field_4608 = new class_844();
        SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
        SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
        SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
        SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
        SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
        SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    }

    public static long getEndTime(Intent var0, TimeUnit var1) {
        long var2 = var0.getLongExtra("vnd.google.fitness.end_time", -1L);
        return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent var0, TimeUnit var1) {
        long var2 = var0.getLongExtra("vnd.google.fitness.start_time", -1L);
        return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
    }

    // $FF: renamed from: iy () com.google.android.gms.fitness.BleApi
    private static BleApi method_5252() {
        return (BleApi)(VERSION.SDK_INT >= 18?new class_847():new class_840());
    }
}

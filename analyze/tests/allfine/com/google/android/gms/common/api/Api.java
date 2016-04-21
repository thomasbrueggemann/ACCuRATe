package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends Api.ApiOptions> {
    // $FF: renamed from: Io com.google.android.gms.common.api.Api$b
    private final Api.class_1479<?, O> field_3295;
    // $FF: renamed from: Ip com.google.android.gms.common.api.Api$c
    private final Api.class_1482<?> field_3296;
    // $FF: renamed from: Iq java.util.ArrayList
    private final ArrayList<Scope> field_3297;

    public <C extends Api.class_1478> Api(Api.class_1479<C, O> var1, Api.class_1482<C> var2, Scope... var3) {
        this.field_3295 = var1;
        this.field_3296 = var2;
        this.field_3297 = new ArrayList(Arrays.asList(var3));
    }

    // $FF: renamed from: gb () com.google.android.gms.common.api.Api$b
    public Api.class_1479<?, O> method_3758() {
        return this.field_3295;
    }

    // $FF: renamed from: gd () java.util.List
    public List<Scope> method_3759() {
        return this.field_3297;
    }

    // $FF: renamed from: ge () com.google.android.gms.common.api.Api$c
    public Api.class_1482<?> method_3760() {
        return this.field_3296;
    }

    public interface ApiOptions {
    }

    public interface HasOptions extends Api.ApiOptions {
    }

    public static final class NoOptions implements Api.NotRequiredOptions {
    }

    public interface NotRequiredOptions extends Api.ApiOptions {
    }

    public interface Optional extends Api.HasOptions, Api.NotRequiredOptions {
    }

    public interface class_1478 {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    public interface class_1479<T extends Api.class_1478, O> {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
        T method_373(Context var1, Looper var2, ClientSettings var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6);

        int getPriority();
    }

    public static final class class_1482<C extends Api.class_1478> {
    }
}

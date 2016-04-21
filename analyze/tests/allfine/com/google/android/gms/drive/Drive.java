package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.class_94;
import com.google.android.gms.drive.class_95;
import com.google.android.gms.drive.internal.class_262;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_305;
import com.google.android.gms.drive.internal.q;
import java.util.List;

public final class Drive {
    public static final Api<Api.NoOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<q> field_3554 = new Api.class_1482();
    public static final DriveApi DriveApi;
    // $FF: renamed from: Nc com.google.android.gms.common.api.Scope
    public static final Scope field_3555 = new Scope("https://www.googleapis.com/auth/drive");
    // $FF: renamed from: Nd com.google.android.gms.common.api.Scope
    public static final Scope field_3556 = new Scope("https://www.googleapis.com/auth/drive.apps");
    // $FF: renamed from: Ne com.google.android.gms.common.api.Api
    public static final Api<Drive.class_1220> field_3557;
    // $FF: renamed from: Nf com.google.android.gms.drive.b
    public static final class_95 field_3558;
    // $FF: renamed from: Ng com.google.android.gms.drive.e
    public static final class_94 field_3559;
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");

    static {
        API = new Api(new Drive.class_1219() {
            // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions$NoOptions) android.os.Bundle
            protected Bundle method_2812(Api.NoOptions var1) {
                return new Bundle();
            }
        }, field_3554, new Scope[0]);
        field_3557 = new Api(new Drive.class_1219() {
            // $FF: renamed from: a (com.google.android.gms.drive.Drive$b) android.os.Bundle
            protected Bundle method_2813(Drive.class_1220 var1) {
                return var1 == null?new Bundle():var1.method_2826();
            }
        }, field_3554, new Scope[0]);
        DriveApi = new class_290();
        field_3558 = new class_262();
        field_3559 = new class_267();
    }

    public abstract static class class_1219<O extends Api.ApiOptions> implements Api.class_1479<q, O> {
        // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions) android.os.Bundle
        protected abstract Bundle method_2810(O var1);

        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.drive.internal.q
        public q method_2811(Context var1, Looper var2, ClientSettings var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            List var7 = var3.getScopes();
            return new class_305(var1, var2, var3, var5, var6, (String[])var7.toArray(new String[var7.size()]), this.method_2810(var4));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static class class_1220 implements Api.Optional {
        // $FF: renamed from: Nh android.os.Bundle
        private final Bundle field_1757;

        private class_1220() {
            this(new Bundle());
        }

        private class_1220(Bundle var1) {
            this.field_1757 = var1;
        }

        // $FF: renamed from: hM () android.os.Bundle
        public Bundle method_2826() {
            return this.field_1757;
        }
    }
}

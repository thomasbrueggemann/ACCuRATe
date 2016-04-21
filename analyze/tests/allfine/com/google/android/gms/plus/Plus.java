package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_865;
import com.google.android.gms.internal.class_866;
import com.google.android.gms.internal.class_867;
import com.google.android.gms.internal.class_868;
import com.google.android.gms.internal.class_869;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.class_180;
import com.google.android.gms.plus.class_181;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_293;
import com.google.android.gms.plus.internal.class_959;
import com.google.android.gms.plus.internal.e;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<Plus.PlusOptions> API;
    public static final Account AccountApi;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    public static final Api.class_1482<e> field_1032 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    static final Api.class_1479<e, Plus.PlusOptions> field_1033 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.plus.Plus$PlusOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.plus.internal.e
        public class_293 method_3366(Context var1, Looper var2, ClientSettings var3, Plus.PlusOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            if(var4 == null) {
                var4 = new Plus.PlusOptions(null);
            }

            class_293 var7 = new class_293(var1, var2, var5, var6, new class_959(var3.getAccountNameOrDefault(), var3.getScopesArray(), (String[])var4.alc.toArray(new String[0]), new String[0], var1.getPackageName(), var1.getPackageName(), (String)null, new PlusCommonExtras()));
            return var7;
        }

        public int getPriority() {
            return 2;
        }
    };
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final class_181 akZ;
    public static final class_180 ala;

    static {
        API = new Api(field_1033, field_1032, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
        SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
        MomentsApi = new class_868();
        PeopleApi = new class_869();
        AccountApi = new class_865();
        akZ = new class_867();
        ala = new class_866();
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
    public static e method_2182(GoogleApiClient var0, Api.class_1482<e> var1) {
        boolean var2 = true;
        boolean var3;
        if(var0 != null) {
            var3 = var2;
        } else {
            var3 = false;
        }

        class_1090.method_5683(var3, "GoogleApiClient parameter is required.");
        class_1090.method_5676(var0.isConnected(), "GoogleApiClient must be connected.");
        class_293 var4 = (class_293)var0.method_896(var1);
        if(var4 == null) {
            var2 = false;
        }

        class_1090.method_5676(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return var4;
    }

    public static final class PlusOptions implements Api.Optional {
        final String alb;
        final Set<String> alc;

        private PlusOptions() {
            this.alb = null;
            this.alc = new HashSet();
        }

        // $FF: synthetic method
        PlusOptions(Object var1) {
            this();
        }

        private PlusOptions(Plus.Builder var1) {
            this.alb = var1.alb;
            this.alc = var1.alc;
        }

        // $FF: synthetic method
        PlusOptions(Plus.Builder var1, Object var2) {
            this(var1);
        }

        public static Plus.Builder builder() {
            return new Plus.Builder();
        }
    }

    public static final class Builder {
        String alb;
        final Set<String> alc = new HashSet();

        public Plus.Builder addActivityTypes(String... var1) {
            class_1090.method_5681(var1, "activityTypes may not be null.");

            for(int var3 = 0; var3 < var1.length; ++var3) {
                this.alc.add(var1[var3]);
            }

            return this;
        }

        public Plus.PlusOptions build() {
            return new Plus.PlusOptions(this, null);
        }

        public Plus.Builder setServerClientId(String var1) {
            this.alb = var1;
            return this;
        }
    }

    public abstract static class class_1173<R extends Result> extends BaseImplementation.class_1146<R, e> {
        public class_1173() {
            super(Plus.field_1032);
        }
    }
}

package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.lm;

public final class Address {
    public static final Api<Address.AddressOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    static final Api.class_1482<lm> field_5052 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<lm, Address.AddressOptions> field_5053 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.identity.intents.Address$AddressOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.lm
        public class_298 method_4244(Context var1, Looper var2, ClientSettings var3, Address.AddressOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            class_1090.method_5683(var1 instanceof Activity, "An Activity must be used for Address APIs");
            if(var4 == null) {
                var4 = new Address.AddressOptions();
            }

            return new class_298((Activity)var1, var2, var5, var6, var3.getAccountName(), var4.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    static {
        API = new Api(field_5053, field_5052, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient var0, final UserAddressRequest var1, final int var2) {
        var0.method_897(new Address.class_1645() {
            // $FF: renamed from: a (com.google.android.gms.internal.lm) void
            protected void method_1158(class_298 var1x) throws RemoteException {
                var1x.method_1871(var1, var2);
                this.b(Status.field_4739);
            }
        });
    }

    public static final class AddressOptions implements Api.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int var1) {
            this.theme = var1;
        }
    }

    private abstract static class class_1645 extends BaseImplementation.class_1146<Status, lm> {
        public class_1645() {
            super(Address.field_5052);
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1157(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1157(Status var1) {
            return var1;
        }
    }
}

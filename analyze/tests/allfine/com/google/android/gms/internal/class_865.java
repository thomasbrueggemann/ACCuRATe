package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_293;
import com.google.android.gms.plus.internal.e;

// $FF: renamed from: com.google.android.gms.internal.np
public final class class_865 implements Account {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
    private static e method_4528(GoogleApiClient var0, Api.class_1482<e> var1) {
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

    public void clearDefaultAccount(GoogleApiClient var1) {
        method_4528(var1, Plus.field_1032).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient var1) {
        return method_4528(var1, Plus.field_1032).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient var1) {
        return var1.method_899(new class_865.class_1816(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1236(class_293 var1) {
                var1.method_1852(this);
            }
        });
    }

    private abstract static class class_1816 extends Plus.class_1173<Status> {
        private class_1816() {
        }

        // $FF: synthetic method
        class_1816(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1235(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1235(Status var1) {
            return var1;
        }
    }
}

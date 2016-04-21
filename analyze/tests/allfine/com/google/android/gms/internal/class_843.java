package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_493;
import com.google.android.gms.fitness.request.class_498;
import com.google.android.gms.fitness.request.class_505;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.class_153;
import com.google.android.gms.internal.class_86;

// $FF: renamed from: com.google.android.gms.internal.lb
public class class_843 implements RecordingApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.m) com.google.android.gms.common.api.PendingResult
    private PendingResult<ListSubscriptionsResult> method_4466(GoogleApiClient var1, final m var2) {
        return var1.method_897(new class_86.class_1401() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1212(class_86 var1) throws RemoteException {
                class_843.class_1672 var2x = new class_843.class_1672(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_779(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1213(var1);
            }

            // $FF: renamed from: z (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.ListSubscriptionsResult
            protected ListSubscriptionsResult method_1213(Status var1) {
                return ListSubscriptionsResult.method_3409(var1);
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.af) com.google.android.gms.common.api.PendingResult
    public PendingResult<Status> method_4467(GoogleApiClient var1, final af var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1227(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_773(var2, var2x, var3);
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.aj) com.google.android.gms.common.api.PendingResult
    public PendingResult<Status> method_4468(GoogleApiClient var1, final aj var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1228(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_775(var2, var2x, var3);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient var1) {
        return this.method_4466(var1, (new class_505.class_1343()).method_3251());
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient var1, DataType var2) {
        return this.method_4466(var1, (new class_505.class_1343()).method_3250(var2).method_3251());
    }

    public PendingResult<Status> subscribe(GoogleApiClient var1, DataSource var2) {
        return this.method_4467(var1, (new class_498.class_1609()).method_4190((new Subscription.class_1742()).method_5222(var2).method_5224()).method_4191());
    }

    public PendingResult<Status> subscribe(GoogleApiClient var1, DataType var2) {
        return this.method_4467(var1, (new class_498.class_1609()).method_4190((new Subscription.class_1742()).method_5223(var2).method_5224()).method_4191());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient var1, DataSource var2) {
        return this.method_4468(var1, (new class_493.class_1615()).method_4216(var2).method_4218());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient var1, DataType var2) {
        return this.method_4468(var1, (new class_493.class_1615()).method_4217(var2).method_4218());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient var1, Subscription var2) {
        return var2.getDataType() == null?this.unsubscribe(var1, var2.getDataSource()):this.unsubscribe(var1, var2.getDataType());
    }

    private static class class_1672 extends class_153.class_1548 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<ListSubscriptionsResult> field_4005;

        private class_1672(BaseImplementation.class_1147<ListSubscriptionsResult> var1) {
            this.field_4005 = var1;
        }

        // $FF: synthetic method
        class_1672(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
        public void method_761(ListSubscriptionsResult var1) {
            this.field_4005.method_120(var1);
        }
    }
}

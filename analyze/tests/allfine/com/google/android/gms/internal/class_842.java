package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.data.class_495;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.class_507;
import com.google.android.gms.fitness.request.class_528;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.fitness.request.q;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_849;
import com.google.android.gms.internal.class_86;
import com.google.android.gms.internal.kk;

// $FF: renamed from: com.google.android.gms.internal.lc
public class class_842 implements SensorsApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.o) com.google.android.gms.common.api.PendingResult
    private PendingResult<Status> method_4464(GoogleApiClient var1, final o var2) {
        return var1.method_897(new class_842.class_1798() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1142(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_780(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1143(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            protected Status method_1143(Status var1) {
                return var1;
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.q, com.google.android.gms.internal.lc$b) com.google.android.gms.common.api.PendingResult
    private PendingResult<Status> method_4465(GoogleApiClient var1, final q var2, final class_842.class_1797 var3) {
        return var1.method_899(new class_842.class_1798() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1138(class_86 var1) throws RemoteException {
                class_842.class_1799 var2x = new class_842.class_1799(this, var3, null);
                String var3x = var1.getContext().getPackageName();
                var1.method_372().method_781(var2, var2x, var3x);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1139(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            protected Status method_1139(Status var1) {
                return var1;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, PendingIntent var3) {
        return this.method_4464(var1, new class_507(var2, (class_200)null, var3));
    }

    public PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, OnDataPointListener var3) {
        return this.method_4464(var1, new class_507(var2, class_495.class_1739.method_4906().method_4907(var3), (PendingIntent)null));
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient var1, final DataSourcesRequest var2) {
        return var1.method_897(new class_842.class_1798() {
            // $FF: renamed from: A (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataSourcesResult
            protected DataSourcesResult method_1140(Status var1) {
                return DataSourcesResult.method_3574(var1);
            }

            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1141(class_86 var1) throws RemoteException {
                class_842.class_1800 var2x = new class_842.class_1800(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_766(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1140(var1);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient var1, PendingIntent var2) {
        return this.method_4465(var1, new class_528((class_200)null, var2), (class_842.class_1797)null);
    }

    public PendingResult<Status> remove(GoogleApiClient var1, final OnDataPointListener var2) {
        class_495 var3 = class_495.class_1739.method_4906().method_4908(var2);
        return (PendingResult)(var3 == null?new class_849(Status.field_4739):this.method_4465(var1, new class_528(var3, (PendingIntent)null), new class_842.class_1797() {
            // $FF: renamed from: jd () void
            public void method_890() {
                class_495.class_1739.method_4906().method_4909(var2);
            }
        }));
    }

    private abstract static class class_1798<R extends Result> extends BaseImplementation.class_1146<R, kk> {
        public class_1798() {
            super(Fitness.field_4606);
        }
    }

    private interface class_1797 {
        // $FF: renamed from: jd () void
        void method_890();
    }

    private static class class_1800 extends class_158.class_1546 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DataSourcesResult> field_3897;

        private class_1800(BaseImplementation.class_1147<DataSourcesResult> var1) {
            this.field_3897 = var1;
        }

        // $FF: synthetic method
        class_1800(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
        public void method_789(DataSourcesResult var1) {
            this.field_3897.method_120(var1);
        }
    }

    private static class class_1799 extends class_151.class_1528 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_4795;
        // $FF: renamed from: TX com.google.android.gms.internal.lc$b
        private final class_842.class_1797 field_4796;

        private class_1799(BaseImplementation.class_1147<Status> var1, class_842.class_1797 var2) {
            this.field_4795 = var1;
            this.field_4796 = var2;
        }

        // $FF: synthetic method
        class_1799(BaseImplementation.class_1147 var1, class_842.class_1797 var2, Object var3) {
            this(var1, var2);
        }

        // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
        public void method_759(Status var1) {
            if(this.field_4796 != null && var1.isSuccess()) {
                this.field_4796.method_890();
            }

            this.field_4795.method_120(var1);
        }
    }
}

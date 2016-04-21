package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.class_510;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.class_155;
import com.google.android.gms.internal.class_86;

// $FF: renamed from: com.google.android.gms.internal.ky
public class class_846 implements ConfigApi {
    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient var1, final DataTypeCreateRequest var2) {
        return var1.method_899(new class_86.class_1401() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1214(class_86 var1) throws RemoteException {
                class_846.class_1675 var2x = new class_846.class_1675(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_767(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1215(var1);
            }

            // $FF: renamed from: x (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
            protected DataTypeResult method_1215(Status var1) {
                return DataTypeResult.method_5517(var1);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient var1) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1229(class_86 var1) throws RemoteException {
                class_86.class_1402 var2 = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_785(var2, var3);
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient var1, String var2) {
        return var1.method_897(new class_86.class_1401() {
            // $FF: renamed from: TG com.google.android.gms.fitness.request.j
            // $FF: synthetic field
            final class_510 field_109;

            {
                this.field_109 = var2;
            }

            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1216(class_86 var1) throws RemoteException {
                class_846.class_1675 var2 = new class_846.class_1675(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_778(this.field_109, var2, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1217(var1);
            }

            // $FF: renamed from: x (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
            protected DataTypeResult method_1217(Status var1) {
                return DataTypeResult.method_5517(var1);
            }
        });
    }

    private static class class_1675 extends class_155.class_1365 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DataTypeResult> field_2942;

        private class_1675(BaseImplementation.class_1147<DataTypeResult> var1) {
            this.field_2942 = var1;
        }

        // $FF: synthetic method
        class_1675(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataTypeResult) void
        public void method_763(DataTypeResult var1) {
            this.field_2942.method_120(var1);
        }
    }
}

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.class_512;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.class_157;
import com.google.android.gms.internal.class_86;

// $FF: renamed from: com.google.android.gms.internal.kz
public class class_845 implements HistoryApi {
    public PendingResult<Status> deleteData(GoogleApiClient var1, final DataDeleteRequest var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1226(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_764(var2, var2x, var3);
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient var1, final DataSet var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1225(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_777((new class_512.class_1351()).method_3263(var2).method_3264(), var2x, var3);
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient var1, final DataReadRequest var2) {
        return var1.method_897(new class_86.class_1401() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1210(class_86 var1) throws RemoteException {
                class_845.class_1777 var2x = new class_845.class_1777(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_765(var2, var2x, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1211(var1);
            }

            // $FF: renamed from: y (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataReadResult
            protected DataReadResult method_1211(Status var1) {
                return DataReadResult.method_4223(var1, var2);
            }
        });
    }

    private static class class_1777 extends class_157.class_1544 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DataReadResult> field_4201;
        // $FF: renamed from: TL int
        private int field_4202;
        // $FF: renamed from: TM com.google.android.gms.fitness.result.DataReadResult
        private DataReadResult field_4203;

        private class_1777(BaseImplementation.class_1147<DataReadResult> var1) {
            this.field_4202 = 0;
            this.field_4203 = null;
            this.field_4201 = var1;
        }

        // $FF: synthetic method
        class_1777(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult) void
        public void method_788(DataReadResult param1) {
            // $FF: Couldn't be decompiled
        }
    }
}

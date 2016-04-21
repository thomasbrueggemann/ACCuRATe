package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.class_496;
import com.google.android.gms.fitness.request.class_500;
import com.google.android.gms.fitness.request.class_516;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.class_149;
import com.google.android.gms.internal.class_86;

// $FF: renamed from: com.google.android.gms.internal.kx
public class class_847 implements BleApi {
    public PendingResult<Status> claimBleDevice(GoogleApiClient var1, final BleDevice var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1231(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_776(new class_516(var2), var2x, var3);
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient var1, final String var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1230(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_776(new class_516(var2), var2x, var3);
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient var1) {
        return var1.method_897(new class_86.class_1401() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1218(class_86 var1) throws RemoteException {
                class_847.class_1583 var2 = new class_847.class_1583(this, null);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_786(var2, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1219(var1);
            }

            // $FF: renamed from: w (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.BleDevicesResult
            protected BleDevicesResult method_1219(Status var1) {
                return BleDevicesResult.method_3494(var1);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient var1, final StartBleScanRequest var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1233(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_770(var2, var2x, var3);
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient var1, final BleScanCallback var2) {
        return var1.method_897(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1234(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                class_500 var4 = new class_500(var2);
                var1.method_372().method_772(var4, var2x, var3);
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, BleDevice var2) {
        return this.unclaimBleDevice(var1, var2.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, final String var2) {
        return var1.method_899(new class_86.class_1403() {
            // $FF: renamed from: a (com.google.android.gms.internal.kk) void
            protected void method_1232(class_86 var1) throws RemoteException {
                class_86.class_1402 var2x = new class_86.class_1402(this);
                String var3 = var1.getContext().getPackageName();
                var1.method_372().method_774(new class_496(var2), var2x, var3);
            }
        });
    }

    private static class class_1583 extends class_149.class_1536 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<BleDevicesResult> field_3482;

        private class_1583(BaseImplementation.class_1147<BleDevicesResult> var1) {
            this.field_3482 = var1;
        }

        // $FF: synthetic method
        class_1583(BaseImplementation.class_1147 var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
        public void method_757(BleDevicesResult var1) {
            this.field_3482.method_120(var1);
        }
    }
}

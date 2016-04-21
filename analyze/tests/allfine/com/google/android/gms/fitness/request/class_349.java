package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.a;
import com.google.android.gms.fitness.request.class_50;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.fitness.request.a
public class class_349 extends class_50.class_1193 {
    // $FF: renamed from: Uf com.google.android.gms.fitness.request.BleScanCallback
    private final BleScanCallback field_1210;

    private class_349(BleScanCallback var1) {
        this.field_1210 = (BleScanCallback)class_1090.method_5685(var1);
    }

    // $FF: synthetic method
    class_349(BleScanCallback var1, Object var2) {
        this(var1);
    }

    public void onDeviceFound(BleDevice var1) throws RemoteException {
        this.field_1210.onDeviceFound(var1);
    }

    public void onScanStopped() throws RemoteException {
        this.field_1210.onScanStopped();
    }

    public static class class_1362 {
        // $FF: renamed from: Ug com.google.android.gms.fitness.request.a$a
        private static final class_349.class_1362 field_2940 = new class_349.class_1362();
        // $FF: renamed from: Uh java.util.Map
        private final Map<BleScanCallback, a> field_2941 = new HashMap();

        // $FF: renamed from: je () com.google.android.gms.fitness.request.a$a
        public static class_349.class_1362 method_3361() {
            return field_2940;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.BleScanCallback) com.google.android.gms.fitness.request.a
        public class_349 method_3362(BleScanCallback param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.fitness.request.BleScanCallback) com.google.android.gms.fitness.request.a
        public class_349 method_3363(BleScanCallback param1) {
            // $FF: Couldn't be decompiled
        }
    }
}

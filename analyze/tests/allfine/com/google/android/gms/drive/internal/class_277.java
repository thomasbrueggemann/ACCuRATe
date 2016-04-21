package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.class_276;

// $FF: renamed from: com.google.android.gms.drive.internal.bb
public class class_277 extends class_276 {
    // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
    private final BaseImplementation.class_1147<Status> field_832;

    public class_277(BaseImplementation.class_1147<Status> var1) {
        this.field_832 = var1;
    }

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    public void method_1012(Status var1) throws RemoteException {
        this.field_832.method_120(var1);
    }

    public void onSuccess() throws RemoteException {
        this.field_832.method_120(Status.field_4739);
    }
}

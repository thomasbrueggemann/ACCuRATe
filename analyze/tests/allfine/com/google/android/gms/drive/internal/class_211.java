package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.q;

// $FF: renamed from: com.google.android.gms.drive.internal.p
abstract class class_211<R extends Result> extends BaseImplementation.class_1146<R, q> {
    public class_211() {
        super(Drive.field_3554);
    }

    abstract static class class_1699 extends p<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1299(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        protected Status method_1299(Status var1) {
            return var1;
        }
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_156;
import com.google.android.gms.internal.kk;

// $FF: renamed from: com.google.android.gms.internal.kk
public interface class_86 extends Api.class_1478 {
    Context getContext();

    // $FF: renamed from: jb () com.google.android.gms.internal.kp
    class_156 method_372();

    public abstract static class class_1401<R extends Result> extends BaseImplementation.class_1146<R, kk> {
        public class_1401() {
            super(Fitness.field_4606);
        }
    }

    public static class class_1402 extends class_151.class_1528 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_4797;

        public class_1402(BaseImplementation.class_1147<Status> var1) {
            this.field_4797 = var1;
        }

        // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
        public void method_759(Status var1) {
            this.field_4797.method_120(var1);
        }
    }

    public abstract static class class_1403 extends class_86.class_1401<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1220(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        protected Status method_1220(Status var1) {
            boolean var2;
            if(!var1.isSuccess()) {
                var2 = true;
            } else {
                var2 = false;
            }

            class_1090.method_5675(var2);
            return var1;
        }
    }
}

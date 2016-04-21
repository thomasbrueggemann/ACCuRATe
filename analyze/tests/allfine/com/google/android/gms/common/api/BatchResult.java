package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_4281;
    // $FF: renamed from: IE com.google.android.gms.common.api.PendingResult[]
    private final PendingResult<?>[] field_4282;

    BatchResult(Status var1, PendingResult<?>[] var2) {
        this.field_4281 = var1;
        this.field_4282 = var2;
    }

    public Status getStatus() {
        return this.field_4281;
    }

    public <R extends Result> R take(BatchResultToken<R> var1) {
        boolean var2;
        if(var1.mId < this.field_4282.length) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5683(var2, "The result token does not belong to this batch");
        return this.field_4282[var1.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public interface PendingResult<R extends Result> {
    // $FF: renamed from: a (com.google.android.gms.common.api.PendingResult$a) void
    void method_877(PendingResult.class_1778 var1);

    R await();

    R await(long var1, TimeUnit var3);

    void cancel();

    boolean isCanceled();

    void setResultCallback(ResultCallback<R> var1);

    void setResultCallback(ResultCallback<R> var1, long var2, TimeUnit var4);

    public interface class_1778 {
        // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
        void method_895(Status var1);
    }
}

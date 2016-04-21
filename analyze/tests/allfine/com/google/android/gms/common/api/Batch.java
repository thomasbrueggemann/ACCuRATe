package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BaseImplementation.AbstractPendingResult<BatchResult> {
    // $FF: renamed from: IA int
    private int field_71;
    // $FF: renamed from: IB boolean
    private boolean field_72;
    // $FF: renamed from: IC boolean
    private boolean field_73;
    // $FF: renamed from: IE com.google.android.gms.common.api.PendingResult[]
    private final PendingResult<?>[] field_74;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_75;

    private Batch(List<PendingResult<?>> var1, Looper var2) {
        super(new BaseImplementation.CallbackHandler(var2));
        this.field_75 = new Object();
        this.field_71 = var1.size();
        this.field_74 = new PendingResult[this.field_71];

        for(int var3 = 0; var3 < var1.size(); ++var3) {
            PendingResult var4 = (PendingResult)var1.get(var3);
            this.field_74[var3] = var4;
            var4.method_877(new PendingResult.class_1778() {
                // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
                public void method_895(Status param1) {
                    // $FF: Couldn't be decompiled
                }
            });
        }

    }

    // $FF: synthetic method
    Batch(List var1, Looper var2, Object var3) {
        this(var1, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.Batch) java.lang.Object
    // $FF: synthetic method
    static Object method_1127(Batch var0) {
        return var0.field_75;
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.Batch, boolean) boolean
    // $FF: synthetic method
    static boolean method_1128(Batch var0, boolean var1) {
        var0.field_73 = var1;
        return var1;
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.Batch) int
    // $FF: synthetic method
    static int method_1129(Batch var0) {
        int var1 = var0.field_71;
        var0.field_71 = var1 - 1;
        return var1;
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.Batch, boolean) boolean
    // $FF: synthetic method
    static boolean method_1130(Batch var0, boolean var1) {
        var0.field_72 = var1;
        return var1;
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.Batch) int
    // $FF: synthetic method
    static int method_1131(Batch var0) {
        return var0.field_71;
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.Batch) boolean
    // $FF: synthetic method
    static boolean method_1132(Batch var0) {
        return var0.field_73;
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.Batch) void
    // $FF: synthetic method
    static void method_1133(Batch var0) {
        var0.cancel();
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.Batch) boolean
    // $FF: synthetic method
    static boolean method_1134(Batch var0) {
        return var0.field_72;
    }

    // $FF: renamed from: g (com.google.android.gms.common.api.Batch) com.google.android.gms.common.api.PendingResult[]
    // $FF: synthetic method
    static PendingResult[] method_1135(Batch var0) {
        return var0.field_74;
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
    // $FF: synthetic method
    public Result method_1104(Status var1) {
        return this.createFailedResult(var1);
    }

    public void cancel() {
        super.cancel();
        PendingResult[] var1 = this.field_74;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            var1[var3].cancel();
        }

    }

    public BatchResult createFailedResult(Status var1) {
        return new BatchResult(var1, this.field_74);
    }

    public static final class Builder {
        // $FF: renamed from: IG java.util.List
        private List<PendingResult<?>> field_5281 = new ArrayList();
        // $FF: renamed from: IH android.os.Looper
        private Looper field_5282;

        public Builder(GoogleApiClient var1) {
            this.field_5282 = var1.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> var1) {
            BatchResultToken var2 = new BatchResultToken(this.field_5281.size());
            this.field_5281.add(var1);
            return var2;
        }

        public Batch build() {
            return new Batch(this.field_5281, this.field_5282, null);
        }
    }
}

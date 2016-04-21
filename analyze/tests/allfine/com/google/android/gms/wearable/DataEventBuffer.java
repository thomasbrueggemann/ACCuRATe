package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.internal.class_258;

public class DataEventBuffer extends g<DataEvent> implements Result {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_1847;

    public DataEventBuffer(DataHolder var1) {
        super(var1);
        this.field_1847 = new Status(var1.getStatusCode());
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2912(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "path";
    }

    public Status getStatus() {
        return this.field_1847;
    }

    // $FF: renamed from: p (int, int) com.google.android.gms.wearable.DataEvent
    protected DataEvent method_2912(int var1, int var2) {
        return new class_258(this.II, var1, var2);
    }
}

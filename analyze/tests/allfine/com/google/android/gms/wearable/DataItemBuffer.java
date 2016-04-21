package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_256;

public class DataItemBuffer extends g<DataItem> implements Result {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_1846;

    public DataItemBuffer(DataHolder var1) {
        super(var1);
        this.field_1846 = new Status(var1.getStatusCode());
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2909(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "path";
    }

    public Status getStatus() {
        return this.field_1846;
    }

    // $FF: renamed from: q (int, int) com.google.android.gms.wearable.DataItem
    protected DataItem method_2909(int var1, int var2) {
        return new class_256(this.II, var1, var2);
    }
}

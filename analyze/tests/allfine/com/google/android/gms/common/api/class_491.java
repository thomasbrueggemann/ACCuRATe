package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// $FF: renamed from: com.google.android.gms.common.api.a
public abstract class class_491 implements Releasable, Result {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    protected final Status field_1989;
    // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
    protected final DataHolder field_1990;

    protected class_491(DataHolder var1) {
        this.field_1989 = new Status(var1.getStatusCode());
        this.field_1990 = var1;
    }

    public Status getStatus() {
        return this.field_1989;
    }

    public void release() {
        if(this.field_1990 != null) {
            this.field_1990.close();
        }

    }
}

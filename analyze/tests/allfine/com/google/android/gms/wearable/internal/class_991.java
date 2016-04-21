package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

// $FF: renamed from: com.google.android.gms.wearable.internal.g
public class class_991 implements DataEvent {
    // $FF: renamed from: FD int
    private int field_4579;
    private DataItem avs;

    public class_991(DataEvent var1) {
        this.field_4579 = var1.getType();
        this.avs = (DataItem)var1.getDataItem().freeze();
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5207();
    }

    public DataItem getDataItem() {
        return this.avs;
    }

    public int getType() {
        return this.field_4579;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: pW () com.google.android.gms.wearable.DataEvent
    public DataEvent method_5207() {
        return this;
    }
}

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_256;
import com.google.android.gms.wearable.internal.class_991;

// $FF: renamed from: com.google.android.gms.wearable.internal.h
public final class class_258 extends class_255 implements DataEvent {
    private final int aaK;

    public class_258(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.aaK = var3;
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1661();
    }

    public DataItem getDataItem() {
        return new class_256(this.II, this.JX, this.aaK);
    }

    public int getType() {
        return this.getInteger("event_type");
    }

    // $FF: renamed from: pW () com.google.android.gms.wearable.DataEvent
    public DataEvent method_1661() {
        return new class_991(this);
    }
}

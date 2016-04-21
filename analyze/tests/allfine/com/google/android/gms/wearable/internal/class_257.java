package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_990;

// $FF: renamed from: com.google.android.gms.wearable.internal.k
public class class_257 extends class_255 implements DataItemAsset {
    public class_257(DataHolder var1, int var2) {
        super(var1, var2);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1660();
    }

    public String getDataItemKey() {
        return this.getString("asset_key");
    }

    public String getId() {
        return this.getString("asset_id");
    }

    // $FF: renamed from: pX () com.google.android.gms.wearable.DataItemAsset
    public DataItemAsset method_1660() {
        return new class_990(this);
    }
}

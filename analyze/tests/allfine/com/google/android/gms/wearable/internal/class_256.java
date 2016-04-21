package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_257;
import com.google.android.gms.wearable.internal.class_994;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.wearable.internal.o
public final class class_256 extends class_255 implements DataItem {
    private final int aaK;

    public class_256(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.aaK = var3;
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1659();
    }

    public Map<String, DataItemAsset> getAssets() {
        HashMap var1 = new HashMap(this.aaK);

        for(int var2 = 0; var2 < this.aaK; ++var2) {
            class_257 var3 = new class_257(this.II, var2 + this.JX);
            if(var3.getDataItemKey() != null) {
                var1.put(var3.getDataItemKey(), var3);
            }
        }

        return var1;
    }

    public byte[] getData() {
        return this.getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(this.getString("path"));
    }

    // $FF: renamed from: pY () com.google.android.gms.wearable.DataItem
    public DataItem method_1659() {
        return new class_994(this);
    }

    public DataItem setData(byte[] var1) {
        throw new UnsupportedOperationException();
    }
}

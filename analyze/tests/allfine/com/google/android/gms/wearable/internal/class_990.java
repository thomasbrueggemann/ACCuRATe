package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

// $FF: renamed from: com.google.android.gms.wearable.internal.i
public class class_990 implements DataItemAsset {
    // $FF: renamed from: BL java.lang.String
    private final String field_4577;
    // $FF: renamed from: JO java.lang.String
    private final String field_4578;

    public class_990(DataItemAsset var1) {
        this.field_4577 = var1.getId();
        this.field_4578 = var1.getDataItemKey();
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5206();
    }

    public String getDataItemKey() {
        return this.field_4578;
    }

    public String getId() {
        return this.field_4577;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: pX () com.google.android.gms.wearable.DataItemAsset
    public DataItemAsset method_5206() {
        return this;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("DataItemAssetEntity[");
        var1.append("@");
        var1.append(Integer.toHexString(this.hashCode()));
        if(this.field_4577 == null) {
            var1.append(",noid");
        } else {
            var1.append(",");
            var1.append(this.field_4577);
        }

        var1.append(", key=");
        var1.append(this.field_4578);
        var1.append("]");
        return var1.toString();
    }
}

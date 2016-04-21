package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_995;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new class_995();
    // $FF: renamed from: BL java.lang.String
    private final String field_4481;
    // $FF: renamed from: BR int
    final int field_4482;
    // $FF: renamed from: JO java.lang.String
    private final String field_4483;

    DataItemAssetParcelable(int var1, String var2, String var3) {
        this.field_4482 = var1;
        this.field_4481 = var2;
        this.field_4483 = var3;
    }

    public DataItemAssetParcelable(DataItemAsset var1) {
        this.field_4482 = 1;
        this.field_4481 = (String)class_1090.method_5685(var1.getId());
        this.field_4483 = (String)class_1090.method_5685(var1.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5049();
    }

    public String getDataItemKey() {
        return this.field_4483;
    }

    public String getId() {
        return this.field_4481;
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: pX () com.google.android.gms.wearable.DataItemAsset
    public DataItemAsset method_5049() {
        return this;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("DataItemAssetParcelable[");
        var1.append("@");
        var1.append(Integer.toHexString(this.hashCode()));
        if(this.field_4481 == null) {
            var1.append(",noid");
        } else {
            var1.append(",");
            var1.append(this.field_4481);
        }

        var1.append(", key=");
        var1.append(this.field_4483);
        var1.append("]");
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_995.method_5215(this, var1, var2);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.class_836;
import com.google.android.gms.internal.lg;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lg
public class class_841 implements SafeParcelable {
    public static final Creator<lg> CREATOR = new class_836();
    // $FF: renamed from: BR int
    private final int field_4127;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_4128;

    class_841(int var1, List<DataType> var2) {
        this.field_4127 = var1;
        this.field_4128 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.field_4128);
    }

    int getVersionCode() {
        return this.field_4127;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("dataTypes", this.field_4128).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_836.method_4457(this, var1, var2);
    }
}

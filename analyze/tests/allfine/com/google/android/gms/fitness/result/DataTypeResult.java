package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_1013;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new class_1013();
    // $FF: renamed from: BR int
    private final int field_4992;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_4993;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_4994;

    DataTypeResult(int var1, Status var2, DataType var3) {
        this.field_4992 = var1;
        this.field_4993 = var2;
        this.field_4994 = var3;
    }

    public DataTypeResult(Status var1, DataType var2) {
        this.field_4992 = 2;
        this.field_4993 = var1;
        this.field_4994 = var2;
    }

    // $FF: renamed from: F (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
    public static DataTypeResult method_5517(Status var0) {
        return new DataTypeResult(var0, (DataType)null);
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.DataTypeResult) boolean
    private boolean method_5518(DataTypeResult var1) {
        return this.field_4993.equals(var1.field_4993) && class_1089.equal(this.field_4994, var1.field_4994);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataTypeResult && this.method_5518((DataTypeResult)var1);
    }

    public DataType getDataType() {
        return this.field_4994;
    }

    public Status getStatus() {
        return this.field_4993;
    }

    int getVersionCode() {
        return this.field_4992;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4993, this.field_4994};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_4993).method_5425("dataType", this.field_4994).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1013.method_5292(this, var1, var2);
    }
}

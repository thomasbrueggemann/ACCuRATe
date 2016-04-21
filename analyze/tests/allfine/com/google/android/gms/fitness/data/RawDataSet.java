package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.class_1132;
import com.google.android.gms.fitness.data.class_1143;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new class_1132();
    // $FF: renamed from: BR int
    final int field_3286;
    // $FF: renamed from: SF boolean
    final boolean field_3287;
    // $FF: renamed from: Tm int
    final int field_3288;
    // $FF: renamed from: To int
    final int field_3289;
    // $FF: renamed from: Tp java.util.List
    final List<RawDataPoint> field_3290;

    RawDataSet(int var1, int var2, int var3, List<RawDataPoint> var4, boolean var5) {
        this.field_3286 = var1;
        this.field_3288 = var2;
        this.field_3289 = var3;
        this.field_3290 = var4;
        this.field_3287 = var5;
    }

    public RawDataSet(DataSet var1, List<DataSource> var2, List<DataType> var3) {
        this.field_3286 = 2;
        this.field_3290 = var1.method_5282(var2);
        this.field_3287 = var1.method_5283();
        this.field_3288 = class_1143.method_5944(var1.getDataSource(), var2);
        this.field_3289 = class_1143.method_5944(var1.getDataType(), var3);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataSet) boolean
    private boolean method_3753(RawDataSet var1) {
        return this.field_3288 == var1.field_3288 && this.field_3289 == var1.field_3289 && this.field_3287 == var1.field_3287 && class_1089.equal(this.field_3290, var1.field_3290);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof RawDataSet && this.method_3753((RawDataSet)var1);
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_3288), Integer.valueOf(this.field_3289)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_3288), Integer.valueOf(this.field_3289), this.field_3290};
        return String.format("RawDataSet{%s@[%s, %s]}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1132.method_5886(this, var1, var2);
    }
}

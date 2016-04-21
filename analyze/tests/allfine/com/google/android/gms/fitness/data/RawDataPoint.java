package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.class_1133;
import com.google.android.gms.fitness.data.class_1143;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new class_1133();
    // $FF: renamed from: BR int
    final int field_5055;
    // $FF: renamed from: SG long
    final long field_5056;
    // $FF: renamed from: SH long
    final long field_5057;
    // $FF: renamed from: SI com.google.android.gms.fitness.data.Value[]
    final Value[] field_5058;
    // $FF: renamed from: SK long
    final long field_5059;
    // $FF: renamed from: SL long
    final long field_5060;
    // $FF: renamed from: Tm int
    final int field_5061;
    // $FF: renamed from: Tn int
    final int field_5062;

    RawDataPoint(int var1, long var2, long var4, Value[] var6, int var7, int var8, long var9, long var11) {
        this.field_5055 = var1;
        this.field_5056 = var2;
        this.field_5057 = var4;
        this.field_5061 = var7;
        this.field_5062 = var8;
        this.field_5059 = var9;
        this.field_5060 = var11;
        this.field_5058 = var6;
    }

    RawDataPoint(DataPoint var1, List<DataSource> var2) {
        this.field_5055 = 4;
        this.field_5056 = var1.getTimestamp(TimeUnit.NANOSECONDS);
        this.field_5057 = var1.getStartTime(TimeUnit.NANOSECONDS);
        this.field_5058 = var1.method_4477();
        this.field_5061 = class_1143.method_5944(var1.getDataSource(), var2);
        this.field_5062 = class_1143.method_5944(var1.getOriginalDataSource(), var2);
        this.field_5059 = var1.method_4478();
        this.field_5060 = var1.method_4479();
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.RawDataPoint) boolean
    private boolean method_5565(RawDataPoint var1) {
        return this.field_5056 == var1.field_5056 && this.field_5057 == var1.field_5057 && Arrays.equals(this.field_5058, var1.field_5058) && this.field_5061 == var1.field_5061 && this.field_5062 == var1.field_5062 && this.field_5059 == var1.field_5059;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof RawDataPoint && this.method_5565((RawDataPoint)var1);
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_5056), Long.valueOf(this.field_5057)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        Object[] var1 = new Object[] {Arrays.toString(this.field_5058), Long.valueOf(this.field_5057), Long.valueOf(this.field_5056), Integer.valueOf(this.field_5061), Integer.valueOf(this.field_5062)};
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1133.method_5889(this, var1, var2);
    }
}

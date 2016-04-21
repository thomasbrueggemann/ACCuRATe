package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.data.class_1127;
import com.google.android.gms.internal.class_851;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR = new class_1127();
    // $FF: renamed from: BR int
    private final int field_4140;
    // $FF: renamed from: SG long
    private long field_4141;
    // $FF: renamed from: SH long
    private long field_4142;
    // $FF: renamed from: SI com.google.android.gms.fitness.data.Value[]
    private final Value[] field_4143;
    // $FF: renamed from: SJ com.google.android.gms.fitness.data.DataSource
    private DataSource field_4144;
    // $FF: renamed from: SK long
    private long field_4145;
    // $FF: renamed from: SL long
    private long field_4146;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4147;

    DataPoint(int var1, DataSource var2, long var3, long var5, Value[] var7, DataSource var8, long var9, long var11) {
        this.field_4140 = var1;
        this.field_4147 = var2;
        this.field_4144 = var8;
        this.field_4141 = var3;
        this.field_4142 = var5;
        this.field_4143 = var7;
        this.field_4145 = var9;
        this.field_4146 = var11;
    }

    private DataPoint(DataSource var1) {
        this.field_4140 = 4;
        this.field_4147 = (DataSource)class_1090.method_5681(var1, "Data source cannot be null");
        List var2 = var1.getDataType().getFields();
        this.field_4143 = new Value[var2.size()];
        Iterator var3 = var2.iterator();

        for(int var4 = 0; var3.hasNext(); ++var4) {
            Field var5 = (Field)var3.next();
            this.field_4143[var4] = new Value(var5.getFormat());
        }

    }

    DataPoint(List<DataSource> var1, RawDataPoint var2) {
        this(4, method_4473(var1, var2.field_5061), var2.field_5056, var2.field_5057, var2.field_5058, method_4473(var1, var2.field_5062), var2.field_5059, var2.field_5060);
    }

    // $FF: renamed from: a (java.util.List, int) com.google.android.gms.fitness.data.DataSource
    private static DataSource method_4473(List<DataSource> var0, int var1) {
        return var1 >= 0 && var1 < var0.size()?(DataSource)var0.get(var1):null;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataPoint) boolean
    private boolean method_4474(DataPoint var1) {
        return class_1089.equal(this.field_4147, var1.field_4147) && this.field_4141 == var1.field_4141 && this.field_4142 == var1.field_4142 && Arrays.equals(this.field_4143, var1.field_4143) && class_1089.equal(this.field_4144, var1.field_4144);
    }

    // $FF: renamed from: cA (int) void
    private void method_4475(int var1) {
        List var2 = this.getDataType().getFields();
        int var3 = var2.size();
        boolean var4;
        if(var1 == var3) {
            var4 = true;
        } else {
            var4 = false;
        }

        Object[] var5 = new Object[] {Integer.valueOf(var1), Integer.valueOf(var3), var2};
        class_1090.method_5684(var4, "Attempting to insert %s values, but needed %s: %s", var5);
    }

    public static DataPoint create(DataSource var0) {
        return new DataPoint(var0);
    }

    public static DataPoint extract(Intent var0) {
        return var0 == null?null:(DataPoint)class_822.method_4294(var0, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    // $FF: renamed from: iF () boolean
    private boolean method_4476() {
        return this.getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataPoint && this.method_4474((DataPoint)var1);
    }

    public DataSource getDataSource() {
        return this.field_4147;
    }

    public DataType getDataType() {
        return this.field_4147.getDataType();
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_4141, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.field_4144;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_4142, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit var1) {
        return var1.convert(this.field_4141, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.field_4141;
    }

    public Value getValue(Field var1) {
        int var2 = this.getDataType().indexOf(var1);
        return this.field_4143[var2];
    }

    public int getVersionCode() {
        return this.field_4140;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4147, Long.valueOf(this.field_4141), Long.valueOf(this.field_4142)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iG () com.google.android.gms.fitness.data.Value[]
    public Value[] method_4477() {
        return this.field_4143;
    }

    // $FF: renamed from: iH () long
    public long method_4478() {
        return this.field_4145;
    }

    // $FF: renamed from: iI () long
    public long method_4479() {
        return this.field_4146;
    }

    // $FF: renamed from: iJ () long
    public long method_4480() {
        return this.field_4142;
    }

    public DataPoint setFloatValues(float... var1) {
        this.method_4475(var1.length);

        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.field_4143[var2].setFloat(var1[var2]);
        }

        return this;
    }

    public DataPoint setIntValues(int... var1) {
        this.method_4475(var1.length);

        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.field_4143[var2].setInt(var1[var2]);
        }

        return this;
    }

    public DataPoint setTimeInterval(long var1, long var3, TimeUnit var5) {
        this.field_4142 = var5.toNanos(var1);
        this.field_4141 = var5.toNanos(var3);
        return this;
    }

    public DataPoint setTimestamp(long var1, TimeUnit var3) {
        this.field_4141 = var3.toNanos(var1);
        if(this.method_4476() && class_851.method_4490(var3)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.field_4141 = class_851.method_4489(this.field_4141, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }

        return this;
    }

    public String toString() {
        Object[] var1 = new Object[] {Arrays.toString(this.field_4143), Long.valueOf(this.field_4142), Long.valueOf(this.field_4141), Long.valueOf(this.field_4145), Long.valueOf(this.field_4146), this.field_4147, this.field_4144};
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1127.method_5871(this, var1, var2);
    }
}

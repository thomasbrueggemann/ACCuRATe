package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.class_1126;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new class_1126();
    // $FF: renamed from: BR int
    private final int field_4678;
    // $FF: renamed from: SF boolean
    private boolean field_4679;
    // $FF: renamed from: SM java.util.List
    private final List<DataPoint> field_4680;
    // $FF: renamed from: SN java.util.List
    private final List<DataSource> field_4681;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_4682;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4683;

    DataSet(int var1, DataSource var2, DataType var3, List<RawDataPoint> var4, List<DataSource> var5, boolean var6) {
        this.field_4679 = false;
        this.field_4678 = var1;
        this.field_4683 = var2;
        this.field_4682 = var3;
        this.field_4679 = var6;
        this.field_4680 = new ArrayList(var4.size());
        if(var1 < 2) {
            var5 = Collections.singletonList(var2);
        }

        this.field_4681 = var5;
        Iterator var7 = var4.iterator();

        while(var7.hasNext()) {
            RawDataPoint var8 = (RawDataPoint)var7.next();
            this.field_4680.add(new DataPoint(this.field_4681, var8));
        }

    }

    private DataSet(DataSource var1, DataType var2) {
        this.field_4679 = false;
        this.field_4678 = 3;
        this.field_4683 = (DataSource)class_1090.method_5685(var1);
        this.field_4682 = (DataType)class_1090.method_5685(var2);
        this.field_4680 = new ArrayList();
        this.field_4681 = new ArrayList();
        this.field_4681.add(this.field_4683);
    }

    public DataSet(RawDataSet var1, List<DataSource> var2, List<DataType> var3) {
        this(3, (DataSource)method_5279(var2, var1.field_3288), (DataType)method_5279(var3, var1.field_3289), var1.field_3290, var2, var1.field_3287);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSet) boolean
    private boolean method_5278(DataSet var1) {
        return class_1089.equal(this.field_4682, var1.field_4682) && class_1089.equal(this.field_4683, var1.field_4683) && class_1089.equal(this.field_4680, var1.field_4680) && this.field_4679 == var1.field_4679;
    }

    // $FF: renamed from: b (java.util.List, int) java.lang.Object
    private static <T> T method_5279(List<T> var0, int var1) {
        return var1 >= 0 && var1 < var0.size()?var0.get(var1):null;
    }

    public static DataSet create(DataSource var0) {
        class_1090.method_5681(var0, "DataSource should be specified");
        return new DataSet(var0, var0.getDataType());
    }

    // $FF: renamed from: a (java.lang.Iterable) void
    public void method_5280(Iterable<DataPoint> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            this.method_5281((DataPoint)var2.next());
        }

    }

    public void add(DataPoint var1) {
        DataSource var2 = var1.getDataSource();
        boolean var3 = var2.getStreamIdentifier().equals(this.field_4683.getStreamIdentifier());
        Object[] var4 = new Object[] {var2, this.field_4683};
        class_1090.method_5684(var3, "Conflicting data sources found %s vs %s", var4);
        boolean var5 = var1.getDataType().getName().equals(this.field_4682.getName());
        Object[] var6 = new Object[] {var1.getDataType(), this.field_4682};
        class_1090.method_5684(var5, "Conflicting data types found %s vs %s", var6);
        boolean var7;
        if(var1.getTimestamp(TimeUnit.NANOSECONDS) > 0L) {
            var7 = true;
        } else {
            var7 = false;
        }

        class_1090.method_5684(var7, "Data point does not have the timestamp set: %s", new Object[] {var1});
        boolean var8;
        if(var1.getStartTime(TimeUnit.NANOSECONDS) <= var1.getEndTime(TimeUnit.NANOSECONDS)) {
            var8 = true;
        } else {
            var8 = false;
        }

        class_1090.method_5684(var8, "Data point with start time greater than end time found: %s", new Object[] {var1});
        this.method_5281(var1);
    }

    public void addAll(Iterable<DataPoint> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            this.add((DataPoint)var2.next());
        }

    }

    // $FF: renamed from: b (com.google.android.gms.fitness.data.DataPoint) void
    public void method_5281(DataPoint var1) {
        this.field_4680.add(var1);
        DataSource var3 = var1.getOriginalDataSource();
        if(var3 != null && !this.field_4681.contains(var3)) {
            this.field_4681.add(var3);
        }

    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.field_4683);
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: e (java.util.List) java.util.List
    List<RawDataPoint> method_5282(List<DataSource> var1) {
        ArrayList var2 = new ArrayList(this.field_4680.size());
        Iterator var3 = this.field_4680.iterator();

        while(var3.hasNext()) {
            var2.add(new RawDataPoint((DataPoint)var3.next(), var1));
        }

        return var2;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof DataSet && this.method_5278((DataSet)var1);
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.field_4680);
    }

    public DataSource getDataSource() {
        return this.field_4683;
    }

    public DataType getDataType() {
        return this.field_4682;
    }

    int getVersionCode() {
        return this.field_4678;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4682, this.field_4683};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iC () boolean
    public boolean method_5283() {
        return this.field_4679;
    }

    // $FF: renamed from: iK () java.util.List
    List<RawDataPoint> method_5284() {
        return this.method_5282(this.field_4681);
    }

    // $FF: renamed from: iL () java.util.List
    List<DataSource> method_5285() {
        return this.field_4681;
    }

    public String toString() {
        Object var1 = this.method_5284();
        Object[] var2 = new Object[] {this.field_4683.toDebugString(), null};
        if(this.field_4680.size() >= 10) {
            Object[] var3 = new Object[] {Integer.valueOf(this.field_4680.size()), ((List)var1).subList(0, 5)};
            var1 = String.format("%d data points, first 5: %s", var3);
        }

        var2[1] = var1;
        return String.format("DataSet{%s %s}", var2);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1126.method_5868(this, var1, var2);
    }
}

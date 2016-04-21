package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1134;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR = new class_1134();
    // $FF: renamed from: BR int
    final int field_1047;
    // $FF: renamed from: KS long
    final long field_1048;
    // $FF: renamed from: SD java.util.List
    final List<RawDataSet> field_1049;
    // $FF: renamed from: SE int
    final int field_1050;
    // $FF: renamed from: SF boolean
    final boolean field_1051;
    // $FF: renamed from: Sr long
    final long field_1052;
    // $FF: renamed from: St com.google.android.gms.fitness.data.Session
    final Session field_1053;
    // $FF: renamed from: Tl int
    final int field_1054;

    RawBucket(int var1, long var2, long var4, Session var6, int var7, List<RawDataSet> var8, int var9, boolean var10) {
        this.field_1047 = var1;
        this.field_1048 = var2;
        this.field_1052 = var4;
        this.field_1053 = var6;
        this.field_1054 = var7;
        this.field_1049 = var8;
        this.field_1050 = var9;
        this.field_1051 = var10;
    }

    public RawBucket(Bucket var1, List<DataSource> var2, List<DataType> var3) {
        this.field_1047 = 2;
        this.field_1048 = var1.getStartTime(TimeUnit.MILLISECONDS);
        this.field_1052 = var1.getEndTime(TimeUnit.MILLISECONDS);
        this.field_1053 = var1.getSession();
        this.field_1054 = var1.method_5194();
        this.field_1050 = var1.getBucketType();
        this.field_1051 = var1.method_5195();
        List var4 = var1.getDataSets();
        this.field_1049 = new ArrayList(var4.size());
        Iterator var5 = var4.iterator();

        while(var5.hasNext()) {
            DataSet var6 = (DataSet)var5.next();
            this.field_1049.add(new RawDataSet(var6, var2, var3));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.RawBucket) boolean
    private boolean method_2223(RawBucket var1) {
        return this.field_1048 == var1.field_1048 && this.field_1052 == var1.field_1052 && this.field_1054 == var1.field_1054 && class_1089.equal(this.field_1049, var1.field_1049) && this.field_1050 == var1.field_1050 && this.field_1051 == var1.field_1051;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof RawBucket && this.method_2223((RawBucket)var1);
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_1048), Long.valueOf(this.field_1052), Integer.valueOf(this.field_1050)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("startTime", Long.valueOf(this.field_1048)).method_5425("endTime", Long.valueOf(this.field_1052)).method_5425("activity", Integer.valueOf(this.field_1054)).method_5425("dataSets", this.field_1049).method_5425("bucketType", Integer.valueOf(this.field_1050)).method_5425("serverHasMoreData", Boolean.valueOf(this.field_1051)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1134.method_5892(this, var1, var2);
    }
}

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1128;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR = new class_1128();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    // $FF: renamed from: BR int
    private final int field_4542;
    // $FF: renamed from: KS long
    private final long field_4543;
    // $FF: renamed from: SC int
    private final int field_4544;
    // $FF: renamed from: SD java.util.List
    private final List<DataSet> field_4545;
    // $FF: renamed from: SE int
    private final int field_4546;
    // $FF: renamed from: SF boolean
    private boolean field_4547;
    // $FF: renamed from: Sr long
    private final long field_4548;
    // $FF: renamed from: St com.google.android.gms.fitness.data.Session
    private final Session field_4549;

    Bucket(int var1, long var2, long var4, Session var6, int var7, List<DataSet> var8, int var9, boolean var10) {
        this.field_4547 = false;
        this.field_4542 = var1;
        this.field_4543 = var2;
        this.field_4548 = var4;
        this.field_4549 = var6;
        this.field_4544 = var7;
        this.field_4545 = var8;
        this.field_4546 = var9;
        this.field_4547 = var10;
    }

    public Bucket(RawBucket var1, List<DataSource> var2, List<DataType> var3) {
        this(2, var1.field_1048, var1.field_1052, var1.field_1053, var1.field_1054, method_5190(var1.field_1049, var2, var3), var1.field_1050, var1.field_1051);
    }

    // $FF: renamed from: a (java.util.List, java.util.List, java.util.List) java.util.List
    private static List<DataSet> method_5190(List<RawDataSet> var0, List<DataSource> var1, List<DataType> var2) {
        ArrayList var3 = new ArrayList(var0.size());
        Iterator var4 = var0.iterator();

        while(var4.hasNext()) {
            var3.add(new DataSet((RawDataSet)var4.next(), var1, var2));
        }

        return var3;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Bucket) boolean
    private boolean method_5191(Bucket var1) {
        return this.field_4543 == var1.field_4543 && this.field_4548 == var1.field_4548 && this.field_4544 == var1.field_4544 && class_1089.equal(this.field_4545, var1.field_4545) && this.field_4546 == var1.field_4546 && this.field_4547 == var1.field_4547;
    }

    // $FF: renamed from: cy (int) java.lang.String
    public static String method_5192(int var0) {
        switch(var0) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.data.Bucket) boolean
    public boolean method_5193(Bucket var1) {
        return this.field_4543 == var1.field_4543 && this.field_4548 == var1.field_4548 && this.field_4544 == var1.field_4544 && this.field_4546 == var1.field_4546;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof Bucket && this.method_5191((Bucket)var1);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.field_4544);
    }

    public int getBucketType() {
        return this.field_4546;
    }

    public DataSet getDataSet(DataType var1) {
        Iterator var2 = this.field_4545.iterator();

        DataSet var3;
        do {
            if(!var2.hasNext()) {
                return null;
            }

            var3 = (DataSet)var2.next();
        } while(!var3.getDataType().equals(var1));

        return var3;
    }

    public List<DataSet> getDataSets() {
        return this.field_4545;
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_4548, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.field_4549;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_4543, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.field_4542;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_4543), Long.valueOf(this.field_4548), Integer.valueOf(this.field_4544), Integer.valueOf(this.field_4546)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iB () int
    public int method_5194() {
        return this.field_4544;
    }

    // $FF: renamed from: iC () boolean
    public boolean method_5195() {
        if(this.field_4547) {
            return true;
        } else {
            Iterator var1 = this.field_4545.iterator();

            do {
                if(!var1.hasNext()) {
                    return false;
                }
            } while(!((DataSet)var1.next()).method_5283());

            return true;
        }
    }

    // $FF: renamed from: iD () long
    public long method_5196() {
        return this.field_4543;
    }

    // $FF: renamed from: iE () long
    public long method_5197() {
        return this.field_4548;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("startTime", Long.valueOf(this.field_4543)).method_5425("endTime", Long.valueOf(this.field_4548)).method_5425("activity", Integer.valueOf(this.field_4544)).method_5425("dataSets", this.field_4545).method_5425("bucketType", method_5192(this.field_4546)).method_5425("serverHasMoreData", Boolean.valueOf(this.field_4547)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1128.method_5874(this, var1, var2);
    }
}

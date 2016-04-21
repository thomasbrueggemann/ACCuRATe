package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_1014;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR = new class_1014();
    // $FF: renamed from: BR int
    private final int field_3157;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_3158;
    // $FF: renamed from: Uk java.util.List
    private final List<DataSource> field_3159;

    DataSourcesResult(int var1, List<DataSource> var2, Status var3) {
        this.field_3157 = var1;
        this.field_3159 = Collections.unmodifiableList(var2);
        this.field_3158 = var3;
    }

    public DataSourcesResult(List<DataSource> var1, Status var2) {
        this.field_3157 = 3;
        this.field_3159 = Collections.unmodifiableList(var1);
        this.field_3158 = var2;
    }

    // $FF: renamed from: E (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataSourcesResult
    public static DataSourcesResult method_3574(Status var0) {
        return new DataSourcesResult(Collections.emptyList(), var0);
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.DataSourcesResult) boolean
    private boolean method_3575(DataSourcesResult var1) {
        return this.field_3158.equals(var1.field_3158) && class_1089.equal(this.field_3159, var1.field_3159);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataSourcesResult && this.method_3575((DataSourcesResult)var1);
    }

    public List<DataSource> getDataSources() {
        return this.field_3159;
    }

    public List<DataSource> getDataSources(DataType var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.field_3159.iterator();

        while(var3.hasNext()) {
            DataSource var4 = (DataSource)var3.next();
            if(var4.getDataType().equals(var1)) {
                var2.add(var4);
            }
        }

        return Collections.unmodifiableList(var2);
    }

    public Status getStatus() {
        return this.field_3158;
    }

    int getVersionCode() {
        return this.field_3157;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_3158, this.field_3159};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_3158).method_5425("dataSets", this.field_3159).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1014.method_5295(this, var1, var2);
    }
}

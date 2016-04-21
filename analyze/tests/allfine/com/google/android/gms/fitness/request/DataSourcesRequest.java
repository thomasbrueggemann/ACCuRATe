package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_515;
import com.google.android.gms.internal.class_348;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new class_515();
    // $FF: renamed from: BR int
    private final int field_4379;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_4380;
    // $FF: renamed from: Uw java.util.List
    private final List<Integer> field_4381;
    // $FF: renamed from: Ux boolean
    private final boolean field_4382;

    DataSourcesRequest(int var1, List<DataType> var2, List<Integer> var3, boolean var4) {
        this.field_4379 = var1;
        this.field_4380 = var2;
        this.field_4381 = var3;
        this.field_4382 = var4;
    }

    private DataSourcesRequest(DataSourcesRequest.Builder var1) {
        this.field_4379 = 2;
        this.field_4380 = class_348.method_2341(var1.field_4104);
        this.field_4381 = Arrays.asList(class_348.method_2340(var1.field_4105));
        this.field_4382 = var1.field_4103;
    }

    // $FF: synthetic method
    DataSourcesRequest(DataSourcesRequest.Builder var1, Object var2) {
        this(var1);
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.field_4380);
    }

    int getVersionCode() {
        return this.field_4379;
    }

    // $FF: renamed from: jo () boolean
    public boolean method_4974() {
        return this.field_4382;
    }

    // $FF: renamed from: jp () java.util.List
    List<Integer> method_4975() {
        return this.field_4381;
    }

    public String toString() {
        class_1089.class_1785 var1 = class_1089.method_5673(this).method_5425("dataTypes", this.field_4380).method_5425("sourceTypes", this.field_4381);
        if(this.field_4382) {
            var1.method_5425("includeDbOnlySources", "true");
        }

        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_515.method_3134(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: Ux boolean
        private boolean field_4103 = false;
        // $FF: renamed from: Uy com.google.android.gms.fitness.data.DataType[]
        private DataType[] field_4104 = new DataType[0];
        // $FF: renamed from: Uz int[]
        private int[] field_4105 = new int[] {0, 1};

        public DataSourcesRequest build() {
            boolean var1 = true;
            boolean var2;
            if(this.field_4104.length > 0) {
                var2 = var1;
            } else {
                var2 = false;
            }

            class_1090.method_5676(var2, "Must add at least one data type");
            if(this.field_4105.length <= 0) {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public DataSourcesRequest.Builder setDataSourceTypes(int... var1) {
            this.field_4105 = var1;
            return this;
        }

        public DataSourcesRequest.Builder setDataTypes(DataType... var1) {
            this.field_4104 = var1;
            return this;
        }
    }
}

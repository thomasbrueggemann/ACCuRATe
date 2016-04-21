package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.class_945;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new class_945();
    // $FF: renamed from: BR int
    final int field_4095;
    // $FF: renamed from: QB com.google.android.gms.drive.query.internal.LogicalFilter
    final LogicalFilter field_4096;
    // $FF: renamed from: QC java.lang.String
    final String field_4097;
    // $FF: renamed from: QD com.google.android.gms.drive.query.SortOrder
    final SortOrder field_4098;
    // $FF: renamed from: QE java.util.List
    final List<String> field_4099;

    Query(int var1, LogicalFilter var2, String var3, SortOrder var4, List<String> var5) {
        this.field_4095 = var1;
        this.field_4096 = var2;
        this.field_4097 = var3;
        this.field_4098 = var4;
        this.field_4099 = var5;
    }

    Query(LogicalFilter var1, String var2, SortOrder var3, List<String> var4) {
        this(1, var1, var2, var3, var4);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.field_4096;
    }

    public String getPageToken() {
        return this.field_4097;
    }

    public SortOrder getSortOrder() {
        return this.field_4098;
    }

    // $FF: renamed from: iq () java.util.List
    public List<String> method_4427() {
        return this.field_4099;
    }

    public String toString() {
        Locale var1 = Locale.US;
        Object[] var2 = new Object[] {this.field_4096, this.field_4098, this.field_4097};
        return String.format(var1, "Query[%s,%s,PageToken=%s]", var2);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_945.method_4933(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: QC java.lang.String
        private String field_3053;
        // $FF: renamed from: QD com.google.android.gms.drive.query.SortOrder
        private SortOrder field_3054;
        // $FF: renamed from: QE java.util.List
        private List<String> field_3055;
        // $FF: renamed from: QF java.util.List
        private final List<Filter> field_3056 = new ArrayList();

        public Builder() {
        }

        public Builder(Query var1) {
            this.field_3056.add(var1.getFilter());
            this.field_3053 = var1.getPageToken();
            this.field_3054 = var1.getSortOrder();
            this.field_3055 = var1.method_4427();
        }

        public Query.Builder addFilter(Filter var1) {
            if(!(var1 instanceof MatchAllFilter)) {
                this.field_3056.add(var1);
            }

            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.field_4763, this.field_3056), this.field_3053, this.field_3054, this.field_3055);
        }

        public Query.Builder setPageToken(String var1) {
            this.field_3053 = var1;
            return this;
        }

        public Query.Builder setSortOrder(SortOrder var1) {
            this.field_3054 = var1;
            return this;
        }
    }
}

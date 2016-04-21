package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_1043;
import com.google.android.gms.drive.query.internal.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new class_1043();
    // $FF: renamed from: BR int
    final int field_2025;
    // $FF: renamed from: QF java.util.List
    private List<Filter> field_2026;
    // $FF: renamed from: QK com.google.android.gms.drive.query.internal.Operator
    final Operator field_2027;
    // $FF: renamed from: QX java.util.List
    final List<FilterHolder> field_2028;

    LogicalFilter(int var1, Operator var2, List<FilterHolder> var3) {
        this.field_2025 = var1;
        this.field_2027 = var2;
        this.field_2028 = var3;
    }

    public LogicalFilter(Operator var1, Filter var2, Filter... var3) {
        this.field_2025 = 1;
        this.field_2027 = var1;
        this.field_2028 = new ArrayList(1 + var3.length);
        this.field_2028.add(new FilterHolder(var2));
        this.field_2026 = new ArrayList(1 + var3.length);
        this.field_2026.add(var2);
        int var6 = var3.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Filter var8 = var3[var7];
            this.field_2028.add(new FilterHolder(var8));
            this.field_2026.add(var8);
        }

    }

    public LogicalFilter(Operator var1, Iterable<Filter> var2) {
        this.field_2025 = 1;
        this.field_2027 = var1;
        this.field_2026 = new ArrayList();
        this.field_2028 = new ArrayList();
        Iterator var3 = var2.iterator();

        while(var3.hasNext()) {
            Filter var4 = (Filter)var3.next();
            this.field_2026.add(var4);
            this.field_2028.add(new FilterHolder(var4));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <T> T method_7(f<T> var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.field_2028.iterator();

        while(var3.hasNext()) {
            var2.add(((FilterHolder)var3.next()).getFilter().method_7(var1));
        }

        return var1.method_883(this.field_2027, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1043.method_5409(this, var1, var2);
    }
}

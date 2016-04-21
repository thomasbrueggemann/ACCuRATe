package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.class_1040;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new class_1040();
    // $FF: renamed from: BR int
    final int field_868;
    // $FF: renamed from: QO com.google.android.gms.drive.query.internal.ComparisonFilter
    final ComparisonFilter<?> field_869;
    // $FF: renamed from: QP com.google.android.gms.drive.query.internal.FieldOnlyFilter
    final FieldOnlyFilter field_870;
    // $FF: renamed from: QQ com.google.android.gms.drive.query.internal.LogicalFilter
    final LogicalFilter field_871;
    // $FF: renamed from: QR com.google.android.gms.drive.query.internal.NotFilter
    final NotFilter field_872;
    // $FF: renamed from: QS com.google.android.gms.drive.query.internal.InFilter
    final InFilter<?> field_873;
    // $FF: renamed from: QT com.google.android.gms.drive.query.internal.MatchAllFilter
    final MatchAllFilter field_874;
    // $FF: renamed from: QU com.google.android.gms.drive.query.internal.HasFilter
    final HasFilter field_875;
    // $FF: renamed from: QV com.google.android.gms.drive.query.Filter
    private final Filter field_876;

    FilterHolder(int var1, ComparisonFilter<?> var2, FieldOnlyFilter var3, LogicalFilter var4, NotFilter var5, InFilter<?> var6, MatchAllFilter var7, HasFilter<?> var8) {
        this.field_868 = var1;
        this.field_869 = var2;
        this.field_870 = var3;
        this.field_871 = var4;
        this.field_872 = var5;
        this.field_873 = var6;
        this.field_874 = var7;
        this.field_875 = var8;
        if(this.field_869 != null) {
            this.field_876 = this.field_869;
        } else if(this.field_870 != null) {
            this.field_876 = this.field_870;
        } else if(this.field_871 != null) {
            this.field_876 = this.field_871;
        } else if(this.field_872 != null) {
            this.field_876 = this.field_872;
        } else if(this.field_873 != null) {
            this.field_876 = this.field_873;
        } else if(this.field_874 != null) {
            this.field_876 = this.field_874;
        } else if(this.field_875 != null) {
            this.field_876 = this.field_875;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter var1) {
        this.field_868 = 2;
        ComparisonFilter var2;
        if(var1 instanceof ComparisonFilter) {
            var2 = (ComparisonFilter)var1;
        } else {
            var2 = null;
        }

        this.field_869 = var2;
        FieldOnlyFilter var3;
        if(var1 instanceof FieldOnlyFilter) {
            var3 = (FieldOnlyFilter)var1;
        } else {
            var3 = null;
        }

        this.field_870 = var3;
        LogicalFilter var4;
        if(var1 instanceof LogicalFilter) {
            var4 = (LogicalFilter)var1;
        } else {
            var4 = null;
        }

        this.field_871 = var4;
        NotFilter var5;
        if(var1 instanceof NotFilter) {
            var5 = (NotFilter)var1;
        } else {
            var5 = null;
        }

        this.field_872 = var5;
        InFilter var6;
        if(var1 instanceof InFilter) {
            var6 = (InFilter)var1;
        } else {
            var6 = null;
        }

        this.field_873 = var6;
        MatchAllFilter var7;
        if(var1 instanceof MatchAllFilter) {
            var7 = (MatchAllFilter)var1;
        } else {
            var7 = null;
        }

        this.field_874 = var7;
        HasFilter var8;
        if(var1 instanceof HasFilter) {
            var8 = (HasFilter)var1;
        } else {
            var8 = null;
        }

        this.field_875 = var8;
        if(this.field_869 == null && this.field_870 == null && this.field_871 == null && this.field_872 == null && this.field_873 == null && this.field_874 == null && this.field_875 == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        } else {
            this.field_876 = var1;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.field_876;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_876};
        return String.format("FilterHolder[%s]", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1040.method_5400(this, var1, var2);
    }
}

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
    public static Filter and(Filter var0, Filter... var1) {
        return new LogicalFilter(Operator.field_4763, var0, var1);
    }

    public static Filter and(Iterable<Filter> var0) {
        return new LogicalFilter(Operator.field_4763, var0);
    }

    public static Filter contains(SearchableMetadataField<String> var0, String var1) {
        return new ComparisonFilter(Operator.field_4766, var0, var1);
    }

    // $FF: renamed from: eq (com.google.android.gms.drive.metadata.SearchableMetadataField, java.lang.Object) com.google.android.gms.drive.query.Filter
    public static <T> Filter method_3698(SearchableMetadataField<T> var0, T var1) {
        return new ComparisonFilter(Operator.field_4758, var0, var1);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> var0, T var1) {
        return new ComparisonFilter(Operator.field_4761, var0, var1);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> var0, T var1) {
        return new ComparisonFilter(Operator.field_4762, var0, var1);
    }

    // $FF: renamed from: in (com.google.android.gms.drive.metadata.SearchableCollectionMetadataField, java.lang.Object) com.google.android.gms.drive.query.Filter
    public static <T> Filter method_3699(SearchableCollectionMetadataField<T> var0, T var1) {
        return new InFilter(var0, var1);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> var0, T var1) {
        return new ComparisonFilter(Operator.field_4759, var0, var1);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> var0, T var1) {
        return new ComparisonFilter(Operator.field_4760, var0, var1);
    }

    public static Filter not(Filter var0) {
        return new NotFilter(var0);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    // $FF: renamed from: or (com.google.android.gms.drive.query.Filter, com.google.android.gms.drive.query.Filter[]) com.google.android.gms.drive.query.Filter
    public static Filter method_3700(Filter var0, Filter... var1) {
        return new LogicalFilter(Operator.field_4764, var0, var1);
    }

    // $FF: renamed from: or (java.lang.Iterable) com.google.android.gms.drive.query.Filter
    public static Filter method_3701(Iterable<Filter> var0) {
        return new LogicalFilter(Operator.field_4764, var0);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.field_3182);
    }
}

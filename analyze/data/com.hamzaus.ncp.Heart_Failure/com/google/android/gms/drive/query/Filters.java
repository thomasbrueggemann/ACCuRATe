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
      return new LogicalFilter(Operator.field_3899, var0, var1);
   }

   public static Filter and(Iterable<Filter> var0) {
      return new LogicalFilter(Operator.field_3899, var0);
   }

   public static Filter contains(SearchableMetadataField<String> var0, String var1) {
      return new ComparisonFilter(Operator.field_3902, var0, var1);
   }

   // $FF: renamed from: eq (com.google.android.gms.drive.metadata.SearchableMetadataField, java.lang.Object) com.google.android.gms.drive.query.Filter
   public static <T> Filter method_3105(SearchableMetadataField<T> var0, T var1) {
      return new ComparisonFilter(Operator.field_3894, var0, var1);
   }

   public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> var0, T var1) {
      return new ComparisonFilter(Operator.field_3897, var0, var1);
   }

   public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> var0, T var1) {
      return new ComparisonFilter(Operator.field_3898, var0, var1);
   }

   // $FF: renamed from: in (com.google.android.gms.drive.metadata.SearchableCollectionMetadataField, java.lang.Object) com.google.android.gms.drive.query.Filter
   public static <T> Filter method_3106(SearchableCollectionMetadataField<T> var0, T var1) {
      return new InFilter(var0, var1);
   }

   public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> var0, T var1) {
      return new ComparisonFilter(Operator.field_3895, var0, var1);
   }

   public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> var0, T var1) {
      return new ComparisonFilter(Operator.field_3896, var0, var1);
   }

   public static Filter not(Filter var0) {
      return new NotFilter(var0);
   }

   // $FF: renamed from: or (com.google.android.gms.drive.query.Filter, com.google.android.gms.drive.query.Filter[]) com.google.android.gms.drive.query.Filter
   public static Filter method_3107(Filter var0, Filter... var1) {
      return new LogicalFilter(Operator.field_3900, var0, var1);
   }

   // $FF: renamed from: or (java.lang.Iterable) com.google.android.gms.drive.query.Filter
   public static Filter method_3108(Iterable<Filter> var0) {
      return new LogicalFilter(Operator.field_3900, var0);
   }

   public static Filter sharedWithMe() {
      return new FieldOnlyFilter(SearchableField.field_2914);
   }
}

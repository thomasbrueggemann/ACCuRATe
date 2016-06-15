package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.class_663;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query implements SafeParcelable {
   public static final Creator<Query> CREATOR = new class_663();
   // $FF: renamed from: KB com.google.android.gms.drive.query.internal.LogicalFilter
   final LogicalFilter field_3314;
   // $FF: renamed from: KC java.lang.String
   final String field_3315;
   // $FF: renamed from: KD com.google.android.gms.drive.query.SortOrder
   final SortOrder field_3316;
   // $FF: renamed from: xJ int
   final int field_3317;

   Query(int var1, LogicalFilter var2, String var3, SortOrder var4) {
      this.field_3317 = var1;
      this.field_3314 = var2;
      this.field_3315 = var3;
      this.field_3316 = var4;
   }

   Query(LogicalFilter var1, String var2, SortOrder var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.field_3314;
   }

   public String getPageToken() {
      return this.field_3315;
   }

   public SortOrder getSortOrder() {
      return this.field_3316;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_663.method_3814(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: KC java.lang.String
      private String field_2801;
      // $FF: renamed from: KD com.google.android.gms.drive.query.SortOrder
      private SortOrder field_2802;
      // $FF: renamed from: KE java.util.List
      private final List<Filter> field_2803 = new ArrayList();

      public Query.Builder addFilter(Filter var1) {
         if(!(var1 instanceof MatchAllFilter)) {
            this.field_2803.add(var1);
         }

         return this;
      }

      public Query build() {
         return new Query(new LogicalFilter(Operator.field_3899, this.field_2803), this.field_2801, this.field_2802);
      }

      public Query.Builder setPageToken(String var1) {
         this.field_2801 = var1;
         return this;
      }

      public Query.Builder setSortOrder(SortOrder var1) {
         this.field_2802 = var1;
         return this;
      }
   }
}

package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.class_857;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
   public static final Creator<Query> CREATOR = new class_857();
   // $FF: renamed from: CK int
   final int field_3275;
   // $FF: renamed from: RY com.google.android.gms.drive.query.internal.LogicalFilter
   final LogicalFilter field_3276;
   // $FF: renamed from: RZ java.lang.String
   final String field_3277;
   // $FF: renamed from: Sa com.google.android.gms.drive.query.SortOrder
   final SortOrder field_3278;
   // $FF: renamed from: Sb java.util.List
   final List<String> field_3279;

   Query(int var1, LogicalFilter var2, String var3, SortOrder var4, List<String> var5) {
      this.field_3275 = var1;
      this.field_3276 = var2;
      this.field_3277 = var3;
      this.field_3278 = var4;
      this.field_3279 = var5;
   }

   Query(LogicalFilter var1, String var2, SortOrder var3, List<String> var4) {
      this(1, var1, var2, var3, var4);
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.field_3276;
   }

   public String getPageToken() {
      return this.field_3277;
   }

   public SortOrder getSortOrder() {
      return this.field_3278;
   }

   // $FF: renamed from: jb () java.util.List
   public List<String> method_4168() {
      return this.field_3279;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.field_3276, this.field_3278, this.field_3277};
      return String.format(var1, "Query[%s,%s,PageToken=%s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_857.method_4772(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: RZ java.lang.String
      private String field_2631;
      // $FF: renamed from: Sa com.google.android.gms.drive.query.SortOrder
      private SortOrder field_2632;
      // $FF: renamed from: Sb java.util.List
      private List<String> field_2633;
      // $FF: renamed from: Sc java.util.List
      private final List<Filter> field_2634 = new ArrayList();

      public Builder() {
      }

      public Builder(Query var1) {
         this.field_2634.add(var1.getFilter());
         this.field_2631 = var1.getPageToken();
         this.field_2632 = var1.getSortOrder();
         this.field_2633 = var1.method_4168();
      }

      public Query.Builder addFilter(Filter var1) {
         if(!(var1 instanceof MatchAllFilter)) {
            this.field_2634.add(var1);
         }

         return this;
      }

      public Query build() {
         return new Query(new LogicalFilter(Operator.field_3976, this.field_2634), this.field_2631, this.field_2632, this.field_2633);
      }

      public Query.Builder setPageToken(String var1) {
         this.field_2631 = var1;
         return this;
      }

      public Query.Builder setSortOrder(SortOrder var1) {
         this.field_2632 = var1;
         return this;
      }
   }
}

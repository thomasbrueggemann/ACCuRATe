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
import com.google.android.gms.drive.query.internal.class_954;

public class FilterHolder implements SafeParcelable {
   public static final Creator<FilterHolder> CREATOR = new class_954();
   // $FF: renamed from: CK int
   final int field_577;
   // $FF: renamed from: Sl com.google.android.gms.drive.query.internal.ComparisonFilter
   final ComparisonFilter<?> field_578;
   // $FF: renamed from: Sm com.google.android.gms.drive.query.internal.FieldOnlyFilter
   final FieldOnlyFilter field_579;
   // $FF: renamed from: Sn com.google.android.gms.drive.query.internal.LogicalFilter
   final LogicalFilter field_580;
   // $FF: renamed from: So com.google.android.gms.drive.query.internal.NotFilter
   final NotFilter field_581;
   // $FF: renamed from: Sp com.google.android.gms.drive.query.internal.InFilter
   final InFilter<?> field_582;
   // $FF: renamed from: Sq com.google.android.gms.drive.query.internal.MatchAllFilter
   final MatchAllFilter field_583;
   // $FF: renamed from: Sr com.google.android.gms.drive.query.internal.HasFilter
   final HasFilter field_584;
   // $FF: renamed from: Ss com.google.android.gms.drive.query.Filter
   private final Filter field_585;

   FilterHolder(int var1, ComparisonFilter<?> var2, FieldOnlyFilter var3, LogicalFilter var4, NotFilter var5, InFilter<?> var6, MatchAllFilter var7, HasFilter<?> var8) {
      this.field_577 = var1;
      this.field_578 = var2;
      this.field_579 = var3;
      this.field_580 = var4;
      this.field_581 = var5;
      this.field_582 = var6;
      this.field_583 = var7;
      this.field_584 = var8;
      if(this.field_578 != null) {
         this.field_585 = this.field_578;
      } else if(this.field_579 != null) {
         this.field_585 = this.field_579;
      } else if(this.field_580 != null) {
         this.field_585 = this.field_580;
      } else if(this.field_581 != null) {
         this.field_585 = this.field_581;
      } else if(this.field_582 != null) {
         this.field_585 = this.field_582;
      } else if(this.field_583 != null) {
         this.field_585 = this.field_583;
      } else if(this.field_584 != null) {
         this.field_585 = this.field_584;
      } else {
         throw new IllegalArgumentException("At least one filter must be set.");
      }
   }

   public FilterHolder(Filter var1) {
      this.field_577 = 2;
      ComparisonFilter var2;
      if(var1 instanceof ComparisonFilter) {
         var2 = (ComparisonFilter)var1;
      } else {
         var2 = null;
      }

      this.field_578 = var2;
      FieldOnlyFilter var3;
      if(var1 instanceof FieldOnlyFilter) {
         var3 = (FieldOnlyFilter)var1;
      } else {
         var3 = null;
      }

      this.field_579 = var3;
      LogicalFilter var4;
      if(var1 instanceof LogicalFilter) {
         var4 = (LogicalFilter)var1;
      } else {
         var4 = null;
      }

      this.field_580 = var4;
      NotFilter var5;
      if(var1 instanceof NotFilter) {
         var5 = (NotFilter)var1;
      } else {
         var5 = null;
      }

      this.field_581 = var5;
      InFilter var6;
      if(var1 instanceof InFilter) {
         var6 = (InFilter)var1;
      } else {
         var6 = null;
      }

      this.field_582 = var6;
      MatchAllFilter var7;
      if(var1 instanceof MatchAllFilter) {
         var7 = (MatchAllFilter)var1;
      } else {
         var7 = null;
      }

      this.field_583 = var7;
      HasFilter var8;
      if(var1 instanceof HasFilter) {
         var8 = (HasFilter)var1;
      } else {
         var8 = null;
      }

      this.field_584 = var8;
      if(this.field_578 == null && this.field_579 == null && this.field_580 == null && this.field_581 == null && this.field_582 == null && this.field_583 == null && this.field_584 == null) {
         throw new IllegalArgumentException("Invalid filter type or null filter.");
      } else {
         this.field_585 = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.field_585;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_585};
      return String.format("FilterHolder[%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_954.method_5259(this, var1, var2);
   }
}

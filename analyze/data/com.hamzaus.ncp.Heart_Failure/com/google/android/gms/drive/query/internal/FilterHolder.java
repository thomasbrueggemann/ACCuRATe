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
import com.google.android.gms.drive.query.internal.class_735;

public class FilterHolder implements SafeParcelable {
   public static final Creator<FilterHolder> CREATOR = new class_735();
   // $FF: renamed from: KM com.google.android.gms.drive.query.internal.ComparisonFilter
   final ComparisonFilter<?> field_720;
   // $FF: renamed from: KN com.google.android.gms.drive.query.internal.FieldOnlyFilter
   final FieldOnlyFilter field_721;
   // $FF: renamed from: KO com.google.android.gms.drive.query.internal.LogicalFilter
   final LogicalFilter field_722;
   // $FF: renamed from: KP com.google.android.gms.drive.query.internal.NotFilter
   final NotFilter field_723;
   // $FF: renamed from: KQ com.google.android.gms.drive.query.internal.InFilter
   final InFilter<?> field_724;
   // $FF: renamed from: KR com.google.android.gms.drive.query.internal.MatchAllFilter
   final MatchAllFilter field_725;
   // $FF: renamed from: KS com.google.android.gms.drive.query.internal.HasFilter
   final HasFilter field_726;
   // $FF: renamed from: KT com.google.android.gms.drive.query.Filter
   private final Filter field_727;
   // $FF: renamed from: xJ int
   final int field_728;

   FilterHolder(int var1, ComparisonFilter<?> var2, FieldOnlyFilter var3, LogicalFilter var4, NotFilter var5, InFilter<?> var6, MatchAllFilter var7, HasFilter<?> var8) {
      this.field_728 = var1;
      this.field_720 = var2;
      this.field_721 = var3;
      this.field_722 = var4;
      this.field_723 = var5;
      this.field_724 = var6;
      this.field_725 = var7;
      this.field_726 = var8;
      if(this.field_720 != null) {
         this.field_727 = this.field_720;
      } else if(this.field_721 != null) {
         this.field_727 = this.field_721;
      } else if(this.field_722 != null) {
         this.field_727 = this.field_722;
      } else if(this.field_723 != null) {
         this.field_727 = this.field_723;
      } else if(this.field_724 != null) {
         this.field_727 = this.field_724;
      } else if(this.field_725 != null) {
         this.field_727 = this.field_725;
      } else if(this.field_726 != null) {
         this.field_727 = this.field_726;
      } else {
         throw new IllegalArgumentException("At least one filter must be set.");
      }
   }

   public FilterHolder(Filter var1) {
      this.field_728 = 2;
      ComparisonFilter var2;
      if(var1 instanceof ComparisonFilter) {
         var2 = (ComparisonFilter)var1;
      } else {
         var2 = null;
      }

      this.field_720 = var2;
      FieldOnlyFilter var3;
      if(var1 instanceof FieldOnlyFilter) {
         var3 = (FieldOnlyFilter)var1;
      } else {
         var3 = null;
      }

      this.field_721 = var3;
      LogicalFilter var4;
      if(var1 instanceof LogicalFilter) {
         var4 = (LogicalFilter)var1;
      } else {
         var4 = null;
      }

      this.field_722 = var4;
      NotFilter var5;
      if(var1 instanceof NotFilter) {
         var5 = (NotFilter)var1;
      } else {
         var5 = null;
      }

      this.field_723 = var5;
      InFilter var6;
      if(var1 instanceof InFilter) {
         var6 = (InFilter)var1;
      } else {
         var6 = null;
      }

      this.field_724 = var6;
      MatchAllFilter var7;
      if(var1 instanceof MatchAllFilter) {
         var7 = (MatchAllFilter)var1;
      } else {
         var7 = null;
      }

      this.field_725 = var7;
      HasFilter var8;
      if(var1 instanceof HasFilter) {
         var8 = (HasFilter)var1;
      } else {
         var8 = null;
      }

      this.field_726 = var8;
      if(this.field_720 == null && this.field_721 == null && this.field_722 == null && this.field_723 == null && this.field_724 == null && this.field_725 == null && this.field_726 == null) {
         throw new IllegalArgumentException("Invalid filter type or null filter.");
      } else {
         this.field_727 = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_735.method_4146(this, var1, var2);
   }
}

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FullTextSearchFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;
import com.google.android.gms.drive.query.internal.zzd;

public class FilterHolder implements SafeParcelable {
   public static final Creator<FilterHolder> CREATOR = new zzd();
   final int mVersionCode;
   private final Filter zzapi;
   final ComparisonFilter<?> zzauk;
   final FieldOnlyFilter zzaul;
   final LogicalFilter zzaum;
   final NotFilter zzaun;
   final InFilter<?> zzauo;
   final MatchAllFilter zzaup;
   final HasFilter zzauq;
   final FullTextSearchFilter zzaur;
   final OwnedByMeFilter zzaus;

   FilterHolder(int var1, ComparisonFilter<?> var2, FieldOnlyFilter var3, LogicalFilter var4, NotFilter var5, InFilter<?> var6, MatchAllFilter var7, HasFilter<?> var8, FullTextSearchFilter var9, OwnedByMeFilter var10) {
      this.mVersionCode = var1;
      this.zzauk = var2;
      this.zzaul = var3;
      this.zzaum = var4;
      this.zzaun = var5;
      this.zzauo = var6;
      this.zzaup = var7;
      this.zzauq = var8;
      this.zzaur = var9;
      this.zzaus = var10;
      if(this.zzauk != null) {
         this.zzapi = this.zzauk;
      } else if(this.zzaul != null) {
         this.zzapi = this.zzaul;
      } else if(this.zzaum != null) {
         this.zzapi = this.zzaum;
      } else if(this.zzaun != null) {
         this.zzapi = this.zzaun;
      } else if(this.zzauo != null) {
         this.zzapi = this.zzauo;
      } else if(this.zzaup != null) {
         this.zzapi = this.zzaup;
      } else if(this.zzauq != null) {
         this.zzapi = this.zzauq;
      } else if(this.zzaur != null) {
         this.zzapi = this.zzaur;
      } else if(this.zzaus != null) {
         this.zzapi = this.zzaus;
      } else {
         throw new IllegalArgumentException("At least one filter must be set.");
      }
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.zzapi;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzapi};
      return String.format("FilterHolder[%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}

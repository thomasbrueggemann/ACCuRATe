package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.FullTextSearchFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

public class zzd implements Creator<FilterHolder> {
   static void zza(FilterHolder var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzauk, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaul, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzaum, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzaun, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzauo, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzaup, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzauq, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.zzaur, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzaus, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzco(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzej(var1);
   }

   public FilterHolder zzco(Parcel var1) {
      OwnedByMeFilter var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      FullTextSearchFilter var5 = null;
      HasFilter var6 = null;
      MatchAllFilter var7 = null;
      InFilter var8 = null;
      NotFilter var9 = null;
      LogicalFilter var10 = null;
      FieldOnlyFilter var11 = null;
      ComparisonFilter var12 = null;

      while(var1.dataPosition() < var3) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var12 = (ComparisonFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, ComparisonFilter.CREATOR);
            break;
         case 2:
            var11 = (FieldOnlyFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, FieldOnlyFilter.CREATOR);
            break;
         case 3:
            var10 = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, LogicalFilter.CREATOR);
            break;
         case 4:
            var9 = (NotFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, NotFilter.CREATOR);
            break;
         case 5:
            var8 = (InFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, InFilter.CREATOR);
            break;
         case 6:
            var7 = (MatchAllFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, MatchAllFilter.CREATOR);
            break;
         case 7:
            var6 = (HasFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, HasFilter.CREATOR);
            break;
         case 8:
            var5 = (FullTextSearchFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, FullTextSearchFilter.CREATOR);
            break;
         case 9:
            var2 = (OwnedByMeFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, OwnedByMeFilter.CREATOR);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FilterHolder(var4, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public FilterHolder[] zzej(int var1) {
      return new FilterHolder[var1];
   }
}

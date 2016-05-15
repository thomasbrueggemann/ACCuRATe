package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class zza implements Creator<ComparisonFilter> {
   static void zza(ComparisonFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzaug, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzauh, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeg(var1);
   }

   public ComparisonFilter zzcl(Parcel var1) {
      MetadataBundle var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;

      Operator var5;
      MetadataBundle var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         Operator var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            Operator var10 = (Operator)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, Operator.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 2:
            var7 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, MetadataBundle.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ComparisonFilter(var4, var5, var2);
      }
   }

   public ComparisonFilter[] zzeg(int var1) {
      return new ComparisonFilter[var1];
   }
}

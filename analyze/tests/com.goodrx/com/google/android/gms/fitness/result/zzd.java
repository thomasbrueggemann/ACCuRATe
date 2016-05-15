package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.DataSourceStatsResult;

public class zzd implements Creator<DataSourceStatsResult> {
   static void zza(DataSourceStatsResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzavU, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzUZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaBI);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaBJ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzaBK);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfR(var1);
   }

   public DataSourceStatsResult zzdQ(Parcel var1) {
      boolean var2 = false;
      long var3 = 0L;
      int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DataSource var6 = null;
      long var7 = var3;
      long var9 = var3;
      int var11 = 0;

      while(var1.dataPosition() < var5) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var6 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, DataSource.CREATOR);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var12);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var12);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var12);
            break;
         case 1000:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new DataSourceStatsResult(var11, var6, var9, var2, var7, var3);
      }
   }

   public DataSourceStatsResult[] zzfR(int var1) {
      return new DataSourceStatsResult[var1];
   }
}

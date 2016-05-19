package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.DataSourceQueryParams;

public class zzg implements Creator<DataSourceQueryParams> {
   static void zza(DataSourceQueryParams var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzavU, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzUZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzawk);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaAT);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzaAO);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzaAU);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdm(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfm(var1);
   }

   public DataSourceQueryParams zzdm(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = zza.zzau(var1);
      DataSource var6 = null;
      int var7 = 0;
      long var8 = var2;
      long var10 = var2;
      int var12 = 0;

      while(var1.dataPosition() < var5) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var6 = (DataSource)zza.zza(var1, var13, DataSource.CREATOR);
            break;
         case 2:
            var10 = zza.zzi(var1, var13);
            break;
         case 3:
            var8 = zza.zzi(var1, var13);
            break;
         case 4:
            var2 = zza.zzi(var1, var13);
            break;
         case 5:
            var7 = zza.zzg(var1, var13);
            break;
         case 6:
            var4 = zza.zzg(var1, var13);
            break;
         case 1000:
            var12 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new DataSourceQueryParams(var12, var6, var10, var8, var2, var7, var4);
      }
   }

   public DataSourceQueryParams[] zzfm(int var1) {
      return new DataSourceQueryParams[var1];
   }
}

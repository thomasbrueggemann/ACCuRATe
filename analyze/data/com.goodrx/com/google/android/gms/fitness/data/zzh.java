package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.DataUpdateNotification;

public class zzh implements Creator<DataUpdateNotification> {
   static void zza(DataUpdateNotification var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzup());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzuq());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getOperationType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcU(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeT(var1);
   }

   public DataUpdateNotification zzcU(Parcel var1) {
      long var2 = 0L;
      DataType var4 = null;
      int var5 = 0;
      int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DataSource var7 = null;
      long var8 = var2;
      int var10 = 0;

      while(var1.dataPosition() < var6) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var11);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var11);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 4:
            var7 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, DataSource.CREATOR);
            break;
         case 5:
            var4 = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, DataType.CREATOR);
            break;
         case 1000:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new DataUpdateNotification(var10, var8, var2, var5, var7, var4);
      }
   }

   public DataUpdateNotification[] zzeT(int var1) {
      return new DataUpdateNotification[var1];
   }
}

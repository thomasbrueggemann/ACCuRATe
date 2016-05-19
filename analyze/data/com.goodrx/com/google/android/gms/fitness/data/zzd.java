package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;

public class zzd implements Creator<DataPoint> {
   static void zza(DataPoint var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.getTimestampNanos());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzuj());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable[])var0.zzuf(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.getOriginalDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzug());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzuh());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeP(var1);
   }

   public DataPoint zzcQ(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      DataSource var4 = null;
      long var5 = 0L;
      long var7 = 0L;
      Value[] var9 = null;
      DataSource var10 = null;
      long var11 = 0L;
      long var13 = 0L;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var4 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, DataSource.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 5:
            var9 = (Value[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15, Value.CREATOR);
            break;
         case 6:
            var10 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, DataSource.CREATOR);
            break;
         case 7:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 8:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new DataPoint(var3, var4, var5, var7, var9, var10, var11, var13);
      }
   }

   public DataPoint[] zzeP(int var1) {
      return new DataPoint[var1];
   }
}

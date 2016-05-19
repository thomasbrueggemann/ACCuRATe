package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

public class zzs implements Creator<Subscription> {
   static void zza(Subscription var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzux());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getAccuracyMode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfd(var1);
   }

   public Subscription zzdd(Parcel var1) {
      DataType var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var5 = 0L;
      DataSource var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DataSource.CREATOR);
            break;
         case 2:
            var2 = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DataType.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var9);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 1000:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Subscription(var8, var7, var2, var5, var3);
      }
   }

   public Subscription[] zzfd(int var1) {
      return new Subscription[var1];
   }
}

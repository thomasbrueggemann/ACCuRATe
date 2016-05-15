package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zze implements Creator<DataSet> {
   static void zza(DataSet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzd(var1, 3, var0.zzuk(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzul(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzuc());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcR(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeQ(var1);
   }

   public DataSet zzcR(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = new ArrayList();
      DataType var6 = null;
      DataSource var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DataSource.CREATOR);
            break;
         case 2:
            var6 = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DataType.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, var5, this.getClass().getClassLoader());
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9, DataSource.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
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
         return new DataSet(var8, var7, var6, var5, var3, var2);
      }
   }

   public DataSet[] zzeQ(int var1) {
      return new DataSet[var1];
   }
}

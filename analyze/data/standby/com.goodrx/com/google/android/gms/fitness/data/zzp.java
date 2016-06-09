package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;

public class zzp implements Creator<RawDataSet> {
   static void zza(RawDataSet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzaxg);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzaxi);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaxj, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzawi);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzda(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeZ(var1);
   }

   public RawDataSet zzda(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8, RawDataPoint.CREATOR);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 1000:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new RawDataSet(var7, var6, var5, var4, var2);
      }
   }

   public RawDataSet[] zzeZ(int var1) {
      return new RawDataSet[var1];
   }
}

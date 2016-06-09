package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;

public class zzb implements Creator<FitnessUnregistrationRequest> {
   static void zza(FitnessUnregistrationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdg(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfg(var1);
   }

   public FitnessUnregistrationRequest zzdg(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      DataSource var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var5)) {
         case 1:
            var4 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var5, DataSource.CREATOR);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new FitnessUnregistrationRequest(var3, var4);
      }
   }

   public FitnessUnregistrationRequest[] zzfg(int var1) {
      return new FitnessUnregistrationRequest[var1];
   }
}

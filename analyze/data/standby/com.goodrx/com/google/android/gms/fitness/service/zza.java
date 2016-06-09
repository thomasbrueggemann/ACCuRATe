package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public class zza implements Creator<FitnessSensorServiceRequest> {
   static void zza(FitnessSensorServiceRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (IBinder)var0.zzvb(), false);
      zzb.zza(var1, 3, var0.zzux());
      zzb.zza(var1, 4, var0.zzvs());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzga(var1);
   }

   public FitnessSensorServiceRequest zzdZ(Parcel var1) {
      long var2 = 0L;
      IBinder var4 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var6 = 0;
      long var7 = var2;
      DataSource var9 = null;

      while(var1.dataPosition() < var5) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, DataSource.CREATOR);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 1000:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new FitnessSensorServiceRequest(var6, var9, var4, var7, var2);
      }
   }

   public FitnessSensorServiceRequest[] zzga(int var1) {
      return new FitnessSensorServiceRequest[var1];
   }
}

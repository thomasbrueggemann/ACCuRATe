package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataUpdateRequest;

public class zzm implements Creator<DataUpdateRequest> {
   static void zza(DataUpdateRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getDataSet(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzds(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfs(var1);
   }

   public DataUpdateRequest zzds(Parcel var1) {
      long var2 = 0L;
      IBinder var4 = null;
      int var5 = zza.zzau(var1);
      int var6 = 0;
      DataSet var7 = null;
      long var8 = var2;

      while(var1.dataPosition() < var5) {
         int var10 = zza.zzat(var1);
         switch(zza.zzca(var10)) {
         case 1:
            var8 = zza.zzi(var1, var10);
            break;
         case 2:
            var2 = zza.zzi(var1, var10);
            break;
         case 3:
            var7 = (DataSet)zza.zza(var1, var10, DataSet.CREATOR);
            break;
         case 4:
            var4 = zza.zzq(var1, var10);
            break;
         case 1000:
            var6 = zza.zzg(var1, var10);
            break;
         default:
            zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new DataUpdateRequest(var6, var8, var2, var7, var4);
      }
   }

   public DataUpdateRequest[] zzfs(int var1) {
      return new DataUpdateRequest[var1];
   }
}

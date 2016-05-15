package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;

public class zzc implements Creator<DailyTotalRequest> {
   static void zza(DailyTotalRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdi(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfi(var1);
   }

   public DailyTotalRequest zzdi(Parcel var1) {
      DataType var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      IBinder var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzq(var1, var6);
            break;
         case 2:
            var2 = (DataType)zza.zza(var1, var6, DataType.CREATOR);
            break;
         case 1000:
            var4 = zza.zzg(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DailyTotalRequest(var4, var5, var2);
      }
   }

   public DailyTotalRequest[] zzfi(int var1) {
      return new DailyTotalRequest[var1];
   }
}

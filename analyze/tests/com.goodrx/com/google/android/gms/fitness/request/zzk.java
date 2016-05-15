package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;

public class zzk implements Creator<DataUpdateListenerRegistrationRequest> {
   static void zza(DataUpdateListenerRegistrationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getIntent(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdq(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfq(var1);
   }

   public DataUpdateListenerRegistrationRequest zzdq(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      PendingIntent var5 = null;
      DataType var6 = null;
      DataSource var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = (DataSource)zza.zza(var1, var8, DataSource.CREATOR);
            break;
         case 2:
            var6 = (DataType)zza.zza(var1, var8, DataType.CREATOR);
            break;
         case 3:
            var5 = (PendingIntent)zza.zza(var1, var8, PendingIntent.CREATOR);
            break;
         case 4:
            var2 = zza.zzq(var1, var8);
            break;
         case 1000:
            var4 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DataUpdateListenerRegistrationRequest(var4, var7, var6, var5, var2);
      }
   }

   public DataUpdateListenerRegistrationRequest[] zzfq(int var1) {
      return new DataUpdateListenerRegistrationRequest[var1];
   }
}

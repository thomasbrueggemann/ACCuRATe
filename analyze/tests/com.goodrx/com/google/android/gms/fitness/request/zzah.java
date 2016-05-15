package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

public class zzah implements Creator<UnsubscribeRequest> {
   static void zza(UnsubscribeRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdM(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfN(var1);
   }

   public UnsubscribeRequest zzdM(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      DataSource var5 = null;

      DataType var6;
      IBinder var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = zza.zzat(var1);
         DataSource var9;
         DataType var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            DataType var16 = (DataType)zza.zza(var1, var7, DataType.CREATOR);
            var11 = var4;
            var10 = var16;
            var8 = var2;
            var9 = var5;
            break;
         case 2:
            DataSource var12 = (DataSource)zza.zza(var1, var7, DataSource.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = zza.zzq(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var14;
            var8 = var2;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new UnsubscribeRequest(var4, var6, var5, var2);
      }
   }

   public UnsubscribeRequest[] zzfN(int var1) {
      return new UnsubscribeRequest[var1];
   }
}

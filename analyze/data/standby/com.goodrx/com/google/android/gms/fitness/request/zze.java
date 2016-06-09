package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataInsertRequest;

public class zze implements Creator<DataInsertRequest> {
   static void zza(DataInsertRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSet(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzuO());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfk(var1);
   }

   public DataInsertRequest zzdk(Parcel var1) {
      IBinder var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      DataSet var5 = null;

      int var6;
      boolean var8;
      for(var6 = 0; var1.dataPosition() < var4; var3 = var8) {
         int var7 = zza.zzat(var1);
         IBinder var9;
         DataSet var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            DataSet var16 = (DataSet)zza.zza(var1, var7, DataSet.CREATOR);
            var11 = var6;
            var10 = var16;
            var8 = var3;
            var9 = var2;
            break;
         case 2:
            IBinder var12 = zza.zzq(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var3;
            break;
         case 4:
            var8 = zza.zzc(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var6;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var14;
            var8 = var3;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var3;
            var9 = var2;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var2 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DataInsertRequest(var6, var5, var2, var3);
      }
   }

   public DataInsertRequest[] zzfk(int var1) {
      return new DataInsertRequest[var1];
   }
}

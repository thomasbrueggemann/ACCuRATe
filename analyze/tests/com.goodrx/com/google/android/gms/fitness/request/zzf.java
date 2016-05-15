package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;

public class zzf implements Creator<DataReadRequest> {
   static void zza(DataReadRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getAggregatedDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getAggregatedDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.getBucketType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzuR());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.getActivityDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.getLimit());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, var0.zzuQ());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, var0.zzuP());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 16, var0.zzuS(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfl(var1);
   }

   public DataReadRequest zzdl(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      ArrayList var4 = null;
      ArrayList var5 = null;
      long var6 = 0L;
      long var8 = 0L;
      ArrayList var10 = null;
      ArrayList var11 = null;
      int var12 = 0;
      long var13 = 0L;
      DataSource var15 = null;
      int var16 = 0;
      boolean var17 = false;
      boolean var18 = false;
      IBinder var19 = null;
      ArrayList var20 = null;

      while(var1.dataPosition() < var2) {
         int var21 = zza.zzat(var1);
         switch(zza.zzca(var21)) {
         case 1:
            var4 = zza.zzc(var1, var21, DataType.CREATOR);
            break;
         case 2:
            var5 = zza.zzc(var1, var21, DataSource.CREATOR);
            break;
         case 3:
            var6 = zza.zzi(var1, var21);
            break;
         case 4:
            var8 = zza.zzi(var1, var21);
            break;
         case 5:
            var10 = zza.zzc(var1, var21, DataType.CREATOR);
            break;
         case 6:
            var11 = zza.zzc(var1, var21, DataSource.CREATOR);
            break;
         case 7:
            var12 = zza.zzg(var1, var21);
            break;
         case 8:
            var13 = zza.zzi(var1, var21);
            break;
         case 9:
            var15 = (DataSource)zza.zza(var1, var21, DataSource.CREATOR);
            break;
         case 10:
            var16 = zza.zzg(var1, var21);
            break;
         case 12:
            var17 = zza.zzc(var1, var21);
            break;
         case 13:
            var18 = zza.zzc(var1, var21);
            break;
         case 14:
            var19 = zza.zzq(var1, var21);
            break;
         case 16:
            var20 = zza.zzc(var1, var21, Device.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var21);
            break;
         default:
            zza.zzb(var1, var21);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new DataReadRequest(var3, var4, var5, var6, var8, var10, var11, var12, var13, var15, var16, var17, var18, var19, var20);
      }
   }

   public DataReadRequest[] zzfl(int var1) {
      return new DataReadRequest[var1];
   }
}

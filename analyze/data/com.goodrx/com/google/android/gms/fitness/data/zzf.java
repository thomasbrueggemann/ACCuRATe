package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Application;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;

public class zzf implements Creator<DataSource> {
   static void zza(DataSource var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.getDevice(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzum(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.getStreamName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeR(var1);
   }

   public DataSource zzcS(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Application var5 = null;
      Device var6 = null;
      String var7 = null;
      DataType var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var8 = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, DataType.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var6 = (Device)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Device.CREATOR);
            break;
         case 5:
            var5 = (Application)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Application.CREATOR);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 1000:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSource(var9, var8, var7, var2, var6, var5, var3);
      }
   }

   public DataSource[] zzeR(int var1) {
      return new DataSource[var1];
   }
}

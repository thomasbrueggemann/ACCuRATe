package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import java.util.ArrayList;
import java.util.List;

public class zzh implements Creator<DataSourcesRequest> {
   static void zza(DataSourcesRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (List)var0.zzuT(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzuU());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfn(var1);
   }

   public DataSourcesRequest zzdn(Parcel var1) {
      boolean var2 = false;
      IBinder var3 = null;
      int var4 = zza.zzau(var1);
      ArrayList var5 = null;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var6 = zza.zzc(var1, var8, DataType.CREATOR);
            break;
         case 2:
            var5 = zza.zzC(var1, var8);
            break;
         case 3:
            var2 = zza.zzc(var1, var8);
            break;
         case 4:
            var3 = zza.zzq(var1, var8);
            break;
         case 1000:
            var7 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSourcesRequest(var7, var6, var5, var2, var3);
      }
   }

   public DataSourcesRequest[] zzfn(int var1) {
      return new DataSourcesRequest[var1];
   }
}

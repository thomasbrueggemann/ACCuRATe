package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.request.DataSourceQueryParams;
import com.google.android.gms.fitness.request.ReadRawRequest;
import java.util.ArrayList;

public class zzt implements Creator<ReadRawRequest> {
   static void zza(ReadRawRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzuW(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzuQ());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzuP());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdy(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfy(var1);
   }

   public ReadRawRequest zzdy(Parcel var1) {
      ArrayList var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      boolean var5 = false;
      IBinder var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var6 = zza.zzq(var1, var8);
            break;
         case 3:
            var2 = zza.zzc(var1, var8, DataSourceQueryParams.CREATOR);
            break;
         case 4:
            var5 = zza.zzc(var1, var8);
            break;
         case 5:
            var3 = zza.zzc(var1, var8);
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
         return new ReadRawRequest(var7, var6, var2, var5, var3);
      }
   }

   public ReadRawRequest[] zzfy(int var1) {
      return new ReadRawRequest[var1];
   }
}

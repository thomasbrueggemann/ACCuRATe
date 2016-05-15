package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import java.util.ArrayList;

public class zzd implements Creator<DataDeleteRequest> {
   static void zza(DataDeleteRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getSessions(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzuL());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzuM());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdj(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfj(var1);
   }

   public DataDeleteRequest zzdj(Parcel var1) {
      long var2 = 0L;
      boolean var4 = false;
      IBinder var5 = null;
      int var6 = zza.zzau(var1);
      boolean var7 = false;
      ArrayList var8 = null;
      ArrayList var9 = null;
      ArrayList var10 = null;
      long var11 = var2;
      int var13 = 0;

      while(var1.dataPosition() < var6) {
         int var14 = zza.zzat(var1);
         switch(zza.zzca(var14)) {
         case 1:
            var11 = zza.zzi(var1, var14);
            break;
         case 2:
            var2 = zza.zzi(var1, var14);
            break;
         case 3:
            var10 = zza.zzc(var1, var14, DataSource.CREATOR);
            break;
         case 4:
            var9 = zza.zzc(var1, var14, DataType.CREATOR);
            break;
         case 5:
            var8 = zza.zzc(var1, var14, Session.CREATOR);
            break;
         case 6:
            var7 = zza.zzc(var1, var14);
            break;
         case 7:
            var4 = zza.zzc(var1, var14);
            break;
         case 8:
            var5 = zza.zzq(var1, var14);
            break;
         case 1000:
            var13 = zza.zzg(var1, var14);
            break;
         default:
            zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new DataDeleteRequest(var13, var11, var2, var10, var9, var8, var7, var4, var5);
      }
   }

   public DataDeleteRequest[] zzfj(int var1) {
      return new DataDeleteRequest[var1];
   }
}

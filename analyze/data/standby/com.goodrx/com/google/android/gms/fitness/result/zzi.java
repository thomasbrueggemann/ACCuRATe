package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.fitness.result.ReadRawResult;
import java.util.ArrayList;

public class zzi implements Creator<ReadRawResult> {
   static void zza(ReadRawResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzsX(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzvo(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdV(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfW(var1);
   }

   public ReadRawResult zzdV(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;

      DataHolder var5;
      ArrayList var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         DataHolder var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            DataHolder var12 = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, DataHolder.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6, DataHolder.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ReadRawResult(var4, var5, var2);
      }
   }

   public ReadRawResult[] zzfW(int var1) {
      return new ReadRawResult[var1];
   }
}

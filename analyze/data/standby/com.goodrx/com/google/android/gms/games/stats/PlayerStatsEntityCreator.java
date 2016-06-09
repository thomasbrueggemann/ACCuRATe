package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.stats.PlayerStatsEntity;

public class PlayerStatsEntityCreator implements Creator<PlayerStatsEntity> {
   static void zza(PlayerStatsEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, var0.getAverageSessionLength());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, var0.getChurnProbability());
      zzb.zzc(var1, 3, var0.getDaysSinceLastPlayed());
      zzb.zzc(var1, 4, var0.getNumberOfPurchases());
      zzb.zzc(var1, 5, var0.getNumberOfSessions());
      zzb.zza(var1, 6, var0.getSessionPercentile());
      zzb.zza(var1, 7, var0.getSpendPercentile());
      zzb.zza(var1, 8, (Bundle)var0.zzxV(), false);
      zzb.zza(var1, 9, var0.getSpendProbability());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgW(var1);
   }

   public PlayerStatsEntity zzeE(Parcel var1) {
      int var2 = 0;
      float var3 = 0.0F;
      int var4 = zza.zzau(var1);
      Bundle var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;
      int var8 = 0;
      int var9 = 0;
      float var10 = 0.0F;
      float var11 = 0.0F;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var11 = zza.zzl(var1, var13);
            break;
         case 2:
            var10 = zza.zzl(var1, var13);
            break;
         case 3:
            var9 = zza.zzg(var1, var13);
            break;
         case 4:
            var8 = zza.zzg(var1, var13);
            break;
         case 5:
            var2 = zza.zzg(var1, var13);
            break;
         case 6:
            var7 = zza.zzl(var1, var13);
            break;
         case 7:
            var6 = zza.zzl(var1, var13);
            break;
         case 8:
            var5 = zza.zzr(var1, var13);
            break;
         case 9:
            var3 = zza.zzl(var1, var13);
            break;
         case 1000:
            var12 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PlayerStatsEntity(var12, var11, var10, var9, var8, var2, var7, var6, var5, var3);
      }
   }

   public PlayerStatsEntity[] zzgW(int var1) {
      return new PlayerStatsEntity[var1];
   }
}

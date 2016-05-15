package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
   static void zza(PlayerLevelInfo var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, var0.getCurrentXpTotal());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, var0.getLastLevelUpTimestamp());
      zzb.zza(var1, 3, (Parcelable)var0.getCurrentLevel(), var2, false);
      zzb.zza(var1, 4, (Parcelable)var0.getNextLevel(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzed(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgf(var1);
   }

   public PlayerLevelInfo zzed(Parcel var1) {
      long var2 = 0L;
      PlayerLevel var4 = null;
      int var5 = zza.zzau(var1);
      int var6 = 0;
      PlayerLevel var7 = null;
      long var8 = var2;

      while(var1.dataPosition() < var5) {
         int var10 = zza.zzat(var1);
         switch(zza.zzca(var10)) {
         case 1:
            var8 = zza.zzi(var1, var10);
            break;
         case 2:
            var2 = zza.zzi(var1, var10);
            break;
         case 3:
            var7 = (PlayerLevel)zza.zza(var1, var10, PlayerLevel.CREATOR);
            break;
         case 4:
            var4 = (PlayerLevel)zza.zza(var1, var10, PlayerLevel.CREATOR);
            break;
         case 1000:
            var6 = zza.zzg(var1, var10);
            break;
         default:
            zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevelInfo(var6, var8, var2, var7, var4);
      }
   }

   public PlayerLevelInfo[] zzgf(int var1) {
      return new PlayerLevelInfo[var1];
   }
}

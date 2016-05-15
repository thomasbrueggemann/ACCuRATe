package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerLevel;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
   static void zza(PlayerLevel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getLevelNumber());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, var0.getMinXp());
      zzb.zza(var1, 3, var0.getMaxXp());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzec(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzge(var1);
   }

   public PlayerLevel zzec(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = zza.zzau(var1);
      long var6 = var2;
      int var8 = 0;

      while(var1.dataPosition() < var5) {
         int var9 = zza.zzat(var1);
         switch(zza.zzca(var9)) {
         case 1:
            var4 = zza.zzg(var1, var9);
            break;
         case 2:
            var6 = zza.zzi(var1, var9);
            break;
         case 3:
            var2 = zza.zzi(var1, var9);
            break;
         case 1000:
            var8 = zza.zzg(var1, var9);
            break;
         default:
            zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevel(var8, var4, var6, var2);
      }
   }

   public PlayerLevel[] zzge(int var1) {
      return new PlayerLevel[var1];
   }
}

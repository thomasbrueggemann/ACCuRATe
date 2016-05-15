package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
   static void zza(GameBadgeEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getType());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getTitle(), false);
      zzb.zza(var1, 3, (String)var0.getDescription(), false);
      zzb.zza(var1, 4, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzen(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgz(var1);
   }

   public GameBadgeEntity zzen(Parcel var1) {
      int var2 = 0;
      Uri var3 = null;
      int var4 = zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var2 = zza.zzg(var1, var8);
            break;
         case 2:
            var6 = zza.zzp(var1, var8);
            break;
         case 3:
            var5 = zza.zzp(var1, var8);
            break;
         case 4:
            var3 = (Uri)zza.zza(var1, var8, Uri.CREATOR);
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
         return new GameBadgeEntity(var7, var2, var6, var5, var3);
      }
   }

   public GameBadgeEntity[] zzgz(int var1) {
      return new GameBadgeEntity[var1];
   }
}

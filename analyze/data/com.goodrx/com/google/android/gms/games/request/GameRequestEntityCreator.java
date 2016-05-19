package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
   static void zza(GameRequestEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getGame(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (Parcelable)var0.getSender(), var2, false);
      zzb.zza(var1, 3, (byte[])var0.getData(), false);
      zzb.zza(var1, 4, (String)var0.getRequestId(), false);
      zzb.zzc(var1, 5, var0.getRecipients(), false);
      zzb.zzc(var1, 7, var0.getType());
      zzb.zza(var1, 9, var0.getCreationTimestamp());
      zzb.zza(var1, 10, var0.getExpirationTimestamp());
      zzb.zza(var1, 11, (Bundle)var0.zzxT(), false);
      zzb.zzc(var1, 12, var0.getStatus());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzez(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgP(var1);
   }

   public GameRequestEntity zzez(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      GameEntity var4 = null;
      PlayerEntity var5 = null;
      byte[] var6 = null;
      String var7 = null;
      ArrayList var8 = null;
      int var9 = 0;
      long var10 = 0L;
      long var12 = 0L;
      Bundle var14 = null;
      int var15 = 0;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var4 = (GameEntity)zza.zza(var1, var16, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)zza.zza(var1, var16, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = zza.zzs(var1, var16);
            break;
         case 4:
            var7 = zza.zzp(var1, var16);
            break;
         case 5:
            var8 = zza.zzc(var1, var16, PlayerEntity.CREATOR);
            break;
         case 7:
            var9 = zza.zzg(var1, var16);
            break;
         case 9:
            var10 = zza.zzi(var1, var16);
            break;
         case 10:
            var12 = zza.zzi(var1, var16);
            break;
         case 11:
            var14 = zza.zzr(var1, var16);
            break;
         case 12:
            var15 = zza.zzg(var1, var16);
            break;
         case 1000:
            var3 = zza.zzg(var1, var16);
            break;
         default:
            zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GameRequestEntity(var3, var4, var5, var6, var7, var8, var9, var10, var12, var14, var15);
      }
   }

   public GameRequestEntity[] zzgP(int var1) {
      return new GameRequestEntity[var1];
   }
}

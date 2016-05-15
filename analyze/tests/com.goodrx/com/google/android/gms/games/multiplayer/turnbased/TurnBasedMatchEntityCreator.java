package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
   static void zza(TurnBasedMatchEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getGame(), var2, false);
      zzb.zza(var1, 2, (String)var0.getMatchId(), false);
      zzb.zza(var1, 3, (String)var0.getCreatorId(), false);
      zzb.zza(var1, 4, var0.getCreationTimestamp());
      zzb.zza(var1, 5, (String)var0.getLastUpdaterId(), false);
      zzb.zza(var1, 6, var0.getLastUpdatedTimestamp());
      zzb.zza(var1, 7, (String)var0.getPendingParticipantId(), false);
      zzb.zzc(var1, 8, var0.getStatus());
      zzb.zzc(var1, 10, var0.getVariant());
      zzb.zzc(var1, 11, var0.getVersion());
      zzb.zza(var1, 12, (byte[])var0.getData(), false);
      zzb.zzc(var1, 13, var0.getParticipants(), false);
      zzb.zza(var1, 14, (String)var0.getRematchId(), false);
      zzb.zza(var1, 15, (byte[])var0.getPreviousMatchData(), false);
      zzb.zza(var1, 17, (Bundle)var0.getAutoMatchCriteria(), false);
      zzb.zzc(var1, 16, var0.getMatchNumber());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 19, var0.isLocallyModified());
      zzb.zzc(var1, 18, var0.getTurnStatus());
      zzb.zza(var1, 21, (String)var0.getDescriptionParticipantId(), false);
      zzb.zza(var1, 20, (String)var0.getDescription(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzew(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgM(var1);
   }

   public TurnBasedMatchEntity zzew(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      GameEntity var4 = null;
      String var5 = null;
      String var6 = null;
      long var7 = 0L;
      String var9 = null;
      long var10 = 0L;
      String var12 = null;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      byte[] var16 = null;
      ArrayList var17 = null;
      String var18 = null;
      byte[] var19 = null;
      int var20 = 0;
      Bundle var21 = null;
      int var22 = 0;
      boolean var23 = false;
      String var24 = null;
      String var25 = null;

      while(var1.dataPosition() < var2) {
         int var26 = zza.zzat(var1);
         switch(zza.zzca(var26)) {
         case 1:
            var4 = (GameEntity)zza.zza(var1, var26, GameEntity.CREATOR);
            break;
         case 2:
            var5 = zza.zzp(var1, var26);
            break;
         case 3:
            var6 = zza.zzp(var1, var26);
            break;
         case 4:
            var7 = zza.zzi(var1, var26);
            break;
         case 5:
            var9 = zza.zzp(var1, var26);
            break;
         case 6:
            var10 = zza.zzi(var1, var26);
            break;
         case 7:
            var12 = zza.zzp(var1, var26);
            break;
         case 8:
            var13 = zza.zzg(var1, var26);
            break;
         case 10:
            var14 = zza.zzg(var1, var26);
            break;
         case 11:
            var15 = zza.zzg(var1, var26);
            break;
         case 12:
            var16 = zza.zzs(var1, var26);
            break;
         case 13:
            var17 = zza.zzc(var1, var26, ParticipantEntity.CREATOR);
            break;
         case 14:
            var18 = zza.zzp(var1, var26);
            break;
         case 15:
            var19 = zza.zzs(var1, var26);
            break;
         case 16:
            var20 = zza.zzg(var1, var26);
            break;
         case 17:
            var21 = zza.zzr(var1, var26);
            break;
         case 18:
            var22 = zza.zzg(var1, var26);
            break;
         case 19:
            var23 = zza.zzc(var1, var26);
            break;
         case 20:
            var24 = zza.zzp(var1, var26);
            break;
         case 21:
            var25 = zza.zzp(var1, var26);
            break;
         case 1000:
            var3 = zza.zzg(var1, var26);
            break;
         default:
            zza.zzb(var1, var26);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new TurnBasedMatchEntity(var3, var4, var5, var6, var7, var9, var10, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25);
      }
   }

   public TurnBasedMatchEntity[] zzgM(int var1) {
      return new TurnBasedMatchEntity[var1];
   }
}

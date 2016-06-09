package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
   static void zza(PlayerEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getPlayerId(), false);
      zzb.zza(var1, 2, (String)var0.getDisplayName(), false);
      zzb.zza(var1, 3, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zza(var1, 4, (Parcelable)var0.getHiResImageUri(), var2, false);
      zzb.zza(var1, 5, var0.getRetrievedTimestamp());
      zzb.zzc(var1, 6, var0.zzvG());
      zzb.zza(var1, 7, var0.getLastPlayedWithTimestamp());
      zzb.zza(var1, 8, (String)var0.getIconImageUrl(), false);
      zzb.zza(var1, 9, (String)var0.getHiResImageUrl(), false);
      zzb.zza(var1, 14, (String)var0.getTitle(), false);
      zzb.zza(var1, 15, (Parcelable)var0.zzvI(), var2, false);
      zzb.zza(var1, 16, (Parcelable)var0.getLevelInfo(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 19, var0.zzvF());
      zzb.zza(var1, 18, var0.zzvH());
      zzb.zza(var1, 21, (String)var0.getName(), false);
      zzb.zza(var1, 20, (String)var0.zzvE(), false);
      zzb.zza(var1, 23, (String)var0.getBannerImageLandscapeUrl(), false);
      zzb.zza(var1, 22, (Parcelable)var0.getBannerImageLandscapeUri(), var2, false);
      zzb.zza(var1, 25, (String)var0.getBannerImagePortraitUrl(), false);
      zzb.zza(var1, 24, (Parcelable)var0.getBannerImagePortraitUri(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgd(var1);
   }

   public PlayerEntity zzeb(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      Uri var6 = null;
      Uri var7 = null;
      long var8 = 0L;
      int var10 = 0;
      long var11 = 0L;
      String var13 = null;
      String var14 = null;
      String var15 = null;
      MostRecentGameInfoEntity var16 = null;
      PlayerLevelInfo var17 = null;
      boolean var18 = false;
      boolean var19 = false;
      String var20 = null;
      String var21 = null;
      Uri var22 = null;
      String var23 = null;
      Uri var24 = null;
      String var25 = null;

      while(var1.dataPosition() < var2) {
         int var26 = zza.zzat(var1);
         switch(zza.zzca(var26)) {
         case 1:
            var4 = zza.zzp(var1, var26);
            break;
         case 2:
            var5 = zza.zzp(var1, var26);
            break;
         case 3:
            var6 = (Uri)zza.zza(var1, var26, Uri.CREATOR);
            break;
         case 4:
            var7 = (Uri)zza.zza(var1, var26, Uri.CREATOR);
            break;
         case 5:
            var8 = zza.zzi(var1, var26);
            break;
         case 6:
            var10 = zza.zzg(var1, var26);
            break;
         case 7:
            var11 = zza.zzi(var1, var26);
            break;
         case 8:
            var13 = zza.zzp(var1, var26);
            break;
         case 9:
            var14 = zza.zzp(var1, var26);
            break;
         case 14:
            var15 = zza.zzp(var1, var26);
            break;
         case 15:
            var16 = (MostRecentGameInfoEntity)zza.zza(var1, var26, MostRecentGameInfoEntity.CREATOR);
            break;
         case 16:
            var17 = (PlayerLevelInfo)zza.zza(var1, var26, PlayerLevelInfo.CREATOR);
            break;
         case 18:
            var18 = zza.zzc(var1, var26);
            break;
         case 19:
            var19 = zza.zzc(var1, var26);
            break;
         case 20:
            var20 = zza.zzp(var1, var26);
            break;
         case 21:
            var21 = zza.zzp(var1, var26);
            break;
         case 22:
            var22 = (Uri)zza.zza(var1, var26, Uri.CREATOR);
            break;
         case 23:
            var23 = zza.zzp(var1, var26);
            break;
         case 24:
            var24 = (Uri)zza.zza(var1, var26, Uri.CREATOR);
            break;
         case 25:
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
         return new PlayerEntity(var3, var4, var5, var6, var7, var8, var10, var11, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25);
      }
   }

   public PlayerEntity[] zzgd(int var1) {
      return new PlayerEntity[var1];
   }
}

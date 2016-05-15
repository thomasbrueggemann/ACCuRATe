package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;

public class GameEntityCreator implements Creator<GameEntity> {
   static void zza(GameEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getApplicationId(), false);
      zzb.zza(var1, 2, (String)var0.getDisplayName(), false);
      zzb.zza(var1, 3, (String)var0.getPrimaryCategory(), false);
      zzb.zza(var1, 4, (String)var0.getSecondaryCategory(), false);
      zzb.zza(var1, 5, (String)var0.getDescription(), false);
      zzb.zza(var1, 6, (String)var0.getDeveloperName(), false);
      zzb.zza(var1, 7, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zza(var1, 8, (Parcelable)var0.getHiResImageUri(), var2, false);
      zzb.zza(var1, 9, (Parcelable)var0.getFeaturedImageUri(), var2, false);
      zzb.zza(var1, 10, var0.zzvx());
      zzb.zza(var1, 11, var0.zzvz());
      zzb.zza(var1, 12, (String)var0.zzvA(), false);
      zzb.zzc(var1, 13, var0.zzvB());
      zzb.zzc(var1, 14, var0.getAchievementTotalCount());
      zzb.zzc(var1, 15, var0.getLeaderboardCount());
      zzb.zza(var1, 17, var0.isTurnBasedMultiplayerEnabled());
      zzb.zza(var1, 16, var0.isRealTimeMultiplayerEnabled());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 19, (String)var0.getHiResImageUrl(), false);
      zzb.zza(var1, 18, (String)var0.getIconImageUrl(), false);
      zzb.zza(var1, 21, var0.isMuted());
      zzb.zza(var1, 20, (String)var0.getFeaturedImageUrl(), false);
      zzb.zza(var1, 23, var0.areSnapshotsEnabled());
      zzb.zza(var1, 22, var0.zzvy());
      zzb.zza(var1, 25, var0.hasGamepadSupport());
      zzb.zza(var1, 24, (String)var0.getThemeColor(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzea(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgb(var1);
   }

   public GameEntity zzea(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      Uri var10 = null;
      Uri var11 = null;
      Uri var12 = null;
      boolean var13 = false;
      boolean var14 = false;
      String var15 = null;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      boolean var19 = false;
      boolean var20 = false;
      String var21 = null;
      String var22 = null;
      String var23 = null;
      boolean var24 = false;
      boolean var25 = false;
      boolean var26 = false;
      String var27 = null;
      boolean var28 = false;

      while(var1.dataPosition() < var2) {
         int var29 = zza.zzat(var1);
         switch(zza.zzca(var29)) {
         case 1:
            var4 = zza.zzp(var1, var29);
            break;
         case 2:
            var5 = zza.zzp(var1, var29);
            break;
         case 3:
            var6 = zza.zzp(var1, var29);
            break;
         case 4:
            var7 = zza.zzp(var1, var29);
            break;
         case 5:
            var8 = zza.zzp(var1, var29);
            break;
         case 6:
            var9 = zza.zzp(var1, var29);
            break;
         case 7:
            var10 = (Uri)zza.zza(var1, var29, Uri.CREATOR);
            break;
         case 8:
            var11 = (Uri)zza.zza(var1, var29, Uri.CREATOR);
            break;
         case 9:
            var12 = (Uri)zza.zza(var1, var29, Uri.CREATOR);
            break;
         case 10:
            var13 = zza.zzc(var1, var29);
            break;
         case 11:
            var14 = zza.zzc(var1, var29);
            break;
         case 12:
            var15 = zza.zzp(var1, var29);
            break;
         case 13:
            var16 = zza.zzg(var1, var29);
            break;
         case 14:
            var17 = zza.zzg(var1, var29);
            break;
         case 15:
            var18 = zza.zzg(var1, var29);
            break;
         case 16:
            var19 = zza.zzc(var1, var29);
            break;
         case 17:
            var20 = zza.zzc(var1, var29);
            break;
         case 18:
            var21 = zza.zzp(var1, var29);
            break;
         case 19:
            var22 = zza.zzp(var1, var29);
            break;
         case 20:
            var23 = zza.zzp(var1, var29);
            break;
         case 21:
            var24 = zza.zzc(var1, var29);
            break;
         case 22:
            var25 = zza.zzc(var1, var29);
            break;
         case 23:
            var26 = zza.zzc(var1, var29);
            break;
         case 24:
            var27 = zza.zzp(var1, var29);
            break;
         case 25:
            var28 = zza.zzc(var1, var29);
            break;
         case 1000:
            var3 = zza.zzg(var1, var29);
            break;
         default:
            zza.zzb(var1, var29);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GameEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
      }
   }

   public GameEntity[] zzgb(int var1) {
      return new GameEntity[var1];
   }
}

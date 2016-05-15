package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
   static void zza(AchievementEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getAchievementId(), false);
      zzb.zzc(var1, 2, var0.getType());
      zzb.zza(var1, 3, (String)var0.getName(), false);
      zzb.zza(var1, 4, (String)var0.getDescription(), false);
      zzb.zza(var1, 5, (Parcelable)var0.getUnlockedImageUri(), var2, false);
      zzb.zza(var1, 6, (String)var0.getUnlockedImageUrl(), false);
      zzb.zza(var1, 7, (Parcelable)var0.getRevealedImageUri(), var2, false);
      zzb.zza(var1, 8, (String)var0.getRevealedImageUrl(), false);
      zzb.zzc(var1, 9, var0.zzvK());
      zzb.zza(var1, 10, (String)var0.zzvL(), false);
      zzb.zza(var1, 11, (Parcelable)var0.getPlayer(), var2, false);
      zzb.zzc(var1, 12, var0.getState());
      zzb.zzc(var1, 13, var0.zzvM());
      zzb.zza(var1, 14, (String)var0.zzvN(), false);
      zzb.zza(var1, 15, var0.getLastUpdatedTimestamp());
      zzb.zza(var1, 16, var0.getXpValue());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzee(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgg(var1);
   }

   public AchievementEntity zzee(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      Uri var8 = null;
      String var9 = null;
      Uri var10 = null;
      String var11 = null;
      int var12 = 0;
      String var13 = null;
      PlayerEntity var14 = null;
      int var15 = 0;
      int var16 = 0;
      String var17 = null;
      long var18 = 0L;
      long var20 = 0L;

      while(var1.dataPosition() < var2) {
         int var22 = zza.zzat(var1);
         switch(zza.zzca(var22)) {
         case 1:
            var4 = zza.zzp(var1, var22);
            break;
         case 2:
            var5 = zza.zzg(var1, var22);
            break;
         case 3:
            var6 = zza.zzp(var1, var22);
            break;
         case 4:
            var7 = zza.zzp(var1, var22);
            break;
         case 5:
            var8 = (Uri)zza.zza(var1, var22, Uri.CREATOR);
            break;
         case 6:
            var9 = zza.zzp(var1, var22);
            break;
         case 7:
            var10 = (Uri)zza.zza(var1, var22, Uri.CREATOR);
            break;
         case 8:
            var11 = zza.zzp(var1, var22);
            break;
         case 9:
            var12 = zza.zzg(var1, var22);
            break;
         case 10:
            var13 = zza.zzp(var1, var22);
            break;
         case 11:
            var14 = (PlayerEntity)zza.zza(var1, var22, PlayerEntity.CREATOR);
            break;
         case 12:
            var15 = zza.zzg(var1, var22);
            break;
         case 13:
            var16 = zza.zzg(var1, var22);
            break;
         case 14:
            var17 = zza.zzp(var1, var22);
            break;
         case 15:
            var18 = zza.zzi(var1, var22);
            break;
         case 16:
            var20 = zza.zzi(var1, var22);
            break;
         case 1000:
            var3 = zza.zzg(var1, var22);
            break;
         default:
            zza.zzb(var1, var22);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AchievementEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var20);
      }
   }

   public AchievementEntity[] zzgg(int var1) {
      return new AchievementEntity[var1];
   }
}

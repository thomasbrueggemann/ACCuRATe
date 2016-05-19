package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
   static void zza(QuestEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getGame(), var2, false);
      zzb.zza(var1, 2, (String)var0.getQuestId(), false);
      zzb.zza(var1, 3, var0.getAcceptedTimestamp());
      zzb.zza(var1, 4, (Parcelable)var0.getBannerImageUri(), var2, false);
      zzb.zza(var1, 5, (String)var0.getBannerImageUrl(), false);
      zzb.zza(var1, 6, (String)var0.getDescription(), false);
      zzb.zza(var1, 7, var0.getEndTimestamp());
      zzb.zza(var1, 8, var0.getLastUpdatedTimestamp());
      zzb.zza(var1, 9, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zza(var1, 10, (String)var0.getIconImageUrl(), false);
      zzb.zza(var1, 12, (String)var0.getName(), false);
      zzb.zza(var1, 13, var0.zzxS());
      zzb.zza(var1, 14, var0.getStartTimestamp());
      zzb.zzc(var1, 15, var0.getState());
      zzb.zzc(var1, 17, var0.zzxR(), false);
      zzb.zzc(var1, 16, var0.getType());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzey(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgO(var1);
   }

   public QuestEntity zzey(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      GameEntity var4 = null;
      String var5 = null;
      long var6 = 0L;
      Uri var8 = null;
      String var9 = null;
      String var10 = null;
      long var11 = 0L;
      long var13 = 0L;
      Uri var15 = null;
      String var16 = null;
      String var17 = null;
      long var18 = 0L;
      long var20 = 0L;
      int var22 = 0;
      int var23 = 0;
      ArrayList var24 = null;

      while(var1.dataPosition() < var2) {
         int var25 = zza.zzat(var1);
         switch(zza.zzca(var25)) {
         case 1:
            var4 = (GameEntity)zza.zza(var1, var25, GameEntity.CREATOR);
            break;
         case 2:
            var5 = zza.zzp(var1, var25);
            break;
         case 3:
            var6 = zza.zzi(var1, var25);
            break;
         case 4:
            var8 = (Uri)zza.zza(var1, var25, Uri.CREATOR);
            break;
         case 5:
            var9 = zza.zzp(var1, var25);
            break;
         case 6:
            var10 = zza.zzp(var1, var25);
            break;
         case 7:
            var11 = zza.zzi(var1, var25);
            break;
         case 8:
            var13 = zza.zzi(var1, var25);
            break;
         case 9:
            var15 = (Uri)zza.zza(var1, var25, Uri.CREATOR);
            break;
         case 10:
            var16 = zza.zzp(var1, var25);
            break;
         case 12:
            var17 = zza.zzp(var1, var25);
            break;
         case 13:
            var18 = zza.zzi(var1, var25);
            break;
         case 14:
            var20 = zza.zzi(var1, var25);
            break;
         case 15:
            var22 = zza.zzg(var1, var25);
            break;
         case 16:
            var23 = zza.zzg(var1, var25);
            break;
         case 17:
            var24 = zza.zzc(var1, var25, MilestoneEntity.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var25);
            break;
         default:
            zza.zzb(var1, var25);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new QuestEntity(var3, var4, var5, var6, var8, var9, var10, var11, var13, var15, var16, var17, var18, var20, var22, var23, var24);
      }
   }

   public QuestEntity[] zzgO(int var1) {
      return new QuestEntity[var1];
   }
}

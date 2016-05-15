package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
   static void zza(ParticipantEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getParticipantId(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getDisplayName(), false);
      zzb.zza(var1, 3, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zza(var1, 4, (Parcelable)var0.getHiResImageUri(), var2, false);
      zzb.zzc(var1, 5, var0.getStatus());
      zzb.zza(var1, 6, (String)var0.zzwt(), false);
      zzb.zza(var1, 7, var0.isConnectedToRoom());
      zzb.zza(var1, 8, (Parcelable)var0.getPlayer(), var2, false);
      zzb.zzc(var1, 9, var0.getCapabilities());
      zzb.zza(var1, 10, (Parcelable)var0.getResult(), var2, false);
      zzb.zza(var1, 11, (String)var0.getIconImageUrl(), false);
      zzb.zza(var1, 12, (String)var0.getHiResImageUrl(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzes(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgI(var1);
   }

   public ParticipantEntity zzes(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      Uri var6 = null;
      Uri var7 = null;
      int var8 = 0;
      String var9 = null;
      boolean var10 = false;
      PlayerEntity var11 = null;
      int var12 = 0;
      ParticipantResult var13 = null;
      String var14 = null;
      String var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var4 = zza.zzp(var1, var16);
            break;
         case 2:
            var5 = zza.zzp(var1, var16);
            break;
         case 3:
            var6 = (Uri)zza.zza(var1, var16, Uri.CREATOR);
            break;
         case 4:
            var7 = (Uri)zza.zza(var1, var16, Uri.CREATOR);
            break;
         case 5:
            var8 = zza.zzg(var1, var16);
            break;
         case 6:
            var9 = zza.zzp(var1, var16);
            break;
         case 7:
            var10 = zza.zzc(var1, var16);
            break;
         case 8:
            var11 = (PlayerEntity)zza.zza(var1, var16, PlayerEntity.CREATOR);
            break;
         case 9:
            var12 = zza.zzg(var1, var16);
            break;
         case 10:
            var13 = (ParticipantResult)zza.zza(var1, var16, ParticipantResult.CREATOR);
            break;
         case 11:
            var14 = zza.zzp(var1, var16);
            break;
         case 12:
            var15 = zza.zzp(var1, var16);
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
         return new ParticipantEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   public ParticipantEntity[] zzgI(int var1) {
      return new ParticipantEntity[var1];
   }
}

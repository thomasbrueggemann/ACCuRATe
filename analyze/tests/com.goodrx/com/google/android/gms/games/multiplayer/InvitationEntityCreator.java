package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
   static void zza(InvitationEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getGame(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getInvitationId(), false);
      zzb.zza(var1, 3, var0.getCreationTimestamp());
      zzb.zzc(var1, 4, var0.getInvitationType());
      zzb.zza(var1, 5, (Parcelable)var0.getInviter(), var2, false);
      zzb.zzc(var1, 6, var0.getParticipants(), false);
      zzb.zzc(var1, 7, var0.getVariant());
      zzb.zzc(var1, 8, var0.getAvailableAutoMatchSlots());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzer(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgH(var1);
   }

   public InvitationEntity zzer(Parcel var1) {
      ArrayList var2 = null;
      int var3 = 0;
      int var4 = zza.zzau(var1);
      long var5 = 0L;
      int var7 = 0;
      ParticipantEntity var8 = null;
      int var9 = 0;
      String var10 = null;
      GameEntity var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var11 = (GameEntity)zza.zza(var1, var13, GameEntity.CREATOR);
            break;
         case 2:
            var10 = zza.zzp(var1, var13);
            break;
         case 3:
            var5 = zza.zzi(var1, var13);
            break;
         case 4:
            var9 = zza.zzg(var1, var13);
            break;
         case 5:
            var8 = (ParticipantEntity)zza.zza(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 6:
            var2 = zza.zzc(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 7:
            var7 = zza.zzg(var1, var13);
            break;
         case 8:
            var3 = zza.zzg(var1, var13);
            break;
         case 1000:
            var12 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new InvitationEntity(var12, var11, var10, var5, var9, var8, var2, var7, var3);
      }
   }

   public InvitationEntity[] zzgH(int var1) {
      return new InvitationEntity[var1];
   }
}

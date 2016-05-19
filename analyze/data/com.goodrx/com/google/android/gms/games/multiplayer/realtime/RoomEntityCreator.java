package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
   static void zza(RoomEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getRoomId(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getCreatorId(), false);
      zzb.zza(var1, 3, var0.getCreationTimestamp());
      zzb.zzc(var1, 4, var0.getStatus());
      zzb.zza(var1, 5, (String)var0.getDescription(), false);
      zzb.zzc(var1, 6, var0.getVariant());
      zzb.zza(var1, 7, (Bundle)var0.getAutoMatchCriteria(), false);
      zzb.zzc(var1, 8, var0.getParticipants(), false);
      zzb.zzc(var1, 9, var0.getAutoMatchWaitEstimateSeconds());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzev(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgL(var1);
   }

   public RoomEntity zzev(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = zza.zzau(var1);
      long var5 = 0L;
      Bundle var7 = null;
      int var8 = 0;
      String var9 = null;
      int var10 = 0;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = zza.zzat(var1);
         switch(zza.zzca(var14)) {
         case 1:
            var12 = zza.zzp(var1, var14);
            break;
         case 2:
            var11 = zza.zzp(var1, var14);
            break;
         case 3:
            var5 = zza.zzi(var1, var14);
            break;
         case 4:
            var10 = zza.zzg(var1, var14);
            break;
         case 5:
            var9 = zza.zzp(var1, var14);
            break;
         case 6:
            var8 = zza.zzg(var1, var14);
            break;
         case 7:
            var7 = zza.zzr(var1, var14);
            break;
         case 8:
            var3 = zza.zzc(var1, var14, ParticipantEntity.CREATOR);
            break;
         case 9:
            var2 = zza.zzg(var1, var14);
            break;
         case 1000:
            var13 = zza.zzg(var1, var14);
            break;
         default:
            zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new RoomEntity(var13, var12, var11, var5, var10, var9, var8, var7, var3, var2);
      }
   }

   public RoomEntity[] zzgL(int var1) {
      return new RoomEntity[var1];
   }
}

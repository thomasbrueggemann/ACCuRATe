package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.quest.MilestoneEntity;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
   static void zza(MilestoneEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getMilestoneId(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, var0.getCurrentProgress());
      zzb.zza(var1, 3, var0.getTargetProgress());
      zzb.zza(var1, 4, (byte[])var0.getCompletionRewardData(), false);
      zzb.zzc(var1, 5, var0.getState());
      zzb.zza(var1, 6, (String)var0.getEventId(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzex(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgN(var1);
   }

   public MilestoneEntity zzex(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      String var5 = null;
      int var6 = zza.zzau(var1);
      byte[] var7 = null;
      long var8 = var2;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var6) {
         int var12 = zza.zzat(var1);
         switch(zza.zzca(var12)) {
         case 1:
            var10 = zza.zzp(var1, var12);
            break;
         case 2:
            var8 = zza.zzi(var1, var12);
            break;
         case 3:
            var2 = zza.zzi(var1, var12);
            break;
         case 4:
            var7 = zza.zzs(var1, var12);
            break;
         case 5:
            var4 = zza.zzg(var1, var12);
            break;
         case 6:
            var5 = zza.zzp(var1, var12);
            break;
         case 1000:
            var11 = zza.zzg(var1, var12);
            break;
         default:
            zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new MilestoneEntity(var11, var10, var8, var2, var7, var4, var5);
      }
   }

   public MilestoneEntity[] zzgN(int var1) {
      return new MilestoneEntity[var1];
   }
}

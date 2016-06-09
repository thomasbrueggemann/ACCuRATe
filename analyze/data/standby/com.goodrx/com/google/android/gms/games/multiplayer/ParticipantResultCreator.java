package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
   static void zza(ParticipantResult var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getParticipantId(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzc(var1, 2, var0.getResult());
      zzb.zzc(var1, 3, var0.getPlacing());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzet(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgJ(var1);
   }

   public ParticipantResult zzet(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var4 = zza.zzp(var1, var7);
            break;
         case 2:
            var5 = zza.zzg(var1, var7);
            break;
         case 3:
            var2 = zza.zzg(var1, var7);
            break;
         case 1000:
            var6 = zza.zzg(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ParticipantResult(var6, var4, var5, var2);
      }
   }

   public ParticipantResult[] zzgJ(int var1) {
      return new ParticipantResult[var1];
   }
}

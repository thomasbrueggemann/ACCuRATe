package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
   static void zza(MostRecentGameInfoEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.zzxy(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.zzxz(), false);
      zzb.zza(var1, 3, var0.zzxA());
      zzb.zza(var1, 4, (Parcelable)var0.zzxB(), var2, false);
      zzb.zza(var1, 5, (Parcelable)var0.zzxC(), var2, false);
      zzb.zza(var1, 6, (Parcelable)var0.zzxD(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzep(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgE(var1);
   }

   public MostRecentGameInfoEntity zzep(Parcel var1) {
      Uri var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      Uri var7 = null;
      Uri var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var10 = zza.zzp(var1, var11);
            break;
         case 2:
            var9 = zza.zzp(var1, var11);
            break;
         case 3:
            var5 = zza.zzi(var1, var11);
            break;
         case 4:
            var8 = (Uri)zza.zza(var1, var11, Uri.CREATOR);
            break;
         case 5:
            var7 = (Uri)zza.zza(var1, var11, Uri.CREATOR);
            break;
         case 6:
            var2 = (Uri)zza.zza(var1, var11, Uri.CREATOR);
            break;
         case 1000:
            var4 = zza.zzg(var1, var11);
            break;
         default:
            zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new MostRecentGameInfoEntity(var4, var10, var9, var5, var8, var7, var2);
      }
   }

   public MostRecentGameInfoEntity[] zzgE(int var1) {
      return new MostRecentGameInfoEntity[var1];
   }
}

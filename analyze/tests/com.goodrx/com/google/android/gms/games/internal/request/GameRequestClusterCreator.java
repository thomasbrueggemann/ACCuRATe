package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
   static void zza(GameRequestCluster var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.zzxF(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeq(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgF(var1);
   }

   public GameRequestCluster zzeq(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = zza.zzc(var1, var5, GameRequestEntity.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GameRequestCluster(var3, var4);
      }
   }

   public GameRequestCluster[] zzgF(int var1) {
      return new GameRequestCluster[var1];
   }
}

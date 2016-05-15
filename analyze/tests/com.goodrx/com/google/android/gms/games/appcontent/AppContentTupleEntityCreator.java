package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
   static void zza(AppContentTupleEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getName(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getValue(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzek(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgm(var1);
   }

   public AppContentTupleEntity zzek(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzp(var1, var6);
            break;
         case 2:
            var2 = zza.zzp(var1, var6);
            break;
         case 1000:
            var4 = zza.zzg(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentTupleEntity(var4, var5, var2);
      }
   }

   public AppContentTupleEntity[] zzgm(int var1) {
      return new AppContentTupleEntity[var1];
   }
}

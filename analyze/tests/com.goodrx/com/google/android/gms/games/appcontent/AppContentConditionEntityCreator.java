package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
   static void zza(AppContentConditionEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.zzwf(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.zzwg(), false);
      zzb.zza(var1, 3, (String)var0.zzwh(), false);
      zzb.zza(var1, 4, (Bundle)var0.zzwi(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzei(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgk(var1);
   }

   public AppContentConditionEntity zzei(Parcel var1) {
      Bundle var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = zza.zzp(var1, var8);
            break;
         case 2:
            var6 = zza.zzp(var1, var8);
            break;
         case 3:
            var5 = zza.zzp(var1, var8);
            break;
         case 4:
            var2 = zza.zzr(var1, var8);
            break;
         case 1000:
            var4 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentConditionEntity(var4, var7, var6, var5, var2);
      }
   }

   public AppContentConditionEntity[] zzgk(int var1) {
      return new AppContentConditionEntity[var1];
   }
}

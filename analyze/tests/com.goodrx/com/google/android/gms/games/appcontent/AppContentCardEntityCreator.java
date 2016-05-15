package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
   static void zza(AppContentCardEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getActions(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzc(var1, 2, var0.zzwa(), false);
      zzb.zzc(var1, 3, var0.zzvP(), false);
      zzb.zza(var1, 4, (String)var0.zzvQ(), false);
      zzb.zzc(var1, 5, var0.zzwb());
      zzb.zza(var1, 6, (String)var0.getDescription(), false);
      zzb.zza(var1, 7, (Bundle)var0.getExtras(), false);
      zzb.zza(var1, 10, (String)var0.zzwc(), false);
      zzb.zza(var1, 11, (String)var0.getTitle(), false);
      zzb.zzc(var1, 12, var0.zzwd());
      zzb.zza(var1, 13, (String)var0.getType(), false);
      zzb.zza(var1, 14, (String)var0.getId(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeh(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgj(var1);
   }

   public AppContentCardEntity zzeh(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      ArrayList var4 = null;
      ArrayList var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      int var8 = 0;
      String var9 = null;
      Bundle var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      String var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var4 = zza.zzc(var1, var16, AppContentActionEntity.CREATOR);
            break;
         case 2:
            var5 = zza.zzc(var1, var16, AppContentAnnotationEntity.CREATOR);
            break;
         case 3:
            var6 = zza.zzc(var1, var16, AppContentConditionEntity.CREATOR);
            break;
         case 4:
            var7 = zza.zzp(var1, var16);
            break;
         case 5:
            var8 = zza.zzg(var1, var16);
            break;
         case 6:
            var9 = zza.zzp(var1, var16);
            break;
         case 7:
            var10 = zza.zzr(var1, var16);
            break;
         case 10:
            var11 = zza.zzp(var1, var16);
            break;
         case 11:
            var12 = zza.zzp(var1, var16);
            break;
         case 12:
            var13 = zza.zzg(var1, var16);
            break;
         case 13:
            var14 = zza.zzp(var1, var16);
            break;
         case 14:
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
         return new AppContentCardEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   public AppContentCardEntity[] zzgj(int var1) {
      return new AppContentCardEntity[var1];
   }
}

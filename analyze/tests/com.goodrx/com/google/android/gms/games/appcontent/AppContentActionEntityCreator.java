package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
   static void zza(AppContentActionEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.zzvP(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.zzvQ(), false);
      zzb.zza(var1, 3, (Bundle)var0.getExtras(), false);
      zzb.zza(var1, 6, (String)var0.getType(), false);
      zzb.zza(var1, 7, (String)var0.getId(), false);
      zzb.zza(var1, 8, (Parcelable)var0.zzvO(), var2, false);
      zzb.zza(var1, 9, (String)var0.zzvR(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzef(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgh(var1);
   }

   public AppContentActionEntity zzef(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      AppContentAnnotationEntity var5 = null;
      String var6 = null;
      String var7 = null;
      Bundle var8 = null;
      String var9 = null;
      ArrayList var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var10 = zza.zzc(var1, var11, AppContentConditionEntity.CREATOR);
            break;
         case 2:
            var9 = zza.zzp(var1, var11);
            break;
         case 3:
            var8 = zza.zzr(var1, var11);
            break;
         case 6:
            var7 = zza.zzp(var1, var11);
            break;
         case 7:
            var6 = zza.zzp(var1, var11);
            break;
         case 8:
            var5 = (AppContentAnnotationEntity)zza.zza(var1, var11, AppContentAnnotationEntity.CREATOR);
            break;
         case 9:
            var2 = zza.zzp(var1, var11);
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
         return new AppContentActionEntity(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public AppContentActionEntity[] zzgh(int var1) {
      return new AppContentActionEntity[var1];
   }
}

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
   static void zza(AppContentSectionEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getActions(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzc(var1, 3, var0.zzwk(), false);
      zzb.zza(var1, 4, (String)var0.zzvQ(), false);
      zzb.zza(var1, 5, (Bundle)var0.getExtras(), false);
      zzb.zza(var1, 6, (String)var0.zzwc(), false);
      zzb.zza(var1, 7, (String)var0.getTitle(), false);
      zzb.zza(var1, 8, (String)var0.getType(), false);
      zzb.zza(var1, 9, (String)var0.getId(), false);
      zzb.zza(var1, 10, (String)var0.zzwl(), false);
      zzb.zzc(var1, 14, var0.zzwa(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzej(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgl(var1);
   }

   public AppContentSectionEntity zzej(Parcel var1) {
      ArrayList var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      Bundle var10 = null;
      String var11 = null;
      ArrayList var12 = null;
      ArrayList var13 = null;

      while(var1.dataPosition() < var3) {
         int var14 = zza.zzat(var1);
         switch(zza.zzca(var14)) {
         case 1:
            var13 = zza.zzc(var1, var14, AppContentActionEntity.CREATOR);
            break;
         case 3:
            var12 = zza.zzc(var1, var14, AppContentCardEntity.CREATOR);
            break;
         case 4:
            var11 = zza.zzp(var1, var14);
            break;
         case 5:
            var10 = zza.zzr(var1, var14);
            break;
         case 6:
            var9 = zza.zzp(var1, var14);
            break;
         case 7:
            var8 = zza.zzp(var1, var14);
            break;
         case 8:
            var7 = zza.zzp(var1, var14);
            break;
         case 9:
            var6 = zza.zzp(var1, var14);
            break;
         case 10:
            var5 = zza.zzp(var1, var14);
            break;
         case 14:
            var2 = zza.zzc(var1, var14, AppContentAnnotationEntity.CREATOR);
            break;
         case 1000:
            var4 = zza.zzg(var1, var14);
            break;
         default:
            zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentSectionEntity(var4, var13, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public AppContentSectionEntity[] zzgl(int var1) {
      return new AppContentSectionEntity[var1];
   }
}

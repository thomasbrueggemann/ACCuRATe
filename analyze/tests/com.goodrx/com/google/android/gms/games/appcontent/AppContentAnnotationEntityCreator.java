package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
   static void zza(AppContentAnnotationEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getDescription(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (Parcelable)var0.zzvV(), var2, false);
      zzb.zza(var1, 3, (String)var0.getTitle(), false);
      zzb.zza(var1, 5, (String)var0.getId(), false);
      zzb.zza(var1, 6, (String)var0.zzvY(), false);
      zzb.zza(var1, 7, (String)var0.zzvT(), false);
      zzb.zzc(var1, 8, var0.zzvU());
      zzb.zzc(var1, 9, var0.zzvX());
      zzb.zza(var1, 10, (Bundle)var0.zzvW(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeg(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgi(var1);
   }

   public AppContentAnnotationEntity zzeg(Parcel var1) {
      int var2 = 0;
      Bundle var3 = null;
      int var4 = zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      Uri var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var11 = zza.zzp(var1, var13);
            break;
         case 2:
            var10 = (Uri)zza.zza(var1, var13, Uri.CREATOR);
            break;
         case 3:
            var9 = zza.zzp(var1, var13);
            break;
         case 5:
            var8 = zza.zzp(var1, var13);
            break;
         case 6:
            var7 = zza.zzp(var1, var13);
            break;
         case 7:
            var6 = zza.zzp(var1, var13);
            break;
         case 8:
            var5 = zza.zzg(var1, var13);
            break;
         case 9:
            var2 = zza.zzg(var1, var13);
            break;
         case 10:
            var3 = zza.zzr(var1, var13);
            break;
         case 1000:
            var12 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AppContentAnnotationEntity(var12, var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public AppContentAnnotationEntity[] zzgi(int var1) {
      return new AppContentAnnotationEntity[var1];
   }
}

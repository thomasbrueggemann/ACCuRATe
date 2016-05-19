package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;

public class zzb implements Creator<AdLauncherIntentInfoParcel> {
   static void zza(AdLauncherIntentInfoParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.intentAction, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.url, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.mimeType, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.packageName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzDK, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzDL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzDM, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.intent, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzf(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzv(var1);
   }

   public AdLauncherIntentInfoParcel zzf(Parcel var1) {
      Intent var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;

      while(var1.dataPosition() < var3) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 9:
            var2 = (Intent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, Intent.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AdLauncherIntentInfoParcel(var4, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public AdLauncherIntentInfoParcel[] zzv(int var1) {
      return new AdLauncherIntentInfoParcel[var1];
   }
}

package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<RewardedVideoAdRequestParcel> {
   static void zza(RewardedVideoAdRequestParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, (Parcelable)var0.zzHt, var2, false);
      zzb.zza(var1, 3, (String)var0.zzrj, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzM(var1);
   }

   public RewardedVideoAdRequestParcel[] zzM(int var1) {
      return new RewardedVideoAdRequestParcel[var1];
   }

   public RewardedVideoAdRequestParcel zzn(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;

      AdRequestParcel var5;
      String var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = zza.zzat(var1);
         AdRequestParcel var8;
         int var9;
         switch(zza.zzca(var6)) {
         case 1:
            int var11 = zza.zzg(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            AdRequestParcel var10 = (AdRequestParcel)zza.zza(var1, var6, AdRequestParcel.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = zza.zzp(var1, var6);
            var8 = var5;
            var9 = var4;
            break;
         default:
            zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new RewardedVideoAdRequestParcel(var4, var5, var2);
      }
   }
}

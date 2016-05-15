package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<InterstitialAdParameterParcel> {
   static void zza(InterstitialAdParameterParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, var0.zzql);
      zzb.zza(var1, 3, var0.zzqm);
      zzb.zza(var1, 4, (String)var0.zzqn, false);
      zzb.zza(var1, 5, var0.zzqo);
      zzb.zza(var1, 6, var0.zzqp);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zza(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzg(var1);
   }

   public InterstitialAdParameterParcel zza(Parcel var1) {
      boolean var2 = false;
      int var3 = zza.zzau(var1);
      String var4 = null;
      float var5 = 0.0F;
      boolean var6 = false;
      boolean var7 = false;
      int var8 = 0;

      while(var1.dataPosition() < var3) {
         int var9 = zza.zzat(var1);
         switch(zza.zzca(var9)) {
         case 1:
            var8 = zza.zzg(var1, var9);
            break;
         case 2:
            var7 = zza.zzc(var1, var9);
            break;
         case 3:
            var6 = zza.zzc(var1, var9);
            break;
         case 4:
            var4 = zza.zzp(var1, var9);
            break;
         case 5:
            var2 = zza.zzc(var1, var9);
            break;
         case 6:
            var5 = zza.zzl(var1, var9);
            break;
         default:
            zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new InterstitialAdParameterParcel(var8, var7, var6, var4, var2, var5);
      }
   }

   public InterstitialAdParameterParcel[] zzg(int var1) {
      return new InterstitialAdParameterParcel[var1];
   }
}

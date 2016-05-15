package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<NativeAdOptionsParcel> {
   static void zza(NativeAdOptionsParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, var0.zzyA);
      zzb.zzc(var1, 3, var0.zzyB);
      zzb.zza(var1, 4, var0.zzyC);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zze(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzp(var1);
   }

   public NativeAdOptionsParcel zze(Parcel var1) {
      boolean var2 = false;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      boolean var5 = false;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var6 = zza.zzg(var1, var7);
            break;
         case 2:
            var5 = zza.zzc(var1, var7);
            break;
         case 3:
            var4 = zza.zzg(var1, var7);
            break;
         case 4:
            var2 = zza.zzc(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new NativeAdOptionsParcel(var6, var5, var4, var2);
      }
   }

   public NativeAdOptionsParcel[] zzp(int var1) {
      return new NativeAdOptionsParcel[var1];
   }
}

package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<CapabilityParcel> {
   static void zza(CapabilityParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, var0.zzIn);
      zzb.zza(var1, 3, var0.zzIo);
      zzb.zza(var1, 4, var0.zzIp);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzI(var1);
   }

   public CapabilityParcel[] zzI(int var1) {
      return new CapabilityParcel[var1];
   }

   public CapabilityParcel zzk(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var4 = false;
      boolean var5 = false;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CapabilityParcel(var6, var5, var4, var2);
      }
   }
}

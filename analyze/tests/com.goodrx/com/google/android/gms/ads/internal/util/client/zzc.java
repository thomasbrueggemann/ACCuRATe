package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzc implements Creator<VersionInfoParcel> {
   static void zza(VersionInfoParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.afmaVersion, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzMZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzNa);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzNb);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzp(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzR(var1);
   }

   public VersionInfoParcel[] zzR(int var1) {
      return new VersionInfoParcel[var1];
   }

   public VersionInfoParcel zzp(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new VersionInfoParcel(var7, var4, var6, var5, var2);
      }
   }
}

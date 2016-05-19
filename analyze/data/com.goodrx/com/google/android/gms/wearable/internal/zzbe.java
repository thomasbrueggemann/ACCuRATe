package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.PackageStorageInfo;

public class zzbe implements Creator<PackageStorageInfo> {
   static void zza(PackageStorageInfo var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, (String)var0.packageName, false);
      zzb.zza(var1, 3, (String)var0.label, false);
      zzb.zza(var1, 4, var0.zzbta);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmh(var1);
   }

   public PackageStorageInfo zziD(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var4 = zza.zzg(var1, var8);
            break;
         case 2:
            var7 = zza.zzp(var1, var8);
            break;
         case 3:
            var2 = zza.zzp(var1, var8);
            break;
         case 4:
            var5 = zza.zzi(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PackageStorageInfo(var4, var7, var2, var5);
      }
   }

   public PackageStorageInfo[] zzmh(int var1) {
      return new PackageStorageInfo[var1];
   }
}

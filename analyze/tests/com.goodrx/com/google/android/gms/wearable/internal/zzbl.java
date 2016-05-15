package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.PackageStorageInfo;
import com.google.android.gms.wearable.internal.StorageInfoResponse;
import java.util.ArrayList;

public class zzbl implements Creator<StorageInfoResponse> {
   static void zza(StorageInfoResponse var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.statusCode);
      zzb.zza(var1, 3, var0.zzbta);
      zzb.zzc(var1, 4, var0.zzbtc, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziI(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmm(var1);
   }

   public StorageInfoResponse zziI(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      long var4 = 0L;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = zza.zzg(var1, var8);
            break;
         case 2:
            var2 = zza.zzg(var1, var8);
            break;
         case 3:
            var4 = zza.zzi(var1, var8);
            break;
         case 4:
            var6 = zza.zzc(var1, var8, PackageStorageInfo.CREATOR);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new StorageInfoResponse(var7, var2, var4, var6);
      }
   }

   public StorageInfoResponse[] zzmm(int var1) {
      return new StorageInfoResponse[var1];
   }
}

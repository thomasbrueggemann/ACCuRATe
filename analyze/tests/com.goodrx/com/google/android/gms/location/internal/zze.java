package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public class zze implements Creator<FusedLocationProviderResult> {
   static void zza(FusedLocationProviderResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeW(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhB(var1);
   }

   public FusedLocationProviderResult zzeW(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      Status var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = (Status)zza.zza(var1, var5, Status.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new FusedLocationProviderResult(var3, var4);
      }
   }

   public FusedLocationProviderResult[] zzhB(int var1) {
      return new FusedLocationProviderResult[var1];
   }
}

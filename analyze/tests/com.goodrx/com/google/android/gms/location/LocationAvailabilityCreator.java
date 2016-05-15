package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationAvailability;

public class LocationAvailabilityCreator implements Creator<LocationAvailability> {
   static void zza(LocationAvailability var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzaNU);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzaNV);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaNW);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaNX);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   public LocationAvailability createFromParcel(Parcel var1) {
      int var2 = 1;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      int var5 = 1000;
      long var6 = 0L;
      int var8 = var2;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new LocationAvailability(var4, var5, var8, var2, var6);
      }
   }

   public LocationAvailability[] newArray(int var1) {
      return new LocationAvailability[var1];
   }
}

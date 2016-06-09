package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;

public class LocationRequestCreator implements Creator<LocationRequest> {
   static void zza(LocationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mPriority);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzaNY);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaNZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaBr);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzaND);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzaOa);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzaOb);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzaOc);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   public LocationRequest createFromParcel(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      int var4 = 102;
      long var5 = 3600000L;
      long var7 = 600000L;
      boolean var9 = false;
      long var10 = Long.MAX_VALUE;
      int var12 = Integer.MAX_VALUE;
      float var13 = 0.0F;
      long var14 = 0L;

      while(var1.dataPosition() < var2) {
         int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var16)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var16);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var16);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var16);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var16);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var16);
            break;
         case 6:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var16);
            break;
         case 7:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 8:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var16);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var16);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new LocationRequest(var3, var4, var5, var7, var9, var10, var12, var13, var14);
      }
   }

   public LocationRequest[] newArray(int var1) {
      return new LocationRequest[var1];
   }
}

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import java.util.ArrayList;

public class zzf implements Creator<LocationSettingsRequest> {
   static void zza(LocationSettingsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzuZ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzyK());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzyL());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhv(var1);
   }

   public LocationSettingsRequest zzeS(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var4 = null;
      boolean var5 = false;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, LocationRequest.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 1000:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new LocationSettingsRequest(var6, var4, var5, var2);
      }
   }

   public LocationSettingsRequest[] zzhv(int var1) {
      return new LocationSettingsRequest[var1];
   }
}

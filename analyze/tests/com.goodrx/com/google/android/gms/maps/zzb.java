package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb implements Creator<StreetViewPanoramaOptions> {
   static void zza(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getStreetViewPanoramaCamera(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getPanoramaId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.getPosition(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Integer)var0.getRadius(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (byte)var0.zzAa());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (byte)var0.zzzP());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (byte)var0.zzAb());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (byte)var0.zzAc());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (byte)var0.zzzL());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzii(var1);
   }

   public StreetViewPanoramaOptions zzfu(Parcel var1) {
      Integer var2 = null;
      byte var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      byte var5 = 0;
      byte var6 = 0;
      byte var7 = 0;
      byte var8 = 0;
      LatLng var9 = null;
      String var10 = null;
      StreetViewPanoramaCamera var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 2:
            var11 = (StreetViewPanoramaCamera)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, StreetViewPanoramaCamera.CREATOR);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 4:
            var9 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, LatLng.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzh(var1, var13);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var13);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var13);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var13);
            break;
         case 9:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var13);
            break;
         case 10:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new StreetViewPanoramaOptions(var12, var11, var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   public StreetViewPanoramaOptions[] zzii(int var1) {
      return new StreetViewPanoramaOptions[var1];
   }
}

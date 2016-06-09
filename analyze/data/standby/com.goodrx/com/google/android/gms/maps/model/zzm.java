package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class zzm implements Creator<StreetViewPanoramaOrientation> {
   static void zza(StreetViewPanoramaOrientation var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfH(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziv(var1);
   }

   public StreetViewPanoramaOrientation zzfH(Parcel var1) {
      float var2 = 0.0F;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      float var5 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaOrientation(var4, var5, var2);
      }
   }

   public StreetViewPanoramaOrientation[] zziv(int var1) {
      return new StreetViewPanoramaOrientation[var1];
   }
}

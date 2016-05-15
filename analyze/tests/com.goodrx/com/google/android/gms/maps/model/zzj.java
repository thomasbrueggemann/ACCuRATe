package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzj implements Creator<StreetViewPanoramaCamera> {
   static void zza(StreetViewPanoramaCamera var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zoom);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzis(var1);
   }

   public StreetViewPanoramaCamera zzfE(Parcel var1) {
      float var2 = 0.0F;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      float var4 = 0.0F;
      int var5 = 0;
      float var6 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var7);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var7);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaCamera(var5, var4, var6, var2);
      }
   }

   public StreetViewPanoramaCamera[] zzis(int var1) {
      return new StreetViewPanoramaCamera[var1];
   }
}

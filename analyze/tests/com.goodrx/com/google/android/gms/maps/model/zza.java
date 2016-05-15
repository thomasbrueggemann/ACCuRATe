package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class zza implements Creator<CameraPosition> {
   static void zza(CameraPosition var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.target, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zoom);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfv(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzij(var1);
   }

   public CameraPosition zzfv(Parcel var1) {
      float var2 = 0.0F;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      LatLng var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var5 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, LatLng.CREATOR);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var8);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var8);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CameraPosition(var4, var5, var7, var6, var2);
      }
   }

   public CameraPosition[] zzij(int var1) {
      return new CameraPosition[var1];
   }
}

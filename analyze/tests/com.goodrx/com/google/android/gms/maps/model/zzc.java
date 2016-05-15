package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class zzc implements Creator<GroundOverlayOptions> {
   static void zza(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzAj(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getLocation(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.getHeight());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.getBounds(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.getBearing());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.getTransparency());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.getAnchorU());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, var0.getAnchorV());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, var0.isClickable());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfx(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzil(var1);
   }

   public GroundOverlayOptions zzfx(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      IBinder var4 = null;
      LatLng var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;
      LatLngBounds var8 = null;
      float var9 = 0.0F;
      float var10 = 0.0F;
      boolean var11 = false;
      float var12 = 0.0F;
      float var13 = 0.0F;
      float var14 = 0.0F;
      boolean var15 = false;

      while(var1.dataPosition() < var2) {
         int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var16)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var16);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var16);
            break;
         case 3:
            var5 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var16, LatLng.CREATOR);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 6:
            var8 = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var16, LatLngBounds.CREATOR);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var16);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var16);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var16);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GroundOverlayOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   public GroundOverlayOptions[] zzil(int var1) {
      return new GroundOverlayOptions[var1];
   }
}

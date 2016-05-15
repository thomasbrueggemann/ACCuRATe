package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class zzb implements Creator<CircleOptions> {
   static void zza(CircleOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getCenter(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.getRadius());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.getStrokeWidth());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getStrokeColor());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getFillColor());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfw(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzik(var1);
   }

   public CircleOptions zzfw(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      LatLng var5 = null;
      double var6 = 0.0D;
      int var8 = 0;
      int var9 = 0;
      float var10 = 0.0F;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var5 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, LatLng.CREATOR);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var12);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var12);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var12);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CircleOptions(var11, var5, var6, var10, var9, var8, var2, var3);
      }
   }

   public CircleOptions[] zzik(int var1) {
      return new CircleOptions[var1];
   }
}

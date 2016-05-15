package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class zzp implements Creator<VisibleRegion> {
   static void zza(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.nearLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.nearRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.farLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.farRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.latLngBounds, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfK(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziy(var1);
   }

   public VisibleRegion zzfK(Parcel var1) {
      LatLngBounds var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      LatLng var5 = null;
      LatLng var6 = null;
      LatLng var7 = null;
      LatLng var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var8 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, LatLng.CREATOR);
            break;
         case 3:
            var7 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, LatLng.CREATOR);
            break;
         case 4:
            var6 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, LatLng.CREATOR);
            break;
         case 5:
            var5 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, LatLng.CREATOR);
            break;
         case 6:
            var2 = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, LatLngBounds.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new VisibleRegion(var4, var8, var7, var6, var5, var2);
      }
   }

   public VisibleRegion[] zziy(int var1) {
      return new VisibleRegion[var1];
   }
}

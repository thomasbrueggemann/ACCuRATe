package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

public class zzi implements Creator<PolylineOptions> {
   static void zza(PolylineOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getPoints(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getColor());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.isGeodesic());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.isClickable());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzir(var1);
   }

   public PolylineOptions zzfD(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      boolean var6 = false;
      boolean var7 = false;
      int var8 = 0;
      float var9 = 0.0F;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11, LatLng.CREATOR);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var11);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PolylineOptions(var10, var5, var9, var8, var2, var7, var6, var3);
      }
   }

   public PolylineOptions[] zzir(int var1) {
      return new PolylineOptions[var1];
   }
}

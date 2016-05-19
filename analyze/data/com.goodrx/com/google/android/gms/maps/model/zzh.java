package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

public class zzh implements Creator<PolygonOptions> {
   static void zza(PolygonOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getPoints(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzd(var1, 3, var0.zzAl(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.getStrokeWidth());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getStrokeColor());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getFillColor());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.isGeodesic());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.isClickable());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziq(var1);
   }

   public PolygonOptions zzfC(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      ArrayList var6 = new ArrayList();
      boolean var7 = false;
      boolean var8 = false;
      int var9 = 0;
      int var10 = 0;
      float var11 = 0.0F;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13, LatLng.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, var6, this.getClass().getClassLoader());
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var13);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var13);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 9:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 10:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PolygonOptions(var12, var5, var6, var11, var10, var9, var2, var8, var7, var3);
      }
   }

   public PolygonOptions[] zziq(int var1) {
      return new PolygonOptions[var1];
   }
}

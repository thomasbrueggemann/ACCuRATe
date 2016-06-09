package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class zzf implements Creator<MarkerOptions> {
   static void zza(MarkerOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getPosition(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getTitle(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getSnippet(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzAk(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.getAnchorU());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.getAnchorV());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.isDraggable());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.isFlat());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.getRotation());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, var0.getInfoWindowAnchorU());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, var0.getInfoWindowAnchorV());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, var0.getAlpha());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzio(var1);
   }

   public MarkerOptions zzfA(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      LatLng var4 = null;
      String var5 = null;
      String var6 = null;
      IBinder var7 = null;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      float var13 = 0.0F;
      float var14 = 0.5F;
      float var15 = 0.0F;
      float var16 = 1.0F;

      while(var1.dataPosition() < var2) {
         int var17 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var17)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 2:
            var4 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, LatLng.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var17);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var17);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var17);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var17);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         case 14:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var17);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new MarkerOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   public MarkerOptions[] zzio(int var1) {
      return new MarkerOptions[var1];
   }
}

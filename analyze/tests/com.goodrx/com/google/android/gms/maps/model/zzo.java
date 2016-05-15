package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class zzo implements Creator<TileOverlayOptions> {
   static void zza(TileOverlayOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzAm(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.getFadeIn());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfJ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzix(var1);
   }

   public TileOverlayOptions zzfJ(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      IBinder var4 = null;
      float var5 = 0.0F;
      boolean var6 = true;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var8);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new TileOverlayOptions(var7, var4, var2, var5, var6);
      }
   }

   public TileOverlayOptions[] zzix(int var1) {
      return new TileOverlayOptions[var1];
   }
}

package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class zzk implements Creator<StreetViewPanoramaLink> {
   static void zza(StreetViewPanoramaLink var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.panoId, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzit(var1);
   }

   public StreetViewPanoramaLink zzfF(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      float var5 = 0.0F;

      while(var1.dataPosition() < var2) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new StreetViewPanoramaLink(var3, var4, var5);
      }
   }

   public StreetViewPanoramaLink[] zzit(int var1) {
      return new StreetViewPanoramaLink[var1];
   }
}

package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.NearbyAlertFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;

public class zze implements Creator<NearbyAlertRequest> {
   static void zza(NearbyAlertRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzyV());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzyY());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzyZ(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzza(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzzb());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzzc());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.getPriority());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhN(var1);
   }

   public NearbyAlertRequest zzfd(Parcel var1) {
      NearbyAlertFilter var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = -1;
      int var6 = 0;
      boolean var7 = false;
      PlaceFilter var8 = null;
      int var9 = 0;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 3:
            var8 = (PlaceFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, PlaceFilter.CREATOR);
            break;
         case 4:
            var2 = (NearbyAlertFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, NearbyAlertFilter.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 1000:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new NearbyAlertRequest(var10, var9, var5, var8, var2, var7, var6, var3);
      }
   }

   public NearbyAlertRequest[] zzhN(int var1) {
      return new NearbyAlertRequest[var1];
   }
}

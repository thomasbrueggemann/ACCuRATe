package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceRequest;

public class zzk implements Creator<PlaceRequest> {
   static void zza(PlaceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzyZ(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.getInterval());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getPriority());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.getExpirationTime());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfi(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhT(var1);
   }

   public PlaceRequest zzfi(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      PlaceFilter var4 = null;
      long var5 = PlaceRequest.zzaPJ;
      int var7 = 102;
      long var8 = Long.MAX_VALUE;

      while(var1.dataPosition() < var2) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 2:
            var4 = (PlaceFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, PlaceFilter.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new PlaceRequest(var3, var4, var5, var7, var8);
      }
   }

   public PlaceRequest[] zzhT(int var1) {
      return new PlaceRequest[var1];
   }
}

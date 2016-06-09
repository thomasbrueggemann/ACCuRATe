package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.PlaceLikelihoodEntity;

public class zzm implements Creator<PlaceLikelihoodEntity> {
   static void zza(PlaceLikelihoodEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.zzaQM, var2, false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zza(var1, 2, var0.zzaQN);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfm(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhZ(var1);
   }

   public PlaceLikelihoodEntity zzfm(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      PlaceImpl var4 = null;

      float var5;
      float var7;
      for(var5 = 0.0F; var1.dataPosition() < var2; var5 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         PlaceImpl var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            PlaceImpl var12 = (PlaceImpl)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, PlaceImpl.CREATOR);
            var9 = var3;
            var7 = var5;
            var8 = var12;
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var6);
            var8 = var4;
            var9 = var3;
            break;
         case 1000:
            int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var4;
            var9 = var10;
            var7 = var5;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var5;
            var8 = var4;
            var9 = var3;
         }

         var3 = var9;
         var4 = var8;
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new PlaceLikelihoodEntity(var3, var4, var5);
      }
   }

   public PlaceLikelihoodEntity[] zzhZ(int var1) {
      return new PlaceLikelihoodEntity[var1];
   }
}
